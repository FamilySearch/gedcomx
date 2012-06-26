/**
 * Copyright 2011-2012 Intellectual Reserve, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.gedcomx.rt.json;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.SerializerProvider;
import org.codehaus.jackson.map.ser.BeanSerializer;
import org.gedcomx.rt.GedcomNamespaceManager;
import org.gedcomx.rt.SupportsExtensionAttributes;
import org.gedcomx.rt.SupportsExtensionElements;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Custom JSON serializer for @XmlAnyElement fields/properties
 *
 * @author Ryan Heaton
 */
public class ExtensibleObjectSerializer extends BeanSerializer {

  public ExtensibleObjectSerializer(BeanSerializer src) {
    super(src);
  }

  @Override
  protected void serializeFields(Object bean, JsonGenerator jgen, SerializerProvider provider) throws IOException, JsonGenerationException {
    super.serializeFields(bean, jgen, provider);

    if (bean instanceof SupportsExtensionAttributes) {
      serializeExtensionAttributes((SupportsExtensionAttributes) bean, jgen, provider);
    }

    if (bean instanceof SupportsExtensionElements) {
      serializeExtensionElements((SupportsExtensionElements) bean, jgen, provider);
    }
  }

  @Override
  protected void serializeFieldsFiltered(Object bean, JsonGenerator jgen, SerializerProvider provider) throws IOException, JsonGenerationException {
    super.serializeFieldsFiltered(bean, jgen, provider);

    if (bean instanceof SupportsExtensionAttributes) {
      serializeExtensionAttributes((SupportsExtensionAttributes) bean, jgen, provider);
    }

    if (bean instanceof SupportsExtensionElements) {
      serializeExtensionElements((SupportsExtensionElements) bean, jgen, provider);
    }
  }

  private void serializeExtensionAttributes(SupportsExtensionAttributes value, JsonGenerator jgen, SerializerProvider provider) throws IOException, JsonProcessingException {
    Map<QName, String> extensionAttributes = value.getExtensionAttributes();
    if (extensionAttributes != null) {
      for (Map.Entry<QName, String> attr : extensionAttributes.entrySet()) {
        jgen.writeStringField(attr.getKey().getNamespaceURI() + attr.getKey().getLocalPart(), attr.getValue());
      }
    }
  }

  public void serializeExtensionElements(SupportsExtensionElements value, JsonGenerator jgen, SerializerProvider provider) throws IOException, JsonProcessingException {
    List<Object> extensionElements = value.getExtensionElements();
    if (extensionElements != null) {
      Map<String, List<Object>> extensionProperties = new HashMap<String, List<Object>>();
      for (Object element : extensionElements) {
        if (element != null) {
          String name;
          if (element instanceof Element) {
            Element el = (Element) element;
            name = GedcomNamespaceManager.nameFromQName(el.getNamespaceURI(), el.getLocalName());
          }
          else if (element instanceof JAXBElement) {
            name = GedcomNamespaceManager.getJsonNameForWrapperName(((JAXBElement) element).getName());
            if (name == null) {
              name = GedcomNamespaceManager.nameFromQName(((JAXBElement) element).getName().getNamespaceURI(), ((JAXBElement) element).getName().getLocalPart());
            }
            element = ((JAXBElement) element).getValue();
          }
          else {
            name = GedcomNamespaceManager.getJsonName(element.getClass());
            if (name == null) {
              throw new JsonMappingException("Unable to serialize custom element " + value +
                                               " because it's not a JAXBElement, DOM element, nor is it annotated with either @JsonElementWrapper or @XmlRootElement.");
            }
          }

          List<Object> propList = extensionProperties.get(name);
          if (propList == null) {
            propList = new ArrayList<Object>();
            extensionProperties.put(name, propList);
          }

          propList.add(element);
        }
      }

      for (Map.Entry<String, List<Object>> prop : extensionProperties.entrySet()) {
        if (prop.getValue().get(0) instanceof HasJsonKey) {
          //we're serialize out this list as a keyed map.
          jgen.writeFieldName(prop.getKey());
          KeyedListSerializer.serializeGeneric(prop.getValue(), jgen, provider);
        }
        else {
          jgen.writeArrayFieldStart(prop.getKey());
          for (Object element : prop.getValue()) {
            if (element instanceof Element) {
              serializeElement((Element) element, jgen);
            }
            else {
              provider.findTypedValueSerializer(element.getClass(), true, null).serialize(element, jgen, provider);
            }
          }
          jgen.writeEndArray();
        }
      }
    }
  }

  private void serializeElement(Element element, JsonGenerator jgen) throws IOException {
    boolean startObjectWritten = false;
    boolean writeValue = false;
    StringBuilder value = new StringBuilder();
    for (Node child = element.getFirstChild(); child != null; child = child.getNextSibling()) {
      switch (child.getNodeType()) {
        case Node.ATTRIBUTE_NODE:
          if (!startObjectWritten) {
            jgen.writeStartObject();
            startObjectWritten = true;
          }
          jgen.writeStringField(child.getLocalName(), child.getNodeValue());
          break;
        case Node.TEXT_NODE:
        case Node.CDATA_SECTION_NODE:
          writeValue = true;
          value.append(child.getNodeValue());
          break;
        case Node.ELEMENT_NODE:
          if (!startObjectWritten) {
            jgen.writeStartObject();
            startObjectWritten = true;
          }
          jgen.writeFieldName(child.getNodeName());
          serializeElement((Element)child, jgen);
          break;
      }
    }
    if (startObjectWritten) {
      if (writeValue) {
        jgen.writeStringField("value", value.toString());
      }
      jgen.writeEndObject();
    }
    else if (writeValue) {
      jgen.writeString(value.toString());
    }
    else {
      //empty object.
      jgen.writeStartObject();
      jgen.writeEndObject();
    }
  }
}

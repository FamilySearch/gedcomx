/**
 * Copyright 2011 Intellectual Reserve, Inc.
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
package org.gedcomx.rt;

import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.SerializerProvider;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import javax.xml.namespace.QName;
import java.io.IOException;
import java.util.List;

/**
 * Custom JSON serializer for @XmlAnyElement fields/properties
 *
 * @author Ryan Heaton
 */
public class AnyElementSerializer extends JsonSerializer<List> {

  @Override
  public void serialize(List value, JsonGenerator jgen, SerializerProvider provider) throws IOException, JsonProcessingException {
    if (value == null) {
      jgen.writeNull();
    }
    else {
      jgen.writeStartArray();
      try {
        for (Object element : value) {
          if (element == null) {
            jgen.writeNull();
          }
          else if (element instanceof Element) {
            Element el = (Element) element;
            serializeElement(el, jgen, new QName(el.getNamespaceURI(), el.getLocalName()));
          }
          else {
            provider.findTypedValueSerializer(element.getClass(), true, null).serialize(element, jgen, provider);
          }
        }
      }
      finally {
        jgen.writeEndArray();
      }
    }
  }

  private void serializeElement(Element element, JsonGenerator jgen, QName typeName) throws IOException {
    boolean startObjectWritten = false;
    if (typeName != null) {
      jgen.writeStartObject();
      startObjectWritten = true;
      jgen.writeStringField("@type", typeName.toString());
    }
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
          serializeElement((Element)child, jgen, null);
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

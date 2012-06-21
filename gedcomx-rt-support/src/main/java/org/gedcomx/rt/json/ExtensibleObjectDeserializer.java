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

import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.JsonToken;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.deser.BeanDeserializer;
import org.gedcomx.rt.SupportsExtensionAttributes;
import org.gedcomx.rt.SupportsExtensionElements;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Custom JSON serializer for @XmlAnyElement fields/properties
 *
 * @author Ryan Heaton
 */
public class ExtensibleObjectDeserializer extends BeanDeserializer {

  public ExtensibleObjectDeserializer(BeanDeserializer src) {
    super(src);
  }

  @Override
  protected void handleUnknownProperty(JsonParser jp, DeserializationContext ctxt, Object beanOrClass, String propName) throws IOException, JsonProcessingException {
    if (beanOrClass instanceof SupportsExtensionElements) {
      SupportsExtensionElements target = (SupportsExtensionElements) beanOrClass;
      //first check if it's a known json type
      Class<?> type = GedcomNamespaceManager.getKnownJsonType(propName);
      if (type != null) {
        //it's a known json type.
        if (HasUniqueJsonKey.class.isAssignableFrom(type)) {
          for (Object ext : readKeyedMapOf(type, jp, ctxt)) {
            target.addExtensionElement(ext);
          }
        }
        else {
          //otherwise just deserialize as a list and go.
          for (Object ext : readArrayOf(type, jp, ctxt)) {
            target.addExtensionElement(ext);
          }
        }
        return;
      }
      else {
        QName wrapper = getWrapperName(propName);
        type = GedcomNamespaceManager.getWrappedTypeForJsonName(propName);
        if (type != null) {
          List<?> objects = readArrayOf(type, jp, ctxt);
          for (Object ext : objects) {
            target.addExtensionElement(new JAXBElement(wrapper, type, ext));
          }
          return;
        }
      }
    }

    if (beanOrClass instanceof SupportsExtensionAttributes && jp.getCurrentToken().isScalarValue()) {
      ((SupportsExtensionAttributes) beanOrClass).addExtensionAttribute(getWrapperName(propName), jp.getText());
      return;
    }

    super.handleUnknownProperty(jp, ctxt, beanOrClass, propName);
  }

  private QName getWrapperName(String propName) {
    QName qname = GedcomNamespaceManager.findWrapperNameForJsonName(propName);

    if (qname == null && propName.indexOf(':') >= 0) {
      //if the propname has a ':', we'll treat it as a qname, because all qnames I know have a ':' in them.
      List<String> knownNS = new ArrayList<String>(GedcomNamespaceManager.getKnownPrefixes().keySet());
      knownNS.add(XMLConstants.XML_NS_URI + "#");
      for (String ns : knownNS) {
        if (propName.startsWith(ns)) {
          String nsURI = propName.substring(0, ns.length());
          String localPart = propName.substring(ns.length());
          if (!"".equals(localPart)) {
            qname = new QName(nsURI, localPart);
          }
          break;
        }
      }

      if (qname == null && propName.indexOf('#') > 0) {
        //well, it wasn't a known namespace; let's try separating ns from local part with a #
        int hashIndex = propName.indexOf('#');
        String nsURI = propName.substring(0, hashIndex);
        String localPart = propName.substring(hashIndex + 1);
        if (!"".equals(localPart)) {
          qname = new QName(nsURI, localPart);
        }
      }

      if (qname == null && propName.lastIndexOf('/') > 0) {
        //still haven't found it; let's try separating ns from local part with the last '/'
        int hashIndex = propName.lastIndexOf('/');
        String nsURI = propName.substring(0, hashIndex);
        String localPart = propName.substring(hashIndex + 1);
        if (!"".equals(localPart)) {
          qname = new QName(nsURI, localPart);
        }
      }
    }

    if (qname == null) {
      qname = new QName("", propName);
    }

    return qname;
  }

  private List<?> readArrayOf(Class<?> type, JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
    ArrayList<Object> objects = new ArrayList<Object>();

    if (jp.getCurrentToken() == JsonToken.START_ARRAY) {
      jp.nextToken();
      while (jp.getCurrentToken() != JsonToken.END_ARRAY) {
        objects.add(jp.readValueAs(type));
        jp.nextToken();
      }
    }
    else {
      objects.add(jp.readValueAs(type));
    }

    return objects;
  }

  private List<?> readKeyedMapOf(Class<?> type, JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
    if (jp.getCurrentToken() == JsonToken.START_OBJECT) {
      return KeyedListDeserializer.deserializeGeneric(jp, ctxt, type);
    }
    else {
      throw new JsonMappingException("Unable to parse keyed map of " + type.getName() + ": expect start object, but got: " + jp.getCurrentToken().name());
    }
  }

}

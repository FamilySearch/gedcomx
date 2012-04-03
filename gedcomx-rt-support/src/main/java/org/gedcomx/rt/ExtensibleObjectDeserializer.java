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

import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.JsonToken;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.deser.BeanDeserializer;
import org.codehaus.jackson.map.jsontype.impl.AsPropertyTypeDeserializer;
import org.codehaus.jackson.map.type.SimpleType;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlRootElement;
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

  private final XmlTypeIdResolver xmlTypeIdResolver;
  private final AsPropertyTypeDeserializer typeDeserializer;

  public ExtensibleObjectDeserializer(BeanDeserializer src) {
    super(src);
    this.xmlTypeIdResolver = new XmlTypeIdResolver();
    this.typeDeserializer = new AsPropertyTypeDeserializer(SimpleType.construct(Object.class), this.xmlTypeIdResolver, null, XmlTypeIdResolver.TYPE_PROPERTY_NAME);
  }

  @Override
  protected void handleUnknownProperty(JsonParser jp, DeserializationContext ctxt, Object beanOrClass, String propName) throws IOException, JsonProcessingException {
    if (XmlTypeIdResolver.TYPE_PROPERTY_NAME.equals(propName)) {
      return;
    }
    
    QName qname = null;
    if (propName.indexOf(':') >= 0) {
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
      qname = GedcomNamespaceManager.findQNameFromJsonWrapperName(propName);
    }

    if (qname == null) {
      qname = new QName("", propName);
    }

    if (beanOrClass instanceof SupportsExtensionAttributes && jp.getCurrentToken().isScalarValue()) {
      ((SupportsExtensionAttributes) beanOrClass).addExtensionAttribute(qname, jp.getText());
    }
    else if (beanOrClass instanceof SupportsExtensionElements) {
      if (jp.getCurrentToken() == JsonToken.START_ARRAY) {
        jp.nextToken();
        while (jp.getCurrentToken() != JsonToken.END_ARRAY) {
          Object element = this.typeDeserializer.deserializeTypedFromAny(jp, ctxt);
          if (element != null && !element.getClass().isAnnotationPresent(XmlRootElement.class)) {
            element = new JAXBElement(qname, element.getClass(), element);
          }
          ((SupportsExtensionElements) beanOrClass).addExtensionElement(element);
          jp.nextToken();
        }
      }
      else {
        Object element = this.typeDeserializer.deserializeTypedFromAny(jp, ctxt);
        if (element != null && !element.getClass().isAnnotationPresent(XmlRootElement.class)) {
          element = new JAXBElement(qname, element.getClass(), element);
        }
        ((SupportsExtensionElements) beanOrClass).addExtensionElement(element);
      }
    }
    else {
      super.handleUnknownProperty(jp, ctxt, beanOrClass, propName);
    }
  }

}

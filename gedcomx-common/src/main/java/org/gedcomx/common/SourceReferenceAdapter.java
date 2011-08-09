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
package org.gedcomx.common;

import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.adapters.XmlAdapter;
import javax.xml.namespace.QName;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Adapter for a source reference to a more generic resource reference.
 *
 * @author Ryan Heaton
 */
@XmlTransient
public class SourceReferenceAdapter extends XmlAdapter<ResourceReference, SourceReference> {

  private static final QName ID_ATTRIBUTE_NAME = new QName("http://www.w3.org/1999/02/22-rdf-syntax-ns#", "ID");
  private static final QName DATATYPE_ATTRIBUTE_NAME = new QName("http://www.w3.org/1999/02/22-rdf-syntax-ns#", "datatype");

  @Override
  public ResourceReference marshal(SourceReference sourceReference) throws Exception {
    if (sourceReference == null) {
      return null;
    }

    ResourceReference resourceReference = new ResourceReference();
    resourceReference.setHref(sourceReference.getHref());
    HashMap<QName, String> otherAttributes = new HashMap<QName, String>();
    ArrayList<Object> otherElements = new ArrayList<Object>();
    if (sourceReference.getId() != null) {
      //we'll use rdf:ID to for the id of the source reference.
      otherAttributes.put(ID_ATTRIBUTE_NAME, sourceReference.getId());
    }
    if (sourceReference.getType() != null) {
      //use rdf:datatype to identify the type.
      QName type = sourceReference.getType();
      String typeUri = String.format("%s#%s", type.getNamespaceURI(), type.getLocalPart()); //todo: verify the QName to URI conversion (see issue #57)
      otherAttributes.put(DATATYPE_ATTRIBUTE_NAME, typeUri);
    }
    if (sourceReference.getQualifiers() != null) {
      for (SourceQualifier qualifier : sourceReference.getQualifiers()) {
        otherElements.add(qualifier);
      }
    }
    if (sourceReference.getExtension() != null && sourceReference.getExtension().getElements() != null) {
      for (Object el : sourceReference.getExtension().getElements()) {
        otherElements.add(el);
      }
    }
    if (!otherAttributes.isEmpty()) {
      resourceReference.setOtherAttributes(otherAttributes);
    }
    if (!otherElements.isEmpty()) {
      resourceReference.setOtherElements(otherElements);
    }
    return resourceReference;
  }

  @Override
  public SourceReference unmarshal(ResourceReference resourceReference) throws Exception {
    if (resourceReference == null) {
      return null;
    }
    
    SourceReference sourceReference = new SourceReference();
    sourceReference.setHref(resourceReference.getHref());
    if (resourceReference.getOtherAttributes() != null) {
      for (Map.Entry<QName, String> attribute : resourceReference.getOtherAttributes().entrySet()) {
        if (ID_ATTRIBUTE_NAME.equals(attribute.getKey())) {
          sourceReference.setId(attribute.getValue());
        }
        else if (DATATYPE_ATTRIBUTE_NAME.equals(attribute.getKey())) {
          String typeValue = attribute.getValue();
          int lastHash = typeValue.lastIndexOf('#');
          String localPart = typeValue;
          String namespaceUri = "";
          if (lastHash >= 0) {
            localPart = typeValue.substring(lastHash + 1);
            namespaceUri = typeValue.substring(0, lastHash);
          }
          sourceReference.setType(new QName(namespaceUri, localPart));
        }
        else {
          //todo: what to do with other custom attributes?
        }
      }
    }

    ArrayList<Object> extensionElements = new ArrayList<Object>();
    ArrayList<SourceQualifier> qualifiers = new ArrayList<SourceQualifier>();
    if (resourceReference.getOtherElements() != null) {
      for (Object el : resourceReference.getOtherElements()) {
        if (el instanceof SourceQualifier) {
          qualifiers.add((SourceQualifier) el);
        }
        else {
          extensionElements.add(el);
        }
      }
    }

    if (!extensionElements.isEmpty()) {
      sourceReference.setExtension(new Extension());
      sourceReference.getExtension().setElements(extensionElements);
    }

    if (!qualifiers.isEmpty()) {
      sourceReference.setQualifiers(qualifiers);
    }

    return sourceReference;
  }
}

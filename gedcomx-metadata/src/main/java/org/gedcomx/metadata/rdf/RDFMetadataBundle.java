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
package org.gedcomx.metadata.rdf;

import javax.xml.bind.annotation.XmlAnyAttribute;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.namespace.QName;
import java.util.List;
import java.util.Map;

/**
 * RDF metadata bundle, <a href="http://www.w3.org/TR/2004/REC-rdf-primer-20040210/#rdfxml">according to the RDF spec</a>.
 *
 * @author Ryan Heaton
 */
@XmlRootElement(name = "RDF")
public class RDFMetadataBundle {

  private List<RDFMetadata> metadataList;
  private Map<QName, String> otherAttributes;
  private List<Object> otherElements;

  /**
   * The list of items in this bundle of metadata.
   *
   * @return The list of items in this bundle of metadata.
   */
  @XmlElement ( name = "Description" )
  public List<RDFMetadata> getMetadataList() {
    return metadataList;
  }

  /**
   * The list of items in this bundle of metadata.
   *
   * @param metadataList The list of items in this bundle of metadata.
   */
  public void setMetadataList(List<RDFMetadata> metadataList) {
    this.metadataList = metadataList;
  }

  @XmlAnyAttribute
  public Map<QName, String> getOtherAttributes() {
    return otherAttributes;
  }

  public void setOtherAttributes(Map<QName, String> otherAttributes) {
    this.otherAttributes = otherAttributes;
  }

  @XmlAnyElement( lax = true )
  public List<Object> getOtherElements() {
    return otherElements;
  }

  public void setOtherElements(List<Object> otherElements) {
    this.otherElements = otherElements;
  }
}

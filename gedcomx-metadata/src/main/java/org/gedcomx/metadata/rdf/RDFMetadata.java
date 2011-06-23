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

import org.codehaus.jackson.annotate.JsonTypeInfo;
import org.codehaus.jackson.map.annotate.JsonTypeIdResolver;
import org.gedcomx.id.XmlTypeIdResolver;
import org.gedcomx.metadata.dc.DublinCoreMetadata;

import javax.xml.bind.annotation.*;
import javax.xml.namespace.QName;
import java.net.URI;
import java.util.List;
import java.util.Map;

/**
 * @author Ryan Heaton
 */
@JsonTypeInfo ( use =JsonTypeInfo.Id.CUSTOM, property = "@type")
@JsonTypeIdResolver (XmlTypeIdResolver.class)
@XmlSeeAlso( DublinCoreMetadata.class )
public class RDFMetadata {

  private String id; 
  private URI dataRef;
  private Map<QName, String> otherAttributes;
  private List<Object> otherElements;

  @XmlAttribute( name = "ID" )
  @XmlID
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }
  
  @XmlAttribute( name = "about" )
  public URI getDataRef() {
    return dataRef;
  }

  public void setDataRef(URI dataRef) {
    this.dataRef = dataRef;
  }

  @XmlAnyAttribute
  public Map<QName, String> getOtherAttributes() {
    return otherAttributes;
  }

  public void setOtherAttributes(Map<QName, String> otherAttributes) {
    this.otherAttributes = otherAttributes;
  }

  @XmlAnyElement ( lax = true )
  public List<Object> getOtherElements() {
    return otherElements;
  }

  public void setOtherElements(List<Object> otherElements) {
    this.otherElements = otherElements;
  }
}

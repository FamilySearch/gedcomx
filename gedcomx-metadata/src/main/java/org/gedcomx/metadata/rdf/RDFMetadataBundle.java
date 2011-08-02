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

import org.codehaus.enunciate.json.JsonName;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonTypeInfo;
import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.codehaus.jackson.map.annotate.JsonTypeIdResolver;
import org.gedcomx.rt.*;

import javax.xml.bind.annotation.*;
import javax.xml.namespace.QName;
import java.util.List;
import java.util.Map;

/**
 * A bunle of RDF metadata, <a href="http://www.w3.org/TR/2004/REC-rdf-primer-20040210/#rdfxml">according to the RDF spec</a>.
 *
 * @author Ryan Heaton
 */
@XmlRootElement ( name = "RDF" )
@JsonTypeInfo ( use = JsonTypeInfo.Id.CUSTOM, property = "@type" )
@JsonTypeIdResolver ( XmlTypeIdResolver.class )
public class RDFMetadataBundle {

  private String id;
  private List<RDFMetadata> contents;
  private Map<QName, String> otherAttributes;
  private List<Object> otherElements;

  /**
   * The id of this bundle.
   *
   * @return The id of this bundle.
   */
  @XmlAttribute ( name = "ID" )
  @XmlID
  public String getId() {
    return id;
  }

  /**
   * The id of this bundle.
   *
   * @param id The id of this bundle.
   */
  public void setId(String id) {
    this.id = id;
  }

  /**
   * The pieces of metadata contained in this bundle.
   *
   * @return The pieces of metadata contained in this bundle.
   */
  @XmlElement ( name = "Description" )
  @JsonProperty ( "Descriptions" )
  @JsonName ( "Descriptions" )
  public List<RDFMetadata> getContents() {
    return contents;
  }

  /**
   * The pieces of metadata contained in this bundle.
   *
   * @param contents The pieces of metadata contained in this bundle.
   */
  @JsonProperty ( "Descriptions" )
  public void setContents(List<RDFMetadata> contents) {
    this.contents = contents;
  }

  /**
   * Custom attributes for this bundle.
   *
   * @return Custom attributes for this bundle.
   */
  @XmlAnyAttribute
  @JsonSerialize ( using = AnyAttributeSerializer.class )
  public Map<QName, String> getOtherAttributes() {
    return otherAttributes;
  }

  /**
   * Custom attributes for this bundle.
   *
   * @param otherAttributes Custom attributes for this bundle.
   */
  @JsonDeserialize ( using = AnyAttributeDeserializer.class )
  public void setOtherAttributes(Map<QName, String> otherAttributes) {
    this.otherAttributes = otherAttributes;
  }

  /**
   * Custom pieces of non-RDF metadata contained in this bundle.
   *
   * @return Custom pieces of non-RDF metadata contained in this bundle.
   */
  @XmlAnyElement ( lax = true )
  @JsonSerialize ( using = AnyElementSerializer.class )
  public List<Object> getOtherElements() {
    return otherElements;
  }

  /**
   * Custom pieces of non-RDF metadata contained in this bundle.
   *
   * @param otherElements Custom pieces of non-RDF metadata contained in this bundle.
   */
  @JsonDeserialize( using = AnyElementDeserializer.class )
  public void setOtherElements(List<Object> otherElements) {
    this.otherElements = otherElements;
  }
}

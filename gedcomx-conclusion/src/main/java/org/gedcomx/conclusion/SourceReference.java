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
package org.gedcomx.conclusion;

import org.codehaus.enunciate.doc.DocumentationExample;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;
import org.gedcomx.common.Attributable;
import org.gedcomx.common.Attribution;
import org.gedcomx.common.ResourceReference;
import org.gedcomx.common.URI;
import org.gedcomx.rt.CommonModels;
import org.gedcomx.rt.JsonElementWrapper;
import org.gedcomx.rt.RDFRange;
import org.gedcomx.types.ResourceType;
import org.gedcomx.types.TypeReference;

import javax.xml.bind.annotation.*;

/**
 * An attributable reference to a source for genealogical conclusions.
 *
 * @author Ryan Heaton
 */
@XmlRootElement ( name = "source" )
@JsonElementWrapper ( name = "sources" )
@XmlType ( name = "SourceReference" )
public class SourceReference extends ResourceReference implements Attributable {

  private String id;
  @XmlElement (namespace = CommonModels.RDF_NAMESPACE)
  @JsonProperty
  private TypeReference<ResourceType> type;
  private Attribution attribution;
  private ResourceReference description;

  /**
   * The id of this resource reference. Note the distinction between this id and the id of the
   * resource being referenced.
   *
   * @return The id of this resource reference. Note the distinction between this id and the id of the
   * resource being referenced.
   */
  @XmlID
  @XmlAttribute ( name = "ID", namespace = CommonModels.RDF_NAMESPACE )
  @DocumentationExample (exclude = true)
  public String getId() {
    return id;
  }

  /**
   * The id of this resource reference. Note the distinction between this id and the id of the
   * resource being referenced.
   *
   * @param id The id of this resource reference. Note the distinction between this id and the id of the
   * resource being referenced.
   */
  public void setId(String id) {
    this.id = id;
  }

  /**
   * The type of the resource being referenced.
   *
   * @return The type of the resource being referenced.
   */
  @XmlTransient
  @JsonIgnore
  public URI getType() {
    return this.type == null ? null : this.type.getType();
  }

  /**
   * The type of the resource being referenced.
   *
   * @param type The type of the resource being referenced.
   */
  @JsonIgnore
  public void setType(URI type) {
    this.type = type == null ? null : new TypeReference<ResourceType>(type);
  }

  /**
   * The enum referencing the known type of the resource being referenced, or {@link org.gedcomx.types.ResourceType#OTHER} if not known.
   *
   * @return The enum referencing the known type of the source reference, or {@link org.gedcomx.types.ResourceType#OTHER} if not known.
   */
  @XmlTransient
  @JsonIgnore
  public ResourceType getKnownType() {
    return this.type == null ? null : ResourceType.fromQNameURI(this.type.getType());
  }

  /**
   * Set the type of this reference from an enumeration of known source reference types.
   *
   * @param knownType The reference type.
   */
  @JsonIgnore
  public void setKnownType(ResourceType knownType) {
    this.type = knownType == null ? null : new TypeReference<ResourceType>(knownType);
  }

  /**
   * The attribution metadata for this source reference.
   *
   * @return The attribution metadata for this source reference.
   */
  @XmlElement ( namespace = CommonModels.GEDCOMX_COMMON_NAMESPACE )
  public Attribution getAttribution() {
    return attribution;
  }

  /**
   * The attribution metadata for this source reference.
   *
   * @param attribution The attribution metadata for this source reference.
   */
  public void setAttribution(Attribution attribution) {
    this.attribution = attribution;
  }

  /**
   * A reference to a description about the source being referenced.
   *
   * @return A reference to a description about the source being referenced.
   */
  @RDFRange( external = "org.gedcomx.metadata.rdf.RDFDescription" )
  public ResourceReference getDescription() {
    return description;
  }

  /**
   * A reference to a description about the source being referenced.
   *
   * @param description A reference to a description about the source being referenced.
   */
  public void setDescription(ResourceReference description) {
    this.description = description;
  }
}

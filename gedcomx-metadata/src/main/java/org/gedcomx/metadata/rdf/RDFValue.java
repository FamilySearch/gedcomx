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
package org.gedcomx.metadata.rdf;

import org.codehaus.enunciate.doc.DocumentationExample;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonTypeInfo;
import org.codehaus.jackson.map.annotate.JsonTypeIdResolver;
import org.gedcomx.common.ResourceReference;
import org.gedcomx.common.URI;
import org.gedcomx.rt.CommonModels;
import org.gedcomx.rt.XmlTypeIdResolver;
import org.gedcomx.types.ResourceType;
import org.gedcomx.types.TypeReference;

import javax.xml.XMLConstants;
import javax.xml.bind.annotation.*;

/**
 * An element representing an RDF value. For more information, see <a href="http://www.w3.org/TR/rdf-schema/#ch_value">RDF Schema, Section 4.5.3</a>,
 * <a href="http://www.w3.org/TR/2004/REC-rdf-primer-20040210/#rdfvalue">RDF Primer, Section 4.4</a>
 * and <a href="http://dublincore.org/documents/profile-guidelines/#appc">Using RDF properties in profiles: a technical primer</a>.
 *
 * @link http://www.w3.org/TR/rdf-schema/#ch_value
 * @link http://www.w3.org/TR/2004/REC-rdf-primer-20040210/#rdfvalue
 * @author Ryan Heaton
 */
@XmlType ( name = "Resource", namespace = CommonModels.RDFS_NAMESPACE )
@JsonTypeInfo ( use =JsonTypeInfo.Id.CUSTOM, property = XmlTypeIdResolver.TYPE_PROPERTY_NAME)
@JsonTypeIdResolver (XmlTypeIdResolver.class)
public final class RDFValue extends ResourceReference {

  private String id;
  @XmlElement (namespace = CommonModels.RDF_NAMESPACE)
  @JsonProperty
  private TypeReference<ResourceType> type;
  private String lang;
  private String value;

  public RDFValue() {
  }

  public RDFValue(String value) {
    this.value = value;
  }

  /**
   * The id of this resource reference. Note the distinction between this id and the id of the
   * resource being referenced.
   *
   * @return The id of this resource reference. Note the distinction between this id and the id of the
   * resource being referenced.
   */
  @XmlID
  @XmlAttribute( name = "ID", namespace = CommonModels.RDF_NAMESPACE )
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
   * The language of the value of the property. See <a href="http://www.w3.org/International/articles/language-tags/>http://www.w3.org/International/articles/language-tags/</a>
   *
   * @return The language of the value of the property.
   */
  @XmlAttribute( namespace = XMLConstants.XML_NS_URI )
  public String getLang() {
    return lang;
  }

  /**
   * The language of the value of the property. See <a href="http://www.w3.org/International/articles/language-tags/>http://www.w3.org/International/articles/language-tags/</a>
   *
   * @param lang The language of the value of the property.
   */
  public void setLang(String lang) {
    this.lang = lang;
  }

  /**
   * The value of the property, if it can be expressed as a string. If the value can't be expressed as a string, use {@link #getResource() the resource ref}.
   *
   * @return The value of the property.
   */
  @XmlElement ( name = "value", namespace = CommonModels.RDF_NAMESPACE )
  public String getValue() {
    return value;
  }

  /**
   * The value of the property, if it can be expressed as a string. If the value can't be expressed as a string, use {@link #getResource() the resource ref}.
   *
   * @param value The value of the property.
   */
  public void setValue(String value) {
    this.value = value;
  }

}

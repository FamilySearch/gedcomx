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

import org.codehaus.enunciate.XmlQNameEnumUtil;
import org.codehaus.enunciate.json.JsonName;
import org.codehaus.enunciate.qname.XmlQNameEnumRef;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonTypeInfo;
import org.codehaus.jackson.map.annotate.JsonTypeIdResolver;
import org.gedcomx.rt.*;
import org.gedcomx.types.RecordType;
import org.gedcomx.types.TypeReference;

import javax.xml.XMLConstants;
import javax.xml.bind.annotation.*;
import java.net.URI;
import java.util.List;

/**
 * A formal collection of genealogical entities.
 */
@XmlRootElement
@JsonExtensionElement
@JsonTypeInfo ( use =JsonTypeInfo.Id.CUSTOM, property = XmlTypeIdResolver.TYPE_PROPERTY_NAME)
@JsonTypeIdResolver (XmlTypeIdResolver.class)
@XmlType ( name = "Collection", propOrder = { "title", "description", "publisher", "types", "spatial", "temporal", "items" } )
@RDFSubClassOf ( CommonNamespaces.DUBLIN_CORE_TYPE_NAMESPACE + "Collection" )
public class Collection extends GenealogicalEntity {

  private String title;
  private String description;
  private String publisher;
  private String spatial;
  private String temporal;
  private List<TypeReference> types;
  private List<ResourceReference> items;

  /**
   * The title for the collection.
   *
   * @return The title for the collection.
   */
  @RDFSubPropertyOf ( CommonNamespaces.DUBLIN_CORE_NAMESPACE + "title" )
  public String getTitle() {
    return title;
  }

  /**
   * The title for the collection.
   *
   * @param title The title for the collection.
   */
  public void setTitle(String title) {
    this.title = title;
  }

  /**
   * A description of the collection.
   *
   * @return A description of the collection.
   */
  @RDFSubPropertyOf ( CommonNamespaces.DUBLIN_CORE_NAMESPACE + "description" )
  public String getDescription() {
    return description;
  }

  /**
   * A description of the collection.
   *
   * @param description A description of the collection.
   */
  public void setDescription(String description) {
    this.description = description;
  }

  /**
   * The publisher for the collection.
   *
   * @return The publisher for the collection.
   */
  @RDFSubPropertyOf ( CommonNamespaces.DUBLIN_CORE_NAMESPACE + "publisher" )
  public String getPublisher() {
    return publisher;
  }

  /**
   * The publisher for the collection.
   *
   * @param publisher The publisher for the collection.
   */
  public void setPublisher(String publisher) {
    this.publisher = publisher;
  }

  /**
   * The "types" of this collection, i.e. the types of items this collection holds.
   *
   * @return The "types" of this collection, i.e. the types of items this collection holds.
   */
  @XmlElement( name = "type", namespace = CommonNamespaces.RDF_NAMESPACE )
  @JsonName ("types")
  @JsonProperty ("types")
  public List<TypeReference> getTypes() {
    return types;
  }

  /**
   * The "types" of this collection, i.e. the types of items this collection holds.
   *
   * @param types The "types" of this collection, i.e. the types of items this collection holds.
   */
  @JsonProperty ("types")
  public void setTypes(List<TypeReference> types) {
    this.types = types;
  }

  /**
   * The spatial coverage.
   *
   * @return The spatial coverage.
   */
  @RDFSubPropertyOf ( CommonNamespaces.DUBLIN_CORE_NAMESPACE + "spatial" )
  public String getSpatial() {
    return spatial;
  }

  /**
   * The spatial coverage.
   *
   * @param spatial The spatial coverage.
   */
  public void setSpatial(String spatial) {
    this.spatial = spatial;
  }

  /**
   * The temporal coverage.
   *
   * @return The temporal coverage.
   */
  @RDFSubPropertyOf ( CommonNamespaces.DUBLIN_CORE_NAMESPACE + "temporal" )
  public String getTemporal() {
    return temporal;
  }

  /**
   * The temporal coverage.
   *
   * @param temporal The temporal coverage.
   */
  public void setTemporal(String temporal) {
    this.temporal = temporal;
  }

  /**
   * The items in this collection.
   *
   * @return The items in this collection.
   */
  @XmlElement(name = "item")
  @JsonProperty ("items")
  @JsonName ("items")
  @RDFRange ({})
  @RDFSubPropertyOf ( CommonNamespaces.DUBLIN_CORE_NAMESPACE + "hasPart")
  public List<ResourceReference> getItems() {
    return items;
  }

  /**
   * The items in this collection.
   *
   * @param items The items in this collection.
   */
  @JsonProperty ("items")
  public void setItems(List<ResourceReference> items) {
    this.items = items;
  }
}

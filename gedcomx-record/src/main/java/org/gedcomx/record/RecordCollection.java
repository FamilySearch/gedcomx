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
package org.gedcomx.record;

import org.codehaus.jackson.annotate.JsonTypeInfo;
import org.codehaus.jackson.map.annotate.JsonTypeIdResolver;
import org.gedcomx.common.*;
import org.gedcomx.rt.RDFRange;
import org.gedcomx.rt.RDFSubClassOf;
import org.gedcomx.rt.RDFSubPropertyOf;
import org.gedcomx.rt.XmlTypeIdResolver;
import org.gedcomx.types.TypesNamespaces;

import javax.xml.bind.annotation.*;

/**
 * A collection of records.
 */
@XmlRootElement
@JsonTypeInfo ( use =JsonTypeInfo.Id.CUSTOM, property = "@type")
@JsonTypeIdResolver (XmlTypeIdResolver.class)
@XmlType ( name = "RecordCollection", propOrder = { "bibliographicCitation", "parent", "title", "description", "publisher" } )
@RDFSubClassOf ( TypesNamespaces.DUBLIN_CORE_TYPE_NAMESPACE + "Collection" )
public class RecordCollection extends GenealogicalResource implements BibliographicResource, Describable {

  private ResourceReference parent;
  private String title;
  private String description;
  private String publisher;
  private String bibliographicCitation;

  /**
   * The reference to the "parent" collection for this collection, i.e. the collection that contains this collection.
   *
   * @return The reference to the "parent" collection for this collection, i.e. the collection that contains this collection.
   */
  @RDFRange(RecordCollection.class)
  @RDFSubPropertyOf ( TypesNamespaces.DUBLIN_CORE_NAMESPACE + "isPartOf" )
  public ResourceReference getParent() {
    return parent;
  }

  /**
   * The reference to the "parent" collection for this collection, i.e. the collection that contains this collection.
   *
   * @param parent The reference to the "parent" collection for this collection, i.e. the collection that contains this collection.
   */
  public void setParent(ResourceReference parent) {
    this.parent = parent;
  }

  /**
   * The title for the collection.
   *
   * @return The title for the collection.
   */
  @RDFSubPropertyOf ( TypesNamespaces.DUBLIN_CORE_NAMESPACE + "title" )
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
  @RDFSubPropertyOf ( TypesNamespaces.DUBLIN_CORE_NAMESPACE + "description" )
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
  @RDFSubPropertyOf ( TypesNamespaces.DUBLIN_CORE_NAMESPACE + "publisher" )
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
   * The bibliographic citation for this data.
   *
   * @return The bibliographic citation for this data.
   */
  public String getBibliographicCitation() {
    return bibliographicCitation;
  }

  /**
   * The bibliographic citation for this data.
   *
   * @param bibliographicCitation The bibliographic citation for this data.
   */
  public void setBibliographicCitation(String bibliographicCitation) {
    this.bibliographicCitation = bibliographicCitation;
  }

}

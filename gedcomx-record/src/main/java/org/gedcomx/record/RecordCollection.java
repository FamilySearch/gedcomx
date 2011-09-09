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

import org.codehaus.enunciate.XmlQNameEnumUtil;
import org.codehaus.enunciate.qname.XmlQNameEnumRef;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonTypeInfo;
import org.codehaus.jackson.map.annotate.JsonTypeIdResolver;
import org.gedcomx.common.BibliographicResource;
import org.gedcomx.common.GenealogicalResource;
import org.gedcomx.common.ResourceReference;
import org.gedcomx.rt.CommonNamespaces;
import org.gedcomx.rt.*;
import org.gedcomx.types.RecordType;

import javax.xml.XMLConstants;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;
import java.net.URI;

/**
 * A collection of records.
 */
@XmlRootElement
@JsonTypeInfo ( use =JsonTypeInfo.Id.CUSTOM, property = "@type")
@JsonTypeIdResolver (XmlTypeIdResolver.class)
@XmlType ( name = "RecordCollection", propOrder = { "bibliographicCitation", "parent", "title", "description", "publisher", "recordType", "spatial", "temporal" } )
@RDFSubClassOf ( CommonNamespaces.DUBLIN_CORE_TYPE_NAMESPACE + "Collection" )
public class RecordCollection extends GenealogicalResource implements BibliographicResource, Describable {

  private String bibliographicCitation;
  private ResourceReference parent;
  private String title;
  private String description;
  private String publisher;
  private URI recordType;
  private String spatial;
  private String temporal;

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

  /**
   * The reference to the "parent" collection for this collection, i.e. the collection that contains this collection.
   *
   * @return The reference to the "parent" collection for this collection, i.e. the collection that contains this collection.
   */
  @RDFRange(RecordCollection.class)
  @RDFSubPropertyOf ( CommonNamespaces.DUBLIN_CORE_NAMESPACE + "isPartOf" )
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
   * Reference to the type of record contained in a collection.
   *
   * @return Reference to the type of record contained in a collection.
   */
  @XmlQNameEnumRef(RecordType.class)
  @XmlSchemaType (name = "anyURI", namespace = XMLConstants.W3C_XML_SCHEMA_NS_URI)
  public URI getRecordType() {
    return recordType;
  }

  /**
   * Reference to the type of record contained in a collection.
   *
   * @param recordType Reference to the type of record contained in a collection.
   */
  public void setRecordType(URI recordType) {
    this.recordType = recordType;
  }

  /**
   * Get the record type from a known enumeration of record types.
   *
   * @return The known record type, or {@link org.gedcomx.types.RecordType#OTHER} if unknown type.
   */
  @XmlTransient
  @JsonIgnore
  public RecordType getKnownRecordType() {
    return XmlQNameEnumUtil.fromURI(getRecordType(), RecordType.class);
  }

  /**
   * Set the record type from a known enumeration of record types.
   *
   * @param type The record type.
   */
  @JsonIgnore
  public void setKnownRecordType(RecordType type) {
    setRecordType(XmlQNameEnumUtil.toURI(type));
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
}

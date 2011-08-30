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
import org.codehaus.enunciate.json.JsonName;
import org.codehaus.enunciate.qname.XmlQNameEnumRef;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonTypeInfo;
import org.codehaus.jackson.map.annotate.JsonTypeIdResolver;
import org.gedcomx.common.*;
import org.gedcomx.rt.RDFRange;
import org.gedcomx.rt.RDFSubPropertyOf;
import org.gedcomx.rt.XmlTypeIdResolver;
import org.gedcomx.types.RecordType;
import org.gedcomx.types.Typed;
import org.gedcomx.types.TypesNamespaces;

import javax.xml.XMLConstants;
import javax.xml.bind.annotation.*;
import java.net.URI;
import java.util.List;

/**
 * A record.
 */
@XmlRootElement
@JsonTypeInfo ( use =JsonTypeInfo.Id.CUSTOM, property = "@type")
@JsonTypeIdResolver (XmlTypeIdResolver.class)
@XmlType ( name = "Record", propOrder = { "persistentId", "alternateIds", "bibliographicCitation", "collection", "personas", "events", "relationships", "fields" } )
public class Record extends GenealogicalResource implements Typed, BibliographicResource, PersistentIdentifiable {

  private String lang;
  private URI type;
  private URI persistentId;
  private List<AlternateId> alternateIds;
  private String bibliographicCitation;
  private ResourceReference collection;
  private List<Persona> personas;
  private List<Event> events;
  private List<Relationship> relationships;
  private List<RecordField> fields;

  /**
   * The type of the record.
   * 
   * @return The type of the record.
   */
  @XmlAttribute (namespace = TypesNamespaces.GEDCOMX_TYPES_NAMESPACE)
  @XmlQNameEnumRef(RecordType.class)
  @XmlSchemaType (name = "anyURI", namespace = XMLConstants.W3C_XML_SCHEMA_NS_URI)
  public URI getType() {
    return type;
  }

  /**
   * The type of the record.
   * 
   * @param type The type of the record.
   */
  public void setType(URI type) {
    this.type = type;
  }

  /**
   * The enum referencing the known type of the record, or {@link org.gedcomx.types.RecordType#other} if not known.
   * 
   * @return The enum referencing the known type of the record, or {@link org.gedcomx.types.RecordType#other} if not known.
   */
  @XmlTransient
  @JsonIgnore
  public RecordType getKnownType() {
    return XmlQNameEnumUtil.fromURI(getType(), RecordType.class);
  }

  /**
   * The enum referencing the known type of the record, or {@link org.gedcomx.types.RecordType#other} if not known.
   * 
   * @param knownType The enum referencing the known type of the record, or {@link org.gedcomx.types.RecordType#other} if not known.
   */
  @JsonIgnore
  public void setKnownType(RecordType knownType) {
    setType(XmlQNameEnumUtil.toURI(knownType));
  }

  /**
   * The language of the record. See <a href="http://www.w3.org/International/articles/language-tags/">http://www.w3.org/International/articles/language-tags/</a>
   *
   * @return The language of the record.
   */
  @XmlAttribute( namespace = XMLConstants.XML_NS_URI )
  public String getLang() {
    return lang;
  }

  /**
   * The language of the record. See <a href="http://www.w3.org/International/articles/language-tags/">http://www.w3.org/International/articles/language-tags/</a>
   *
   * @param lang The language of the record.
   */
  public void setLang(String lang) {
    this.lang = lang;
  }

  /**
   * A long-term, persistent, globally unique identifier for this record.
   *
   * @return A long-term, persistent, globally unique identifier for this record.
   */
  @XmlSchemaType(name = "anyURI", namespace = XMLConstants.W3C_XML_SCHEMA_NS_URI)
  public URI getPersistentId() {
    return persistentId;
  }

  /**
   * A long-term, persistent, globally unique identifier for this record.
   *
   * @param persistentId A long-term, persistent, globally unique identifier for this record.
   */
  public void setPersistentId(URI persistentId) {
    this.persistentId = persistentId;
  }

  /**
   * The list of alternate ids of the record.
   *
   * @return The list of alternate ids of the record.
   */
  @XmlElement (name="alternateId")
  @JsonProperty("alternateIds")
  @JsonName("alternateIds")
  public List<AlternateId> getAlternateIds() {
    return alternateIds;
  }

  /**
   * The list of alternate ids of the record.
   *
   * @param alternateIds The list of alternate ids of the record.
   */
  @JsonProperty("alternateIds")
  public void setAlternateIds(List<AlternateId> alternateIds) {
    this.alternateIds = alternateIds;
  }

  /**
   * The bibliographic citation for this record.
   *
   * @return The bibliographic citation for this record.
   */
  public String getBibliographicCitation() {
    return bibliographicCitation;
  }

  /**
   * The bibliographic citation for this record.
   *
   * @param bibliographicCitation The bibliographic citation for this record.
   */
  public void setBibliographicCitation(String bibliographicCitation) {
    this.bibliographicCitation = bibliographicCitation;
  }
  /**
   * The reference to the collection containing this record.
   *
   * @return The reference to the collection containing this record.
   */
  @RDFRange( RecordCollection.class )
  @RDFSubPropertyOf ( TypesNamespaces.DUBLIN_CORE_NAMESPACE + "isPartOf" )
  public ResourceReference getCollection() {
    return collection;
  }

  /**
   * The reference to the collection containing this record.
   *
   * @param collection The reference to the collection containing this record.
   */
  public void setCollection(ResourceReference collection) {
    this.collection = collection;
  }

  /**
   * The personas of this record.
   *
   * @return The personas of this record.
   */
  @XmlElement(name = "persona")
  @JsonProperty("personas")
  @JsonName("personas")
  public List<Persona> getPersonas() {
    return personas;
  }

  /**
   * The personas of this record.
   *
   * @param personas The personas of this record.
   */
  @JsonProperty("personas")
  public void setPersonas(List<Persona> personas) {
    this.personas = personas;
  }

  /**
   * The events of the record.
   *
   * @return The events of the record.
   */
  @XmlElement(name = "event")
  @JsonProperty("events")
  @JsonName("events")
  public List<Event> getEvents() {
    return events;
  }

  /**
   * The events of the record.
   *
   * @param events The events of the record.
   */
  @JsonProperty("events")
  public void setEvents(List<Event> events) {
    this.events = events;
  }

  /**
   * The relationships on this record.
   *
   * @return The relationships on this record.
   */
  @XmlElement(name = "relationship")
  @JsonProperty("relationships")
  @JsonName("relationships")
  public List<Relationship> getRelationships() {
    return relationships;
  }

  /**
   * The relationships on this record.
   *
   * @param relationships The relationships on this record.
   */
  @JsonProperty("relationships")
  public void setRelationships(List<Relationship> relationships) {
    this.relationships = relationships;
  }

  /**
   * Any generic fields that are on the record (not belonging to a persona or relationship).
   *
   * @return Any generic fields that are on the record (not belonging to a persona or relationship).
   */
  @XmlElement(name = "field")
  @JsonProperty("fields")
  @JsonName("fields")
  public List<RecordField> getFields() {
    return fields;
  }

  /**
   * Any generic fields that are on the record (not belonging to a persona or relationship).
   *
   * @param fields Any generic fields that are on the record (not belonging to a persona or relationship).
   */
  @JsonProperty("fields")
  public void setFields(List<RecordField> fields) {
    this.fields = fields;
  }

}

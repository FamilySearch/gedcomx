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
import org.codehaus.jackson.annotate.JsonIgnore
;
import org.codehaus.enunciate.json.JsonName;
import org.codehaus.enunciate.qname.XmlQNameEnumRef;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonTypeInfo;
import org.codehaus.jackson.map.annotate.JsonTypeIdResolver;
import org.gedcomx.attribution.Attribution;
import org.gedcomx.common.AlternateId;
import org.gedcomx.common.Extension;
import org.gedcomx.common.ResourceReference;
import org.gedcomx.common.SourceReference;
import org.gedcomx.rt.XmlTypeIdResolver;
import org.gedcomx.types.RecordType;

import javax.xml.XMLConstants;
import javax.xml.bind.annotation.*;
import javax.xml.namespace.QName;
import java.net.URI;
import java.util.*;

/**
 * A record.
 */
@XmlRootElement
@XmlType (
  propOrder = {"persistentId", "alternateIds", "attribution", "collection", "personas", "events", "relationships", "fields", "bibliographicCitation", "sources", "extension"}
)
@JsonTypeInfo ( use =JsonTypeInfo.Id.CUSTOM, property = "@type")
@JsonTypeIdResolver (XmlTypeIdResolver.class)
public class Record {

  private String id;
  private String lang;
  private QName type;
  private URI persistentId;
  private List<AlternateId> alternateIds;
  private Attribution attribution;
  private ResourceReference collection;
  private List<Persona> personas;
  private List<Event> events;
  private List<Relationship> relationships;
  private List<RecordField> fields;
  private String bibliographicCitation;
  private List<SourceReference> sources;
  private Extension extension;

  /**
   * The id of the record, unique to the context and not necessarily globally unique.
   *
   * @return The id of the record, unique to the context and not necessarily globally unique.
   */
  @XmlID
  @XmlAttribute
  public String getId() {
    return id;
  }

  /**
   * The id of the record, unique to the context and not necessarily globally unique.
   *
   * @param id The id of the record, unique to the context and not necessarily globally unique.
   */
  public void setId(String id) {
    this.id = id;
  }

  /**
   * The type of the record.
   * 
   * @return The type of the record.
   */
  @XmlAttribute
  @XmlQNameEnumRef(RecordType.class)
  public QName getType() {
    return type;
  }

  /**
   * The type of the record.
   * 
   * @param type The type of the record.
   */
  public void setType(QName type) {
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
    return XmlQNameEnumUtil.fromQName(getType(), RecordType.class);
  }

  /**
   * The enum referencing the known type of the record, or {@link org.gedcomx.types.RecordType#other} if not known.
   * 
   * @param knownType The enum referencing the known type of the record, or {@link org.gedcomx.types.RecordType#other} if not known.
   */
  @JsonIgnore
  public void setKnownType(RecordType knownType) {
    this.type = XmlQNameEnumUtil.toQName(knownType);
  }

  /**
   * The language of the record. See <a href="http://www.w3.org/International/articles/language-tags/>http://www.w3.org/International/articles/language-tags/</a>
   *
   * @return The language of the record.
   */
  @XmlAttribute( namespace = XMLConstants.XML_NS_URI )
  public String getLang() {
    return lang;
  }

  /**
   * The language of the record. See <a href="http://www.w3.org/International/articles/language-tags/>http://www.w3.org/International/articles/language-tags/</a>
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
   * The attribution metadata for this record.
   *
   * @return The attribution metadata for this record.
   */
  @XmlElementRef
  public Attribution getAttribution() {
    return attribution;
  }

  /**
   * The attribution metadata for this record.
   *
   * @param attribution The attribution metadata for this record.
   */
  public void setAttribution(Attribution attribution) {
    this.attribution = attribution;
  }

  /**
   * The reference to the collection containing this record.
   *
   * @return The reference to the collection containing this record.
   */
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
   * The references to the sources of the record.
   *
   * @return The references to the sources of the record.
   */
  @XmlElement(name = "source")
  @JsonProperty("sources")
  @JsonName("sources")
  public List<SourceReference> getSources() {
    return sources;
  }

  /**
   * The references to the sources of the record.
   *
   * @param sources The references to the sources of the record.
   */
  @JsonProperty("sources")
  public void setSources(List<SourceReference> sources) {
    this.sources = sources;
  }

  /**
   * The extension point for the record.
   *
   * @return The extension point for the record.
   */
  @XmlElement( name = "ext" )
  public Extension getExtension() {
    return extension;
  }

  /**
   * The extension point for the record.
   *
   * @param extension The extension point for the record.
   */
  public void setExtension(Extension extension) {
    this.extension = extension;
  }
}

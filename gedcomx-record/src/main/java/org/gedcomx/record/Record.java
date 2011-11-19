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
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonTypeInfo;
import org.codehaus.jackson.map.annotate.JsonTypeIdResolver;
import org.gedcomx.common.GenealogicalEntity;
import org.gedcomx.common.PersistentIdentifiable;
import org.gedcomx.rt.CommonModels;
import org.gedcomx.rt.JsonElementWrapper;
import org.gedcomx.rt.XmlTypeIdResolver;
import org.gedcomx.types.RecordType;
import org.gedcomx.types.TypeReference;
import org.gedcomx.types.Typed;

import javax.xml.XMLConstants;
import javax.xml.bind.annotation.*;
import java.util.List;

/**
 * A record.
 */
@XmlRootElement
@JsonElementWrapper ( name = "records" )
@JsonTypeInfo ( use =JsonTypeInfo.Id.CUSTOM, property = XmlTypeIdResolver.TYPE_PROPERTY_NAME)
@JsonTypeIdResolver (XmlTypeIdResolver.class)
@XmlType ( name = "Record", propOrder = { "type", "personas", "events", "relationships", "fields" } )
public class Record extends GenealogicalEntity implements Typed<RecordType>, PersistentIdentifiable {

  private String lang;
  private TypeReference<RecordType> type;
  private List<Persona> personas;
  private List<Event> events;
  private List<Relationship> relationships;
  private List<RecordField> fields;

  /**
   * The type of the record.
   * 
   * @return The type of the record.
   */
  @XmlElement (namespace = CommonModels.RDF_NAMESPACE)
  public TypeReference<RecordType> getType() {
    return type;
  }

  /**
   * The type of the record.
   * 
   * @param type The type of the record.
   */
  public void setType(TypeReference<RecordType> type) {
    this.type = type;
  }

  /**
   * The enum referencing the known type of the record, or {@link org.gedcomx.types.RecordType#OTHER} if not known.
   * 
   * @return The enum referencing the known type of the record, or {@link org.gedcomx.types.RecordType#OTHER} if not known.
   */
  @XmlTransient
  @JsonIgnore
  public RecordType getKnownType() {
    return getType() == null ? null : XmlQNameEnumUtil.fromURI(getType().getType(), RecordType.class);
  }

  /**
   * The enum referencing the known type of the record, or {@link org.gedcomx.types.RecordType#OTHER} if not known.
   * 
   * @param knownType The enum referencing the known type of the record, or {@link org.gedcomx.types.RecordType#OTHER} if not known.
   */
  @JsonIgnore
  public void setKnownType(RecordType knownType) {
    setType(knownType == null ? null : new TypeReference<RecordType>(knownType));
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

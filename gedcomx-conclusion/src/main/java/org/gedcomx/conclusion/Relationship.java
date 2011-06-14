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
package org.gedcomx.conclusion;

import org.codehaus.enunciate.json.JsonName;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonTypeInfo;
import org.codehaus.jackson.map.annotate.JsonTypeIdResolver;
import org.gedcomx.attribution.Attribution;
import org.gedcomx.id.AlternateId;
import org.gedcomx.id.PersistentId;
import org.gedcomx.id.XmlTypeIdResolver;
import org.gedcomx.source.AttributedSourceReference;

import javax.xml.bind.annotation.*;
import java.util.List;

/**
 * A relationship between two or more persons.
 *
 * @author Ryan Heaton
 */
@XmlType (
  propOrder = {"persistentId", "alternateIds", "attribution", "events", "characteristics", "sources"}
)
@JsonTypeInfo ( use =JsonTypeInfo.Id.CUSTOM, property = "@type")
@JsonTypeIdResolver (XmlTypeIdResolver.class)
public abstract class Relationship {

  private String id;
  private PersistentId persistentId;
  private List<AlternateId> alternateIds;
  private Attribution attribution;

  private List<Event> events;
  private List<Characteristic> characteristics;
  private List<AttributedSourceReference> sources;

  /**
   * The id of the relationship, unique to the context and not necessarily globally unique.
   *
   * @return The id of the relationship, unique to the context and not necessarily globally unique.
   */
  @XmlID
  @XmlAttribute
  public String getId() {
    return id;
  }

  /**
   * The id of the relationship, unique to the context and not necessarily globally unique.
   *
   * @param id The id of the relationship, unique to the context and not necessarily globally unique.
   */
  public void setId(String id) {
    this.id = id;
  }

  /**
   * A long-term, persistent, globally unique identifier for this relationship.
   *
   * @return A long-term, persistent, globally unique identifier for this relationship.
   */
  public PersistentId getPersistentId() {
    return persistentId;
  }

  /**
   * A long-term, persistent, globally unique identifier for this relationship.
   *
   * @param persistentId A long-term, persistent, globally unique identifier for this relationship.
   */
  public void setPersistentId(PersistentId persistentId) {
    this.persistentId = persistentId;
  }

  /**
   * The list of alternate ids of the relationship.
   *
   * @return The list of alternate ids of the relationship.
   */
  @XmlElement (name="alternateId")
  @JsonProperty("alternateIds")
  @JsonName("alternateIds")
  public List<AlternateId> getAlternateIds() {
    return alternateIds;
  }

  /**
   * The list of alternate ids of the relationship.
   *
   * @param alternateIds The list of alternate ids of the relationship.
   */
  @JsonProperty("alternateIds")
  public void setAlternateIds(List<AlternateId> alternateIds) {
    this.alternateIds = alternateIds;
  }

  /**
   * The attribution metadata for this relationship.
   *
   * @return The attribution metadata for this relationship.
   */
  public Attribution getAttribution() {
    return attribution;
  }

  /**
   * The attribution metadata for this relationship.
   *
   * @param attribution The attribution metadata for this relationship.
   */
  public void setAttribution(Attribution attribution) {
    this.attribution = attribution;
  }

  /**
   * The event conclusions for the relationship.
   *
   * @return The event conclusions for the relationship.
   */
  @XmlElement(name="event")
  @JsonProperty("events")
  @JsonName("events")
  public List<Event> getEvents() {
    return events;
  }

  /**
   * The event conclusions for the relationship.
   *
   * @param events The event conclusions for the relationship.
   */
  @JsonProperty("events")
  public void setEvents(List<Event> events) {
    this.events = events;
  }

  /**
   * The characteristic conclusions for the relationship.
   *
   * @return The characteristic conclusions for the relationship.
   */
  @XmlElement(name="characteristic")
  @JsonProperty("characteristics")
  @JsonName("characteristics")
  public List<Characteristic> getCharacteristics() {
    return characteristics;
  }

  /**
   * The characteristic conclusions for the relationship.
   *
   * @param characteristics The characteristic conclusions for the relationship.
   */
  @JsonProperty("characteristics")
  public void setCharacteristics(List<Characteristic> characteristics) {
    this.characteristics = characteristics;
  }

  /**
   * The sources for the conclusions about this relationship.
   *
   * @return The sources for the conclusions about this relationship.
   */
  @XmlElement(name="source")
  @JsonProperty ("sources")
  @JsonName ("sources")
  public List<AttributedSourceReference> getSources() {
    return sources;
  }

  /**
   * The sources for the conclusions about this relationship.
   *
   * @param sources The sources for the conclusions about this relationship.
   */
  @JsonProperty ("sources")
  public void setSources(List<AttributedSourceReference> sources) {
    this.sources = sources;
  }

  /**
   * A person in the relationship. The name "person1" is used only to distinguish it from
   * the other person in this relationship and implies neither order nor role. When the relationship type
   * implies direction, it goes from "person1" to "person2".
   *
   * @return A person in the relationship. The name "person1" is used only to distinguish it from
   * the other person in this relationship and implies neither order nor role. When the relationship type
   * implies direction, it goes from "person1" to "person2".
   */
  @XmlTransient
  public abstract PersonReference getPerson1();

  /**
   * A person in the relationship. The name "person1" is used only to distinguish it from
   * the other person in this relationship and implies neither order nor role. When the relationship type
   * implies direction, it goes from "person1" to "person2".
   *
   * @param person1 A person in the relationship. The name "person1" is used only to distinguish it from
   * the other person in this relationship and implies neither order nor role. When the relationship type
   * implies direction, it goes from "person1" to "person2".
   */
  public abstract void setPerson1(PersonReference person1);

  /**
   * A person in the relationship. The name "person2" is used only to distinguish it from
   * the other person in this relationship and implies neither order nor role. When the relationship type
   * implies direction, it goes from "person1" to "person2".
   *
   * @return A person in the relationship. The name "person2" is used only to distinguish it from
   * the other person in this relationship and implies neither order nor role. When the relationship type
   * implies direction, it goes from "person1" to "person2".
   */
  @XmlTransient
  public abstract PersonReference getPerson2();

  /**
   * A person in the relationship. The name "person2" is used only to distinguish it from
   * the other person in this relationship and implies neither order nor role. When the relationship type
   * implies direction, it goes from "person1" to "person2".
   *
   * @param person2 A person in the relationship. The name "person2" is used only to distinguish it from
   * the other person in this relationship and implies neither order nor role. When the relationship type
   * implies direction, it goes from "person1" to "person2".
   */
  public abstract void setPerson2(PersonReference person2);

}

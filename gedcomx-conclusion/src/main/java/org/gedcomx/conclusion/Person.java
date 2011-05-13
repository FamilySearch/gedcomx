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

import org.codehaus.jackson.annotate.JsonTypeInfo;
import org.codehaus.jackson.map.annotate.JsonTypeIdResolver;
import org.gedcomx.id.AlternateId;
import org.gedcomx.id.PersistentIdentifier;
import org.gedcomx.id.XmlTypeIdResolver;
import org.gedcomx.source.AttributedSourceReference;

import javax.xml.bind.annotation.*;
import java.util.List;

/**
 * A person.
 *
 * @author Ryan Heaton
 */
@XmlRootElement
@XmlType (
  propOrder = {"persistentId", "alternateIds", "gender", "names", "events", "characteristics", "relationships", "sources"}
)
@JsonTypeInfo ( use =JsonTypeInfo.Id.CUSTOM, property = "@type")
@JsonTypeIdResolver (XmlTypeIdResolver.class)
public class Person {

  private String id;
  private List<AlternateId> alternateIds;
  private PersistentIdentifier persistentId;
  private Gender gender;

  //todo: change to List<? extends Name> when http://jira.codehaus.org/browse/ENUNCIATE-562 is fixed.
  private List<Name> names;
  private List<Event> events;
  private List<Characteristic> characteristics;
  private List<RelationshipReference> relationships;
  private List<AttributedSourceReference> sources;

  /**
   * The id of the person, unique to the context and not necessarily globally unique.
   *
   * @return The id of the person, unique to the context and not necessarily globally unique.
   */
  @XmlID
  @XmlAttribute
  public String getId() {
    return id;
  }

  /**
   * The id of the person, unique to the context and not necessarily globally unique.
   *
   * @param id The id of the person, unique to the context and not necessarily globally unique.
   */
  public void setId(String id) {
    this.id = id;
  }

  /**
   * A long-term, persistent, globally unique identifier for this person.
   *
   * @return A long-term, persistent, globally unique identifier for this person.
   */
  public PersistentIdentifier getPersistentId() {
    return persistentId;
  }

  /**
   * A long-term, persistent, globally unique identifier for this person.
   *
   * @param persistentId A long-term, persistent, globally unique identifier for this person.
   */
  public void setPersistentId(PersistentIdentifier persistentId) {
    this.persistentId = persistentId;
  }

  /**
   * The list of alternate ids of the person.
   *
   * @return The list of alternate ids of the person.
   */
  @XmlElement (name="alternateId")
  public List<AlternateId> getAlternateIds() {
    return alternateIds;
  }

  /**
   * The list of alternate ids of the person.
   *
   * @param alternateIds The list of alternate ids of the person.
   */
  public void setAlternateIds(List<AlternateId> alternateIds) {
    this.alternateIds = alternateIds;
  }

  /**
   * The gender of the person.
   *
   * @return The gender of the person.
   */
  public Gender getGender() {
    return gender;
  }

  /**
   * The gender conclusion for the person.
   *
   * @param gender The gender conclusion for the person.
   */
  public void setGender(Gender gender) {
    this.gender = gender;
  }

  /**
   * The name conclusions for the person.
   *
   * @return The name conclusions for the person.
   */
  @XmlElement(name="name")
  public List<Name> getNames() {
    return names;
  }

  /**
   * The name conclusions for the person.
   *
   * @param names The name conclusions for the person.
   */
  public void setNames(List<Name> names) {
    this.names = names;
  }

  /**
   * The event conclusions for the person.
   *
   * @return The event conclusions for the person.
   */
  @XmlElement(name="event")
  public List<Event> getEvents() {
    return events;
  }

  /**
   * The event conclusions for the person.
   *
   * @param events The event conclusions for the person.
   */
  public void setEvents(List<Event> events) {
    this.events = events;
  }

  /**
   * The characteristic conclusions for the person.
   *
   * @return The characteristic conclusions for the person.
   */
  @XmlElement(name="characteristic")
  public List<Characteristic> getCharacteristics() {
    return characteristics;
  }

  /**
   * The characteristic conclusions for the person.
   *
   * @param characteristics The characteristic conclusions for the person.
   */
  public void setCharacteristics(List<Characteristic> characteristics) {
    this.characteristics = characteristics;
  }

  /**
   * The references to the relationships of the person.
   *
   * @return The references to the relationships of the person.
   */
  @XmlElement(name="relationship")
  public List<RelationshipReference> getRelationships() {
    return relationships;
  }

  /**
   * The references to the relationships of the person.
   *
   * @param relationships The references to the relationships of the person.
   */
  public void setRelationships(List<RelationshipReference> relationships) {
    this.relationships = relationships;
  }

  /**
   * The sources for the conclusions about this person.
   *
   * @return The sources for the conclusions about this person.
   */
  @XmlElement(name="source")
  public List<AttributedSourceReference> getSources() {
    return sources;
  }

  /**
   * The sources for the conclusions about this person.
   *
   * @param sources The sources for the conclusions about this person.
   */
  public void setSources(List<AttributedSourceReference> sources) {
    this.sources = sources;
  }
}

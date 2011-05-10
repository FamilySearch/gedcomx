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

import org.gedcomx.attribution.AttributionReference;
import org.gedcomx.id.AlternateId;
import org.gedcomx.id.PersistentIdentifier;
import org.gedcomx.source.AttributedSourceReference;

import javax.xml.bind.annotation.*;
import java.util.Collection;
import java.util.List;

/**
 * A relationship between two or more persons.
 *
 * @author Ryan Heaton
 */
@XmlType (
  propOrder = {"persistentId", "alternateIds", "attribution", "events", "characteristics", "sources"}
)
public abstract class Relationship {

  private String id;
  private PersistentIdentifier persistentId;
  private List<AlternateId> alternateIds;
  private AttributionReference attribution;
  private Collection<Event> events;
  private Collection<Characteristic> characteristics;
  private Collection<AttributedSourceReference> sources;

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
  public PersistentIdentifier getPersistentId() {
    return persistentId;
  }

  /**
   * A long-term, persistent, globally unique identifier for this relationship.
   *
   * @param persistentId A long-term, persistent, globally unique identifier for this relationship.
   */
  public void setPersistentId(PersistentIdentifier persistentId) {
    this.persistentId = persistentId;
  }

  /**
   * The list of alternate ids of the relationship.
   *
   * @return The list of alternate ids of the relationship.
   */
  @XmlElement (name="alternateId")
  public List<AlternateId> getAlternateIds() {
    return alternateIds;
  }

  /**
   * The list of alternate ids of the relationship.
   *
   * @param alternateIds The list of alternate ids of the relationship.
   */
  public void setAlternateIds(List<AlternateId> alternateIds) {
    this.alternateIds = alternateIds;
  }

  /**
   * The link to the attribution metadata for this relationship.
   *
   * @return The link to the attribution metadata for this relationship.
   */
  public AttributionReference getAttribution() {
    return attribution;
  }

  /**
   * The link to the attribution metadata for this relationship.
   *
   * @param attribution The link to the attribution metadata for this relationship.
   */
  public void setAttribution(AttributionReference attribution) {
    this.attribution = attribution;
  }

  /**
   * The event conclusions for the relationship.
   *
   * @return The event conclusions for the relationship.
   */
  @XmlElement(name="event")
  public Collection<Event> getEvents() {
    return events;
  }

  /**
   * The event conclusions for the relationship.
   *
   * @param events The event conclusions for the relationship.
   */
  public void setEvents(Collection<Event> events) {
    this.events = events;
  }

  /**
   * The characteristic conclusions for the relationship.
   *
   * @return The characteristic conclusions for the relationship.
   */
  @XmlElement(name="characteristic")
  public Collection<Characteristic> getCharacteristics() {
    return characteristics;
  }

  /**
   * The characteristic conclusions for the relationship.
   *
   * @param characteristics The characteristic conclusions for the relationship.
   */
  public void setCharacteristics(Collection<Characteristic> characteristics) {
    this.characteristics = characteristics;
  }

  /**
   * The sources for the conclusions about this relationship.
   *
   * @return The sources for the conclusions about this relationship.
   */
  @XmlElement(name="source")
  public Collection<AttributedSourceReference> getSources() {
    return sources;
  }

  /**
   * The sources for the conclusions about this relationship.
   *
   * @param sources The sources for the conclusions about this relationship.
   */
  public void setSources(Collection<AttributedSourceReference> sources) {
    this.sources = sources;
  }

  /**
   * Get the list of person references for this relationship.
   *
   * @return the person references. Note the possibility of null items in the list.
   */
  @XmlTransient
  public abstract List<? extends PersonReference> getPersonReferences();
}

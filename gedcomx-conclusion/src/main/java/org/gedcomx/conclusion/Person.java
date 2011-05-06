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

import org.gedcomx.source.AttributedSourceReference;

import javax.xml.bind.annotation.*;
import java.util.Collection;
import java.util.List;

/**
 * @author Ryan Heaton
 */
@XmlRootElement
@XmlType (
  propOrder = {"alternateIds", "gender", "names", "events", "characteristics", "relationships", "sources"}
)
public class Person {

  private String id;
  private List<AlternateId> alternateIds;
  private Gender gender;
  private Collection<Name> names;
  private Collection<Event> events;
  private Collection<Characteristic> characteristics;
  private Collection<RelationshipReference> relationships;
  private Collection<AttributedSourceReference> sources;

  @XmlID
  @XmlAttribute
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  @XmlElement (name="alternateId")
  public List<AlternateId> getAlternateIds() {
    return alternateIds;
  }

  public void setAlternateIds(List<AlternateId> alternateIds) {
    this.alternateIds = alternateIds;
  }

  public Gender getGender() {
    return gender;
  }

  public void setGender(Gender gender) {
    this.gender = gender;
  }

  public Collection<Name> getNames() {
    return names;
  }

  public void setNames(Collection<Name> names) {
    this.names = names;
  }

  public Collection<Event> getEvents() {
    return events;
  }

  public void setEvents(Collection<Event> events) {
    this.events = events;
  }

  public Collection<Characteristic> getCharacteristics() {
    return characteristics;
  }

  public void setCharacteristics(Collection<Characteristic> characteristics) {
    this.characteristics = characteristics;
  }

  public Collection<RelationshipReference> getRelationships() {
    return relationships;
  }

  public void setRelationships(Collection<RelationshipReference> relationships) {
    this.relationships = relationships;
  }

  public Collection<AttributedSourceReference> getSources() {
    return sources;
  }

  public void setSources(Collection<AttributedSourceReference> sources) {
    this.sources = sources;
  }
}

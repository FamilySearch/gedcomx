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
import org.gedcomx.common.GenealogicalEntity;
import org.gedcomx.common.PersistentIdentifiable;
import org.gedcomx.rt.JsonExtensionElement;
import org.gedcomx.rt.XmlTypeIdResolver;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.List;

/**
 * A person.
 *
 * @author Ryan Heaton
 */
@XmlRootElement
@JsonExtensionElement
@JsonTypeInfo ( use =JsonTypeInfo.Id.CUSTOM, property = XmlTypeIdResolver.TYPE_PROPERTY_NAME)
@JsonTypeIdResolver (XmlTypeIdResolver.class)
@XmlType ( name = "Person", propOrder = { "genders", "names", "events", "characteristics" } )
public class Person extends GenealogicalEntity implements PersistentIdentifiable, HasEvents, HasCharacteristics {

  private List<Gender> genders;
  private List<Name> names;
  private List<Event> events;
  private List<Characteristic> characteristics;

  /**
   * The gender conclusions for the person.
   *
   * @return The gender conclusions for the person.
   */
  @XmlElement(name="gender")
  @JsonProperty("genders")
  @JsonName("genders")
  public List<Gender> getGenders() {
    return genders;
  }

  /**
   * The gender conclusions for the person.
   *
   * @param genders The gender conclusions for the person.
   */
  @JsonProperty("genders")
  public void setGenders(List<Gender> genders) {
    this.genders = genders;
  }

  /**
   * The name conclusions for the person.
   *
   * @return The name conclusions for the person.
   */
  @XmlElement(name="name")
  @JsonProperty("names")
  @JsonName("names")
  public List<Name> getNames() {
    return names;
  }

  /**
   * The name conclusions for the person.
   *
   * @param names The name conclusions for the person.
   */
  @JsonProperty("names")
  public void setNames(List<Name> names) {
    this.names = names;
  }

  /**
   * The event conclusions for the person.
   *
   * @return The event conclusions for the person.
   */
  @XmlElement(name="event")
  @JsonProperty("events")
  @JsonName("events")
  public List<Event> getEvents() {
    return events;
  }

  /**
   * The event conclusions for the person.
   *
   * @param events The event conclusions for the person.
   */
  @JsonProperty("events")
  public void setEvents(List<Event> events) {
    this.events = events;
  }

  /**
   * The characteristic conclusions for the person.
   *
   * @return The characteristic conclusions for the person.
   */
  @XmlElement(name="characteristic")
  @JsonProperty("characteristics")
  @JsonName("characteristics")
  public List<Characteristic> getCharacteristics() {
    return characteristics;
  }

  /**
   * The characteristic conclusions for the person.
   *
   * @param characteristics The characteristic conclusions for the person.
   */
  @JsonProperty("characteristics")
  public void setCharacteristics(List<Characteristic> characteristics) {
    this.characteristics = characteristics;
  }

}

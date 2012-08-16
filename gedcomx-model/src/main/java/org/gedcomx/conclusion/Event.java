/**
 * Copyright 2011-2012 Intellectual Reserve, Inc.
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
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;
import org.gedcomx.common.URI;
import org.gedcomx.rt.json.JsonElementWrapper;
import org.gedcomx.types.EventType;

import javax.xml.bind.annotation.*;
import java.util.List;


/**
 * A historical event.
 *
 * @author Ryan Heaton
 */
@XmlRootElement
@JsonElementWrapper (name = "events")
@XmlType ( name = "Event", propOrder = { "date", "place", "roles" } )
public class Event extends Conclusion implements HasDateAndPlace {

  private URI type;
  private Date date;
  private Place place;
  private List<EventRole> roles;

  /**
   * Create an event.
   */
  public Event() {
  }

  /**
   * Create an event with the passed in type and values.
   *
   * @param EventType the event type.
   */
  public Event(EventType EventType) {
    setKnownType(EventType);
  }

  /**
   * Create a date/place event with the passed in type and values.
   *
   * @param EventType the event type.
   * @param date The date of applicability of this event.
   * @param place The place of applicability of this event.
   */
  public Event(EventType EventType, Date date, Place place) {
    setKnownType(EventType);
    setDate(date);
    setPlace(place);
  }

  /**
   * The type of the event.
   *
   * @return The type of the event.
   */
  @XmlAttribute
  public URI getType() {
    return type;
  }

  /**
   * The type of the event.
   *
   * @param type The type of the event.
   */
  public void setType(URI type) {
    this.type = type;
  }

  /**
   * The enum referencing the known type of the event, or {@link org.gedcomx.types.EventType#OTHER} if not known.
   *
   * @return The enum referencing the known type of the event, or {@link org.gedcomx.types.EventType#OTHER} if not known.
   */
  @XmlTransient
  @JsonIgnore
  public org.gedcomx.types.EventType getKnownType() {
    return getType() == null ? null : EventType.fromQNameURI(getType());
  }

  /**
   * Set the type of this event from a known enumeration of event types.
   *
   * @param knownType the event type.
   */
  @JsonIgnore
  public void setKnownType(org.gedcomx.types.EventType knownType) {
    setType(knownType == null ? null : URI.create(org.codehaus.enunciate.XmlQNameEnumUtil.toURIValue(knownType)));
  }

  /**
   * The date of this event.
   *
   * @return The date of this event.
   */
  @Override
  public Date getDate() {
    return date;
  }

  /**
   * The date of this event.
   *
   * @param date The date of this event.
   */
  @Override
  public void setDate(Date date) {
    this.date = date;
  }

  /**
   * The place of this event.
   *
   * @return The place of this event.
   */
  @Override
  public Place getPlace() {
    return place;
  }

  /**
   * The place of this event.
   *
   * @param place The place of this event.
   */
  @Override
  public void setPlace(Place place) {
    this.place = place;
  }

  /**
   * The roles played in this event.
   *
   * @return The roles played in this event.
   */
  @XmlElement (name="role")
  @JsonProperty ("roles")
  @JsonName ("roles")
  public List<EventRole> getRoles() {
    return roles;
  }

  /**
   * The roles played in this event.
   *
   * @param roles The roles played in this event.
   */
  public void setRoles(List<EventRole> roles) {
    this.roles = roles;
  }

}

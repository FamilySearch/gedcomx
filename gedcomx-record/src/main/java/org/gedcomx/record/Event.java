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

import org.codehaus.enunciate.ClientName;
import org.codehaus.enunciate.XmlQNameEnumUtil;
import org.codehaus.enunciate.qname.XmlQNameEnumRef;
import org.codehaus.jackson.annotate.JsonTypeInfo;
import org.codehaus.jackson.map.annotate.JsonTypeIdResolver;
import org.gedcomx.id.XmlTypeIdResolver;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.namespace.QName;
import java.util.Collection;

/**
 * A recorded event.
 */
@ClientName("EventInfo")
@JsonTypeInfo ( use =JsonTypeInfo.Id.CUSTOM, property = "@type")
@JsonTypeIdResolver (XmlTypeIdResolver.class)
public class Event {

  private String id;
  private QName type;
  private Boolean primary;
  private String description;
  private Date date;
  private Place place;
  private Collection<Characteristic> characteristics;

  /**
   * The id of the event, unique to the context and not necessarily globally unique.
   *
   * @return The id of the event, unique to the context and not necessarily globally unique.
   */
  @XmlID
  @XmlAttribute
  public String getId() {
    return id;
  }

  /**
   * The id of the event, unique to the context and not necessarily globally unique.
   *
   * @param id The id of the event, unique to the context and not necessarily globally unique.
   */
  public void setId(String id) {
    this.id = id;
  }

  /**
   * The type of the event.
   *
   * @return The type of the event.
   */
  @XmlAttribute
  @XmlQNameEnumRef ( org.gedcomx.types.EventType.class)
  public QName getType() {
    return type;
  }

  /**
   * The type of the event.
   *
   * @param type The type of the event.
   */
  public void setType(QName type) {
    this.type = type;
  }

  /**
   * The enum referencing the known type of the event, or {@link org.gedcomx.types.EventType#other} if not known.
   *
   * @return The enum referencing the known type of the event, or {@link org.gedcomx.types.EventType#other} if not known.
   */
  @XmlTransient
  public org.gedcomx.types.EventType getKnownType() {
    return XmlQNameEnumUtil.fromQName(getType(), org.gedcomx.types.EventType.class);
  }

  /**
   * Set the type of this event from a known enumeration of event types.
   *
   * @param knownType the event type.
   */
  public void setKnownType(org.gedcomx.types.EventType knownType) {
    this.type = XmlQNameEnumUtil.toQName(knownType);
  }

  /**
   * Indicator for whether this is the primary event for this record. For example, the primary event for a birth certificate would be the birth event.
   *
   * @return Indicator for whether this is the primary event for this record. For example, the primary event for a birth certificate would be the birth event.
   */
  @XmlAttribute
  public Boolean getPrimary() {
    return primary;
  }

  /**
   * Indicator for whether this is the primary event for this record. For example, the primary event for a birth certificate would be the birth event.
   *
   * @param primary Indicator for whether this is the primary event for this record. For example, the primary event for a birth certificate would be the birth event.
   */
  public void setPrimary(Boolean primary) {
    this.primary = primary;
  }

  /**
   * The description of the event found on the record.
   *
   * @return The description of the event found on the record.
   */
  public String getDescription() {
    return description;
  }

  /**
   * The description of the event found on the record.
   *
   * @param description The description of the event found on the record.
   */
  public void setDescription(String description) {
    this.description = description;
  }

  /**
   * The date of this event.
   *
   * @return The date of this event.
   */
  public Date getDate() {
    return date;
  }

  /**
   * The date of this event.
   *
   * @param date The date of this event.
   */
  public void setDate(Date date) {
    this.date = date;
  }

  /**
   * The place of this event.
   *
   * @return The place of this event.
   */
  public Place getPlace() {
    return place;
  }

  /**
   * The place of this event.
   *
   * @param place The place of this event.
   */
  public void setPlace(Place place) {
    this.place = place;
  }

  /**
   * The characteristic fields on this event.
   *
   * @return The characteristic fields on this event.
   */
  @XmlElement(name="characteristic")
  public Collection<Characteristic> getCharacteristics() {
    return characteristics;
  }

  /**
   * The characteristic fields on this event.
   *
   * @param characteristics The characteristic fields on this event.
   */
  public void setCharacteristics(Collection<Characteristic> characteristics) {
    this.characteristics = characteristics;
  }

}

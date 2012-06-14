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
import org.codehaus.jackson.annotate.JsonTypeInfo;
import org.codehaus.jackson.map.annotate.JsonTypeIdResolver;
import org.gedcomx.common.GenealogicalResource;
import org.gedcomx.common.URI;
import org.gedcomx.rt.CommonModels;
import org.gedcomx.rt.JsonElementWrapper;
import org.gedcomx.rt.XmlTypeIdResolver;
import org.gedcomx.types.FactType;
import org.gedcomx.types.TypeReference;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;

/**
 * A historical event.
 *
 * @author Ryan Heaton
 */
@XmlRootElement
@JsonElementWrapper (name = "events")
@JsonTypeInfo ( use =JsonTypeInfo.Id.CUSTOM, property = XmlTypeIdResolver.TYPE_PROPERTY_NAME)
@JsonTypeIdResolver ( XmlTypeIdResolver.class )
@XmlType ( name = "Event", propOrder = { "type", "date", "place", "roles", "sources" } )
public class Event extends GenealogicalResource implements ReferencesSources {

  @XmlElement (namespace = CommonModels.RDF_NAMESPACE)
  @JsonProperty
  private TypeReference<FactType> type;
  private Date date;
  private Place place;
  private List<EventRole> roles;
  private List<SourceReference> sources;

  /**
   * Create an event.
   */
  public Event() {
  }

  /**
   * Create an event with the passed in type and values.
   *
   * @param FactType the event type.
   */
  public Event(FactType FactType) {
    setKnownType(FactType);
  }

  /**
   * Create a date/place event with the passed in type and values.
   *
   * @param FactType the event type.
   * @param date The date of applicability of this event.
   * @param place The place of applicability of this event.
   */
  public Event(FactType FactType, Date date, Place place) {
    setKnownType(FactType);
    setDate(date);
    setPlace(place);
  }

  /**
   * The type of the event.
   *
   * @return The type of the event.
   */
  @XmlTransient
  @JsonIgnore
  public URI getType() {
    return this.type == null ? null : this.type.getType();
  }

  /**
   * The type of the event.
   *
   * @param type The type of the event.
   */
  @JsonIgnore
  public void setType(URI type) {
    this.type = type == null ? null : new TypeReference<FactType>(type);
  }

  /**
   * The enum referencing the known type of the event, or {@link org.gedcomx.types.FactType#OTHER} if not known.
   *
   * @return The enum referencing the known type of the event, or {@link org.gedcomx.types.FactType#OTHER} if not known.
   */
  @XmlTransient
  @JsonIgnore
  public org.gedcomx.types.FactType getKnownType() {
    return this.type == null ? null : FactType.fromQNameURI(this.type.getType());
  }

  /**
   * Set the type of this event from a known enumeration of event types.
   *
   * @param knownType the event type.
   */
  @JsonIgnore
  public void setKnownType(org.gedcomx.types.FactType knownType) {
    this.type = knownType == null ? null : new TypeReference<FactType>(knownType);
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

  /**
   * The source references for this event.
   *
   * @return The source references for this event.
   */
  @XmlElement (name="source")
  @JsonProperty ("sources")
  @JsonName ("sources")
  public List<SourceReference> getSources() {
    return sources;
  }

  /**
   * The source references for this event.
   *
   * @param sources The source references for this event.
   */
  @JsonProperty("sources")
  public void setSources(List<SourceReference> sources) {
    this.sources = sources;
  }

  /**
   * Add a sourceReference.
   *
   * @param sourceReference The sourceReference to be added.
   */
  public void addSource(SourceReference sourceReference) {
    if (sourceReference != null) {
      if (sources == null) {
        sources = new ArrayList<SourceReference>();
      }
      sources.add(sourceReference);
    }
  }

}

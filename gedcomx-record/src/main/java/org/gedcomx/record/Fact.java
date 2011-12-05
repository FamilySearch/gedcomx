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
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonTypeInfo;
import org.codehaus.jackson.map.annotate.JsonTypeIdResolver;
import org.gedcomx.common.GenealogicalResource;
import org.gedcomx.rt.CommonModels;
import org.gedcomx.rt.RDFSubClassOf;
import org.gedcomx.rt.RDFSubPropertyOf;
import org.gedcomx.rt.XmlTypeIdResolver;
import org.gedcomx.types.FactType;
import org.gedcomx.types.TypeReference;
import org.gedcomx.types.Typed;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

/**
 * A recorded event.
 */
@JsonTypeInfo ( use =JsonTypeInfo.Id.CUSTOM, property = XmlTypeIdResolver.TYPE_PROPERTY_NAME)
@JsonTypeIdResolver (XmlTypeIdResolver.class)
@XmlType( name = "Fact", propOrder = { "type", "date", "place", "value" } )
@RDFSubClassOf ( CommonModels.DUBLIN_CORE_TYPE_NAMESPACE + "Event" )
public class Fact extends GenealogicalResource implements Typed<FactType> {

  private TypeReference<FactType> type;
  private Boolean primary;
  private Date date;
  private Place place;
  private Field value;

  /**
   * The type of the event.
   *
   * @return The type of the event.
   */
  @XmlElement (namespace = CommonModels.RDF_NAMESPACE)
  public TypeReference<FactType> getType() {
    return type;
  }

  /**
   * The type of the event.
   *
   * @param type The type of the event.
   */
  public void setType(TypeReference<FactType> type) {
    this.type = type;
  }

  /**
   * The enum referencing the known type of the event, or {@link org.gedcomx.types.FactType#OTHER} if not known.
   *
   * @return The enum referencing the known type of the event, or {@link org.gedcomx.types.FactType#OTHER} if not known.
   */
  @XmlTransient
  @JsonIgnore
  public org.gedcomx.types.FactType getKnownType() {
    return getType() == null ? null : XmlQNameEnumUtil.fromURI(getType().getType(), org.gedcomx.types.FactType.class);
  }

  /**
   * Set the type of this event from a known enumeration of event types.
   *
   * @param knownType the event type.
   */
  @JsonIgnore
  public void setKnownType(org.gedcomx.types.FactType knownType) {
    setType(knownType == null ? null : new TypeReference<FactType>(knownType));
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
   * The date of this event.
   *
   * @return The date of this event.
   */
  @RDFSubPropertyOf ( CommonModels.DUBLIN_CORE_NAMESPACE + "temporal" )
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
  @RDFSubPropertyOf ( CommonModels.DUBLIN_CORE_NAMESPACE + "spatial" )
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
   * The value of a fact, if applicable.
   *
   * @return The value of a fact.
   */
  public Field getValue() {
    return value;
  }

  /**
   * The value of a fact, if applicable.
   *
   * @param value The value of a fact, if applicable.
   */
  public void setValue(Field value) {
    this.value = value;
  }
}

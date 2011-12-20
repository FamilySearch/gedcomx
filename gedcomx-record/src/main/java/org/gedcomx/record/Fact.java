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
 * A recorded fact.
 */
@JsonTypeInfo ( use =JsonTypeInfo.Id.CUSTOM, property = XmlTypeIdResolver.TYPE_PROPERTY_NAME)
@JsonTypeIdResolver (XmlTypeIdResolver.class)
@XmlType( name = "Fact", propOrder = { "type", "date", "place" } )
@RDFSubClassOf ( CommonModels.DUBLIN_CORE_TYPE_NAMESPACE + "Event" )
public class Fact extends Field implements Typed<FactType> {

  private TypeReference<FactType> type;
  private Boolean primary;
  private Date date;
  private Place place;

  /**
   * The type of the fact.
   *
   * @return The type of the fact.
   */
  @XmlElement (namespace = CommonModels.RDF_NAMESPACE)
  public TypeReference<FactType> getType() {
    return type;
  }

  /**
   * The type of the fact.
   *
   * @param type The type of the fact.
   */
  public void setType(TypeReference<FactType> type) {
    this.type = type;
  }

  /**
   * The enum referencing the known type of the fact, or {@link org.gedcomx.types.FactType#OTHER} if not known.
   *
   * @return The enum referencing the known type of the fact, or {@link org.gedcomx.types.FactType#OTHER} if not known.
   */
  @XmlTransient
  @JsonIgnore
  public org.gedcomx.types.FactType getKnownType() {
    return getType() == null ? null : FactType.fromQNameURI(getType().getType());
  }

  /**
   * Set the type of this fact from a known enumeration of fact types.
   *
   * @param knownType the fact type.
   */
  @JsonIgnore
  public void setKnownType(org.gedcomx.types.FactType knownType) {
    setType(knownType == null ? null : new TypeReference<FactType>(knownType));
  }

  /**
   * Indicator for whether this is a primary fact for this record. For example, the primary fact for a birth certificate would be the birth fact.
   *
   * @return Indicator for whether this is a primary fact for this record. For example, the primary fact for a birth certificate would be the birth fact.
   */
  @XmlAttribute
  public Boolean getPrimary() {
    return primary;
  }

  /**
   * Indicator for whether this is the primary fact for this record. For example, the primary fact for a birth certificate would be the birth fact.
   *
   * @param primary Indicator for whether this is the primary fact for this record. For example, the primary fact for a birth certificate would be the birth fact.
   */
  public void setPrimary(Boolean primary) {
    this.primary = primary;
  }

  /**
   * The applicable date of this fact, if any.
   *
   * @return The applicable date of this fact, if any.
   */
  @RDFSubPropertyOf ( CommonModels.DUBLIN_CORE_NAMESPACE + "temporal" )
  public Date getDate() {
    return date;
  }

  /**
   * The applicable date of this fact, if any.
   *
   * @param date The applicable date of this fact, if any.
   */
  public void setDate(Date date) {
    this.date = date;
  }

  /**
   * The applicable place of this fact, if any.
   *
   * @return The applicable place of this fact, if any.
   */
  @RDFSubPropertyOf ( CommonModels.DUBLIN_CORE_NAMESPACE + "spatial" )
  public Place getPlace() {
    return place;
  }

  /**
   * The applicable place of this fact, if any.
   *
   * @param place The applicable place of this fact, if any.
   */
  public void setPlace(Place place) {
    this.place = place;
  }

}

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

import org.codehaus.enunciate.XmlQNameEnumUtil;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonTypeInfo;
import org.codehaus.jackson.map.annotate.JsonTypeIdResolver;
import org.gedcomx.common.FormalValue;
import org.gedcomx.rt.CommonModels;
import org.gedcomx.rt.JsonElementWrapper;
import org.gedcomx.rt.RDFSubClassOf;
import org.gedcomx.rt.XmlTypeIdResolver;
import org.gedcomx.types.FactType;
import org.gedcomx.types.TypeReference;
import org.gedcomx.types.Typed;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

/**
 * A conclusion about a fact applicable to a person or relationship.
 */
@JsonTypeInfo ( use =JsonTypeInfo.Id.CUSTOM, property = XmlTypeIdResolver.TYPE_PROPERTY_NAME)
@JsonTypeIdResolver (XmlTypeIdResolver.class)
@XmlType ( name = "Fact", propOrder = {"type", "date", "place", "original", "formal" })
@RDFSubClassOf ( CommonModels.DUBLIN_CORE_TYPE_NAMESPACE + "Event" )
@XmlRootElement
@JsonElementWrapper ( name = "facts" )
public class Fact extends Conclusion implements Typed<FactType>, Formalizeable {

  private TypeReference<FactType> type;
  private Date date;
  private Place place;
  private String original;
  private FormalValue formal;

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
  public FactType getKnownType() {
    return getType() == null ? null : FactType.fromQNameURI(getType().getType());
  }

  /**
   * Set the type of this fact from a known enumeration of types.
   *
   * @param knownType The known type.
   */
  @JsonIgnore
  public void setKnownType(FactType knownType) {
    setType(knownType == null ? null : new TypeReference<FactType>(knownType));
  }

  /**
   * The date of applicability of this fact.
   *
   * @return The date of applicability of this fact.
   */
  public Date getDate() {
    return date;
  }

  /**
   * The date of applicability of this fact.
   *
   * @param date The date of applicability of this fact.
   */
  public void setDate(Date date) {
    this.date = date;
  }

  /**
   * The place of applicability of this fact.
   *
   * @return The place of applicability of this fact.
   */
  public Place getPlace() {
    return place;
  }

  /**
   * The place of applicability of this fact.
   *
   * @param place The place of applicability of this fact.
   */
  public void setPlace(Place place) {
    this.place = place;
  }

  /**
   * The original text as supplied by the user.
   *
   * @return The original text as supplied by the user.
   */
  @Override
  public String getOriginal() {
    return original;
  }

  /**
   * The original value as supplied by the user.
   *
   * @param original The original value as supplied by the user.
   */
  @Override
  public void setOriginal(String original) {
    this.original = original;
  }

  /**
   * The formal value.
   *
   * @return The formal value.
   */
  @Override
  public FormalValue getFormal() {
    return formal;
  }

  /**
   * The formal value.
   *
   * @param formal The formal value.
   */
  @Override
  public void setFormal(FormalValue formal) {
    this.formal = formal;
  }
}

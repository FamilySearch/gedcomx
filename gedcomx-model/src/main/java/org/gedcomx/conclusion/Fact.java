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

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;
import org.gedcomx.common.TypeReference;
import org.gedcomx.common.URI;
import org.gedcomx.rt.json.JsonElementWrapper;
import org.gedcomx.types.FactType;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

/**
 * A conclusion about a fact applicable to a person or relationship.
 */
@XmlType ( name = "Fact", propOrder = {"type", "date", "place", "original", "formal" })
@XmlRootElement
@JsonElementWrapper ( name = "facts" )
public class Fact extends Conclusion implements Formalizeable, HasDateAndPlace {

  @XmlElement
  @JsonProperty
  private TypeReference<FactType> type;
  private Date date;
  private Place place;
  private String original;
  private FormalValue formal;

  /**
   * Create a fact.
   */
  public Fact() {
  }

  /**
   * Create a fact with the passed in type and values.
   *
   * @param factType the fact type.
   * @param original The original value as supplied by the user.
   */
  public Fact(FactType factType, String original) {
    setKnownType(factType);
    setOriginal(original);
  }

  /**
   * Create a date/place fact with the passed in type and values.
   *
   * @param factType the fact type.
   * @param date The date of applicability of this fact.
   * @param place The place of applicability of this fact.
   * @param original The original value as supplied by the user.
   */
  public Fact(FactType factType, Date date, Place place, String original) {
    setKnownType(factType);
    setDate(date);
    setPlace(place);
    setOriginal(original);
  }

  /**
   * The type of the fact.
   *
   * @return The type of the fact.
   */
  @XmlTransient
  @JsonIgnore
  public URI getType() {
    return this.type == null ? null : this.type.getType();
  }

  /**
   * The type of the fact.
   *
   * @param type The type of the fact.
   */
  @JsonIgnore
  public void setType(URI type) {
    this.type = type == null ? null : new TypeReference<FactType>(type);
  }

  /**
   * The enum referencing the known type of the fact, or {@link org.gedcomx.types.FactType#OTHER} if not known.
   *
   * @return The enum referencing the known type of the fact, or {@link org.gedcomx.types.FactType#OTHER} if not known.
   */
  @XmlTransient
  @JsonIgnore
  public org.gedcomx.types.FactType getKnownType() {
    return this.type == null ? null : FactType.fromQNameURI(this.type.getType());
  }

  /**
   * Set the type of this fact from a known enumeration of fact types.
   *
   * @param knownType the fact type.
   */
  @JsonIgnore
  public void setKnownType(org.gedcomx.types.FactType knownType) {
    this.type = knownType == null ? null : new TypeReference<FactType>(knownType);
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

  @Override
  public String toString() {
    return "type=" + getKnownType() + ",orig=" + getOriginal() + ",date=" + getDate() + ",place=" + getPlace();
  }
}

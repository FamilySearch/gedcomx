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
import org.gedcomx.rt.JsonElementWrapper;
import org.gedcomx.rt.XmlTypeIdResolver;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;

/**
 * A person.
 *
 * @author Ryan Heaton
 */
@XmlRootElement
@JsonElementWrapper (name = "persons")
@JsonTypeInfo ( use =JsonTypeInfo.Id.CUSTOM, property = XmlTypeIdResolver.TYPE_PROPERTY_NAME)
@JsonTypeIdResolver (XmlTypeIdResolver.class)
@XmlType ( name = "Person", propOrder = { "living", "genders", "names", "facts" } )
public class Person extends GenealogicalEntity implements PersistentIdentifiable, HasFacts {

  private Boolean living;
  private List<Gender> genders;
  private List<Name> names;
  private List<Fact> facts;

  /**
   * Living status of the person as treated by the system. The value of this property is intended
   * to be based on a system-specific calculation and therefore has limited portability. Conclusions
   * about the living status of a person can be modeled with a fact.
   *
   * @return Living status of the person as treated by the system.
   */
  public Boolean getLiving() {
    return living;
  }

  /**
   * Living status of the person as treated by the system. The value of this property is intended
   * to be based on a system-specific calculation and therefore has limited portability. Conclusions
   * about the living status of a person can be modeled with a fact.
   *
   * @param living Living status of the person as treated by the system.
   */
  public void setLiving(Boolean living) {
    this.living = living;
  }

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
   * The fact conclusions for the person.
   *
   * @return The fact conclusions for the person.
   */
  @XmlElement(name="fact")
  @JsonProperty("facts")
  @JsonName("facts")
  public List<Fact> getFacts() {
    return facts;
  }

  /**
   * The fact conclusions for the person.
   *
   * @param facts The fact conclusions for the person.
   */
  @JsonProperty("facts")
  public void setFacts(List<Fact> facts) {
    this.facts = facts;
  }

  /**
   * Add a fact conclusion to the person.
   *
   * @param fact The fact conclusion to be added.
   */
  public void addFact(Fact fact) {
    if(facts == null) {
      facts = new ArrayList<Fact>();
    }
    facts.add(fact);
  }
}

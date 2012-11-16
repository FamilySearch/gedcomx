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

import org.gedcomx.common.ExtensibleData;

import javax.xml.bind.annotation.XmlType;


/**
 * A set of display properties for the convenience of quick display, such as for
 * a Web-based application. All display properties are provided in the default locale for the current
 * application context and are NOT considered canonical for the purposes of data exchange.
 */
@XmlType ( name = "DisplayProperties" )
public class DisplayProperties extends ExtensibleData {

  private String name;
  private String gender;
  private String lifespan;
  private String birthDate;
  private String birthPlace;
  private String deathDate;
  private String deathPlace;
  private String ascendancyNumber;
  private String descendancyNumber;

  /**
   * The displayable name of the person.
   *
   * @return The displayable name of the person.
   */
  public String getName() {
    return name;
  }

  /**
   * The displayable name of the person.
   *
   * @param name The displayable name of the person.
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * The displayable label for the gender of the person.
   *
   * @return The displayable label for the gender of the person.
   */
  public String getGender() {
    return gender;
  }

  /**
   * Displayable form of the gender.
   *
   * @param gender Displayable form of the gender.
   */
  public void setGender(String gender) {
    this.gender = gender;
  }

  /**
   * The displayable label for the lifespan of the person.
   *
   * @return The displayable label for the lifespan of the person.
   */
  public String getLifespan() {
    return lifespan;
  }

  /**
   * The displayable label for the lifespan of the person.
   *
   * @param lifespan The displayable label for the lifespan of the person.
   */
  public void setLifespan(String lifespan) {
    this.lifespan = lifespan;
  }

  /**
   * The displayable label for the birth date of the person.
   * 
   * @return The displayable label for the birth date of the person.
   */
  public String getBirthDate() {
    return birthDate;
  }

  /**
   * The displayable label for the birth date of the person.
   * 
   * @param birthDate The displayable label for the birth date of the person.
   */
  public void setBirthDate(String birthDate) {
    this.birthDate = birthDate;
  }

  /**
   * The displayable label for the birth place of the person.
   * 
   * @return The displayable label for the birth place of the person.
   */
  public String getBirthPlace() {
    return birthPlace;
  }

  /**
   * The displayable label for the birth place of the person.
   * 
   * @param birthPlace The displayable label for the birth place of the person.
   */
  public void setBirthPlace(String birthPlace) {
    this.birthPlace = birthPlace;
  }

  /**
   * The displayable label for the death date of the person.
   * 
   * @return The displayable label for the death date of the person.
   */
  public String getDeathDate() {
    return deathDate;
  }

  /**
   * The displayable label for the death date of the person.
   * 
   * @param deathDate The displayable label for the death date of the person.
   */
  public void setDeathDate(String deathDate) {
    this.deathDate = deathDate;
  }

  /**
   * The displayable label for the death place of the person.
   * 
   * @return The displayable label for the death place of the person.
   */
  public String getDeathPlace() {
    return deathPlace;
  }

  /**
   * The displayable label for the death place of the person.
   * 
   * @param deathPlace The displayable label for the death place of the person.
   */
  public void setDeathPlace(String deathPlace) {
    this.deathPlace = deathPlace;
  }

  /**
   * The context-specific ascendancy number for the person in relation to the other persons in the request. The ancestry number is defined using the Ahnentafel numbering system.
   *
   * @return The context-specific ascendancy number for the person in relation to the other persons in the request. The ancestry number is defined using the Ahnentafel numbering system.
   */
  public String getAscendancyNumber() {
    return ascendancyNumber;
  }

  /**
   * The context-specific ascendancy number for the person in relation to the other persons in the request. The ancestry number is defined using the Ahnentafel numbering system.
   *
   * @param ascendancyNumber The context-specific ascendancy number for the person in relation to the other persons in the request. The ancestry number is defined using the Ahnentafel numbering system.
   */
  public void setAscendancyNumber(String ascendancyNumber) {
    this.ascendancyNumber = ascendancyNumber;
  }

  /**
   * The context-specific descendancy number for the person in relation to the other persons in the request. The descendancy number is defined using the d'Aboville numbering system.
   *
   * @return The context-specific descendancy number for the person in relation to the other persons in the request. The descendancy number is defined using the d'Aboville numbering system.
   */
  public String getDescendancyNumber() {
    return descendancyNumber;
  }

  /**
   * The context-specific descendancy number for the person in relation to the other persons in the request. The descendancy number is defined using the d'Aboville numbering system.
   *
   * @param descendancyNumber The context-specific descendancy number for the person in relation to the other persons in the request. The descendancy number is defined using the d'Aboville numbering system.
   */
  public void setDescendancyNumber(String descendancyNumber) {
    this.descendancyNumber = descendancyNumber;
  }
}

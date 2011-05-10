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
import org.gedcomx.types.RelationshipRole;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.namespace.QName;
import java.util.ArrayList;
import java.util.List;

/**
 * A recorded relationship.
 */
public abstract class Relationship {

  //todo: why are we even subclassing relationship?

  private String id;
  private QName role1;
  protected Persona persona1;
  private QName role2;
  protected Persona persona2;
  private List<Characteristic> characteristics = new ArrayList<Characteristic>();

  /**
   * The id of the relationship, unique to the context and not necessarily globally unique.
   *
   * @return The id of the relationship, unique to the context and not necessarily globally unique.
   */
  @XmlID
  @XmlAttribute
  public String getId() {
    return id;
  }

  /**
   * The id of the relationship, unique to the context and not necessarily globally unique.
   *
   * @param id The id of the relationship, unique to the context and not necessarily globally unique.
   */
  public void setId(String id) {
    this.id = id;
  }

  /**
   * A persona in the relationship. The name "persona1" is used only to distinguish it from
   * the other persona in this relationship and implies neither order nor role.
   *
   * @return A persona in the relationship. The name "persona1" is used only to distinguish it from
   * the other persona in this relationship and implies neither order nor role.
   */
  @XmlTransient
  public Persona getPersona1() {
    return this.persona1;
  }

  /**
   * A persona in the relationship. The name "persona1" is used only to distinguish it from
   * the other persona in this relationship and implies neither order nor role.
   *
   * @param persona1 A persona in the relationship. The name "persona1" is used only to distinguish it from
   * the other persona in this relationship and implies neither order nor role.
   */
  public void setPersona1(Persona persona1) {
    this.persona1 = persona1;
  }

  /**
   * The role of the persona1 of this relationship.
   *
   * @return The role of the persona1 of this relationship.
   */
  @XmlTransient
  public QName getRole1() {
    return this.role1;
  }

  /**
   * The role of the persona1 of this relationship.
   *
   * @param role1 The role of the persona1 of this relationship.
   */
  public void setRole1(QName role1) {
    this.role1 = role1;
  }

  /**
   * The enum referencing the known role1, or {@link org.gedcomx.types.RelationshipRole#other} if not known.
   *
   * @return The enum referencing the known role1, or {@link org.gedcomx.types.RelationshipRole#other} if not known.
   */
  @XmlTransient
  public RelationshipRole getKnownRole1() {
    return XmlQNameEnumUtil.fromQName(getRole1(), RelationshipRole.class);
  }

  /**
   * Set the role1 from an enumeration of known roles.
   *
   * @param role The role.
   */
  public void setKnownRole1(RelationshipRole role) {
    this.role1 = XmlQNameEnumUtil.toQName(role);
  }

  /**
   * A persona in the relationship. The name "persona2" is used only to distinguish it from
   * the other persona in this relationship and implies neither order nor role.
   *
   * @return A persona in the relationship. The name "persona2" is used only to distinguish it from
   * the other persona in this relationship and implies neither order nor role.
   */
  @XmlTransient
  public Persona getPersona2() {
    return this.persona2;
  }

  /**
   * A persona in the relationship. The name "persona2" is used only to distinguish it from
   * the other persona in this relationship and implies neither order nor role.
   *
   * @param persona2 A persona in the relationship. The name "persona2" is used only to distinguish it from
   * the other persona in this relationship and implies neither order nor role.
   */
  public void setPersona2(Persona persona2) {
    this.persona2 = persona2;
  }

  /**
   * The role of the persona2 of this relationship.
   *
   * @return The role of the persona2 of this relationship.
   */
  @XmlTransient
  public QName getRole2() {
    return this.role2;
  }

  /**
   * The role of the persona2 of this relationship.
   *
   * @param role2 The role of the persona2 of this relationship.
   */
  public void setRole2(QName role2) {
    this.role2 = role2;
  }

  /**
   * The enum referencing the known role2, or {@link org.gedcomx.types.RelationshipRole#other} if not known.
   *
   * @return The enum referencing the known role2, or {@link org.gedcomx.types.RelationshipRole#other} if not known.
   */
  @XmlTransient
  public RelationshipRole getKnownRole2() {
    return XmlQNameEnumUtil.fromQName(getRole2(), RelationshipRole.class);
  }

  /**
   * Set the role2 from an enumeration of known roles.
   *
   * @param role The role.
   */
  public void setKnownRole2(RelationshipRole role) {
    this.role2 = XmlQNameEnumUtil.toQName(role);
  }

  /**
   * The characteristic fields of the relationship.
   *
   * @return The characteristic fields of the relationship.
   */
  @XmlElement(name = "characteristic")
  public List<Characteristic> getCharacteristics() {
    return characteristics;
  }

  /**
   * The characteristic fields of the relationship.
   *
   * @param characteristics The characteristic fields of the relationship.
   */
  public void setCharacteristics(List<Characteristic> characteristics) {
    this.characteristics = characteristics;
  }

}

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
import org.codehaus.enunciate.qname.XmlQNameEnumRef;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonTypeInfo;
import org.codehaus.jackson.map.annotate.JsonTypeIdResolver;
import org.gedcomx.id.XmlTypeIdResolver;
import org.gedcomx.types.RelationshipType;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.namespace.QName;

/**
 * A basic relationship between two people, used to model basic relationships that are neither couple nor parent-child relationships.
 */
@JsonTypeInfo ( use =JsonTypeInfo.Id.CUSTOM, property = "@type")
@JsonTypeIdResolver (XmlTypeIdResolver.class)
public class OtherRelationship extends Relationship {

  @JsonProperty("type")
  private QName type;
  private PersonaReference persona1;
  private PersonaReference persona2;

  /**
   * The type of this relationship.
   *
   * @return The type of this relationship.
   */
  @Override
  @XmlAttribute
  @XmlQNameEnumRef(RelationshipType.class)
  @JsonIgnore
  public QName getType() {
    return type;
  }

  /**
   * The type of this relationship.
   *
   * @param type The type of this relationship.
   */
  @JsonIgnore
  public void setType(QName type) {
    this.type = type;
  }

  /**
   * The enum referencing the known type of the relationship, or {@link org.gedcomx.types.RelationshipType#other} if not known.
   *
   * @return The enum referencing the known type of the relationship, or {@link org.gedcomx.types.RelationshipType#other} if not known.
   */
  @XmlTransient
  public RelationshipType getKnownRelationshipType() {
    return XmlQNameEnumUtil.fromQName(getType(), RelationshipType.class);
  }

  /**
   * Set the relationship type from a known enumeration of relationship types.
   *
   * @param type The relationship type.
   */
  public void setKnownRelationshipType(RelationshipType type) {
    this.type = XmlQNameEnumUtil.toQName(type);
  }

  /**
   * A persona in the relationship. The name "persona1" is used only to distinguish it from
   * the other persona in this relationship. When the relationship type implies direction, it
   * goes from "persona1" to "persona2".
   * 
   * @return A persona in the relationship. The name "persona1" is used only to distinguish it from
   * the other persona in this relationship. When the relationship type implies direction, it
   * goes from "persona1" to "persona2".
   */
  public PersonaReference getPersona1() {
    return this.persona1;
  }

  /**
   * A persona in the relationship. The name "persona1" is used only to distinguish it from
   * the other persona in this relationship. When the relationship type implies direction, it
   * goes from "persona1" to "persona2".
   *
   * @param persona1 A persona in the relationship. The name "persona1" is used only to distinguish it from
   * the other persona in this relationship. When the relationship type implies direction, it
   * goes from "persona1" to "persona2".
   */
  public void setPersona1(PersonaReference persona1) {
    this.persona1 = persona1;
  }

  /**
   * A persona in the relationship. The name "persona2" is used only to distinguish it from
   * the other persona in this relationship. When the relationship type implies direction, it
   * goes from "persona1" to "persona2".
   * 
   * @return A persona in the relationship. The name "persona2" is used only to distinguish it from
   * the other persona in this relationship. When the relationship type implies direction, it
   * goes from "persona1" to "persona2".
   */
  public PersonaReference getPersona2() {
    return this.persona2;
  }

  /**
   * A persona in the relationship. The name "persona2" is used only to distinguish it from
   * the other persona in this relationship. When the relationship type implies direction, it
   * goes from "persona1" to "persona2".
   *
   * @param persona2 A persona in the relationship. The name "persona2" is used only to distinguish it from
   * the other persona in this relationship. When the relationship type implies direction, it
   * goes from "persona1" to "persona2".
   */
  public void setPersona2(PersonaReference persona2) {
    this.persona2 = persona2;
  }

}

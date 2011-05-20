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

import org.codehaus.jackson.annotate.JsonTypeInfo;
import org.codehaus.jackson.map.annotate.JsonTypeIdResolver;
import org.gedcomx.id.XmlTypeIdResolver;
import org.gedcomx.types.RelationshipType;

import javax.xml.bind.annotation.XmlTransient;

/**
 * A relationship between two personas, making a genealogical "couple".
 */
@JsonTypeInfo ( use =JsonTypeInfo.Id.CUSTOM, property = "@type")
@JsonTypeIdResolver (XmlTypeIdResolver.class)
public class CoupleRelationship extends Relationship {

  private PersonaReference persona1;
  private PersonaReference persona2;

  /**
   * A persona in the relationship. The name "persona1" is used only to distinguish it from
   * the other persona in this relationship and implies neither order nor role.
   * 
   * @return A persona in the relationship. The name "persona1" is used only to distinguish it from
   * the other persona in this relationship and implies neither order nor role.
   */
  public PersonaReference getPersona1() {
    return this.persona1;
  }

  /**
   * Reference to a persona in the relationship. The name "persona1" is used only to distinguish it from
   * the other persona in this relationship and implies neither order nor role.
   *
   * @param persona1 A persona in the relationship. The name "persona1" is used only to distinguish it from
   * the other persona in this relationship and implies neither order nor role.
   */
  public void setPersona1(PersonaReference persona1) {
    this.persona1 = persona1;
  }

  /**
   * Reference to a persona in the relationship. The name "persona2" is used only to distinguish it from
   * the other persona in this relationship and implies neither order nor role.
   * 
   * @return A persona in the relationship. The name "persona2" is used only to distinguish it from
   * the other persona in this relationship and implies neither order nor role.
   */
  public PersonaReference getPersona2() {
    return this.persona2;
  }

  /**
   * A persona in the relationship. The name "persona2" is used only to distinguish it from
   * the other persona in this relationship and implies neither order nor role.
   *
   * @param persona2 A persona in the relationship. The name "persona2" is used only to distinguish it from
   * the other persona in this relationship and implies neither order nor role.
   */
  public void setPersona2(PersonaReference persona2) {
    this.persona2 = persona2;
  }

  @XmlTransient
  @Override
  public RelationshipType getKnownRelationshipType() {
    return RelationshipType.couple;
  }
}

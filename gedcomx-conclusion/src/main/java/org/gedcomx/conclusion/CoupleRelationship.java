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

import org.codehaus.jackson.annotate.JsonTypeInfo;
import org.codehaus.jackson.map.annotate.JsonTypeIdResolver;
import org.gedcomx.rt.XmlTypeIdResolver;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * A relationship between two persons, making a genealogical "couple".
 */
@XmlRootElement
@JsonTypeInfo ( use =JsonTypeInfo.Id.CUSTOM, property = "@type")
@JsonTypeIdResolver (XmlTypeIdResolver.class)
public class CoupleRelationship extends Relationship {

  private PersonReference person1;
  private PersonReference person2;

  /**
   * A reference to a person in the relationship. The name "person1" is used only to distinguish it from
   * the other person in this relationship and implies neither order nor role.
   * 
   * @return A reference to a person in the relationship. The name "person1" is used only to distinguish it from
   * the other person in this relationship and implies neither order nor role.
   */
  public PersonReference getPerson1() {
    return person1;
  }

  /**
   * A reference to a person in the relationship. The name "person1" is used only to distinguish it from
   * the other person in this relationship and implies neither order nor role.
   * 
   * @param person1 A reference to a person in the relationship. The name "person1" is used only to distinguish it from
   * the other person in this relationship and implies neither order nor role.
   */
  public void setPerson1(PersonReference person1) {
    this.person1 = person1;
  }

  /**
   * A reference to a person in the relationship. The name "person2" is used only to distinguish it from
   * the other person in this relationship and implies neither order nor role.
   * 
   * @return A reference to a person in the relationship. The name "person2" is used only to distinguish it from
   * the other person in this relationship and implies neither order nor role.
   */
  public PersonReference getPerson2() {
    return person2;
  }

  /**
   * A reference to a person in the relationship. The name "person2" is used only to distinguish it from
   * the other person in this relationship and implies neither order nor role.
   * 
   * @param person2 A reference to a person in the relationship. The name "person2" is used only to distinguish it from
   * the other person in this relationship and implies neither order nor role.
   */
  public void setPerson2(PersonReference person2) {
    this.person2 = person2;
  }

}

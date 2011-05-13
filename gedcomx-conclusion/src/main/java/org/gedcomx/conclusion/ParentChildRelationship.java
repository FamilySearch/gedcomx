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
import org.gedcomx.id.XmlTypeIdResolver;

import javax.xml.bind.annotation.XmlTransient;
import java.util.Arrays;
import java.util.List;

/**
 * A relationship between a child and two parents.
 *
 * @author Ryan Heaton
 */
@JsonTypeInfo ( use =JsonTypeInfo.Id.CUSTOM, property = "@type")
@JsonTypeIdResolver (XmlTypeIdResolver.class)
public class ParentChildRelationship extends Relationship {

  private PersonReference parent1;
  private Lineage parent1Lineage;
  private PersonReference parent2;
  private Lineage parent2Lineage;
  private PersonReference child;

  /**
   * A reference to a parent in this relationship. The name "parent1" is used only to distinguish it from
   * the other parent in this relationship and implies neither order nor role.
   *
   * @return A reference to a parent in this relationship. The name "parent1" is used only to distinguish it from
   * the other parent in this relationship and implies neither order nor role.
   */
  public PersonReference getParent1() {
    return parent1;
  }

  /**
   * A reference to a parent in this relationship. The name "parent1" is used only to distinguish it from
   * the other parent in this relationship and implies neither order nor role.
   *
   * @param parent1 A reference to a parent in this relationship. The name "parent1" is used only to distinguish it from
   * the other parent in this relationship and implies neither order nor role.
   */
  public void setParent1(PersonReference parent1) {
    this.parent1 = parent1;
  }

  /**
   * The conclusion about the lineage of the parent1 in this relationship.
   *
   * @return The conclusion about the lineage of the parent1 in this relationship.
   */
  public Lineage getParent1Lineage() {
    return parent1Lineage;
  }

  /**
   * The conclusion about the lineage of the parent1 in this relationship.
   *
   * @param parent1Lineage The conclusion about the lineage of the parent1 in this relationship.
   */
  public void setParent1Lineage(Lineage parent1Lineage) {
    this.parent1Lineage = parent1Lineage;
  }

  /**
   * A reference to a parent in this relationship. The name "parent2" is used only to distinguish it from
   * the other parent in this relationship and implies neither order nor role.
   *
   * @return A reference to a parent in this relationship. The name "parent2" is used only to distinguish it from
   * the other parent in this relationship and implies neither order nor role.
   */
  public PersonReference getParent2() {
    return parent2;
  }

  /**
   * A reference to a parent in this relationship. The name "parent2" is used only to distinguish it from
   * the other parent in this relationship and implies neither order nor role.
   *
   * @param parent2 A reference to a parent in this relationship. The name "parent2" is used only to distinguish it from
   * the other parent in this relationship and implies neither order nor role.
   */
  public void setParent2(PersonReference parent2) {
    this.parent2 = parent2;
  }

  /**
   * The conclusion about the lineage of the parent2 in this relationship.
   *
   * @return The conclusion about the lineage of the parent2 in this relationship.
   */
  public Lineage getParent2Lineage() {
    return parent2Lineage;
  }

  /**
   * The conclusion about the lineage of the parent2 in this relationship.
   *
   * @param parent2Lineage The conclusion about the lineage of the parent2 in this relationship.
   */
  public void setParent2Lineage(Lineage parent2Lineage) {
    this.parent2Lineage = parent2Lineage;
  }

  /**
   * The reference to the child in this relationship.
   *
   * @return The reference to the child in this relationship.
   */
  public PersonReference getChild() {
    return child;
  }

  /**
   * The reference to the child in this relationship.
   *
   * @param child The reference to the child in this relationship.
   */
  public void setChild(PersonReference child) {
    this.child = child;
  }

  @Override
  @XmlTransient
  public List<? extends PersonReference> getPersonReferences() {
    return Arrays.asList(getChild(), getParent1(), getParent2());
  }
}

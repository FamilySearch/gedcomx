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

/**
 * A relationship between a child and two parents.
 *
 * @author Ryan Heaton
 */
public class ParentChildRelationship extends Relationship {

  private ParentReference parent1;
  private Lineage parent1Lineage;
  private ParentReference parent2;
  private Lineage parent2Lineage;
  private PersonReference child;

  public ParentReference getParent1() {
    return parent1;
  }

  public void setParent1(ParentReference parent1) {
    this.parent1 = parent1;
  }

  public Lineage getParent1Lineage() {
    return parent1Lineage;
  }

  public void setParent1Lineage(Lineage parent1Lineage) {
    this.parent1Lineage = parent1Lineage;
  }

  public ParentReference getParent2() {
    return parent2;
  }

  public void setParent2(ParentReference parent2) {
    this.parent2 = parent2;
  }

  public Lineage getParent2Lineage() {
    return parent2Lineage;
  }

  public void setParent2Lineage(Lineage parent2Lineage) {
    this.parent2Lineage = parent2Lineage;
  }

  public PersonReference getChild() {
    return child;
  }

  public void setChild(PersonReference child) {
    this.child = child;
  }
}

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

import org.gedcomx.common.Attributable;
import org.gedcomx.common.ResourceReference;
import org.gedcomx.rt.GedcomxModelVisitor;
import org.gedcomx.rt.RDFRange;
import org.gedcomx.rt.json.JsonElementWrapper;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * A relationship between two or more persons.
 *
 * @author Ryan Heaton
 */
@XmlRootElement
@JsonElementWrapper ( name = "coupleChildRelationships" )
@XmlType ( name = "CoupleChildRelationship", propOrder = { "relationshipToParent1", "relationshipToParent2" } )
public class CoupleChildRelationship extends Conclusion implements Attributable {

  private ResourceReference relationshipToParent1;
  private ResourceReference relationshipToParent2;

  /**
   * A reference to a parent-child relationship. The name "relationshipToParent1" is used only to distinguish it from
   * the other parent-child relationship and implies neither order nor role.
   *
   * @return A reference to a parent-child relationship.
   */
  @RDFRange (Relationship.class)
  public ResourceReference getRelationshipToParent1() {
    return relationshipToParent1;
  }

  /**
   * A reference to a parent-child relationship. The name "relationshipToParent1" is used only to distinguish it from
   * the other parent-child relationship and implies neither order nor role.
   *
   * @param relationshipToParent1 A reference to a parent-child relationship.
   */
  public void setRelationshipToParent1(ResourceReference relationshipToParent1) {
    this.relationshipToParent1 = relationshipToParent1;
  }

  /**
   * A reference to a parent-child relationship. The name "relationshipToParent2" is used only to distinguish it from
   * the other parent-child relationship and implies neither order nor role.
   *
   * @return A reference to a parent-child relationship.
   */
  @RDFRange (Relationship.class)
  public ResourceReference getRelationshipToParent2() {
    return relationshipToParent2;
  }

  /**
   * A reference to a parent-child relationship. The name "relationshipToParent2" is used only to distinguish it from
   * the other parent-child relationship and implies neither order nor role.
   *
   * @param relationshipToParent2 A reference to a parent-child relationship.
   */
  public void setRelationshipToParent2(ResourceReference relationshipToParent2) {
    this.relationshipToParent2 = relationshipToParent2;
  }

  /**
   * Accept a visitor.
   *
   * @param visitor The visitor.
   */
  public void accept(GedcomxModelVisitor visitor) {
    visitor.visitCoupleChildRelationship(this);
  }
}

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
import javax.xml.bind.annotation.XmlTransient;

/**
 * A relationship between a child and a parent.
 *
 * @author Ryan Heaton
 */
@JsonTypeInfo ( use =JsonTypeInfo.Id.CUSTOM, property = "@type")
@JsonTypeIdResolver (XmlTypeIdResolver.class)
@XmlRootElement
public class ParentChildRelationship extends Relationship {

  private PersonReference parent;
  private Lineage lineage;
  private PersonReference child;

  /**
   * A reference to the parent in this relationship.
   *
   * @return A reference to a parent in this relationship.
   */
  public PersonReference getParent() {
    return parent;
  }

  /**
   * A reference to a parent in this relationship.
   *
   * @param parent A reference to a parent in this relationship.
   */
  public void setParent(PersonReference parent) {
    this.parent = parent;
  }

  /**
   * The conclusion about the lineage of this relationship.
   *
   * @return The conclusion about the lineage of this relationship.
   */
  public Lineage getLineage() {
    return lineage;
  }

  /**
   * The conclusion about the lineage of this relationship.
   *
   * @param lineage The conclusion about the lineage of this relationship.
   */
  public void setLineage(Lineage lineage) {
    this.lineage = lineage;
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

  @XmlTransient
  @Override
  public PersonReference getPerson1() {
    return getParent();
  }

  @XmlTransient
  @Override
  public void setPerson1(PersonReference person1) {
    setParent(person1);
  }

  @XmlTransient
  @Override
  public PersonReference getPerson2() {
    return getChild();
  }

  @XmlTransient
  @Override
  public void setPerson2(PersonReference person2) {
    setChild(person2);
  }
}

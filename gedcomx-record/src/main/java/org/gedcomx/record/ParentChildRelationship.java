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
import org.codehaus.jackson.annotate.JsonTypeInfo;
import org.codehaus.jackson.map.annotate.JsonTypeIdResolver;
import org.gedcomx.rt.XmlTypeIdResolver;
import org.gedcomx.types.LineageType;
import org.gedcomx.types.RelationshipType;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.namespace.QName;

/**
 * A recorded relationship between a parent and a child.
 */
@JsonTypeInfo ( use =JsonTypeInfo.Id.CUSTOM, property = "@type")
@JsonTypeIdResolver (XmlTypeIdResolver.class)
public class ParentChildRelationship extends Relationship {

  private QName lineageType;
  private PersonaReference parent;
  private PersonaReference child;

  /**
   * The lineage type.
   *
   * @return The lineage type.
   */
  @XmlAttribute
  @XmlQNameEnumRef( LineageType.class )
  public QName getLineageType() {
    return lineageType;
  }

  /**
   * The lineage type.
   *
   * @param lineageType The lineage type.
   */
  public void setLineageType(QName lineageType) {
    this.lineageType = lineageType;
  }

  /**
   * The enum referencing the known lineage type, or {@link org.gedcomx.types.LineageType#other} if not known.
   *
   * @return The enum referencing the known lineage type, or {@link org.gedcomx.types.LineageType#other} if not known.
   */
  @XmlTransient
  public LineageType getKnownLineageType() {
    return XmlQNameEnumUtil.fromQName(getLineageType(), LineageType.class);
  }

  /**
   * Set the lineage type from an enumeration of known lineage types.
   *
   * @param knownLineageType The lineage type.
   */
  public void setKnownLineageType(LineageType knownLineageType) {
    this.lineageType = XmlQNameEnumUtil.toQName(knownLineageType);
  }

  /**
   * Reference to the parent persona in the relationship.
   *
   * @return The parent persona in the relationship.
   */
  public PersonaReference getParent() {
    return this.parent;
  }

  /**
   * Reference to the parent persona in the relationship.
   *
   * @param parent Reference to the parent persona in the relationship.
   */
  public void setParent(PersonaReference parent) {
    this.parent = parent;
  }

  /**
   * Reference to the child in the relationship.
   *
   * @return Reference to the child in the relationship.
   */
  public PersonaReference getChild() {
    return this.child;
  }

  /**
   * Reference to the child in the relationship.
   *
   * @param child Reference to the child in the relationship.
   */
  public void setChild(PersonaReference child) {
    this.child = child;
  }

  @Override
  public PersonaReference getPersona1() {
    return getParent();
  }

  @Override
  public void setPersona1(PersonaReference persona1) {
    setParent(persona1);
  }

  @Override
  public PersonaReference getPersona2() {
    return getChild();
  }

  @Override
  public void setPersona2(PersonaReference persona2) {
    setChild(persona2);
  }

  @XmlTransient
  @Override
  public RelationshipType getKnownRelationshipType() {
    return RelationshipType.parent_child;
  }
}

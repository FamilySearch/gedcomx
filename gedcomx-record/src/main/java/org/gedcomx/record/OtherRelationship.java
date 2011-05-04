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
import org.gedcomx.types.RelationshipRole;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlIDREF;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.namespace.QName;

@XmlRootElement( name = "relationship" )
public class OtherRelationship extends Relationship {

  private String description;
  private QName role1;
  private QName role2;

  public OtherRelationship() {
  }

  @XmlAttribute
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  @XmlAttribute
  @XmlQNameEnumRef(RelationshipRole.class)
  public QName getRole1() {
    return role1;
  }

  public void setRole1(QName role1) {
    this.role1 = role1;
  }

  @XmlTransient
  public RelationshipRole getKnownRole1() {
    return XmlQNameEnumUtil.fromQName(getRole1(), RelationshipRole.class);
  }

  public void setKnownRole1(RelationshipRole knownRole1) {
    this.role1 = XmlQNameEnumUtil.toQName(knownRole1);
  }

  @XmlAttribute
  @XmlQNameEnumRef(RelationshipRole.class)
  public QName getRole2() {
    return role2;
  }

  public void setRole2(QName role2) {
    this.role2 = role2;
  }

  @XmlTransient
  public RelationshipRole getKnownRole2() {
    return XmlQNameEnumUtil.fromQName(getRole2(), RelationshipRole.class);
  }

  public void setKnownRole2(RelationshipRole knownRole2) {
    this.role2 = XmlQNameEnumUtil.toQName(knownRole2);
  }

  @XmlAttribute
  @XmlIDREF
  public Persona getRole1Persona() {
    return super.getRole1Persona();
  }

  public void setRole1Persona(Persona role1Persona) {
    super.setRole1Persona(role1Persona);
  }

  @XmlAttribute
  @XmlIDREF
  public Persona getRole2Persona() {
    return super.getRole2Persona();
  }

  public void setRole2Persona(Persona role2Persona) {
    super.setRole2Persona(role2Persona);
  }
}

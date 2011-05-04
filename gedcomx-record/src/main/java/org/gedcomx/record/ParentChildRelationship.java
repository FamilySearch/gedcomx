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
import org.gedcomx.types.LineageType;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlIDREF;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.namespace.QName;

@XmlRootElement
public class ParentChildRelationship extends Relationship {

  private QName lineageType;

  public ParentChildRelationship() {
  }

  @XmlAttribute
  @XmlQNameEnumRef( LineageType.class )
  public QName getLineageType() {
    return lineageType;
  }

  public void setLineageType(QName lineageType) {
    this.lineageType = lineageType;
  }

  @XmlTransient
  public LineageType getKnownLineageType() {
    return XmlQNameEnumUtil.fromQName(getLineageType(), LineageType.class);
  }

  public void setKnownLineageType(LineageType knownLineageType) {
    this.lineageType = XmlQNameEnumUtil.toQName(knownLineageType);
  }

  @XmlAttribute
  @XmlIDREF
  public Persona getParent() {
    return getRole1Persona();
  }

  public void setParent(Persona parent) {
    role1Persona = parent;
  }

  @XmlAttribute
  @XmlIDREF
  public Persona getChild() {
    return getRole2Persona();
  }

  public void setChild(Persona child) {
    role2Persona = child;
  }
}

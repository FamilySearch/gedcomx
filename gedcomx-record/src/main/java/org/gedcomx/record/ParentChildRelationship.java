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

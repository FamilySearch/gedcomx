package org.familysearch.gedcom.rex.relationship;

import org.familysearch.gedcom.rex.record.Persona;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlIDREF;
import javax.xml.namespace.QName;

/**
 * @author Merlin Carpenter
 *         Date: Jul 30, 2008
 */
public class ParentChildRelationship extends Relationship {

  private QName lineageType;

  public ParentChildRelationship() {
  }

  @XmlAttribute
  public QName getLineageType() {
    return lineageType;
  }

  public void setLineageType(QName lineageType) {
    this.lineageType = lineageType;
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

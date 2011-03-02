package org.familysearch.gedcom.rex.relationship;

import org.familysearch.gedcom.rex.record.Person;

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
  public Person getParent() {
    return getRole1Person();
  }

  public void setParent(Person parent) {
    role1Person = parent;
  }

  @XmlAttribute
  @XmlIDREF
  public Person getChild() {
    return getRole2Person();
  }

  public void setChild(Person child) {
    role2Person = child;
  }
}

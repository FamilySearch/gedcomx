package org.familysearch.gedcom.rex.relationship;

/**
 * @author Ryan Heaton
 */

import org.familysearch.gedcom.rex.record.Person;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlIDREF;
import javax.xml.namespace.QName;

/**
 * @author Merlin Carpenter
 *         Date: Aug 4, 2008
 */
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
  public QName getRole1() {
    return role1;
  }

  public void setRole1(QName role1) {
    this.role1 = role1;
  }

  @XmlAttribute
  public QName getRole2() {
    return role2;
  }

  public void setRole2(QName role2) {
    this.role2 = role2;
  }

  @XmlAttribute
  @XmlIDREF
  public Person getRole1Person() {
    return super.getRole1Person();
  }

  public void setRole1Person(Person role1Person) {
    this.role1Person = role1Person;
  }

  @XmlAttribute
  @XmlIDREF
  public Person getRole2Person() {
    return super.getRole2Person();
  }

  public void setRole2Person(Person role2Person) {
    this.role2Person = role2Person;
  }
}

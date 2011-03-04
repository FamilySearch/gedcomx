package org.familysearch.gedcom.rex.relationship;

/**
 * @author Ryan Heaton
 */

import org.familysearch.gedcom.rex.record.Persona;

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

package org.gedcomx.record;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlIDREF;

/**
 * @author Merlin Carpenter
 *         Date: Jul 30, 2008
 */
public class CoupleRelationship extends Relationship {

  public CoupleRelationship() {
  }

  @XmlAttribute
  @XmlIDREF
  public Persona getPersona1() {
    return getRole1Persona();
  }

  public void setPersona1(Persona person1) {
    role1Persona = person1;
  }

  @XmlAttribute
  @XmlIDREF
  public Persona getPersona2() {
    return getRole2Persona();
  }

  public void setPersona2(Persona person2) {
    role2Persona = person2;
  }

}

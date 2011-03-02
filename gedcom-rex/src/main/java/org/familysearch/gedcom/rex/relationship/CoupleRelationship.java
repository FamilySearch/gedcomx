package org.familysearch.gedcom.rex.relationship;

import org.familysearch.gedcom.rex.record.Person;

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
  public Person getPerson1() {
    return getRole1Person();
  }

  public void setPerson1(Person person1) {
    role1Person = person1;
  }

  @XmlAttribute
  @XmlIDREF
  public Person getPerson2() {
    return getRole2Person();
  }

  public void setPerson2(Person person2) {
    role2Person = person2;
  }

}

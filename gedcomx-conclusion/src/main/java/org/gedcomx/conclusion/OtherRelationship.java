package org.gedcomx.conclusion;

import javax.xml.bind.annotation.XmlTransient;
import java.util.Arrays;
import java.util.List;

/**
 * A basic relationship between two people, used to model basic relationships that are neither couple nor parent-child relationships.
 *
 * @author Ryan Heaton
 */
public class OtherRelationship extends Relationship {

  private PersonReference person1;
  private PersonReference person2;

  /**
   * A reference to a person in the relationship. The name "person1" is used only to distinguish it from
   * the other person in this relationship and implies neither order nor role.
   *
   * @return A reference to a person in the relationship. The name "person1" is used only to distinguish it from
   * the other person in this relationship and implies neither order nor role.
   */
  public PersonReference getPerson1() {
    return person1;
  }

  /**
   * A reference to a person in the relationship. The name "person1" is used only to distinguish it from
   * the other person in this relationship and implies neither order nor role.
   *
   * @param person1 A reference to a person in the relationship. The name "person1" is used only to distinguish it from
   * the other person in this relationship and implies neither order nor role.
   */
  public void setPerson1(PersonReference person1) {
    this.person1 = person1;
  }

  /**
   * A reference to a person in the relationship. The name "person2" is used only to distinguish it from
   * the other person in this relationship and implies neither order nor role.
   *
   * @return A reference to a person in the relationship. The name "person2" is used only to distinguish it from
   * the other person in this relationship and implies neither order nor role.
   */
  public PersonReference getPerson2() {
    return person2;
  }

  /**
   * A reference to a person in the relationship. The name "person2" is used only to distinguish it from
   * the other person in this relationship and implies neither order nor role.
   *
   * @param person2 A reference to a person in the relationship. The name "person2" is used only to distinguish it from
   * the other person in this relationship and implies neither order nor role.
   */
  public void setPerson2(PersonReference person2) {
    this.person2 = person2;
  }

  @Override
  @XmlTransient
  public List<PersonReference> getPersonReferences() {
    return Arrays.asList(getPerson1(), getPerson2());
  }
}

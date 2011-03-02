package org.familysearch.gedcom.rex.record;

import org.familysearch.gedcom.rex.age.Age;
import org.familysearch.gedcom.rex.characteristic.Characteristic;
import org.familysearch.gedcom.rex.gender.Gender;
import org.familysearch.gedcom.rex.name.Name;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlID;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Merlin Carpenter
 *         Date: Jul 30, 2008
 */
public class Person {

  private String id;
  private Gender gender;
  private Age age;
  private List<Name> names = new ArrayList<Name>();
  private List<Characteristic> characteristics = new ArrayList<Characteristic>();
  private List<RoleInEvent> rolesInEvents = new ArrayList<RoleInEvent>();
  private Boolean principal;

  public Person() {
  }

  @XmlAttribute
  @XmlID
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  @XmlElement
  public Gender getGender() {
    return gender;
  }

  public void setGender(Gender gender) {
    this.gender = gender;
  }

  @XmlElement
  public Age getAge() {
    return age;
  }

  public void setAge(Age age) {
    this.age = age;
  }

  @XmlElement(name = "name")
  public List<Name> getNames() {
    return names;
  }

  public void addName(Name name) {
    if (names == null) {
      names = new ArrayList<Name>();
    }
    names.add(name);
  }

  public void setNames(List<Name> names) {
    this.names = names;
  }

  @XmlElement(name = "characteristic")
  public List<Characteristic> getCharacteristics() {
    return characteristics;
  }

  public void setCharacteristics(List<Characteristic> characteristics) {
    this.characteristics = characteristics;
  }

  @XmlElement(name = "roleInEvent")
  public List<RoleInEvent> getRolesInEvents() {
    return rolesInEvents;
  }

  public void setRolesInEvents(List<RoleInEvent> rolesInEvents) {
    this.rolesInEvents = rolesInEvents;
  }

  @XmlAttribute(name = "principal")
  public Boolean getPrincipal() {
    return principal;
  }

  public void setPrincipal(Boolean isPrincipal) {
    this.principal = isPrincipal;
  }
}

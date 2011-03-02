package org.familysearch.gedcom.rex.relationship;

import org.familysearch.gedcom.rex.characteristic.Characteristic;
import org.familysearch.gedcom.rex.record.Person;

import javax.xml.bind.annotation.*;
import javax.xml.namespace.QName;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Merlin Carpenter
 *         Date: Jul 30, 2008
 */
@XmlType(name = "relationship")
public abstract class Relationship {

  private String id;
  private QName type;
  protected Person role1Person;
  protected Person role2Person;
  private List<Characteristic> characteristics = new ArrayList<Characteristic>();

  public Relationship() {
  }

  @XmlAttribute
  public QName getType() {
    return type;
  }

  public void setType(QName type) {
    this.type = type;
  }

  @XmlAttribute
  @XmlID
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Person getRole1Person() {
    return role1Person;
  }

  @XmlTransient
  public void setRole1Person(Person role1Person) {
    this.role1Person = role1Person;
  }

  public Person getRole2Person() {
    return role2Person;
  }

  @XmlTransient
  public void setRole2Person(Person role2Person) {
    this.role2Person = role2Person;
  }

  @XmlElement(name = "characteristic")
  public List<Characteristic> getCharacteristics() {
    return characteristics;
  }

  public void setCharacteristics(List<Characteristic> characteristics) {
    this.characteristics = characteristics;
  }

}

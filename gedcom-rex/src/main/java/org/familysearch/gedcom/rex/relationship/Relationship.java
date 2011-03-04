package org.familysearch.gedcom.rex.relationship;

import org.familysearch.gedcom.rex.characteristic.Characteristic;
import org.familysearch.gedcom.rex.record.Persona;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Merlin Carpenter
 *         Date: Jul 30, 2008
 */
@XmlType(name = "relationship")
public abstract class Relationship {

  private String id;
  protected Persona role1Persona;
  protected Persona role2Persona;
  private List<Characteristic> characteristics = new ArrayList<Characteristic>();

  public Relationship() {
  }

  @XmlAttribute
  @XmlID
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  @XmlTransient
  public Persona getRole1Persona() {
    return role1Persona;
  }

  public void setRole1Persona(Persona role1Persona) {
    this.role1Persona = role1Persona;
  }

  @XmlTransient
  public Persona getRole2Persona() {
    return role2Persona;
  }

  public void setRole2Persona(Persona role2Persona) {
    this.role2Persona = role2Persona;
  }

  @XmlElement(name = "characteristic")
  public List<Characteristic> getCharacteristics() {
    return characteristics;
  }

  public void setCharacteristics(List<Characteristic> characteristics) {
    this.characteristics = characteristics;
  }

}

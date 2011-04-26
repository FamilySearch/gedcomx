package org.gedcomx.record;

import org.gedcomx.source.SourceReference;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Merlin Carpenter
 *         Date: Jul 30, 2008
 */
@XmlType (
  name = "basePersona",
  propOrder = {"alternateIds", "gender", "age", "names", "eventRoles", "characteristics", "sources"}
)
public class Persona {

  private String id;
  private List<AlternateId> alternateIds;
  private Gender gender;
  private Age age;
  private List<Name> names = new ArrayList<Name>();
  private List<EventRole> eventRoles = new ArrayList<EventRole>();
  private List<Characteristic> characteristics = new ArrayList<Characteristic>();
  private Boolean principal;
  private List<SourceReference> sources;

  public Persona() {
  }

  @XmlAttribute
  @XmlID
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  @XmlElement(name="alternateId")
  public List<AlternateId> getAlternateIds() {
    return alternateIds;
  }

  public void setAlternateIds(List<AlternateId> alternateIds) {
    this.alternateIds = alternateIds;
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

  @XmlElement(name = "eventRole")
  public List<EventRole> getEventRoles() {
    return eventRoles;
  }

  public void setEventRoles(List<EventRole> eventRoles) {
    this.eventRoles = eventRoles;
  }

  @XmlAttribute
  public Boolean getPrincipal() {
    return principal;
  }

  public void setPrincipal(Boolean isPrincipal) {
    this.principal = isPrincipal;
  }

  @XmlElement(name = "source")
  public List<SourceReference> getSources() {
    return sources;
  }

  public void setSources(List<SourceReference> sources) {
    this.sources = sources;
  }
}

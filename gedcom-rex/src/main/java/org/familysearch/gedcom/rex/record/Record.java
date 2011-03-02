package org.familysearch.gedcom.rex.record;

import org.familysearch.gedcom.rex.characteristic.Characteristic;
import org.familysearch.gedcom.rex.event.Event;
import org.familysearch.gedcom.rex.relationship.Relationship;

import javax.xml.bind.annotation.*;
import javax.xml.namespace.QName;
import java.util.List;

/**
 * @author Merlin Carpenter
 *         Date: Jul 30, 2008
 */
@XmlRootElement(name = "record")
@XmlType(propOrder = {"persons", "events", "relationships", "characteristics"})
public class Record {

  private String id;
  private QName type;
  private List<Person> persons;
  private List<Event> events;
  private List<Relationship> relationships;
  private List<Characteristic> characteristics;

  public Record() {
  }

  @XmlAttribute
  @XmlID
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  @XmlAttribute
  public QName getType() {
    return type;
  }

  public void setType(QName type) {
    this.type = type;
  }

  @XmlElement(name = "person")
  public List<Person> getPersons() {
    return persons;
  }

  public void setPersons(List<Person> persons) {
    this.persons = persons;
  }

  @XmlElement(name = "event")
  public List<Event> getEvents() {
    return events;
  }

  public void setEvents(List<Event> events) {
    this.events = events;
  }

  @XmlElement(name = "relationship")
  public List<Relationship> getRelationships() {
    return relationships;
  }

  public void setRelationships(List<Relationship> relationships) {
    this.relationships = relationships;
  }

  @XmlElement(name = "characteristic")
  public List<Characteristic> getCharacteristics() {
    return characteristics;
  }

  public void setCharacteristics(List<Characteristic> characteristics) {
    this.characteristics = characteristics;
  }

}

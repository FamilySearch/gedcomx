package org.familysearch.gedcom.rex.event;

import org.codehaus.enunciate.ClientName;
import org.familysearch.gedcom.rex.characteristic.Characteristic;
import org.familysearch.gedcom.rex.date.Date;
import org.familysearch.gedcom.rex.place.Place;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlID;
import javax.xml.namespace.QName;
import java.util.List;

/**
 * @author Merlin Carpenter
 *         Date: Jul 30, 2008
 */
@ClientName("EventInfo")
public class Event {

  private String id;
  private QName type;
  private Boolean primary;
  private String description;
  private Date date;
  private Place place;
  private List<Characteristic> characteristics;

  public Event() {
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

  @XmlAttribute
  public Boolean getPrimary() {
    return primary;
  }

  public void setPrimary(Boolean primary) {
    this.primary = primary;
  }

  @XmlElement
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  @XmlElement
  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  @XmlElement
  public Place getPlace() {
    return place;
  }

  public void setPlace(Place place) {
    this.place = place;
  }

  @XmlElement(name = "characteristic")
  public List<Characteristic> getCharacteristics() {
    return characteristics;
  }

  public void setCharacteristics(List<Characteristic> characteristics) {
    this.characteristics = characteristics;
  }

}

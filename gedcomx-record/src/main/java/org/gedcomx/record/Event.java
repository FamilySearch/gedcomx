package org.gedcomx.record;

import org.codehaus.enunciate.ClientName;
import org.codehaus.enunciate.XmlQNameEnumUtil;
import org.codehaus.enunciate.qname.XmlQNameEnumRef;
import org.gedcomx.types.EventType;

import javax.xml.bind.annotation.*;
import javax.xml.namespace.QName;
import java.util.List;

@XmlRootElement
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
  @XmlQNameEnumRef(EventType.class)
  public QName getType() {
    return type;
  }

  public void setType(QName type) {
    this.type = type;
  }

  @XmlTransient
  public EventType getKnownType() {
    return XmlQNameEnumUtil.fromQName(getType(), EventType.class);
  }

  public void setKnownType(EventType knownType) {
    this.type = XmlQNameEnumUtil.toQName(knownType);
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

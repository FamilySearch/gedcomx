package org.gedcomx.record;


import org.codehaus.enunciate.XmlQNameEnumUtil;
import org.codehaus.enunciate.qname.XmlQNameEnumRef;
import org.gedcomx.types.CharacteristicType;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.namespace.QName;

public class Characteristic extends Field {

  private QName type;
  private Date date;
  private Place place;

  public Characteristic() {
  }

  @XmlAttribute
  @XmlQNameEnumRef(CharacteristicType.class)
  public QName getType() {
    return type;
  }

  public void setType(QName type) {
    this.type = type;
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

  @XmlTransient
  public CharacteristicType getKnownType() {
    return XmlQNameEnumUtil.fromQName(getType(), CharacteristicType.class);
  }

  public void setKnownType(CharacteristicType knownType) {
    this.type = XmlQNameEnumUtil.toQName(knownType);
  }
}

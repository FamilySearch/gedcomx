package org.gedcomx.record;

import org.codehaus.enunciate.XmlQNameEnumUtil;
import org.codehaus.enunciate.qname.XmlQNameEnumRef;
import org.gedcomx.types.PlacePartType;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;
import javax.xml.namespace.QName;

@XmlType(name = "placePart")
public class PlacePart extends Field {

  private QName type;

  public PlacePart() {
  }

  @XmlAttribute(name = "type")
  @XmlQNameEnumRef(PlacePartType.class)
  public QName getType() {
    return type;
  }

  public void setType(QName type) {
    this.type = type;
  }

  @XmlTransient
  public PlacePartType getKnownType() {
    return XmlQNameEnumUtil.fromQName(getType(), PlacePartType.class);
  }

  public void setKnownType(PlacePartType knownType) {
    this.type = XmlQNameEnumUtil.toQName(knownType);
  }
}

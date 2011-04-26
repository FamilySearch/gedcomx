package org.gedcomx.record;

import org.codehaus.enunciate.XmlQNameEnumUtil;
import org.codehaus.enunciate.qname.XmlQNameEnumRef;
import org.gedcomx.types.AlternateIdType;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlValue;
import javax.xml.namespace.QName;

/**
 * @author Ryan Heaton
 */
public class AlternateId {

  private String value;
  private QName type;

  @XmlValue
  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  @XmlAttribute
  @XmlQNameEnumRef(AlternateIdType.class)
  public QName getType() {
    return type;
  }

  public void setType(QName type) {
    this.type = type;
  }

  @XmlTransient
  public AlternateIdType getKnownType() {
    return XmlQNameEnumUtil.fromQName(getType(), AlternateIdType.class);
  }

  public void setKnownType(AlternateIdType knownType) {
    this.type = XmlQNameEnumUtil.toQName(knownType);
  }
}

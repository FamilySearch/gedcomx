package org.gedcomx.record;

import org.codehaus.enunciate.XmlQNameEnumUtil;
import org.codehaus.enunciate.qname.XmlQNameEnumRef;
import org.gedcomx.types.DatePartType;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.namespace.QName;

public class DatePart extends Field {

  private QName type;

  public DatePart() {
  }

  @XmlAttribute
  @XmlQNameEnumRef(DatePartType.class)
  public QName getType() {
    return type;
  }

  public void setType(QName type) {
    this.type = type;
  }

  @XmlTransient
  public DatePartType getKnownType() {
    return XmlQNameEnumUtil.fromQName(getType(), DatePartType.class);
  }

  public void setKnownType(DatePartType knownType) {
    this.type = XmlQNameEnumUtil.toQName(knownType);
  }
}

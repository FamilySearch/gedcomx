package org.gedcomx.record;

import org.codehaus.enunciate.XmlQNameEnumUtil;
import org.codehaus.enunciate.qname.XmlQNameEnumRef;
import org.gedcomx.types.NamePartType;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.namespace.QName;

public class NamePart extends Field {

  private QName type;

  public NamePart() {
  }

  @XmlAttribute
  @XmlQNameEnumRef(NamePartType.class)
  public QName getType() {
    return type;
  }

  public void setType(QName type) {
    this.type = type;
  }

  @XmlTransient
  public NamePartType getKnownType() {
    return XmlQNameEnumUtil.fromQName(getType(), NamePartType.class);
  }

  public void setKnownType(NamePartType knownType) {
    this.type = XmlQNameEnumUtil.toQName(knownType);
  }
}

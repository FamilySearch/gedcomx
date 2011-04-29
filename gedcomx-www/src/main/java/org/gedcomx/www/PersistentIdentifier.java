package org.gedcomx.www;

import org.codehaus.enunciate.XmlQNameEnumUtil;
import org.codehaus.enunciate.qname.XmlQNameEnumRef;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlValue;
import javax.xml.namespace.QName;
import java.net.URI;

/**
 * @author Ryan Heaton
 */
public class PersistentIdentifier {

  private QName type;
  private URI value;

  @XmlAttribute
  @XmlQNameEnumRef(PersistentIdentifierType.class)
  public QName getType() {
    return type;
  }

  public void setType(QName type) {
    this.type = type;
  }

  @XmlTransient
  public PersistentIdentifierType getKnownType() {
    return XmlQNameEnumUtil.fromQName(getType(), PersistentIdentifierType.class);
  }

  public void setKnownType(PersistentIdentifierType type) {
    this.type = XmlQNameEnumUtil.toQName(type);
  }

  @XmlValue
  public URI getValue() {
    return value;
  }

  public void setValue(URI value) {
    this.value = value;
  }
}

package org.gedcomx.metadata.dc;

import org.codehaus.enunciate.XmlQNameEnumUtil;

import javax.xml.bind.annotation.XmlValue;
import javax.xml.namespace.QName;

/**
 * @author Ryan Heaton
 */
public class DublinCoreTypeProperty extends DublinCoreProperty<QName> {

  private QName value;

  @XmlValue
  public QName getValue() {
    return value;
  }

  public void setValue(QName value) {
    this.value = value;
  }

  public DublinCoreType getKnownValue() {
    return XmlQNameEnumUtil.fromQName(getValue(), DublinCoreType.class);
  }

  public void setKnownValue(DublinCoreType knownType) {
    this.value = XmlQNameEnumUtil.toQName(knownType);
  }
}

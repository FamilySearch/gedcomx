package org.gedcomx.record;

import org.codehaus.enunciate.qname.XmlQNameEnumRef;
import org.gedcomx.types.AgeUnits;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.namespace.QName;

/**
 * @author Ryan Heaton
 */
public class AgePart extends Field {

  private QName units;

  @XmlAttribute
  @XmlQNameEnumRef(AgeUnits.class)
  public QName getUnits() {
    return units;
  }

  public void setUnits(QName units) {
    this.units = units;
  }

  @XmlTransient
  public AgeUnits getKnownUnits() {
    return org.codehaus.enunciate.XmlQNameEnumUtil.fromQName(getUnits(), AgeUnits.class);
  }

  public void setKnownUnits(AgeUnits units) {
    this.units = org.codehaus.enunciate.XmlQNameEnumUtil.toQName(units);
  }

}

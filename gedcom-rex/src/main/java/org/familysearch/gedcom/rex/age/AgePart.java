package org.familysearch.gedcom.rex.age;

import org.familysearch.gedcom.rex.Field;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.namespace.QName;

/**
 * @author Ryan Heaton
 */
public class AgePart extends Field {

  private QName units;

  @XmlAttribute
  public QName getUnits() {
    return units;
  }

  public void setUnits(QName units) {
    this.units = units;
  }

}

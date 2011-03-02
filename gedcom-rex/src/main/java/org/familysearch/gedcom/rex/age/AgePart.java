package org.familysearch.gedcom.rex.age;

import org.familysearch.gedcom.rex.Part;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.namespace.QName;

/**
 * @author Ryan Heaton
 */
public class AgePart extends Part {

  private QName units;

  @XmlAttribute
  public QName getUnits() {
    return units;
  }

  public void setUnits(QName units) {
    this.units = units;
  }

}

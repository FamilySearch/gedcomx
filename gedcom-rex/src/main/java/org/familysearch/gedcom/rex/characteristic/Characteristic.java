package org.familysearch.gedcom.rex.characteristic;


import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.namespace.QName;
import org.familysearch.gedcom.rex.Field;

/**
 * Class representing characteristics (attributes) of something.
 * Author: Randy Wilson
 * Date: Aug 5, 2008
 */
public class Characteristic extends Field {

  private QName type;

  public Characteristic() {
  }

  @XmlAttribute(name = "type")
  public QName getType() {
    return type;
  }

  public void setType(QName type) {
    this.type = type;
  }

}

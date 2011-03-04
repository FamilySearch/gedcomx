package org.familysearch.gedcom.rex.place;

import org.familysearch.gedcom.rex.Field;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import javax.xml.namespace.QName;

/**
 * @author Merlin Carpenter
 *         Place: Aug 14, 2008
 */
@XmlType(name = "placePart")
public class PlacePart extends Field {

  private QName type;

  public PlacePart() {
  }

  @XmlAttribute(name = "type")
  public QName getType() {
    return type;
  }

  public void setType(QName type) {
    this.type = type;
  }

}

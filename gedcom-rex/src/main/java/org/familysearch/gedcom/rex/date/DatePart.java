package org.familysearch.gedcom.rex.date;

import org.familysearch.gedcom.rex.Field;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.namespace.QName;

/**
 * @author Merlin Carpenter
 *         Date: Aug 14, 2008
 */
public class DatePart extends Field {

  private QName type;

  public DatePart() {
  }

  @XmlAttribute(name = "type")
  public QName getType() {
    return type;
  }

  public void setType(QName type) {
    this.type = type;
  }

}

package org.familysearch.gedcom.rex.name;

import org.familysearch.gedcom.rex.Part;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.namespace.QName;

/**
 * Class representing a typed part of a name (e.g., given name part such as "John Henry", which may have multiple
 * pieces in a single string, as you might get from a field on a form labeled "given name(s)").
 * 
 * @author Merlin Carpenter
 *         Date: Aug 14, 2008
 */
public class NamePart extends Part {

  private QName type;

  public NamePart() {
  }

  @XmlAttribute(name = "type")
  public QName getType() {
    return type;
  }

  public void setType(QName type) {
    this.type = type;
  }

}

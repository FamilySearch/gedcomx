package org.familysearch.gedcom.rex.age;

import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlType;
import org.familysearch.gedcom.rex.Field;

/**
 * @author Merlin Carpenter
 *         Date: Jul 30, 2008
 */
@XmlType
public class Age extends Field {

  private List<AgePart> parts;

  public Age() {
  }

  @XmlElementWrapper (name = "parts")
  @XmlElement (name = "part")
  public List<AgePart> getParts() {
    return parts;
  }

  public void setParts(List<AgePart> parts) {
    this.parts = parts;
  }

}

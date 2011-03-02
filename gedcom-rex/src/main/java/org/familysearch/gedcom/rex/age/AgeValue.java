package org.familysearch.gedcom.rex.age;

import org.familysearch.gedcom.rex.Value;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import java.util.List;

/**
 * @author Merlin Carpenter
 *         Date: Aug 14, 2008
 */
public class AgeValue extends Value {

  private List<AgePart> parts;

  public AgeValue() {
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

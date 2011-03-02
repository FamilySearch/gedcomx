package org.familysearch.gedcom.rex.name;

import org.familysearch.gedcom.rex.Value;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import java.util.List;

/**
 * @author CarpenterMP
 *         Date: Jul 13, 2009
 */
public class NameValue extends Value {

  private List<NamePart> parts;

  public NameValue() {
  }

  @XmlElementWrapper(name = "parts")
  @XmlElement(name = "part")
  public List<NamePart> getParts() {
    return parts;
  }

  public void setParts(List<NamePart> parts) {
    this.parts = parts;
  }

}

package org.familysearch.gedcom.rex.date;

import org.familysearch.gedcom.rex.Value;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import java.util.List;

/**
 * @author CarpenterMP
 *         Date: Jul 10, 2009
 */
public class DateValue extends Value {

  private List<DatePart> parts;

  public DateValue() {
  }

  @XmlElementWrapper(name = "parts")
  @XmlElement(name = "part")
  public List<DatePart> getParts() {
    return parts;
  }

  public void setParts(List<DatePart> parts) {
    this.parts = parts;
  }

}

package org.familysearch.gedcom.rex.place;

import org.familysearch.gedcom.rex.Value;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import java.util.List;

/**
 * @author CarpenterMP
 *         Date: Jul 13, 2009
 */
public class PlaceValue extends Value {

  private List<PlacePart> parts;

  public PlaceValue() {
  }

  @XmlElementWrapper(name = "parts")
  @XmlElement(name = "part")
  public List<PlacePart> getParts() {
    return parts;
  }

  public void setParts(List<PlacePart> parts) {
    this.parts = parts;
  }

}

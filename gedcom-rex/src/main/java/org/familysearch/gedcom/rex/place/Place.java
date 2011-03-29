package org.familysearch.gedcom.rex.place;

import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlType;
import org.familysearch.gedcom.rex.Field;

/**
 * @author Merlin Carpenter
 *         Place: Jul 30, 2008
 */
@XmlType
public class Place extends Field {

  public Place() {
  }

  private List<PlacePart> parts;

  @XmlElementWrapper(name = "parts")
  @XmlElement(name = "part")
  public List<PlacePart> getParts() {
    return parts;
  }

  public void setParts(List<PlacePart> parts) {
    this.parts = parts;
  }

}

package org.gedcomx.record;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import java.util.List;

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

package org.gedcomx.record;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlType;
import java.util.List;

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

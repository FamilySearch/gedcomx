package org.gedcomx.record;

import org.codehaus.enunciate.ClientName;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlType;
import java.util.List;

@XmlType
@ClientName("DateInfo")
public class Date extends Field {

  private List<DatePart> parts;

  public Date() {
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

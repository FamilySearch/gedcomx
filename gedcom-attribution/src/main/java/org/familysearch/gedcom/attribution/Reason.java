package org.familysearch.gedcom.attribution;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlValue;

/**
 * @author CarpenterMP
 *         Date: Aug 12, 2009
 */
public class Reason {

  private ReasonType type;
  private String value;

  public Reason() {
  }

  public Reason(ReasonType type, String reasoning) {
    this.type = type;
    this.value = reasoning;
  }

  @XmlAttribute
  public ReasonType getType() {
    return type;
  }

  public void setType(ReasonType type) {
    this.type = type;
  }

  @XmlValue
  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

}

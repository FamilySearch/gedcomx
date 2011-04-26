package org.gedcomx.metadata.dc;

import javax.xml.bind.annotation.XmlValue;
import java.util.Date;

/**
 * @author Ryan Heaton
 */
public class DublinCoreDateProperty extends DublinCoreProperty<Date> {

  private Date value;

  @XmlValue
  public Date getValue() {
    return value;
  }

  public void setValue(Date value) {
    this.value = value;
  }
}

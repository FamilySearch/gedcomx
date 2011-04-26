package org.gedcomx.metadata.dc;

import javax.xml.bind.annotation.XmlValue;

/**
 * @author Ryan Heaton
 */
public class DublinCoreStringProperty extends DublinCoreProperty<String> {

  private String value;

  @XmlValue
  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }
}

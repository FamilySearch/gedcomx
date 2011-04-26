package org.gedcomx.www;

import javax.xml.bind.annotation.XmlValue;
import java.net.URI;

/**
 * @author Ryan Heaton
 */
public class PAL {

  private URI value;

  @XmlValue
  public URI getValue() {
    return value;
  }

  public void setValue(URI value) {
    this.value = value;
  }
}

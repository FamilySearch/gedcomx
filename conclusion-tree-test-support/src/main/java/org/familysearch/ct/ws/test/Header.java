package org.familysearch.ct.ws.test;

import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

/**
 * @author Mike Gardiner
 */
@XmlType
public class Header implements Serializable {
  private String name;
  private String value;

  public Header() {

  }

  public Header(String name, String value) {
    this.name = name;
    this.value = value;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }
}

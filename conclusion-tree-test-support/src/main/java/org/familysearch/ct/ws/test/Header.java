package org.familysearch.ct.ws.test;

import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

/**
 * Used to hold header information associated with a request
 * or response
 *
 * @author Mike Gardiner
 */
@XmlType
public class Header implements Serializable {
  private String name;
  private String value;

  /**
   * Default Constructor
   */
  public Header() {

  }

  /**
   * Multi-parameter Constructor
   *
   * @param name  - Name of the header
   * @param value - Value of the header
   */
  public Header(String name, String value) {
    this.name = name;
    this.value = value;
  }

  /**
   * @return The header name
   */
  public String getName() {
    return name;
  }

  /**
   * @param name - The header name
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * @return The value
   */
  public String getValue() {
    return value;
  }

  /**
   * @param value - The String value to set
   */
  public void setValue(String value) {
    this.value = value;
  }
}

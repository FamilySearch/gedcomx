package org.gedcomx.test;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Ryan Heaton
 */
@XmlRootElement
public class CustomElement {
  
  private String prop1;
  private String prop2;

  public String getProp1() {
    return prop1;
  }

  public void setProp1(String prop1) {
    this.prop1 = prop1;
  }

  public String getProp2() {
    return prop2;
  }

  public void setProp2(String prop2) {
    this.prop2 = prop2;
  }
}

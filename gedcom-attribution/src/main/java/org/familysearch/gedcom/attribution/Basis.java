package org.familysearch.gedcom.attribution;

import javax.xml.bind.annotation.XmlAttribute;

/**
 * @author CarpenterMP
 *         Date: Aug 12, 2009
 */
public class Basis {

  private String ref;

  @XmlAttribute
  public String getRef() {
    return ref;
  }

  public void setRef(String ref) {
    this.ref = ref;
  }
}

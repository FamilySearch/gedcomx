package org.familysearch.gedcom.attribution;

import javax.xml.bind.annotation.XmlElement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Address an address
 */
public class Address {

  private List<String> lines;

  public Address() {
  }

  public Address(String[] addressLines) {
    if (addressLines != null) {
      lines = new ArrayList<String>(Arrays.asList(addressLines));
    }
  }

  @XmlElement(name = "addressLine")
  public List<String> getLines() {
    return lines;
  }

  public void addLine(String addressLine) {
    if (lines == null) {
      lines = new ArrayList<String>();
    }
    lines.add(addressLine);
  }

  public void setLines(List<String> lines) {
    this.lines = lines;
  }
}

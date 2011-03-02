package org.familysearch.gedcom.rex.date;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

/**
 * @author CarpenterMP
 *         Date: Jul 13, 2009
 */
public class AstroDate {

  private int earliest;
  private int latest;

  public AstroDate() {
  }

  @XmlAttribute
  public int getEarliest() {
    return earliest;
  }

  public void setEarliest(int earliest) {
    this.earliest = earliest;
  }

  @XmlAttribute
  public int getLatest() {
    return latest;
  }

  public void setLatest(int latest) {
    this.latest = latest;
  }
}

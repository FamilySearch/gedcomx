package org.gedcomx.record.www;

import org.gedcomx.www.Links;
import org.gedcomx.www.PAL;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * @author Ryan Heaton
 */
@XmlRootElement
@XmlType ( propOrder = {"pal", "links"} )
public class Record extends org.gedcomx.record.Record {

  private Links links;
  private PAL pal;

  public PAL getPal() {
    return pal;
  }

  public void setPal(PAL pal) {
    this.pal = pal;
  }

  public Links getLinks() {
    return links;
  }

  public void setLinks(Links links) {
    this.links = links;
  }

}

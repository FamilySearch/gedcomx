package org.gedcomx.record.www;

import org.gedcomx.www.Links;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Ryan Heaton
 */
@XmlRootElement
public class Collection extends org.gedcomx.record.Collection {

  private Links links;

  public Links getLinks() {
    return links;
  }

  public void setLinks(Links links) {
    this.links = links;
  }
}

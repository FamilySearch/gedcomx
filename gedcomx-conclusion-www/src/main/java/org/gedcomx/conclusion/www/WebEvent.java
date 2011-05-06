package org.gedcomx.conclusion.www;

import org.gedcomx.conclusion.Event;
import org.gedcomx.www.Links;

import javax.xml.bind.annotation.XmlType;

/**
 * @author Ryan Heaton
 */
@XmlType (name = "event")
public class WebEvent extends Event {
  //todo: what are the implications of using this in the model? does it deserialize correctly? what about for json?

  private Links links;

  public Links getLinks() {
    return links;
  }

  public void setLinks(Links links) {
    this.links = links;
  }
}

package org.gedcomx.record.www;

import org.gedcomx.www.Links;

/**
 * A characteristic field that can support WWW links.
 *
 * @author Ryan Heaton
 */
public class Characteristic extends org.gedcomx.record.Characteristic {

  private Links links;

  /**
   * The WWW links for this field.
   *
   * @return The WWW links for this field.
   */
  public Links getLinks() {
    return links;
  }

  /**
   * The links.
   *
   * @param links The links.
   */
  public void setLinks(Links links) {
    this.links = links;
  }

}

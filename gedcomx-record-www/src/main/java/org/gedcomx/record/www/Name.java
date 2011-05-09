package org.gedcomx.record.www;

import org.gedcomx.www.Links;

/**
 * A name field that can support WWW links.
 *
 * @author Ryan Heaton
 */
public class Name extends org.gedcomx.record.Name {

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

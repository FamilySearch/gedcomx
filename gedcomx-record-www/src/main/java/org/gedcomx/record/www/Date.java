package org.gedcomx.record.www;

import org.gedcomx.www.Links;

/**
 * A date field that can support WWW links.
 *
 * @author Ryan Heaton
 */
public class Date extends org.gedcomx.record.Date {

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

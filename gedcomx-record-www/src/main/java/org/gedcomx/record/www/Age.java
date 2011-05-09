package org.gedcomx.record.www;

import org.gedcomx.www.Links;

/**
 * An age field that can support WWW links.
 *
 * @author Ryan Heaton
 */
public class Age extends org.gedcomx.record.Age {

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

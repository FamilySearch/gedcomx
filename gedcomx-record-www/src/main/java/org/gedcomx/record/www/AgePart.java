package org.gedcomx.record.www;

import org.gedcomx.www.Links;

/**
 * An age part field that can support WWW links.
 *
 * @author Ryan Heaton
 */
public class AgePart extends org.gedcomx.record.AgePart {

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

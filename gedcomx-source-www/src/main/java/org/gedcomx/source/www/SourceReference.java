package org.gedcomx.source.www;

import org.gedcomx.www.Links;

/**
 * A source reference that can support WWW links.
 *
 * @author Ryan Heaton
 */
public class SourceReference extends org.gedcomx.source.SourceReference {

  private Links links;

  /**
   * The WWW links for this source reference.
   *
   * @return The WWW links for this reference.
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

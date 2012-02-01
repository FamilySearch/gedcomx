package org.familysearch.ct.ws.service.api;


import org.gedcomx.xrd.Link;

import org.gedcomx.metadata.foaf.Person;
import java.util.List;

/**
 * @author Mike Gardiner
 */
public interface DiscoveryService {
  /**
   * Get a list of authentication Links
   * @return List of authentication links
   */
  public List<Link> getAuthLinks();

  /**
   * Get the Session Id
   * @return A valid session Id or Null if user is not authenticated
   */
  public String getSessionId();

  /**
   * Get meta-data about currently authenticated user
   *
   * @return Person meta-data
   */
  public Person getAuthenticatedPerson();
}

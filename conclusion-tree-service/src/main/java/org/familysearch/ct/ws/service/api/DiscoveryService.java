package org.familysearch.ct.ws.service.api;


import org.gedcomx.xrd.Link;

import org.gedcomx.conclusion.Person;
import java.util.List;

/**
 * @author Mike Gardiner
 */
public interface DiscoveryService {

  /**
   * Get a list of authentication links
   *
   * @return List of authentication links
   */
  public EntityBundle<List<Link>> getAuthLinks();

  /**
   * Get the conclusion person of the currently-authenticated user.
   *
   * @return The conclusion person, or null if there is no currently authenticated user.
   */
  public EntityBundle<Person> getAuthenticatedPerson();
}

package org.familysearch.ct.ws.service.api;

import org.gedcomx.atom.Feed;
import org.gedcomx.conclusion.Person;

/**
 * @author Randy Bliss
 * @author Ryan Heaton
 */
public interface PersonService {

  /**
   * Get the summary for the specified person.
   *
   * @param personId The id of the person for which to get the summary.
   * @return The entity bundle, or null if the summary was not found.
   */
  public EntityBundle<Person> getPersonSummary(String personId);

  /**
   * Get the matches for the specified person.
   *
   * @param personId The id of the person for which to get the list of matches.
   * @return The matches for a person.
   */
  public EntityBundle<Feed> getPersonMatches(String personId);

}

package org.familysearch.ct.ws.service.api;

import org.gedcomx.atom.Feed;
import org.gedcomx.conclusion.Person;

import java.util.Map;

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
  EntityBundle<Person> getPersonSummary(String personId);

  /**
   * Get the matches for the specified person.
   *
   * @param personId The id of the person for which to get the list of matches.
   * @return The matches for a person.
   */
  EntityBundle<Feed> getPersonMatches(String personId);

  /**
   * Search for conclusion persons.
   *
   * @param parameters The search parameters.
   * @return The results of searching for persons.
   * @throws InsufficientQueryException If the query is in some way insufficient.
   */
  Feed searchForPersons(Map<SearchParameter, String> parameters) throws InsufficientQueryException;

  /**
   * Search for matches of conclusion persons.
   *
   * @param parameters The search parameters.
   * @return The results of searching for matches of persons.
   * @throws InsufficientQueryException If the query is in some way insufficient.
   */
  Feed searchForPersonMatches(Map<SearchParameter, String> parameters) throws InsufficientQueryException;
}

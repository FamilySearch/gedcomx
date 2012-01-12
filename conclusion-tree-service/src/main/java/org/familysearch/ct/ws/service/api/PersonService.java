package org.familysearch.ct.ws.service.api;

import java.util.Date;
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
   * Get the timestamp of the summary for the specified person.
   *
   * @param personId The id of the person.
   * @return The last modified timestamp of the summary, or null if
   */
  public Date getSummaryLastModified(String personId);

  /**
   * Get the person summary
   *
   * @param personId The id of the person for which to read the summary.
   * @return The person summary.
   */
  public Person getSummary(String personId);

}

package org.familysearch.ct.service.api.person;

import java.util.Date;
import org.gedcomx.conclusion.Person;

/**
 * @author Randy Bliss
 */
public interface PersonService {

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

  /**
   * Create the person
   * @param person object contains conclusions for person to be created
   * @return person id of newly created person
   */
  public String createPerson(Person person);

  /**
   * Get the person identified by the supplied person id
   * @param personId id of the person that will be returned
   * @return person object of retrieved person corresponding to supplied person id
   */
  public Person getPerson(String personId);
}

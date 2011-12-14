package org.familysearch.ct.service.api.person;

/**
 * @author Randy Bliss
 */
public interface PersonService {
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

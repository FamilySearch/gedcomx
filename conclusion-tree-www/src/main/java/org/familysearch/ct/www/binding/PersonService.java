package org.familysearch.ct.www.binding;

import org.gedcomx.conclusion.Person;

/**
 * @author Ryan Heaton
 */
@Deprecated
public interface PersonService {

  /**
   * Create a person.
   *
   * @param person Person object containing the data for the conclusion tree person that is to be created
   * @param proofStatement The proof statement that was given by the user when the person was created.
   * @return id of the person that was created
   */
  String createPerson(Person person, String proofStatement) throws IllegalArgumentException;

  /**
   * Read a person.
   *
   * @param id The id of the person to be read.
   * @return The person.
   */
  Person readPerson(String id) throws NotFoundException;

  /**
   * Delete a person.
   *
   * @param id The id of the person to delete.
   * @param proofStatement The proof statement that was given by the user for the person to be deleted.
   */
  void deletePerson(String id, String proofStatement);

}

package org.familysearch.ct.www.api;

import org.gedcomx.conclusion.Fact;
import org.gedcomx.conclusion.Gender;
import org.gedcomx.conclusion.Name;
import org.gedcomx.conclusion.Person;

/**
 * @author Ryan Heaton
 */
public interface PersonService {

  /**
   * Create a person.
   *
   * @param living Whether the person is living.
   * @param name The name of the person.
   * @param gender The gender of the person.
   * @param death The death event of the person.
   * @param proofStatement The proof statement that was given by the user when the person was created.
   * @return The person that was created.
   * @throws IllegalArgumentException If...
   */
  Person createPerson(boolean living, Name name, Gender gender, Fact death, String proofStatement);

  /**
   * Read a person.
   *
   * @param id The id of the person to be read.
   * @return The person.
   */
  Person readPerson(String id);

  /**
   * Delete a person.
   *
   * @param id The id of the person to delete.
   * @param proofStatement The proof statement that was given by the user for the person to be deleted.
   */
  void deletePerson(String id, String proofStatement);

}

package org.familysearch.ct.www;

import org.gedcomx.conclusion.Person;
import org.gedcomx.conclusion.www.PersonAPI;
import org.gedcomx.www.rt.APIRefinement;
import org.gedcomx.www.rt.LinkRefinement;
import org.gedcomx.www.rt.StatusCode;

/**
 * @author Ryan Heaton
 */
@APIRefinement ( PersonAPI.class )
public interface PersonService {

  /**
   * Create a person.
   *
   * @param living Whether the person is living.
   * @param proofStatement The proof statement that was given by the user when the person was created.
   * @return The person that was created.
   */
  @LinkRefinement(
    value = PersonAPI.LINK_CREATE,
    statusCodes = {
      @StatusCode( code = 400, condition = "If the proof statement is null or empty")
    }
  )
  Person createPerson(boolean living, String proofStatement);

  /**
   * Read a person.
   *
   * @param id The id of the person to be read.
   * @return The person.
   */
  @LinkRefinement( PersonAPI.LINK_READ )
  Person readPerson(String id);

  /**
   * Delete a person.
   *
   * @param id The id of the person to delete.
   * @param proofStatement The proof statement that was given by the user for the person to be deleted.
   */
  @LinkRefinement(
    value = PersonAPI.LINK_DELETE,
    statusCodes = {
      @StatusCode( code = 400, condition = "If the proof statement is null or empty")
    }
  )
  void deletePerson(String id, String proofStatement);

}

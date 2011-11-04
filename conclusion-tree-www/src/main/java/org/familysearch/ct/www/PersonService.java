package org.familysearch.ct.www;

import org.gedcomx.conclusion.Person;
import org.gedcomx.conclusion.www.PersonAPI;
import org.gedcomx.www.rt.APIRefinement;
import org.gedcomx.www.rt.LinkRefinement;

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
   * @throws javax.ws.rs.WebApplicationException 401 If the current user doesn't have permission to create a person.
   * @throws javax.ws.rs.WebApplicationException 400 If the proof statement is null or empty.
   */
  @LinkRefinement( PersonAPI.LINK_CREATE )
  Person createPerson(boolean living, String proofStatement);

  /**
   * Read a person.
   *
   * @param id The id of the person to be read.
   * @return The person.
   * @throws javax.ws.rs.WebApplicationException 401 If the current user doesn't have permission to read a person.
   * @throws javax.ws.rs.WebApplicationException 403 If the current user doesn't have permission to read the requested person.
   */
  @LinkRefinement( PersonAPI.LINK_READ )
  Person readPerson(String id);

  /**
   * Delete a person.
   *
   * @param id The id of the person to delete.
   * @param proofStatement The proof statement that was given by the user for the person to be deleted.
   * @throws javax.ws.rs.WebApplicationException 401 If the current user doesn't have permission to delete a person.
   * @throws javax.ws.rs.WebApplicationException 403 If the current user doesn't have permission to delete the requested person.
   */
  @LinkRefinement( PersonAPI.LINK_DELETE )
  void deletePerson(String id, String proofStatement);

}

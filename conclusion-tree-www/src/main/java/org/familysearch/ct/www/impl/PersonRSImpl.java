package org.familysearch.ct.www.impl;

import org.familysearch.ct.www.binding.PersonRSBinding;
import org.gedcomx.conclusion.Person;
import org.gedcomx.rs.Link;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

/**
 * @author Ryan Heaton
 */
public class PersonRSImpl implements PersonRSBinding {

  /**
   * Set the proof statement given by the user to support changes to genealogical data.
   *
   * @param proofStatement The proof statement.
   */
  public void setProofStatement(String proofStatement) {
  }

  /**
   * A Person resource is used to create a new person containing the vital conclusions supplied.
   * The successful "created" response will contain the following relevant headers:
   * <table>
   * <tr>
   * <th>header</th>
   * <th>description</th>
   * </tr>
   * <tr>
   * <td>Location</td>
   * <td>URI at which the created person can be obtained.</td>
   * </tr>
   * <tr>
   * <td>X-Entity-ID</td>
   * <td>ID of the created person.</td>
   * </tr>
   * </table>
   *
   * @param person a Person representation POJO which supports FsPerson interface.
   * @return The response.
   */
  public Response createPerson(Person person) {

//    if (person == null) {
//      throw new IllegalArgumentException("No vital person data provided.");
//    }
//    String personId = personService.createPerson(person, "Proof Statement");
//    URI personURI = getRequestUrl().path("..").path(personId).build().normalize();
//    return Response.created(personURI).header("X-Entity-ID", personId).build();
    throw new WebApplicationException(501);
  }


  public Person readPerson(@Context UriInfo uriInfo) {
    String pid = uriInfo.getPathParameters().getFirst("pid");
    Person person = new Person();
    person.setId(pid);
    Link updateLink = new Link();
    updateLink.setRel("self");
    updateLink.setHref(uriInfo.getBaseUriBuilder().path(PersonRSImpl.class).path(PersonRSImpl.class, "readPerson").build(pid));
    person.addExtensionElement(updateLink);
    return person;
  }

  /**
   * Update a person.
   *
   * @param person  The person to be used for the update.
   * @param uriInfo Information on the URI that was used to identify the person to update.
   */
  public void updatePerson(@Context UriInfo uriInfo, Person person) {
  }

  public void deletePerson(@Context UriInfo uriInfo) {
  }

}

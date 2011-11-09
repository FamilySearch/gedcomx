package org.familysearch.ct.www.binding;

import org.gedcomx.conclusion.Person;
import org.gedcomx.conclusion.www.PersonAPI;
import org.gedcomx.www.Link;
import org.gedcomx.www.rt.APIBinding;
import org.gedcomx.www.rt.LinkBinding;
import org.gedcomx.www.rt.StatusCode;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;
import java.net.URI;

/**
 * @author Ryan Heaton
 */
@APIBinding
@Path("/person")
public class PersonEndpoints extends PersonAPI implements PersonRsb {

  @Context
  private PersonService personService;
  private UriBuilder baseUriBuilder;

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
  @POST
  @Path("person")
  @LinkBinding
  public Response createPerson(Person person) {

//    if (person == null) {
//      throw new IllegalArgumentException("No vital person data provided.");
//    }
//    String personId = personService.createPerson(person, "Proof Statement");
//    URI personURI = getRequestUrl().path("..").path(personId).build().normalize();
//    return Response.created(personURI).header("X-Entity-ID", personId).build();
    throw new WebApplicationException(501);
  }


  @GET
  @Path("/{pid}")
  @LinkBinding
  public Person readPerson(@Context UriInfo uriInfo) {
    String pid = uriInfo.getPathParameters().getFirst("pid");
    Person person = personService.readPerson(pid);
    Link updateLink = new Link();
    updateLink.setRel("self");
    updateLink.setHref(uriInfo.getBaseUriBuilder().path(PersonEndpoints.class).path(PersonEndpoints.class, "readPerson").build(pid));
    person.addExtensionElement(updateLink);
    return person;
  }

  @DELETE
  @Path("/{pid}")
  @LinkBinding (
    statusCodes = {
      @StatusCode(code = 400, condition = "The proof statement was not provided." )
    }
  )
  public void deletePerson(@Context UriInfo uriInfo) {
    String pid = uriInfo.getPathParameters().getFirst("pid");
    this.personService.deletePerson(pid, "proof statement");
  }

}

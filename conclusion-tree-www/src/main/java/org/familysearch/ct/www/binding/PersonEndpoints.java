package org.familysearch.ct.www.binding;

import org.familysearch.ct.www.api.PersonService;
import org.gedcomx.conclusion.Person;
import org.gedcomx.conclusion.www.PersonAPI;
import org.gedcomx.www.Link;
import org.gedcomx.www.rt.APIBinding;
import org.gedcomx.www.rt.LinkBinding;
import org.gedcomx.www.rt.StatusCode;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;

/**
 * @author Ryan Heaton
 */
@APIBinding
@Path("/person")
public class PersonEndpoints extends PersonAPI {

  @Context
  private PersonService personService;

  @GET
  @Path("/{pid}")
  @Override
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
  @Override
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

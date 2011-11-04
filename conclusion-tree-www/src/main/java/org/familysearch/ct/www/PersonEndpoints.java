package org.familysearch.ct.www;

import org.gedcomx.conclusion.Person;
import org.gedcomx.conclusion.www.PersonAPI;
import org.gedcomx.www.Link;
import org.gedcomx.www.rt.APIBinding;
import org.gedcomx.www.rt.Deleted;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
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
  public Person readPerson(@Context UriInfo uriInfo) {
    String pid = uriInfo.getPathParameters().getFirst("pid");
    Person person = personService.readPerson(pid);
    Link updateLink = new Link();
    updateLink.setRel(PersonAPI.LINK_DELETE);
    updateLink.setHref(uriInfo.getBaseUriBuilder().path(PersonEndpoints.class).path(PersonEndpoints.class, "deletePerson").build(pid));
    person.addExtensionElement(updateLink);
    return person;
  }

  @DELETE
  @Path("/{pid}")
  @Override
  public Deleted<Person> deletePerson(@Context UriInfo uriInfo) {
    String pid = uriInfo.getPathParameters().getFirst("pid");
    this.personService.deletePerson(pid, "proof statement");
    return new Deleted<Person>(Response.status(Response.Status.NO_CONTENT).build());
  }

}

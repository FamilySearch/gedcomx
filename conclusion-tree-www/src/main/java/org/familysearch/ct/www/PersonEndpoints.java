package org.familysearch.ct.www;

import org.gedcomx.conclusion.Person;
import org.gedcomx.conclusion.www.PersonAPI;
import org.gedcomx.www.Link;
import org.gedcomx.www.rt.Updated;

import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.xml.namespace.QName;

/**
 * @author Ryan Heaton
 */
@Path("/person")
public class PersonEndpoints extends PersonAPI {

  @GET
  @Path("/{pid}")
  @Override
  public Person readPerson(@Context UriInfo uriInfo) {
    String pid = uriInfo.getPathParameters().getFirst("pid");
    Person person = new Person();
    person.setId(pid);
    Link updateLink = new Link();
    updateLink.setRel(new QName(PersonAPI.LINK_UPDATE));
    updateLink.setHref(uriInfo.getRequestUriBuilder().path(PersonEndpoints.class, "updatePerson").build(pid));
    person.addExtensionElement(updateLink);
    return person;
  }

  @PUT
  @Path("/{pid}")
  @Override
  public Updated<Person> updatePerson(@Context UriInfo uriInfo, Person person) {
    return super.updatePerson(uriInfo, person);
  }
}

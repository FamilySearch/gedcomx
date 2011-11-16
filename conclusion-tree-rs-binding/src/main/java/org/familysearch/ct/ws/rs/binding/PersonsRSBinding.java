package org.familysearch.ct.ws.rs.binding;

import org.gedcomx.conclusion.Person;
import org.gedcomx.conclusion.rs.definition.PersonsRSDefinition;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

/**
 * @author Ryan Heaton
 */
@Path ("/persons")
public interface PersonsRSBinding extends PersonsRSDefinition {

  @POST
  @Override
  Response createPerson(@Context UriInfo uriInfo, Person person);
}

package org.familysearch.ct.ws.rs.impl;

import org.gedcomx.conclusion.Person;
import org.gedcomx.conclusion.rs.definition.PersonRSDefinition;
import org.gedcomx.rt.rs.ResponseCode;
import org.gedcomx.rt.rs.StatusCodes;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

/**
 * @author Ryan Heaton
 */
@Path("/persons/{pid}")
public class PersonRSImpl implements PersonRSDefinition {

  @GET
  @Override
  public Response readPerson(@Context UriInfo uriInfo) {
    return null;
  }

  @PUT
  @Override
  public void updatePerson(@Context UriInfo uriInfo, Person person) {

  }

  @DELETE
  @StatusCodes ({
    @ResponseCode (code = 400, condition = "The proof statement is not provided." )
  })
  @Override
  public void deletePerson(@Context UriInfo uriInfo) {

  }

  @Path("/conclusions")
  public ConclusionsRSImpl getConclusionsResource() {
     return new ConclusionsRSImpl();
  }

  @Path("/conclusions/{cid}")
  public ConclusionRSImpl getConclusionResource() {
    return new ConclusionRSImpl();
  }

}

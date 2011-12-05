package org.familysearch.ct.ws.rs.binding;

import org.gedcomx.conclusion.Person;
import org.gedcomx.conclusion.rs.definition.PersonRSDefinition;
import org.gedcomx.rt.rs.ResourceServiceBinding;
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
@ResourceServiceBinding
@Path("/persons/{pid}")
public interface PersonRSBinding extends PersonRSDefinition {

  @GET
  @Override
  Response readPerson(@Context UriInfo uriInfo);

  @PUT
  @Override
  void updatePerson(@Context UriInfo uriInfo, Person person);

  @DELETE
  @StatusCodes ({
    @ResponseCode (code = 400, condition = "The proof statement is not provided." )
  })
  @Override
  void deletePerson(@Context UriInfo uriInfo);

  @Path("/conclusions")
  ConclusionsRSBinding getConclusionsResource();

  @Path("/conclusions/{cid}")
  ConclusionRSBinding getConclusionResource();

}

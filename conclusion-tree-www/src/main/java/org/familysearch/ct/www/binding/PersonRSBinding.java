package org.familysearch.ct.www.binding;

import org.gedcomx.conclusion.Person;
import org.gedcomx.conclusion.www.PersonRSDefinition;
import org.gedcomx.rt.www.ResourceServiceBinding;
import org.gedcomx.rt.www.StatusCode;
import org.gedcomx.rt.www.StatusCodes;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

/**
 * @author Ryan Heaton
 */
@ResourceServiceBinding
@Path("/person")
public interface PersonRSBinding extends PersonRSDefinition {

  @POST
  @StatusCodes({
    @StatusCode(code = 400, condition = "If the proof statement is not provided.")
  })
  Response createPerson(Person person);

  @GET
  @Path("/{pid}")
  public Person readPerson(@Context UriInfo uriInfo);

  @DELETE
  @Path("/{pid}")
  @StatusCodes ({
    @StatusCode (code = 400, condition = "The proof statement is not provided." )
  })
  public void deletePerson(@Context UriInfo uriInfo);

}

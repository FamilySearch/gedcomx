package org.familysearch.ct.www.binding;

import org.gedcomx.conclusion.Person;
import org.gedcomx.www.rt.APIBinding;
import org.gedcomx.www.rt.LinkBinding;
import org.gedcomx.www.rt.StatusCode;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

/**
 * @author Randy Bliss
 */
@APIBinding
@Path("/person")
public interface PersonRsb {
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
  Response createPerson(Person person);

  @GET
  @Path("/{pid}")
  @LinkBinding
  Person readPerson(@Context UriInfo uriInfo);

  @DELETE
  @Path("/{pid}")
  @LinkBinding (
    statusCodes = {
      @StatusCode(code = 400, condition = "The proof statement was not provided." )
    }
  )
  void deletePerson(@Context UriInfo uriInfo);
}

package org.familysearch.ct.www.binding;

import org.familysearch.ct.www.impl.ConclusionCategory;
import org.familysearch.ct.www.impl.ConclusionWrapper;
import org.gedcomx.rt.www.ResourceServiceBinding;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;

/**
 * @author Randy Bliss
 */
@Path("persons/{personId}/conclusions")
@ResourceServiceBinding
public interface ConclusionRsb {
  /**
   * A Conclusion resource is used to create a new conclusion.
   * The successful "created" response will contain the following relevant headers:
   * <table>
   * <tr>
   * <th>header</th>
   * <th>description</th>
   * </tr>
   * </table>
   *
   * @param personId The id of the person that will be updated with the supplied conclusion.
   * @param conclusionWrapper The conclusion that will be updated for the specified person.
   * @return The response.
   */
  @POST
  @Path("conclusion")
  @Consumes( { MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
  
  Response addConclusion(
      @PathParam("personId") String personId,
      ConclusionWrapper conclusionWrapper);

  /**
   * Get a list of conclusions from a person given the person id.
   * <ul>
   * </ul>
   * A Conclusions object is returned containing the list of conclusions.
   * <table>
   * <tr>
   * <th>header</th>
   * <th>description</th>
   * </tr>
   * </table>
   *
   * @param personId The id of the person to get the conclusions for.
   * @param category Specifies the category of conclusions to return (ALL, VITAL, NON_VITAL)
   * @param request The request
   * @return A conclusions object containing the list of conclusions.
   */
  @GET
  @Produces( { MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
  
  Response getConclusions(
      @PathParam("personId") String personId,
      @QueryParam("category") @DefaultValue("ALL") ConclusionCategory category,
      @Context Request request);

  /**
   * Get a conclusion from a person given the conclusion id.
   * <ul>
   * </ul>
   * A ConclusionWrapper is returned with the conclusion data associated with the supplied conclusion id.
   * <table>
   * <tr>
   * <th>header</th>
   * <th>description</th>
   * </tr>
   * </table>
   *
   * @param personId The id of the person to get the conclusion for.
   * @param conclusionId The id of the conclusion that will be returned.
   * @return A conclusion wrapper containing the conclusion.
   */
  @GET
  @Path("{conclusionId}")
  @Produces( { MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
  
  ConclusionWrapper getConclusion(@PathParam("personId") String personId, @PathParam("conclusionId") String conclusionId);

  /**
   * A ConclusionWrapper is used to supply the conclusion to be updated for the specified person.
   * <ul>
   * </ul>
   * The successful "updated" response will contain the following relevant headers:
   * <table>
   * <tr>
   * <th>header</th>
   * <th>description</th>
   * </tr>
   * </table>
   *
   * @param personId The id of the person that will be updated with the supplied conclusion.
   * @param conclusionId The id of the conclusion that will be updated with the supplied conclusion.
   * @param conclusionWrapper The conclusion that will be updated for the specified person.
   * @return The response.
   */
  @PUT
  @Path("{conclusionId}")
  @Consumes( { MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
  
  Response editConclusion(
      @PathParam("personId") String personId,
      @PathParam("conclusionId") String conclusionId,
      ConclusionWrapper conclusionWrapper);

  /**
   * Delete a conclusion from a person given the conclusion id.
   * <ul>
   * </ul>
   * The successful "ok" response indicates that the conclusion was deleted
   *
   * @param personId The id of the person that will be updated with the supplied conclusion.
   * @param conclusionId The id of the conclusion that will be updated with the supplied conclusion.
   * @param reason The reason for deleting the person
   * @return The response.
   */
  @DELETE
  @Path("{conclusionId}")
  @Consumes( { MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
  
  Response deleteConclusion(
      @PathParam("personId") String personId,
      @PathParam("conclusionId") String conclusionId,
      @QueryParam("reason") String reason);
}

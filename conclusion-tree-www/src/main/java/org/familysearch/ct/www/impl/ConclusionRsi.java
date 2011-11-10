package org.familysearch.ct.www.impl;

import org.familysearch.ct.www.binding.ConclusionRSBinding;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;

/**
 * @author Randy Bliss
 */
public class ConclusionRsi implements ConclusionRSBinding {


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
    public Response addConclusion( String personId, ConclusionWrapper conclusionWrapper) {
      return Response.ok().build();
    }

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
    public Response getConclusions( final String personId, final ConclusionCategory category, Request request) {
      return Response.ok().build();
    }

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
    public ConclusionWrapper getConclusion( String personId, String conclusionId) {

      //return getConclusionService().getConclusion(personId, conclusionId);
      return new ConclusionWrapper();
    }

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
    public Response editConclusion( String personId, String conclusionId, ConclusionWrapper conclusionWrapper) {
      return Response.ok().build();
    }

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
    public Response deleteConclusion( String personId, String conclusionId, final String reason) {
      return Response.ok().build();
    }
}

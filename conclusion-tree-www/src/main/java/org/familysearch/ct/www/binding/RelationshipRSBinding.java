package org.familysearch.ct.www.binding;

import org.familysearch.ct.rsd.RelationshipRSDefinition;
import org.familysearch.ct.shema.*;
import org.gedcomx.rt.www.ResourceServiceBinding;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * @author Randy Bliss
 */
@ResourceServiceBinding
public interface RelationshipRSBinding extends RelationshipRSDefinition {

  /**
   * A ParentChildRelationship resource is "POST"ed to the ct/parent-child endpoint to create a new
   * parent-child relationship containing the conclusions supplied.
   * The successful "created" response will contain the following relevant headers:
   * <table>
   * <tr>
   * <th>header</th>
   * <th>description</th>
   * </tr>
   * <tr>
   * <td>Location</td>
   * <td>URI at which the created parent-child relationship can be obtained.</td>
   * </tr>
   * <tr>
   * <td>X-Entity-ID</td>
   * <td>ID of the created parent-child relationship.</td>
   * </tr>
   * </table>
   *
   * @param parentChildRelationship ParentChildRelationship POJO which supports FsParentChildRelationship interface
   * @return The response.
   */
  @POST
  @Consumes( { "application/xml", "application/json", "application/familysearch-ct-v1+xml" })
  Response createParentChildRelationship(TernaryRelationship parentChildRelationship);

  /**
   * Get parentChildRelationship specified by parentChildRelationshipId
   *
   * @param parentChildRelationshipId The id of the parentChildRelationship whose data will be returned.
   * @param conclusionScope How much conclusion data is desired
   * @return The desired parentChildRelationship object.
   */
  @GET
  @Path("{parentChildRelationshipId}")
  @Produces( { "application/xml", "application/json", "application/familysearch-ct-v1+xml" })
  TernaryRelationship getParentChildRelationship(@PathParam("parentChildRelationshipId") String parentChildRelationshipId, @QueryParam("conclusionScope") @DefaultValue("SUMMARY") ConclusionScope conclusionScope);

  /**
   * Edit the contribution tracked id of the father in the parentChildRelationship with the specified identifier.
   *
   * @param parentChildRelationshipId is the identifier of the parentChildRelationship to be updated.
   * @param fatherId is the contribution tracked id data that will be used to update the
   * father in parentChildRelationship with the specified identifier.
   * @return The response.
   */
  @PUT
  @Path("{parentChildRelationshipId}/father")
  @Consumes( { "application/xml", "application/json", "application/familysearch-ct-v1+xml" })
  public Response editFather(@PathParam("parentChildRelationshipId") String parentChildRelationshipId, ContributionTrackedId fatherId);

  /**
   * Edit the contribution tracked id of the mother in the parentChildRelationship with the specified identifier.
   *
   * @param parentChildRelationshipId is the identifier of the parentChildRelationship to be updated.
   * @param motherId is the contribution tracked id data that will be used to update the
   * mother in parentChildRelationship with the specified identifier.
   * @return The response.
   */
  @PUT
  @Path("{parentChildRelationshipId}/mother")
  @Consumes( { "application/xml", "application/json", "application/familysearch-ct-v1+xml" })
  public Response editMother(@PathParam("parentChildRelationshipId") String parentChildRelationshipId, ContributionTrackedId motherId);

  /**
   * Edit the contribution tracked id of the child in the parentChildRelationship with the specified identifier.
   *
   * @param parentChildRelationshipId is the identifier of the parentChildRelationship to be updated.
   * @param childId is the contribution tracked id data that will be used to update the
   * child in parentChildRelationship with the specified identifier.
   * @return The response.
   */
  @PUT
  @Path("{parentChildRelationshipId}/child")
  @Consumes( { "application/xml", "application/json", "application/familysearch-ct-v1+xml" })
  public Response editChild(@PathParam("parentChildRelationshipId") String parentChildRelationshipId, ContributionTrackedId childId);

  /**
   * Edit the father-child lineage declaration of the parent-child relationship with the specified identifier.
   *
   * @param parentChildRelationshipId is the identifier of the parent-child relationship to be updated.
   * @param lineageDeclaration is the father-child lineage declaration data that will be used to update the
   * parent-child relationship with the specified identifier.
   * @return The response.
   */
  @PUT
  @Path("{parentChildRelationshipId}/father-child-lineage")
  @Consumes( { "application/xml", "application/json", "application/familysearch-ct-v1+xml" })
  public Response editFatherChildLineage(@PathParam("parentChildRelationshipId") String parentChildRelationshipId, LineageDeclaration lineageDeclaration);

  /**
   * Edit the mother-child lineage declaration of the parent-child relationship with the specified identifier.
   *
   * @param parentChildRelationshipId is the identifier of the parent-child relationship to be updated.
   * @param lineageDeclaration is the mother-child lineage declaration data that will be used to update the
   * parent-child relationship with the specified identifier.
   * @return The response.
   */
  @PUT
  @Path("{parentChildRelationshipId}/mother-child-lineage")
  @Consumes( { "application/xml", "application/json", "application/familysearch-ct-v1+xml" })
  public Response editMotherChildLineage(@PathParam("parentChildRelationshipId") String parentChildRelationshipId, LineageDeclaration lineageDeclaration);

  /**
   * Delete the specified parentChildRelationship.
   *
   * @param parentChildRelationshipId The parentChildRelationshipId of the parentChildRelationship to be deleted.
   * @return The HTTP response including the appropriate header information.
   */
  @DELETE
  @Path("{parentChildRelationshipId}")
  public Response deleteParentChildRelationship(@PathParam("parentChildRelationshipId") String parentChildRelationshipId);

  /**
   * Merge parent-child relationships according to the specified merge specification
   *
   * @param parentChildRelationshipId is the identifier of the surviving parent-child relationship to merge.
   * @param duplicateParentChildRelationshipId is the identifier of the duplicate parent-child relationship to merge
   * @param spec is the specification of how the relationship merge is to proceed
   * @return The HTTP response OK
   */
  @POST
  @Path("{parentChildRelationshipId}/merge/{duplicateParentChildRelationshipId}")
  @Consumes( { MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON, "application/familysearch-ct-v1+xml" })
  public Response mergeParentChildRelationships(@PathParam("parentChildRelationshipId") String parentChildRelationshipId, @PathParam("duplicateParentChildRelationshipId") String duplicateParentChildRelationshipId, RelationshipMergeSpecification spec);
}
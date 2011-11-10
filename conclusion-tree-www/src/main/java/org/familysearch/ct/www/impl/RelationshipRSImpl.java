package org.familysearch.ct.www.impl;

import org.familysearch.ct.ws.*;
import org.familysearch.ct.www.binding.RelationshipRSBinding;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

/**
 * @author Randy Bliss
 */
public class RelationshipRSImpl implements RelationshipRSBinding {
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
  public Response createParentChildRelationship(TernaryRelationship parentChildRelationship) {
    throw new WebApplicationException(501);
  }

  /**
   * Get parentChildRelationship specified by parentChildRelationshipId
   *
   * @param parentChildRelationshipId The id of the parentChildRelationship whose data will be returned.
   * @param conclusionScope           How much conclusion data is desired
   * @return The desired parentChildRelationship object.
   */
  public TernaryRelationship getParentChildRelationship(String parentChildRelationshipId, ConclusionScope conclusionScope) {
    throw new WebApplicationException(501);
  }

  /**
   * Edit the contribution tracked id of the father in the parentChildRelationship with the specified identifier.
   *
   * @param parentChildRelationshipId is the identifier of the parentChildRelationship to be updated.
   * @param fatherId                  is the contribution tracked id data that will be used to update the
   *                                  father in parentChildRelationship with the specified identifier.
   * @return The response.
   */
  public Response editFather(String parentChildRelationshipId, ContributionTrackedId fatherId) {
    throw new WebApplicationException(501);
  }

  /**
   * Edit the contribution tracked id of the mother in the parentChildRelationship with the specified identifier.
   *
   * @param parentChildRelationshipId is the identifier of the parentChildRelationship to be updated.
   * @param motherId                  is the contribution tracked id data that will be used to update the
   *                                  mother in parentChildRelationship with the specified identifier.
   * @return The response.
   */
  public Response editMother(String parentChildRelationshipId, ContributionTrackedId motherId) {
    throw new WebApplicationException(501);
  }

  /**
   * Edit the contribution tracked id of the child in the parentChildRelationship with the specified identifier.
   *
   * @param parentChildRelationshipId is the identifier of the parentChildRelationship to be updated.
   * @param childId                   is the contribution tracked id data that will be used to update the
   *                                  child in parentChildRelationship with the specified identifier.
   * @return The response.
   */
  public Response editChild(String parentChildRelationshipId, ContributionTrackedId childId) {
    throw new WebApplicationException(501);
  }

  /**
   * Edit the father-child lineage declaration of the parent-child relationship with the specified identifier.
   *
   * @param parentChildRelationshipId is the identifier of the parent-child relationship to be updated.
   * @param lineageDeclaration        is the father-child lineage declaration data that will be used to update the
   *                                  parent-child relationship with the specified identifier.
   * @return The response.
   */
  public Response editFatherChildLineage(String parentChildRelationshipId, LineageDeclaration lineageDeclaration) {
    throw new WebApplicationException(501);
  }

  /**
   * Edit the mother-child lineage declaration of the parent-child relationship with the specified identifier.
   *
   * @param parentChildRelationshipId is the identifier of the parent-child relationship to be updated.
   * @param lineageDeclaration        is the mother-child lineage declaration data that will be used to update the
   *                                  parent-child relationship with the specified identifier.
   * @return The response.
   */
  public Response editMotherChildLineage(String parentChildRelationshipId, LineageDeclaration lineageDeclaration) {
    throw new WebApplicationException(501);
  }

  /**
   * Delete the specified parentChildRelationship.
   *
   * @param parentChildRelationshipId The parentChildRelationshipId of the parentChildRelationship to be deleted.
   * @return The HTTP response including the appropriate header information.
   */
  public Response deleteParentChildRelationship(String parentChildRelationshipId) {
    throw new WebApplicationException(501);
  }

  /**
   * Merge parent-child relationships according to the specified merge specification
   *
   * @param parentChildRelationshipId is the identifier of the surviving parent-child relationship to merge.
   * @param duplicateParentChildRelationshipId
   *                                  is the identifier of the duplicate parent-child relationship to merge
   * @param spec                      is the specification of how the relationship merge is to proceed
   * @return The HTTP response OK
   */
  public Response mergeParentChildRelationships(String parentChildRelationshipId, String duplicateParentChildRelationshipId, RelationshipMergeSpecification spec) {
    throw new WebApplicationException(501);
  }
}

package org.familysearch.ct.www.impl;

import org.familysearch.ct.rsd.RelationshipRsd;
import org.familysearch.ct.shema.*;
import org.familysearch.ct.www.binding.RelationshipRsb;

import javax.ws.rs.core.Response;

/**
 * @author Randy Bliss
 */
public class RelationshipRsi extends RelationshipRsd implements RelationshipRsb {
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
  @Override
  public Response createParentChildRelationship(TernaryRelationship parentChildRelationship) {
    return super.createParentChildRelationship(parentChildRelationship);    //To change body of overridden methods use File | Settings | File Templates.
  }

  /**
   * Get parentChildRelationship specified by parentChildRelationshipId
   *
   * @param parentChildRelationshipId The id of the parentChildRelationship whose data will be returned.
   * @param conclusionScope           How much conclusion data is desired
   * @return The desired parentChildRelationship object.
   */
  @Override
  public TernaryRelationship getParentChildRelationship(String parentChildRelationshipId, ConclusionScope conclusionScope) {
    return super.getParentChildRelationship(parentChildRelationshipId, conclusionScope);    //To change body of overridden methods use File | Settings | File Templates.
  }

  /**
   * Edit the contribution tracked id of the father in the parentChildRelationship with the specified identifier.
   *
   * @param parentChildRelationshipId is the identifier of the parentChildRelationship to be updated.
   * @param fatherId                  is the contribution tracked id data that will be used to update the
   *                                  father in parentChildRelationship with the specified identifier.
   * @return The response.
   */
  @Override
  public Response editFather(String parentChildRelationshipId, ContributionTrackedId fatherId) {
    return super.editFather(parentChildRelationshipId, fatherId);    //To change body of overridden methods use File | Settings | File Templates.
  }

  /**
   * Edit the contribution tracked id of the mother in the parentChildRelationship with the specified identifier.
   *
   * @param parentChildRelationshipId is the identifier of the parentChildRelationship to be updated.
   * @param motherId                  is the contribution tracked id data that will be used to update the
   *                                  mother in parentChildRelationship with the specified identifier.
   * @return The response.
   */
  @Override
  public Response editMother(String parentChildRelationshipId, ContributionTrackedId motherId) {
    return super.editMother(parentChildRelationshipId, motherId);    //To change body of overridden methods use File | Settings | File Templates.
  }

  /**
   * Edit the contribution tracked id of the child in the parentChildRelationship with the specified identifier.
   *
   * @param parentChildRelationshipId is the identifier of the parentChildRelationship to be updated.
   * @param childId                   is the contribution tracked id data that will be used to update the
   *                                  child in parentChildRelationship with the specified identifier.
   * @return The response.
   */
  @Override
  public Response editChild(String parentChildRelationshipId, ContributionTrackedId childId) {
    return super.editChild(parentChildRelationshipId, childId);    //To change body of overridden methods use File | Settings | File Templates.
  }

  /**
   * Edit the father-child lineage declaration of the parent-child relationship with the specified identifier.
   *
   * @param parentChildRelationshipId is the identifier of the parent-child relationship to be updated.
   * @param lineageDeclaration        is the father-child lineage declaration data that will be used to update the
   *                                  parent-child relationship with the specified identifier.
   * @return The response.
   */
  @Override
  public Response editFatherChildLineage(String parentChildRelationshipId, LineageDeclaration lineageDeclaration) {
    return super.editFatherChildLineage(parentChildRelationshipId, lineageDeclaration);    //To change body of overridden methods use File | Settings | File Templates.
  }

  /**
   * Edit the mother-child lineage declaration of the parent-child relationship with the specified identifier.
   *
   * @param parentChildRelationshipId is the identifier of the parent-child relationship to be updated.
   * @param lineageDeclaration        is the mother-child lineage declaration data that will be used to update the
   *                                  parent-child relationship with the specified identifier.
   * @return The response.
   */
  @Override
  public Response editMotherChildLineage(String parentChildRelationshipId, LineageDeclaration lineageDeclaration) {
    return super.editMotherChildLineage(parentChildRelationshipId, lineageDeclaration);    //To change body of overridden methods use File | Settings | File Templates.
  }

  /**
   * Delete the specified parentChildRelationship.
   *
   * @param parentChildRelationshipId The parentChildRelationshipId of the parentChildRelationship to be deleted.
   * @return The HTTP response including the appropriate header information.
   */
  @Override
  public Response deleteParentChildRelationship(String parentChildRelationshipId) {
    return super.deleteParentChildRelationship(parentChildRelationshipId);    //To change body of overridden methods use File | Settings | File Templates.
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
  @Override
  public Response mergeParentChildRelationships(String parentChildRelationshipId, String duplicateParentChildRelationshipId, RelationshipMergeSpecification spec) {
    return super.mergeParentChildRelationships(parentChildRelationshipId, duplicateParentChildRelationshipId, spec);    //To change body of overridden methods use File | Settings | File Templates.
  }
}

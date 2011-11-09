/**
 * Copyright 2011 Intellectual Reserve, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.familysearch.ct.rsd;

import org.familysearch.ct.shema.*;
import org.gedcomx.rt.www.LinkDefinition;
import org.gedcomx.rt.www.ResourceServiceDefinition;
import org.gedcomx.rt.www.StatusCode;
import org.gedcomx.rt.www.StatusCodes;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import javax.xml.bind.annotation.XmlTransient;

/**
 * @author Randy Bliss
 */
@XmlTransient
@ResourceServiceDefinition(
    name = "Relationship"
)
@StatusCodes({
        @StatusCode(code = 401, condition = "If authentication is needed, or if the supplied authentication is expired or otherwise invalid."),
        @StatusCode(code = 403, condition = "If the link is forbidden even after considering a possibly valid authentication."),
        @StatusCode(code = 501, condition = "If the link is not supported by the implementation.")
    })
public abstract class RelationshipRsd {


  public static final String LINK_RELATIONSHIP_LABEL = "relationship";

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
  @LinkDefinition(LINK_RELATIONSHIP_LABEL)
  @POST
  @StatusCodes({
    @StatusCode(code = 201, condition = "The creation of the person was successful. Expect a location header specifying the link to the created person.")
  })
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
  @LinkDefinition( LINK_RELATIONSHIP_LABEL )
  @StatusCodes({
          @StatusCode(code = 200, condition = "Upon a successful read."),
          @StatusCode(code = 301, condition = "If the requested relationship has been merged to another relationship."),
          @StatusCode(code = 404, condition = "If the requested relationship is not found."),
          @StatusCode(code = 410, condition = "If the requested relationship has been deleted.")
      })
  @GET
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
  @LinkDefinition( LINK_RELATIONSHIP_LABEL )
  @StatusCodes({
          @StatusCode(code = 200, condition = "Upon a successful edit"),
          @StatusCode(code = 404, condition = "If the requested relationship is not found"),
          @StatusCode(code = 410, condition = "If the requested relationship has been deleted")
      })
  @PUT
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
  @LinkDefinition( LINK_RELATIONSHIP_LABEL )
  @StatusCodes({
          @StatusCode(code = 200, condition = "Upon a successful edit"),
          @StatusCode(code = 404, condition = "If the requested relationship is not found"),
          @StatusCode(code = 410, condition = "If the requested relationship has been deleted")
      })
  @PUT
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
  @LinkDefinition( LINK_RELATIONSHIP_LABEL )
  @StatusCodes({
          @StatusCode(code = 200, condition = "Upon a successful edit"),
          @StatusCode(code = 404, condition = "If the requested relationship is not found"),
          @StatusCode(code = 410, condition = "If the requested relationship has been deleted")
      })
  @PUT
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
  @LinkDefinition( LINK_RELATIONSHIP_LABEL )
  @StatusCodes({
          @StatusCode(code = 200, condition = "Upon a successful edit of father child lineage"),
          @StatusCode(code = 404, condition = "If the requested relationship is not found"),
          @StatusCode(code = 410, condition = "If the requested relationship has been deleted")
      })
  @PUT
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
  @LinkDefinition( LINK_RELATIONSHIP_LABEL )
  @PUT
  @StatusCodes({
          @StatusCode(code = 200, condition = "Upon a successful edit"),
          @StatusCode(code = 404, condition = "If the requested relationship is not found"),
          @StatusCode(code = 410, condition = "If the requested relationship has been deleted")
      })
  public Response editMotherChildLineage(String parentChildRelationshipId, LineageDeclaration lineageDeclaration) {
    throw new WebApplicationException(501);
  }

  /**
   * Delete the specified parentChildRelationship.
   *
   * @param parentChildRelationshipId The parentChildRelationshipId of the parentChildRelationship to be deleted.
   * @return The HTTP response including the appropriate header information.
   */
  @LinkDefinition( LINK_RELATIONSHIP_LABEL )
  @DELETE
  @StatusCodes({
          @StatusCode(code = 200, condition = "Upon a successful edit"),
          @StatusCode(code = 404, condition = "If the requested relationship is not found"),
          @StatusCode(code = 410, condition = "If the requested relationship has been deleted")
      })
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
  @LinkDefinition( LINK_RELATIONSHIP_LABEL )
  @POST
  @StatusCodes({
          @StatusCode(code = 201, condition = "Upon a successful relationship merge"),
          @StatusCode(code = 404, condition = "If the requested relationship is not found"),
          @StatusCode(code = 410, condition = "If the requested relationship has been deleted")
      })
  public Response mergeParentChildRelationships(String parentChildRelationshipId, String duplicateParentChildRelationshipId, RelationshipMergeSpecification spec) {
    throw new WebApplicationException(501);
  }
}

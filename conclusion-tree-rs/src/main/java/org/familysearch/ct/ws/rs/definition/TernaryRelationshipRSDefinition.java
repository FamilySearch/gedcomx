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
package org.familysearch.ct.ws.rs.definition;

import org.familysearch.ct.ws.ConclusionTreeModel;
import org.familysearch.ct.ws.TernaryRelationship;
import org.gedcomx.conclusion.rs.definition.RelationshipRSDefinition;
import org.gedcomx.rt.rs.*;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

/**
 * @author Randy Bliss
 */
/**
 * The relationship resource service is used to manage a conclusion relationship.
 *
 * @author Ryan Heaton
 */
@ResourceDefinition (
  name = "TernaryRelationship",
  namespace = ConclusionTreeModel.CONCLUSION_TREE_V1_NAMESPACE,
  resourceElement = TernaryRelationship.class,
  subresources = RelationshipRSDefinition.class
)
@ResourceRelationships ({
  @ResourceRelationship ( identifier = "self", definedBy = RelationshipRSDefinition.class, description = "The relationship itself." )
})
public interface TernaryRelationshipRSDefinition {

  /**
   * Read a relationship.
   *
   * @param uriInfo Information on the URI that was used to identify the relationship to read.
   * @return The relationship.
   */
  @GET
  @StatusCodes({
    @ResponseCode( code = 200, condition = "Upon a successful read."),
    @ResponseCode( code = 301, condition = "If the requested relationship has been merged to another relationship."),
    @ResponseCode( code = 404, condition = "If the requested relationship is not found."),
    @ResponseCode( code = 410, condition = "If the requested relationship has been deleted.")
  })
  Response readRelationship(@Context UriInfo uriInfo);

  /**
   * Update a relationship.
   *
   * @param relationship The relationship to be used for the update.
   * @param uriInfo Information on the URI that was used to identify the relationship to update.
   */
  @PUT
  @StatusCodes({
    @ResponseCode( code = 204, condition = "The update was successful.")
  })
  void updateRelationship(@Context UriInfo uriInfo, TernaryRelationship relationship);

  /**
   * Delete a relationship.
   *
   * @param uriInfo Information on the URI that was used to identify the relationship to delete.
   */
  @DELETE
  @StatusCodes({
    @ResponseCode ( code = 204, condition = "The delete was successful.")
  })
  void deleteRelationship(@Context UriInfo uriInfo);

}

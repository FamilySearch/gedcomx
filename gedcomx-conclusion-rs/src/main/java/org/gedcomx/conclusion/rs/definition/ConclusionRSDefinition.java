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
package org.gedcomx.conclusion.rs.definition;

import org.gedcomx.conclusion.*;
import org.gedcomx.rt.rs.*;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;

/**
 * The conclusion resource service is used to manage a conclusion.
 *
 * @author Ryan Heaton
 */
@ResourceServiceDefinition (
  name = "Conclusion",
  namespace = ConclusionModel.GEDCOMX_CONCLUSION_V1_NAMESPACE,
  resourceElement = { Name.class, Gender.class, Fact.class }
)
@ResourceRelationships ({
  @ResourceRelationship ( identifier = "self", definedBy = ConclusionRSDefinition.class, description = "The conclusion itself." )
})
public interface ConclusionRSDefinition extends CommonRSParameters {

  /**
   * Read a conclusion.
   *
   * @param uriInfo Information on the URI that was used to identify the conclusion to read.
   * @return The conclusion.
   */
  @GET
  @StatusCodes({
    @ResponseCode ( code = 200, condition = "A successful read."),
    @ResponseCode ( code = 404, condition = "If the requested conclusion is not found."),
    @ResponseCode ( code = 410, condition = "If the requested conclusion has been deleted.")
  })
  Conclusion readConclusion(@Context UriInfo uriInfo);

  /**
   * Update a conclusion.
   *
   * @param conclusion The conclusion to be used for the update.
   * @param uriInfo Information on the URI that was used to identify the conclusion to update.
   */
  @PUT
  @StatusCodes({
    @ResponseCode ( code = 204, condition = "The update was successful.")
  })
  void updateConclusion(@Context UriInfo uriInfo, Conclusion conclusion);

  /**
   * Delete a conclusion.
   *
   * @param uriInfo Information on the URI that was used to identify the conclusion to delete.
   */
  @DELETE
  @StatusCodes({
    @ResponseCode ( code = 204, condition = "The delete was successful.")
  })
  void deleteConclusion(@Context UriInfo uriInfo);

}

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
import javax.ws.rs.core.Response;

/**
 * The conclusion resource service is used to manage a conclusion.
 *
 * @author Ryan Heaton
 */
@ResourceDefinition (
  name = "Conclusion",
  resourceElement = { Name.class, Gender.class, Fact.class },
  namespace = ConclusionModel.GEDCOMX_CONCLUSION_V1_NAMESPACE,
  subresources = { ConclusionRSDefinition.class, ConclusionsRSDefinition.class }
)
@ResourceRelationships ({
  @ResourceRelationship ( identifier = "self", definedBy = ConclusionRSDefinition.class, description = "The conclusion itself." )
})
public interface ConclusionRSDefinition extends CommonRSParameters {

  public static final String REL = CommonRSParameters.GEDCOMX_LINK_REL_PREFIX + "conclusions";

  /**
   * Read a conclusion.
   *
   * @return The conclusion.
   */
  @GET
  @StatusCodes({
    @ResponseCode ( code = 200, condition = "Upon a successful read."),
    @ResponseCode ( code = 404, condition = "If the requested conclusion is not found.")
  })
  Response get();

  /**
   * Update a conclusion.
   *
   * @param conclusion The conclusion to be used for the update.
   *
   */
  @PUT
  @StatusCodes({
    @ResponseCode ( code = 204, condition = "The update was successful."),
    @ResponseCode ( code = 404, condition = "If the requested conclusion is not found.")
  })
  Response put(Conclusion conclusion);

  /**
   * Delete a conclusion.
   *
   */
  @DELETE
  @StatusCodes({
    @ResponseCode ( code = 204, condition = "The delete was successful.")
  })
  Response delete();
}

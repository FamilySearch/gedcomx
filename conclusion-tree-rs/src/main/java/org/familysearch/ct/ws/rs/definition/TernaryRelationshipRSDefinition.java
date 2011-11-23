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

import org.familysearch.ct.ws.TernaryRelationship;
import org.gedcomx.conclusion.rs.definition.RelationshipRSDefinition;
import org.gedcomx.rt.rs.ResourceServiceDefinition;
import org.gedcomx.rt.rs.StatusCode;
import org.gedcomx.rt.rs.StatusCodes;

import javax.ws.rs.PUT;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;

/**
 * @author Randy Bliss
 */
/**
 * The relationship resource service is used to manage a conclusion relationship.
 *
 * @author Ryan Heaton
 */
@ResourceServiceDefinition (
  name = "TernaryRelationship"
)
public interface TernaryRelationshipRSDefinition extends RelationshipRSDefinition {

  /**
   * Update a relationship.
   *
   * @param relationship The relationship to be used for the update.
   * @param uriInfo Information on the URI that was used to identify the relationship to update.
   */
  @PUT
  @StatusCodes({
    @StatusCode( code = 204, condition = "The update was successful.")
  })
  void updateRelationship(@Context UriInfo uriInfo, TernaryRelationship relationship);

}

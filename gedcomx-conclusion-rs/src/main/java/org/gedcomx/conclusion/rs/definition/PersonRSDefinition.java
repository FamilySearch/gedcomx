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

import org.gedcomx.conclusion.ConclusionModel;
import org.gedcomx.conclusion.Person;
import org.gedcomx.rt.rs.*;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

/**
 * The person resource service is used to manage a conclusion person.
 *
 * @author Ryan Heaton
 */
@ResourceServiceDefinition (
  name = "Person",
  resourceElement = Person.class,
  namespace = ConclusionModel.GEDCOMX_CONCLUSION_V1_NAMESPACE,
  subresources = { ConclusionRSDefinition.class, ConclusionsRSDefinition.class }
)
@ResourceRelationships({
  @ResourceRelationship ( name = "self", definedBy = PersonRSDefinition.class, description = "The person itself." ),
  @ResourceRelationship ( name = "parent-child-relationship", definedBy = RelationshipRSDefinition.class, description = "The parent-child relationships for a person." )
})
public interface PersonRSDefinition extends CommonRSParameters {

  /**
   * Read a person.
   *
   * @param uriInfo Information on the URI that was used to identify the person to read.
   * @return The person.
   */
  @GET
  @StatusCodes({
    @ResponseCode ( code = 200, condition = "Upon a successful read."),
    @ResponseCode ( code = 301, condition = "If the requested person has been merged to another person."),
    @ResponseCode ( code = 404, condition = "If the requested person is not found."),
    @ResponseCode ( code = 410, condition = "If the requested person has been deleted.")
  })
  Response readPerson(@Context UriInfo uriInfo);

  /**
   * Update a person.
   *
   * @param person The person to be used for the update.
   * @param uriInfo Information on the URI that was used to identify the person to update.
   */
  @PUT
  @StatusCodes({
    @ResponseCode ( code = 204, condition = "The update was successful.")
  })
  void updatePerson(@Context UriInfo uriInfo, Person person);

  /**
   * Delete a person.
   *
   * @param uriInfo Information on the URI that was used to identify the person to delete.
   */
  @DELETE
  @StatusCodes({
    @ResponseCode ( code = 204, condition = "The delete was successful.")
  })
  void deletePerson(@Context UriInfo uriInfo);

}

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

import org.gedcomx.common.ResourceSet;
import org.gedcomx.conclusion.ConclusionModel;
import org.gedcomx.conclusion.Person;
import org.gedcomx.rt.rs.ResourceServiceDefinition;
import org.gedcomx.rt.rs.StatusCode;
import org.gedcomx.rt.rs.StatusCodes;

import javax.ws.rs.POST;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

/**
 * The persons resource service is used to manage a collection of persons.
 *
 * @author Ryan Heaton
 */
@ResourceServiceDefinition (
  name = "Persons",
  namespace = ConclusionModel.GEDCOMX_CONCLUSION_V1_NAMESPACE,
  resourceElement = ResourceSet.class,
  subresources = PersonRSDefinition.class
)
public interface PersonsRSDefinition extends CommonRSParameters {

  /**
   * Create a person.
   *
   * @param uriInfo Information on the URI that was used to identify the collection in which the person is to be created.
   * @param person The person to be created.
   * @return The appropriate response.
   */
  @POST
  @StatusCodes({
    @StatusCode( code = 201, condition = "The creation of the person was successful. Expect a location header specifying the link to the created person.")
  })
  Response createPerson(@Context UriInfo uriInfo, Person person);

}

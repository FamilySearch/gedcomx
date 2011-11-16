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

import org.gedcomx.conclusion.Conclusion;
import org.gedcomx.rt.www.ResourceServiceDefinition;
import org.gedcomx.rt.www.StatusCode;
import org.gedcomx.rt.www.StatusCodes;

import javax.ws.rs.POST;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

/**
 * The conclusions resource service is used to manage a collection of conclusions.
 *
 * @author Ryan Heaton
 */
@ResourceServiceDefinition (
  name = "Conclusions"
)
public interface ConclusionsRSDefinition extends CommonRSDefinition {

  /**
   * Get a set of conclusions.
   *
   * @param uriInfo Information on the URI that was used to identify the conclusions.
   * @return The set of conclusions.
   */
  @POST
  @StatusCodes({
    @StatusCode( code = 200, condition = "Upon a successful read.")
  })
  Response readConclusions(@Context UriInfo uriInfo);

  /**
   * Create a conclusion.
   *
   * @param uriInfo Information on the URI that was used to identify the collection in which the conclusion is to be created.
   * @param conclusion The conclusion to be created.
   * @return The appropriate response.
   */
  @POST
  @StatusCodes({
    @StatusCode( code = 201, condition = "The creation of the conclusion was successful. Expect a location header specifying the link to the created conclusion.")
  })
  Response createConclusion(@Context UriInfo uriInfo, Conclusion conclusion);

}

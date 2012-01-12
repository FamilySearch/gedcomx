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

import javax.ws.rs.GET;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

/**
 * <p>The person summary resource defines a subset of information about a person, optimized for a summary view. The person summary is especially useful
 * for applications when providing quick access to the most useful data about a person, such as when retrieving a pedigree or when providing search
 * results.</p>
 *
 * <p>A person summary should contain at least the following (if available):</p>
 *
 * <ul>
 *   <li>living status</li>
 *   <li>preferred name</li>
 *   <li>gender</li>
 *   <li>birth</li>
 *   <li>death</li>
 * </ul>
 *
 * <p>Applications may choose to provide additional information to meet the specific requirements of their products.</p>
 *
 * <p>Note that the <tt>person</tt> element is used as the data format for the person summary resource, but the person summary resource is distinct from
 * the person resource.</p>
 *
 * @author Ryan Heaton
 */
@ResourceDefinition (
  name = "PersonSummary",
  resourceElement = Person.class,
  namespace = ConclusionModel.GEDCOMX_CONCLUSION_V1_NAMESPACE,
  subresources = { ConclusionRSDefinition.class, ConclusionsRSDefinition.class }
)
@ResourceRelationships({
  @ResourceRelationship ( identifier = "self", definedBy = PersonSummaryRSDefinition.class, description = "The person summary itself." ),
  @ResourceRelationship ( identifier = PersonRSDefinition.REL, definedBy = PersonRSDefinition.class, description = "The person for which this is a summary." )
})
public interface PersonSummaryRSDefinition extends CommonRSParameters {

  public static final String REL = CommonRSParameters.GEDCOMX_LINK_REL_PREFIX + "person/summary";

  /**
   * Read a person summary.
   *
   * @param uriInfo Information on the URI that was used to identify the person to read.
   * @return The person summary.
   */
  @GET
  @StatusCodes({
    @ResponseCode ( code = 200, condition = "Upon a successful read."),
    @ResponseCode ( code = 301, condition = "If the person summary has moved, such as when the person associated with the person summary has been merged to another person."),
    @ResponseCode ( code = 404, condition = "If the requested person summary is not found."),
    @ResponseCode ( code = 410, condition = "If the requested person summary has been deleted.")
  })
  Response readPersonSummary(@Context UriInfo uriInfo);

}

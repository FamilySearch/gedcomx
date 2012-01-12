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

import org.gedcomx.rt.rs.*;
import org.gedcomx.xrd.XRD;
import org.gedcomx.xrd.XRDModel;

import javax.ws.rs.GET;
import javax.ws.rs.core.Response;

/**
 * The discovery resource is used to discover application (or "host") -level metadata. Such metadata could include links to the various resources
 * that the system supports and links to the authentication and authorization policies that the system applies. For more information about the
 * discover resource, see <a href="http://tools.ietf.org/html/draft-hammer-hostmeta">http://tools.ietf.org/html/draft-hammer-hostmeta</a>.
 *
 * @author Mike Gardiner
 * @author Ryan Heaton
 */
@ResourceDefinition(
    name = "Discovery",
    resourceElement = XRD.class,
    namespace = XRDModel.XRD_V1_NAMESPACE
)
@ResourceRelationships({
  @ResourceRelationship(identifier = PersonsRSDefinition.REL, definedBy = DiscoveryRSDefinition.class, description = "A set of persons making up a family conclusion tree.")
})
public interface DiscoveryRSDefinition extends CommonRSParameters {

  /**
   * Read the host metadata.
   *
   * @return The host metadata.
   */
  @GET
  @StatusCodes({
    @ResponseCode(code = 200, condition = "Upon a successful read.")
  })
  Response readHostMetadata();

}

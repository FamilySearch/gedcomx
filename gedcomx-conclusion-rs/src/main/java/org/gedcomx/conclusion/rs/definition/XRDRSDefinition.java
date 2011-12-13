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
 * @author Mike Gardiner
 */
@ResourceDefinition(
  name = "XRD",
  resourceElement = XRD.class,
  namespace = XRDModel.XRD_V1_NAMESPACE
)
@ResourceRelationships({
  @ResourceRelationship( identifier = "self", definedBy = XRDRSDefinition.class, description = "The XRD itself." )
})
public interface XRDRSDefinition extends CommonRSParameters {

  /**
   * Read the XRD.
   *
   * @return The XRD.
   */
  @GET
  @StatusCodes({
    @ResponseCode( code = 200, condition = "Upon a successful read.")
  })
  Response readXRD();

}

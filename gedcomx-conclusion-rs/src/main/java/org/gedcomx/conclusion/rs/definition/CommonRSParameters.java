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

import org.gedcomx.rt.rs.ResourceServiceDefinition;
import org.gedcomx.rt.rs.StatusCode;
import org.gedcomx.rt.rs.StatusCodes;

import javax.ws.rs.HeaderParam;

/**
 * The common resource service definition supplies a set of common parameters and error codes applicable to GEDCOM X resources.
 *
 * @author Ryan Heaton
 */
@StatusCodes ( {
  @StatusCode( code = 401, condition = "If authentication is needed, or if the supplied authentication is expired or otherwise invalid."),
  @StatusCode( code = 403, condition = "If the resource is forbidden even after considering a possibly valid authentication."),
  @StatusCode( code = 501, condition = "If the resource is not supported by the implementation.")
} )
public interface CommonRSParameters {

  /**
   * Set the proof statement given by the user to support changes to genealogical data.
   *
   * @param proofStatement The proof statement.
   */
  @HeaderParam( "X-Proof-Statement" )
  void setProofStatement(String proofStatement);

}

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
package org.gedcomx.conclusion.www;

import org.gedcomx.conclusion.Person;
import org.gedcomx.rt.www.ResourceServiceDefinition;
import org.gedcomx.rt.www.LinkDefinition;
import org.gedcomx.rt.www.StatusCode;
import org.gedcomx.rt.www.StatusCodes;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import javax.xml.bind.annotation.XmlTransient;

/**
 * The person resource service definition defines the standard methods and operations that are applicable to
 * a conclusion person.
 *
 * @author Ryan Heaton
 */
@XmlTransient
@ResourceServiceDefinition (
  name = "Person"
)
@StatusCodes ( {
  @StatusCode( code = 401, condition = "If authentication is needed, or if the supplied authentication is expired or otherwise invalid."),
  @StatusCode( code = 403, condition = "If the link is forbidden even after considering a possibly valid authentication."),
  @StatusCode( code = 501, condition = "If the link is not supported by the implementation.")
} )
public interface PersonRSDefinition {

  public static final String PERSON_LINK = "person";

  /**
   * Set the proof statement given by the user to support changes to genealogical data.
   *
   * @param proofStatement The proof statement.
   */
  @HeaderParam( "X-Proof-Statement" )
  void setProofStatement(String proofStatement);

  /**
   * Create a person.
   *
   * @param person The person to be created.
   * @return The appropriate response.
   */
  @LinkDefinition ( PERSON_LINK )
  @POST
  @StatusCodes({
    @StatusCode( code = 201, condition = "The creation of the person was successful. Expect a location header specifying the link to the created person.")
  })
  Response createPerson(Person person);

  /**
   * Read a person.
   *
   * @param uriInfo Information on the URI that was used to identify the person to read.
   * @return The person.
   */
  @LinkDefinition ( PERSON_LINK )
  @GET
  @StatusCodes({
    @StatusCode( code = 200, condition = "Upon a successful read."),
    @StatusCode( code = 301, condition = "If the requested person has been merged to another person."),
    @StatusCode( code = 404, condition = "If the requested person is not found."),
    @StatusCode( code = 410, condition = "If the requested person has been deleted.")
  })
  Person readPerson(@Context UriInfo uriInfo);

  /**
   * Read a person and some of its relevant metadata.
   *
   * todo: define standard query parameters to specify which metadata to return.
   *
   * @param uriInfo Information on the URI that was used to identify the person to read.
   * @return The person.
   */
  @LinkDefinition ( PERSON_LINK )
  @GET
  @StatusCodes({
    @StatusCode( code = 200, condition = "Upon a successful read."),
    @StatusCode( code = 301, condition = "If the requested person has been merged to another person."),
    @StatusCode( code = 404, condition = "If the requested person is not found."),
    @StatusCode( code = 410, condition = "If the requested person has been deleted.")
  })
  PersonWWW readPersonWWW(@Context UriInfo uriInfo);

  /**
   * Update a person.
   *
   * @param person The person to be used for the update.
   * @param uriInfo Information on the URI that was used to identify the person to update.
   */
  @LinkDefinition ( PERSON_LINK )
  @PUT
  @StatusCodes({
    @StatusCode( code = 204, condition = "The update was successful.")
  })
  void updatePerson(@Context UriInfo uriInfo, Person person);

  /**
   * Read a person.
   *
   * @param uriInfo Information on the URI that was used to identify the person to delete.
   */
  @LinkDefinition ( PERSON_LINK )
  @DELETE
  @StatusCodes({
    @StatusCode ( code = 204, condition = "The delete was successful.")
  })
  void deletePerson(@Context UriInfo uriInfo);

}

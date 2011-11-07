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
import org.gedcomx.www.rt.APIDefinition;
import org.gedcomx.www.rt.LinkDefinition;
import org.gedcomx.www.rt.StatusCode;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import javax.xml.bind.annotation.XmlTransient;

/**
 * The person API defines the standard methods and operations that are applicable to
 * a conclusion person.
 *
 * @author Ryan Heaton
 */
@XmlTransient
@APIDefinition (
  name = "Person",
  statusCodes = {
    @StatusCode( code = 401, condition = "If authentication is needed, or if the supplied authentication is expired or otherwise invalid."),
    @StatusCode( code = 403, condition = "If the link is forbidden even after considering a possibly valid authentication."),
    @StatusCode( code = 501, condition = "If the link is not supported by the implementation.")
  }
)
public abstract class PersonAPI {

  public static final String LINK_PERSON_LABEL = "person";

  /**
   * Create a person.
   *
   * @param person The person to be created.
   * @return The appropriate response.
   */
  @LinkDefinition (
    label = LINK_PERSON_LABEL,
    operation = "POST",
    statusCodes = {
      @StatusCode( code = 201, condition = "The creation of the person was successful. Expect a location header specifying the link to the created person.")
    }
  )
  public Response createPerson(Person person) {
    throw new WebApplicationException(501);
  }

  /**
   * Read a person.
   *
   * @param uriInfo Information on the URI that was used to identify the person to read.
   * @return The person.
   */
  @LinkDefinition (
    label = LINK_PERSON_LABEL,
    operation = "GET",
    statusCodes = {
      @StatusCode( code = 200, condition = "Upon a successful read."),
      @StatusCode( code = 301, condition = "If the requested person has been merged to another person."),
      @StatusCode( code = 404, condition = "If the requested person is not found."),
      @StatusCode( code = 410, condition = "If the requested person has been deleted.")
    }
  )
  public Person readPerson(@Context UriInfo uriInfo) {
    throw new WebApplicationException(501);
  }

  /**
   * Read a person and some of its relevant metadata.
   *
   * todo: define standard query parameters to specify which metadata to return.
   *
   * @param uriInfo Information on the URI that was used to identify the person to read.
   * @return The person.
   */
  @LinkDefinition (
    label = LINK_PERSON_LABEL,
    operation = "GET",
    statusCodes = {
      @StatusCode( code = 200, condition = "Upon a successful read."),
      @StatusCode( code = 301, condition = "If the requested person has been merged to another person."),
      @StatusCode( code = 404, condition = "If the requested person is not found."),
      @StatusCode( code = 410, condition = "If the requested person has been deleted.")
    }
  )
  public PersonWWW readPersonWWW(@Context UriInfo uriInfo) {
    throw new WebApplicationException(501);
  }

  /**
   * Update a person.
   *
   * @param person The person to be used for the update.
   * @param uriInfo Information on the URI that was used to identify the person to update.
   */
  @LinkDefinition (
    label = LINK_PERSON_LABEL,
    operation = "PUT",
    statusCodes = {
      @StatusCode( code = 204, condition = "The update was successful.")
    }
  )
  public void updatePerson(@Context UriInfo uriInfo, Person person) {
    throw new WebApplicationException(501);
  }

  /**
   * Read a person.
   *
   * @param uriInfo Information on the URI that was used to identify the person to delete.
   */
  @LinkDefinition (
    label = LINK_PERSON_LABEL,
    operation = "DELETE",
    statusCodes = {
      @StatusCode( code = 204, condition = "The delete was successful.")
    }
  )
  public void deletePerson(@Context UriInfo uriInfo) {
    throw new WebApplicationException(501);
  }

}

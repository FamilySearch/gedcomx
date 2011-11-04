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
import org.gedcomx.www.rt.*;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
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

  public static final String LINK_CREATE = "person-create";
  public static final String LINK_READ = "person-read";
  public static final String LINK_UPDATE = "person-update";
  public static final String LINK_DELETE = "person-delete";

  /**
   * Create a person.
   *
   * @param person The person to be created.
   * @return The location of the person created.
   */
  @LinkDefinition ( LINK_CREATE )
  public Created<Person> createPerson(Person person) {
    throw new WebApplicationException(501);
  }

  /**
   * Read a person.
   *
   * @param uriInfo Information on the URI that was used to identify the person to read.
   * @return The person.
   */
  @LinkDefinition (
    value = LINK_READ,
    statusCodes = {
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
    value = LINK_READ,
    statusCodes = {
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
   * @return The update response.
   * @throws WebApplicationException 301 If the person to be updated has been merged to another person.
   * @throws WebApplicationException 404 If the person to be updated was not found.
   * @throws WebApplicationException 410 If the person to be updated has been deleted.
   */
  @LinkDefinition (
    value = LINK_UPDATE,
    statusCodes = {
      @StatusCode( code = 301, condition = "If the person to be updated has been merged to another person."),
      @StatusCode( code = 404, condition = "If the person to be updated is not found."),
      @StatusCode( code = 410, condition = "If the person to be updated has been deleted.")
    }
  )
  public Updated<Person> updatePerson(@Context UriInfo uriInfo, Person person) {
    throw new WebApplicationException(501);
  }

  /**
   * Read a person.
   *
   * @param uriInfo Information on the URI that was used to identify the person to delete.
   * @return The delete response.
   */
  @LinkDefinition (
    value = LINK_DELETE,
    statusCodes = {
      @StatusCode( code = 301, condition = "If the person to be deleted has been merged to another person."),
      @StatusCode( code = 404, condition = "If the person to be deleted is not found."),
      @StatusCode( code = 410, condition = "If the person to be deleted has already been deleted.")
    }
  )
  public Deleted<Person> deletePerson(@Context UriInfo uriInfo) {
    throw new WebApplicationException(501);
  }

}

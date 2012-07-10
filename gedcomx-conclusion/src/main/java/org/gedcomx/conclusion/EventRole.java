/**
 * Copyright 2011-2012 Intellectual Reserve, Inc.
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
package org.gedcomx.conclusion;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.gedcomx.common.GenealogicalResource;
import org.gedcomx.common.ResourceReference;
import org.gedcomx.rt.RDFRange;
import org.gedcomx.types.EventRoleType;
import org.gedcomx.types.TypeReference;

import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

/**
 * A role that a specific person plays in an event.
 *
 * @author Ryan Heaton
 */
@XmlType ( name = "EventRole", propOrder = { "person", "role" } )
public class EventRole extends GenealogicalResource {

  private ResourceReference person;
  private TypeReference<EventRoleType> role;
  private String details;

  /**
   * Reference to the person playing the role in the event.
   *
   * @return Reference to the person playing the role in the event.
   */
  @RDFRange (Person.class)
  public ResourceReference getPerson() {
    return person;
  }

  /**
   * Reference to the person playing the role in the event.
   *
   * @param person Reference to the person playing the role in the event.
   */
  public void setPerson(ResourceReference person) {
    this.person = person;
  }

  /**
   * The role the person plays in the event.
   *
   * @return The role the person plays in the event.
   */
  public TypeReference<EventRoleType> getRole() {
    return role;
  }

  /**
   * The role the person plays in the event.
   *
   * @param role The role the person plays in the event.
   */
  public void setRole(TypeReference<EventRoleType> role) {
    this.role = role;
  }

  /**
   * Details about the role of the person in the event.
   *
   * @return Details about the role of the person in the event.
   */
  public String getDetails() {
    return details;
  }

  /**
   * Details about the role of the person in the event.
   *
   * @param details Details about the role of the person in the event.
   */
  public void setDetails(String details) {
    this.details = details;
  }

  /**
   * The enum referencing the known role, or {@link org.gedcomx.types.EventRoleType#OTHER} if not known.
   *
   * @return The enum referencing the known role, or {@link org.gedcomx.types.EventRoleType#OTHER} if not known.
   */
  @XmlTransient
  @JsonIgnore
  public EventRoleType getKnownRole() {
    return getRole() == null ? null : EventRoleType.fromQNameURI(getRole().getType());
  }

  /**
   * Set the role from a known enumeration of roles.
   *
   * @param role The known role.
   */
  @JsonIgnore
  public void setKnownRole(EventRoleType role) {
    setRole(role == null ? null : new TypeReference<EventRoleType>(role));
  }

  /**
   * Provide a simple toString() method.
   */
  @Override
  public String toString() {
    return (person == null) ? "" : person.toString();
  }
}

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
package org.gedcomx.record;

import javax.xml.bind.annotation.XmlAttribute;

/**
 * A role played by a persona in a recorded event.
 */
public final class EventRole {

  private String description;
  private EventReference event;
  private Boolean principal;

  /**
   * The reference to the event.
   *
   * @return The reference to the event.
   */
  public EventReference getEvent() {
    return event;
  }

  /**
   * The reference to the event.
   *
   * @param event The reference to the event.
   */
  public void setEvent(EventReference event) {
    this.event = event;
  }

  /**
   * Whether this is the principal event for the persona in the record. For example, the principal event for a persona recorded in a birth certificate is
   * the birth event.
   *
   * @return Whether this is the principal event for the persona in the record. For example, the principal event for a persona recorded in a birth certificate is
   * the birth event.
   */
  @XmlAttribute
  public Boolean getPrincipal() {
    return principal;
  }

  /**
   * Whether this is the principal event for the persona in the record. For example, the principal event for a persona recorded in a birth certificate is
   * the birth event.
   *
   * @param principal Whether this is the principal event for the persona in the record. For example, the principal event for a persona recorded in a birth certificate is
   * the birth event.
   */
  public void setPrincipal(Boolean principal) {
    this.principal = principal;
  }

  /**
   * The description of the role found on the record.
   *
   * @return The description of the role found on the record.
   */
  public String getDescription() {
    return description;
  }

  /**
   * The description of the role found on the record.
   *
   * @param description The description of the role found on the record.
   */
  public void setDescription(String description) {
    this.description = description;
  }
}

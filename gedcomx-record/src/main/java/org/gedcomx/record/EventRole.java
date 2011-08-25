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

import org.gedcomx.common.Attributable;
import org.gedcomx.common.Attribution;
import org.gedcomx.common.Extensible;
import org.gedcomx.common.Extension;
import org.gedcomx.types.TypesNamespaces;

import javax.xml.XMLConstants;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import java.net.URI;

/**
 * Description of a role played by a persona in an event.
 */
@XmlType ( name = "EventRole", propOrder = { "description", "attribution", "extension"} )
public final class EventRole implements Attributable, Extensible, Describable, Weighted {

  private URI event;
  private String description;
  private Boolean principal;
  private Attribution attribution;
  private Extension extension;

  /**
   * The reference to the event. If the event is local to the record, the URI will be a
   * relative <a href="http://www.w3.org/TR/webarch/#fragid">fragment identifier</a>
   *
   * @return The reference to the event.
   */
  @XmlAttribute(namespace = TypesNamespaces.RDF_NAMESPACE, name = "about" )
  @XmlSchemaType (name = "anyURI", namespace = XMLConstants.W3C_XML_SCHEMA_NS_URI)
  public URI getEvent() {
    return event;
  }

  /**
   * The reference to the event. If the event is local to the record, the URI will be a
   * relative <a href="http://www.w3.org/TR/webarch/#fragid">fragment identifier</a>
   *
   * @param event The reference to the event.
   */
  public void setEvent(URI event) {
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
   * The attribution metadata for this event role.
   *
   * @return The attribution metadata for this event role.
   */
  public Attribution getAttribution() {
    return attribution;
  }

  /**
   * The attribution metadata for this event role.
   *
   * @param attribution The attribution metadata for this event role.
   */
  public void setAttribution(Attribution attribution) {
    this.attribution = attribution;
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

  /**
   * The extension point for the event role.
   *
   * @return The extension point for the event role.
   */
  @XmlElement ( name = "ext" )
  public Extension getExtension() {
    return extension;
  }

  /**
   * The extension point for the event role.
   *
   * @param extension The extension point for the event role.
   */
  public void setExtension(Extension extension) {
    this.extension = extension;
  }
}

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
package org.gedcomx.atom;

import org.gedcomx.common.URI;

import javax.xml.XMLConstants;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

/**
 * A Person construct is an element that describes a person, corporation, or similar entity
 *
 * @author Ryan Heaton
 * @see <a href="http://tools.ietf.org/html/rfc4287#section-3.2">The atom spec, section 3.2.</a>
 */
@XmlType( name = "Person", propOrder = {"name", "uri", "email"} )
public final class Person extends ExtensibleElement {
  
  private String name;
  private URI uri;
  private String email;

  /**
   * Conveys a human-readable name for the person.
   *
   * @return a human-readable name for the person.
   */
  public String getName() {
    return name;
  }

  /**
   * a human-readable name for the person.
   *
   * @param name a human-readable name for the person.
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * an IRI associated with the person.
   *
   * @return an IRI associated with the person.
   */
  @XmlSchemaType (name = "anyURI", namespace = XMLConstants.W3C_XML_SCHEMA_NS_URI)
  public URI getUri() {
    return uri;
  }

  /**
   * an IRI associated with the person.
   *
   * @param uri an IRI associated with the person.
   */
  public void setUri(URI uri) {
    this.uri = uri;
  }

  /**
   * an e-mail address associated with the person.
   *
   * @return an e-mail address associated with the person.
   */
  public String getEmail() {
    return email;
  }

  /**
   * an e-mail address associated with the person.
   *
   * @param email an e-mail address associated with the person.
   */
  public void setEmail(String email) {
    this.email = email;
  }
}

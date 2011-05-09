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

import org.gedcomx.www.Links;
import org.gedcomx.www.PersistentIdentifier;

import javax.xml.XMLConstants;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.net.URI;

/**
 * A person that can support WWW links.
 *
 * @author Ryan Heaton
 */
@XmlRootElement (name = "person")
@XmlType (name = "person")
public class Person extends org.gedcomx.conclusion.Person {

  private URI base;
  private PersistentIdentifier persistentId;
  private Links links;

  /**
   * The base uri for all relative links within the context of this person.
   *
   * @return The base uri for all relative links within the context of this person.
   */
  @XmlAttribute (namespace = XMLConstants.XML_NS_URI)
  public URI getBase() {
    return base;
  }

  /**
   * The base uri for all relative links within the context of this person.
   *
   * @param base The base uri for all relative links within the context of this person.
   */
  public void setBase(URI base) {
    this.base = base;
  }

  /**
   * A long-term, persistent, globally unique identifier for this person.
   *
   * @return A long-term, persistent, globally unique identifier for this person.
   */
  public PersistentIdentifier getPersistentId() {
    return persistentId;
  }

  /**
   * A long-term, persistent, globally unique identifier for this person.
   *
   * @param persistentId A long-term, persistent, globally unique identifier for this person.
   */
  public void setPersistentId(PersistentIdentifier persistentId) {
    this.persistentId = persistentId;
  }

  /**
   * The WWW links for this person.
   *
   * @return The WWW links for this person.
   */
  public Links getLinks() {
    return links;
  }

  /**
   * The WWW links for this person.
   *
   * @param links The WWW links for this person.
   */
  public void setLinks(Links links) {
    this.links = links;
  }
}

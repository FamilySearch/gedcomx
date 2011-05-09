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
package org.gedcomx.source.www;

import org.gedcomx.www.Links;
import org.gedcomx.www.PersistentIdentifier;

import javax.xml.XMLConstants;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.net.URI;

/**
 * A source that can support WWW links.
 * 
 * @author Ryan Heaton
 */
@XmlRootElement (name = "source")
@XmlType (name = "source")
public class Source extends org.gedcomx.source.Source {

  private URI base;
  private PersistentIdentifier persistentId;
  private Links links;

  /**
   * The base uri for all relative links within the context of this source.
   *
   * @return The base uri for all relative links within the context of this source.
   */
  @XmlAttribute (namespace = XMLConstants.XML_NS_URI)
  public URI getBase() {
    return base;
  }

  /**
   * The base uri for all relative links within the context of this source.
   *
   * @param base The base uri for all relative links within the context of this source.
   */
  public void setBase(URI base) {
    this.base = base;
  }

  /**
   * A long-term, persistent, globally unique identifier for this source.
   *
   * @return A long-term, persistent, globally unique identifier for this source.
   */
  public PersistentIdentifier getPersistentId() {
    return persistentId;
  }

  /**
   * A long-term, persistent, globally unique identifier for this source.
   *
   * @param persistentId A long-term, persistent, globally unique identifier for this source.
   */
  public void setPersistentId(PersistentIdentifier persistentId) {
    this.persistentId = persistentId;
  }

  /**
   * The WWW links for this source.
   *
   * @return The WWW links for this source.
   */
  public Links getLinks() {
    return links;
  }

  /**
   * The WWW links for this source.
   *
   * @param links The WWW links for this source.
   */
  public void setLinks(Links links) {
    this.links = links;
  }
}

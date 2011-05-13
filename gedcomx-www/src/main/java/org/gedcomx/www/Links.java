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
package org.gedcomx.www;

import org.codehaus.enunciate.ClientName;

import javax.xml.XMLConstants;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import java.net.URI;
import java.util.List;

/**
 * A set of links.
 *
 * @author Ryan Heaton
 */
public final class Links {

  private List<Link> links;
  private URI base;

  /**
   * The 'base' URI for all links in this set.
   *
   * @return The 'base' URI for all links in this set.
   */
  @XmlAttribute (namespace = XMLConstants.XML_NS_URI)
  public URI getBase() {
    return base;
  }

  /**
   * The 'base' URI for all links in this set.
   *
   * @param base The 'base' URI for all links in this set.
   */
  public void setBase(URI base) {
    this.base = base;
  }

  /**
   * The links.
   *
   * @return The links.
   */
  @XmlElement( name="link" )
  @ClientName( "linkList" )
  public List<Link> getLinks() {
    return links;
  }

  /**
   * The links.
   *
   * @param links The links.
   */
  public void setLinks(List<Link> links) {
    this.links = links;
  }
}

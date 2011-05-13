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
package org.gedcomx.record.www;

import org.codehaus.jackson.annotate.JsonTypeInfo;
import org.codehaus.jackson.map.annotate.JsonTypeIdResolver;
import org.gedcomx.id.XmlTypeIdResolver;
import org.gedcomx.www.Links;

import javax.xml.XMLConstants;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import java.net.URI;

/**
 * A collection that can support WWW links.
 * 
 * @author Ryan Heaton
 */
@XmlRootElement
@JsonTypeInfo ( use =JsonTypeInfo.Id.CUSTOM, property = "@type")
@JsonTypeIdResolver (XmlTypeIdResolver.class)
public class Collection extends org.gedcomx.record.Collection {

  private URI base;
  private Links links;

  /**
   * The base uri for all relative links within the context of this collection.
   *
   * @return The base uri for all relative links within the context of this collection.
   */
  @XmlAttribute (namespace = XMLConstants.XML_NS_URI)
  public URI getBase() {
    return base;
  }

  /**
   * The base uri for all relative links within the context of this collection.
   *
   * @param base The base uri for all relative links within the context of this collection.
   */
  public void setBase(URI base) {
    this.base = base;
  }

  /**
   * The WWW links for this collection.
   *
   * @return The WWW links for this collection.
   */
  public Links getLinks() {
    return links;
  }

  /**
   * The WWW links for this collection.
   *
   * @param links The WWW links for this collection.
   */
  public void setLinks(Links links) {
    this.links = links;
  }
}

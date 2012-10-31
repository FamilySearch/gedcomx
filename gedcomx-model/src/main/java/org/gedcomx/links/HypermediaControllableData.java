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
package org.gedcomx.links;

import org.codehaus.enunciate.json.JsonName;
import org.codehaus.jackson.annotate.JsonProperty;
import org.gedcomx.common.ExtensibleData;
import org.gedcomx.common.URI;

import javax.xml.bind.annotation.XmlElement;
import java.util.ArrayList;
import java.util.List;

/**
 * An object that is potentially hypermedia-controlled.
 *
 * @author Ryan Heaton
 */
public abstract class HypermediaControllableData extends ExtensibleData {

  private List<Link> links;

  /**
   * The list of hypermedia links.
   *
   * @return The list of hypermedia links.
   */
  @XmlElement (name = "link")
  @JsonName ("links")
  @JsonProperty ("links")
  public List<Link> getLinks() {
    return links;
  }

  /**
   * The list of hypermedia links.
   *
   * @param links The list of hypermedia links.
   */
  @JsonProperty ("links")
  public void setLinks(List<Link> links) {
    this.links = links;
  }

  /**
   * Add a hypermedia link.
   *
   * @param link The hypermedia link.
   */
  public void addLink(Link link) {
    if (this.links == null) {
      setLinks(new ArrayList<Link>());
    }

    this.links.add(link);
  }

  /**
   * Add a hypermedia link.
   *
   * @param rel The link rel.
   * @param href The target URI.
   */
  public void addLink(String rel, URI href) {
    addLink(new Link(rel, href));
  }

  /**
   * Add a templated link.
   *
   * @param rel The link rel.
   * @param template The link template.
   */
  public void addTemplatedLink(String rel, String template) {
    Link link = new Link();
    link.setRel(rel);
    link.setTemplate(template);
    addLink(link);
  }

  /**
   * Get a link by its rel.
   *
   * @param rel The link rel.
   * @return The link by rel.
   */
  public Link getLink(String rel) {
    List<Link> links = getLinks(rel);
    Link link = null;
    if (!links.isEmpty()) {
      link = links.get(0);
    }
    return link;
  }

  /**
   * Get a list of links by rel.
   *
   * @param rel The rel of the links.
   * @return The link.
   */
  public List<Link> getLinks(String rel) {
    ArrayList<Link> links = new ArrayList<Link>();
    if (this.links != null) {
      for (Link link : getLinks()) {
        if (rel.equals(link.getRel())) {
          links.add(link);
        }
      }
    }
    return links;
  }
}

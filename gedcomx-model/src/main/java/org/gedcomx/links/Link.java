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

import org.codehaus.jackson.annotate.JsonIgnore;
import org.gedcomx.common.URI;
import org.gedcomx.rt.json.HasJsonKey;
import org.gedcomx.rt.json.JsonElementWrapper;

import javax.xml.XMLConstants;
import javax.xml.bind.annotation.*;
import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

/**
 * A hypermedia link, used to drive the state of a hypermedia-enabled genealogical data application.
 *
 * @author Ryan Heaton
 * @see <a href="http://tools.ietf.org/html/rfc5988">RFC 5988</a>
 * @see <a href="http://tools.ietf.org/html/rfc4287#section-4.2.7">Atom Syndication Format, Section 4.2.7</a>
 */
@XmlRootElement
@XmlType ( name = "Link" )
@JsonElementWrapper ( name = "links" )
@SuppressWarnings("gedcomx:no_id")
public class Link implements HasJsonKey {

  /**
   * The list of link rels that support multi-valued links. Be careful about editing this because
   * it might break backwards-compatibility with JSON clients.
   */
  public static final Set<String> NON_UNIQUE_RELS = new TreeSet<String>(Arrays.asList("alternate", "bookmark", "related", "item"));

  private String rel;
  private URI href;
  private String template;
  private String type;
  private String accept;
  private String allow;
  private String hreflang;
  private String title;

  public Link(String rel, URI href) {
    this.rel = rel;
    this.href = href;
  }

  public Link() {
  }

  @XmlTransient
  @JsonIgnore
  @org.codehaus.enunciate.json.JsonIgnore
  @Override
  public boolean isHasUniqueKey() {
    return this.rel != null && !NON_UNIQUE_RELS.contains(this.rel);
  }

  /**
   * The link relationship.
   *
   * @return The link relationship.
   */
  @XmlAttribute
  @JsonIgnore
  @org.codehaus.enunciate.json.JsonIgnore
  public String getRel() {
    return rel;
  }

  /**
   * The link relationship.
   *
   * @param rel The link relationship.
   */
  @JsonIgnore
  public void setRel(String rel) {
    this.rel = rel;
  }

  /**
   * The json key that is used define this link in a map.
   *
   * @return The json key that is used define this link in a map.
   */
  @XmlTransient
  @JsonIgnore
  @Override
  public String getJsonKey() {
    return getRel();
  }

  /**
   * The json key that is used define this link in a map.
   *
   * @param jsonKey The json key that is used define this link in a map.
   */
  @Override
  @JsonIgnore
  public void setJsonKey(String jsonKey) {
    setRel(jsonKey);
  }

  /**
   * The target IRI of the link.
   *
   * @return The target IRI of the link.
   */
  @XmlAttribute
  @XmlSchemaType (name = "anyURI", namespace = XMLConstants.W3C_XML_SCHEMA_NS_URI)
  public URI getHref() {
    return href;
  }

  /**
   * The link URI.
   *
   * @param href The link URI.
   */
  public void setHref(URI href) {
    this.href = href;
  }

  /**
   * A URI template per <a href="http://tools.ietf.org/html/rfc6570">RFC 6570</a>, used to link to a range of
   * URIs, such as for the purpose of linking to a query. A link specifying a template can be formally referred to
   * as a "Templated Link (LT)" per Amundsen, M. (2011). <i>Hypermedia APIs with HTML5 and Node</i>. O'Reilly.
   *
   * @return A URI template per <a href="http://tools.ietf.org/html/rfc6570">RFC 6570</a>, used to link to a range of
   * URIs, such as for the purpose of linking to a query.
   */
  @XmlAttribute
  public String getTemplate() {
    return template;
  }

  /**
   * A URI template per <a href="http://tools.ietf.org/html/rfc6570">RFC 6570</a>, used to link to a range of
   * URIs, such as for the purpose of linking to a query. A link specifying a template can be formally referred to
   * as a "Templated Link (LT)" per Amundsen, M. (2011). <i>Hypermedia APIs with HTML5 and Node</i>. O'Reilly.
   *
   * @param template A URI template per <a href="http://tools.ietf.org/html/rfc6570">RFC 6570</a>, used to link to a range of
   * URIs, such as for the purpose of linking to a query.
   */
  public void setTemplate(String template) {
    this.template = template;
  }

  /**
   * Metadata about the available media type(s) of the resource being linked to. The value of the "type" attribute is
   * as defined by the HTTP specification, <a href="http://www.ietf.org/rfc/rfc2616.txt">RFC 2616</a>, Section 3.7.
   *
   * Note that this attribute can be considered an "Update Control (CU)" per Amundsen, M. (2011). <i>Hypermedia APIs with HTML5 and Node</i>. O'Reilly.
   *
   * @return Metadata about the available media type(s) of the resource being linked to.
   */
  @XmlAttribute
  public String getType() {
    return type;
  }

  /**
   * Metadata about the available media type(s) of the resource being linked to. The value of the "type" attribute is
   * as defined by the HTTP specification, <a href="http://www.ietf.org/rfc/rfc2616.txt">RFC 2616</a>, Section 3.7.
   *
   * Note that this attribute can be considered an "Read Control (CR)" per Amundsen, M. (2011). <i>Hypermedia APIs with HTML5 and Node</i>. O'Reilly.
   *
   * @param type Metadata about the available media type(s) of the resource being linked to.
   */
  public void setType(String type) {
    this.type = type;
  }

  /**
   * Metadata about the acceptable media type(s) that can be used to update (i.e. change the state of) the resource being linked to. The value of
   * the "accept" attribute is as defined by the HTTP specification, <a href="http://www.ietf.org/rfc/rfc2616.txt">RFC 2616</a>, Section 3.7.
   *
   * Note that this attribute can be considered an "Read Control (CR)" per Amundsen, M. (2011). <i>Hypermedia APIs with HTML5 and Node</i>. O'Reilly.
   *
   * @return Metadata about the available media type(s) of the resource being linked to.
   */
  @XmlAttribute
  public String getAccept() {
    return accept;
  }

  /**
   * Metadata about the media type(s) that can be used to update (i.e. change the state of) the resource being linked to. The value of
   * the "accept" attribute is as defined by the HTTP specification, <a href="http://www.ietf.org/rfc/rfc2616.txt">RFC 2616</a>, Section 3.7.
   *
   * Note that this attribute can be considered an "Update Control (CU)" per Amundsen, M. (2011). <i>Hypermedia APIs with HTML5 and Node</i>. O'Reilly.
   *
   * @param accept Metadata about the available media type(s) of the resource being linked to.
   */
  public void setAccept(String accept) {
    this.accept = accept;
  }

  /**
   * Metadata about the allowable methods that can be used to transition to the resource being linked. The value of
   * the "allow" attribute is as defined by the HTTP specification, <a href="http://www.ietf.org/rfc/rfc2616.txt">RFC 2616</a>, Section 14.7.
   *
   * Note that this attribute can be considered an "Method Control (CM)" per Amundsen, M. (2011). <i>Hypermedia APIs with HTML5 and Node</i>. O'Reilly.
   *
   * @return Metadata about the available media type(s) of the resource being linked to.
   */
  @XmlAttribute
  public String getAllow() {
    return allow;
  }

  /**
   * Metadata about the allowable methods that can be used to transition to the resource being linked. The value of
   * the "allow" attribute is as defined by the HTTP specification, <a href="http://www.ietf.org/rfc/rfc2616.txt">RFC 2616</a>, Section 14.7.
   *
   * Note that this attribute can be considered an "Method Control (CM)" per Amundsen, M. (2011). <i>Hypermedia APIs with HTML5 and Node</i>. O'Reilly.
   *
   * @param allow Metadata about the available media type(s) of the resource being linked to.
   */
  public void setAllow(String allow) {
    this.allow = allow;
  }

  /**
   * The language of the resource being linked to.
   *
   * Note that this attribute can be considered an "Update Control (CU)" per Amundsen, M. (2011). <i>Hypermedia APIs with HTML5 and Node</i>. O'Reilly.
   *
   * @return The language of the resource being linked to.
   */
  @XmlAttribute
  public String getHreflang() {
    return hreflang;
  }

  /**
   * The language of the resource being linked to.
   *
   * Note that this attribute can be considered an "Update Control (CU)" per Amundsen, M. (2011). <i>Hypermedia APIs with HTML5 and Node</i>. O'Reilly.
   *
   * @param hreflang The language of the resource being linked to.
   */
  public void setHreflang(String hreflang) {
    this.hreflang = hreflang;
  }

  /**
   * Human-readable information about the link.
   *
   * @return Human-readable information about the link.
   */
  @XmlAttribute
  public String getTitle() {
    return title;
  }

  /**
   * Human-readable information about the link.
   *
   * @param title Human-readable information about the link.
   */
  public void setTitle(String title) {
    this.title = title;
  }

  /**
   * Format this link as a Link header per RFC 5988.
   *
   * @return The value of this link formatted per RFC 5988.
   */
  @XmlTransient
  @JsonIgnore
  @org.codehaus.enunciate.json.JsonIgnore
  public String getHttpHeaderValue() {
    StringBuilder builder = new StringBuilder("<");

    if (this.href != null) {
      builder.append(this.href.toString());
    }

    builder.append(">");

    if (this.rel != null) {
      builder.append("; rel=\"").append(this.rel).append("\"");
    }

    if (this.template != null) {
      builder.append("; template=\"").append(this.template).append("\"");
    }

    if (this.type != null) {
      builder.append("; type=\"").append(this.type).append("\"");
    }

    if (this.accept != null) {
      builder.append("; accept=\"").append(this.accept).append("\"");
    }

    if (this.allow != null) {
      builder.append("; allow=\"").append(this.allow).append("\"");
    }

    if (this.hreflang != null) {
      builder.append("; hreflang=\"").append(this.hreflang).append("\"");
    }

    if (this.title != null) {
      builder.append("; title=\"").append(this.title).append("\"");
    }

    return builder.toString();
  }

  @Override
  public String toString() {
    return getHttpHeaderValue();
  }
}

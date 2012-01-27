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

import org.codehaus.enunciate.json.JsonName;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonTypeInfo;
import org.codehaus.jackson.map.annotate.JsonTypeIdResolver;
import org.gedcomx.common.URI;
import org.gedcomx.opensearch.OpenSearchModel;
import org.gedcomx.opensearch.Query;
import org.gedcomx.rt.XmlTypeIdResolver;

import javax.xml.XMLConstants;
import javax.xml.bind.annotation.*;
import java.util.Date;
import java.util.List;

/**
 * The "atom:feed" element is the document (i.e., top-level) element of an Atom Feed Document,
 * acting as a container for metadata and data associated with the feed.
 *
 * @author Ryan Heaton
 * @see <a href="http://tools.ietf.org/html/rfc4287#section-4">The atom spec, section 4.</a>
 */
@XmlRootElement
@XmlType( name = "Feed", propOrder = {"authors", "contributors", "generator", "icon", "id", "totalResults", "startIndex", "itemsPerPage", "query", "links", "logo", "rights", "subtitle", "title", "updated", "entries"} )
@JsonTypeInfo ( use =JsonTypeInfo.Id.CUSTOM, property = XmlTypeIdResolver.TYPE_PROPERTY_NAME)
@JsonTypeIdResolver (XmlTypeIdResolver.class)
@SuppressWarnings("gedcomx:no_id")
public class Feed extends ExtensibleElement {
  
  private List<Person> authors;
  private List<Person> contributors;
  private Generator generator;
  private URI icon;
  private URI id;
  private Integer totalResults;
  private Integer startIndex;
  private Integer itemsPerPage;
  private Query query;
  private List<Link> links;
  private URI logo;
  private String rights;
  private String subtitle;
  private String title;
  private Date updated;
  private List<Entry> entries;

  /**
   * The author of the feed.
   *
   * @return The author of the feed.
   */
  @XmlElement (name = "author")
  @JsonName("authors")
  @JsonProperty("authors")
  public List<Person> getAuthors() {
    return authors;
  }

  /**
   * The author of the feed.
   *
   * @param authors The author of the feed.
   */
  @JsonProperty("authors")
  public void setAuthors(List<Person> authors) {
    this.authors = authors;
  }

  /**
   * information about a category associated with the feed
   *
   * @return information about a category associated with the feed
   */
  @XmlElement (name = "contributor")
  @JsonName("contributors")
  @JsonProperty("contributors")
  public List<Person> getContributors() {
    return contributors;
  }

  /**
   * information about a category associated with the feed
   *
   * @param contributors information about a category associated with the feed
   */
  @JsonProperty("contributors")
  public void setContributors(List<Person> contributors) {
    this.contributors = contributors;
  }

  /**
   * identifies the agent used to generate the feed
   *
   * @return identifies the agent used to generate the feed
   */
  public Generator getGenerator() {
    return generator;
  }

  /**
   * identifies the agent used to generate the feed
   *
   * @param generator identifies the agent used to generate the feed
   */
  public void setGenerator(Generator generator) {
    this.generator = generator;
  }

  /**
   * identifies an image that provides iconic visual identification for the feed.
   *
   * @return identifies an image that provides iconic visual identification for the feed.
   */
  @XmlSchemaType (name = "anyURI", namespace = XMLConstants.W3C_XML_SCHEMA_NS_URI)
  public URI getIcon() {
    return icon;
  }

  /**
   * identifies an image that provides iconic visual identification for the feed.
   *
   * @param icon identifies an image that provides iconic visual identification for the feed.
   */
  public void setIcon(URI icon) {
    this.icon = icon;
  }

  /**
   * a permanent, universally unique identifier for the feed.
   *
   * @return a permanent, universally unique identifier for the feed.
   */
  @XmlSchemaType (name = "anyURI", namespace = XMLConstants.W3C_XML_SCHEMA_NS_URI)
  public URI getId() {
    return id;
  }

  /**
   * a permanent, universally unique identifier for the feed.
   *
   * @param id a permanent, universally unique identifier for the feed.
   */
  public void setId(URI id) {
    this.id = id;
  }

  /**
   * The number of search results available for the current search, if this feed is supplying search results.
   *
   * @return The number of search results available for the current search, if this feed is supplying search results.
   */
  @XmlElement (namespace = OpenSearchModel.OPENSEARCH_NAMESPACE )
  public Integer getTotalResults() {
    return totalResults;
  }

  /**
   * The number of search results available for the current search, if this feed is supplying search results.
   *
   * @param totalResults The number of search results available for the current search, if this feed is supplying search results.
   */
  public void setTotalResults(Integer totalResults) {
    this.totalResults = totalResults;
  }

  /**
   * The index of the first search result in the current set of search results, if this feed is supplying search results.
   *
   * @return The index of the first search result in the current set of search results, if this feed is supplying search results.
   */
  @XmlElement (namespace = OpenSearchModel.OPENSEARCH_NAMESPACE )
  public Integer getStartIndex() {
    return startIndex;
  }

  /**
   * The index of the first search result in the current set of search results, if this feed is supplying search results.
   *
   * @param startIndex The index of the first search result in the current set of search results, if this feed is supplying search results.
   */
  public void setStartIndex(Integer startIndex) {
    this.startIndex = startIndex;
  }

  /**
   * The number of search results returned per page, if this feed is supplying search results.
   *
   * @return The number of search results returned per page, if this feed is supplying search results.
   */
  @XmlElement (namespace = OpenSearchModel.OPENSEARCH_NAMESPACE )
  public Integer getItemsPerPage() {
    return itemsPerPage;
  }

  /**
   * The number of search results returned per page, if this feed is supplying search results.
   *
   * @param itemsPerPage The number of search results returned per page, if this feed is supplying search results.
   */
  public void setItemsPerPage(Integer itemsPerPage) {
    this.itemsPerPage = itemsPerPage;
  }

  /**
   * Search query that was performed by the search client, if this feed is supplying search results.
   *
   * @return Search query that was performed by the search client, if this feed is supplying search results.
   */
  @XmlElement (name = "Query", namespace = OpenSearchModel.OPENSEARCH_NAMESPACE )
  public Query getQuery() {
    return query;
  }

  /**
   * Search query that was performed by the search client, if this feed is supplying search results.
   *
   * @param query Search query that was performed by the search client, if this feed is supplying search results.
   */
  public void setQuery(Query query) {
    this.query = query;
  }

  /**
   * a reference from a feed to a Web resource.
   *
   * @return a reference from a feed to a Web resource.
   */
  @XmlElement (name = "link")
  @JsonName("links")
  @JsonProperty("links")
  public List<Link> getLinks() {
    return links;
  }

  /**
   * a reference from a feed to a Web resource.
   *
   * @param links a reference from a feed to a Web resource.
   */
  @JsonProperty("links")
  public void setLinks(List<Link> links) {
    this.links = links;
  }

  /**
   * identifies an image that provides visual identification for the feed.
   *
   * @return identifies an image that provides visual identification for the feed.
   */
  @XmlSchemaType (name = "anyURI", namespace = XMLConstants.W3C_XML_SCHEMA_NS_URI)
  public URI getLogo() {
    return logo;
  }

  /**
   * identifies an image that provides visual identification for the feed.
   *
   * @param logo identifies an image that provides visual identification for the feed.
   */
  public void setLogo(URI logo) {
    this.logo = logo;
  }

  /**
   * information about rights held in and over the feed.
   *
   * @return information about rights held in and over the feed.
   */
  public String getRights() {
    return rights;
  }

  /**
   * information about rights held in and over the feed.
   *
   * @param rights information about rights held in and over the feed.
   */
  public void setRights(String rights) {
    this.rights = rights;
  }

  /**
   * a human-readable description or subtitle for the feed.
   *
   * @return a human-readable description or subtitle for the feed.
   */
  public String getSubtitle() {
    return subtitle;
  }

  /**
   * a human-readable description or subtitle for the feed.
   *
   * @param subtitle a human-readable description or subtitle for the feed.
   */
  public void setSubtitle(String subtitle) {
    this.subtitle = subtitle;
  }

  /**
   * a human-readable title for the feed
   *
   * @return a human-readable title for the feed
   */
  public String getTitle() {
    return title;
  }

  /**
   * a human-readable title for the feed
   *
   * @param title a human-readable title for the feed
   */
  public void setTitle(String title) {
    this.title = title;
  }

  /**
   * the most recent instant in time when the feed was modified in a way the publisher considers significant.
   *
   * @return the most recent instant in time when the feed was modified in a way the publisher considers significant.
   */
  public Date getUpdated() {
    return updated;
  }

  /**
   * the most recent instant in time when the feed was modified in a way the publisher considers significant.
   *
   * @param updated the most recent instant in time when the feed was modified in a way the publisher considers significant.
   */
  public void setUpdated(Date updated) {
    this.updated = updated;
  }

  /**
   * The entries in the feed.
   *
   * @return The entries in the feed.
   */
  @XmlElementWrapper( name = "entries" )
  public List<Entry> getEntries() {
    return entries;
  }

  /**
   * The entries in the feed.
   *
   * @param entries The entries in the feed.
   */
  public void setEntries(List<Entry> entries) {
    this.entries = entries;
  }
}

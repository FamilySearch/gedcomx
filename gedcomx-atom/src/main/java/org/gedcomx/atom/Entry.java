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
import org.gedcomx.rt.JsonElementWrapper;
import org.gedcomx.rt.XmlTypeIdResolver;

import javax.xml.XMLConstants;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import java.util.Date;
import java.util.List;

/**
 * The "atom:entry" element represents an individual entry, acting as a container for metadata and data associated with the entry.
 *
 * @author Ryan Heaton
 */
@XmlRootElement
@XmlType ( name = "Entry" )
@JsonElementWrapper (name = "entries")
@JsonTypeInfo ( use =JsonTypeInfo.Id.CUSTOM, property = XmlTypeIdResolver.TYPE_PROPERTY_NAME)
@JsonTypeIdResolver (XmlTypeIdResolver.class)
@SuppressWarnings("gedcomx:no_id")
public class Entry extends ExtensibleElement {
  
  private List<Person> authors;
  private List<Category> categories;
  private Content content;
  private List<Person> contributors;
  private URI id;
  private Float score;
  private List<Link> links;
  private Date published;
  private String rights;
  private String title;
  private Date updated;

  /**
   * The author of the entry.
   *
   * @return The author of the entry.
   */
  @XmlElement (name = "author")
  @JsonName ("authors")
  @JsonProperty ("authors")
  public List<Person> getAuthors() {
    return authors;
  }

  /**
   * The author of the entry.
   *
   * @param authors The author of the entry.
   */
  @JsonProperty("authors")
  public void setAuthors(List<Person> authors) {
    this.authors = authors;
  }

  /**
   * information about a category associated with an entry.
   *
   * @return information about a category associated with an entry.
   */
  @XmlElement (name = "category")
  @JsonName ("categories")
  @JsonProperty ("categories")
  public List<Category> getCategories() {
    return categories;
  }

  /**
   * information about a category associated with an entry.
   *
   * @param categories information about a category associated with an entry.
   */
  @JsonProperty ("categories")
  public void setCategories(List<Category> categories) {
    this.categories = categories;
  }

  /**
   * The content of the entry.
   *
   * @return The content of the entry.
   */
  public Content getContent() {
    return content;
  }

  /**
   * The content of the entry.
   *
   * @param content The content of the entry.
   */
  public void setContent(Content content) {
    this.content = content;
  }

  /**
   * information about a category associated with the entry
   *
   * @return information about a category associated with the entry
   */
  @XmlElement (name = "contributor")
  @JsonName("contributors")
  @JsonProperty("contributors")
  public List<Person> getContributors() {
    return contributors;
  }

  /**
   * information about a category associated with the entry
   *
   * @param contributors information about a category associated with the entry
   */
  @JsonProperty("contributors")
  public void setContributors(List<Person> contributors) {
    this.contributors = contributors;
  }

  /**
   * a permanent, universally unique identifier for the entry.
   *
   * @return a permanent, universally unique identifier for the entry.
   */
  @XmlSchemaType (name = "anyURI", namespace = XMLConstants.W3C_XML_SCHEMA_NS_URI)
  public URI getId() {
    return id;
  }

  /**
   * a permanent, universally unique identifier for the entry.
   *
   * @param id a permanent, universally unique identifier for the entry.
   */
  public void setId(URI id) {
    this.id = id;
  }

  /**
   * The relevance score, if this entry represents a search result. The value must contain a decimal representation of a real number between 0 and 1, inclusive.
   *
   * @return The relevance score, if this entry represents a search result. The value must contain a decimal representation of a real number between 0 and 1, inclusive.
   * @see <a href="http://www.opensearch.org/Specifications/OpenSearch/Extensions/Relevance/1.0">OpenSearch Relevance Extension</a>
   */
  @XmlElement(namespace = OpenSearchModel.OPENSEARCH_RELEVANCE_NAMESPACE )
  public Float getScore() {
    return score;
  }

  /**
   * The relevance score, if this entry represents a search result. The value must contain a decimal representation of a real number between 0 and 1, inclusive.
   *
   * @param score The relevance score, if this entry represents a search result. The value must contain a decimal representation of a real number between 0 and 1, inclusive.
   */
  public void setScore(Float score) {
    this.score = score;
  }

  /**
   * a reference from a entry to a Web resource.
   *
   * @return a reference from a entry to a Web resource.
   */
  @XmlElement (name = "link")
  @JsonName("links")
  @JsonProperty("links")
  public List<Link> getLinks() {
    return links;
  }

  /**
   * a reference from a entry to a Web resource.
   *
   * @param links a reference from a entry to a Web resource.
   */
  @JsonProperty("links")
  public void setLinks(List<Link> links) {
    this.links = links;
  }

  /**
   * instant in time associated with an event early in the life cycle of the entry.
   *
   * @return instant in time associated with an event early in the life cycle of the entry.
   */
  public Date getPublished() {
    return published;
  }

  /**
   * instant in time associated with an event early in the life cycle of the entry.
   *
   * @param published instant in time associated with an event early in the life cycle of the entry.
   */
  public void setPublished(Date published) {
    this.published = published;
  }

  /**
   * information about rights held in and over the entry.
   *
   * @return information about rights held in and over the entry.
   */
  public String getRights() {
    return rights;
  }

  /**
   * information about rights held in and over the entry.
   *
   * @param rights information about rights held in and over the entry.
   */
  public void setRights(String rights) {
    this.rights = rights;
  }

  /**
   * a human-readable title for the entry
   *
   * @return a human-readable title for the entry
   */
  public String getTitle() {
    return title;
  }

  /**
   * a human-readable title for the entry
   *
   * @param title a human-readable title for the entry
   */
  public void setTitle(String title) {
    this.title = title;
  }

  /**
   * the most recent instant in time when the entry was modified in a way the publisher considers significant.
   *
   * @return the most recent instant in time when the entry was modified in a way the publisher considers significant.
   */
  public Date getUpdated() {
    return updated;
  }

  /**
   * the most recent instant in time when the entry was modified in a way the publisher considers significant.
   *
   * @param updated the most recent instant in time when the entry was modified in a way the publisher considers significant.
   */
  public void setUpdated(Date updated) {
    this.updated = updated;
  }

}

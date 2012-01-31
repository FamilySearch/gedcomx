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
package org.gedcomx.opensearch;

import org.codehaus.jackson.annotate.JsonTypeInfo;
import org.codehaus.jackson.map.annotate.JsonTypeIdResolver;
import org.gedcomx.rt.XmlTypeIdResolver;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Describes a specific search request that can be made by the search client.
 *
 * @author Ryan Heaton
 * @see <a href="http://www.opensearch.org/Specifications/OpenSearch/1.1#OpenSearch_Query_element">OpenSearch Query Element</a>
 */
@XmlType( name = "Query" )
@JsonTypeInfo ( use =JsonTypeInfo.Id.CUSTOM, property = XmlTypeIdResolver.TYPE_PROPERTY_NAME)
@JsonTypeIdResolver (XmlTypeIdResolver.class)
@SuppressWarnings("gedcomx:no_id")
public class Query {
  
  private String role;
  private String title;
  private Integer totalResults;
  private String searchTerms;
  private Integer count;
  private Integer startIndex;
  private String startPage;
  private String language;
  private String inputEncoding;
  private String outputEncoding;

  /**
   * how the search client should interpret the search request defined by this Query element.
   *
   * @return how the search client should interpret the search request defined by this Query element.
   */
  @XmlAttribute
  public String getRole() {
    return role;
  }

  /**
   * how the search client should interpret the search request defined by this Query element.
   *
   * @param role how the search client should interpret the search request defined by this Query element.
   */
  public void setRole(String role) {
    this.role = role;
  }

  /**
   * human-readable plain text string describing the search request.
   *
   * @return human-readable plain text string describing the search request.
   */
  @XmlAttribute
  public String getTitle() {
    return title;
  }

  /**
   * human-readable plain text string describing the search request.
   *
   * @param title human-readable plain text string describing the search request.
   */
  public void setTitle(String title) {
    this.title = title;
  }

  /**
   * the expected number of results to be found if the search request were made.
   *
   * @return the expected number of results to be found if the search request were made.
   */
  @XmlAttribute
  public Integer getTotalResults() {
    return totalResults;
  }

  /**
   * the expected number of results to be found if the search request were made.
   *
   * @param totalResults the expected number of results to be found if the search request were made.
   */
  public void setTotalResults(Integer totalResults) {
    this.totalResults = totalResults;
  }

  /**
   * the keyword or keywords desired by the search client
   *
   * @return the keyword or keywords desired by the search client
   */
  @XmlAttribute
  public String getSearchTerms() {
    return searchTerms;
  }

  /**
   * the keyword or keywords desired by the search client
   *
   * @param searchTerms the keyword or keywords desired by the search client
   */
  public void setSearchTerms(String searchTerms) {
    this.searchTerms = searchTerms;
  }

  /**
   * the number of search results per page desired by the search client.
   *
   * @return the number of search results per page desired by the search client.
   */
  @XmlAttribute
  public Integer getCount() {
    return count;
  }

  /**
   * the number of search results per page desired by the search client.
   *
   * @param count the number of search results per page desired by the search client.
   */
  public void setCount(Integer count) {
    this.count = count;
  }

  /**
   * the index of the first search result desired by the search client.
   *
   * @return the index of the first search result desired by the search client.
   */
  @XmlAttribute
  public Integer getStartIndex() {
    return startIndex;
  }

  /**
   * the index of the first search result desired by the search client.
   *
   * @param startIndex the index of the first search result desired by the search client.
   */
  public void setStartIndex(Integer startIndex) {
    this.startIndex = startIndex;
  }

  /**
   * the page number of the set of search results desired by the search client.
   *
   * @return the page number of the set of search results desired by the search client.
   */
  @XmlAttribute
  public String getStartPage() {
    return startPage;
  }

  /**
   * the page number of the set of search results desired by the search client.
   *
   * @param startPage the page number of the set of search results desired by the search client.
   */
  public void setStartPage(String startPage) {
    this.startPage = startPage;
  }

  /**
   * indicates that the search client desires search results in the specified language.
   *
   * @return indicates that the search client desires search results in the specified language.
   */
  @XmlAttribute
  public String getLanguage() {
    return language;
  }

  /**
   * indicates that the search client desires search results in the specified language.
   *
   * @param language indicates that the search client desires search results in the specified language.
   */
  public void setLanguage(String language) {
    this.language = language;
  }

  /**
   * indicates that the search client is performing the search request encoded with the specified character encoding.
   *
   * @return indicates that the search client is performing the search request encoded with the specified character encoding.
   */
  @XmlAttribute
  public String getInputEncoding() {
    return inputEncoding;
  }

  /**
   * indicates that the search client is performing the search request encoded with the specified character encoding.
   *
   * @param inputEncoding indicates that the search client is performing the search request encoded with the specified character encoding.
   */
  public void setInputEncoding(String inputEncoding) {
    this.inputEncoding = inputEncoding;
  }

  /**
   * indicates that the search client desires a search response encoding with the specified character encoding.
   *
   * @return indicates that the search client desires a search response encoding with the specified character encoding.
   */
  @XmlAttribute
  public String getOutputEncoding() {
    return outputEncoding;
  }

  /**
   * indicates that the search client desires a search response encoding with the specified character encoding.
   *
   * @param outputEncoding indicates that the search client desires a search response encoding with the specified character encoding.
   */
  public void setOutputEncoding(String outputEncoding) {
    this.outputEncoding = outputEncoding;
  }
}

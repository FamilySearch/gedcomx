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
package org.gedcomx.common;

import org.codehaus.enunciate.json.JsonName;
import org.codehaus.jackson.annotate.JsonProperty;
import org.gedcomx.conclusion.Document;
import org.gedcomx.conclusion.Event;
import org.gedcomx.conclusion.Person;
import org.gedcomx.conclusion.Relationship;
import org.gedcomx.contributor.Agent;
import org.gedcomx.rt.json.JsonElementWrapper;
import org.gedcomx.source.SourceDescription;

import javax.xml.XMLConstants;
import javax.xml.bind.annotation.*;
import java.util.List;

/**
 * The root document of the GEDCOM X media type. A container for all data of type GEDCOM X.
 *
 * @author Ryan Heaton
 */
@XmlRootElement
@JsonElementWrapper (name = "gedcomx")
@XmlType ( name = "Gedcomx" )
public class Gedcomx extends ExtensibleData {

  private String id;
  private String lang;
  private Attribution attribution;
  private List<Person> persons;
  private List<Relationship> relationships;
  private List<SourceDescription> sourceDescriptions;
  private List<Agent> agents;
  private List<Event> events;
  private List<Document> documents;

  /**
   * The id of this genealogical data set.
   *
   * @return The id of this genealogical data set.
   */
  @XmlAttribute
  @XmlID
  public String getId() {
    return id;
  }

  /**
   * The id of this genealogical data set.
   *
   * @param id The id of this genealogical data set.
   */
  public void setId(String id) {
    this.id = id;
  }

  /**
   * The language of this genealogical data set. See <a href="http://www.w3.org/International/articles/language-tags/>http://www.w3.org/International/articles/language-tags/</a>.
   * Note that some language-enabled elements MAY override the language. 
   *
   * @return The language of the genealogical data.
   */
  @XmlAttribute ( namespace = XMLConstants.XML_NS_URI )
  public String getLang() {
    return lang;
  }

  /**
   * The language of this genealogical data set. See <a href="http://www.w3.org/International/articles/language-tags/>http://www.w3.org/International/articles/language-tags/</a>.
   * Note that some language-enabled elements MAY override the language.
   *
   * @param lang The language of this genealogical data.
   */
  public void setLang(String lang) {
    this.lang = lang;
  }

  /**
   * The attribution of this genealogical data.
   *
   * @return The attribution of this genealogical data.
   */
  public Attribution getAttribution() {
    return attribution;
  }

  /**
   * The attribution of this genealogical data.
   *
   * @param attribution The attribution of this genealogical data.
   */
  public void setAttribution(Attribution attribution) {
    this.attribution = attribution;
  }

  /**
   * The persons included in this genealogical data set.
   * 
   * @return The persons included in this genealogical data set.
   */
  @XmlElement (name="person")
  @JsonProperty ("persons")
  @JsonName ("persons")
  public List<Person> getPersons() {
    return persons;
  }

  /**
   * The persons included in this genealogical data set.
   * 
   * @param persons The persons included in this genealogical data set.
   */
  @JsonProperty ("persons")
  public void setPersons(List<Person> persons) {
    this.persons = persons;
  }
  
  /**
   * The relationships included in this genealogical data set.
   * 
   * @return The relationships included in this genealogical data set.
   */
  @XmlElement (name="relationship")
  @JsonProperty ("relationships")
  @JsonName ("relationships")
  public List<Relationship> getRelationships() {
    return relationships;
  }

  /**
   * The relationships included in this genealogical data set.
   * 
   * @param relationships The relationships included in this genealogical data set.
   */
  @JsonProperty ("relationships")
  public void setRelationships(List<Relationship> relationships) {
    this.relationships = relationships;
  }
  
  /**
   * The descriptions of sources included in this genealogical data set.
   * 
   * @return The descriptions of sources included in this genealogical data set.
   */
  @XmlElement (name="sourceDescription")
  @JsonProperty ("sourceDescriptions")
  @JsonName ("sourceDescriptions")
  public List<SourceDescription> getSourceDescriptions() {
    return sourceDescriptions;
  }

  /**
   * The descriptions of sources included in this genealogical data set.
   * 
   * @param sourceDescriptions The descriptions of sources included in this genealogical data set.
   */
  @JsonProperty ("sourceDescriptions")
  public void setSourceDescriptions(List<SourceDescription> sourceDescriptions) {
    this.sourceDescriptions = sourceDescriptions;
  }

  /**
   * The agents included in this genealogical data set.
   *
   * @return The agents included in this genealogical data set.
   */
  @XmlElement (name="agent")
  @JsonProperty ("agents")
  @JsonName ("agents")
  public List<Agent> getAgents() {
    return agents;
  }

  /**
   * The agents included in this genealogical data set.
   *
   * @param agents The agents included in this genealogical data set.
   */
  @JsonProperty ("agents")
  public void setAgents(List<Agent> agents) {
    this.agents = agents;
  }

  /**
   * The events included in this genealogical data set.
   *
   * @return The events included in this genealogical data set.
   */
  @XmlElement (name="event")
  @JsonProperty ("events")
  @JsonName ("events")
  public List<Event> getEvents() {
    return events;
  }

  /**
   * The events included in this genealogical data set.
   *
   * @param events The events included in this genealogical data set.
   */
  @JsonProperty ("events")
  public void setEvents(List<Event> events) {
    this.events = events;
  }

  /**
   * The documents included in this genealogical data set.
   *
   * @return The documents included in this genealogical data set.
   */
  @XmlElement (name="document")
  @JsonProperty ("documents")
  @JsonName ("documents")
  public List<Document> getDocuments() {
    return documents;
  }

  /**
   * The documents included in this genealogical data set.
   *
   * @param documents The documents included in this genealogical data set.
   */
  @JsonProperty ("documents")
  public void setDocuments(List<Document> documents) {
    this.documents = documents;
  }

}
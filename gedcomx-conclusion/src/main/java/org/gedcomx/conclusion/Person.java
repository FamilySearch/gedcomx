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
package org.gedcomx.conclusion;

import org.codehaus.enunciate.json.JsonName;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonTypeInfo;
import org.codehaus.jackson.map.annotate.JsonTypeIdResolver;
import org.gedcomx.common.*;
import org.gedcomx.rt.XmlTypeIdResolver;
import org.gedcomx.types.TypesNamespaces;

import javax.xml.XMLConstants;
import javax.xml.bind.annotation.*;
import java.net.URI;
import java.util.List;

/**
 * A person.
 *
 * @author Ryan Heaton
 */
@XmlRootElement(name = "person")
@JsonTypeInfo ( use =JsonTypeInfo.Id.CUSTOM, property = "@type")
@JsonTypeIdResolver (XmlTypeIdResolver.class)
@XmlType ( name = "Person", propOrder = {"persistentId", "alternateIds", "bibliographicCitation", "gender", "names", "events", "characteristics", "sources", "extension"} )
public class Person implements Extensible, PersistentIdentifiable, BibliographicResource, HasEvents, HasCharacteristics, SourceSupported {

  private String id;
  private List<AlternateId> alternateIds;
  private URI persistentId;
  private Gender gender;
  private List<Name> names;
  private List<Event> events;
  private List<Characteristic> characteristics;
  private String bibliographicCitation;
  private List<ResourceReference> sources;
  private Extension extension;

  /**
   * The id of the person, unique to the context and not necessarily globally unique.
   *
   * @return The id of the person, unique to the context and not necessarily globally unique.
   */
  @XmlID
  @XmlAttribute(name = "ID", namespace = TypesNamespaces.RDF_NAMESPACE)
  public String getId() {
    return id;
  }

  /**
   * The id of the person, unique to the context and not necessarily globally unique.
   *
   * @param id The id of the person, unique to the context and not necessarily globally unique.
   */
  public void setId(String id) {
    this.id = id;
  }

  /**
   * A long-term, persistent, globally unique identifier for this person.
   *
   * @return A long-term, persistent, globally unique identifier for this person.
   */
  @XmlSchemaType(name = "anyURI", namespace = XMLConstants.W3C_XML_SCHEMA_NS_URI)
  public URI getPersistentId() {
    return persistentId;
  }

  /**
   * A long-term, persistent, globally unique identifier for this person.
   *
   * @param persistentId A long-term, persistent, globally unique identifier for this person.
   */
  public void setPersistentId(URI persistentId) {
    this.persistentId = persistentId;
  }

  /**
   * The list of alternate ids of the person.
   *
   * @return The list of alternate ids of the person.
   */
  @XmlElement (name="alternateId")
  @JsonProperty ("alternateIds")
  @JsonName ("alternateIds")
  public List<AlternateId> getAlternateIds() {
    return alternateIds;
  }

  /**
   * The list of alternate ids of the person.
   *
   * @param alternateIds The list of alternate ids of the person.
   */
  @JsonProperty ("alternateIds")
  public void setAlternateIds(List<AlternateId> alternateIds) {
    this.alternateIds = alternateIds;
  }

  /**
   * The gender of the person.
   *
   * @return The gender of the person.
   */
  public Gender getGender() {
    return gender;
  }

  /**
   * The gender conclusion for the person.
   *
   * @param gender The gender conclusion for the person.
   */
  public void setGender(Gender gender) {
    this.gender = gender;
  }

  /**
   * The name conclusions for the person.
   *
   * @return The name conclusions for the person.
   */
  @XmlElement(name="name")
  @JsonProperty("names")
  @JsonName("names")
  public List<Name> getNames() {
    return names;
  }

  /**
   * The name conclusions for the person.
   *
   * @param names The name conclusions for the person.
   */
  @JsonProperty("names")
  public void setNames(List<Name> names) {
    this.names = names;
  }

  /**
   * The event conclusions for the person.
   *
   * @return The event conclusions for the person.
   */
  @XmlElement(name="event")
  @JsonProperty("events")
  @JsonName("events")
  public List<Event> getEvents() {
    return events;
  }

  /**
   * The event conclusions for the person.
   *
   * @param events The event conclusions for the person.
   */
  @JsonProperty("events")
  public void setEvents(List<Event> events) {
    this.events = events;
  }

  /**
   * The characteristic conclusions for the person.
   *
   * @return The characteristic conclusions for the person.
   */
  @XmlElement(name="characteristic")
  @JsonProperty("characteristics")
  @JsonName("characteristics")
  public List<Characteristic> getCharacteristics() {
    return characteristics;
  }

  /**
   * The characteristic conclusions for the person.
   *
   * @param characteristics The characteristic conclusions for the person.
   */
  @JsonProperty("characteristics")
  public void setCharacteristics(List<Characteristic> characteristics) {
    this.characteristics = characteristics;
  }

  /**
   * The bibliographic citation for this data.
   *
   * @return The bibliographic citation for this data.
   */
  public String getBibliographicCitation() {
    return bibliographicCitation;
  }

  /**
   * The bibliographic citation for this data.
   *
   * @param bibliographicCitation The bibliographic citation for this data.
   */
  public void setBibliographicCitation(String bibliographicCitation) {
    this.bibliographicCitation = bibliographicCitation;
  }

  /**
   * The sources for the conclusions about this person.
   *
   * @return The sources for the conclusions about this person.
   */
  @XmlElement(name="source")
  @JsonProperty("sources")
  @JsonName("sources")
  public List<ResourceReference> getSources() {
    return sources;
  }

  /**
   * The sources for the conclusions about this person.
   *
   * @param sources The sources for the conclusions about this person.
   */
  @JsonProperty("sources")
  public void setSources(List<ResourceReference> sources) {
    this.sources = sources;
  }

  /**
   * The extension point for the person.
   *
   * @return The extension point for the person.
   */
  @XmlElement( name = "ext" )
  public Extension getExtension() {
    return extension;
  }

  /**
   * The extension point for the person.
   *
   * @param extension The extension point for the person.
   */
  public void setExtension(Extension extension) {
    this.extension = extension;
  }
}

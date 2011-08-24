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

import org.codehaus.enunciate.XmlQNameEnumUtil;
import org.codehaus.enunciate.json.JsonName;
import org.codehaus.enunciate.qname.XmlQNameEnumRef;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonTypeInfo;
import org.codehaus.jackson.map.annotate.JsonTypeIdResolver;
import org.gedcomx.common.*;
import org.gedcomx.rt.XmlTypeIdResolver;
import org.gedcomx.types.RelationshipType;
import org.gedcomx.types.TypesNamespaces;

import javax.xml.XMLConstants;
import javax.xml.bind.annotation.*;
import java.net.URI;
import java.util.List;

/**
 * A relationship between two or more persons.
 *
 * @author Ryan Heaton
 */
@XmlRootElement
@XmlType (
  propOrder = {"persistentId", "alternateIds", "person1", "person2", "attribution", "events", "characteristics", "bibliographicCitation", "sources", "extension"}
)
@JsonTypeInfo ( use =JsonTypeInfo.Id.CUSTOM, property = "@type")
@JsonTypeIdResolver (XmlTypeIdResolver.class)
public class Relationship implements Attributable {

  private String id;
  private URI type;
  private URI persistentId;
  private List<AlternateId> alternateIds;
  private ResourceReference person1;
  private ResourceReference person2;
  private Attribution attribution;
  private List<Event> events;
  private List<Characteristic> characteristics;
  private String bibliographicCitation;
  private List<ResourceReference> sources;
  private Extension extension;

  /**
   * The id of the relationship, unique to the context and not necessarily globally unique.
   *
   * @return The id of the relationship, unique to the context and not necessarily globally unique.
   */
  @XmlID
  @XmlAttribute(name = "ID", namespace = TypesNamespaces.RDF_NAMESPACE)
  public String getId() {
    return id;
  }

  /**
   * The id of the relationship, unique to the context and not necessarily globally unique.
   *
   * @param id The id of the relationship, unique to the context and not necessarily globally unique.
   */
  public void setId(String id) {
    this.id = id;
  }

  /**
   * The type of this relationship.
   *
   * @return The type of this relationship.
   */
  @XmlAttribute
  @XmlQNameEnumRef (RelationshipType.class)
  @XmlSchemaType (name = "anyURI", namespace = XMLConstants.W3C_XML_SCHEMA_NS_URI)
  public URI getType() {
    return type;
  }

  /**
   * The type of this relationship.
   *
   * @param type The type of this relationship.
   */
  public void setType(URI type) {
    this.type = type;
  }

  /**
   * The enum referencing the known type of the relationship, or {@link org.gedcomx.types.RelationshipType#other} if not known.
   *
   * @return The enum referencing the known type of the relationship, or {@link org.gedcomx.types.RelationshipType#other} if not known.
   */
  @XmlTransient
  @JsonIgnore
  public RelationshipType getKnownType() {
    return XmlQNameEnumUtil.fromURI(getType(), RelationshipType.class);
  }

  /**
   * Set the relationship type from a known enumeration of relationship types.
   *
   * @param type The relationship type.
   */
  @JsonIgnore
  public void setKnownType(RelationshipType type) {
    setType(XmlQNameEnumUtil.toURI(type));
  }

  /**
   * A long-term, persistent, globally unique identifier for this relationship.
   *
   * @return A long-term, persistent, globally unique identifier for this relationship.
   */
  @XmlSchemaType(name = "anyURI", namespace = XMLConstants.W3C_XML_SCHEMA_NS_URI)
  public URI getPersistentId() {
    return persistentId;
  }

  /**
   * A long-term, persistent, globally unique identifier for this relationship.
   *
   * @param persistentId A long-term, persistent, globally unique identifier for this relationship.
   */
  public void setPersistentId(URI persistentId) {
    this.persistentId = persistentId;
  }

  /**
   * The list of alternate ids of the relationship.
   *
   * @return The list of alternate ids of the relationship.
   */
  @XmlElement (name="alternateId")
  @JsonProperty("alternateIds")
  @JsonName("alternateIds")
  public List<AlternateId> getAlternateIds() {
    return alternateIds;
  }

  /**
   * The list of alternate ids of the relationship.
   *
   * @param alternateIds The list of alternate ids of the relationship.
   */
  @JsonProperty("alternateIds")
  public void setAlternateIds(List<AlternateId> alternateIds) {
    this.alternateIds = alternateIds;
  }

  /**
   * A reference to a person in the relationship. The name "person1" is used only to distinguish it from
   * the other person in this relationship and implies neither order nor role. When the relationship type
   * implies direction, it goes from "person1" to "person2".
   *
   * @return A reference to a person in the relationship. The name "person1" is used only to distinguish it from
   * the other person in this relationship and implies neither order nor role. When the relationship type
   * implies direction, it goes from "person1" to "person2".
   */
  public ResourceReference getPerson1() {
    return person1;
  }

  /**
   * A reference to a person in the relationship. The name "person1" is used only to distinguish it from
   * the other person in this relationship and implies neither order nor role. When the relationship type
   * implies direction, it goes from "person1" to "person2".
   *
   * @param person1 A reference to a person in the relationship. The name "person1" is used only to distinguish it from
   * the other person in this relationship and implies neither order nor role. When the relationship type
   * implies direction, it goes from "person1" to "person2".
   */
  public void setPerson1(ResourceReference person1) {
    this.person1 = person1;
  }

  /**
   * A reference to a person in the relationship. The name "person2" is used only to distinguish it from
   * the other person in this relationship and implies neither order nor role. When the relationship type
   * implies direction, it goes from "person1" to "person2".
   *
   * @return A reference to a person in the relationship. The name "person2" is used only to distinguish it from
   * the other person in this relationship and implies neither order nor role. When the relationship type
   * implies direction, it goes from "person1" to "person2".
   */
  public ResourceReference getPerson2() {
    return person2;
  }

  /**
   * A reference to a person in the relationship. The name "person2" is used only to distinguish it from
   * the other person in this relationship and implies neither order nor role. When the relationship type
   * implies direction, it goes from "person1" to "person2".
   *
   * @param person2 A reference to a person in the relationship. The name "person2" is used only to distinguish it from
   * the other person in this relationship and implies neither order nor role. When the relationship type
   * implies direction, it goes from "person1" to "person2".
   */
  public void setPerson2(ResourceReference person2) {
    this.person2 = person2;
  }

  /**
   * The attribution metadata for this relationship.
   *
   * @return The attribution metadata for this relationship.
   */
  public Attribution getAttribution() {
    return attribution;
  }

  /**
   * The attribution metadata for this relationship.
   *
   * @param attribution The attribution metadata for this relationship.
   */
  public void setAttribution(Attribution attribution) {
    this.attribution = attribution;
  }

  /**
   * The event conclusions for the relationship.
   *
   * @return The event conclusions for the relationship.
   */
  @XmlElement(name="event")
  @JsonProperty("events")
  @JsonName("events")
  public List<Event> getEvents() {
    return events;
  }

  /**
   * The event conclusions for the relationship.
   *
   * @param events The event conclusions for the relationship.
   */
  @JsonProperty("events")
  public void setEvents(List<Event> events) {
    this.events = events;
  }

  /**
   * The characteristic conclusions for the relationship.
   *
   * @return The characteristic conclusions for the relationship.
   */
  @XmlElement(name="characteristic")
  @JsonProperty("characteristics")
  @JsonName("characteristics")
  public List<Characteristic> getCharacteristics() {
    return characteristics;
  }

  /**
   * The characteristic conclusions for the relationship.
   *
   * @param characteristics The characteristic conclusions for the relationship.
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
   * The sources for the conclusions about this relationship.
   *
   * @return The sources for the conclusions about this relationship.
   */
  @XmlElement(name="source")
  @JsonProperty ("sources")
  @JsonName ("sources")
  public List<ResourceReference> getSources() {
    return sources;
  }

  /**
   * The sources for the conclusions about this relationship.
   *
   * @param sources The sources for the conclusions about this relationship.
   */
  @JsonProperty ("sources")
  public void setSources(List<ResourceReference> sources) {
    this.sources = sources;
  }

  /**
   * The extension point for the relationship.
   *
   * @return The extension point for the relationship.
   */
  @XmlElement( name = "ext" )
  public Extension getExtension() {
    return extension;
  }

  /**
   * The extension point for the relationship.
   *
   * @param extension The extension point for the relationship.
   */
  public void setExtension(Extension extension) {
    this.extension = extension;
  }
}

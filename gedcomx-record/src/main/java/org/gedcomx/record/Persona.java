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
package org.gedcomx.record;

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
import java.util.ArrayList;
import java.util.List;

/**
 * A persona is the set of data about a person bounded by a single record.
 */
@JsonTypeInfo ( use =JsonTypeInfo.Id.CUSTOM, property = "@type")
@JsonTypeIdResolver (XmlTypeIdResolver.class)
@XmlType ( name = "Persona", propOrder = { "persistentId", "alternateIds", "gender", "age", "names", "eventRoles", "characteristics" } )
public class Persona extends GenealogicalResource implements PersistentIdentifiable, HasCharacteristics, Weighted {

  private Boolean principal;
  private URI persistentId;
  private List<AlternateId> alternateIds;
  private Gender gender;
  private Age age;
  private java.util.List<Name> names;
  private java.util.List<EventRole> eventRoles = new ArrayList<EventRole>();
  private java.util.List<Characteristic> characteristics = new ArrayList<Characteristic>();

  /**
   * A long-term, persistent, globally unique identifier for this persona.
   *
   * @return A long-term, persistent, globally unique identifier for this persona.
   */
  @XmlSchemaType (name = "anyURI", namespace = XMLConstants.W3C_XML_SCHEMA_NS_URI)
  public URI getPersistentId() {
    return persistentId;
  }

  /**
   * A long-term, persistent, globally unique identifier for this persona.
   *
   * @param persistentId A long-term, persistent, globally unique identifier for this persona.
   */
  public void setPersistentId(URI persistentId) {
    this.persistentId = persistentId;
  }

  /**
   * The list of alternate ids of the persona.
   *
   * @return The list of alternate ids of the persona.
   */
  @XmlElement (name="alternateId")
  @JsonProperty ("alternateIds")
  @JsonName ("alternateIds")
  public List<AlternateId> getAlternateIds() {
    return alternateIds;
  }

  /**
   * The list of alternate ids of the persona.
   *
   * @param alternateIds The list of alternate ids of the persona.
   */
  @JsonProperty ("alternateIds")
  public void setAlternateIds(List<AlternateId> alternateIds) {
    this.alternateIds = alternateIds;
  }

  /**
   * The gender of the persona.
   *
   * @return The gender of the persona.
   */
  public Gender getGender() {
    return gender;
  }

  /**
   * The gender conclusion for the persona.
   *
   * @param gender The gender conclusion for the persona.
   */
  public void setGender(Gender gender) {
    this.gender = gender;
  }

  /**
   * The age field for the persona.
   * 
   * @return The age field for the persona.
   */
  public Age getAge() {
    return age;
  }

  /**
   * The age field for the persona.
   * 
   * @param age The age field for the persona.
   */
  public void setAge(Age age) {
    this.age = age;
  }

  /**
   * The name conclusions for the persona.
   *
   * @return The name conclusions for the persona.
   */
  @XmlElement(name="name")
  @JsonProperty("names")
  @JsonName("names")
  public java.util.List<Name> getNames() {
    return names;
  }

  /**
   * The name conclusions for the persona.
   *
   * @param names The name conclusions for the persona.
   */
  @JsonProperty("names")
  public void setNames(java.util.List<Name> names) {
    this.names = names;
  }

  /**
   * The characteristic fields on this persona.
   *
   * @return The characteristic fields on this persona.
   */
  @XmlElement(name="characteristic")
  @JsonProperty("characteristics")
  @JsonName("characteristics")
  public List<Characteristic> getCharacteristics() {
    return characteristics;
  }

  /**
   * The characteristic fields on this persona.
   *
   * @param characteristics The characteristic fields on this persona.
   */
  @JsonProperty("characteristics")
  public void setCharacteristics(List<Characteristic> characteristics) {
    this.characteristics = characteristics;
  }

  /**
   * The roles this persona plays in the events of the record.
   *
   * @return The roles this persona plays in the events of the record.
   */
  @XmlElement(name = "eventRole")
  @JsonProperty("eventRoles")
  @JsonName("eventRoles")
  public List<EventRole> getEventRoles() {
    return eventRoles;
  }

  /**
   * The roles this persona plays in the events of the record.
   *
   * @param eventRoles The roles this persona plays in the events of the record.
   */
  @JsonProperty("eventRoles")
  public void setEventRoles(List<EventRole> eventRoles) {
    this.eventRoles = eventRoles;
  }

  /**
   * Whether this is the principal persona in the record. For example, the principal persona in a birth certificate is the persona whose birth
   * was recorded.
   *
   * @return Whether this is the principal persona in the record. For example, the principal persona in a birth certificate is the persona whose birth
   * was recorded.
   */
  @XmlAttribute
  public Boolean getPrincipal() {
    return principal;
  }

  /**
   * Whether this is the principal persona in the record. For example, the principal persona in a birth certificate is the persona whose birth
   * was recorded.
   *
   * @param isPrincipal Whether this is the principal persona in the record. For example, the principal persona in a birth certificate is the persona whose birth
   * was recorded.
   */
  public void setPrincipal(Boolean isPrincipal) {
    this.principal = isPrincipal;
  }

}

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

import org.codehaus.enunciate.XmlQNameEnumUtil;
import org.codehaus.jackson.annotate.JsonIgnore
;
import org.codehaus.enunciate.json.JsonName;
import org.codehaus.enunciate.qname.XmlQNameEnumRef;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonTypeInfo;
import org.codehaus.jackson.map.annotate.JsonTypeIdResolver;
import org.gedcomx.attribution.Attribution;
import org.gedcomx.common.ResourceReference;
import org.gedcomx.rt.XmlTypeIdResolver;
import org.gedcomx.common.Extension;
import org.gedcomx.types.RelationshipType;

import javax.xml.bind.annotation.*;
import javax.xml.namespace.QName;
import java.util.ArrayList;
import java.util.List;

/**
 * A recorded relationship.
 */
@JsonTypeInfo ( use =JsonTypeInfo.Id.CUSTOM, property = "@type")
@JsonTypeIdResolver (XmlTypeIdResolver.class)
@XmlType (
  propOrder = {"attribution", "persona1", "persona2", "characteristics", "extension"}
)
public class Relationship {

  private String id;
  private QName type;
  private Attribution attribution;
  private ResourceReference persona1;
  private ResourceReference persona2;
  private List<Characteristic> characteristics = new ArrayList<Characteristic>();
  private Extension extension;

  /**
   * The id of the relationship, unique to the context and not necessarily globally unique.
   *
   * @return The id of the relationship, unique to the context and not necessarily globally unique.
   */
  @XmlID
  @XmlAttribute
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
  public QName getType() {
    return type;
  }

  /**
   * The type of this relationship.
   *
   * @param type The type of this relationship.
   */
  public void setType(QName type) {
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
    return XmlQNameEnumUtil.fromQName(getType(), RelationshipType.class);
  }

  /**
   * Set the relationship type from a known enumeration of relationship types.
   *
   * @param type The relationship type.
   */
  @JsonIgnore
  public void setKnownType(RelationshipType type) {
    this.type = XmlQNameEnumUtil.toQName(type);
  }

  /**
   * The attribution metadata for this relationship.
   *
   * @return The attribution metadata for this relationship.
   */
  @XmlElementRef
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
   * A persona in the relationship. The name "persona1" is used only to distinguish it from
   * the other persona in this relationship. When the relationship type implies direction, it
   * goes from "persona1" to "persona2".
   *
   * @return A persona in the relationship. The name "persona1" is used only to distinguish it from
   * the other persona in this relationship. When the relationship type implies direction, it
   * goes from "persona1" to "persona2".
   */
  public ResourceReference getPersona1() {
    return this.persona1;
  }

  /**
   * A persona in the relationship. The name "persona1" is used only to distinguish it from
   * the other persona in this relationship. When the relationship type implies direction, it
   * goes from "persona1" to "persona2".
   *
   * @param persona1 A persona in the relationship. The name "persona1" is used only to distinguish it from
   * the other persona in this relationship. When the relationship type implies direction, it
   * goes from "persona1" to "persona2".
   */
  public void setPersona1(ResourceReference persona1) {
    this.persona1 = persona1;
  }

  /**
   * A persona in the relationship. The name "persona2" is used only to distinguish it from
   * the other persona in this relationship. When the relationship type implies direction, it
   * goes from "persona1" to "persona2".
   *
   * @return A persona in the relationship. The name "persona2" is used only to distinguish it from
   * the other persona in this relationship. When the relationship type implies direction, it
   * goes from "persona1" to "persona2".
   */
  public ResourceReference getPersona2() {
    return this.persona2;
  }

  /**
   * A persona in the relationship. The name "persona2" is used only to distinguish it from
   * the other persona in this relationship. When the relationship type implies direction, it
   * goes from "persona1" to "persona2".
   *
   * @param persona2 A persona in the relationship. The name "persona2" is used only to distinguish it from
   * the other persona in this relationship. When the relationship type implies direction, it
   * goes from "persona1" to "persona2".
   */
  public void setPersona2(ResourceReference persona2) {
    this.persona2 = persona2;
  }

  /**
   * The characteristic fields of the relationship.
   *
   * @return The characteristic fields of the relationship.
   */
  @XmlElement(name = "characteristic")
  @JsonProperty ("characteristics")
  @JsonName ("characteristics")
  public List<Characteristic> getCharacteristics() {
    return characteristics;
  }

  /**
   * The characteristic fields of the relationship.
   *
   * @param characteristics The characteristic fields of the relationship.
   */
  @JsonProperty ("characteristics")
  public void setCharacteristics(List<Characteristic> characteristics) {
    this.characteristics = characteristics;
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

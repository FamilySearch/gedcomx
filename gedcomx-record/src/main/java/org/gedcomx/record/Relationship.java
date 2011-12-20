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
import org.codehaus.enunciate.json.JsonName;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonTypeInfo;
import org.codehaus.jackson.map.annotate.JsonTypeIdResolver;
import org.gedcomx.common.GenealogicalResource;
import org.gedcomx.common.ResourceReference;
import org.gedcomx.rt.CommonModels;
import org.gedcomx.rt.RDFRange;
import org.gedcomx.rt.RDFSubPropertyOf;
import org.gedcomx.rt.XmlTypeIdResolver;
import org.gedcomx.types.RelationshipType;
import org.gedcomx.types.TypeReference;
import org.gedcomx.types.Typed;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;

/**
 * A recorded relationship.
 */
@JsonTypeInfo ( use =JsonTypeInfo.Id.CUSTOM, property = XmlTypeIdResolver.TYPE_PROPERTY_NAME)
@JsonTypeIdResolver (XmlTypeIdResolver.class)
@XmlType ( name = "Relationship", propOrder = { "type", "persona1", "persona2", "facts" } )
public class Relationship extends GenealogicalResource implements Typed<RelationshipType>, HasFacts {

  private TypeReference<RelationshipType> type;
  private ResourceReference persona1;
  private ResourceReference persona2;
  private List<Fact> facts = new ArrayList<Fact>();

  /**
   * The type of this relationship.
   *
   * @return The type of this relationship.
   */
  @XmlElement (namespace = CommonModels.RDF_NAMESPACE)
  public TypeReference<RelationshipType> getType() {
    return type;
  }

  /**
   * The type of this relationship.
   *
   * @param type The type of this relationship.
   */
  public void setType(TypeReference<RelationshipType> type) {
    this.type = type;
  }

  /**
   * The enum referencing the known type of the relationship, or {@link org.gedcomx.types.RelationshipType#OTHER} if not known.
   *
   * @return The enum referencing the known type of the relationship, or {@link org.gedcomx.types.RelationshipType#OTHER} if not known.
   */
  @XmlTransient
  @JsonIgnore
  public RelationshipType getKnownType() {
    return getType() == null ? null : RelationshipType.fromQNameURI(getType().getType());
  }

  /**
   * Set the relationship type from a known enumeration of relationship types.
   *
   * @param type The relationship type.
   */
  @JsonIgnore
  public void setKnownType(RelationshipType type) {
    setType(type == null ? null : new TypeReference<RelationshipType>(type));
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
  @RDFRange(Persona.class)
  @RDFSubPropertyOf ( CommonModels.DUBLIN_CORE_NAMESPACE + "hasPart")
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
  @RDFRange(Persona.class)
  @RDFSubPropertyOf ( CommonModels.DUBLIN_CORE_NAMESPACE + "hasPart")
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
   * The fact fields of the relationship.
   *
   * @return The fact fields of the relationship.
   */
  @XmlElement(name = "fact")
  @JsonProperty ("facts")
  @JsonName ("facts")
  public List<Fact> getFacts() {
    return facts;
  }

  /**
   * The fact fields of the relationship.
   *
   * @param facts The fact fields of the relationship.
   */
  @JsonProperty ("facts")
  public void setFacts(List<Fact> facts) {
    this.facts = facts;
  }

}

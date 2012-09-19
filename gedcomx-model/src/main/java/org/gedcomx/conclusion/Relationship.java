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
package org.gedcomx.conclusion;

import org.codehaus.enunciate.json.JsonName;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;
import org.gedcomx.common.Attributable;
import org.gedcomx.common.Attribution;
import org.gedcomx.common.ResourceReference;
import org.gedcomx.common.URI;
import org.gedcomx.rt.RDFRange;
import org.gedcomx.rt.RDFSubPropertyOf;
import org.gedcomx.rt.json.JsonElementWrapper;
import org.gedcomx.types.RelationshipType;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;


/**
 * A relationship between two or more persons.
 *
 * @author Ryan Heaton
 */
@XmlRootElement
@JsonElementWrapper ( name = "relationships" )
@XmlType ( name = "Relationship", propOrder = { "attribution", "person1", "person2", "facts" } )
public class Relationship extends Conclusion implements HasFacts, Attributable {

  private URI type;
  private Attribution attribution;
  private ResourceReference person1;
  private ResourceReference person2;
  private List<Fact> facts;

  /**
   * The type of this relationship.
   *
   * @return The type of this relationship.
   */
  @XmlAttribute
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
   * The enum referencing the known type of the relationship, or {@link org.gedcomx.types.RelationshipType#OTHER} if not known.
   *
   * @return The enum referencing the known type of the relationship, or {@link org.gedcomx.types.RelationshipType#OTHER} if not known.
   */
  @XmlTransient
  @JsonIgnore
  public RelationshipType getKnownType() {
    return getType() == null ? null : RelationshipType.fromQNameURI(getType());
  }

  /**
   * Set the relationship type from a known enumeration of relationship types.
   *
   * @param type The relationship type.
   */
  @JsonIgnore
  public void setKnownType(RelationshipType type) {
    setType(type == null ? null : URI.create(org.codehaus.enunciate.XmlQNameEnumUtil.toURIValue(type)));
  }

  /**
   * Attribution metadata for a conclusion.
   *
   * @return Attribution metadata for a conclusion.
   */
  @Override
  public Attribution getAttribution() {
    return attribution;
  }

  /**
   * Attribution metadata for a conclusion.
   *
   * @param attribution Attribution metadata for a conclusion.
   */
  @Override
  public void setAttribution(Attribution attribution) {
    this.attribution = attribution;
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
  @RDFRange (Person.class)
  @RDFSubPropertyOf ( "http://purl.org/dc/terms/hasPart")
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
  @RDFRange (Person.class)
  @RDFSubPropertyOf ( "http://purl.org/dc/terms/hasPart")
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
   * The fact conclusions for the relationship.
   *
   * @return The fact conclusions for the relationship.
   */
  @XmlElement(name="fact")
  @JsonProperty("facts")
  @JsonName("facts")
  public List<Fact> getFacts() {
    return facts;
  }

  /**
   * The fact conclusions for the relationship.
   *
   * @param facts The fact conclusions for the relationship.
   */
  @JsonProperty("facts")
  public void setFacts(List<Fact> facts) {
    this.facts = facts;
  }

  /**
   * Add a fact conclusion.
   *
   * @param fact The fact conclusion to be added.
   */
  public void addFact(Fact fact) {
    if (fact != null) {
      if (facts == null) {
        facts = new ArrayList<Fact>();
      }
      facts.add(fact);
    }
  }
}

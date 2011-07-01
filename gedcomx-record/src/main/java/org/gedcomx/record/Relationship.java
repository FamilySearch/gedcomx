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
import org.gedcomx.types.RelationshipType;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.namespace.QName;
import java.util.ArrayList;
import java.util.List;

/**
 * A recorded relationship.
 */
public abstract class Relationship {

  //heatonra - consideration was given to not subclassing relationship into couple, p/c, and other. It was decided to optimize for the common case and
  //provide subclasses.

  private String id;
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
   * A persona in the relationship. The name "persona1" is used only to distinguish it from
   * the other persona in this relationship and implies neither order nor role.
   *
   * @return A persona in the relationship. The name "persona1" is used only to distinguish it from
   * the other persona in this relationship and implies neither order nor role.
   */
  public abstract PersonaReference getPersona1();

  /**
   * A persona in the relationship. The name "persona1" is used only to distinguish it from
   * the other persona in this relationship and implies neither order nor role.
   *
   * @param persona1 A persona in the relationship. The name "persona1" is used only to distinguish it from
   * the other persona in this relationship and implies neither order nor role.
   */
  public abstract void setPersona1(PersonaReference persona1);

  /**
   * A persona in the relationship. The name "persona2" is used only to distinguish it from
   * the other persona in this relationship and implies neither order nor role.
   *
   * @return A persona in the relationship. The name "persona2" is used only to distinguish it from
   * the other persona in this relationship and implies neither order nor role.
   */
  public abstract PersonaReference getPersona2();

  /**
   * A persona in the relationship. The name "persona2" is used only to distinguish it from
   * the other persona in this relationship and implies neither order nor role.
   *
   * @param persona2 A persona in the relationship. The name "persona2" is used only to distinguish it from
   * the other persona in this relationship and implies neither order nor role.
   */
  public abstract void setPersona2(PersonaReference persona2);

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

  /**
   * The type of this relationship.
   *
   * @return The type of this relationship.
   */
  @JsonIgnore
  @XmlTransient
  public QName getType() {
    return XmlQNameEnumUtil.toQName(getKnownRelationshipType());
  }

  /**
   * The known type of this relationship.
   *
   * @return The known type of this relationship.
   */
  @XmlTransient
  public abstract RelationshipType getKnownRelationshipType();
}

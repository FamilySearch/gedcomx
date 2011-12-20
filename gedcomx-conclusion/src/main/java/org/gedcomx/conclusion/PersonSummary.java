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

import org.codehaus.jackson.annotate.JsonTypeInfo;
import org.codehaus.jackson.map.annotate.JsonTypeIdResolver;
import org.gedcomx.common.GenealogicalResource;
import org.gedcomx.common.ResourceReference;
import org.gedcomx.rt.*;

import javax.xml.XMLConstants;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import org.gedcomx.common.URI;

/**
 * Definition of the summary information for a person. The "summary" information is useful to applications
 * that want to specify which conclusions are identified as the "primary" conclusions about a person.
 *
 * @author Ryan Heaton
 */
@XmlRootElement ( name = "personSummary" )
@JsonElementWrapper ( name = "personSummaries" )
@JsonTypeInfo ( use =JsonTypeInfo.Id.CUSTOM, property = XmlTypeIdResolver.TYPE_PROPERTY_NAME)
@JsonTypeIdResolver (XmlTypeIdResolver.class)
@XmlType ( name = "PersonSummary", propOrder = { "gender", "name", "birth", "death" } )
@RDFSubClassOf( ConclusionModel.GEDCOMX_CONCLUSION_V1_NAMESPACE + "Person" )
public class PersonSummary extends GenealogicalResource {

  private URI personReference;
  private ResourceReference gender;
  private ResourceReference name;
  private ResourceReference birth;
  private ResourceReference death;

  /**
   * Reference to the person to which this summary information is being applied. The reference can be via persistent id,
   * if exists, or via local reference, e.g. "#personId".
   *
   * @return Reference to the person to which this summary information is being applied.
   */
  @XmlAttribute ( name = "about", namespace = CommonModels.RDF_NAMESPACE )
  @XmlSchemaType (name = "anyURI", namespace = XMLConstants.W3C_XML_SCHEMA_NS_URI)
  public URI getPersonReference() {
    return personReference;
  }

  /**
   * Reference to the person to which this summary information is being applied. The reference can be via persistent id,
   * if exists, or via local reference, e.g. "#personId".
   *
   * @param personReference Reference to the person to which this summary information is being applied.
   */
  public void setPersonReference(URI personReference) {
    this.personReference = personReference;
  }

  /**
   * Reference to the primary gender conclusion of the person.
   *
   * @return Reference to the primary gender conclusion of the person.
   */
  @RDFRange (Gender.class)
  @RDFDomain ( ConclusionModel.GEDCOMX_CONCLUSION_V1_NAMESPACE + "Person" )
  public ResourceReference getGender() {
    return gender;
  }

  /**
   * Reference to the primary gender conclusion of the person.
   *
   * @param gender Reference to the primary gender conclusion of the person.
   */
  public void setGender(ResourceReference gender) {
    this.gender = gender;
  }

  /**
   * Reference to the primary name for a person.
   *
   * @return Reference to the primary name for a person.
   */
  @RDFRange (Name.class)
  @RDFDomain ( ConclusionModel.GEDCOMX_CONCLUSION_V1_NAMESPACE + "Person" )
  public ResourceReference getName() {
    return name;
  }

  /**
   * Reference to the primary name for a person.
   *
   * @param name Reference to the primary name for a person.
   */
  public void setName(ResourceReference name) {
    this.name = name;
  }

  /**
   * Reference to the primary birth event for a person.
   *
   * @return Reference to the primary birth event for a person.
   */
  @RDFRange (Fact.class)
  public ResourceReference getBirth() {
    return birth;
  }

  /**
   * Reference to the primary birth event for a person.
   *
   * @param birth Reference to the primary birth event for a person.
   */
  public void setBirth(ResourceReference birth) {
    this.birth = birth;
  }

  /**
   * Reference to the primary death event for a person.
   *
   * @return Reference to the primary death event for a person.
   */
  @RDFRange (Fact.class)
  public ResourceReference getDeath() {
    return death;
  }

  /**
   * Reference to the primary death event for a person.
   *
   * @param death Reference to the primary death event for a person.
   */
  public void setDeath(ResourceReference death) {
    this.death = death;
  }
}

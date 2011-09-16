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
import org.gedcomx.rt.*;

import javax.xml.XMLConstants;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import java.net.URI;
import java.util.List;

/**
 * A family.
 *
 * @author Ryan Heaton
 */
@XmlRootElement
@JsonExtensionElement
@JsonTypeInfo ( use =JsonTypeInfo.Id.CUSTOM, property = XmlTypeIdResolver.TYPE_PROPERTY_NAME)
@JsonTypeIdResolver (XmlTypeIdResolver.class)
@XmlType ( name = "Family", propOrder = {"persistentId", "alternateIds", "bibliographicCitation", "parent1", "parent2", "children" } )
public class Family extends GenealogicalResource implements PersistentIdentifiable, BibliographicResource {

  private URI persistentId;
  private List<AlternateId> alternateIds;
  private String bibliographicCitation;
  private ResourceReference parent1;
  private ResourceReference parent2;
  private List<ResourceReference> children;

  /**
   * A long-term, persistent, globally unique identifier for this family.
   *
   * @return A long-term, persistent, globally unique identifier for this family.
   */
  @XmlSchemaType (name = "anyURI", namespace = XMLConstants.W3C_XML_SCHEMA_NS_URI)
  public URI getPersistentId() {
    return persistentId;
  }

  /**
   * A long-term, persistent, globally unique identifier for this family.
   *
   * @param persistentId A long-term, persistent, globally unique identifier for this family.
   */
  public void setPersistentId(URI persistentId) {
    this.persistentId = persistentId;
  }

  /**
   * The list of alternate ids of the family.
   *
   * @return The list of alternate ids of the family.
   */
  @XmlElement (name="alternateId")
  @JsonProperty ("alternateIds")
  @JsonName ("alternateIds")
  public List<AlternateId> getAlternateIds() {
    return alternateIds;
  }

  /**
   * The list of alternate ids of the family.
   *
   * @param alternateIds The list of alternate ids of the family.
   */
  @JsonProperty ("alternateIds")
  public void setAlternateIds(List<AlternateId> alternateIds) {
    this.alternateIds = alternateIds;
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
   * A reference to a parent in the family. The name "parent1" is used only to distinguish it from
   * the other parent in this family and does not imply role.
   *
   * @return A reference to a parent in the family. The name "parent1" is used only to distinguish it from
   * the other parent in this family and does not imply role.
   */
  @RDFRange (Person.class)
  @RDFSubPropertyOf ( CommonNamespaces.DUBLIN_CORE_NAMESPACE + "hasPart")
  public ResourceReference getParent1() {
    return parent1;
  }

  /**
   * A reference to a parent in the family. The name "parent1" is used only to distinguish it from
   * the other parent in this family and does not imply role.
   *
   * @param parent1 A reference to a parent in the family. The name "parent1" is used only to distinguish it from
   * the other parent in this family and does not imply role.
   */
  public void setParent1(ResourceReference parent1) {
    this.parent1 = parent1;
  }

  /**
   * A reference to a parent in the family. The name "parent2" is used only to distinguish it from
   * the other parent in this family and does not imply role.
   *
   * @return A reference to a parent in the family. The name "parent2" is used only to distinguish it from
   * the other parent in this family and does not imply role.
   */
  @RDFRange (Person.class)
  @RDFSubPropertyOf ( CommonNamespaces.DUBLIN_CORE_NAMESPACE + "hasPart")
  public ResourceReference getParent2() {
    return parent2;
  }

  /**
   * A reference to a parent in the family. The name "parent2" is used only to distinguish it from
   * the other parent in this family and does not imply role.
   *
   * @param parent2 A reference to a parent in the family. The name "parent2" is used only to distinguish it from
   * the other parent in this family and does not imply role.
   */
  public void setParent2(ResourceReference parent2) {
    this.parent2 = parent2;
  }

  /**
   * The children of the family.
   *
   * @return The children the family.
   */
  @XmlElement (name="child")
  @JsonProperty ("children")
  @JsonName ("children")
  @RDFRange (Person.class)
  @RDFSubPropertyOf ( CommonNamespaces.DUBLIN_CORE_NAMESPACE + "hasPart")
  @SuppressWarnings("gedcomx:non_plural_json_name")
  public List<ResourceReference> getChildren() {
    return children;
  }

  /**
   * The children of the family.
   *
   * @param children The children of the family.
   */
  public void setChildren(List<ResourceReference> children) {
    this.children = children;
  }
}

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
import org.gedcomx.common.GenealogicalEntity;
import org.gedcomx.common.ResourceReference;
import org.gedcomx.rt.*;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.List;

/**
 * The pedigree node is designed to model a node in a traditional family-based pedigree. The pedigree node
 * can be used to model a family, providing a place to put attributes on a family, a place to maintain
 * child order, and an optimization mechanism for displaying pedigrees to a user.
 *
 * @author Ryan Heaton
 */
@XmlRootElement
@JsonExtensionElement
@JsonTypeInfo ( use =JsonTypeInfo.Id.CUSTOM, property = XmlTypeIdResolver.TYPE_PROPERTY_NAME)
@JsonTypeIdResolver (XmlTypeIdResolver.class)
@XmlType ( name = "PedigreeNode", propOrder = {"coupleRelationship", "childRelationships"} )
public class PedigreeNode extends GenealogicalEntity {

  private ResourceReference coupleRelationship;
  private List<ResourceReference> childRelationships;

  /**
   * A reference to the couple relationship between the parents of the node.
   *
   * @return A reference to the couple relationship between the parents of the node.
   */
  @RDFRange (Relationship.class)
  @RDFSubPropertyOf ( CommonNamespaces.DUBLIN_CORE_NAMESPACE + "hasPart")
  public ResourceReference getCoupleRelationship() {
    return coupleRelationship;
  }

  /**
   * A reference to the couple relationship between the parents of the node.
   *
   * @param coupleRelationship A reference to the couple relationship between the parents of the node.
   */
  public void setCoupleRelationship(ResourceReference coupleRelationship) {
    this.coupleRelationship = coupleRelationship;
  }

  /**
   * The ordered list of relationships between the children and the parents.
   *
   * @return The ordered list of relationships between the children and the parents.
   */
  @XmlElement (name="childRelationship")
  @JsonProperty ("childRelationships")
  @JsonName ("childRelationships")
  public List<ResourceReference> getChildRelationships() {
    return childRelationships;
  }

  /**
   * The ordered list of relationships between the children and the parents.
   *
   * @param childRelationships The ordered list of relationships between the children and the parents.
   */
  public void setChildRelationships(List<ResourceReference> childRelationships) {
    this.childRelationships = childRelationships;
  }
}

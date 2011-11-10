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
package org.gedcomx.conclusion.www;

import org.codehaus.jackson.annotate.JsonTypeInfo;
import org.codehaus.jackson.map.annotate.JsonTypeIdResolver;
import org.gedcomx.common.ResourceSet;
import org.gedcomx.conclusion.Relationship;
import org.gedcomx.rt.JsonExtensionElement;
import org.gedcomx.rt.XmlTypeIdResolver;
import org.gedcomx.rs.Link;

import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;

/**
 * A representation of a relationship for the WWW.
 * 
 * @author Ryan Heaton
 */
@XmlRootElement(name = "relationship")
@JsonExtensionElement
@JsonTypeInfo ( use =JsonTypeInfo.Id.CUSTOM, property = XmlTypeIdResolver.TYPE_PROPERTY_NAME)
@JsonTypeIdResolver (XmlTypeIdResolver.class)
@XmlType ( name = "RelationshipWWW", propOrder = {"relationship", "metadata"})
@XmlSeeAlso({Link.class})
public final class RelationshipWWW {

  private Relationship relationship;
  private ResourceSet metadata;

  /**
   * The relationship.
   *
   * @return The relationship.
   */
  @XmlElementRef
  public Relationship getRelationship() {
    return relationship;
  }

  /**
   * The relationship.
   *
   * @param relationship The relationship.
   */
  public void setRelationship(Relationship relationship) {
    this.relationship = relationship;
  }

  /**
   * Metadata associated with the relationship.
   *
   * @return Metadata associated with the relationship.
   */
  public ResourceSet getMetadata() {
    return metadata;
  }

  /**
   * Metadata associated with the relationship.
   *
   * @param metadata Metadata associated with the relationship.
   */
  public void setMetadata(ResourceSet metadata) {
    this.metadata = metadata;
  }
}

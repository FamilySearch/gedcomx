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
import org.gedcomx.conclusion.PedigreeNode;
import org.gedcomx.rt.JsonExtensionElement;
import org.gedcomx.rt.XmlTypeIdResolver;
import org.gedcomx.www.Link;

import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;

/**
 * A representation of a pedigree node for the WWW.
 * 
 * @author Ryan Heaton
 */
@XmlRootElement(name = "pedigreeNode")
@JsonExtensionElement
@JsonTypeInfo ( use =JsonTypeInfo.Id.CUSTOM, property = XmlTypeIdResolver.TYPE_PROPERTY_NAME)
@JsonTypeIdResolver (XmlTypeIdResolver.class)
@XmlType ( name = "PedigreeNodeWWW", propOrder = {"pedigreeNode", "metadata"})
@XmlSeeAlso({Link.class})
public final class PedigreeNodeWWW {

  private PedigreeNode pedigreeNode;
  private ResourceSet metadata;

  /**
   * The pedigree node.
   *
   * @return The pedigree node.
   */
  @XmlElementRef
  public PedigreeNode getPedigreeNode() {
    return pedigreeNode;
  }

  /**
   * The pedigree node.
   *
   * @param pedigreeNode The pedigree node.
   */
  public void setPedigreeNode(PedigreeNode pedigreeNode) {
    this.pedigreeNode = pedigreeNode;
  }

  /**
   * Metadata associated with the pedigree node.
   *
   * @return Metadata associated with the pedigree node.
   */
  public ResourceSet getMetadata() {
    return metadata;
  }

  /**
   * Metadata associated with the pedigree node.
   *
   * @param metadata Metadata associated with the pedigree node.
   */
  public void setMetadata(ResourceSet metadata) {
    this.metadata = metadata;
  }
}

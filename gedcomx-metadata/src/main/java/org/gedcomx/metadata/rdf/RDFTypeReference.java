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
package org.gedcomx.metadata.rdf;

import org.codehaus.enunciate.XmlQNameEnumUtil;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.gedcomx.rt.CommonNamespaces;
import org.gedcomx.types.ResourceType;

import javax.xml.XMLConstants;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlTransient;
import java.net.URI;

/**
 * An element representing an RDF type reference. When specifying types in RDF, you have to use
 * the rdf:resource attribute to distinguish between a reference to the type and the actual type. See
 * <a href="http://www.w3.org/TR/rdf-primer/#example12">RDF Primer, Example 12</a>.
 *
 * @link http://www.w3.org/TR/rdf-primer/#example12
 * @author Ryan Heaton
 */
public final class RDFTypeReference {

  private URI type;

  /**
   * The type.
   *
   * @return The type.
   */
  @XmlAttribute(namespace = CommonNamespaces.RDF_NAMESPACE, name = "resource")
  @XmlSchemaType (name = "anyURI", namespace = XMLConstants.W3C_XML_SCHEMA_NS_URI)
  public URI getType() {
    return type;
  }

  /**
   * The type.
   *
   * @param type The type.
   */
  public void setType(URI type) {
    this.type = type;
  }

  /**
   * Get the type from an enumeration of known types, or null if unknown.
   *
   * @return The type from an enumeration of known types, or null if unknown.
   */
  @XmlTransient
  @JsonIgnore
  public ResourceType getKnownType() {
    return XmlQNameEnumUtil.fromURI(getType(), ResourceType.class);
  }

  /**
   * Set the type from a known enumeration of Dublin Core types.
   *
   * @param knownType The type.
   */
  @JsonIgnore
  public void setKnownType(ResourceType knownType) {
    setType(XmlQNameEnumUtil.toURI(knownType));
  }
}

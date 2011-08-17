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
package org.gedcomx.common;

import org.codehaus.enunciate.XmlQNameEnumUtil;
import org.codehaus.enunciate.qname.XmlQNameEnumRef;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.gedcomx.rt.AnyAttributeDeserializer;
import org.gedcomx.rt.AnyAttributeSerializer;
import org.gedcomx.rt.AnyElementDeserializer;
import org.gedcomx.rt.AnyElementSerializer;
import org.gedcomx.types.ResourceFragmentParameter;
import org.gedcomx.types.ResourceType;
import org.gedcomx.types.TypesNamespaces;

import javax.xml.XMLConstants;
import javax.xml.bind.annotation.*;
import javax.xml.namespace.QName;
import java.net.URI;
import java.util.List;
import java.util.Map;

/**
 * A generic RDF-based reference to a resource.
 *
 * @author Ryan Heaton
 */
@XmlSeeAlso(ResourceFragmentParameter.class)
public final class ResourceReference {

  private String id;
  private URI type;
  private URI resource;
  private Map<QName, String> otherAttributes;
  private List<Object> otherElements;

  /**
   * The id of this resource reference.
   *
   * @return The id of this resource reference.
   */
  @XmlID
  @XmlAttribute( name = "ID", namespace = TypesNamespaces.RDF_NAMESPACE )
  public String getId() {
    return id;
  }

  /**
   * The id of this resource reference.
   *
   * @param id The id of this resource reference.
   */
  public void setId(String id) {
    this.id = id;
  }

  /**
   * The type of the resource reference.
   *
   * @return The type of the resource reference.
   */
  @XmlAttribute
  @XmlQNameEnumRef (ResourceType.class)
  @XmlSchemaType (name = "anyURI", namespace = XMLConstants.W3C_XML_SCHEMA_NS_URI)
  public URI getType() {
    return type;
  }

  /**
   * The type of the source reference.
   *
   * @param type The type of the source reference.
   */
  public void setType(URI type) {
    this.type = type;
  }

  /**
   * The URI to the resource. For more information, see <a href="http://www.w3.org/TR/webarch/#identification">Architecture of the World
   * Wide Web, Volume One, Section 2</a>
   *
   * @link http://www.w3.org/TR/webarch/#identification
   * @return The URI to the resource.
   */
  @XmlAttribute (namespace=TypesNamespaces.RDF_NAMESPACE)
  @XmlSchemaType (name = "anyURI", namespace = XMLConstants.W3C_XML_SCHEMA_NS_URI)
  public URI getResource() {
    return resource;
  }

  /**
   * The URI to the resource. For more information, see <a href="http://www.w3.org/TR/webarch/#identification">Architecture of the World
   * Wide Web, Volume One, Section 2</a>
   *
   * @link http://www.w3.org/TR/webarch/#identification
   * @param resource The URI to the resource.
   */
  public void setResource(URI resource) {
    this.resource = resource;
  }

  /**
   * Custom attributes applicable to this resource reference.
   *
   * @return Custom attributes applicable to this resource reference.
   */
  @XmlAnyAttribute
  @JsonSerialize (using = AnyAttributeSerializer.class)
  public Map<QName, String> getOtherAttributes() {
    return otherAttributes;
  }

  /**
   * Custom attributes applicable to this resource reference.
   *
   * @param otherAttributes Custom attributes applicable to this resource reference.
   */
  @JsonDeserialize (using = AnyAttributeDeserializer.class)
  public void setOtherAttributes(Map<QName, String> otherAttributes) {
    this.otherAttributes = otherAttributes;
  }

  /**
   * Custom attributes applicable to this resource reference.
   *
   * @return Custom attributes applicable to this resource reference.
   */
  @XmlAnyElement ( lax = true )
  @JsonSerialize ( using = AnyElementSerializer.class )
  public List<Object> getOtherElements() {
    return otherElements;
  }

  /**
   * Custom attributes applicable to this resource reference.
   *
   * @param otherElements Custom attributes applicable to this resource reference.
   */
  @JsonDeserialize( using = AnyElementDeserializer.class )
  public void setOtherElements(List<Object> otherElements) {
    this.otherElements = otherElements;
  }

  /**
   * The enum referencing the known type of the resource being referenced, or {@link org.gedcomx.types.ResourceType#other} if not known.
   *
   * @return The enum referencing the known type of the source reference, or {@link org.gedcomx.types.ResourceType#other} if not known.
   */
  @XmlTransient
  @JsonIgnore
  public ResourceType getKnownType() {
    return XmlQNameEnumUtil.fromURI(getType(), ResourceType.class);
  }

  /**
   * Set the type of this source reference from an enumeration of known source reference types.
   *
   * @param knownType The source reference type.
   */
  @JsonIgnore
  public void setKnownType(ResourceType knownType) {
    setType(XmlQNameEnumUtil.toURI(knownType));
  }
}

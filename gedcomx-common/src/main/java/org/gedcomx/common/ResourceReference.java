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
import org.codehaus.jackson.annotate.JsonTypeInfo;
import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.codehaus.jackson.map.annotate.JsonTypeIdResolver;
import org.gedcomx.rt.*;
import org.gedcomx.types.ResourceFragmentParameter;
import org.gedcomx.types.ResourceType;
import org.gedcomx.types.Typed;

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
@XmlType ( name = "ResourceReference" )
@JsonTypeInfo ( use = JsonTypeInfo.Id.CUSTOM, property = "@type")
@JsonTypeIdResolver ( XmlTypeIdResolver.class )
@XmlSeeAlso(ResourceFragmentParameter.class)
public class ResourceReference implements Typed {

  private String id;
  private URI type;
  private URI resource;
  private Map<QName, String> extensionAttributes;
  private List<Object> extensionElements;

  /**
   * The id of this resource reference. Note the distinction between this id and the id of the
   * resource being referenced.
   *
   * @return The id of this resource reference. Note the distinction between this id and the id of the
   * resource being referenced.
   */
  @XmlID
  @XmlAttribute( name = "ID", namespace = CommonNamespaces.RDF_NAMESPACE )
  public String getId() {
    return id;
  }

  /**
   * The id of this resource reference. Note the distinction between this id and the id of the
   * resource being referenced.
   *
   * @param id The id of this resource reference. Note the distinction between this id and the id of the
   * resource being referenced.
   */
  public void setId(String id) {
    this.id = id;
  }

  /**
   * The type of the resource being referenced.
   *
   * @return The type of the resource being referenced.
   */
  @XmlAttribute (namespace = CommonNamespaces.GEDCOMX_COMMON_NAMESPACE)
  @XmlQNameEnumRef (ResourceType.class)
  @XmlSchemaType (name = "anyURI", namespace = XMLConstants.W3C_XML_SCHEMA_NS_URI)
  public URI getType() {
    return type;
  }

  /**
   * The type of the resource being referenced.
   *
   * @param type The type of the resource being referenced.
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
  @XmlAttribute (namespace= CommonNamespaces.RDF_NAMESPACE)
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
  @JsonSerialize (using = AnyAttributeSerializer.class, include = JsonSerialize.Inclusion.NON_NULL)
  public Map<QName, String> getExtensionAttributes() {
    return extensionAttributes;
  }

  /**
   * Custom attributes applicable to this resource reference.
   *
   * @param extensionAttributes Custom attributes applicable to this resource reference.
   */
  @JsonDeserialize (using = AnyAttributeDeserializer.class)
  public void setExtensionAttributes(Map<QName, String> extensionAttributes) {
    this.extensionAttributes = extensionAttributes;
  }

  /**
   * Custom attributes applicable to this resource reference.
   *
   * @return Custom attributes applicable to this resource reference.
   */
  @XmlAnyElement ( lax = true )
  @JsonSerialize ( using = AnyElementSerializer.class, include = JsonSerialize.Inclusion.NON_NULL )
  public List<Object> getExtensionElements() {
    return extensionElements;
  }

  /**
   * Custom attributes applicable to this resource reference.
   *
   * @param extensionElements Custom attributes applicable to this resource reference.
   */
  @JsonDeserialize( using = AnyElementDeserializer.class )
  public void setExtensionElements(List<Object> extensionElements) {
    this.extensionElements = extensionElements;
  }

  /**
   * The enum referencing the known type of the resource being referenced, or {@link org.gedcomx.types.ResourceType#OTHER} if not known.
   *
   * @return The enum referencing the known type of the source reference, or {@link org.gedcomx.types.ResourceType#OTHER} if not known.
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

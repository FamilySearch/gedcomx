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

import org.codehaus.enunciate.doc.DocumentationExample;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonTypeInfo;
import org.codehaus.jackson.map.annotate.JsonTypeIdResolver;
import org.gedcomx.rt.CommonModels;
import org.gedcomx.rt.SupportsExtensionAttributes;
import org.gedcomx.rt.SupportsExtensionElements;
import org.gedcomx.rt.XmlTypeIdResolver;
import org.gedcomx.types.AlternateIdType;
import org.gedcomx.types.ResourceFragmentParameter;
import org.gedcomx.types.ResourceType;
import org.gedcomx.types.TypeReference;

import javax.xml.XMLConstants;
import javax.xml.bind.annotation.*;
import javax.xml.namespace.QName;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A generic RDF-based reference to a resource.
 *
 * @author Ryan Heaton
 */
@XmlType ( name = "ResourceReference", namespace = CommonModels.RDF_NAMESPACE )
@JsonTypeInfo ( use = JsonTypeInfo.Id.CUSTOM, property = XmlTypeIdResolver.TYPE_PROPERTY_NAME)
@JsonTypeIdResolver ( XmlTypeIdResolver.class )
@XmlSeeAlso(ResourceFragmentParameter.class)
public class ResourceReference implements SupportsExtensionAttributes, SupportsExtensionElements {

  private String id;
  @XmlElement (namespace = CommonModels.RDF_NAMESPACE)
  @JsonProperty
  private TypeReference<ResourceType> type;
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
  @XmlAttribute( name = "ID", namespace = CommonModels.RDF_NAMESPACE )
  @DocumentationExample(exclude = true)
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
  @XmlTransient
  @JsonIgnore
  public URI getType() {
    return this.type == null ? null : this.type.getType();
  }

  /**
   * The type of the resource being referenced.
   *
   * @param type The type of the resource being referenced.
   */
  @JsonIgnore
  public void setType(URI type) {
    this.type = type == null ? null : new TypeReference<ResourceType>(type);
  }

  /**
   * The enum referencing the known type of the resource being referenced, or {@link org.gedcomx.types.ResourceType#OTHER} if not known.
   *
   * @return The enum referencing the known type of the source reference, or {@link org.gedcomx.types.ResourceType#OTHER} if not known.
   */
  @XmlTransient
  @JsonIgnore
  public ResourceType getKnownType() {
    return this.type == null ? null : ResourceType.fromQNameURI(this.type.getType());
  }

  /**
   * Set the type of this reference from an enumeration of known source reference types.
   *
   * @param knownType The reference type.
   */
  @JsonIgnore
  public void setKnownType(ResourceType knownType) {
    this.type = knownType == null ? null : new TypeReference<ResourceType>(knownType);
  }

  /**
   * The URI to the resource. For more information, see <a href="http://www.w3.org/TR/webarch/#identification">Architecture of the World
   * Wide Web, Volume One, Section 2</a>
   *
   * @link http://www.w3.org/TR/webarch/#identification
   * @return The URI to the resource.
   */
  @XmlAttribute (namespace= CommonModels.RDF_NAMESPACE)
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
  @JsonIgnore
  public Map<QName, String> getExtensionAttributes() {
    return extensionAttributes;
  }

  /**
   * Custom attributes applicable to this resource reference.
   *
   * @param extensionAttributes Custom attributes applicable to this resource reference.
   */
  @JsonIgnore
  public void setExtensionAttributes(Map<QName, String> extensionAttributes) {
    this.extensionAttributes = extensionAttributes;
  }

  /**
   * Add a custom extension attribute.
   *
   * @param qname The qname of the attribute.
   * @param value The value of the attribute.
   */
  public void addExtensionAttribute(QName qname, String value) {
    if (this.extensionAttributes == null) {
      this.extensionAttributes = new HashMap<QName, String>();
    }

    this.extensionAttributes.put(qname, value);
  }

  /**
   * Convenience method for getting the attribution for this resource reference.
   *
   * @return The attribution for this resource reference.
   */
  public Attribution findAttribution() {
    return findExtensionOfType(Attribution.class);
  }

  /**
   * Convenience method for adding the attribution for this resource reference.
   *
   * @param attribution The attribution.
   */
  public void addAttribution(Attribution attribution) {
    addExtensionElement(attribution);
  }

  /**
   * Custom attributes applicable to this resource reference.
   *
   * @return Custom attributes applicable to this resource reference.
   */
  @XmlAnyElement ( lax = true )
  @JsonIgnore
  public List<Object> getExtensionElements() {
    return extensionElements;
  }

  /**
   * Custom attributes applicable to this resource reference.
   *
   * @param extensionElements Custom attributes applicable to this resource reference.
   */
  @JsonIgnore
  public void setExtensionElements(List<Object> extensionElements) {
    this.extensionElements = extensionElements;
  }

  /**
   * Add an extension element.
   *
   * @param element The extension element to add.
   */
  public void addExtensionElement(Object element) {
    if (this.extensionElements == null) {
      this.extensionElements = new ArrayList<Object>();
    }

    this.extensionElements.add(element);
  }

  /**
   * Finds the first extension of a specified type.
   *
   * @param clazz The type.
   * @return The extension, or null if none found.
   */
  @SuppressWarnings ( {"unchecked"} )
  public <E> E findExtensionOfType(Class<E> clazz) {
    if (this.extensionElements != null) {
      for (Object extension : extensionElements) {
        if (clazz.isInstance(extension)) {
          return (E) extension;
        }
      }
    }

    return null;
  }

  /**
   * Find the extensions of a specified type.
   *
   * @param clazz The type.
   * @return The extensions, possibly empty but not null.
   */
  @SuppressWarnings ( {"unchecked"} )
  public <E> List<E> findExtensionsOfType(Class<E> clazz) {
    List<E> ext = new ArrayList<E>();
    if (this.extensionElements != null) {
      for (Object extension : extensionElements) {
        if (clazz.isInstance(extension)) {
          ext.add((E) extension);
        }
      }
    }

    return ext;
  }

  /**
   * Provide a simple toString() method.
   */
  @Override
  public String toString() {
    return (resource == null) ? "" : resource.toString();
  }
}

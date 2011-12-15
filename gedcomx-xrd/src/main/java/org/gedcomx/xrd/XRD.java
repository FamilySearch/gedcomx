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

package org.gedcomx.xrd;

import org.codehaus.enunciate.json.JsonName;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonTypeInfo;
import org.codehaus.jackson.map.annotate.JsonTypeIdResolver;
import org.gedcomx.rt.SupportsExtensionAttributes;
import org.gedcomx.rt.SupportsExtensionElements;
import org.gedcomx.rt.XmlTypeIdResolver;

import javax.xml.XMLConstants;
import javax.xml.bind.annotation.*;
import javax.xml.namespace.QName;
import java.lang.String;
import java.net.URI;
import java.util.*;


/**
 * The <XRD> element encapsulates the entire resource descriptor. None of the properties
 * are mandatory.
 *
 * See http://docs.oasis-open.org/xri/xrd/v1.0/xrd-1.0.html#element.xrd
 *
 * @author Mike Gardiner, Ryan Heaton
 */
@XmlRootElement (
  name = "XRD"
)
@XmlType (
  name = "XRD",
  propOrder = { "expires", "subject", "aliases", "properties", "links", "extensionElements" }
)
@JsonTypeInfo ( use =JsonTypeInfo.Id.CUSTOM, property = XmlTypeIdResolver.TYPE_PROPERTY_NAME)
@JsonTypeIdResolver ( XmlTypeIdResolver.class )
@SuppressWarnings("rdf-incompatible-ns")
public final class XRD implements SupportsExtensionAttributes, SupportsExtensionElements {

  private Date expires;
  private URI subject;
  private List<URI> aliases;
  private List<Property> properties;
  private List<Link> links;
  private Map<QName, java.lang.String> extensionAttributes;
  private List<Object> extensionElements;

    /**
     * Specifies when this document expires. See Section 2.2, “Element <Expires>”.
     *
     * @return Date when the document expires
     */
  @XmlElement ( name = "Expires" )
  public Date getExpires() {
    return expires;
  }

    /**
     * Specifies a Date when the document expires.
     *
     * @param expires - Date when the document expires
     */
  public void setExpires(Date expires) {
    this.expires = expires;
  }

    /**
     * Provides the identifier of the resource described by this XRD. See Section
     * 2.3, “Element <Subject>”.
     *
     * @return A valid URI indicating the Subject
     */
  @XmlElement ( name = "Subject" )
  @XmlSchemaType( name = "anyURI", namespace = XMLConstants.W3C_XML_SCHEMA_NS_URI )
  public URI getSubject() {
    return subject;
  }

    /**
     * Provides the identifier of the resource described by this XRD. See Section
     * 2.3, “Element <Subject>”
     *
     * @param subject - A valid URI indicating the subject.
     */
  public void setSubject(URI subject) {
    this.subject = subject;
  }

    /**
     * Provides an additional identifier for the resource described by this XRD.
     * See Section 2.4, “Element <Alias>”.
     *
     * @return Zero more more Alias elements
     */
  @XmlElement ( name = "Alias" )
  @SuppressWarnings("gedcomx:plural_xml_name")
  @XmlSchemaType( name = "anyURI", namespace = XMLConstants.W3C_XML_SCHEMA_NS_URI )
  public List<URI> getAliases() {
    return aliases;
  }

    /**
     * Provides an additional identifier for the resource described by this XRD.
     * See Section 2.4, “Element <Alias>”.
     *
     * @param aliases - Zero more more Aliases
     */
  public void setAliases(List<URI> aliases) {
    this.aliases = aliases;
  }

    /**
     * Declares a property of the resource described by this XRD. See Section 2.5,
     * “Element <Property>”.
     *
     * @return Zero more more Property elements.
     */
  @XmlElement ( name = "Property" )
  @JsonName ("properties")
  @JsonProperty ("properties")
  public List<Property> getProperties() {
    return properties;
  }

    /**
     * Declares a property of the resource described by this XRD. See Section 2.5,
     * “Element <Property>”
     *
     * @param properties - Zero or more Property elements.
     */
  @JsonProperty ("properties")
  public void setProperties(List<Property> properties) {
    this.properties = properties;
  }

    /**
     * Identifies another resource which is related to the resource described by
     * this XRD, and describes the semantics of that relation. See Section 2.6,
     * “Element <Link>”.
     *
     * @return Zero more more Link elements
     */
  @XmlElement ( name = "Link" )
  @JsonName ("links")
  @JsonProperty ("links")
  public List<Link> getLinks() {
    return links;
  }

    /**
     * Identifies another resource which is related to the resource described by
     * this XRD, and describes the semantics of that relation. See Section 2.6,
     * “Element <Link>”.
     *
     * @param links - Zero more more Link elements
     */
  @JsonProperty ("links")
  public void setLinks(List<Link> links) {
    this.links = links;
  }

  /**
   * Custom attributes applicable as part of this metadata.
   *
   * @return Custom attributes applicable as part of this metadata.
   */
  @XmlAnyAttribute
  @JsonIgnore
  public Map<QName, java.lang.String> getExtensionAttributes() {
    return extensionAttributes;
  }

  /**
   * Custom attributes applicable as part of this metadata.
   *
   * @param extensionAttributes Custom attributes applicable as part of this metadata.
   */
  @JsonIgnore
  public void setExtensionAttributes(Map<QName, java.lang.String> extensionAttributes) {
    this.extensionAttributes = extensionAttributes;
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
   * Custom elements applicable as part of this metadata.
   *
   * @return Custom elements applicable as part of this metadata.
   */
  @XmlAnyElement ( lax = true )
  @JsonIgnore
  public List<Object> getExtensionElements() {
    return extensionElements;
  }

  /**
   * Custom elements applicable as part of this metadata.
   *
   * @param extensionElements Custom elements applicable as part of this metadata.
   */
  @JsonIgnore
  public void setExtensionElements(List<Object> extensionElements) {
    this.extensionElements = extensionElements;
  }

  /**
   * Add a custom extension attribute.
   *
   * @param qname The qname of the attribute.
   * @param value The value of the attribute.
   */
  public void addExtensionAttribute(QName qname, java.lang.String value) {
    if (this.extensionAttributes == null) {
      this.extensionAttributes = new HashMap<QName, String>();
    }

    this.extensionAttributes.put(qname, value);
  }
}

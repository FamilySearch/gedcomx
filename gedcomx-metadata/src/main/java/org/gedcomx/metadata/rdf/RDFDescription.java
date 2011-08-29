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

import org.codehaus.jackson.annotate.JsonTypeInfo;
import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.codehaus.jackson.map.annotate.JsonTypeIdResolver;
import org.gedcomx.rt.*;
import org.gedcomx.metadata.dc.DublinCoreDescription;

import javax.xml.XMLConstants;
import javax.xml.bind.annotation.*;
import javax.xml.namespace.QName;
import java.net.URI;
import java.util.List;
import java.util.Map;

/**
 * An RDF description of a resource.
 *
 * @author Ryan Heaton
 */
@JsonTypeInfo ( use =JsonTypeInfo.Id.CUSTOM, property = "@type")
@JsonTypeIdResolver (XmlTypeIdResolver.class)
@XmlSeeAlso( DublinCoreDescription.class )
public class RDFDescription {

  private String id; 
  private URI about;
  private Map<QName, String> extensionAttributes;
  private List<Object> extensionElements;

  /**
   * The id of this piece of metadata.
   *
   * @return The id of this piece of metadata.
   */
  @XmlAttribute( name = "ID" )
  @XmlID
  public String getId() {
    return id;
  }

  /**
   * The id of this piece of metadata.
   *
   * @param id The id of this piece of metadata.
   */
  public void setId(String id) {
    this.id = id;
  }

  /**
   * URI to the resource that this metadata is describing.
   *
   * @return URI to the resource that this metadata is describing.
   */
  @XmlAttribute
  @XmlSchemaType(name = "anyURI", namespace = XMLConstants.W3C_XML_SCHEMA_NS_URI)
  public URI getAbout() {
    return about;
  }

  /**
   * URI to the resource that this metadata is describing.
   *
   * @param about URI to the resource that this metadata is describing.
   */
  public void setAbout(URI about) {
    this.about = about;
  }

  /**
   * Custom attributes applicable as part of this metadata.
   *
   * @return Custom attributes applicable as part of this metadata.
   */
  @XmlAnyAttribute
  @JsonSerialize (using = AnyAttributeSerializer.class)
  public Map<QName, String> getExtensionAttributes() {
    return extensionAttributes;
  }

  /**
   * Custom attributes applicable as part of this metadata.
   *
   * @param extensionAttributes Custom attributes applicable as part of this metadata.
   */
  @JsonDeserialize (using = AnyAttributeDeserializer.class)
  public void setExtensionAttributes(Map<QName, String> extensionAttributes) {
    this.extensionAttributes = extensionAttributes;
  }

  /**
   * Custom elements applicable as part of this metadata.
   *
   * @return Custom elements applicable as part of this metadata.
   */
  @XmlAnyElement ( lax = true )
  @JsonSerialize ( using = AnyElementSerializer.class )
  public List<Object> getExtensionElements() {
    return extensionElements;
  }

  /**
   * Custom elements applicable as part of this metadata.
   *
   * @param extensionElements Custom elements applicable as part of this metadata.
   */
  @JsonDeserialize( using = AnyElementDeserializer.class )
  public void setExtensionElements(List<Object> extensionElements) {
    this.extensionElements = extensionElements;
  }
}

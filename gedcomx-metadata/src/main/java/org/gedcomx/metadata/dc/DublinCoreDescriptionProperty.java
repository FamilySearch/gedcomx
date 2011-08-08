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
package org.gedcomx.metadata.dc;

import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.gedcomx.metadata.MetadataNamespaces;
import org.gedcomx.rt.AnyAttributeDeserializer;
import org.gedcomx.rt.AnyAttributeSerializer;

import javax.xml.XMLConstants;
import javax.xml.bind.annotation.*;
import javax.xml.namespace.QName;
import java.net.URI;
import java.util.Map;

/**
 * A Dublin Core metadata property in the form of a string.
 *
 * @author Ryan Heaton
 */
public final class DublinCoreDescriptionProperty {

  private String id;
  private String lang;
  private String value;
  private URI valueRef;
  private Map<QName, String> otherAttributes;

  /**
   * The id of the property. Used so that other properties can refer to it and possibly refine it's value.
   *
   * @return The id of the property. Used so that other properties can refer to it and possibly refine it's value.
   */
  @XmlAttribute ( name = "ID", namespace = MetadataNamespaces.RDF_NAMESPACE )
  @XmlID
  public String getId() {
    return id;
  }

  /**
   * The id of the property. Used so that other properties can refer to it and possibly refine it's value.
   *
   * @param id The id of the property. Used so that other properties can refer to it and possibly refine it's value.
   */
  public void setId(String id) {
    this.id = id;
  }

  /**
   * The language of the value of the property. See <a href="http://www.w3.org/International/articles/language-tags/>http://www.w3.org/International/articles/language-tags/</a>
   *
   * @return The language of the value of the property.
   */
  @XmlAttribute( namespace = XMLConstants.XML_NS_URI )
  public String getLang() {
    return lang;
  }

  /**
   * The language of the value of the property. See <a href="http://www.w3.org/International/articles/language-tags/>http://www.w3.org/International/articles/language-tags/</a>
   *
   * @param lang The language of the value of the property.
   */
  public void setLang(String lang) {
    this.lang = lang;
  }

  /**
   * The value of the property.
   *
   * @return The value of the property.
   */
  @XmlValue
  public String getValue() {
    return value;
  }

  /**
   * The value of the property.
   *
   * @param value The value of the property.
   */
  public void setValue(String value) {
    this.value = value;
  }

  /**
   * The URI reference to the value. To be used, for example, if the value is structured data.
   * If a {@link #getValue() value} is assigned as well as a value reference, the value is to
   * be treated as a string representation of the resource being referenced.
   *
   * @return The URI reference to the value. To be used, for example, if the value is structured data.
   */
  @XmlAttribute( name = "resource", namespace = MetadataNamespaces.RDF_NAMESPACE )
  @XmlSchemaType (name = "anyURI", namespace = XMLConstants.W3C_XML_SCHEMA_NS_URI)
  public URI getValueRef() {
    return valueRef;
  }

  /**
   * The URI reference to the value. To be used, for example, if the value is structured data.
   * If a {@link #getValue() value} is assigned as well as a value reference, the value is to
   * be treated as a string representation of the resource being referenced.
   *
   * @param valueRef The URI reference to the value. To be used, for example, if the value is structured data.
   */
  public void setValueRef(URI valueRef) {
    this.valueRef = valueRef;
  }

  /**
   * Attribute extensions to the property.
   *
   * @return Attribute extensions to the property.
   */
  @XmlAnyAttribute
  @JsonSerialize (using = AnyAttributeSerializer.class)
  public Map<QName, String> getOtherAttributes() {
    return otherAttributes;
  }

  /**
   * Attribute extensions to the property.
   *
   * @param otherAttributes Attribute extensions to the property.
   */
  @JsonDeserialize (using = AnyAttributeDeserializer.class)
  public void setOtherAttributes(Map<QName, String> otherAttributes) {
    this.otherAttributes = otherAttributes;
  }
}

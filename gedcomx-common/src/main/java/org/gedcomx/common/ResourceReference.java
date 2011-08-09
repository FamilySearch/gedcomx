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

import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.gedcomx.rt.AnyAttributeDeserializer;
import org.gedcomx.rt.AnyAttributeSerializer;
import org.gedcomx.rt.AnyElementDeserializer;
import org.gedcomx.rt.AnyElementSerializer;

import javax.xml.XMLConstants;
import javax.xml.bind.annotation.*;
import javax.xml.namespace.QName;
import java.net.URI;
import java.util.List;
import java.util.Map;

/**
 * A reference to a resource.
 *
 * @author Ryan Heaton
 */
@XmlSeeAlso(SourceQualifier.class)
public final class ResourceReference {

  private URI href;
  private Map<QName, String> otherAttributes;
  private List<Object> otherElements;

  /**
   * The URI to the resource. For more information, see <a href="http://www.w3.org/TR/webarch/#identification">Architecture of the World
   * Wide Web, Volume One, Section 2</a>
   *
   * @link http://www.w3.org/TR/webarch/#identification
   * @return The URI to the resource.
   */
  @XmlAttribute (namespace="http://www.w3.org/1999/xlink")
  @XmlSchemaType (name = "anyURI", namespace = XMLConstants.W3C_XML_SCHEMA_NS_URI)
  public URI getHref() {
    return href;
  }

  /**
   * The URI to the resource. For more information, see <a href="http://www.w3.org/TR/webarch/#identification">Architecture of the World
   * Wide Web, Volume One, Section 2</a>
   *
   * @link http://www.w3.org/TR/webarch/#identification
   * @param href The URI to the resource.
   */
  public void setHref(URI href) {
    this.href = href;
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
}

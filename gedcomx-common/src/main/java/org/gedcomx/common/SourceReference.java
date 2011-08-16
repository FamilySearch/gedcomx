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
import org.codehaus.enunciate.json.JsonName;
import org.codehaus.enunciate.qname.XmlQNameEnumRef;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.gedcomx.types.SourceType;

import javax.xml.XMLConstants;
import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.net.URI;
import java.util.List;

/**
 * A reference to a source.
 *
 * @author Ryan Heaton
 */
@XmlJavaTypeAdapter( SourceReferenceAdapter.class )
@JsonSerialize(using = SourceReferenceSerializer.class)
@JsonDeserialize(using = SourceReferenceDeserializer.class)
public final class SourceReference {

  private String id;
  private URI href;
  private URI type;
  private List<SourceQualifier> qualifiers;
  private Extension extension;

  /**
   * The id of this source reference, unique to its entity.
   *
   * @return The id of this source reference, unique to its entity.
   */
  @XmlID
  @XmlAttribute
  public String getId() {
    return id;
  }

  /**
   * The id of this source reference, unique to its entity.
   *
   * @param id The id of this source reference, unique to its entity.
   */
  public void setId(String id) {
    this.id = id;
  }

  /**
   * The link to the source.
   *
   * @return The link to the source.
   */
  @XmlAttribute(namespace="http://www.w3.org/1999/xlink")
  @XmlSchemaType (name = "anyURI", namespace = XMLConstants.W3C_XML_SCHEMA_NS_URI)
  public URI getHref() {
    return href;
  }

  /**
   * The link to the source.
   *
   * @param href The link to the source.
   */
  public void setHref(URI href) {
    this.href = href;
  }

  /**
   * The type of the source reference.
   *
   * @return The type of the source reference.
   */
  @XmlAttribute
  @XmlQNameEnumRef (SourceType.class)
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
   * The enum referencing the known type of the source reference, or {@link org.gedcomx.types.SourceType#other} if not known.
   *
   * @return The enum referencing the known type of the source reference, or {@link org.gedcomx.types.SourceType#other} if not known.
   */
  @XmlTransient
  @JsonIgnore
  public SourceType getKnownType() {
    return XmlQNameEnumUtil.fromURI(getType(), SourceType.class);
  }

  /**
   * Set the type of this source reference from an enumeration of known source reference types.
   *
   * @param knownType The source reference type.
   */
  @JsonIgnore
  public void setKnownType(SourceType knownType) {
    setType(XmlQNameEnumUtil.toURI(knownType));
  }

  /**
   * The qualifiers for the source being referenced.
   *
   * @return The qualifiers for the source being referenced.
   */
  @XmlElement(name = "qualifier")
  @JsonName("qualifiers")
  @JsonProperty("qualifiers")
  public List<SourceQualifier> getQualifiers() {
    return qualifiers;
  }

  /**
   * The qualifiers for the source being referenced.
   *
   * @param qualifiers The qualifiers for the source being referenced.
   */
  @JsonProperty("qualifiers")
  public void setQualifiers(List<SourceQualifier> qualifiers) {
    this.qualifiers = qualifiers;
  }

  /**
   * The extension point for the source reference.
   *
   * @return The extension point for the source reference.
   */
  @XmlElement( name = "ext" )
  public Extension getExtension() {
    return extension;
  }

  /**
   * The extension point for the source reference.
   *
   * @param extension The extension point for the source reference.
   */
  public void setExtension(Extension extension) {
    this.extension = extension;
  }
}

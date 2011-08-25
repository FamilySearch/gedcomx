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
package org.gedcomx.conclusion;

import org.codehaus.enunciate.XmlQNameEnumUtil;
import org.codehaus.enunciate.qname.XmlQNameEnumRef;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.gedcomx.types.NamePartType;
import org.gedcomx.types.Typed;
import org.gedcomx.types.TypesNamespaces;

import javax.xml.XMLConstants;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;
import java.net.URI;

/**
 * A part of a name.
 *
 * @author Ryan Heaton
 */
@XmlType ( name = "NamePart" )
public final class NamePart implements Typed {

  private URI type;
  private String text;

  /**
   * The type of the name part.
   *
   * @return The type of the name part.
   */
  @XmlAttribute (namespace = TypesNamespaces.GEDCOMX_TYPES_NAMESPACE)
  @XmlQNameEnumRef (NamePartType.class)
  @XmlSchemaType (name = "anyURI", namespace = XMLConstants.W3C_XML_SCHEMA_NS_URI)
  public URI getType() {
    return type;
  }

  /**
   * The type of the name part.
   *
   * @param type The type of the name part.
   */
  public void setType(URI type) {
    this.type = type;
  }

  /**
   * The enum referencing the known name part type, or {@link org.gedcomx.types.NamePartType#other} if not known.
   *
   * @return The enum referencing the known name part type, or {@link org.gedcomx.types.NamePartType#other} if not known.
   */
  @XmlTransient
  @JsonIgnore
  public NamePartType getKnownType() {
    return XmlQNameEnumUtil.fromURI(getType(), NamePartType.class);
  }

  /**
   * Set the type of this name part from an enumeration of known name part types.
   *
   * @param knownType The name part type.
   */
  @JsonIgnore
  public void setKnownType(NamePartType knownType) {
    setType(XmlQNameEnumUtil.toURI(knownType));
  }

  /**
   * The text of the name part.
   *
   * @return The text of the name part.
   */
  public String getText() {
    return text;
  }

  /**
   * The text of the name part.
   *
   * @param text The text of the name part.
   */
  public void setText(String text) {
    this.text = text;
  }
}

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
package org.gedcomx.record;

import org.codehaus.enunciate.qname.XmlQNameEnumRef;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonTypeInfo;
import org.codehaus.jackson.map.annotate.JsonTypeIdResolver;
import org.gedcomx.rt.XmlTypeIdResolver;
import org.gedcomx.types.AgePartType;
import org.gedcomx.types.Typed;
import org.gedcomx.types.TypesNamespaces;

import javax.xml.XMLConstants;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;
import java.net.URI;

/**
 * A part of an age field.
 *
 * @author Ryan Heaton
 */
@JsonTypeInfo ( use =JsonTypeInfo.Id.CUSTOM, property = "@type")
@JsonTypeIdResolver (XmlTypeIdResolver.class)
@XmlType ( name = "AgePart" )
public class AgePart extends Field implements Typed {

  private URI type;

  /**
   * The age part type.
   *
   * @return The age part type.
   */
  @XmlAttribute (namespace = TypesNamespaces.GEDCOMX_TYPES_NAMESPACE)
  @XmlQNameEnumRef(AgePartType.class)
  @XmlSchemaType (name = "anyURI", namespace = XMLConstants.W3C_XML_SCHEMA_NS_URI)
  public URI getType() {
    return type;
  }

  /**
   * The age part type.
   *
   * @param type The age part type.
   */
  public void setType(URI type) {
    this.type = type;
  }

  /**
   * The enum referencing the known age part type, or {@link org.gedcomx.types.AgePartType#other} if not known.
   *
   * @return The enum referencing the known age part type, or {@link org.gedcomx.types.AgePartType#other} if not known.
   */
  @XmlTransient
  @JsonIgnore
  public AgePartType getKnownType() {
    return org.codehaus.enunciate.XmlQNameEnumUtil.fromURI(getType(), AgePartType.class);
  }

  /**
   * Set the age unit from a known enumeration of age part types.
   *
   * @param type The age part type.
   */
  @JsonIgnore
  public void setKnownType(AgePartType type) {
    setType(org.codehaus.enunciate.XmlQNameEnumUtil.toURI(type));
  }

}

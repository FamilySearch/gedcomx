/**
 * Copyright 2011-2012 Intellectual Reserve, Inc.
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

import org.codehaus.jackson.annotate.JsonIgnore;
import org.gedcomx.common.URI;
import org.gedcomx.types.IdentifierType;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;

/**
 * An identifier for a resource.
 *
 * @author Ryan Heaton
 */
@XmlType ( name = "Identifier" )
public final class Identifier {

  private String value;
  private URI type;

  /**
   * The id value.
   *
   * @return The id value.
   */
  public String getValue() {
    return value;
  }

  /**
   * The id value.
   *
   * @param value The id value.
   */
  @XmlValue
  public void setValue(String value) {
    this.value = value;
  }

  /**
   * The type of the id.
   *
   * @return The type of the id.
   */
  @XmlAttribute
  public URI getType() {
    return type;
  }

  /**
   * The type of the id.
   *
   * @param type The type of the id.
   */
  public void setType(URI type) {
    this.type = type;
  }

  /**
   * The enum referencing a known identifier type.
   *
   * @return The enum referencing a known identifier type, or {@link org.gedcomx.types.IdentifierType#OTHER} if not known.
   */
  @XmlTransient
  @JsonIgnore
  public IdentifierType getKnownType() {
    return getType() == null ? null : IdentifierType.fromQNameURI(getType());
  }

  /**
   * Set the value of the id type from a known identifier type.
   *
   * @param knownType The known identifier type.
   */
  @JsonIgnore
  public void setKnownType(IdentifierType knownType) {
    setType(knownType == null ? null : URI.create(org.codehaus.enunciate.XmlQNameEnumUtil.toURIValue(knownType)));
  }

  /**
   * Provide a simple toString() method.
   */
  @Override
  public String toString() {
    return (value == null) ? "" : value;
  }
}

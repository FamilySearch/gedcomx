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
import org.codehaus.jackson.annotate.JsonIgnore;
import org.gedcomx.rt.CommonModels;
import org.gedcomx.types.AlternateIdType;
import org.gedcomx.types.TypeReference;
import org.gedcomx.types.Typed;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

/**
 * An alternate id for an entity, such as the id in another system or
 * an id prior to a merge operation.
 *
 * @author Ryan Heaton
 */
@XmlType ( name = "AlternateId", propOrder = {"type", "value"})
public final class AlternateId implements Typed<AlternateIdType> {

  private String value;
  private TypeReference<AlternateIdType> type;

  /**
   * The id value.
   *
   * @return The id value.
   */
  @XmlElement ( name = "value", namespace = CommonModels.RDF_NAMESPACE )
  public String getValue() {
    return value;
  }

  /**
   * The id value.
   *
   * @param value The id value.
   */
  public void setValue(String value) {
    this.value = value;
  }

  /**
   * The type of the id.
   *
   * @return The type of the id.
   */
  @XmlElement (namespace = CommonModels.RDF_NAMESPACE)
  public TypeReference<AlternateIdType> getType() {
    return type;
  }

  /**
   * The type of the id.
   *
   * @param type The type of the id.
   */
  public void setType(TypeReference<AlternateIdType> type) {
    this.type = type;
  }

  /**
   * The enum referencing a known alternate id type.
   *
   * @return The enum referencing a known alternate id type, or {@link AlternateIdType#OTHER} if not known.
   */
  @XmlTransient
  @JsonIgnore
  public AlternateIdType getKnownType() {
    return getType() == null ? null : XmlQNameEnumUtil.fromURI(getType().getType(), AlternateIdType.class);
  }

  /**
   * Set the value of the id type from a known alternate id type.
   *
   * @param knownType The known alternate id type.
   */
  @JsonIgnore
  public void setKnownType(AlternateIdType knownType) {
    setType(knownType == null ? null : new TypeReference<AlternateIdType>(knownType));
  }
}

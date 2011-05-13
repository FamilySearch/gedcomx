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
package org.gedcomx.id;

import org.codehaus.enunciate.XmlQNameEnumUtil;
import org.codehaus.enunciate.qname.XmlQNameEnumRef;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlValue;
import javax.xml.namespace.QName;

/**
 * An alternate id for an entity, such as the id in another system or
 * an id prior to a merge operation.
 *
 * @author Ryan Heaton
 */
public final class AlternateId {

  private String value;
  private QName type;

  /**
   * The id value.
   *
   * @return The id value.
   */
  @XmlValue
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
  @XmlAttribute
  @XmlQNameEnumRef(AlternateIdType.class)
  public QName getType() {
    return type;
  }

  /**
   * The type of the id.
   *
   * @param type The type of the id.
   */
  public void setType(QName type) {
    this.type = type;
  }

  /**
   * The enum referencing a known alternate id type.
   *
   * @return The enum referencing a known alternate id type, or {@link AlternateIdType#other} if not known.
   */
  @XmlTransient
  public AlternateIdType getKnownType() {
    return XmlQNameEnumUtil.fromQName(getType(), AlternateIdType.class);
  }

  /**
   * Set the value of the id type from a known alternate id type.
   *
   * @param knownType The known alternate id type.
   */
  public void setKnownType(AlternateIdType knownType) {
    this.type = XmlQNameEnumUtil.toQName(knownType);
  }
}

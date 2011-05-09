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

import org.codehaus.enunciate.XmlQNameEnumUtil;
import org.codehaus.enunciate.qname.XmlQNameEnumRef;
import org.gedcomx.types.DatePartType;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.namespace.QName;

/**
 * A date part field.
 */
public class DatePart extends Field {

  private QName type;

  /**
   * The date part type.
   *
   * @return The date part type.
   */
  @XmlAttribute
  @XmlQNameEnumRef(DatePartType.class)
  public QName getType() {
    return type;
  }

  /**
   * The date part type.
   *
   * @param type The date part type.
   */
  public void setType(QName type) {
    this.type = type;
  }

  /**
   * The enum referencing the known type of the date part, or {@link org.gedcomx.types.DatePartType#other} if not known.
   *
   * @return The enum referencing the known type of the date part, or {@link org.gedcomx.types.DatePartType#other} if not known.
   */
  @XmlTransient
  public DatePartType getKnownType() {
    return XmlQNameEnumUtil.fromQName(getType(), DatePartType.class);
  }

  /**
   * Set the date part type from a known enumeration of date part types.
   *
   * @param knownType The date part type.
   */
  public void setKnownType(DatePartType knownType) {
    this.type = XmlQNameEnumUtil.toQName(knownType);
  }
}

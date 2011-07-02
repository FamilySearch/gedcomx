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
package org.gedcomx.types;

import org.codehaus.enunciate.qname.XmlQNameEnum;
import org.codehaus.enunciate.qname.XmlUnknownQNameEnumValue;

import javax.xml.namespace.QName;

/**
 * Enumeration of standard lineage types.
 */
@XmlQNameEnum
public enum LineageType {

  @XmlUnknownQNameEnumValue
  other;

  /**
   * Return the QName value for this enum.
   *
   * @return The QName value for this enum.
   */
  public QName toQName() {
    return org.codehaus.enunciate.XmlQNameEnumUtil.toQName(this);
  }

  /**
   * Get the enumeration from the QName.
   *
   * @param qname The qname.
   * @return The enumeration.
   */
  public static LineageType fromQName(QName qname) {
    return org.codehaus.enunciate.XmlQNameEnumUtil.fromQName(qname, LineageType.class);
  }

}

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

import org.codehaus.enunciate.XmlQNameEnumUtil;

import javax.xml.bind.annotation.XmlValue;
import javax.xml.namespace.QName;

/**
 * A Dublin Core property whose value is a Dublin Core type.
 *
 * @author Ryan Heaton
 */
public class DublinCoreTypeProperty extends DublinCoreProperty<QName> {

  private QName value;

  /**
   * The value of the type.
   *
   * @return The value of the type.
   */
  @XmlValue
  public QName getValue() {
    return value;
  }

  /**
   * The value of the type.
   *
   * @param value The value of the type.
   */
  public void setValue(QName value) {
    this.value = value;
  }

  /**
   * Get the type from an enumeration of known types, or null if unknown.
   *
   * @return The type from an enumeration of known types, or null if unknown.
   */
  public DublinCoreType getKnownValue() {
    return XmlQNameEnumUtil.fromQName(getValue(), DublinCoreType.class);
  }

  /**
   * Set the type from a known enumeration of Dublin Core types.
   *
   * @param knownType The type.
   */
  public void setKnownValue(DublinCoreType knownType) {
    this.value = XmlQNameEnumUtil.toQName(knownType);
  }
}

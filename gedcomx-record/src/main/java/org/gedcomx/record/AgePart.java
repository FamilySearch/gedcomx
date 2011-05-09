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
import org.gedcomx.types.AgeUnit;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.namespace.QName;

/**
 * A part of an age field.
 *
 * @author Ryan Heaton
 */
public class AgePart extends Field {

  private QName units;

  /**
   * The units in which this age part is defined.
   *
   * @return The units in which this age part is defined.
   */
  @XmlAttribute
  @XmlQNameEnumRef(AgeUnit.class)
  public QName getUnits() {
    return units;
  }

  /**
   * The units in which this age part is defined.
   *
   * @param units The units in which this age part is defined.
   */
  public void setUnits(QName units) {
    this.units = units;
  }

  /**
   * The enum referencing the known age unit, or {@link org.gedcomx.types.AgeUnit#other} if not known.
   *
   * @return The enum referencing the known age unit, or {@link org.gedcomx.types.AgeUnit#other} if not known.
   */
  @XmlTransient
  public AgeUnit getKnownUnits() {
    return org.codehaus.enunciate.XmlQNameEnumUtil.fromQName(getUnits(), AgeUnit.class);
  }

  /**
   * Set the age unit from a known enumeration of age units.
   *
   * @param unit The age unit.
   */
  public void setKnownUnits(AgeUnit unit) {
    this.units = org.codehaus.enunciate.XmlQNameEnumUtil.toQName(unit);
  }

}

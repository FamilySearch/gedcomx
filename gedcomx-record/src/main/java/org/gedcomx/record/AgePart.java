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
import org.gedcomx.types.AgeUnits;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.namespace.QName;

/**
 * @author Ryan Heaton
 */
public class AgePart extends Field {

  private QName units;

  @XmlAttribute
  @XmlQNameEnumRef(AgeUnits.class)
  public QName getUnits() {
    return units;
  }

  public void setUnits(QName units) {
    this.units = units;
  }

  @XmlTransient
  public AgeUnits getKnownUnits() {
    return org.codehaus.enunciate.XmlQNameEnumUtil.fromQName(getUnits(), AgeUnits.class);
  }

  public void setKnownUnits(AgeUnits units) {
    this.units = org.codehaus.enunciate.XmlQNameEnumUtil.toQName(units);
  }

}

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
import org.codehaus.jackson.annotate.JsonTypeInfo;
import org.codehaus.jackson.map.annotate.JsonTypeIdResolver;
import org.gedcomx.id.XmlTypeIdResolver;
import org.gedcomx.types.LineageType;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.namespace.QName;

/**
 * A lineage conclusion.
 *
 * @author Ryan Heaton
 */
@JsonTypeInfo ( use =JsonTypeInfo.Id.CUSTOM, property = "@type")
@JsonTypeIdResolver (XmlTypeIdResolver.class)
public class Lineage extends Conclusion {

  private QName type;

  /**
   * The lineage type.
   *
   * @return The lineage type.
   */
  @XmlAttribute
  @XmlQNameEnumRef ( LineageType.class )
  public QName getType() {
    return type;
  }

  /**
   * The lineage type.
   *
   * @param type The lineage type.
   */
  public void setType(QName type) {
    this.type = type;
  }

  /**
   * The enum referencing the known lineage type, or {@link org.gedcomx.types.LineageType#other} if not known.
   *
   * @return The enum referencing the known lineage type, or {@link org.gedcomx.types.LineageType#other} if not known.
   */
  @XmlTransient
  public LineageType getKnownType() {
    return XmlQNameEnumUtil.fromQName(getType(), LineageType.class);
  }

  /**
   * Set the lineage type from an enumeration of known lineage types.
   *
   * @param knownLineageType The lineage type.
   */
  public void setKnownType(LineageType knownLineageType) {
    this.type = XmlQNameEnumUtil.toQName(knownLineageType);
  }

}

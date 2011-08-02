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
import org.codehaus.jackson.annotate.JsonTypeInfo;
import org.codehaus.jackson.map.annotate.JsonTypeIdResolver;
import org.gedcomx.rt.XmlTypeIdResolver;
import org.gedcomx.types.NameType;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.namespace.QName;
import java.util.List;

/**
 * A name field.
 */
@JsonTypeInfo ( use =JsonTypeInfo.Id.CUSTOM, property = "@type")
@JsonTypeIdResolver (XmlTypeIdResolver.class)
public class Name extends Field {

  private QName type;
  private List<NamePart> parts;

  /**
   * The type of the name.
   *
   * @return The type of the name.
   */
  @XmlAttribute
  @XmlQNameEnumRef (NameType.class)
  public QName getType() {
    return type;
  }

  /**
   * The type of the name.
   *
   * @param type The type of the name.
   */
  public void setType(QName type) {
    this.type = type;
  }

  /**
   * The enum referencing the known name type, or {@link org.gedcomx.types.NameType#other} if not known.
   *
   * @return The enum referencing the known name type, or {@link org.gedcomx.types.NameType#other} if not known.
   */
  @XmlTransient
  public NameType getKnownType() {
    return XmlQNameEnumUtil.fromQName(getType(), NameType.class);
  }

  /**
   * Set the name type from an enumeration of known name types.
   *
   * @param knownType The known type.
   */
  public void setKnownType(NameType knownType) {
    this.type = XmlQNameEnumUtil.toQName(knownType);
  }

  /**
   * The different parts of the name field.
   *
   * @return The different parts of the name field.
   */
  @XmlElementWrapper (name = "parts")
  @XmlElement (name = "part")
  public List<NamePart> getParts() {
    return parts;
  }

  /**
   * The different parts of the name field.
   *
   * @param parts The different parts of the name field.
   */
  public void setParts(List<NamePart> parts) {
    this.parts = parts;
  }
}

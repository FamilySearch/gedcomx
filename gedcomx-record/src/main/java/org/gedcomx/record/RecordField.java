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
import org.gedcomx.types.FieldType;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.namespace.QName;

/**
 * A generic field on a record.
 */
@JsonTypeInfo ( use =JsonTypeInfo.Id.CUSTOM, property = "@type")
@JsonTypeIdResolver (XmlTypeIdResolver.class)
public class RecordField extends Field {

  private QName type;

  /**
   * The type of the field.
   *
   * @return The type of the field.
   */
  @XmlAttribute
  @XmlQNameEnumRef (FieldType.class)
  public QName getType() {
    return type;
  }

  /**
   * The type of the field.
   *
   * @param type The type of the field.
   */
  public void setType(QName type) {
    this.type = type;
  }

  /**
   * The enum referencing the known type of the field, or {@link org.gedcomx.types.FieldType#other} if not known.
   *
   * @return The enum referencing the known type of the field, or {@link org.gedcomx.types.FieldType#other} if not known.
   */
  @XmlTransient
  public FieldType  getKnownType() {
    return XmlQNameEnumUtil.fromQName(getType(), FieldType.class);
  }

  /**
   * Set the type of this field from a known enumeration of types.
   *
   * @param knownType The known type.
   */
  public void setKnownType(FieldType knownType) {
    this.type = XmlQNameEnumUtil.toQName(knownType);
  }

}

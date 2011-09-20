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
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonTypeInfo;
import org.codehaus.jackson.map.annotate.JsonTypeIdResolver;
import org.gedcomx.rt.CommonNamespaces;
import org.gedcomx.rt.XmlTypeIdResolver;
import org.gedcomx.types.FieldType;
import org.gedcomx.types.TypeReference;
import org.gedcomx.types.Typed;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

/**
 * A generic field on a record.
 */
@JsonTypeInfo ( use =JsonTypeInfo.Id.CUSTOM, property = XmlTypeIdResolver.TYPE_PROPERTY_NAME)
@JsonTypeIdResolver (XmlTypeIdResolver.class)
@XmlType ( name = "RecordField" )
public class RecordField extends Field implements Typed<FieldType> {

  private TypeReference<FieldType> type;

  /**
   * The type of the field.
   *
   * @return The type of the field.
   */
  @XmlElement (namespace = CommonNamespaces.RDF_NAMESPACE)
  public TypeReference<FieldType> getType() {
    return type;
  }

  /**
   * The type of the field.
   *
   * @param type The type of the field.
   */
  public void setType(TypeReference<FieldType> type) {
    this.type = type;
  }

  /**
   * The enum referencing the known type of the field, or {@link org.gedcomx.types.FieldType#other} if not known.
   *
   * @return The enum referencing the known type of the field, or {@link org.gedcomx.types.FieldType#other} if not known.
   */
  @XmlTransient
  @JsonIgnore
  public FieldType getKnownType() {
    return getType() == null ? null : XmlQNameEnumUtil.fromURI(getType().getType(), FieldType.class);
  }

  /**
   * Set the type of this field from a known enumeration of types.
   *
   * @param knownType The known type.
   */
  @JsonIgnore
  public void setKnownType(FieldType knownType) {
    setType(knownType == null ? null : new TypeReference<FieldType>(knownType));
  }

}

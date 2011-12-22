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

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonTypeInfo;
import org.codehaus.jackson.map.annotate.JsonTypeIdResolver;
import org.gedcomx.common.URI;
import org.gedcomx.rt.CommonModels;
import org.gedcomx.rt.XmlTypeIdResolver;
import org.gedcomx.types.DatePartType;
import org.gedcomx.types.TypeReference;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

/**
 * A date part field.
 */
@JsonTypeInfo ( use =JsonTypeInfo.Id.CUSTOM, property = XmlTypeIdResolver.TYPE_PROPERTY_NAME)
@JsonTypeIdResolver (XmlTypeIdResolver.class)
@XmlType ( name = "DatePart" )
public class DatePart extends Field {

  @XmlElement (namespace = CommonModels.RDF_NAMESPACE)
  @JsonProperty
  private TypeReference<DatePartType> type;

  /**
   * The date part type.
   *
   * @return The date part type.
   */
  @XmlTransient
  @JsonIgnore
  public URI getType() {
    return this.type == null ? null : this.type.getType();
  }

  /**
   * The date part type.
   *
   * @param type The date part type.
   */
  @JsonIgnore
  public void setType(URI type) {
    this.type = type == null ? null : new TypeReference<DatePartType>(type);
  }

  /**
   * The enum referencing the known type of the date part, or {@link org.gedcomx.types.DatePartType#OTHER} if not known.
   *
   * @return The enum referencing the known type of the date part, or {@link org.gedcomx.types.DatePartType#OTHER} if not known.
   */
  @XmlTransient
  @JsonIgnore
  public DatePartType getKnownType() {
    return this.type == null ? null : DatePartType.fromQName(this.type.getType());
  }

  /**
   * Set the date part type from a known enumeration of date part types.
   *
   * @param knownType The date part type.
   */
  @JsonIgnore
  public void setKnownType(DatePartType knownType) {
    this.type = knownType == null ? null : new TypeReference<DatePartType>(knownType);
  }
}

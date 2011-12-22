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
import org.gedcomx.types.PlacePartType;
import org.gedcomx.types.TypeReference;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

@JsonTypeInfo ( use =JsonTypeInfo.Id.CUSTOM, property = XmlTypeIdResolver.TYPE_PROPERTY_NAME)
@JsonTypeIdResolver (XmlTypeIdResolver.class)
@XmlType ( name = "PlacePart" )
public class PlacePart extends Field {

  @XmlElement (namespace = CommonModels.RDF_NAMESPACE)
  @JsonProperty
  private TypeReference<PlacePartType> type;

  /**
   * The place part type.
   *
   * @return The place part type.
   */
  @XmlTransient
  @JsonIgnore
  public URI getType() {
    return this.type == null ? null : this.type.getType();
  }

  /**
   * The place part type.
   *
   * @param type The place part type.
   */
  @JsonIgnore
  public void setType(URI type) {
    this.type = type == null ? null : new TypeReference<PlacePartType>(type);
  }

  /**
   * The enum referencing the known type of the place part, or {@link org.gedcomx.types.PlacePartType#OTHER} if not known.
   *
   * @return The enum referencing the known type of the place part, or {@link org.gedcomx.types.PlacePartType#OTHER} if not known.
   */
  @XmlTransient
  @JsonIgnore
  public PlacePartType getKnownType() {
    return this.type == null ? null : PlacePartType.fromQNameURI(this.type.getType());
  }

  /**
   * Set the place part type from a known enumeration of place part types.
   *
   * @param knownType The place part type.
   */
  @JsonIgnore
  public void setKnownType(PlacePartType knownType) {
    this.type = knownType == null ? null : new TypeReference<PlacePartType>(knownType);
  }
}

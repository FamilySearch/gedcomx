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
import org.gedcomx.types.PlacePartType;
import org.gedcomx.types.TypeReference;
import org.gedcomx.types.Typed;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

@JsonTypeInfo ( use =JsonTypeInfo.Id.CUSTOM, property = XmlTypeIdResolver.TYPE_PROPERTY_NAME)
@JsonTypeIdResolver (XmlTypeIdResolver.class)
@XmlType ( name = "PlacePart" )
public class PlacePart extends Field implements Typed<PlacePartType> {

  private TypeReference<PlacePartType> type;

  /**
   * The place part type.
   *
   * @return The place part type.
   */
  @XmlElement (namespace = CommonNamespaces.RDF_NAMESPACE)
  public TypeReference<PlacePartType> getType() {
    return type;
  }

  /**
   * The place part type.
   *
   * @param type The place part type.
   */
  public void setType(TypeReference<PlacePartType> type) {
    this.type = type;
  }

  /**
   * The enum referencing the known type of the place part, or {@link org.gedcomx.types.PlacePartType#OTHER} if not known.
   *
   * @return The enum referencing the known type of the place part, or {@link org.gedcomx.types.PlacePartType#OTHER} if not known.
   */
  @XmlTransient
  @JsonIgnore
  public PlacePartType getKnownType() {
    return getType() == null ? null : XmlQNameEnumUtil.fromURI(getType().getType(), PlacePartType.class);
  }

  /**
   * Set the place part type from a known enumeration of place part types.
   *
   * @param knownType The place part type.
   */
  @JsonIgnore
  public void setKnownType(PlacePartType knownType) {
    setType(knownType == null ? null : new TypeReference<PlacePartType>(knownType));
  }
}

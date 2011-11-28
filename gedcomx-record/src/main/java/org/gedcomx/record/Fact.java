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
import org.gedcomx.common.ResourceReference;
import org.gedcomx.rt.*;
import org.gedcomx.types.FactType;
import org.gedcomx.types.TypeReference;
import org.gedcomx.types.Typed;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

/**
 * A fact field. A fact is a piece of historical data applicable to a person or relationship. Examples include an event in which the person participated, a
 * physical description of a person, or the nature of the lineage between a parent and a child. If a fact references an event, the value of the fact describes
 * how the person or relationship relates to the event (e.g. the role the person played in the event).
 */
@JsonTypeInfo ( use =JsonTypeInfo.Id.CUSTOM, property = XmlTypeIdResolver.TYPE_PROPERTY_NAME)
@JsonTypeIdResolver (XmlTypeIdResolver.class)
@XmlType ( name = "Fact" )
public class Fact extends Field implements Typed<FactType>, Weighted {

  private TypeReference<FactType> type;
  private ResourceReference event;
  private Boolean principal;

  /**
   * The type of the fact.
   *
   * @return The type of the fact.
   */
  @XmlElement (namespace = CommonModels.RDF_NAMESPACE)
  public TypeReference<FactType> getType() {
    return type;
  }

  /**
   * The type of the fact.
   *
   * @param type The type of the fact.
   */
  public void setType(TypeReference<FactType> type) {
    this.type = type;
  }

  /**
   * The enum referencing the known type of the fact, or {@link org.gedcomx.types.FactType#OTHER} if not known.
   *
   * @return The enum referencing the known type of the fact, or {@link org.gedcomx.types.FactType#OTHER} if not known.
   */
  @XmlTransient
  @JsonIgnore
  public FactType getKnownType() {
    return getType() == null ? null : XmlQNameEnumUtil.fromURI(getType().getType(), FactType.class);
  }

  /**
   * Set the type of this fact from a known enumeration of types.
   *
   * @param knownType The known type.
   */
  @JsonIgnore
  public void setKnownType(FactType knownType) {
    setType(knownType == null ? null : new TypeReference<FactType>(knownType));
  }

  /**
   * An event reference, if applicable to this fact.
   *
   * @return An event reference, if applicable to this fact.
   */
  @RDFRange ( Event.class )
  @RDFDomain ( CommonModels.GEDCOMX_COMMON_NAMESPACE + "GenealogicalResource" )
  public ResourceReference getEvent() {
    return event;
  }

  /**
   * An event reference, if applicable to this fact.
   *
   * @param event An event reference, if applicable to this fact.
   */
  public void setEvent(ResourceReference event) {
    this.event = event;
  }

  /**
   * Whether this is a principal fact in the record. For example, the birth fact is the principal fact for a birth certificate.
   *
   * @return Whether this is a principal fact in the record. For example, the birth fact is the principal fact for a birth certificate.
   */
  @XmlAttribute
  public Boolean getPrincipal() {
    return principal;
  }

  /**
   * Whether this is a principal fact in the record. For example, the birth fact is the principal fact for a birth certificate.
   *
   * @param principal Whether this is a principal fact in the record. For example, the birth fact is the principal fact for a birth certificate.
   */
  public void setPrincipal(Boolean principal) {
    this.principal = principal;
  }

}

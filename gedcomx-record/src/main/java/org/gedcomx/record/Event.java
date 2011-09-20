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

import org.codehaus.enunciate.ClientName;
import org.codehaus.enunciate.XmlQNameEnumUtil;
import org.codehaus.enunciate.qname.XmlQNameEnumRef;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonTypeInfo;
import org.codehaus.jackson.map.annotate.JsonTypeIdResolver;
import org.gedcomx.common.GenealogicalResource;
import org.gedcomx.rt.CommonNamespaces;
import org.gedcomx.rt.RDFSubClassOf;
import org.gedcomx.rt.RDFSubPropertyOf;
import org.gedcomx.rt.XmlTypeIdResolver;
import org.gedcomx.types.Typed;

import javax.xml.XMLConstants;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;
import java.net.URI;

/**
 * A recorded event.
 */
@ClientName("EventInfo")
@JsonTypeInfo ( use =JsonTypeInfo.Id.CUSTOM, property = XmlTypeIdResolver.TYPE_PROPERTY_NAME)
@JsonTypeIdResolver (XmlTypeIdResolver.class)
@XmlType( name = "Event", propOrder = { "date", "place" } )
@RDFSubClassOf ( CommonNamespaces.DUBLIN_CORE_TYPE_NAMESPACE + "Event" )
public class Event extends GenealogicalResource implements Typed {

  private URI type;
  private Boolean primary;
  private Date date;
  private Place place;

  /**
   * The type of the event.
   *
   * @return The type of the event.
   */
  @XmlAttribute (namespace = CommonNamespaces.GEDCOMX_COMMON_NAMESPACE)
  @XmlQNameEnumRef ( org.gedcomx.types.EventType.class)
  @XmlSchemaType (name = "anyURI", namespace = XMLConstants.W3C_XML_SCHEMA_NS_URI)
  public URI getType() {
    return type;
  }

  /**
   * The type of the event.
   *
   * @param type The type of the event.
   */
  public void setType(URI type) {
    this.type = type;
  }

  /**
   * The enum referencing the known type of the event, or {@link org.gedcomx.types.EventType#OTHER} if not known.
   *
   * @return The enum referencing the known type of the event, or {@link org.gedcomx.types.EventType#OTHER} if not known.
   */
  @XmlTransient
  @JsonIgnore
  public org.gedcomx.types.EventType getKnownType() {
    return XmlQNameEnumUtil.fromURI(getType(), org.gedcomx.types.EventType.class);
  }

  /**
   * Set the type of this event from a known enumeration of event types.
   *
   * @param knownType the event type.
   */
  @JsonIgnore
  public void setKnownType(org.gedcomx.types.EventType knownType) {
    setType(XmlQNameEnumUtil.toURI(knownType));
  }

  /**
   * Indicator for whether this is the primary event for this record. For example, the primary event for a birth certificate would be the birth event.
   *
   * @return Indicator for whether this is the primary event for this record. For example, the primary event for a birth certificate would be the birth event.
   */
  @XmlAttribute
  public Boolean getPrimary() {
    return primary;
  }

  /**
   * Indicator for whether this is the primary event for this record. For example, the primary event for a birth certificate would be the birth event.
   *
   * @param primary Indicator for whether this is the primary event for this record. For example, the primary event for a birth certificate would be the birth event.
   */
  public void setPrimary(Boolean primary) {
    this.primary = primary;
  }

  /**
   * The date of this event.
   *
   * @return The date of this event.
   */
  @RDFSubPropertyOf ( CommonNamespaces.DUBLIN_CORE_NAMESPACE + "temporal" )
  public Date getDate() {
    return date;
  }

  /**
   * The date of this event.
   *
   * @param date The date of this event.
   */
  public void setDate(Date date) {
    this.date = date;
  }

  /**
   * The place of this event.
   *
   * @return The place of this event.
   */
  @RDFSubPropertyOf ( CommonNamespaces.DUBLIN_CORE_NAMESPACE + "spatial" )
  public Place getPlace() {
    return place;
  }

  /**
   * The place of this event.
   *
   * @param place The place of this event.
   */
  public void setPlace(Place place) {
    this.place = place;
  }

}

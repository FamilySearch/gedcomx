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
package org.gedcomx.types;

import org.codehaus.enunciate.qname.XmlQNameEnum;
import org.codehaus.enunciate.qname.XmlUnknownQNameEnumValue;

import javax.xml.namespace.QName;
import java.net.URI;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Set;

/**
 * Enumeration of standard event types.
 */
@XmlQNameEnum (
  base = XmlQNameEnum.BaseType.URI
)
public enum EventType {

  adoption,
  adult_christening,
  annulment,
  baptism,
  bar_mitzvah,
  bas_mitzvah,
  birth,
  blessing,
  burial,
  census,
  christening,
  circumcision,
  confirmation,
  cremation,
  death,
  divorce,
  divorce_filing,
  emigration,
  engagement,
  excommunication,
  first_communion,
  flourish,
  funeral,
  graduation,
  illness,
  immigration,
  interment,
  marriage,
  marriage_banns,
  marriage_contract,
  marriage_intent,
  marriage_license,
  marriage_notice,
  marriage_settlement,
  military_award,
  military_discharge,
  military_service,
  mission,
  move,
  naturalization,
  ordinance,
  ordination,
  probate,
  residence,
  retirement,
  separation,
  will,
  @XmlUnknownQNameEnumValue
  other;

  public final static Set<EventType> BIRTHLIKE_EVENT_TYPES = Collections.unmodifiableSet(EnumSet.of(baptism, birth, christening, blessing, circumcision, adoption));
  public final static Set<EventType> DEATHLIKE_EVENT_TYPES = Collections.unmodifiableSet(EnumSet.of(death, burial, cremation, funeral, interment, probate, will));
  public final static Set<EventType> MARRIAGELIKE_EVENT_TYPES = Collections.unmodifiableSet(EnumSet.of(marriage, engagement, marriage_banns, marriage_contract, marriage_license, marriage_notice, marriage_settlement));
  public final static Set<EventType> DIVORCELIKE_EVENT_TYPES = Collections.unmodifiableSet(EnumSet.of(divorce, divorce_filing, annulment, separation));
  public final static Set<EventType> MIGRATIONLIKE_EVENT_TYPES = Collections.unmodifiableSet(EnumSet.of(immigration, emigration, naturalization, move));

  /**
   * Return the QName value for this enum.
   *
   * @return The QName value for this enum.
   */
  public URI toQNameURI() {
    return org.codehaus.enunciate.XmlQNameEnumUtil.toURI(this);
  }

  /**
   * Get the enumeration from the QName.
   *
   * @param qname The qname.
   * @return The enumeration.
   */
  public static EventType fromQNameURI(URI qname) {
    return org.codehaus.enunciate.XmlQNameEnumUtil.fromURI(qname, EventType.class);
  }

  public boolean isBirthLike() {
    return BIRTHLIKE_EVENT_TYPES.contains(this);
  }

  public boolean isDeathLike() {
    return DEATHLIKE_EVENT_TYPES.contains(this);
  }

  public boolean isMarriageLike() {
    return MARRIAGELIKE_EVENT_TYPES.contains(this);
  }

  public boolean isDivorceLike() {
    return DIVORCELIKE_EVENT_TYPES.contains(this);
  }

  public boolean isMigrationLike() {
    return MIGRATIONLIKE_EVENT_TYPES.contains(this);
  }

}

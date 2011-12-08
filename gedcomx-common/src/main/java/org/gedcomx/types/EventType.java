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

  Adoption,
  AdultChristening,
  Annulment,
  Baptism,
  BarMitzvah,
  BasMitzvah,
  Birth,
  Blessing,
  Burial,
  Census,
  Christening,
  Circumcision,
  CommonLawMarriage,
  Confirmation,
  Cremation,
  Death,
  Divorce,
  DivorceFiling,
  Emigration,
  Engagement,
  Excommunication,
  FirstCommunion,
  Flourish,
  Funeral,
  Graduation,
  Illness,
  Immigration,
  Interment,
  Marriage,
  MarriageBanns,
  MilitaryAward,
  MilitaryCompany,
  MarriageContract,
  MilitaryDischarge,
  MarriageIntent,
  MarriageLicense,
  MarriageNotice,
  MilitaryRank,
  MilitaryRegiment,
  MilitaryService,
  MilitaryServiceBranch,
  MarriageSettlement,
  Mission,
  Move,
  Naturalization,
  Occupation,
  Ordinance,
  Ordination,
  Probate,
  ReligiousAffiliation,
  Residence,
  Retirement,
  ScholasticAchievement,
  Separation,
  Stillborn,
  Will,
  @XmlUnknownQNameEnumValue
  OTHER;

  public final static Set<EventType> BIRTHLIKE_EVENT_TYPES = Collections.unmodifiableSet(EnumSet.of(Baptism, Birth, Christening, Blessing, Circumcision, Adoption));
  public final static Set<EventType> DEATHLIKE_EVENT_TYPES = Collections.unmodifiableSet(EnumSet.of(Death, Burial, Cremation, Funeral, Interment, Probate, Will));
  public final static Set<EventType> MARRIAGELIKE_EVENT_TYPES = Collections.unmodifiableSet(EnumSet.of(Marriage, Engagement, MarriageBanns, MarriageContract, MarriageLicense, MarriageNotice, MarriageSettlement));
  public final static Set<EventType> DIVORCELIKE_EVENT_TYPES = Collections.unmodifiableSet(EnumSet.of(Divorce, DivorceFiling, Annulment, Separation));
  public final static Set<EventType> MIGRATIONLIKE_EVENT_TYPES = Collections.unmodifiableSet(EnumSet.of(Immigration, Emigration, Naturalization, Move));

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

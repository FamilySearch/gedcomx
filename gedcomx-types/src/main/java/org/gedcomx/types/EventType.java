package org.gedcomx.types;

import org.codehaus.enunciate.qname.XmlQNameEnum;
import org.codehaus.enunciate.qname.XmlUnknownQNameEnumValue;

import java.util.Collections;
import java.util.EnumSet;
import java.util.Set;

@XmlQNameEnum
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

package org.gedcomx.types;

import org.codehaus.enunciate.qname.XmlQNameEnum;
import org.codehaus.enunciate.qname.XmlUnknownQNameEnumValue;

import java.util.Collections;
import java.util.EnumSet;
import java.util.Set;

@XmlQNameEnum
public enum RecordType {

  // root level record types
  census,
  legal,
  migration,
  military,
  vital,

  // "VITAL" types
  birth,
  death,
  marriage,

  // "LEGAL" types
  bank,
  land,
  probate,
  tax,

  // "MILITARY" types
  draft,
  roll,
  pension,

  @XmlUnknownQNameEnumValue
  other;

  public static final Set<RecordType> VITAL_TYPES = Collections.unmodifiableSet(EnumSet.of(birth, death, marriage));
  public static final Set<RecordType> MILITARY_TYPES = Collections.unmodifiableSet(EnumSet.of(draft, pension, roll));
  public static final Set<RecordType> LEGAL_TYPES = Collections.unmodifiableSet(EnumSet.of(bank, land, probate, tax));

  public boolean isVital() {
    return this == vital || VITAL_TYPES.contains(this);
  }
  
  public RecordType getBaseType() {
    if (VITAL_TYPES.contains(this)) {
      return vital;
    }
    else if (MILITARY_TYPES.contains(this)) {
      return military;
    }
    else if (LEGAL_TYPES.contains(this)) {
      return legal;
    }
    else {
      return this;
    }
  }
}

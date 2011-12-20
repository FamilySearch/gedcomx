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

import org.gedcomx.common.URI;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Set;

/**
 * Enumeration of known record types.
 */
@XmlQNameEnum (
  base = XmlQNameEnum.BaseType.URI
)
public enum RecordType {

  // root level record types
  Census,
  Legal,
  Migration,
  Military,
  Vital,

  // "VITAL" types
  Birth,
  Death,
  Marriage,

  // "LEGAL" types
  Bank,
  Land,
  Probate,
  Tax,

  // "MILITARY" types
  Draft,
  Roll,
  Pension,

  @XmlUnknownQNameEnumValue
  OTHER;

  public static final Set<RecordType> VITAL_TYPES = Collections.unmodifiableSet(EnumSet.of(Birth, Death, Marriage));
  public static final Set<RecordType> MILITARY_TYPES = Collections.unmodifiableSet(EnumSet.of(Draft, Pension, Roll));
  public static final Set<RecordType> LEGAL_TYPES = Collections.unmodifiableSet(EnumSet.of(Bank, Land, Probate, Tax));

  /**
   * Return the QName value for this enum.
   *
   * @return The QName value for this enum.
   */
  public URI toQNameURI() {
    return URI.create(org.codehaus.enunciate.XmlQNameEnumUtil.toURIValue(this));
  }

  /**
   * Get the enumeration from the QName.
   *
   * @param qname The qname.
   * @return The enumeration.
   */
  public static RecordType fromQNameURI(URI qname) {
    return org.codehaus.enunciate.XmlQNameEnumUtil.fromURIValue(qname.toString(), RecordType.class);
  }

  public boolean isVital() {
    return this == Vital || VITAL_TYPES.contains(this);
  }
  
  public RecordType getBaseType() {
    if (VITAL_TYPES.contains(this)) {
      return Vital;
    }
    else if (MILITARY_TYPES.contains(this)) {
      return Military;
    }
    else if (LEGAL_TYPES.contains(this)) {
      return Legal;
    }
    else {
      return this;
    }
  }
}

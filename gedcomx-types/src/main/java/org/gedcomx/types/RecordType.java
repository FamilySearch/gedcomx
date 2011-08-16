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
 * Enumeration of known record types.
 */
@XmlQNameEnum (
  base = XmlQNameEnum.BaseType.URI
)
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
  public static RecordType fromQNameURI(URI qname) {
    return org.codehaus.enunciate.XmlQNameEnumUtil.fromURI(qname, RecordType.class);
  }

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

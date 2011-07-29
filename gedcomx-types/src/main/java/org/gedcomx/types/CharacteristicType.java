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

import javax.xml.bind.annotation.XmlTransient;
import javax.xml.namespace.QName;
import java.util.EnumSet;

/**
 * Enumeration of standard characteristic types.
 */
@XmlQNameEnum
public enum CharacteristicType {

  age,
  caste_name,
  citizenship,
  clan_name,
  count_of_children,
  count_of_marriages,
  died_before_eight,
  dwelling,
  ethnicity,
  gedcom_uuid,
  household,
  marital_status,
  military_company,
  military_rank,
  military_regiment,
  military_service_branch,
  namesake,
  national_id,
  national_origin,
  not_accountable,
  occupation,
  never_had_children,
  never_married,
  physical_description,
  possessions,
  race,
  religious_affiliation,
  scholastic_achievement,
  social_security_number,
  stillborn,
  title_of_nobility,
  tribe_name,
  twin,
  common_law_marriage,
  universal_id,
  currently_spouses,
  number_of_children,
  biological,
  adopted,
  step,
  foster,
  guardianship,
  @XmlUnknownQNameEnumValue
  other;

  /**
   * Return the QName value for this enum.
   *
   * @return The QName value for this enum.
   */
  public QName toQName() {
    return org.codehaus.enunciate.XmlQNameEnumUtil.toQName(this);
  }

  /**
   * Get the enumeration from the QName.
   *
   * @param qname The qname.
   * @return The enumeration.
   */
  public static CharacteristicType fromQName(QName qname) {
    return org.codehaus.enunciate.XmlQNameEnumUtil.fromQName(qname, CharacteristicType.class);
  }

  /**
   * Enumeration of types that are applicable to a person characteristic.
   */
  @XmlTransient
  public static final class Person {
    private Person(){}

    private static final EnumSet<CharacteristicType> PERSON_CHARACTERISTIC_TYPES = EnumSet.noneOf(CharacteristicType.class);
    private static CharacteristicType include(CharacteristicType type) {
      PERSON_CHARACTERISTIC_TYPES.add(type);
      return type;
    }
    
    public static final CharacteristicType age = include(CharacteristicType.age);
    public static final CharacteristicType caste_name = include(CharacteristicType.caste_name);
    public static final CharacteristicType clan_name = include(CharacteristicType.clan_name);
    public static final CharacteristicType count_of_children = include(CharacteristicType.count_of_children);
    public static final CharacteristicType count_of_marriages = include(CharacteristicType.count_of_marriages);
    public static final CharacteristicType died_before_eight = include(CharacteristicType.died_before_eight);
    public static final CharacteristicType dwelling = include(CharacteristicType.dwelling);
    public static final CharacteristicType ethnicity = include(CharacteristicType.ethnicity);
    public static final CharacteristicType gedcom_uuid = include(CharacteristicType.gedcom_uuid);
    public static final CharacteristicType household = include(CharacteristicType.household);
    public static final CharacteristicType marital_status = include(CharacteristicType.marital_status);
    public static final CharacteristicType namesake = include(CharacteristicType.namesake);
    public static final CharacteristicType national_id = include(CharacteristicType.national_id);
    public static final CharacteristicType national_origin = include(CharacteristicType.national_origin);
    public static final CharacteristicType not_accountable = include(CharacteristicType.not_accountable);
    public static final CharacteristicType occupation = include(CharacteristicType.occupation);
    public static final CharacteristicType never_had_children = include(CharacteristicType.never_had_children);
    public static final CharacteristicType never_married = include(CharacteristicType.never_married);
    public static final CharacteristicType physical_description = include(CharacteristicType.physical_description);
    public static final CharacteristicType possessions = include(CharacteristicType.possessions);
    public static final CharacteristicType race = include(CharacteristicType.race);
    public static final CharacteristicType religious_affiliation = include(CharacteristicType.religious_affiliation);
    public static final CharacteristicType scholastic_achievement = include(CharacteristicType.scholastic_achievement);
    public static final CharacteristicType social_security_number = include(CharacteristicType.social_security_number);
    public static final CharacteristicType stillborn = include(CharacteristicType.stillborn);
    public static final CharacteristicType title_of_nobility = include(CharacteristicType.title_of_nobility);
    public static final CharacteristicType tribe_name = include(CharacteristicType.tribe_name);
    public static final CharacteristicType twin = include(CharacteristicType.twin);
    
    /**
     * Whether the given characteristic type is applicable to a person characteristic.
     * 
     * @param type The characteristic type.
     * @return Whether the given characteristic type is applicable to a person characteristic.
     */
    public static boolean isApplicable(CharacteristicType type) {
      return PERSON_CHARACTERISTIC_TYPES.contains(type);
    }
  }

  @XmlTransient
  public static final class Couple {
    private Couple() {}

    private static final EnumSet<CharacteristicType> COUPLE_CHARACTERISTIC_TYPES = EnumSet.noneOf(CharacteristicType.class);
    private static CharacteristicType include(CharacteristicType type) {
      COUPLE_CHARACTERISTIC_TYPES.add(type);
      return type;
    }
    
    public static final CharacteristicType common_law_marriage = include(CharacteristicType.common_law_marriage);
    public static final CharacteristicType universal_id = include(CharacteristicType.universal_id);
    public static final CharacteristicType currently_spouses = include(CharacteristicType.currently_spouses);
    public static final CharacteristicType never_had_children = include(CharacteristicType.never_had_children);
    public static final CharacteristicType never_married = include(CharacteristicType.never_married);
    public static final CharacteristicType number_of_children = include(CharacteristicType.number_of_children);

    /**
     * Whether the given characteristic type is applicable to a couple characteristic.
     * 
     * @param type The characteristic type.
     * @return Whether the given characteristic type is applicable to a couple characteristic.
     */
    public static boolean isApplicable(CharacteristicType type) {
      return COUPLE_CHARACTERISTIC_TYPES.contains(type);
    }
  }

  @XmlTransient
  public static final class ParentChild {
    private ParentChild() {}

    private static final EnumSet<CharacteristicType> PARENT_CHILD_CHARACTERISTIC_TYPES = EnumSet.noneOf(CharacteristicType.class);
    private static CharacteristicType include(CharacteristicType type) {
      PARENT_CHILD_CHARACTERISTIC_TYPES.add(type);
      return type;
    }
    
    public static final CharacteristicType biological = include(CharacteristicType.biological);
    public static final CharacteristicType adopted = include(CharacteristicType.adopted);
    public static final CharacteristicType step = include(CharacteristicType.step);
    public static final CharacteristicType foster = include(CharacteristicType.foster);
    public static final CharacteristicType guardianship = include(CharacteristicType.guardianship);

    /**
     * Whether the given characteristic type is applicable to a ParentChild characteristic.
     * 
     * @param type The characteristic type.
     * @return Whether the given characteristic type is applicable to a ParentChild characteristic.
     */
    public static boolean isApplicable(CharacteristicType type) {
      return PARENT_CHILD_CHARACTERISTIC_TYPES.contains(type);
    }
  }

}

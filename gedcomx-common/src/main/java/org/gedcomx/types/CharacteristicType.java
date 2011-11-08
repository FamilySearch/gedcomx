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
import java.net.URI;
import java.util.EnumSet;

/**
 * Enumeration of standard characteristic types.
 */
@XmlQNameEnum (
  base = XmlQNameEnum.BaseType.URI
)
public enum CharacteristicType {

  Age,
  CasteName,
  Citizenship,
  ClanName,
  CountOfChildren,
  CountOfMarriages,
  DiedBeforeEight,
  Dwelling,
  Ethnicity,
  GedcomUUID,
  Household,
  MaritalStatus,
  MilitaryCompany,
  MilitaryRank,
  MilitaryRegiment,
  MilitaryServiceBranch,
  Namesake,
  NationalId,
  NationalOrigin,
  NotAccountable,
  Occupation,
  NeverHadChildren,
  NeverMarried,
  PhysicalDescription,
  Possessions,
  Race,
  ReligiousAffiliation,
  ScholasticAchievement,
  SocialSecurityNumber,
  Stillborn,
  TitleOfNobility,
  TribeName,
  Twin,
  CommonLawMarriage,
  UniversalId,
  CurrentlySpouses,
  NumberOfChildren,
  Biological,
  Adopted,
  Step,
  Foster,
  Guardianship,
  @XmlUnknownQNameEnumValue
  OTHER;

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
  public static CharacteristicType fromQNameURI(URI qname) {
    return org.codehaus.enunciate.XmlQNameEnumUtil.fromURI(qname, CharacteristicType.class);
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
    
    public static final CharacteristicType Age = include(CharacteristicType.Age);
    public static final CharacteristicType CasteName = include(CharacteristicType.CasteName);
    public static final CharacteristicType ClanName = include(CharacteristicType.ClanName);
    public static final CharacteristicType CountOfChildren = include(CharacteristicType.CountOfChildren);
    public static final CharacteristicType CountOfMarriages = include(CharacteristicType.CountOfMarriages);
    public static final CharacteristicType DiedBeforeEight = include(CharacteristicType.DiedBeforeEight);
    public static final CharacteristicType Dwelling = include(CharacteristicType.Dwelling);
    public static final CharacteristicType Ethnicity = include(CharacteristicType.Ethnicity);
    public static final CharacteristicType GedcomUuid = include(CharacteristicType.GedcomUUID);
    public static final CharacteristicType Household = include(CharacteristicType.Household);
    public static final CharacteristicType MaritalStatus = include(CharacteristicType.MaritalStatus);
    public static final CharacteristicType Namesake = include(CharacteristicType.Namesake);
    public static final CharacteristicType NationalId = include(CharacteristicType.NationalId);
    public static final CharacteristicType NationalOrigin = include(CharacteristicType.NationalOrigin);
    public static final CharacteristicType NotAccountable = include(CharacteristicType.NotAccountable);
    public static final CharacteristicType Occupation = include(CharacteristicType.Occupation);
    public static final CharacteristicType NeverHadChildren = include(CharacteristicType.NeverHadChildren);
    public static final CharacteristicType NeverMarried = include(CharacteristicType.NeverMarried);
    public static final CharacteristicType PhysicalDescription = include(CharacteristicType.PhysicalDescription);
    public static final CharacteristicType Possessions = include(CharacteristicType.Possessions);
    public static final CharacteristicType Race = include(CharacteristicType.Race);
    public static final CharacteristicType ReligiousAffiliation = include(CharacteristicType.ReligiousAffiliation);
    public static final CharacteristicType ScholasticAchievement = include(CharacteristicType.ScholasticAchievement);
    public static final CharacteristicType SocialSecurityNumber = include(CharacteristicType.SocialSecurityNumber);
    public static final CharacteristicType Stillborn = include(CharacteristicType.Stillborn);
    public static final CharacteristicType TitleOfNobility = include(CharacteristicType.TitleOfNobility);
    public static final CharacteristicType TribeName = include(CharacteristicType.TribeName);
    public static final CharacteristicType Twin = include(CharacteristicType.Twin);
    
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
    
    public static final CharacteristicType CommonLawMarriage = include(CharacteristicType.CommonLawMarriage);
    public static final CharacteristicType UniversalId = include(CharacteristicType.UniversalId);
    public static final CharacteristicType CurrentlySpouses = include(CharacteristicType.CurrentlySpouses);
    public static final CharacteristicType NeverHadChildren = include(CharacteristicType.NeverHadChildren);
    public static final CharacteristicType NeverMarried = include(CharacteristicType.NeverMarried);
    public static final CharacteristicType NumberOfChildren = include(CharacteristicType.NumberOfChildren);

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
    
    public static final CharacteristicType Biological = include(CharacteristicType.Biological);
    public static final CharacteristicType Adopted = include(CharacteristicType.Adopted);
    public static final CharacteristicType Step = include(CharacteristicType.Step);
    public static final CharacteristicType Foster = include(CharacteristicType.Foster);
    public static final CharacteristicType Guardianship = include(CharacteristicType.Guardianship);

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

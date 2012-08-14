/**
 * Copyright 2011-2012 Intellectual Reserve, Inc.
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
import org.codehaus.enunciate.qname.XmlQNameEnumValue;
import org.codehaus.enunciate.qname.XmlUnknownQNameEnumValue;
import org.gedcomx.common.URI;

import javax.xml.bind.annotation.XmlTransient;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Set;

/**
 * Enumeration of standard fact types.
 */
@XmlQNameEnum (
  base = XmlQNameEnum.BaseType.URI
)
public enum FactType {

  // facts generally applicable within the scope of a person.

  /**
   * A fact of a person's adoption. In the context of a parent-child relationship, it describes a fact of the adoption of a child by a parent.
   */
  Adoption,

  /**
   * A fact of a person's christening as an adult.
   */
  AdultChristening,

  /**
   * A fact of a person's baptism.
   */
  Baptism,

  /**
   * A fact of a person's bar mitzvah.
   */
  BarMitzvah,

  /**
   * A fact of a person's bat mitzvah.
   */
  BatMitzvah,

  /**
   * A fact of a person's birth.
   */
  Birth,

  /**
   * A fact of an official blessing received by a person, such as at the hands of a clergy member or at another religious rite.
   */
  Blessing,

  /**
   * A fact of the burial of person's body after death.
   */
  Burial,

  /**
   * A fact of a person's caste.
   */
  Caste,

  /**
   * A fact of a person's participation in a census.
   */
  Census,

  /**
   * A fact of a person's christening *at birth*. Note: use `AdultChristening` for the christening as an adult.
   */
  Christening,

  /**
   * A fact of a person's circumcision.
   */
  Circumcision,

  /**
   * A fact of a person's clan.
   */
  Clan,

  /**
   * A fact of a person's confirmation (or other rite of initiation) in a church or religion.
   */
  Confirmation,

  /**
   * A fact of the cremation of person's body after death.
   */
  Cremation,

  /**
   * A fact of the death of a person.
   */
  Death,

  /**
   * A fact of an education or an educational achievement (e.g. diploma, graduation, scholarship, etc.) of a person.
   */
  Education,

  /**
   * A fact of the emigration of a person.
   */
  Emigration,

  /**
   * A fact of a person's ethnicity or race.
   */
  Ethnicity,

  /**
   * A fact of a person's excommunication from a church.
   */
  Excommunication,

  /**
   * A fact of a person's first communion in a church.
   */
  FirstCommunion,

  /**
   * A fact of a person's flourish, defined to mean the time period in an adult's life where he was most productive, perhaps as a writer or member of the state assembly. It does not reflect the person's birth and death dates.
   */
  Flourish,

  /**
   * A fact of a person's funeral.
   */
  Funeral,
  Illness,
  Immigration,
  Interment,
  Living,
  MaritalStatus,
  MilitaryAward,
  MilitaryCompany,
  MilitaryDischarge,
  MilitaryRank,
  MilitaryRegiment,
  MilitaryService,
  MilitaryServiceBranch,
  Mission,
  Move,
  NameOfShip,
  Naturalization,
  Namesake,
  NationalId,
  Nationality,
  NeverHadChildren,
  NeverMarried,
  NotAccountable,
  Occupation,
  Ordinance,
  Ordination,
  PhysicalDescription,
  PortOfDeparture,
  PreviousResidence,
  Probate,
  Property,
  RelationshipToHead,
  Religion,
  Residence,
  Retirement,
  SocialSecurityNumber,
  Stillborn,
  TitleOfNobility,
  TribeName,
  Twin,
  Will,

  // facts generally applicable within the scope of a couple.

  /**
   * The fact of an annulment of a marriage.
   */
  Annulment,

  /**
   * The fact of a marriage by common law.
   */
  CommonLawMarriage,

  /**
   * The fact of a divorce of a couple.
   */
  Divorce,

  /**
   * The fact of a filing for divorce.
   */
  DivorceFiling,

  /**
   * The fact of an engagement to be married.
   */
  Engagement,
  Marriage,
  MarriageBanns,
  MarriageContract,
  MarriageIntent,
  MarriageLicense,
  MarriageNotice,
  MarriageSettlement,
  NumberOfChildren,
  Separation,
  UniversalId,

  // facts generally applicable within the scope of a parent-child relationship.
  // Adoption, (applicable on a person, too).
  Biological,
  Step,
  Foster,
  Guardianship,

  //facts generally applicable within the scope of a record.
  @XmlQNameEnumValue ( namespace = "http://record.gedcomx.org/")
  Household,
  @XmlQNameEnumValue ( namespace = "http://record.gedcomx.org/")
  BatchNumber,
  @XmlQNameEnumValue ( namespace = "http://record.gedcomx.org/")
  LineNumber,
  @XmlQNameEnumValue ( namespace = "http://record.gedcomx.org/")
  PageNumber,
  @XmlQNameEnumValue ( namespace = "http://record.gedcomx.org/")
  CertificateNumber,

  @XmlUnknownQNameEnumValue
  OTHER;

  public final static Set<FactType> BIRTHLIKE_FACT_TYPES = Collections.unmodifiableSet(EnumSet.of(Baptism, Birth, Christening, Blessing, Circumcision, Adoption));
  public final static Set<FactType> DEATHLIKE_FACT_TYPES = Collections.unmodifiableSet(EnumSet.of(Death, Burial, Cremation, Funeral, Interment, Probate, Will));
  public final static Set<FactType> MARRIAGELIKE_FACT_TYPES = Collections.unmodifiableSet(EnumSet.of(Marriage, Engagement, MarriageBanns, MarriageContract, MarriageLicense, MarriageNotice, MarriageSettlement));
  public final static Set<FactType> DIVORCELIKE_FACT_TYPES = Collections.unmodifiableSet(EnumSet.of(Divorce, DivorceFiling, Annulment, Separation));
  public final static Set<FactType> MIGRATIONLIKE_FACT_TYPES = Collections.unmodifiableSet(EnumSet.of(Immigration, Emigration, Naturalization, Move));

  public boolean isBirthLike() {
    return BIRTHLIKE_FACT_TYPES.contains(this);
  }

  public boolean isDeathLike() {
    return DEATHLIKE_FACT_TYPES.contains(this);
  }

  public boolean isMarriageLike() {
    return MARRIAGELIKE_FACT_TYPES.contains(this);
  }

  public boolean isDivorceLike() {
    return DIVORCELIKE_FACT_TYPES.contains(this);
  }

  public boolean isMigrationLike() {
    return MIGRATIONLIKE_FACT_TYPES.contains(this);
  }

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
  public static FactType fromQNameURI(URI qname) {
    return org.codehaus.enunciate.XmlQNameEnumUtil.fromURIValue(qname.toString(), FactType.class);
  }

  /**
   * Enumeration of types that are applicable to a person.
   */
  @XmlTransient
  public static final class Person {
    private Person(){}

    private static final EnumSet<FactType> PERSON_FACT_TYPES = EnumSet.noneOf(FactType.class);
    private static FactType include(FactType type) {
      PERSON_FACT_TYPES.add(type);
      return type;
    }
    
    public static final FactType Adoption = include(FactType.Adoption);
    public static final FactType AdultChristening = include(FactType.AdultChristening);
    public static final FactType Baptism = include(FactType.Baptism);
    public static final FactType BarMitzvah = include(FactType.BarMitzvah);
    public static final FactType BatMitzvah = include(FactType.BatMitzvah);
    public static final FactType Birth = include(FactType.Birth);
    public static final FactType Blessing = include(FactType.Blessing);
    public static final FactType Burial = include(FactType.Burial);
    public static final FactType Caste = include(FactType.Caste);
    public static final FactType Census = include(FactType.Census);
    public static final FactType Christening = include(FactType.Christening);
    public static final FactType Circumcision = include(FactType.Circumcision);
    public static final FactType Clan = include(FactType.Clan);
    public static final FactType Confirmation = include(FactType.Confirmation);
    public static final FactType Cremation = include(FactType.Cremation);
    public static final FactType Death = include(FactType.Death);
    public static final FactType Emigration = include(FactType.Emigration);
    public static final FactType Ethnicity = include(FactType.Ethnicity);
    public static final FactType Excommunication = include(FactType.Excommunication);
    public static final FactType FirstCommunion = include(FactType.FirstCommunion);
    public static final FactType Flourish = include(FactType.Flourish);
    public static final FactType Funeral = include(FactType.Funeral);
    public static final FactType Education = include(FactType.Education);
    public static final FactType Illness = include(FactType.Illness);
    public static final FactType Immigration = include(FactType.Immigration);
    public static final FactType Interment = include(FactType.Interment);
    public static final FactType Household = include(FactType.Household);
    public static final FactType Living = include(FactType.Living);
    public static final FactType MaritalStatus = include(FactType.MaritalStatus);
    public static final FactType MilitaryAward = include(FactType.MilitaryAward);
    public static final FactType MilitaryCompany = include(FactType.MilitaryCompany);
    public static final FactType MilitaryDischarge = include(FactType.MilitaryDischarge);
    public static final FactType MilitaryRank = include(FactType.MilitaryRank);
    public static final FactType MilitaryRegiment = include(FactType.MilitaryRegiment);
    public static final FactType MilitaryService = include(FactType.MilitaryService);
    public static final FactType MilitaryServiceBranch = include(FactType.MilitaryServiceBranch);
    public static final FactType Mission = include(FactType.Mission);
    public static final FactType Move = include(FactType.Move);
    public static final FactType NameOfShip = include(FactType.NameOfShip);
    public static final FactType Naturalization = include(FactType.Naturalization);
    public static final FactType Namesake = include(FactType.Namesake);
    public static final FactType NationalId = include(FactType.NationalId);
    public static final FactType Nationality = include(FactType.Nationality);
    public static final FactType NeverHadChildren = include(FactType.NeverHadChildren);
    public static final FactType NeverMarried = include(FactType.NeverMarried);
    public static final FactType NotAccountable = include(FactType.NotAccountable);
    public static final FactType Occupation = include(FactType.Occupation);
    public static final FactType Ordinance = include(FactType.Ordinance);
    public static final FactType Ordination = include(FactType.Ordination);
    public static final FactType PhysicalDescription = include(FactType.PhysicalDescription);
    public static final FactType Probate = include(FactType.Probate);
    public static final FactType PortOfDeparture = include(FactType.PortOfDeparture);
    public static final FactType Property = include(FactType.Property);
    public static final FactType PreviousResidence = include(FactType.PreviousResidence);
    public static final FactType RelationshipToHead = include(FactType.RelationshipToHead);
    public static final FactType Religion = include(FactType.Religion);
    public static final FactType Residence = include(FactType.Residence);
    public static final FactType Retirement = include(FactType.Retirement);
    public static final FactType SocialSecurityNumber = include(FactType.SocialSecurityNumber);
    public static final FactType Stillborn = include(FactType.Stillborn);
    public static final FactType TitleOfNobility = include(FactType.TitleOfNobility);
    public static final FactType TribeName = include(FactType.TribeName);
    public static final FactType Twin = include(FactType.Twin);
    public static final FactType Will = include(FactType.Will);
    
    /**
     * Whether the given fact type is applicable to a person.
     * 
     * @param type The fact type.
     * @return Whether the given fact type is applicable to a person.
     */
    public static boolean isApplicable(FactType type) {
      return PERSON_FACT_TYPES.contains(type);
    }
  }

  @XmlTransient
  public static final class Couple {
    private Couple() {}

    private static final EnumSet<FactType> COUPLE_FACT_TYPES = EnumSet.noneOf(FactType.class);
    private static FactType include(FactType type) {
      COUPLE_FACT_TYPES.add(type);
      return type;
    }
    
    public static final FactType Annulment = include(FactType.Annulment);
    public static final FactType CommonLawMarriage = include(FactType.CommonLawMarriage);
    public static final FactType Divorce = include(FactType.Divorce);
    public static final FactType DivorceFiling = include(FactType.DivorceFiling);
    public static final FactType Engagement = include(FactType.Engagement);
    public static final FactType Marriage = include(FactType.Marriage);
    public static final FactType MarriageBanns = include(FactType.MarriageBanns);
    public static final FactType MarriageContract = include(FactType.MarriageContract);
    public static final FactType MarriageIntent = include(FactType.MarriageIntent);
    public static final FactType MarriageLicense = include(FactType.MarriageLicense);
    public static final FactType MarriageNotice = include(FactType.MarriageNotice);
    public static final FactType MarriageSettlement = include(FactType.MarriageSettlement);
    public static final FactType NumberOfChildren = include(FactType.NumberOfChildren);
    public static final FactType Separation = include(FactType.Separation);
    public static final FactType UniversalId = include(FactType.UniversalId);

    /**
     * Whether the given fact type is applicable to a couple.
     * 
     * @param type The fact type.
     * @return Whether the given fact type is applicable to a couple.
     */
    public static boolean isApplicable(FactType type) {
      return COUPLE_FACT_TYPES.contains(type);
    }
  }

  @XmlTransient
  public static final class ParentChild {
    private ParentChild() {}

    private static final EnumSet<FactType> PARENT_CHILD_FACT_TYPES = EnumSet.noneOf(FactType.class);
    private static FactType include(FactType type) {
      PARENT_CHILD_FACT_TYPES.add(type);
      return type;
    }
    
    public static final FactType Biological = include(FactType.Biological);
    public static final FactType Adopted = include(FactType.Adoption);
    public static final FactType Step = include(FactType.Step);
    public static final FactType Foster = include(FactType.Foster);
    public static final FactType Guardianship = include(FactType.Guardianship);

    /**
     * Whether the given fact type is applicable to a parent-child relationship.
     * 
     * @param type The fact type.
     * @return Whether the given fact type is applicable to a parent-child relationship.
     */
    public static boolean isApplicable(FactType type) {
      return PARENT_CHILD_FACT_TYPES.contains(type);
    }
  }

  @XmlTransient
  public static final class Record {
    private Record() {}

    private static final EnumSet<FactType> RECORD_FACT_TYPES = EnumSet.noneOf(FactType.class);
    private static FactType include(FactType type) {
      RECORD_FACT_TYPES.add(type);
      return type;
    }

    public static final FactType Household = include(FactType.Household);
    public static final FactType BatchNumber = include(FactType.BatchNumber);
    public static final FactType LineNumber = include(FactType.LineNumber);
    public static final FactType PageNumber = include(FactType.PageNumber);
    public static final FactType CertificateNumber = include(FactType.CertificateNumber);

    /**
     * Whether the given fact type is applicable to a record.
     *
     * @param type The fact type.
     * @return Whether the given fact type is applicable to a record.
     */
    public static boolean isApplicable(FactType type) {
      return RECORD_FACT_TYPES.contains(type);
    }
  }

}

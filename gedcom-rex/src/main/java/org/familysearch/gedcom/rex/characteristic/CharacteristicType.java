package org.familysearch.gedcom.rex.characteristic;

import org.familysearch.gedcom.GedcomConstants;

import javax.xml.bind.annotation.XmlTransient;
import javax.xml.namespace.QName;

/**
 * The known types of characteristic.  For characteristics not in the list, choose type "Other" and supply
 * a description.
 *
 * @author Merlin Carpenter
 *         Date: Aug 12, 2008
 */
@XmlTransient
public class CharacteristicType {

  private CharacteristicType() {}

  public static final QName ABUSUA = new QName(GedcomConstants.GEDCOM_TYPES_PERSON_CHARACTERISTIC_NAMESPACE, "abusua");
  public static final QName AGE = new QName(GedcomConstants.GEDCOM_TYPES_PERSON_CHARACTERISTIC_NAMESPACE, "age");
  public static final QName BATCH_NUM = new QName(GedcomConstants.GEDCOM_TYPES_PERSON_CHARACTERISTIC_NAMESPACE, "batch_number");
  public static final QName CASTE_NAME = new QName(GedcomConstants.GEDCOM_TYPES_PERSON_CHARACTERISTIC_NAMESPACE, "caste_name");
  public static final QName CLAN_NAME = new QName(GedcomConstants.GEDCOM_TYPES_PERSON_CHARACTERISTIC_NAMESPACE, "clan_name");
  public static final QName COUNT_OF_CHILDREN = new QName(GedcomConstants.GEDCOM_TYPES_PERSON_CHARACTERISTIC_NAMESPACE, "count_of_children");
  public static final QName COUNT_OF_MARRIAGES = new QName(GedcomConstants.GEDCOM_TYPES_PERSON_CHARACTERISTIC_NAMESPACE, "count_of_marriages");
  public static final QName DIED_BEFORE_EIGHT = new QName(GedcomConstants.GEDCOM_TYPES_PERSON_CHARACTERISTIC_NAMESPACE, "died_before_eight");
  public static final QName DWELLING = new QName(GedcomConstants.GEDCOM_TYPES_PERSON_CHARACTERISTIC_NAMESPACE, "dwelling");
  public static final QName EXISTS = new QName(GedcomConstants.GEDCOM_TYPES_PERSON_CHARACTERISTIC_NAMESPACE, "exists");
  public static final QName GEDCOM_ID = new QName(GedcomConstants.GEDCOM_TYPES_PERSON_CHARACTERISTIC_NAMESPACE, "gedcom_id");
  public static final QName HOUSEHOLD = new QName(GedcomConstants.GEDCOM_TYPES_PERSON_CHARACTERISTIC_NAMESPACE, "household");
  public static final QName MARITAL_STATUS = new QName(GedcomConstants.GEDCOM_TYPES_PERSON_CHARACTERISTIC_NAMESPACE, "marital_status");
  public static final QName NAME_SAKE = new QName(GedcomConstants.GEDCOM_TYPES_PERSON_CHARACTERISTIC_NAMESPACE, "namesake");
  public static final QName NATIONAL_ID = new QName(GedcomConstants.GEDCOM_TYPES_PERSON_CHARACTERISTIC_NAMESPACE, "national_id");
  public static final QName NATIONAL_ORIGIN = new QName(GedcomConstants.GEDCOM_TYPES_PERSON_CHARACTERISTIC_NAMESPACE, "national_origin");
  public static final QName NOT_ACCOUNTABLE = new QName(GedcomConstants.GEDCOM_TYPES_PERSON_CHARACTERISTIC_NAMESPACE, "not_accountable");
  public static final QName OCCUPATION = new QName(GedcomConstants.GEDCOM_TYPES_PERSON_CHARACTERISTIC_NAMESPACE, "occupation");
  public static final QName PERSON_NEVER_HAD_CHILDREN = new QName(GedcomConstants.GEDCOM_TYPES_PERSON_CHARACTERISTIC_NAMESPACE, "never_had_children");
  public static final QName PERSON_NEVER_MARRIED = new QName(GedcomConstants.GEDCOM_TYPES_PERSON_CHARACTERISTIC_NAMESPACE, "never_married");
  public static final QName PHYSICAL_DESCRIPTION = new QName(GedcomConstants.GEDCOM_TYPES_PERSON_CHARACTERISTIC_NAMESPACE, "physical_description");
  public static final QName POSSESSIONS = new QName(GedcomConstants.GEDCOM_TYPES_PERSON_CHARACTERISTIC_NAMESPACE, "possessions");
  public static final QName RACE = new QName(GedcomConstants.GEDCOM_TYPES_PERSON_CHARACTERISTIC_NAMESPACE, "race");
  public static final QName RELIGIOUS_AFFILIATION = new QName(GedcomConstants.GEDCOM_TYPES_PERSON_CHARACTERISTIC_NAMESPACE, "religious_affiliation");
  public static final QName SCHOLASTIC_ACHIEVEMENT = new QName(GedcomConstants.GEDCOM_TYPES_PERSON_CHARACTERISTIC_NAMESPACE, "scholastic_achievement");
  public static final QName SOCIAL_SECURITY_NUMBER = new QName(GedcomConstants.GEDCOM_TYPES_PERSON_CHARACTERISTIC_NAMESPACE, "social_security_number");
  public static final QName STILLBORN = new QName(GedcomConstants.GEDCOM_TYPES_PERSON_CHARACTERISTIC_NAMESPACE, "stillborn");
  public static final QName TEMPLE_CODE = new QName(GedcomConstants.GEDCOM_TYPES_PERSON_CHARACTERISTIC_NAMESPACE, "temple_code");
  public static final QName TITLE_OF_NOBILITY = new QName(GedcomConstants.GEDCOM_TYPES_PERSON_CHARACTERISTIC_NAMESPACE, "title_of_nobility");
  public static final QName TRIBE_NAME = new QName(GedcomConstants.GEDCOM_TYPES_PERSON_CHARACTERISTIC_NAMESPACE, "tribe_name");
  public static final QName TWIN = new QName(GedcomConstants.GEDCOM_TYPES_PERSON_CHARACTERISTIC_NAMESPACE, "twin");

  // couple characteristic types
  public static final QName COMMON_LAW_MARRIAGE = new QName(GedcomConstants.GEDCOM_TYPES_COUPLE_CHARACTERISTIC_NAMESPACE, "common_law_marriage");
  public static final QName COUPLE_UNIVERSAL_ID = new QName(GedcomConstants.GEDCOM_TYPES_COUPLE_CHARACTERISTIC_NAMESPACE, "universal_id");
  public static final QName CURRENTLY_SPOUSES = new QName(GedcomConstants.GEDCOM_TYPES_COUPLE_CHARACTERISTIC_NAMESPACE, "currently_spouses");
  public static final QName NEVER_HAD_CHILDREN = new QName(GedcomConstants.GEDCOM_TYPES_COUPLE_CHARACTERISTIC_NAMESPACE, "never_had_children");
  public static final QName NEVER_MARRIED = new QName(GedcomConstants.GEDCOM_TYPES_COUPLE_CHARACTERISTIC_NAMESPACE, "never_married");
  public static final QName NUMBER_OF_CHILDREN = new QName(GedcomConstants.GEDCOM_TYPES_COUPLE_CHARACTERISTIC_NAMESPACE, "number_of_children");
}

package org.familysearch.gedcom.rex.record;

import org.familysearch.gedcom.GedcomConstants;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.namespace.QName;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * The "type" of record
 *
 * @author Merlin Carpenter
 *         Date: Jul 30, 2008
 */
@XmlTransient
public class RecordType {

  private RecordType() {}

  // root level record types
  public static final QName CENSUS = new QName(GedcomConstants.GEDCOM_TYPES_RECORD_NAMESPACE, "census");
  public static final QName LEGAL = new QName(GedcomConstants.GEDCOM_TYPES_RECORD_NAMESPACE, "legal");
  public static final QName MIGRATION = new QName(GedcomConstants.GEDCOM_TYPES_RECORD_NAMESPACE, "migration");
  public static final QName MILITARY = new QName(GedcomConstants.GEDCOM_TYPES_RECORD_NAMESPACE, "military");
  public static final QName VITAL = new QName(GedcomConstants.GEDCOM_TYPES_RECORD_NAMESPACE, "vital");

  // "VITAL" types
  public static final QName BIRTH = new QName(GedcomConstants.GEDCOM_TYPES_RECORD_VITAL_NAMESPACE, "birth");
  public static final QName DEATH = new QName(GedcomConstants.GEDCOM_TYPES_RECORD_VITAL_NAMESPACE, "death");
  public static final QName MARRIAGE = new QName(GedcomConstants.GEDCOM_TYPES_RECORD_VITAL_NAMESPACE, "marriage");
  public static final Set<QName> VITAL_TYPES = Collections.unmodifiableSet(new HashSet<QName>(Arrays.asList(BIRTH, DEATH, MARRIAGE)));

  // "LEGAL" types
  public static final QName BANK = new QName(GedcomConstants.GEDCOM_TYPES_RECORD_LEGAL_NAMESPACE, "bank");
  public static final QName LAND = new QName(GedcomConstants.GEDCOM_TYPES_RECORD_LEGAL_NAMESPACE, "land");
  public static final QName PROBATE = new QName(GedcomConstants.GEDCOM_TYPES_RECORD_LEGAL_NAMESPACE, "probate");
  public static final QName TAX = new QName(GedcomConstants.GEDCOM_TYPES_RECORD_LEGAL_NAMESPACE, "tax");
  public static final Set<QName> LEGAL_TYPES = Collections.unmodifiableSet(new HashSet<QName>(Arrays.asList(BANK, LAND, PROBATE, TAX)));

  // "MILITARY" types
  public static final QName DRAFT = new QName(GedcomConstants.GEDCOM_TYPES_RECORD_MILITARY_NAMESPACE, "draft");
  public static  final QName PENSION = new QName(GedcomConstants.GEDCOM_TYPES_RECORD_MILITARY_NAMESPACE, "pension");
  public static final QName ROLL = new QName(GedcomConstants.GEDCOM_TYPES_RECORD_MILITARY_NAMESPACE, "roll");
  public static final Set<QName> MILITARY_TYPES = Collections.unmodifiableSet(new HashSet<QName>(Arrays.asList(DRAFT, PENSION, ROLL)));

}

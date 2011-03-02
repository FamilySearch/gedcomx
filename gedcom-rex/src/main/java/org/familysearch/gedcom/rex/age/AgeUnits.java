package org.familysearch.gedcom.rex.age;

import org.familysearch.gedcom.GedcomConstants;

import javax.xml.bind.annotation.XmlTransient;
import javax.xml.namespace.QName;

/**
 * @author Ryan Heaton
 */
@XmlTransient
public class AgeUnits {

  private AgeUnits() {}

  public static final QName YEARS = new QName(GedcomConstants.GEDCOM_TYPES_AGE_UNIT_NAMESPACE, "years");
  public static final QName MONTHS = new QName(GedcomConstants.GEDCOM_TYPES_AGE_UNIT_NAMESPACE, "months");
  public static final QName DAYS = new QName(GedcomConstants.GEDCOM_TYPES_AGE_UNIT_NAMESPACE, "days");
  public static final QName HOURS = new QName(GedcomConstants.GEDCOM_TYPES_AGE_UNIT_NAMESPACE, "hours");
  public static final QName MINUTES = new QName(GedcomConstants.GEDCOM_TYPES_AGE_UNIT_NAMESPACE, "minutes");

}

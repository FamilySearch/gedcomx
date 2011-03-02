package org.familysearch.gedcom.rex.date;

import org.familysearch.gedcom.GedcomConstants;

import javax.xml.bind.annotation.XmlTransient;
import javax.xml.namespace.QName;

/**
 * The "type" of date part
 *
 * @author Merlin Carpenter
 *         Date: Aug 14, 2008
 */
@XmlTransient
public class DatePartType {

  private DatePartType() {}

  public static final QName YEAR = new QName(GedcomConstants.GEDCOM_TYPES_DATE_PART_NAMESPACE, "year");
  public static final QName MONTH = new QName(GedcomConstants.GEDCOM_TYPES_DATE_PART_NAMESPACE, "month");
  public static final QName DAY = new QName(GedcomConstants.GEDCOM_TYPES_DATE_PART_NAMESPACE, "day");

}

package org.familysearch.gedcom.rex.place;

import org.familysearch.gedcom.GedcomConstants;

import javax.xml.bind.annotation.XmlTransient;
import javax.xml.namespace.QName;

/**
 * the "type" of place part
 *
 * @author Merlin Carpenter
 *         Date: Aug 14, 2008
 */
@XmlTransient
public class PlacePartType {

  private PlacePartType() {}

  public static final QName COUNTRY = new QName(GedcomConstants.GEDCOM_TYPES_PLACE_NAMESPACE, "country");
  public static final QName STATE = new QName(GedcomConstants.GEDCOM_TYPES_PLACE_NAMESPACE, "state");
  public static final QName PROVINCE = new QName(GedcomConstants.GEDCOM_TYPES_PLACE_NAMESPACE, "province");
  public static final QName COUNTY = new QName(GedcomConstants.GEDCOM_TYPES_PLACE_NAMESPACE, "county");
  public static final QName CITY = new QName(GedcomConstants.GEDCOM_TYPES_PLACE_NAMESPACE, "city");
  public static final QName TOWN = new QName(GedcomConstants.GEDCOM_TYPES_PLACE_NAMESPACE, "town");
  public static final QName PARISH = new QName(GedcomConstants.GEDCOM_TYPES_PLACE_NAMESPACE, "parish");

}

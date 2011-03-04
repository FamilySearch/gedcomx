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
  public static final QName TERRITORY = new QName(GedcomConstants.GEDCOM_TYPES_PLACE_NAMESPACE, "territory");
  public static final QName DISTRICT = new QName(GedcomConstants.GEDCOM_TYPES_PLACE_NAMESPACE, "district");
  public static final QName TOWNSHIP = new QName(GedcomConstants.GEDCOM_TYPES_PLACE_NAMESPACE, "township");
  public static final QName WARD = new QName(GedcomConstants.GEDCOM_TYPES_PLACE_NAMESPACE, "ward");
  public static final QName SECTION = new QName(GedcomConstants.GEDCOM_TYPES_PLACE_NAMESPACE, "section");
  public static final QName ISLAND = new QName(GedcomConstants.GEDCOM_TYPES_PLACE_NAMESPACE, "island");
  public static final QName CHURCH = new QName(GedcomConstants.GEDCOM_TYPES_PLACE_NAMESPACE, "church");
  public static final QName CEMETERY = new QName(GedcomConstants.GEDCOM_TYPES_PLACE_NAMESPACE, "cemetery");
  public static final QName PLOT_NUMBER = new QName(GedcomConstants.GEDCOM_TYPES_PLACE_NAMESPACE, "plot_number");
  public static final QName MORTUARY = new QName(GedcomConstants.GEDCOM_TYPES_PLACE_NAMESPACE, "mortuary");
  public static final QName SHIP = new QName(GedcomConstants.GEDCOM_TYPES_PLACE_NAMESPACE, "ship");
  public static final QName POST_OFFICE = new QName(GedcomConstants.GEDCOM_TYPES_PLACE_NAMESPACE, "post_office");
  public static final QName HOSPITAL = new QName(GedcomConstants.GEDCOM_TYPES_PLACE_NAMESPACE, "hospital");
  public static final QName ADDRESS = new QName(GedcomConstants.GEDCOM_TYPES_PLACE_NAMESPACE, "address");
  public static final QName POSTAL_CODE = new QName(GedcomConstants.GEDCOM_TYPES_PLACE_NAMESPACE, "postal_code");
  public static final QName MILITARY_BASE = new QName(GedcomConstants.GEDCOM_TYPES_PLACE_NAMESPACE, "military_base");
  public static final QName PRISON = new QName(GedcomConstants.GEDCOM_TYPES_PLACE_NAMESPACE, "prison");

}

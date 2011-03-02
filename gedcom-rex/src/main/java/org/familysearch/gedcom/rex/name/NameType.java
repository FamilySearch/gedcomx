package org.familysearch.gedcom.rex.name;

import org.familysearch.gedcom.GedcomConstants;

import javax.xml.bind.annotation.XmlTransient;
import javax.xml.namespace.QName;

/**
 * the "type" of name
 *
 * @author Merlin Carpenter
 *         Date: Sep 17, 2008
 */
@XmlTransient
public class NameType {

  private NameType() {}

  public static final QName NAME = new QName(GedcomConstants.GEDCOM_TYPES_NAME_NAMESPACE, "name");
  public static final QName ALSO_KNOWN_AS = new QName(GedcomConstants.GEDCOM_TYPES_NAME_NAMESPACE, "also_known_as");
  public static final QName MAIDEN_NAME = new QName(GedcomConstants.GEDCOM_TYPES_NAME_NAMESPACE, "maiden_name");
  public static final QName MARRIED_NAME = new QName(GedcomConstants.GEDCOM_TYPES_NAME_NAMESPACE, "married_name");
  public static final QName NICKNAME = new QName(GedcomConstants.GEDCOM_TYPES_NAME_NAMESPACE, "nickname");
  public static final QName ADOPTIVE = new QName(GedcomConstants.GEDCOM_TYPES_NAME_NAMESPACE, "adoptive");
  public static final QName FORMAL = new QName(GedcomConstants.GEDCOM_TYPES_NAME_NAMESPACE, "formal");
  public static final QName RELIGIOUS = new QName(GedcomConstants.GEDCOM_TYPES_NAME_NAMESPACE, "religious");

}

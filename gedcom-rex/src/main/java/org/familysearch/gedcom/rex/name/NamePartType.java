package org.familysearch.gedcom.rex.name;

import org.familysearch.gedcom.GedcomConstants;

import javax.xml.bind.annotation.XmlTransient;
import javax.xml.namespace.QName;

/**
 * the "type" of name part (when a name was given in parts on the original record)
 *
 * @author Merlin Carpenter
 *         Date: Aug 14, 2008
 */
@XmlTransient
public class NamePartType {

  private NamePartType() {}

  public static final QName PREFIX = new QName(GedcomConstants.GEDCOM_TYPES_NAME_PART_NAMESPACE, "prefix");
  public static final QName SUFFIX = new QName(GedcomConstants.GEDCOM_TYPES_NAME_PART_NAMESPACE, "suffix");
  public static final QName GIVEN = new QName(GedcomConstants.GEDCOM_TYPES_NAME_PART_NAMESPACE, "given");
  public static final QName SURNAME = new QName(GedcomConstants.GEDCOM_TYPES_NAME_PART_NAMESPACE, "surname");

}

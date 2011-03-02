package org.familysearch.gedcom.rex.record;

import org.familysearch.gedcom.GedcomConstants;

import javax.xml.bind.annotation.XmlTransient;
import javax.xml.namespace.QName;

/**
 * the type of role a person plays in an event
 *
 * @author Merlin Carpenter
 *         Date: Aug 14, 2008
 */
@XmlTransient
public class RoleType {

  private RoleType() {}

  public static final QName PRINCIPAL = new QName(GedcomConstants.GEDCOM_TYPES_EVENT_ROLE_NAMESPACE, "principal"); // main person in an event (or main 2 people in a couple event such as marriage).
  public static final QName FATHER = new QName(GedcomConstants.GEDCOM_TYPES_EVENT_ROLE_NAMESPACE, "father");
  public static final QName MOTHER = new QName(GedcomConstants.GEDCOM_TYPES_EVENT_ROLE_NAMESPACE, "mother");
  public static final QName INFORMANT = new QName(GedcomConstants.GEDCOM_TYPES_EVENT_ROLE_NAMESPACE, "informant");
  public static final QName REGISTRAR = new QName(GedcomConstants.GEDCOM_TYPES_EVENT_ROLE_NAMESPACE, "registrar");
  public static final QName MEMBER = new QName(GedcomConstants.GEDCOM_TYPES_EVENT_ROLE_NAMESPACE, "member");

}

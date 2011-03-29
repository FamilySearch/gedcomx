package org.familysearch.gedcom.rex.relationship;

import javax.xml.bind.annotation.XmlTransient;
import javax.xml.namespace.QName;
import org.familysearch.gedcom.GedcomConstants;

/**
 * @author Jeff Phillips
 * Date: Feb 16, 2011
 */
@XmlTransient
public class RelationshipRole {
  private RelationshipRole(){}

  //todo: others?
  public static final QName GRANDPARENT = new QName(GedcomConstants.GEDCOM_TYPES_RELATIONSHIP_ROLE_NAMESPACE, "grandparent");
  public static final QName GRANDCHILD = new QName(GedcomConstants.GEDCOM_TYPES_RELATIONSHIP_ROLE_NAMESPACE, "grandchild");
  public static final QName ANCESTOR = new QName(GedcomConstants.GEDCOM_TYPES_RELATIONSHIP_ROLE_NAMESPACE, "ancestor");
  public static final QName DESCENDANT = new QName(GedcomConstants.GEDCOM_TYPES_RELATIONSHIP_ROLE_NAMESPACE, "descendant");
  public static final QName COUSIN = new QName(GedcomConstants.GEDCOM_TYPES_RELATIONSHIP_ROLE_NAMESPACE, "cousin");
  public static final QName IN_LAW = new QName(GedcomConstants.GEDCOM_TYPES_RELATIONSHIP_ROLE_NAMESPACE, "in_law");

}
package org.familysearch.gedcom.rex.relationship;

import org.familysearch.gedcom.GedcomConstants;

import javax.xml.bind.annotation.XmlTransient;
import javax.xml.namespace.QName;

/**
 * the "lineage" type of relationship between a parent and child
 *
 * @author Merlin Carpenter
 *         Date: Sep 16, 2008
 */
@XmlTransient
public class LineageType {

  private LineageType() {}

  public static final QName BIOLOGICAL = new QName(GedcomConstants.GEDCOM_TYPES_RELATIONSHIP_LINEAGE_NAMESPACE, "biological");
  public static final QName ADOPTED = new QName(GedcomConstants.GEDCOM_TYPES_RELATIONSHIP_LINEAGE_NAMESPACE, "adopted");
  public static final QName STEP = new QName(GedcomConstants.GEDCOM_TYPES_RELATIONSHIP_LINEAGE_NAMESPACE, "step");
  public static final QName FOSTER = new QName(GedcomConstants.GEDCOM_TYPES_RELATIONSHIP_LINEAGE_NAMESPACE, "foster");
  public static final QName GUARDIANSHIP = new QName(GedcomConstants.GEDCOM_TYPES_RELATIONSHIP_LINEAGE_NAMESPACE, "guardianship");
  public static final QName SEALING = new QName(GedcomConstants.GEDCOM_TYPES_RELATIONSHIP_LINEAGE_NAMESPACE, "sealing");

}

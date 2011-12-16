package org.familysearch.ct.ws;

import org.codehaus.jackson.annotate.JsonTypeInfo;
import org.codehaus.jackson.map.annotate.JsonTypeIdResolver;
import org.gedcomx.common.GenealogicalEntity;
import org.gedcomx.conclusion.Relationship;
import org.gedcomx.rt.JsonElementWrapper;
import org.gedcomx.rt.XmlTypeIdResolver;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * The ternary relationship manages all information that is relevant to the grouping of a child, father, and mother.
 *
 * @author Ron Tanner
 * @author Joe Martel
 * @author NOT Ryan Heaton
 */
@XmlRootElement
@JsonElementWrapper( name = "relationships" )
@JsonTypeInfo ( use =JsonTypeInfo.Id.CUSTOM, property = XmlTypeIdResolver.TYPE_PROPERTY_NAME)
@JsonTypeIdResolver (XmlTypeIdResolver.class)
@XmlType ( name = "TernaryRelationship", propOrder = { "childToFatherRelationship", "childToMotherRelationship" } )
public class TernaryRelationship extends GenealogicalEntity {

  private Relationship childToFatherRelationship;
  private Relationship childToMotherRelationship;

  /**
   * The relationship of the child to the father.
   *
   * @return The relationship of the child to the father.
   */
  public Relationship getChildToFatherRelationship() {
    return childToFatherRelationship;
  }

  /**
   * The relationship of the child to the father.
   *
   * @param childToFatherRelationship The relationship of the child to the father.
   */
  public void setChildToFatherRelationship(Relationship childToFatherRelationship) {
    this.childToFatherRelationship = childToFatherRelationship;
  }

  /**
   * The relationship of the child to the mother.
   *
   * @return The relationship of the child to the mother.
   */
  public Relationship getChildToMotherRelationship() {
    return childToMotherRelationship;
  }

  /**
   * The relationship of the child to the mother.
   *
   * @param childToMotherRelationship The relationship of the child to the mother.
   */
  public void setChildToMotherRelationship(Relationship childToMotherRelationship) {
    this.childToMotherRelationship = childToMotherRelationship;
  }
}

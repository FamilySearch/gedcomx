package org.familysearch.ct.www.impl;

import org.codehaus.jackson.annotate.JsonTypeInfo;
import org.codehaus.jackson.map.annotate.JsonTypeIdResolver;
import org.familysearch.ct.TernaryRelationship;
import org.gedcomx.common.ResourceSet;
import org.gedcomx.rt.JsonExtensionElement;
import org.gedcomx.rt.XmlTypeIdResolver;
import org.gedcomx.rs.Link;

import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;

/**
 * WWW wrapper for the ternary relationship.
 *
 * @author Ryan Heaton
 */
@XmlRootElement (name = "ternaryRelationship")
@JsonExtensionElement
@JsonTypeInfo ( use =JsonTypeInfo.Id.CUSTOM, property = XmlTypeIdResolver.TYPE_PROPERTY_NAME)
@JsonTypeIdResolver (XmlTypeIdResolver.class)
@XmlType ( name = "TernaryRelationship", propOrder = {"ternaryRelationship", "metadata"})
@XmlSeeAlso ({Link.class})
public final class TernaryRelationshipWrapper {

  private TernaryRelationship ternaryRelationship;
  private ResourceSet metadata;

  /**
   * The ternary relationship.
   *
   * @return The ternary relationship.
   */
  @XmlElementRef
  public TernaryRelationship getTernaryRelationship() {
    return ternaryRelationship;
  }

  /**
   * The ternary relationship.
   *
   * @param ternaryRelationship The ternary relationship.
   */
  public void setTernaryRelationship(TernaryRelationship ternaryRelationship) {
    this.ternaryRelationship = ternaryRelationship;
  }

  /**
   * The metadata associated with the relationship.
   *
   * @return The metadata associated with the relationship.
   */
  public ResourceSet getMetadata() {
    return metadata;
  }

  /**
   * The metadata associated with the relationship.
   *
   * @param metadata The metadata associated with the relationship.
   */
  public void setMetadata(ResourceSet metadata) {
    this.metadata = metadata;
  }
}

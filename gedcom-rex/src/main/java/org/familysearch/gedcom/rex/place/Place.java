package org.familysearch.gedcom.rex.place;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlType;

/**
 * @author Merlin Carpenter
 *         Place: Jul 30, 2008
 */
@XmlType(propOrder = {"original", "interpreted", "normalized"})
public class Place {

  private String id;
  private PlaceValue original;
  private PlaceValue interpreted;
  private PlaceValue normalized;

  public Place() {
  }

  @XmlID
  @XmlAttribute
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  @XmlElement
  public PlaceValue getOriginal() {
    return original;
  }

  public void setOriginal(PlaceValue original) {
    this.original = original;
  }

  @XmlElement
  public PlaceValue getInterpreted() {
    return interpreted;
  }

  public void setInterpreted(PlaceValue interpreted) {
    this.interpreted = interpreted;
  }

  @XmlElement
  public PlaceValue getNormalized() {
    return normalized;
  }

  public void setNormalized(PlaceValue normalized) {
    this.normalized = normalized;
  }

}

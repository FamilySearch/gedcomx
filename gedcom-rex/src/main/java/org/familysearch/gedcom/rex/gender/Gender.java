package org.familysearch.gedcom.rex.gender;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlType;

/**
 * @author Merlin Carpenter
 *         Date: Jul 30, 2008
 */
@XmlType(propOrder = {"original", "interpreted", "normalized"})
public class Gender {

  private String id;
  private GenderValue original;
  private GenderValue interpreted;
  private GenderValue normalized;

  public Gender() {
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
  public GenderValue getOriginal() {
    return original;
  }

  public void setOriginal(GenderValue original) {
    this.original = original;
  }

  @XmlElement
  public GenderValue getInterpreted() {
    return interpreted;
  }

  public void setInterpreted(GenderValue interpreted) {
    this.interpreted = interpreted;
  }

  @XmlElement
  public GenderValue getNormalized() {
    return normalized;
  }

  public void setNormalized(GenderValue normalized) {
    this.normalized = normalized;
  }

}

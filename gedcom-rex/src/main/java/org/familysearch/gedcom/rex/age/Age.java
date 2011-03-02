package org.familysearch.gedcom.rex.age;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlType;

/**
 * @author Merlin Carpenter
 *         Date: Jul 30, 2008
 */
@XmlType(propOrder = {"original", "interpreted", "normalized"})
public class Age {

  private String id;
  private AgeValue original;
  private AgeValue interpreted;
  private AgeValue normalized;

  public Age() {
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
  public AgeValue getOriginal() {
    return original;
  }

  public void setOriginal(AgeValue original) {
    this.original = original;
  }

  @XmlElement
  public AgeValue getInterpreted() {
    return interpreted;
  }

  public void setInterpreted(AgeValue interpreted) {
    this.interpreted = interpreted;
  }

  @XmlElement
  public AgeValue getNormalized() {
    return normalized;
  }

  public void setNormalized(AgeValue normalized) {
    this.normalized = normalized;
  }

}

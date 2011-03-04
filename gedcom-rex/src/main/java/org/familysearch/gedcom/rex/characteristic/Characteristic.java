package org.familysearch.gedcom.rex.characteristic;

import org.familysearch.gedcom.rex.Value;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlID;
import javax.xml.namespace.QName;

/**
 * Class representing characteristics (attributes) of something.
 * Author: Randy Wilson
 * Date: Aug 5, 2008
 */
public class Characteristic {

  private String id;
  private QName type;
  private Value original;
  private Value interpreted;
  private Value normalized;

  public Characteristic() {
  }

  @XmlID
  @XmlAttribute
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  @XmlAttribute(name = "type")
  public QName getType() {
    return type;
  }

  public void setType(QName type) {
    this.type = type;
  }

  @XmlElement
  public Value getOriginal() {
    return original;
  }

  public void setOriginal(Value original) {
    this.original = original;
  }

  @XmlElement
  public Value getInterpreted() {
    return interpreted;
  }

  public void setInterpreted(Value interpreted) {
    this.interpreted = interpreted;
  }

  @XmlElement
  public Value getNormalized() {
    return normalized;
  }

  public void setNormalized(Value normalized) {
    this.normalized = normalized;
  }

}

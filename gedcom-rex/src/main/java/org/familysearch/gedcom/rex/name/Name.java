package org.familysearch.gedcom.rex.name;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlType;
import javax.xml.namespace.QName;

/**
 * @author Merlin Carpenter
 *         Date: Jul 30, 2008
 */
@XmlType(propOrder = {"original", "interpreted", "normalized"})
public class Name {

  private String id;
  private QName type = NameType.NAME;
  private QName genre;
  private NameValue original;
  private NameValue interpreted;
  private NameValue normalized;

  public Name() {
  }

  @XmlID
  @XmlAttribute
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  @XmlAttribute
  public QName getType() {
    return type;
  }

  public void setType(QName type) {
    this.type = type;
  }

  @XmlAttribute
  public QName getGenre() {
    return genre;
  }

  public void setGenre(QName genre) {
    this.genre = genre;
  }

  @XmlElement
  public NameValue getOriginal() {
    return original;
  }

  public void setOriginal(NameValue original) {
    this.original = original;
  }

  @XmlElement
  public NameValue getNormalized() {
    return normalized;
  }

  public void setNormalized(NameValue normalized) {
    this.normalized = normalized;
  }

  @XmlElement
  public NameValue getInterpreted() {
    return interpreted;
  }

  public void setInterpreted(NameValue interpreted) {
    this.interpreted = interpreted;
  }

}

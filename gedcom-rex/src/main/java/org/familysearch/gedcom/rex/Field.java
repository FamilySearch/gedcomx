package org.familysearch.gedcom.rex;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlID;

/**
 * @author Jeff Phillips
 * Date: Mar 24, 2011
 */
public class Field {

  private String id;
  private String fieldId;
  private String original;
  private String interpreted;
  private String normalized;

  public Field() {
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
  public String getFieldId() {
    return fieldId;
  }

  public void setFieldId(String fieldId) {
    this.fieldId = fieldId;
  }

  /**
   * @return the original
   */
  @XmlElement
  public String getOriginal() {
    return original;
  }

  /**
   * @param original the original to set
   */
  public void setOriginal(String original) {
    this.original = original;
  }

  /**
   * @return the interpreted
   */
  @XmlElement
  public String getInterpreted() {
    return interpreted;
  }

  /**
   * @param interpreted the interpreted to set
   */
  public void setInterpreted(String interpreted) {
    this.interpreted = interpreted;
  }

  /**
   * @return the normalized
   */
  @XmlElement
  public String getNormalized() {
    return normalized;
  }

  /**
   * @param normalized the normalized to set
   */
  public void setNormalized(String normalized) {
    this.normalized = normalized;
  }

}

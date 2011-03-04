package org.familysearch.gedcom.rex;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlID;

/**
 * @author Merlin Carpenter
 *         Date: Aug 14, 2008
 */
public class Field {

  private String id;
  private String text;
  private String fieldId;

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

  @XmlElement
  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  @XmlElement
  public String getFieldId() {
    return fieldId;
  }

  public void setFieldId(String fieldId) {
    this.fieldId = fieldId;
  }

}

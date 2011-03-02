package org.familysearch.gedcom.rex;

import javax.xml.bind.annotation.*;

/**
 * @author CarpenterMP
 *         Date: Jul 13, 2009
 */
@XmlType(name = "text")
@XmlAccessorType
public abstract class Part {

  private String id;
  private String text;
  private String fieldId;

  public Part() {
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

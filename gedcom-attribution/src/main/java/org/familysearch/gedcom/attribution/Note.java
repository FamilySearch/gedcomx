package org.familysearch.gedcom.attribution;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;

/**
 * @author CarpenterMP
 *         Date: Nov 5, 2009
 */
@XmlRootElement
public class Note {

  /**
   * reference to the note
   */
  private String ref;

  /**
   * the text of the note
   */
  private String text;

  public Note() {
  }

  @XmlAttribute
  public String getRef() {
    return ref;
  }

  public void setRef(String ref) {
    this.ref = ref;
  }

  @XmlValue
  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

}

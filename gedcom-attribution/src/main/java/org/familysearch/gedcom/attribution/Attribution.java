package org.familysearch.gedcom.attribution;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import java.util.List;

/**
 * @author Merlin Carpenter
 *         Date: Aug 13, 2008
 */
public class Attribution {

  private String ref;
  private Confidence confidence;
  private Reason reason;
  private List<Basis> basis;
  private List<Note> notes;

  public Attribution() {
  }

  @XmlAttribute
  public String getRef() {
    return ref;
  }

  public void setRef(String ref) {
    this.ref = ref;
  }

  @XmlAttribute
  public Confidence getConfidence() {
    return confidence;
  }

  public void setConfidence(Confidence confidence) {
    this.confidence = confidence;
  }

  @XmlElement
  public Reason getReason() {
    return reason;
  }

  public void setReason(Reason reason) {
    this.reason = reason;
  }

  @XmlElement(name = "basis")
  public List<Basis> getBasis() {
    return basis;
  }

  public void setBasis(List<Basis> basis) {
    this.basis = basis;
  }

  @XmlElement(name = "note")
  public List<Note> getNotes() {
    return notes;
  }

  public void setNotes(List<Note> notes) {
    this.notes = notes;
  }

}

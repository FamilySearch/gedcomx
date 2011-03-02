package org.familysearch.gedcom.attribution;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlID;
import java.util.Date;
import java.util.List;

/**
 * @author Merlin Carpenter
 *         Date: Mar 10, 2009
 */
public class Contribution {

  private String id;
  private String ref;
  private Contributor contributor;
  private Process process;
  private Date timestamp;
  private List<Note> notes;
  private List<Attribution> attributions;

  public Contribution() {
    this.timestamp = new Date(System.currentTimeMillis());
  }

  public Contribution(String id, Contributor contributor, Date timestamp) {
    this(id, contributor, null, timestamp);
  }

  public Contribution(String id, Process process, Date timestamp) {
    this(id, null, process, timestamp);
  }

  public Contribution(String id, Contributor contributor, Process process, Date timestamp) {
    this.id = id;
    this.contributor = contributor;
    this.process = process;
    this.timestamp = timestamp == null ? new Date(System.currentTimeMillis()) : timestamp;
  }

  @XmlAttribute
  @XmlID
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getRef() {
    return ref;
  }

  public void setRef(String ref) {
    this.ref = ref;
  }

  /**
   * gets the contributor that made the contribution
   *
   * @return the contributor that made the contribution
   */
  public Contributor getContributor() {
    return contributor;
  }

  public void setContributor(Contributor contributor) {
    this.contributor = contributor;
  }

  /**
   * gets the process that made the contribution
   *
   * @return the process that made the contribution
   */
  public Process getProcess() {
    return process;
  }

  public void setProcess(Process process) {
    this.process = process;
  }

  /**
   * gets the timestamp for when the contribution was made
   *
   * @return the timestamp for when the contribution was made
   */
  @XmlAttribute
  public Date getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(Date timestamp) {
    this.timestamp = timestamp;
  }

  @XmlElement(name = "note")
  public List<Note> getNotes() {
    return notes;
  }

  public void setNotes(List<Note> notes) {
    this.notes = notes;
  }

  @XmlElement(name = "attribution")
  public List<Attribution> getAttributions() {
    return attributions;
  }

  public void setAttributions(List<Attribution> attributions) {
    this.attributions = attributions;
  }
}

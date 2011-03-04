package org.familysearch.gedcom.rex.record;

import org.familysearch.gedcom.rex.event.Event;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlIDREF;

/**
 * @author Merlin Carpenter
 *         Date: Aug 8, 2008
 */
public class EventRole {

  private String id;
  private String description;
  private Event event;
  private Boolean principal;

  public EventRole() {
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
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  @XmlAttribute
  @XmlIDREF
  public Event getEvent() {
    return event;
  }

  public void setEvent(Event event) {
    this.event = event;
  }

  @XmlAttribute
  public Boolean getPrincipal() {
    return principal;
  }

  public void setPrincipal(Boolean principal) {
    this.principal = principal;
  }
}

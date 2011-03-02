package org.familysearch.gedcom.rex.record;

import org.familysearch.gedcom.rex.event.Event;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlIDREF;
import javax.xml.namespace.QName;

/**
 * @author Merlin Carpenter
 *         Date: Aug 8, 2008
 */
public class RoleInEvent {

  private String id;
  private QName roleType;
  private String description;
  private Event event;

  public RoleInEvent() {
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
  public QName getRoleType() {
    return roleType;
  }

  public void setRoleType(QName roleType) {
    this.roleType = roleType;
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

}

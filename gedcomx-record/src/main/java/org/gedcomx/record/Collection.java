package org.gedcomx.record;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlType;
import java.util.List;

@XmlType (
  name = "baseCollection",
  propOrder = { "alternateIds", "parent", "title", "description", "publisher" }
)
public class Collection {

  private String id;
  private List<AlternateId> alternateIds;
  private CollectionReference parent;
  private String title;
  private String description;
  private String publisher;
  //todo: support contents of this collection? records, images, and waypoints

  @XmlAttribute
  @XmlID
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  @XmlElement (name="alternateId")
  public List<AlternateId> getAlternateIds() {
    return alternateIds;
  }

  public void setAlternateIds(List<AlternateId> alternateIds) {
    this.alternateIds = alternateIds;
  }

  public CollectionReference getParent() {
    return parent;
  }

  public void setParent(CollectionReference parent) {
    this.parent = parent;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getPublisher() {
    return publisher;
  }

  public void setPublisher(String publisher) {
    this.publisher = publisher;
  }
}

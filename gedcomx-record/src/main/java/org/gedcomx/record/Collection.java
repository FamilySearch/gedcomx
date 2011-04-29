package org.gedcomx.record;

import org.gedcomx.www.Links;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlType (
  propOrder = { "parent", "title", "description", "publisher", "links" }
)
public class Collection {

  private String id;
  private CollectionReference parent;
  private String title;
  private String description;
  private String publisher;
  private Links links;

  @XmlAttribute
  @XmlID
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
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

  public Links getLinks() {
    return links;
  }

  public void setLinks(Links links) {
    this.links = links;
  }
}

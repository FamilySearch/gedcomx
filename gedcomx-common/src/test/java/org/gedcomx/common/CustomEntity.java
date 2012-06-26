package org.gedcomx.common;

import org.gedcomx.rt.json.JsonElementWrapper;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * @author Ryan Heaton
 */
@XmlRootElement
@JsonElementWrapper (name = "customEntities")
public class CustomEntity extends GenealogicalResource {

  private ResourceReference source;
  private URI refToSomething;
  private List<UniqueCustomKeyedItem> uniqueKeyedItems;
  private List<CustomKeyedItem> keyedItems;

  public CustomEntity() {
  }

  public CustomEntity(String id) {
    setId(id);
  }

  public ResourceReference getSource() {
    return this.source;
  }

  public void setSource(ResourceReference source) {
    this.source = source;
  }

  public URI getRefToSomething() {
    return refToSomething;
  }

  public void setRefToSomething(URI refToSomething) {
    this.refToSomething = refToSomething;
  }

  @XmlElement ( name = "item" )
  public List<CustomKeyedItem> getKeyedItems() {
    return keyedItems;
  }

  public void setKeyedItems(List<CustomKeyedItem> keyedItems) {
    this.keyedItems = keyedItems;
  }

  @XmlElement ( name = "uitem" )
  public List<UniqueCustomKeyedItem> getUniqueKeyedItems() {
    return uniqueKeyedItems;
  }

  public void setUniqueKeyedItems(List<UniqueCustomKeyedItem> uniqueKeyedItems) {
    this.uniqueKeyedItems = uniqueKeyedItems;
  }
}

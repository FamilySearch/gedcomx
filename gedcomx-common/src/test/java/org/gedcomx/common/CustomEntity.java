package org.gedcomx.common;

import org.gedcomx.rt.json.JsonElementWrapper;

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

  @XmlElementWrapper( name = "item" )
  public List<CustomKeyedItem> getKeyedItems() {
    return keyedItems;
  }

  public void setKeyedItems(List<CustomKeyedItem> keyedItems) {
    this.keyedItems = keyedItems;
  }
}

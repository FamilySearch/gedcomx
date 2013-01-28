package org.gedcomx.common;

import org.gedcomx.rt.json.JsonElementWrapper;
import org.gedcomx.source.SourceReference;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;


/**
 * @author Ryan Heaton
 */
@XmlRootElement
@JsonElementWrapper (name = "customEntities")
public class CustomEntity
{

  private String id;
  private URI refToSomething;
  private List<UniqueCustomKeyedItem> uniqueKeyedItems;
  private List<CustomKeyedItem> keyedItems;
  private SourceReference source;

  public CustomEntity() {
  }

  public CustomEntity( String id ) {
    this.id = id;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
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

  public SourceReference getSource() {
    return source;
  }

  public void setSource(SourceReference source) {
    this.source = source;
  }
}

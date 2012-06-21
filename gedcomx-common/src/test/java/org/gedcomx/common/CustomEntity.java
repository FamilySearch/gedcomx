package org.gedcomx.common;

import org.gedcomx.rt.JsonElementWrapper;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Ryan Heaton
 */
@XmlRootElement
@JsonElementWrapper (name = "customEntities")
public class CustomEntity extends GenealogicalResource {

  private ResourceReference source;
  private URI refToSomething;

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
}

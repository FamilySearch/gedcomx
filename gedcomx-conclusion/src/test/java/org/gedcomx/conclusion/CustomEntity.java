package org.gedcomx.conclusion;

import org.gedcomx.common.GenealogicalResource;
import org.gedcomx.common.URI;
import org.gedcomx.rt.json.JsonElementWrapper;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Ryan Heaton
 */
@XmlRootElement
@JsonElementWrapper (name = "customEntities")
public class CustomEntity extends GenealogicalResource {

  private SourceReference source;
  private URI refToSomething;

  public CustomEntity() {
  }

  public CustomEntity(String id) {
    setId(id);
  }

  public SourceReference getSource() {
    return this.source;
  }

  public void setSource(SourceReference source) {
    this.source = source;
  }

  public URI getRefToSomething() {
    return refToSomething;
  }

  public void setRefToSomething(URI refToSomething) {
    this.refToSomething = refToSomething;
  }
}

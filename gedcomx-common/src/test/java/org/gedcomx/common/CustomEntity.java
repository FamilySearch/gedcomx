package org.gedcomx.common;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonTypeInfo;
import org.codehaus.jackson.map.annotate.JsonTypeIdResolver;
import org.gedcomx.rt.JsonElementWrapper;
import org.gedcomx.rt.XmlTypeIdResolver;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.util.Arrays;

/**
 * @author Ryan Heaton
 */
@XmlRootElement
@JsonElementWrapper (name = "customEntities")
@JsonTypeInfo ( use =JsonTypeInfo.Id.CUSTOM, property = XmlTypeIdResolver.TYPE_PROPERTY_NAME)
@JsonTypeIdResolver (XmlTypeIdResolver.class)
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

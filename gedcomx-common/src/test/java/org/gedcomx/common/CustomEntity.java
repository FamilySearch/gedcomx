package org.gedcomx.common;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonTypeInfo;
import org.codehaus.jackson.map.annotate.JsonTypeIdResolver;
import org.gedcomx.rt.JsonElementWrapper;
import org.gedcomx.rt.XmlTypeIdResolver;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Arrays;

/**
 * @author Ryan Heaton
 */
@XmlRootElement
@JsonElementWrapper (name = "customEntities")
@JsonTypeInfo ( use =JsonTypeInfo.Id.CUSTOM, property = XmlTypeIdResolver.TYPE_PROPERTY_NAME)
@JsonTypeIdResolver (XmlTypeIdResolver.class)
public class CustomEntity extends GenealogicalEntity {

  private URI refToSomething;

  public CustomEntity() {
  }

  public CustomEntity(String id) {
    setId(id);
  }

  @XmlTransient
  @JsonIgnore
  public ResourceReference getSource() {
    return getSources().get(0);
  }

  @JsonIgnore
  public void setSource(ResourceReference source) {
    setSources(Arrays.asList(source));
  }

  public URI getRefToSomething() {
    return refToSomething;
  }

  public void setRefToSomething(URI refToSomething) {
    this.refToSomething = refToSomething;
  }
}

package org.gedcomx.common;

import org.codehaus.jackson.annotate.JsonTypeInfo;
import org.codehaus.jackson.map.annotate.JsonTypeIdResolver;
import org.gedcomx.rt.XmlTypeIdResolver;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Ryan Heaton
 */
@XmlRootElement
@JsonTypeInfo ( use =JsonTypeInfo.Id.CUSTOM, property = "@type")
@JsonTypeIdResolver (XmlTypeIdResolver.class)
public class CustomElement {

  private String id;
  private ResourceReference source;

  public CustomElement() {
  }

  public CustomElement(String id) {
    this.id = id;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public ResourceReference getSource() {
    return source;
  }

  public void setSource(ResourceReference source) {
    this.source = source;
  }
}

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
public class CustomResource extends GenealogicalResource {

  private ResourceReference source;

  public CustomResource() {
  }

  public CustomResource(String id) {
    setId(id);
  }

  public ResourceReference getSource() {
    return source;
  }

  public void setSource(ResourceReference source) {
    this.source = source;
  }
}

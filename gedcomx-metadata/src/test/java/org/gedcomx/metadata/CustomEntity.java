package org.gedcomx.metadata;

import org.gedcomx.metadata.source.SourceReference;
import org.gedcomx.rt.json.JsonElementWrapper;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
@JsonElementWrapper (name = "customEntities")
public class CustomEntity {

  private String id;
  private SourceReference source;

  public CustomEntity() {
  }

  public CustomEntity(String id) {
    this.id = id;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public SourceReference getSource() {
    return source;
  }

  public void setSource(SourceReference source) {
    this.source = source;
  }
}

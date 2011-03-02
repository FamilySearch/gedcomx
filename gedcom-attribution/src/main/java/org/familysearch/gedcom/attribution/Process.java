package org.familysearch.gedcom.attribution;

import javax.xml.bind.annotation.XmlAttribute;

/**
 * @author CarpenterMP
 *         Date: Jul 10, 2009
 */
public class Process {

  private String uri;
  private String title;
  private String description;
  private String version;

  public Process() {
  }

  public Process(String uri, String title, String description, String version) {
    this.uri = uri;
    this.title = title;
    this.description = description;
    this.version = version;
  }

  @XmlAttribute
  public String getUri() {
    return uri;
  }

  public void setUri(String uri) {
    this.uri = uri;
  }

  @XmlAttribute
  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  @XmlAttribute
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  @XmlAttribute
  public String getVersion() {
    return version;
  }

  public void setVersion(String version) {
    this.version = version;
  }

}

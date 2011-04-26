package org.gedcomx.record;

import javax.xml.bind.annotation.XmlAttribute;
import java.net.URI;

/**
 * @author Ryan Heaton
 */
public class CollectionReference {

  private URI href;
  private String sortValue;

  @XmlAttribute(namespace="http://www.w3.org/1999/xlink")
  public URI getHref() {
    return href;
  }

  public void setHref(URI href) {
    this.href = href;
  }

  @XmlAttribute
  public String getSortValue() {
    return sortValue;
  }

  public void setSortValue(String sortValue) {
    this.sortValue = sortValue;
  }
}

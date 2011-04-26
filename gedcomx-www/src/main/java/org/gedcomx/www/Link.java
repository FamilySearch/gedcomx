package org.gedcomx.www;

import javax.xml.XMLConstants;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.namespace.QName;
import java.net.URI;

/**
 * @author Ryan Heaton
 */
public class Link {

  private URI base;
  private QName rel;
  private URI href;

  @XmlAttribute
  public QName getRel() {
    return rel;
  }

  public void setRel(QName rel) {
    this.rel = rel;
  }

  @XmlAttribute (namespace = XMLConstants.XML_NS_URI)
  public URI getBase() {
    return base;
  }

  public void setBase(URI base) {
    this.base = base;
  }

  @XmlAttribute(namespace="http://www.w3.org/1999/xlink")
  public URI getHref() {
    return href;
  }

  public void setHref(URI href) {
    this.href = href;
  }
}

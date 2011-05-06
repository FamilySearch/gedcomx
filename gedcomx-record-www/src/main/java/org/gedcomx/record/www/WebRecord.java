package org.gedcomx.record.www;

import org.gedcomx.record.Record;
import org.gedcomx.www.Links;
import org.gedcomx.www.PersistentIdentifier;

import javax.xml.XMLConstants;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.net.URI;

/**
 * @author Ryan Heaton
 */
@XmlRootElement (name = "record")
@XmlType (name = "record")
public class WebRecord extends Record {

  private URI base;
  private PersistentIdentifier identifier;
  private Links links;

  @XmlAttribute (namespace = XMLConstants.XML_NS_URI)
  public URI getBase() {
    return base;
  }

  public void setBase(URI base) {
    this.base = base;
  }

  public PersistentIdentifier getIdentifier() {
    return identifier;
  }

  public void setIdentifier(PersistentIdentifier identifier) {
    this.identifier = identifier;
  }

  public Links getLinks() {
    return links;
  }

  public void setLinks(Links links) {
    this.links = links;
  }
}

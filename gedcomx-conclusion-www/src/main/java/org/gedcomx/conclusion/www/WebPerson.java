package org.gedcomx.conclusion.www;

import org.gedcomx.conclusion.Person;
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
@XmlRootElement (name = "person")
@XmlType (name = "person")
public class WebPerson extends Person {

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

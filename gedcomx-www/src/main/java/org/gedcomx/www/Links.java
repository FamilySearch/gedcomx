package org.gedcomx.www;

import org.codehaus.enunciate.ClientName;

import javax.xml.XMLConstants;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import java.net.URI;
import java.util.List;

/**
 * @author Ryan Heaton
 */
public class Links {

  //todo: should PAL be inside 'Links' so it can take advantage of the xml:base?
  private List<Link> links;
  private URI base;

  @XmlAttribute (namespace = XMLConstants.XML_NS_URI)
  public URI getBase() {
    return base;
  }

  public void setBase(URI base) {
    this.base = base;
  }

  @XmlElement( name="link" )
  @ClientName( "linkList" )
  public List<Link> getLinks() {
    return links;
  }

  public void setLinks(List<Link> links) {
    this.links = links;
  }
}

package org.gedcomx.www;

import org.testng.annotations.Test;

import javax.xml.namespace.QName;
import java.net.URI;
import java.util.ArrayList;

import static org.gedcomx.rt.SerializationUtil.processThroughJson;
import static org.gedcomx.rt.SerializationUtil.processThroughXml;
import static org.testng.AssertJUnit.assertEquals;

/**
 * @author Ryan Heaton
 */
@Test
public class TestLinks {

  /**
   * tests alternate id xml
   */
  public void testAlternateIdXml() throws Exception {
    Links links = new Links();
    links.setBase(URI.create("http://gedcomx.org"));
    links.setLinks(new ArrayList<Link>());
    Link ln = new Link();
    ln.setHref(URI.create("urn:href"));
    QName linkrel = new QName("urn:action", "dosomething");
    ln.setRel(linkrel);
    links.getLinks().add(ln);
    links = processThroughXml(links);
    assertEquals("http://gedcomx.org", links.getBase().toString());
    assertEquals(1, links.getLinks().size());
    assertEquals("urn:href", links.getLinks().get(0).getHref().toString());
    assertEquals(linkrel, links.getLinks().get(0).getRel());
  }

  /**
   * tests alternate id json
   */
  public void testAlternateIdJson() throws Exception {
    Links links = new Links();
    links.setBase(URI.create("http://gedcomx.org"));
    links.setLinks(new ArrayList<Link>());
    Link ln = new Link();
    ln.setHref(URI.create("urn:href"));
    QName linkrel = new QName("urn:action", "dosomething");
    ln.setRel(linkrel);
    links.getLinks().add(ln);
    links = processThroughJson(links);
    assertEquals("http://gedcomx.org", links.getBase().toString());
    assertEquals(1, links.getLinks().size());
    assertEquals("urn:href", links.getLinks().get(0).getHref().toString());
    assertEquals(linkrel, links.getLinks().get(0).getRel());
  }

}

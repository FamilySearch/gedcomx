package org.gedcomx.www;

import org.testng.annotations.Test;

import javax.xml.namespace.QName;
import java.net.URI;

import static org.gedcomx.rt.SerializationUtil.processThroughJson;
import static org.gedcomx.rt.SerializationUtil.processThroughXml;
import static org.testng.AssertJUnit.assertEquals;

/**
 * @author Ryan Heaton
 */
@Test
public class TestLink {

  /**
   * tests link xml
   */
  public void testLinkXml() throws Exception {
    Link link = new Link();
    link.setHref(URI.create("urn:link"));
    link.setRel("rel");
    link = processThroughXml(link);
    assertEquals(URI.create("urn:link"), link.getHref());
    assertEquals("rel", link.getRel());
  }

  /**
   * tests link json
   */
  public void testLinkJson() throws Exception {
    Link link = new Link();
    link.setHref(URI.create("urn:link"));
    link.setRel("rel");
    link = processThroughJson(link);
    assertEquals(URI.create("urn:link"), link.getHref());
    assertEquals("rel", link.getRel());
  }

}

package org.gedcomx.www;

import junit.framework.TestCase;

import java.net.URI;

/**
 * @author Ryan Heaton
 */
public class TestPersistentIdentifier extends TestCase {

  /**
   * Can persistent identifiers be URIs?
   */
  public void testURIValues() throws Exception {
    assertNull(URI.create("myvalue").getScheme());
    assertNull(URI.create("#localref").getScheme());
    assertEquals("http", URI.create("http://mydomain/pal:/12345").getScheme());

    //todo: fill in this test
  }
}

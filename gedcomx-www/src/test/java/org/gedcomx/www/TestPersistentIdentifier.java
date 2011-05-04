package org.gedcomx.www;

import org.testng.annotations.Test;

import java.net.URI;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertNull;

/**
 * @author Ryan Heaton
 */
@Test
public class TestPersistentIdentifier {

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

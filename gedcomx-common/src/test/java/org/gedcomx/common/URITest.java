package org.gedcomx.common;

import org.testng.annotations.Test;

import static org.gedcomx.rt.SerializationUtil.processThroughJson;
import static org.gedcomx.rt.SerializationUtil.processThroughXml;
import static org.testng.Assert.*;


/**
 * @author Ryan Heaton
 */
public class URITest {

  /**
   * tests source reference xml
   */
  @Test
  public void testSourceReferenceXml() throws Exception {
    CustomEntity custom = new CustomEntity();
    custom.setRefToSomething(new URI("uri:hello"));
    custom = processThroughXml(custom);
    assertEquals(custom.getRefToSomething().toString(), "uri:hello");

    // code to further exercise URIAdapter
    custom.setRefToSomething(null);
    custom = processThroughXml(custom);
    assertNull(custom.getRefToSomething());
  }

  /**
   * tests source reference json
   */
  @Test
  public void testSourceReferenceJson() throws Exception {
    CustomEntity custom = new CustomEntity();
    custom.setRefToSomething(new URI("uri:hello"));
    custom = processThroughJson(custom);
    assertEquals(custom.getRefToSomething().toString(), "uri:hello");
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testCreateWithNull() {
    URI.create(null);
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testCtorWithNull() {
    new URI(null);
  }

  @Test
  public void testToURI() {
    URI hello = new URI("uri:hello");
    assertEquals(hello.toURI(), java.net.URI.create("uri:hello"));
  }

  @Test
  public void testEquals() {
    URI a, b;

    a = new URI("uri:hello");
    b = null;
    assertFalse(a.equals(b));
    assertTrue(a.equals(a));

    b = new URI("uri:hello");
    assertTrue(a.equals(b));

    b = new URI("uri:hello-again");
    assertFalse(a.equals(b));
  }

  @Test
  public void testHash() {
    URI hello = new URI("uri:hello");
    assertEquals(hello.hashCode(), "uri:hello".hashCode());
  }
}

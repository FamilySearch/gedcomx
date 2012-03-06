package org.gedcomx.common;

import org.testng.annotations.Test;

import static org.gedcomx.rt.SerializationUtil.processThroughJson;
import static org.gedcomx.rt.SerializationUtil.processThroughXml;
import static org.testng.AssertJUnit.assertEquals;

/**
 * @author Ryan Heaton
 */
@Test
public class URITest {

  /**
   * tests source reference xml
   */
  public void testSourceReferenceXml() throws Exception {
    CustomEntity custom = new CustomEntity();
    custom.setRefToSomething(new org.gedcomx.common.URI("uri:hello"));
    custom = processThroughXml(custom);
    assertEquals("uri:hello", custom.getRefToSomething().toString());
  }

  /**
   * tests source reference json
   */
  public void testSourceReferenceJson() throws Exception {
    CustomEntity custom = new CustomEntity();
    custom.setRefToSomething(new org.gedcomx.common.URI("uri:hello"));
    custom = processThroughJson(custom);
    assertEquals("uri:hello", custom.getRefToSomething().toString());
  }

}

package org.gedcomx.attribution;

import org.testng.annotations.Test;

import java.net.URI;

import static org.gedcomx.rt.SerializationUtil.processThroughJson;
import static org.gedcomx.rt.SerializationUtil.processThroughXml;
import static org.testng.AssertJUnit.assertEquals;

/**
 * @author Ryan Heaton
 */
@Test
public class TestAttributionReference {

  /**
   * tests attribution reference xml
   */
  public void testAttributionReferenceXml() throws Exception {
    AttributionReference reference = new AttributionReference();
    reference.setHref(URI.create("urn:someid"));
    reference = processThroughXml(reference);
    assertEquals("urn:someid", reference.getHref().toString());
  }

  /**
   * tests attribution reference json
   */
  public void testAttributionReferenceJson() throws Exception {
    AttributionReference reference = new AttributionReference();
    reference.setHref(URI.create("urn:someid"));
    reference = processThroughJson(reference);
    assertEquals("urn:someid", reference.getHref().toString());
  }

}

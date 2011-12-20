package org.gedcomx.common;

import org.gedcomx.types.ConfidenceLevel;
import org.testng.annotations.Test;

import org.gedcomx.common.URI;
import java.util.Date;

import static org.gedcomx.rt.SerializationUtil.processThroughJson;
import static org.gedcomx.rt.SerializationUtil.processThroughXml;
import static org.testng.AssertJUnit.assertEquals;

/**
 * @author Ryan Heaton
 */
@Test
public class TestAttribution {

  /**
   * tests attribution xml
   */
  public void testAttributionXml() throws Exception {
    Attribution attribution = new Attribution();
    attribution.setContributor(new ResourceReference());
    attribution.getContributor().setResource(URI.create("urn:someid"));
    attribution.setProofStatement("hello, there.");
    attribution.setKnownConfidenceLevel(ConfidenceLevel.Possibly);
    Date ts = new Date();
    attribution.setModified(ts);
    attribution = processThroughXml(attribution);
    assertEquals("urn:someid", attribution.getContributor().getResource().toString());
    assertEquals("hello, there.", attribution.getProofStatement());
    assertEquals(ts, attribution.getModified());
    assertEquals(ConfidenceLevel.Possibly, attribution.getKnownConfidenceLevel());
  }

  /**
   * tests attribution json
   */
  public void testAttributionJson() throws Exception {
    Attribution attribution = new Attribution();
    attribution.setContributor(new ResourceReference());
    attribution.getContributor().setResource(URI.create("urn:someid"));
    attribution.setProofStatement("hello, there.");
    attribution.setKnownConfidenceLevel(ConfidenceLevel.Possibly);
    Date ts = new Date();
    attribution.setModified(ts);
    attribution = processThroughJson(attribution);
    assertEquals("urn:someid", attribution.getContributor().getResource().toString());
    assertEquals("hello, there.", attribution.getProofStatement());
    assertEquals(ts, attribution.getModified());
    assertEquals(ConfidenceLevel.Possibly, attribution.getKnownConfidenceLevel());
  }

}

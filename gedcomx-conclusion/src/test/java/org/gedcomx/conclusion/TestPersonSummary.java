package org.gedcomx.conclusion;

import org.gedcomx.common.Attribution;
import org.gedcomx.common.ResourceReference;
import org.testng.annotations.Test;

import java.net.URI;

import static org.gedcomx.rt.SerializationUtil.processThroughJson;
import static org.gedcomx.rt.SerializationUtil.processThroughXml;
import static org.testng.AssertJUnit.assertEquals;

/**
 * @author Ryan Heaton
 */
@Test
public class TestPersonSummary {

  /**
   * tests processing a family through xml...
   */
  public void testPersonVitalsXml() throws Exception {
    PersonSummary summary = createTestVitals();
    summary = processThroughXml(summary);
    assertTestFamily(summary);
  }

  /**
   * tests processing a family through json...
   */
  public void testPersonVitalsJson() throws Exception {
    PersonSummary summary = createTestVitals();
    summary = processThroughJson(summary);
    assertTestFamily(summary);
  }

  private PersonSummary createTestVitals() {
    PersonSummary summary = new PersonSummary();
    summary.setAttribution(new Attribution());
    summary.getAttribution().setStatement("explanation");
    summary.setId("vitalId");
    summary.setPersonReference(URI.create("urn:pid"));
    summary.setGender(new ResourceReference());
    summary.getGender().setResource(URI.create("#gender"));
    summary.setBirth(new ResourceReference());
    summary.getBirth().setResource(URI.create("#birth"));
    summary.setDeath(new ResourceReference());
    summary.getDeath().setResource(URI.create("#death"));
    summary.setName(new ResourceReference());
    summary.getName().setResource(URI.create("#name"));
    return summary;
  }

  private void assertTestFamily(PersonSummary summary) {
    assertEquals("explanation", summary.getAttribution().getStatement());
    assertEquals("vitalId", summary.getId());
    assertEquals(URI.create("urn:pid"), summary.getPersonReference());
    assertEquals(URI.create("#gender"), summary.getGender().getResource());
    assertEquals(URI.create("#birth"), summary.getBirth().getResource());
    assertEquals(URI.create("#death"), summary.getDeath().getResource());
    assertEquals(URI.create("#name"), summary.getName().getResource());
  }

}

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
public class TestPersonVitals {

  /**
   * tests processing a family through xml...
   */
  public void testPersonVitalsXml() throws Exception {
    PersonVitals vitals = createTestVitals();
    vitals = processThroughXml(vitals);
    assertTestFamily(vitals);
  }

  /**
   * tests processing a family through json...
   */
  public void testPersonVitalsJson() throws Exception {
    PersonVitals vitals = createTestVitals();
    vitals = processThroughJson(vitals);
    assertTestFamily(vitals);
  }

  private PersonVitals createTestVitals() {
    PersonVitals vitals = new PersonVitals();
    vitals.setAttribution(new Attribution());
    vitals.getAttribution().setStatement("explanation");
    vitals.setId("vitalId");
    vitals.setPersonReference(URI.create("urn:pid"));
    vitals.setGender(new ResourceReference());
    vitals.getGender().setResource(URI.create("#gender"));
    vitals.setBirth(new ResourceReference());
    vitals.getBirth().setResource(URI.create("#birth"));
    vitals.setDeath(new ResourceReference());
    vitals.getDeath().setResource(URI.create("#death"));
    vitals.setName(new ResourceReference());
    vitals.getName().setResource(URI.create("#name"));
    return vitals;
  }

  private void assertTestFamily(PersonVitals vitals) {
    assertEquals("explanation", vitals.getAttribution().getStatement());
    assertEquals("vitalId", vitals.getId());
    assertEquals(URI.create("urn:pid"), vitals.getPersonReference());
    assertEquals(URI.create("#gender"), vitals.getGender().getResource());
    assertEquals(URI.create("#birth"), vitals.getBirth().getResource());
    assertEquals(URI.create("#death"), vitals.getDeath().getResource());
    assertEquals(URI.create("#name"), vitals.getName().getResource());
  }

}

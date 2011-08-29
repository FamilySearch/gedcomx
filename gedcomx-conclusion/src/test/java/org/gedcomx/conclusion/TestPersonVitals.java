package org.gedcomx.conclusion;

import org.testng.annotations.Test;

import static org.gedcomx.rt.SerializationUtil.processThroughJson;
import static org.gedcomx.rt.SerializationUtil.processThroughXml;
import static org.testng.AssertJUnit.assertEquals;

/**
 * @author Ryan Heaton
 */
@Test
public class TestPersonVitals {

  /**
   * tests processing a personvitals through xml...
   */
  public void testPersonvitalsXml() throws Exception {
    PersonVitals personvitals = createTestPersonVitals();
    personvitals = processThroughXml(personvitals);
    assertTestPersonVitals(personvitals);
  }

  /**
   * tests processing a personvitals through json...
   */
  public void testPersonJson() throws Exception {
    PersonVitals personvitals = createTestPersonVitals();
    personvitals = processThroughJson(personvitals);
    assertTestPersonVitals(personvitals);
  }

  private PersonVitals createTestPersonVitals() {
    PersonVitals personvitals = new PersonVitals();
    personvitals.setBirth(new Event());
    personvitals.getBirth().setId("birth");
    personvitals.setDeath(new Event());
    personvitals.getDeath().setId("death");
    personvitals.setGender(new Gender());
    personvitals.getGender().setId("gender");
    personvitals.setName(new Name());
    personvitals.getName().setId("name");
    personvitals.setId("vitals");
    return personvitals;
  }

  private void assertTestPersonVitals(PersonVitals personvitals) {
    assertEquals("birth", personvitals.getBirth().getId());
    assertEquals("death", personvitals.getDeath().getId());
    assertEquals("gender", personvitals.getGender().getId());
    assertEquals("name", personvitals.getName().getId());
    assertEquals("vitals", personvitals.getId());
  }

}

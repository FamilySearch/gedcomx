package org.gedcomx.conclusion;

import org.gedcomx.common.AlternateId;
import org.gedcomx.common.Attribution;
import org.gedcomx.common.ResourceReference;
import org.testng.annotations.Test;

import java.net.URI;
import java.util.Arrays;

import static org.gedcomx.rt.SerializationUtil.processThroughJson;
import static org.gedcomx.rt.SerializationUtil.processThroughXml;
import static org.testng.AssertJUnit.assertEquals;

/**
 * @author Ryan Heaton
 */
@Test
public class TestFamily {

  /**
   * tests processing a family through xml...
   */
  public void testFamilyXml() throws Exception {
    Family family = createTestFamily();
    family = processThroughXml(family);
    assertTestFamily(family);
  }

  /**
   * tests processing a family through json...
   */
  public void testFamilyJson() throws Exception {
    Family family = createTestFamily();
    family = processThroughJson(family);
    assertTestFamily(family);
  }

  private Family createTestFamily() {
    Family family = new Family();
    AlternateId alternateId = new AlternateId();
    alternateId.setValue("alt-id");
    family.setAlternateIds(Arrays.asList(alternateId));
    family.setAttribution(new Attribution());
    family.getAttribution().setStatement("explanation");
    family.setId("family");
    family.setPersistentId(URI.create("urn:pid"));
    family.setParent1(new ResourceReference());
    family.getParent1().setResource(URI.create("urn:person1"));
    family.setParent2(new ResourceReference());
    family.getParent2().setResource(URI.create("urn:person2"));
    family.setChildren(Arrays.asList(new ResourceReference()));
    family.getChildren().get(0).setResource(URI.create("urn:child1"));
    ResourceReference sourceReference = new ResourceReference();
    sourceReference.setId("source-ref");
    family.setSources(Arrays.asList(sourceReference));
    family.setBibliographicCitation("family bibliographic citation");
    return family;
  }

  private void assertTestFamily(Family family) {
    assertEquals("alt-id", family.getAlternateIds().get(0).getValue());
    assertEquals("explanation", family.getAttribution().getStatement());
    assertEquals("family", family.getId());
    assertEquals(URI.create("urn:pid"), family.getPersistentId());
    assertEquals(URI.create("urn:person1"), family.getParent1().getResource());
    assertEquals(URI.create("urn:person2"), family.getParent2().getResource());
    assertEquals(URI.create("urn:child1"), family.getChildren().get(0).getResource());
    assertEquals("source-ref", family.getSources().get(0).getId());
    assertEquals("family bibliographic citation", family.getBibliographicCitation());
  }

}

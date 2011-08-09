package org.gedcomx.conclusion;

import org.gedcomx.attribution.Attribution;
import org.gedcomx.common.AlternateId;
import org.gedcomx.common.Extension;
import org.gedcomx.common.ResourceReference;
import org.gedcomx.common.SourceReference;
import org.gedcomx.types.RelationshipType;
import org.testng.annotations.Test;

import java.net.URI;
import java.util.Arrays;

import static org.gedcomx.rt.SerializationUtil.processThroughJson;
import static org.gedcomx.rt.SerializationUtil.processThroughXml;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertNotNull;

/**
 * @author Ryan Heaton
 */
@Test
public class TestRelationship {

  /**
   * tests processing a relationship through xml...
   */
  public void testRelationshipXml() throws Exception {
    Relationship relationship = createTestRelationship();
    relationship = processThroughXml(relationship);
    assertTestRelationship(relationship);
  }

  /**
   * tests processing a relationship through json...
   */
  public void testPersonJson() throws Exception {
    Relationship relationship = createTestRelationship();
    relationship = processThroughJson(relationship);
    assertTestRelationship(relationship);
  }

  private Relationship createTestRelationship() {
    Relationship relationship = new Relationship();
    relationship.setKnownType(RelationshipType.couple);
    AlternateId alternateId = new AlternateId();
    alternateId.setValue("alt-id");
    relationship.setAlternateIds(Arrays.asList(alternateId));
    relationship.setAttribution(new Attribution());
    relationship.getAttribution().setExplanation("explanation");
    Characteristic characteristic = new Characteristic();
    characteristic.setId("characteristic");
    relationship.setCharacteristics(Arrays.asList(characteristic));
    Event event = new Event();
    event.setId("event");
    relationship.setEvents(Arrays.asList(event));
    relationship.setExtension(new Extension());
    relationship.setId("relationship");
    relationship.setPersistentId(URI.create("urn:pid"));
    relationship.setPerson1(new ResourceReference());
    relationship.getPerson1().setHref(URI.create("urn:person1"));
    relationship.setPerson2(new ResourceReference());
    relationship.getPerson2().setHref(URI.create("urn:person2"));
    SourceReference sourceReference = new SourceReference();
    sourceReference.setId("source-ref");
    relationship.setSources(Arrays.asList(sourceReference));
    relationship.setBibliographicCitation("relationship bibliographic citation");
    return relationship;
  }

  private void assertTestRelationship(Relationship relationship) {
    assertEquals(RelationshipType.couple, relationship.getKnownType());
    assertEquals("alt-id", relationship.getAlternateIds().get(0).getValue());
    assertEquals("explanation", relationship.getAttribution().getExplanation());
    assertEquals("characteristic", relationship.getCharacteristics().get(0).getId());
    assertEquals("event", relationship.getEvents().get(0).getId());
    assertNotNull(relationship.getExtension());
    assertEquals("relationship", relationship.getId());
    assertEquals(URI.create("urn:pid"), relationship.getPersistentId());
    assertEquals(URI.create("urn:person1"), relationship.getPerson1().getHref());
    assertEquals(URI.create("urn:person2"), relationship.getPerson2().getHref());
    assertEquals("source-ref", relationship.getSources().get(0).getId());
    assertEquals("relationship bibliographic citation", relationship.getBibliographicCitation());
  }

}

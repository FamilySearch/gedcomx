package org.gedcomx.conclusion;

import org.gedcomx.common.AlternateId;
import org.gedcomx.common.Attribution;
import org.gedcomx.common.ResourceReference;
import org.gedcomx.types.RelationshipType;
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
    relationship.setKnownType(RelationshipType.Couple);
    AlternateId alternateId = new AlternateId();
    alternateId.setValue("alt-id");
    relationship.setAlternateIds(Arrays.asList(alternateId));
    relationship.setAttribution(new Attribution());
    relationship.getAttribution().setStatement("explanation");
    Characteristic characteristic = new Characteristic();
    characteristic.setId("characteristic");
    relationship.setCharacteristics(Arrays.asList(characteristic));
    Event event = new Event();
    event.setId("event");
    relationship.setEvents(Arrays.asList(event));
    relationship.setId("relationship");
    relationship.setPersistentId(URI.create("urn:pid"));
    relationship.setPerson1(new ResourceReference());
    relationship.getPerson1().setResource(URI.create("urn:person1"));
    relationship.setPerson2(new ResourceReference());
    relationship.getPerson2().setResource(URI.create("urn:person2"));
    ResourceReference sourceReference = new ResourceReference();
    sourceReference.setId("source-ref");
    relationship.setSources(Arrays.asList(sourceReference));
    relationship.setBibliographicCitation("relationship bibliographic citation");
    return relationship;
  }

  private void assertTestRelationship(Relationship relationship) {
    assertEquals(RelationshipType.Couple, relationship.getKnownType());
    assertEquals("alt-id", relationship.getAlternateIds().get(0).getValue());
    assertEquals("explanation", relationship.getAttribution().getStatement());
    assertEquals("characteristic", relationship.getCharacteristics().get(0).getId());
    assertEquals("event", relationship.getEvents().get(0).getId());
    assertEquals("relationship", relationship.getId());
    assertEquals(URI.create("urn:pid"), relationship.getPersistentId());
    assertEquals(URI.create("urn:person1"), relationship.getPerson1().getResource());
    assertEquals(URI.create("urn:person2"), relationship.getPerson2().getResource());
    assertEquals("source-ref", relationship.getSources().get(0).getId());
    assertEquals("relationship bibliographic citation", relationship.getBibliographicCitation());
  }

}

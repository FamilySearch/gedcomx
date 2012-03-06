package org.gedcomx.conclusion;

import org.gedcomx.common.AlternateId;
import org.gedcomx.common.Attribution;
import org.gedcomx.common.ResourceReference;
import org.gedcomx.types.RelationshipType;
import org.testng.annotations.Test;

import org.gedcomx.common.URI;
import java.util.Arrays;

import static org.gedcomx.rt.SerializationUtil.processThroughJson;
import static org.gedcomx.rt.SerializationUtil.processThroughXml;
import static org.testng.AssertJUnit.assertEquals;

/**
 * @author Ryan Heaton
 */
@Test
public class RelationshipTest {

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
    relationship.getAttribution().setProofStatement("explanation");
    Fact fact = new Fact();
    fact.setId("fact");
    Fact event = new Fact();
    event.setId("event");
    relationship.setFacts(Arrays.asList(event, fact));
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
    assertEquals("explanation", relationship.getAttribution().getProofStatement());
    assertEquals("fact", relationship.getFacts().get(1).getId());
    assertEquals("event", relationship.getFacts().get(0).getId());
    assertEquals("relationship", relationship.getId());
    assertEquals(URI.create("urn:pid"), relationship.getPersistentId());
    assertEquals(URI.create("urn:person1"), relationship.getPerson1().getResource());
    assertEquals(URI.create("urn:person2"), relationship.getPerson2().getResource());
    assertEquals("source-ref", relationship.getSources().get(0).getId());
    assertEquals("relationship bibliographic citation", relationship.getBibliographicCitation());
  }

}

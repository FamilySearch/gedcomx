package org.gedcomx.conclusion;

import org.gedcomx.common.Attribution;
import org.gedcomx.common.ResourceReference;
import org.gedcomx.metadata.source.SourceReference;
import org.gedcomx.common.URI;
import org.gedcomx.types.RelationshipType;
import org.testng.annotations.Test;

import java.util.List;

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
    relationship.setAttribution(new Attribution());
    relationship.getAttribution().setChangeMessage("explanation");
    Fact fact = new Fact();
    fact.setId("fact");
    Fact event = new Fact();
    event.setId("event");
    relationship.addFact(event);
    List<Fact> facts = relationship.getFacts();
    facts.add(fact);
    relationship.setFacts(facts);
    relationship.setId("relationship");
    relationship.setPerson1(new ResourceReference());
    relationship.getPerson1().setResource(URI.create("urn:person1"));
    relationship.setPerson2(new ResourceReference());
    relationship.getPerson2().setResource(URI.create("urn:person2"));
    SourceReference sourceReference = new SourceReference();
    sourceReference.setSourceDescriptionURI(URI.create("urn:sourceDescription1"));
    relationship.addSource(sourceReference);
    return relationship;
  }

  private void assertTestRelationship(Relationship relationship) {
    assertEquals(RelationshipType.Couple, relationship.getKnownType());
    assertEquals("explanation", relationship.getAttribution().getChangeMessage());
    assertEquals("fact", relationship.getFacts().get(1).getId());
    assertEquals("event", relationship.getFacts().get(0).getId());
    assertEquals("relationship", relationship.getId());
    assertEquals(URI.create("urn:person1"), relationship.getPerson1().getResource());
    assertEquals(URI.create("urn:person2"), relationship.getPerson2().getResource());
    assertEquals(URI.create("urn:sourceDescription1"), relationship.getSources().get(0).getSourceDescription().getResource());
  }

}

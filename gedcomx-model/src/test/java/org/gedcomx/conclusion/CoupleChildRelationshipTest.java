package org.gedcomx.conclusion;

import org.gedcomx.common.Attribution;
import org.gedcomx.common.Note;
import org.gedcomx.common.ResourceReference;
import org.gedcomx.common.URI;
import org.gedcomx.source.SourceReference;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNull;


public class CoupleChildRelationshipTest {
  @Test
  public void testGetRelationshipToParent1() throws Exception {
    ArrayList<SourceReference> sources = new ArrayList<SourceReference>();
    ArrayList<Note> notes = new ArrayList<Note>();
    Attribution attribution =  new Attribution();

    CoupleChildRelationship coupleChildRelationship = new CoupleChildRelationship();

    assertNull(coupleChildRelationship.getRelationshipToParent1());
    assertNull(coupleChildRelationship.getRelationshipToParent2());
    assertNull(coupleChildRelationship.getSources());
    assertNull(coupleChildRelationship.getNotes());
    assertNull(coupleChildRelationship.getAttribution());

    coupleChildRelationship.setRelationshipToParent1(new ResourceReference(URI.create("urn:father-to-child")));
    coupleChildRelationship.setRelationshipToParent2(new ResourceReference(URI.create("urn:mother-to-child")));
    coupleChildRelationship.setSources(sources);
    coupleChildRelationship.setNotes(notes);
    coupleChildRelationship.setAttribution(attribution);

    assertEquals(coupleChildRelationship.getRelationshipToParent1().getResource(), URI.create("urn:father-to-child"));
    assertEquals(coupleChildRelationship.getRelationshipToParent2().getResource(), URI.create("urn:mother-to-child"));
    assertEquals(coupleChildRelationship.getSources(), sources);
    assertEquals(coupleChildRelationship.getNotes(), notes);
    assertEquals(coupleChildRelationship.getAttribution(), attribution);
  }
}

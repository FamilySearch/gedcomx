package org.familysearch.ct;

import org.gedcomx.conclusion.Relationship;
import org.testng.annotations.Test;

import static org.gedcomx.rt.SerializationUtil.processThroughJson;
import static org.gedcomx.rt.SerializationUtil.processThroughXml;
import static org.testng.AssertJUnit.assertEquals;

/**
 * @author Ryan Heaton
 */
@Test
public class TestTernaryRelationship {

  /**
   * tests processing a family through xml...
   */
  public void testXml() throws Exception {
    TernaryRelationship rel = create();
    rel = processThroughXml(rel);
    verify(rel);
  }

  /**
   * tests processing a family through json...
   */
  public void testJson() throws Exception {
    TernaryRelationship rel = create();
    rel = processThroughJson(rel);
    verify(rel);
  }

  private TernaryRelationship create() {
    TernaryRelationship rel = new TernaryRelationship();
    rel.setChildToFatherRelationship(new Relationship());
    rel.getChildToFatherRelationship().setId("father");
    rel.setChildToMotherRelationship(new Relationship());
    rel.getChildToMotherRelationship().setId("mother");
    return rel;
  }

  private void verify(TernaryRelationship rel) {
    assertEquals("father", rel.getChildToFatherRelationship().getId());
    assertEquals("mother", rel.getChildToMotherRelationship().getId());
  }
}

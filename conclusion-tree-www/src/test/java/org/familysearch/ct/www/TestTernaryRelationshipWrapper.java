package org.familysearch.ct.www;

import org.familysearch.ct.TernaryRelationship;
import org.familysearch.ct.www.impl.TernaryRelationshipWrapper;
import org.testng.annotations.Test;

import static org.gedcomx.rt.SerializationUtil.processThroughJson;
import static org.gedcomx.rt.SerializationUtil.processThroughXml;
import static org.testng.AssertJUnit.assertEquals;

/**
 * @author Ryan Heaton
 */
@Test
public class TestTernaryRelationshipWrapper {

  /**
   * tests processing a family through xml...
   */
  public void testXml() throws Exception {
    TernaryRelationshipWrapper rel = create();
    rel = processThroughXml(rel);
    verify(rel);
  }

  /**
   * tests processing a family through json...
   */
  public void testJson() throws Exception {
    TernaryRelationshipWrapper rel = create();
    rel = processThroughJson(rel);
    verify(rel);
  }

  private TernaryRelationshipWrapper create() {
    TernaryRelationshipWrapper rel = new TernaryRelationshipWrapper();
    rel.setTernaryRelationship(new TernaryRelationship());
    rel.getTernaryRelationship().setId("tr");
    return rel;
  }

  private void verify(TernaryRelationshipWrapper rel) {
    assertEquals("tr", rel.getTernaryRelationship().getId());
  }
}

package org.gedcomx.metadata.rdf;

import org.testng.annotations.Test;

import static org.gedcomx.rt.SerializationUtil.processThroughJson;
import static org.gedcomx.rt.SerializationUtil.processThroughXml;
import static org.testng.AssertJUnit.assertEquals;

/**
 * @author Ryan Heaton
 */
@Test
public class TestRDFMetadata {

  /**
   * tests alternate id xml
   */
  public void testRDFMetadataXml() throws Exception {
    RDFMetadata meta = new RDFMetadata();
    meta.setId("id");
    //todo: fill in other tests...
    meta = processThroughXml(meta);
    assertEquals("id", meta.getId());
    //todo: fill in other asserts.
  }

  /**
   * tests alternate id json
   */
  public void testRDFMetadataJson() throws Exception {
    RDFMetadata meta = new RDFMetadata();
    meta.setId("id");
    //todo: fill in other tests...
    meta = processThroughJson(meta);
    assertEquals("id", meta.getId());
    //todo: fill in other asserts.
  }

}

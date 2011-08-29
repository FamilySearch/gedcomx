package org.gedcomx.metadata.rdf;

import org.gedcomx.metadata.dc.DublinCoreDescription;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.gedcomx.rt.SerializationUtil.processThroughJson;
import static org.gedcomx.rt.SerializationUtil.processThroughXml;
import static org.testng.AssertJUnit.assertEquals;

/**
 * @author Ryan Heaton
 */
@Test
public class TestRDFDescriptionSet {

  /**
   * tests alternate id xml
   */
  public void testRDFMetadataBundleXml() throws Exception {
    RDFDescriptionSet meta = new RDFDescriptionSet();
    meta.setId("id");
    meta.setRdfDescriptions(Arrays.asList((RDFDescription) new DublinCoreDescription()));
    meta.setOtherDescriptions(new ArrayList<Object>());
    meta.getOtherDescriptions().add(new RDFDescriptionSet());
    meta = processThroughXml(meta);
    assertEquals("id", meta.getId());
    assertEquals(1, meta.getOtherDescriptions().size());
    assertEquals(1, meta.getRdfDescriptions().size());
  }

  /**
   * tests alternate id json
   */
  public void testRDFMetadataJson() throws Exception {
    RDFDescriptionSet meta = new RDFDescriptionSet();
    meta.setId("id");
    meta.setRdfDescriptions(Arrays.asList((RDFDescription) new DublinCoreDescription()));
    meta.setOtherDescriptions(new ArrayList<Object>());
    meta.getOtherDescriptions().add(new RDFDescriptionSet());
    meta = processThroughJson(meta);
    assertEquals("id", meta.getId());
    assertEquals(1, meta.getOtherDescriptions().size());
    assertEquals(1, meta.getRdfDescriptions().size());
  }

}

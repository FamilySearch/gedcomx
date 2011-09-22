package org.gedcomx.common;

import org.testng.annotations.Test;

import java.util.ArrayList;

import static org.gedcomx.rt.SerializationUtil.processThroughJson;
import static org.gedcomx.rt.SerializationUtil.processThroughXml;
import static org.testng.AssertJUnit.assertEquals;

/**
 * @author Ryan Heaton
 */
@Test
public class TestResourceSet {

  /**
   * tests alternate id xml
   */
  public void testRDFMetadataBundleXml() throws Exception {
    ResourceSet meta = new ResourceSet();
    meta.setId("id");
    meta.setExtensionElements(new ArrayList<Object>());
    meta.getExtensionElements().add(new ResourceSet());
    meta = processThroughXml(meta);
    assertEquals("id", meta.getId());
    assertEquals(1, meta.getExtensionElements().size());
  }

  /**
   * tests alternate id json
   */
  public void testRDFMetadataJson() throws Exception {
    ResourceSet meta = new ResourceSet();
    meta.setId("id");
    meta.setExtensionElements(new ArrayList<Object>());
    meta.getExtensionElements().add(new ResourceSet());
    meta = processThroughJson(meta);
    assertEquals("id", meta.getId());
    assertEquals(1, meta.getExtensionElements().size());
  }

}

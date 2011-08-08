package org.gedcomx.metadata.rdf;

import org.gedcomx.metadata.dc.DublinCoreDescription;
import org.testng.annotations.Test;

import javax.xml.namespace.QName;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

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
    meta.setContents(Arrays.asList((RDFDescription) new DublinCoreDescription()));
    meta.setOtherAttributes(new HashMap<QName, String>());
    meta.getOtherAttributes().put(new QName("urn:data", "data"), "custom");
    meta.setOtherElements(new ArrayList<Object>());
    meta.getOtherElements().add(new RDFDescriptionSet());
    meta = processThroughXml(meta);
    assertEquals("id", meta.getId());
    assertEquals("custom", meta.getOtherAttributes().get(new QName("urn:data", "data")));
    assertEquals(1, meta.getOtherElements().size());
    assertEquals(1, meta.getContents().size());
  }

  /**
   * tests alternate id json
   */
  public void testRDFMetadataJson() throws Exception {
    RDFDescriptionSet meta = new RDFDescriptionSet();
    meta.setId("id");
    meta.setContents(Arrays.asList((RDFDescription) new DublinCoreDescription()));
    meta.setOtherAttributes(new HashMap<QName, String>());
    meta.getOtherAttributes().put(new QName("urn:data", "data"), "custom");
    meta.setOtherElements(new ArrayList<Object>());
    meta.getOtherElements().add(new RDFDescriptionSet());
    meta = processThroughJson(meta);
    assertEquals("id", meta.getId());
    assertEquals("custom", meta.getOtherAttributes().get(new QName("urn:data", "data")));
    assertEquals(1, meta.getOtherElements().size());
    assertEquals(1, meta.getContents().size());
  }

}

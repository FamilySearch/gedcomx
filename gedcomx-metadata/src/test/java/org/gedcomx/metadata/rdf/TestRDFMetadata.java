package org.gedcomx.metadata.rdf;

import org.testng.annotations.Test;

import javax.xml.bind.JAXBContext;
import javax.xml.namespace.QName;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;

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
    meta.setDataRef(URI.create("urn:dataref"));
    meta.setOtherAttributes(new HashMap<QName, String>());
    meta.getOtherAttributes().put(new QName("urn:data", "data"), "custom");
    meta.setOtherElements(new ArrayList<Object>());
    meta.getOtherElements().add(new RDFMetadataBundle());
    meta = processThroughXml(meta, RDFMetadata.class, JAXBContext.newInstance(RDFMetadata.class, RDFMetadataBundle.class));
    assertEquals("id", meta.getId());
    assertEquals(URI.create("urn:dataref"), meta.getDataRef());
    assertEquals("custom", meta.getOtherAttributes().get(new QName("urn:data", "data")));
    assertEquals(1, meta.getOtherElements().size());
  }

  /**
   * tests alternate id json
   */
  public void testRDFMetadataJson() throws Exception {
    RDFMetadata meta = new RDFMetadata();
    meta.setId("id");
    meta.setDataRef(URI.create("urn:dataref"));
    meta.setOtherAttributes(new HashMap<QName, String>());
    meta.getOtherAttributes().put(new QName("urn:data", "data"), "custom");
    meta.setOtherElements(new ArrayList<Object>());
    meta.getOtherElements().add(new RDFMetadataBundle());
    meta = processThroughJson(meta);
    assertEquals("id", meta.getId());
    assertEquals(URI.create("urn:dataref"), meta.getDataRef());
    assertEquals("custom", meta.getOtherAttributes().get(new QName("urn:data", "data")));
    assertEquals(1, meta.getOtherElements().size());
  }

}

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
public class TestRDFDescription {

  /**
   * tests alternate id xml
   */
  public void testRDFMetadataXml() throws Exception {
    RDFDescription meta = new RDFDescription();
    meta.setId("id");
    meta.setAbout(URI.create("urn:dataref"));
    meta.setExtensionAttributes(new HashMap<QName, String>());
    meta.getExtensionAttributes().put(new QName("urn:data", "data"), "custom");
    meta.setExtensionElements(new ArrayList<Object>());
    meta.getExtensionElements().add(new RDFDescriptionSet());
    meta = processThroughXml(meta, RDFDescription.class, JAXBContext.newInstance(RDFDescription.class, RDFDescriptionSet.class));
    assertEquals("id", meta.getId());
    assertEquals(URI.create("urn:dataref"), meta.getAbout());
    assertEquals("custom", meta.getExtensionAttributes().get(new QName("urn:data", "data")));
    assertEquals(1, meta.getExtensionElements().size());
  }

  /**
   * tests alternate id json
   */
  public void testRDFMetadataJson() throws Exception {
    RDFDescription meta = new RDFDescription();
    meta.setId("id");
    meta.setAbout(URI.create("urn:dataref"));
    meta.setExtensionAttributes(new HashMap<QName, String>());
    meta.getExtensionAttributes().put(new QName("urn:data", "data"), "custom");
    meta.setExtensionElements(new ArrayList<Object>());
    meta.getExtensionElements().add(new RDFDescriptionSet());
    meta = processThroughJson(meta);
    assertEquals("id", meta.getId());
    assertEquals(URI.create("urn:dataref"), meta.getAbout());
    assertEquals("custom", meta.getExtensionAttributes().get(new QName("urn:data", "data")));
    assertEquals(1, meta.getExtensionElements().size());
  }

}

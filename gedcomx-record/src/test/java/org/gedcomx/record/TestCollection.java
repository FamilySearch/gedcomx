package org.gedcomx.record;

import org.gedcomx.common.GenealogicalResource;
import org.gedcomx.common.ResourceReference;
import org.testng.annotations.Test;

import java.net.URI;

import static org.gedcomx.rt.SerializationUtil.processThroughJson;
import static org.gedcomx.rt.SerializationUtil.processThroughXml;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertNotNull;

/**
 * @author Ryan Heaton
 */
@Test
public class TestCollection {

  /**
   * tests collection xml
   */
  public void testCollectionXml() throws Exception {
    RecordCollection collection = new RecordCollection();
    collection.setDescription("description");
    collection.setId("id");
    collection.setParent(new ResourceReference());
    collection.getParent().setResource(URI.create("urn:parent"));
    collection.setPublisher("publisher");
    collection.setTitle("title");
    collection.setBibliographicCitation("bibliographic citation");
    collection = processThroughXml(collection);
    assertEquals("description", collection.getDescription());
    assertEquals("id", collection.getId());
    assertEquals(URI.create("urn:parent"), collection.getParent().getResource());
    assertEquals("publisher", collection.getPublisher());
    assertEquals("title", collection.getTitle());
    assertEquals("bibliographic citation", collection.getBibliographicCitation());
  }

  /**
   * tests collection json
   */
  public void testCollectionJson() throws Exception {
    RecordCollection collection = new RecordCollection();
    collection.setDescription("description");
    collection.setId("id");
    collection.setParent(new ResourceReference());
    collection.getParent().setResource(URI.create("urn:parent"));
    collection.setPublisher("publisher");
    collection.setTitle("title");
    collection.setBibliographicCitation("bibliographic citation");
    collection = processThroughJson(collection);
    assertEquals("description", collection.getDescription());
    assertEquals("id", collection.getId());
    assertEquals(URI.create("urn:parent"), collection.getParent().getResource());
    assertEquals("publisher", collection.getPublisher());
    assertEquals("title", collection.getTitle());
    assertEquals("bibliographic citation", collection.getBibliographicCitation());
  }

}

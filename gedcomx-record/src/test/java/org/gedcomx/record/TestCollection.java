package org.gedcomx.record;

import org.gedcomx.common.GenealogicalResource;
import org.gedcomx.common.ResourceReference;
import org.gedcomx.types.RecordType;
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
    RecordCollection collection = createTestCollection();
    collection = processThroughXml(collection);
    assertCollection(collection);
  }

  /**
   * tests collection json
   */
  public void testCollectionJson() throws Exception {
    RecordCollection collection = createTestCollection();
    collection = processThroughJson(collection);
    assertCollection(collection);
  }

  private RecordCollection createTestCollection() {
    RecordCollection collection = new RecordCollection();
    collection.setDescription("description");
    collection.setId("id");
    collection.setParent(new ResourceReference());
    collection.getParent().setResource(URI.create("urn:parent"));
    collection.setPublisher("publisher");
    collection.setTitle("title");
    collection.setBibliographicCitation("bibliographic citation");
    collection.setSpatial("spatial coverage");
    collection.setTemporal("temporal coverage");
    collection.setKnownRecordType(RecordType.census);
    return collection;
  }

  private void assertCollection(RecordCollection collection) {
    assertEquals("description", collection.getDescription());
    assertEquals("id", collection.getId());
    assertEquals(URI.create("urn:parent"), collection.getParent().getResource());
    assertEquals("publisher", collection.getPublisher());
    assertEquals("title", collection.getTitle());
    assertEquals("bibliographic citation", collection.getBibliographicCitation());
    assertEquals("spatial coverage", collection.getSpatial());
    assertEquals("temporal coverage", collection.getTemporal());
    assertEquals(RecordType.census, collection.getKnownRecordType());
  }

}

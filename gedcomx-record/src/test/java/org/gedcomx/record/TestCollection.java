package org.gedcomx.record;

import org.gedcomx.common.ResourceReference;
import org.gedcomx.types.RecordType;
import org.testng.annotations.Test;

import java.net.URI;
import java.util.ArrayList;

import static org.gedcomx.rt.SerializationUtil.processThroughJson;
import static org.gedcomx.rt.SerializationUtil.processThroughXml;
import static org.testng.AssertJUnit.assertEquals;

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
    collection.setPublisher("publisher");
    collection.setTitle("title");
    collection.setBibliographicCitation("bibliographic citation");
    collection.setSpatial("spatial coverage");
    collection.setTemporal("temporal coverage");
    collection.setKnownRecordType(RecordType.Census);
    collection.setItems(new ArrayList<ResourceReference>());
    ResourceReference resourceReference = new ResourceReference();
    resourceReference.setResource(URI.create("urn:item"));
    collection.getItems().add(resourceReference);
    return collection;
  }

  private void assertCollection(RecordCollection collection) {
    assertEquals("description", collection.getDescription());
    assertEquals("id", collection.getId());
    assertEquals("publisher", collection.getPublisher());
    assertEquals("title", collection.getTitle());
    assertEquals("bibliographic citation", collection.getBibliographicCitation());
    assertEquals("spatial coverage", collection.getSpatial());
    assertEquals("temporal coverage", collection.getTemporal());
    assertEquals("urn:item", collection.getItems().get(0).getResource().toString());
    assertEquals(RecordType.Census, collection.getKnownRecordType());
  }

}

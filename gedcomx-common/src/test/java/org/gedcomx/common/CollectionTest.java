package org.gedcomx.common;

import org.codehaus.enunciate.XmlQNameEnumUtil;
import org.gedcomx.common.Collection;
import org.gedcomx.types.RecordType;
import org.gedcomx.types.TypeReference;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static org.gedcomx.rt.SerializationUtil.processThroughJson;
import static org.gedcomx.rt.SerializationUtil.processThroughXml;
import static org.testng.AssertJUnit.assertEquals;

/**
 * @author Ryan Heaton
 */
@Test
public class CollectionTest {

  /**
   * tests collection xml
   */
  public void testCollectionXml() throws Exception {
    Collection collection = createTestCollection();
    collection = processThroughXml(collection);
    assertCollection(collection);
  }

  /**
   * tests collection json
   */
  public void testCollectionJson() throws Exception {
    Collection collection = createTestCollection();
    collection = processThroughJson(collection);
    assertCollection(collection);
  }

  private Collection createTestCollection() {
    Collection collection = new Collection();
    collection.setDescription("description");
    collection.setId("id");
    collection.setPublisher("publisher");
    collection.setTitle("title");
    collection.setLang("en");
    collection.setBibliographicCitation("bibliographic citation");
    collection.setSpatial("spatial coverage");
    collection.setTemporal("temporal coverage");
    collection.setTypes(new ArrayList<TypeReference>());
    collection.getTypes().add(new TypeReference(RecordType.Birth));
    collection.setItems(new ArrayList<ResourceReference>());
    ResourceReference resourceReference = new ResourceReference();
    resourceReference.setResource(URI.create("urn:item"));
    collection.getItems().add(resourceReference);
    return collection;
  }

  private void assertCollection(Collection collection) {
    assertEquals("description", collection.getDescription());
    assertEquals("id", collection.getId());
    assertEquals("publisher", collection.getPublisher());
    assertEquals("title", collection.getTitle());
    assertEquals("en", collection.getLang());
    assertEquals("bibliographic citation", collection.getBibliographicCitation());
    assertEquals("spatial coverage", collection.getSpatial());
    assertEquals("temporal coverage", collection.getTemporal());
    assertEquals("urn:item", collection.getItems().get(0).getResource().toString());
    assertEquals(1, collection.getTypes().size());
    assertEquals(XmlQNameEnumUtil.toURIValue(RecordType.Birth), collection.getTypes().get(0).getType().toString());
  }

}

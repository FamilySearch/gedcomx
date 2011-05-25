package org.gedcomx.id;

import org.testng.annotations.Test;

import java.net.URI;

import static org.gedcomx.rt.SerializationUtil.processThroughJson;
import static org.gedcomx.rt.SerializationUtil.processThroughXml;
import static org.testng.AssertJUnit.assertEquals;

/**
 * @author Ryan Heaton
 */
@Test
public class TestPersistentId {

  /**
   * tests persistent id xml
   */
  public void testPersistentIdXml() throws Exception {
    PersistentId id = new PersistentId();
    id.setValue(URI.create("value"));
    id = processThroughXml(id);
    assertEquals("value", id.getValue().toString());
  }

  /**
   * tests persistent id json
   */
  public void testPersistentIdJson() throws Exception {
    PersistentId id = new PersistentId();
    id.setValue(URI.create("value"));
    id = processThroughJson(id);
    assertEquals("value", id.getValue().toString());
  }

}

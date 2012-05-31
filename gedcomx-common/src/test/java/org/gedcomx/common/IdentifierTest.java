package org.gedcomx.common;

import org.gedcomx.types.IdentifierType;
import org.testng.annotations.Test;

import static org.gedcomx.rt.SerializationUtil.processThroughJson;
import static org.gedcomx.rt.SerializationUtil.processThroughXml;
import static org.testng.AssertJUnit.assertEquals;

/**
 * @author Ryan Heaton
 */
@Test
public class IdentifierTest {

  /**
   * tests identifier xml
   */
  public void testIdXml() throws Exception {
    Identifier id = new Identifier();
    id.setKnownType(IdentifierType.Forwarded);
    id.setValue("value");
    id = processThroughXml(id);
    assertEquals(IdentifierType.Forwarded, id.getKnownType());
    assertEquals("value", id.getValue());
  }

  /**
   * tests identifier json
   */
  public void testIdJson() throws Exception {
    Identifier id = new Identifier();
    id.setKnownType(IdentifierType.Forwarded);
    id.setValue("value");
    id = processThroughJson(id);
    assertEquals(IdentifierType.Forwarded, id.getKnownType());
    assertEquals("value", id.getValue());
  }

}

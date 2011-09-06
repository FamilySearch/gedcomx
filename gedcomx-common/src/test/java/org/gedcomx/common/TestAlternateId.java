package org.gedcomx.common;

import org.gedcomx.types.AlternateIdType;
import org.testng.annotations.Test;

import static org.gedcomx.rt.SerializationUtil.processThroughJson;
import static org.gedcomx.rt.SerializationUtil.processThroughXml;
import static org.testng.AssertJUnit.assertEquals;

/**
 * @author Ryan Heaton
 */
@Test
public class TestAlternateId {

  /**
   * tests alternate id xml
   */
  public void testAlternateIdXml() throws Exception {
    AlternateId id = new AlternateId();
    id.setKnownType(AlternateIdType.Forwarded);
    id.setValue("value");
    id = processThroughXml(id);
    assertEquals(AlternateIdType.Forwarded, id.getKnownType());
    assertEquals("value", id.getValue());
  }

  /**
   * tests alternate id json
   */
  public void testAlternateIdJson() throws Exception {
    AlternateId id = new AlternateId();
    id.setKnownType(AlternateIdType.Forwarded);
    id.setValue("value");
    id = processThroughJson(id);
    assertEquals(AlternateIdType.Forwarded, id.getKnownType());
    assertEquals("value", id.getValue());
  }

}

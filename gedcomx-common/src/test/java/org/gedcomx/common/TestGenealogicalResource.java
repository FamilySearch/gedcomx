package org.gedcomx.common;

import org.gedcomx.types.AlternateIdType;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.*;

/**
 * @author Ryan Heaton
 */
@Test
public class TestGenealogicalResource {

  /**
   * tests alternate id xml
   */
  public void testProperties() throws Exception {
    GenealogicalResource ext = new CustomResource();
    AlternateId id = new AlternateId();
    id.setKnownType(AlternateIdType.forwarded);
    id.setValue("value");
    ext.addExtensionElement(id);
    ext.addExtensionElement(new Object());
    assertNotNull(ext.findExtensionOfType(AlternateId.class));
    assertEquals(1, ext.findExtensionsOfType(AlternateId.class).size());
    ext.setExtensionElements(null);
    assertNull(ext.getExtensionElements());
    assertNull(ext.findExtensionOfType(AlternateId.class));
    assertEquals(0, ext.findExtensionsOfType(AlternateId.class).size());
  }
}

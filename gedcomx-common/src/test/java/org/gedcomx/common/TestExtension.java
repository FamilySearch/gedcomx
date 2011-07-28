package org.gedcomx.common;

import org.gedcomx.types.AlternateIdType;
import org.testng.annotations.Test;

import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

import java.util.ArrayList;

import static org.gedcomx.rt.SerializationUtil.processThroughJson;
import static org.gedcomx.rt.SerializationUtil.processThroughXml;
import static org.testng.AssertJUnit.*;

/**
 * @author Ryan Heaton
 */
@Test
public class TestExtension {

  /**
   * tests alternate id xml
   */
  public void testProperties() throws Exception {
    Extension ext = new Extension();
    AlternateId id = new AlternateId();
    id.setKnownType(AlternateIdType.forwarded);
    id.setValue("value");
    ext.addElement(id);
    ext.addElement(new Object());
    assertNotNull(ext.findExtensionOfType(AlternateId.class));
    assertEquals(1, ext.findExtensionsOfType(AlternateId.class).size());
    assertTrue(ext.iterator().hasNext());
    ext.setElements(null);
    assertNull(ext.getElements());
    assertNull(ext.findExtensionOfType(AlternateId.class));
    assertEquals(0, ext.findExtensionsOfType(AlternateId.class).size());
    assertFalse(ext.iterator().hasNext());
  }
}

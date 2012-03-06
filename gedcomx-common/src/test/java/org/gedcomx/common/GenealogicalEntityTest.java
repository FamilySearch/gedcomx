package org.gedcomx.common;

import org.gedcomx.types.AlternateIdType;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static org.testng.AssertJUnit.*;

/**
 * @author Ryan Heaton
 */
@Test
public class GenealogicalEntityTest {

  /**
   * tests alternate id xml
   */
  public void testProperties() throws Exception {
    GenealogicalEntity ext = new CustomEntity();
    AlternateId id = new AlternateId();
    id.setKnownType(AlternateIdType.Forwarded);
    id.setValue("value");
    ext.addExtensionElement(id);
    ext.addExtensionElement(new Object());
    ext.setNotes(new ArrayList<Note>());
    ext.getNotes().add(new Note());
    assertNotNull(ext.findExtensionOfType(AlternateId.class));
    assertEquals(1, ext.findExtensionsOfType(AlternateId.class).size());
    ext.setExtensionElements(null);
    assertNull(ext.getExtensionElements());
    assertNull(ext.findExtensionOfType(AlternateId.class));
    assertEquals(0, ext.findExtensionsOfType(AlternateId.class).size());
    assertEquals(1, ext.getNotes().size());
  }
}

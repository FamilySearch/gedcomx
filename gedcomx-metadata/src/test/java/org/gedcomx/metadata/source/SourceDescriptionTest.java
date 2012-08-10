package org.gedcomx.metadata.source;

import org.gedcomx.metadata.CustomEntity;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNull;

public class SourceDescriptionTest {
  @Test
  public void testExtensionElements() throws Exception {
    SourceDescription sourceDescription = new SourceDescription();
    sourceDescription.addExtensionElement(new CustomEntity("alt1"));
    sourceDescription.addExtensionElement(new CustomEntity("alt2"));
    assertEquals(((CustomEntity) sourceDescription.getExtensionElements().get(0)).getId(), "alt1");
    assertEquals(((CustomEntity) sourceDescription.getExtensionElements().get(1)).getId(), "alt2");
    assertNull(sourceDescription.findExtensionOfType(String.class));
    assertEquals(sourceDescription.findExtensionOfType(CustomEntity.class).getId(), "alt1");
    assertEquals(0, sourceDescription.findExtensionsOfType(String.class).size());
    assertEquals(2, sourceDescription.findExtensionsOfType(CustomEntity.class).size());
    assertEquals(sourceDescription.findExtensionsOfType(CustomEntity.class).get(1).getId(), "alt2");

    sourceDescription.setExtensionElements(null);
    assertNull(sourceDescription.findExtensionOfType(CustomEntity.class));
    assertEquals(sourceDescription.findExtensionsOfType(CustomEntity.class).size(), 0);
  }
}

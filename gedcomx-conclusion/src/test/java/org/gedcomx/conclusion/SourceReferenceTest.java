package org.gedcomx.conclusion;

import org.gedcomx.common.URI;
import org.gedcomx.rt.SerializationUtil;
import org.gedcomx.types.ResourceType;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static org.gedcomx.rt.SerializationUtil.processThroughJson;
import static org.gedcomx.rt.SerializationUtil.processThroughXml;
import static org.testng.AssertJUnit.assertEquals;

/**
 * @author Ryan Heaton
 */
@Test
public class SourceReferenceTest {

  /**
   * tests source reference xml
   */
  public void testSourceReferenceXml() throws Exception {
    SourceReference reference = new SourceReference();
    reference.setResource(URI.create("urn:someid"));
    reference.setKnownType(ResourceType.Collection);
    reference.setId("refid");
    reference.setExtensionElements(new ArrayList<Object>());
    reference.getExtensionElements().add(new CustomEntity("alt"));
    CustomEntity custom = new CustomEntity();
    custom.setSource(reference);
    custom = SerializationUtil.processThroughXml(custom);
    AssertJUnit.assertEquals("urn:someid", custom.getSource().getResource().toString());
    assertEquals(ResourceType.Collection, custom.getSource().getKnownType());
    assertEquals("refid", custom.getSource().getId());
    AssertJUnit.assertEquals("alt", ((CustomEntity) custom.getSource().getExtensionElements().get(0)).getId());
  }

  /**
   * tests source reference json
   */
  public void testSourceReferenceJson() throws Exception {
    SourceReference reference = new SourceReference();
    reference.setResource(URI.create("urn:someid"));
    reference.setKnownType(ResourceType.Collection);
    reference.setId("refid");
    reference.setExtensionElements(new ArrayList<Object>());
    reference.getExtensionElements().add(new CustomEntity("alt"));
    CustomEntity custom = new CustomEntity();
    custom.setSource(reference);
    custom = SerializationUtil.processThroughJson(custom);
    AssertJUnit.assertEquals("urn:someid", custom.getSource().getResource().toString());
    assertEquals(ResourceType.Collection, custom.getSource().getKnownType());
    assertEquals("refid", custom.getSource().getId());
    AssertJUnit.assertEquals("alt", ((CustomEntity) custom.getSource().getExtensionElements().get(0)).getId());
  }

}

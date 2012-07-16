package org.gedcomx.common;

import org.gedcomx.rt.SerializationUtil;
import org.gedcomx.types.SourceReferenceType;
import org.testng.annotations.Test;

import java.util.ArrayList;

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
    reference.setKnownType(SourceReferenceType.Abstract);
    reference.setSourceDescription(URI.create("urn:srcDescInstance"));
    reference.setSource(URI.create("urn:someid"));
    reference.setId("refid");
    reference.setExtensionElements(new ArrayList<Object>());
    reference.getExtensionElements().add(new CustomEntity("alt"));
    CustomEntity custom = new CustomEntity();
    custom.setSource(reference);
    custom = SerializationUtil.processThroughXml(custom);
    assertEquals(SourceReferenceType.Abstract, custom.getSource().getKnownType());
    assertEquals("urn:srcDescInstance", custom.getSource().getSourceDescription().toString());
    assertEquals("urn:someid", custom.getSource().getSource().toString());
    assertEquals("refid", custom.getSource().getId());
    assertEquals("alt", ((CustomEntity) custom.getSource().getExtensionElements().get(0)).getId());
  }

  /**
   * tests source reference json
   */
  public void testSourceReferenceJson() throws Exception {
    SourceReference reference = new SourceReference();
    reference.setKnownType(SourceReferenceType.Analysis);
    reference.setSourceDescription(URI.create("urn:srcDescInstance"));
    reference.setSource(URI.create("urn:someid"));
    reference.setId("refid");
    reference.setExtensionElements(new ArrayList<Object>());
    reference.getExtensionElements().add(new CustomEntity("alt"));
    CustomEntity custom = new CustomEntity();
    custom.setSource(reference);
    custom = SerializationUtil.processThroughJson(custom);
    assertEquals(SourceReferenceType.Analysis, custom.getSource().getKnownType());
    assertEquals("urn:srcDescInstance", custom.getSource().getSourceDescription().toString());
    assertEquals("urn:someid", custom.getSource().getSource().toString());
    assertEquals("refid", custom.getSource().getId());
    assertEquals("alt", ((CustomEntity) custom.getSource().getExtensionElements().get(0)).getId());
  }

}

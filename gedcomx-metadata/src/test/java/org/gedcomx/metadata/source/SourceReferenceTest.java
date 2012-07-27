package org.gedcomx.metadata.source;

import org.gedcomx.common.Attribution;
import org.gedcomx.common.ResourceReference;
import org.gedcomx.common.URI;
import org.gedcomx.metadata.CustomEntity;
import org.gedcomx.rt.SerializationUtil;
import org.gedcomx.types.SourceReferenceType;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertNull;


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
    reference.setAttribution(new Attribution());
    reference.getAttribution().setContributor(new ResourceReference(URI.create("urn:contributorid")));
    reference.setSourceDescription(URI.create("urn:srcDescInstance"));
    reference.setId("refid");
    reference.addExtensionElement(new CustomEntity("alt1"));
    reference.addExtensionElement(new CustomEntity("alt2"));
    CustomEntity custom = new CustomEntity();
    custom.setSource(reference);
    custom = SerializationUtil.processThroughXml(custom);
    assertEquals(SourceReferenceType.Abstract, custom.getSource().getKnownType());
    assertEquals(SourceReferenceType.Abstract.toQNameURI().toString(), custom.getSource().getType().toURI().toString());
    assertEquals("urn:contributorid", custom.getSource().getAttribution().toString());
    assertEquals("urn:srcDescInstance", custom.getSource().getSourceDescription().toString());
    assertEquals("refid", custom.getSource().getId());
    AssertJUnit.assertEquals("alt1", ((CustomEntity) custom.getSource().getExtensionElements().get(0)).getId());
    AssertJUnit.assertEquals("alt2", ((CustomEntity) custom.getSource().getExtensionElements().get(1)).getId());
    assertNull(custom.getSource().findExtensionOfType(String.class));
    assertEquals("alt1", custom.getSource().findExtensionOfType(CustomEntity.class).getId());
    assertEquals(0, custom.getSource().findExtensionsOfType(String.class).size());
    assertEquals(2, custom.getSource().findExtensionsOfType(CustomEntity.class).size());
    assertEquals("alt2", custom.getSource().findExtensionsOfType(CustomEntity.class).get(1).getId());

    reference.setKnownType(null);
    assertNull(reference.getKnownType());
    assertNull(reference.getType());

    reference.setKnownType(SourceReferenceType.Abstract);
    reference.setType(null);
    assertNull(reference.getKnownType());
    assertNull(reference.getType());

    reference.setSourceDescription((URI)null);
    reference.setAttribution(null);
    reference.setExtensionElements(null);
    assertNull(reference.getSourceDescription());
    assertNull(reference.getAttribution());
    assertNull(reference.findExtensionOfType(CustomEntity.class));
    assertEquals(0, reference.findExtensionsOfType(CustomEntity.class).size());
  }

  /**
   * tests source reference json
   */
  public void testSourceReferenceJson() throws Exception {
    SourceReference reference = new SourceReference();
    reference.setType(SourceReferenceType.Analysis.toQNameURI());
    reference.setSourceDescription(URI.create("urn:srcDescInstance"));
    reference.setId("refid");
    reference.setExtensionElements(new ArrayList<Object>());
    reference.getExtensionElements().add(new CustomEntity("alt"));
    CustomEntity custom = new CustomEntity();
    custom.setSource(reference);
    custom = SerializationUtil.processThroughJson(custom);
    assertEquals(SourceReferenceType.Analysis, custom.getSource().getKnownType());
    assertEquals("urn:srcDescInstance", custom.getSource().getSourceDescription().toString());
    assertEquals("refid", custom.getSource().getId());
    AssertJUnit.assertEquals("alt", ((CustomEntity) custom.getSource().getExtensionElements().get(0)).getId());
  }

}
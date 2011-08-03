package org.gedcomx.source;

import org.gedcomx.types.SourceType;
import org.testng.annotations.Test;

import java.net.URI;
import java.util.ArrayList;

import static org.gedcomx.rt.SerializationUtil.processThroughJson;
import static org.gedcomx.rt.SerializationUtil.processThroughXml;
import static org.testng.AssertJUnit.assertEquals;

/**
 * @author Ryan Heaton
 */
@Test
public class TestSourceReference {

  /**
   * tests source reference xml
   */
  public void testSourceReferenceXml() throws Exception {
    SourceReference reference = new SourceReference();
    reference.setHref(URI.create("urn:someid"));
    reference.setKnownType(SourceType.collection);
    reference.setId("refid");
    reference.setQualifiers(new ArrayList<SourceQualifier>());
    SourceQualifier q = new SourceQualifier();
    q.setAttribute(SourceQualifierAttribute.height_pixels, "1234");
    reference.getQualifiers().add(q);
    reference = processThroughXml(reference);
    assertEquals("urn:someid", reference.getHref().toString());
    assertEquals(SourceType.collection, reference.getKnownType());
    assertEquals("refid", reference.getId());
    assertEquals("1234", reference.getQualifiers().get(0).getAttribute(SourceQualifierAttribute.height_pixels));
  }

  /**
   * tests source reference json
   */
  public void testSourceReferenceJson() throws Exception {
    SourceReference reference = new SourceReference();
    reference.setHref(URI.create("urn:someid"));
    reference.setKnownType(SourceType.collection);
    reference.setId("refid");
    reference.setQualifiers(new ArrayList<SourceQualifier>());
    SourceQualifier q = new SourceQualifier();
    q.setAttribute(SourceQualifierAttribute.height_pixels, "1234");
    reference.getQualifiers().add(q);
    reference = processThroughJson(reference);
    assertEquals("urn:someid", reference.getHref().toString());
    assertEquals(SourceType.collection, reference.getKnownType());
    assertEquals("refid", reference.getId());
    assertEquals("1234", reference.getQualifiers().get(0).getAttribute(SourceQualifierAttribute.height_pixels));
  }

}

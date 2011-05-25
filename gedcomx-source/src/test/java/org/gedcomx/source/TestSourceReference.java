package org.gedcomx.source;

import org.gedcomx.types.SourceReferenceType;
import org.testng.annotations.Test;

import java.net.URI;

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
    reference.setKnownType(SourceReferenceType.source);
    reference.setId("refid");
    //todo: test source qualifiers
    //reference.setQualifiers();
    reference = processThroughXml(reference);
    assertEquals("urn:someid", reference.getHref().toString());
    assertEquals(SourceReferenceType.source, reference.getKnownType());
    assertEquals("refid", reference.getId());
  }

  /**
   * tests source reference json
   */
  public void testSourceReferenceJson() throws Exception {
    SourceReference reference = new SourceReference();
    reference.setHref(URI.create("urn:someid"));
    reference.setKnownType(SourceReferenceType.source);
    reference.setId("refid");
    //todo: test source qualifiers
    //reference.setQualifiers();
    reference = processThroughJson(reference);
    assertEquals("urn:someid", reference.getHref().toString());
    assertEquals(SourceReferenceType.source, reference.getKnownType());
    assertEquals("refid", reference.getId());
  }

}

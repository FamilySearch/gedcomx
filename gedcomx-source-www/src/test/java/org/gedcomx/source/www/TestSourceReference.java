package org.gedcomx.source.www;

import org.gedcomx.types.SourceReferenceType;
import org.gedcomx.www.Link;
import org.gedcomx.www.Links;
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
    reference.setKnownType(SourceReferenceType.source);
    reference.setId("refid");
    reference.setLinks(new Links());
    reference.getLinks().setLinks(new ArrayList<Link>());
    Link link = new Link();
    link.setHref(URI.create("urn:href"));
    reference.getLinks().getLinks().add(link);
    //todo: test source qualifiers
    //reference.setQualifiers();
    reference = processThroughXml(reference);
    assertEquals("urn:someid", reference.getHref().toString());
    assertEquals(SourceReferenceType.source, reference.getKnownType());
    assertEquals("refid", reference.getId());
    assertEquals(1, reference.getLinks().getLinks().size());
    assertEquals("urn:href", reference.getLinks().getLinks().get(0).getHref().toString());
  }

  /**
   * tests source reference json
   */
  public void testSourceReferenceJson() throws Exception {
    SourceReference reference = new SourceReference();
    reference.setHref(URI.create("urn:someid"));
    reference.setKnownType(SourceReferenceType.source);
    reference.setId("refid");
    reference.setLinks(new Links());
    reference.getLinks().setLinks(new ArrayList<Link>());
    Link link = new Link();
    link.setHref(URI.create("urn:href"));
    reference.getLinks().getLinks().add(link);
    //todo: test source qualifiers
    //reference.setQualifiers();
    reference = processThroughJson(reference);
    assertEquals("urn:someid", reference.getHref().toString());
    assertEquals(SourceReferenceType.source, reference.getKnownType());
    assertEquals("refid", reference.getId());
    assertEquals(1, reference.getLinks().getLinks().size());
    assertEquals("urn:href", reference.getLinks().getLinks().get(0).getHref().toString());
  }

}

package org.gedcomx.source.www;

import org.gedcomx.common.Extension;
import org.gedcomx.source.SourceReference;
import org.gedcomx.types.SourceType;
import org.gedcomx.www.Link;
import org.testng.annotations.Test;

import javax.xml.bind.JAXBContext;
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
    reference.setKnownType(SourceType.source);
    reference.setId("refid");
    reference.setExtension(new Extension());
    Link link = new Link();
    link.setHref(URI.create("urn:href"));
    reference.getExtension().addElement(link);
    //todo: test source qualifiers
    //reference.setQualifiers();
    reference = processThroughXml(reference, SourceReference.class, JAXBContext.newInstance(SourceReference.class, Link.class));
    assertEquals("urn:someid", reference.getHref().toString());
    assertEquals(SourceType.source, reference.getKnownType());
    assertEquals("refid", reference.getId());
    assertEquals(1, reference.getExtension().findExtensionsOfType(Link.class).size());
    assertEquals("urn:href", reference.getExtension().findExtensionsOfType(Link.class).get(0).getHref().toString());
  }

  /**
   * tests source reference json
   */
  public void testSourceReferenceJson() throws Exception {
    SourceReference reference = new SourceReference();
    reference.setHref(URI.create("urn:someid"));
    reference.setKnownType(SourceType.source);
    reference.setId("refid");
    reference.setExtension(new Extension());
    Link link = new Link();
    link.setHref(URI.create("urn:href"));
    reference.getExtension().addElement(link);
    //todo: test source qualifiers
    //reference.setQualifiers();
    reference = processThroughJson(reference);
    assertEquals("urn:someid", reference.getHref().toString());
    assertEquals(SourceType.source, reference.getKnownType());
    assertEquals("refid", reference.getId());
    assertEquals(1, reference.getExtension().findExtensionsOfType(Link.class).size());
    assertEquals("urn:href", reference.getExtension().findExtensionsOfType(Link.class).get(0).getHref().toString());
  }

}

package org.gedcomx.source;

import org.gedcomx.attribution.Attribution;
import org.gedcomx.common.AlternateId;
import org.gedcomx.common.Extension;
import org.gedcomx.types.SourceType;
import org.testng.annotations.Test;

import javax.xml.namespace.QName;
import java.net.URI;
import java.util.ArrayList;

import static org.gedcomx.rt.SerializationUtil.processThroughJson;
import static org.gedcomx.rt.SerializationUtil.processThroughXml;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertNotNull;

/**
 * @author Ryan Heaton
 */
@Test
public class TestSource {

  /**
   * tests alternate id xml
   */
  public void testSourceXml() throws Exception {
    Source source = new Source();
    source.setAlternateIds(new ArrayList<AlternateId>());
    source.getAlternateIds().add(new AlternateId());
    source.setAttribution(new Attribution());
    source.setBibliographicCitation("citation");
    source.setExtension(new Extension());
    source.setId("source");
    source.setType(new QName("urn:custom", "custom"));
    source.setNote("note");
    source.setPersistentId(URI.create("urn:pid"));
    source.setTitle("title");
    source.setWebLocation(URI.create("urn:here"));
    source = processThroughXml(source);
    assertNotNull(source.getAlternateIds());
    assertNotNull(source.getAttribution());
    assertEquals("citation", source.getBibliographicCitation());
    assertNotNull(source.getExtension());
    assertEquals("source", source.getId());
    assertEquals(SourceType.other, source.getKnownType());
    assertEquals("note", source.getNote());
    assertEquals(URI.create("urn:pid"), source.getPersistentId());
    assertEquals("title", source.getTitle());
    assertEquals(URI.create("urn:here"), source.getWebLocation());
  }

  /**
   * tests alternate id json
   */
  public void testSourceJson() throws Exception {
    Source source = new Source();
    source.setAlternateIds(new ArrayList<AlternateId>());
    source.getAlternateIds().add(new AlternateId());
    source.setAttribution(new Attribution());
    source.setBibliographicCitation("citation");
    source.setExtension(new Extension());
    source.setId("source");
    source.setType(new QName("urn:custom", "custom"));
    source.setNote("note");
    source.setPersistentId(URI.create("urn:pid"));
    source.setTitle("title");
    source.setWebLocation(URI.create("urn:here"));
    source = processThroughJson(source);
    assertNotNull(source.getAlternateIds());
    assertNotNull(source.getAttribution());
    assertEquals("citation", source.getBibliographicCitation());
    assertNotNull(source.getExtension());
    assertEquals("source", source.getId());
    assertEquals(SourceType.other, source.getKnownType());
    assertEquals("note", source.getNote());
    assertEquals(URI.create("urn:pid"), source.getPersistentId());
    assertEquals("title", source.getTitle());
    assertEquals(URI.create("urn:here"), source.getWebLocation());
  }

}

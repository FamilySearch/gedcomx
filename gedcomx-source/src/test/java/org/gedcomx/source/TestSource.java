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
    SourceDescription sourceDescription = new SourceDescription();
    sourceDescription.setAlternateIds(new ArrayList<AlternateId>());
    sourceDescription.getAlternateIds().add(new AlternateId());
    sourceDescription.setAttribution(new Attribution());
    sourceDescription.setBibliographicCitation("citation");
    sourceDescription.setExtension(new Extension());
    sourceDescription.setId("source");
    sourceDescription.setType(new QName("urn:custom", "custom"));
    sourceDescription.setPersistentId(URI.create("urn:pid"));
    sourceDescription.setTitle("title");
    sourceDescription.setAbout(URI.create("urn:here"));
    sourceDescription.setSources(new ArrayList<SourceReference>());
    sourceDescription.getSources().add(new SourceReference());
    sourceDescription = processThroughXml(sourceDescription);
    assertNotNull(sourceDescription.getAlternateIds());
    assertNotNull(sourceDescription.getAttribution());
    assertEquals("citation", sourceDescription.getBibliographicCitation());
    assertNotNull(sourceDescription.getExtension());
    assertEquals("source", sourceDescription.getId());
    assertEquals(SourceType.other, sourceDescription.getKnownType());
    assertEquals(URI.create("urn:pid"), sourceDescription.getPersistentId());
    assertEquals("title", sourceDescription.getTitle());
    assertEquals(URI.create("urn:here"), sourceDescription.getAbout());
    assertEquals(1, sourceDescription.getSources().size());
  }

  /**
   * tests alternate id json
   */
  public void testSourceJson() throws Exception {
    SourceDescription sourceDescription = new SourceDescription();
    sourceDescription.setAlternateIds(new ArrayList<AlternateId>());
    sourceDescription.getAlternateIds().add(new AlternateId());
    sourceDescription.setAttribution(new Attribution());
    sourceDescription.setBibliographicCitation("citation");
    sourceDescription.setExtension(new Extension());
    sourceDescription.setId("source");
    sourceDescription.setType(new QName("urn:custom", "custom"));
    sourceDescription.setPersistentId(URI.create("urn:pid"));
    sourceDescription.setTitle("title");
    sourceDescription.setAbout(URI.create("urn:here"));
    sourceDescription.setSources(new ArrayList<SourceReference>());
    sourceDescription.getSources().add(new SourceReference());
    sourceDescription = processThroughJson(sourceDescription);
    assertNotNull(sourceDescription.getAlternateIds());
    assertNotNull(sourceDescription.getAttribution());
    assertEquals("citation", sourceDescription.getBibliographicCitation());
    assertNotNull(sourceDescription.getExtension());
    assertEquals("source", sourceDescription.getId());
    assertEquals(SourceType.other, sourceDescription.getKnownType());
    assertEquals(URI.create("urn:pid"), sourceDescription.getPersistentId());
    assertEquals("title", sourceDescription.getTitle());
    assertEquals(URI.create("urn:here"), sourceDescription.getAbout());
    assertEquals(1, sourceDescription.getSources().size());
  }

}

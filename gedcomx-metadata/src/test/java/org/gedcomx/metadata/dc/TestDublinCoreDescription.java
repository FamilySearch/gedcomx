package org.gedcomx.metadata.dc;

import org.gedcomx.metadata.rdf.RDFLiteral;
import org.gedcomx.metadata.rdf.RDFValue;
import org.testng.annotations.Test;

import javax.xml.namespace.QName;
import java.net.URI;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import static org.gedcomx.rt.SerializationUtil.processThroughJson;
import static org.gedcomx.rt.SerializationUtil.processThroughXml;
import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertEquals;

/**
 * @author Ryan Heaton
 */
@Test
public class TestDublinCoreDescription {

  /**
   * tests alternate id xml
   */
  public void testDublinCoreMetadataXml() throws Exception {
    DublinCoreDescription metadata = createMetadata();
    metadata = processThroughXml(metadata);
    assertMetadata(metadata);
  }

  /**
   * tests alternate id json
   */
  public void testDublinCoreMetadataJson() throws Exception {
    DublinCoreDescription metadata = createMetadata();
    metadata = processThroughJson(metadata);
    assertMetadata(metadata);
  }

  private DublinCoreDescription createMetadata() {
    DublinCoreDescription metadata = new DublinCoreDescription();
    RDFValue abstrct = new RDFValue();
    abstrct.setValue("title");
    abstrct.setLang("en");
    abstrct.setOtherAttributes(new HashMap<QName, String>());
    abstrct.getOtherAttributes().put(new QName("urn:hi", "hi"), "hello");
    abstrct.setValueRef(URI.create("urn:abstract"));
    metadata.setAbstract(abstrct);
    metadata.setAccessRights(new ArrayList<RDFValue>());
    metadata.setAccrualMethod(new RDFValue());
    metadata.setAccrualPeriodicity(new RDFValue());
    metadata.setAccrualPolicy(new RDFValue());
    metadata.setAlternative(new ArrayList<RDFLiteral>());
    metadata.setAudience(new ArrayList<RDFValue>());
    metadata.setAvailable(new Date());
    metadata.setBibliographicCitation(new RDFLiteral());
    metadata.setConformsTo(new ArrayList<RDFValue>());
    metadata.setContributor(new ArrayList<RDFValue>());
    metadata.setCoverage(new RDFValue());
    metadata.setCreated(new Date());
    metadata.setCreator(new ArrayList<RDFValue>());
    metadata.setDate(new Date());
    metadata.setDate(new Date(12345L));
    metadata.setDateAccepted(new Date());
    metadata.setDateCopyrighted(new Date());
    metadata.setDateSubmitted(new Date());
    metadata.setDescription(new RDFValue());
    metadata.setEducationLevel(new RDFValue());
    metadata.setExtent(new RDFValue());
    metadata.setFormat(new RDFValue());
    metadata.setFormatOf(new ArrayList<RDFValue>());
    metadata.setHasFormat(new ArrayList<RDFValue>());
    metadata.setHasPart(new ArrayList<RDFValue>());
    metadata.setHasVersion(new ArrayList<RDFValue>());
    metadata.setIdentifier(new RDFValue());
    metadata.setInstructionalMethod(new RDFValue());
    metadata.setIssued(new Date());
    metadata.setLanguage(new ArrayList<RDFValue>());
    metadata.setLicense(new ArrayList<RDFValue>());
    metadata.setMediator(new ArrayList<RDFValue>());
    metadata.setMedium(new RDFValue());
    metadata.setModified(new Date());
    metadata.setPartOf(new ArrayList<RDFValue>());
    metadata.setProvenance(new RDFValue());
    metadata.setPublisher(new RDFValue());
    metadata.setReferencedBy(new ArrayList<RDFValue>());
    metadata.setReferences(new ArrayList<RDFValue>());
    metadata.setRelation(new ArrayList<RDFValue>());
    metadata.setReplacedBy(new ArrayList<RDFValue>());
    metadata.setReplaces(new ArrayList<RDFValue>());
    metadata.setRequiredBy(new ArrayList<RDFValue>());
    metadata.setRequires(new ArrayList<RDFValue>());
    metadata.setRights(new ArrayList<RDFValue>());
    metadata.setRightsHolder(new RDFValue());
    metadata.setSource(new ArrayList<RDFValue>());
    metadata.setSpatial(new ArrayList<RDFValue>());
    metadata.setTableOfContents(new RDFValue());
    metadata.setTemporal(new ArrayList<RDFValue>());
    RDFLiteral titleProperty = new RDFLiteral();
    titleProperty.setValue("title");
    titleProperty.setLang("en");
    titleProperty.setOtherAttributes(new HashMap<QName, String>());
    titleProperty.getOtherAttributes().put(new QName("urn:hi", "hi"), "hello");
    metadata.setTitle(titleProperty);
    metadata.setKnownType(DublinCoreType.Event);
    metadata.setValid(new ArrayList<RDFValue>());
    metadata.setVersionOf(new RDFValue());
    return metadata;
  }

  private void assertMetadata(DublinCoreDescription metadata) {
    RDFValue abstrct = metadata.getAbstract();
    assertTrue(abstrct != null);
    assertEquals("title", abstrct.getValue());
    assertEquals("en", abstrct.getLang());
    assertEquals("hello", abstrct.getOtherAttributes().get(new QName("urn:hi", "hi")));
    assertEquals(URI.create("urn:abstract"), abstrct.getValueRef());
    assertTrue(metadata.getAccessRights() == null || metadata.getAccessRights().isEmpty());
    assertTrue(metadata.getAccrualMethod() != null);
    assertTrue(metadata.getAccrualPeriodicity() != null);
    assertTrue(metadata.getAccrualPolicy() != null);
    assertTrue(metadata.getAlternative() == null || metadata.getAlternative().isEmpty());
    assertTrue(metadata.getAudience() == null || metadata.getAudience().isEmpty());
    assertTrue(metadata.getAvailable() != null);
    assertTrue(metadata.getBibliographicCitation() != null);
    assertTrue(metadata.getConformsTo() == null || metadata.getConformsTo().isEmpty());
    assertTrue(metadata.getContributor() == null || metadata.getContributor().isEmpty());
    assertTrue(metadata.getCoverage() != null);
    assertTrue(metadata.getCreated() != null);
    assertTrue(metadata.getCreator() == null || metadata.getCreator().isEmpty());
    assertEquals(new Date(12345L), metadata.getDate());
    assertTrue(metadata.getDateAccepted() != null);
    assertTrue(metadata.getDateCopyrighted() != null);
    assertTrue(metadata.getDateSubmitted() != null);
    assertTrue(metadata.getDescription() != null);
    assertTrue(metadata.getEducationLevel() != null);
    assertTrue(metadata.getExtent() != null);
    assertTrue(metadata.getFormat() != null);
    assertTrue(metadata.getFormatOf() == null || metadata.getFormatOf().isEmpty());
    assertTrue(metadata.getHasFormat() == null || metadata.getHasFormat().isEmpty());
    assertTrue(metadata.getHasPart() == null || metadata.getHasPart().isEmpty());
    assertTrue(metadata.getHasVersion() == null || metadata.getHasVersion().isEmpty());
    assertTrue(metadata.getIdentifier() != null);
    assertTrue(metadata.getInstructionalMethod() != null);
    assertTrue(metadata.getIssued() != null);
    assertTrue(metadata.getLanguage() == null || metadata.getLanguage().isEmpty());
    assertTrue(metadata.getLicense() == null || metadata.getLicense().isEmpty());
    assertTrue(metadata.getMediator() == null || metadata.getMediator().isEmpty());
    assertTrue(metadata.getMedium() != null);
    assertTrue(metadata.getModified() != null);
    assertTrue(metadata.getPartOf() == null || metadata.getPartOf().isEmpty());
    assertTrue(metadata.getProvenance() != null);
    assertTrue(metadata.getPublisher() != null);
    assertTrue(metadata.getReferencedBy() == null || metadata.getReferencedBy().isEmpty());
    assertTrue(metadata.getReferences() == null || metadata.getReferences().isEmpty());
    assertTrue(metadata.getRelation() == null || metadata.getRelation().isEmpty());
    assertTrue(metadata.getReplacedBy() == null || metadata.getReplacedBy().isEmpty());
    assertTrue(metadata.getReplaces() == null || metadata.getReplaces().isEmpty());
    assertTrue(metadata.getRequiredBy() == null || metadata.getRequiredBy().isEmpty());
    assertTrue(metadata.getRequires() == null || metadata.getRequires().isEmpty());
    assertTrue(metadata.getRights() == null || metadata.getRights().isEmpty());
    assertTrue(metadata.getRightsHolder() != null);
    assertTrue(metadata.getSource() == null || metadata.getSource().isEmpty());
    assertTrue(metadata.getSpatial() == null || metadata.getSpatial().isEmpty());
    assertTrue(metadata.getTableOfContents() != null);
    assertTrue(metadata.getTemporal() == null || metadata.getTemporal().isEmpty());
    RDFLiteral titleProperty = metadata.getTitle();
    assertEquals("title", titleProperty.getValue());
    assertEquals("en", titleProperty.getLang());
    assertEquals("hello", titleProperty.getOtherAttributes().get(new QName("urn:hi", "hi")));
    assertEquals(DublinCoreType.Event, metadata.getKnownType());
    assertTrue(metadata.getValid() == null || metadata.getValid().isEmpty());
    assertTrue(metadata.getVersionOf() != null);
  }

}

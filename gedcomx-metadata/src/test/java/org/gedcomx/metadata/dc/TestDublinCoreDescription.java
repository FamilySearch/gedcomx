package org.gedcomx.metadata.dc;

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
    metadata.setAbstract(new DublinCoreStringProperty());
    metadata.setAccessRights(new ArrayList<DublinCoreStringProperty>());
    metadata.setAccrualMethod(new DublinCoreStringProperty());
    metadata.setAccrualPeriodicity(new DublinCoreStringProperty());
    metadata.setAccrualPolicy(new DublinCoreStringProperty());
    metadata.setAlternative(new ArrayList<DublinCoreStringProperty>());
    metadata.setAudience(new ArrayList<DublinCoreStringProperty>());
    metadata.setAvailable(new Date());
    metadata.setBibliographicCitation(new DublinCoreStringProperty());
    metadata.setConformsTo(new ArrayList<DublinCoreStringProperty>());
    metadata.setContributor(new ArrayList<DublinCoreStringProperty>());
    metadata.setCoverage(new DublinCoreStringProperty());
    metadata.setCreated(new Date());
    metadata.setCreator(new ArrayList<DublinCoreStringProperty>());
    metadata.setDate(new Date());
    metadata.setDate(new Date(12345L));
    metadata.setDateAccepted(new Date());
    metadata.setDateCopyrighted(new Date());
    metadata.setDateSubmitted(new Date());
    metadata.setDescription(new DublinCoreStringProperty());
    metadata.setEducationLevel(new DublinCoreStringProperty());
    metadata.setExtent(new DublinCoreStringProperty());
    metadata.setFormat(new DublinCoreStringProperty());
    metadata.setFormatOf(new ArrayList<DublinCoreStringProperty>());
    metadata.setHasFormat(new ArrayList<DublinCoreStringProperty>());
    metadata.setHasPart(new ArrayList<DublinCoreStringProperty>());
    metadata.setHasVersion(new ArrayList<DublinCoreStringProperty>());
    metadata.setIdentifier(new DublinCoreStringProperty());
    metadata.setInstructionalMethod(new DublinCoreStringProperty());
    metadata.setIssued(new Date());
    metadata.setLanguage(new ArrayList<DublinCoreStringProperty>());
    metadata.setLicense(new ArrayList<DublinCoreStringProperty>());
    metadata.setMediator(new ArrayList<DublinCoreStringProperty>());
    metadata.setMedium(new DublinCoreStringProperty());
    metadata.setModified(new Date());
    metadata.setPartOf(new ArrayList<DublinCoreStringProperty>());
    metadata.setProvenance(new DublinCoreStringProperty());
    metadata.setPublisher(new DublinCoreStringProperty());
    metadata.setReferencedBy(new ArrayList<DublinCoreStringProperty>());
    metadata.setReferences(new ArrayList<DublinCoreStringProperty>());
    metadata.setRelation(new ArrayList<DublinCoreStringProperty>());
    metadata.setReplacedBy(new ArrayList<DublinCoreStringProperty>());
    metadata.setReplaces(new ArrayList<DublinCoreStringProperty>());
    metadata.setRequiredBy(new ArrayList<DublinCoreStringProperty>());
    metadata.setRequires(new ArrayList<DublinCoreStringProperty>());
    metadata.setRights(new ArrayList<DublinCoreStringProperty>());
    metadata.setRightsHolder(new DublinCoreStringProperty());
    metadata.setSource(new ArrayList<DublinCoreStringProperty>());
    metadata.setSpatial(new ArrayList<DublinCoreStringProperty>());
    metadata.setTableOfContents(new DublinCoreStringProperty());
    metadata.setTemporal(new ArrayList<DublinCoreStringProperty>());
    metadata.setTitle(new DublinCoreStringProperty());
    DublinCoreStringProperty titleProperty = new DublinCoreStringProperty();
    titleProperty.setId("id");
    titleProperty.setValue("title");
    titleProperty.setLang("en");
    titleProperty.setOtherAttributes(new HashMap<QName, String>());
    titleProperty.getOtherAttributes().put(new QName("urn:hi", "hi"), "hello");
    titleProperty.setValueRef(URI.create("urn:ref"));
    metadata.setTitle(titleProperty);
    metadata.setKnownType(DublinCoreType.Event);
    metadata.setValid(new ArrayList<DublinCoreStringProperty>());
    metadata.setVersionOf(new DublinCoreStringProperty());
    return metadata;
  }

  private void assertMetadata(DublinCoreDescription metadata) {
    assertTrue(metadata.getAbstract() != null);
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
    DublinCoreStringProperty titleProperty = metadata.getTitle();
    assertEquals("id", titleProperty.getId());
    assertEquals("title", titleProperty.getValue());
    assertEquals("en", titleProperty.getLang());
    assertEquals("hello", titleProperty.getOtherAttributes().get(new QName("urn:hi", "hi")));
    assertEquals(URI.create("urn:ref"), titleProperty.getValueRef());
    assertEquals(DublinCoreType.Event, metadata.getKnownType());
    assertTrue(metadata.getValid() == null || metadata.getValid().isEmpty());
    assertTrue(metadata.getVersionOf() != null);
  }

}

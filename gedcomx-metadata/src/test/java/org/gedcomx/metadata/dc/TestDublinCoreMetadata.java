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
public class TestDublinCoreMetadata {

  /**
   * tests alternate id xml
   */
  public void testDublinCoreMetadataXml() throws Exception {
    DublinCoreMetadata metadata = createMetadata();
    metadata = processThroughXml(metadata);
    assertMetadata(metadata);
  }

  /**
   * tests alternate id json
   */
  public void testDublinCoreMetadataJson() throws Exception {
    DublinCoreMetadata metadata = createMetadata();
    metadata = processThroughJson(metadata);
    assertMetadata(metadata);
  }

  private DublinCoreMetadata createMetadata() {
    DublinCoreMetadata metadata = new DublinCoreMetadata();
    metadata.setAbstract(new ArrayList<DublinCoreStringProperty>());
    metadata.setAccessRights(new ArrayList<DublinCoreStringProperty>());
    metadata.setAccrualMethod(new ArrayList<DublinCoreStringProperty>());
    metadata.setAccrualPeriodicity(new ArrayList<DublinCoreStringProperty>());
    metadata.setAccrualPolicy(new ArrayList<DublinCoreStringProperty>());
    metadata.setAlternative(new ArrayList<DublinCoreStringProperty>());
    metadata.setAudience(new ArrayList<DublinCoreStringProperty>());
    metadata.setAvailable(new ArrayList<DublinCoreDateProperty>());
    metadata.setBibliographicCitation(new ArrayList<DublinCoreStringProperty>());
    metadata.setConformsTo(new ArrayList<DublinCoreStringProperty>());
    metadata.setContributor(new ArrayList<DublinCoreStringProperty>());
    metadata.setCoverage(new ArrayList<DublinCoreStringProperty>());
    metadata.setCreated(new ArrayList<DublinCoreDateProperty>());
    metadata.setCreator(new ArrayList<DublinCoreStringProperty>());
    metadata.setDate(new ArrayList<DublinCoreDateProperty>());
    DublinCoreDateProperty dateProperty = new DublinCoreDateProperty();
    dateProperty.setValue(new Date(12345L));
    dateProperty.setId("dateid");
    dateProperty.setLang("fr");
    dateProperty.setOtherAttributes(new HashMap<QName, String>());
    dateProperty.getOtherAttributes().put(new QName("urn:date", "date"), "customdate");
    dateProperty.setValueRef(URI.create("urn:dateref"));
    metadata.getDate().add(dateProperty);
    metadata.setDateAccepted(new ArrayList<DublinCoreDateProperty>());
    metadata.setDateCopyrighted(new ArrayList<DublinCoreDateProperty>());
    metadata.setDateSubmitted(new ArrayList<DublinCoreDateProperty>());
    metadata.setDescription(new ArrayList<DublinCoreStringProperty>());
    metadata.setEducationLevel(new ArrayList<DublinCoreStringProperty>());
    metadata.setExtent(new ArrayList<DublinCoreStringProperty>());
    metadata.setFormat(new ArrayList<DublinCoreStringProperty>());
    metadata.setFormatOf(new ArrayList<DublinCoreStringProperty>());
    metadata.setHasFormat(new ArrayList<DublinCoreStringProperty>());
    metadata.setHasPart(new ArrayList<DublinCoreStringProperty>());
    metadata.setHasVersion(new ArrayList<DublinCoreStringProperty>());
    metadata.setIdentifier(new ArrayList<DublinCoreStringProperty>());
    metadata.setInstructionalMethod(new ArrayList<DublinCoreStringProperty>());
    metadata.setIssued(new ArrayList<DublinCoreDateProperty>());
    metadata.setLanguage(new ArrayList<DublinCoreStringProperty>());
    metadata.setLicense(new ArrayList<DublinCoreStringProperty>());
    metadata.setMediator(new ArrayList<DublinCoreStringProperty>());
    metadata.setMedium(new ArrayList<DublinCoreStringProperty>());
    metadata.setModified(new ArrayList<DublinCoreDateProperty>());
    metadata.setPartOf(new ArrayList<DublinCoreStringProperty>());
    metadata.setProvenance(new ArrayList<DublinCoreStringProperty>());
    metadata.setPublisher(new ArrayList<DublinCoreStringProperty>());
    metadata.setReferencedBy(new ArrayList<DublinCoreStringProperty>());
    metadata.setReferences(new ArrayList<DublinCoreStringProperty>());
    metadata.setRelation(new ArrayList<DublinCoreStringProperty>());
    metadata.setReplacedBy(new ArrayList<DublinCoreStringProperty>());
    metadata.setReplaces(new ArrayList<DublinCoreStringProperty>());
    metadata.setRequiredBy(new ArrayList<DublinCoreStringProperty>());
    metadata.setRequires(new ArrayList<DublinCoreStringProperty>());
    metadata.setRights(new ArrayList<DublinCoreStringProperty>());
    metadata.setRightsHolder(new ArrayList<DublinCoreStringProperty>());
    metadata.setSource(new ArrayList<DublinCoreStringProperty>());
    metadata.setSpatial(new ArrayList<DublinCoreStringProperty>());
    metadata.setTableOfContents(new ArrayList<DublinCoreStringProperty>());
    metadata.setTemporal(new ArrayList<DublinCoreStringProperty>());
    metadata.setTitle(new ArrayList<DublinCoreStringProperty>());
    DublinCoreStringProperty titleProperty = new DublinCoreStringProperty();
    titleProperty.setId("id");
    titleProperty.setValue("title");
    titleProperty.setLang("en");
    titleProperty.setOtherAttributes(new HashMap<QName, String>());
    titleProperty.getOtherAttributes().put(new QName("urn:hi", "hi"), "hello");
    titleProperty.setValueRef(URI.create("urn:ref"));
    metadata.getTitle().add(titleProperty);
    metadata.setType(new ArrayList<DublinCoreTypeProperty>());
    DublinCoreTypeProperty typeProperty = new DublinCoreTypeProperty();
    typeProperty.setKnownValue(DublinCoreType.Collection);
    typeProperty.setId("typeid");
    typeProperty.setLang("fr");
    typeProperty.setOtherAttributes(new HashMap<QName, String>());
    typeProperty.getOtherAttributes().put(new QName("urn:type", "type"), "customtype");
    typeProperty.setValueRef(URI.create("urn:typeref"));
    metadata.getType().add(typeProperty);
    metadata.setValid(new ArrayList<DublinCoreDateProperty>());
    metadata.setVersionOf(new ArrayList<DublinCoreStringProperty>());
    return metadata;
  }

  private void assertMetadata(DublinCoreMetadata metadata) {
    assertTrue(metadata.getAbstract() == null || metadata.getAbstract().isEmpty());
    assertTrue(metadata.getAccessRights() == null || metadata.getAccessRights().isEmpty());
    assertTrue(metadata.getAccrualMethod() == null || metadata.getAccrualMethod().isEmpty());
    assertTrue(metadata.getAccrualPeriodicity() == null || metadata.getAccrualPeriodicity().isEmpty());
    assertTrue(metadata.getAccrualPolicy() == null || metadata.getAccrualPolicy().isEmpty());
    assertTrue(metadata.getAlternative() == null || metadata.getAlternative().isEmpty());
    assertTrue(metadata.getAudience() == null || metadata.getAudience().isEmpty());
    assertTrue(metadata.getAvailable() == null || metadata.getAvailable().isEmpty());
    assertTrue(metadata.getBibliographicCitation() == null || metadata.getBibliographicCitation().isEmpty());
    assertTrue(metadata.getConformsTo() == null || metadata.getConformsTo().isEmpty());
    assertTrue(metadata.getContributor() == null || metadata.getContributor().isEmpty());
    assertTrue(metadata.getCoverage() == null || metadata.getCoverage().isEmpty());
    assertTrue(metadata.getCreated() == null || metadata.getCreated().isEmpty());
    assertTrue(metadata.getCreator() == null || metadata.getCreator().isEmpty());
    DublinCoreDateProperty dateProperty = metadata.getDate().get(0);
    assertEquals(new Date(12345L), dateProperty.getValue());
    assertEquals("dateid", dateProperty.getId());
    assertEquals("fr", dateProperty.getLang());
    assertEquals("customdate", dateProperty.getOtherAttributes().get(new QName("urn:date", "date")));
    assertEquals(URI.create("urn:dateref"), dateProperty.getValueRef());
    assertTrue(metadata.getDateAccepted() == null || metadata.getDateAccepted().isEmpty());
    assertTrue(metadata.getDateCopyrighted() == null || metadata.getDateCopyrighted().isEmpty());
    assertTrue(metadata.getDateSubmitted() == null || metadata.getDateSubmitted().isEmpty());
    assertTrue(metadata.getDescription() == null || metadata.getDescription().isEmpty());
    assertTrue(metadata.getEducationLevel() == null || metadata.getEducationLevel().isEmpty());
    assertTrue(metadata.getExtent() == null || metadata.getExtent().isEmpty());
    assertTrue(metadata.getFormat() == null || metadata.getFormat().isEmpty());
    assertTrue(metadata.getFormatOf() == null || metadata.getFormatOf().isEmpty());
    assertTrue(metadata.getHasFormat() == null || metadata.getHasFormat().isEmpty());
    assertTrue(metadata.getHasPart() == null || metadata.getHasPart().isEmpty());
    assertTrue(metadata.getHasVersion() == null || metadata.getHasVersion().isEmpty());
    assertTrue(metadata.getIdentifier() == null || metadata.getIdentifier().isEmpty());
    assertTrue(metadata.getInstructionalMethod() == null || metadata.getInstructionalMethod().isEmpty());
    assertTrue(metadata.getIssued() == null || metadata.getIssued().isEmpty());
    assertTrue(metadata.getLanguage() == null || metadata.getLanguage().isEmpty());
    assertTrue(metadata.getLicense() == null || metadata.getLicense().isEmpty());
    assertTrue(metadata.getMediator() == null || metadata.getMediator().isEmpty());
    assertTrue(metadata.getMedium() == null || metadata.getMedium().isEmpty());
    assertTrue(metadata.getModified() == null || metadata.getModified().isEmpty());
    assertTrue(metadata.getPartOf() == null || metadata.getPartOf().isEmpty());
    assertTrue(metadata.getProvenance() == null || metadata.getProvenance().isEmpty());
    assertTrue(metadata.getPublisher() == null || metadata.getPublisher().isEmpty());
    assertTrue(metadata.getReferencedBy() == null || metadata.getReferencedBy().isEmpty());
    assertTrue(metadata.getReferences() == null || metadata.getReferences().isEmpty());
    assertTrue(metadata.getRelation() == null || metadata.getRelation().isEmpty());
    assertTrue(metadata.getReplacedBy() == null || metadata.getReplacedBy().isEmpty());
    assertTrue(metadata.getReplaces() == null || metadata.getReplaces().isEmpty());
    assertTrue(metadata.getRequiredBy() == null || metadata.getRequiredBy().isEmpty());
    assertTrue(metadata.getRequires() == null || metadata.getRequires().isEmpty());
    assertTrue(metadata.getRights() == null || metadata.getRights().isEmpty());
    assertTrue(metadata.getRightsHolder() == null || metadata.getRightsHolder().isEmpty());
    assertTrue(metadata.getSource() == null || metadata.getSource().isEmpty());
    assertTrue(metadata.getSpatial() == null || metadata.getSpatial().isEmpty());
    assertTrue(metadata.getTableOfContents() == null || metadata.getTableOfContents().isEmpty());
    assertTrue(metadata.getTemporal() == null || metadata.getTemporal().isEmpty());
    DublinCoreStringProperty titleProperty = metadata.getTitle().get(0);
    assertEquals("id", titleProperty.getId());
    assertEquals("title", titleProperty.getValue());
    assertEquals("en", titleProperty.getLang());
    assertEquals("hello", titleProperty.getOtherAttributes().get(new QName("urn:hi", "hi")));
    assertEquals(URI.create("urn:ref"), titleProperty.getValueRef());
    DublinCoreTypeProperty typeProperty = metadata.getType().get(0);
    assertEquals(DublinCoreType.Collection, typeProperty.getKnownValue());
    assertEquals("typeid", typeProperty.getId());
    assertEquals("fr", typeProperty.getLang());
    assertEquals("customtype", typeProperty.getOtherAttributes().get(new QName("urn:type", "type")));
    assertEquals(URI.create("urn:typeref"), typeProperty.getValueRef());
    assertTrue(metadata.getValid() == null || metadata.getValid().isEmpty());
    assertTrue(metadata.getVersionOf() == null || metadata.getVersionOf().isEmpty());
  }

}

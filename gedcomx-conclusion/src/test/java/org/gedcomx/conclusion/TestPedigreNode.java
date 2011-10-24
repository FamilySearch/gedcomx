package org.gedcomx.conclusion;

import org.gedcomx.common.AlternateId;
import org.gedcomx.common.Attribution;
import org.gedcomx.common.ResourceReference;
import org.testng.annotations.Test;

import java.net.URI;
import java.util.Arrays;

import static org.gedcomx.rt.SerializationUtil.processThroughJson;
import static org.gedcomx.rt.SerializationUtil.processThroughXml;
import static org.testng.AssertJUnit.assertEquals;

/**
 * @author Ryan Heaton
 */
@Test
public class TestPedigreNode {

  /**
   * tests processing a pedigree node through xml...
   */
  public void testPedigreeNodeXml() throws Exception {
    PedigreeNode pedigreeNode = createTestPedigreeNode();
    pedigreeNode = processThroughXml(pedigreeNode);
    assertTestPedigreeNode(pedigreeNode);
  }

  /**
   * tests processing a pedigree node through json...
   */
  public void testPedigreeNodeJson() throws Exception {
    PedigreeNode pedigreeNode = createTestPedigreeNode();
    pedigreeNode = processThroughJson(pedigreeNode);
    assertTestPedigreeNode(pedigreeNode);
  }

  private PedigreeNode createTestPedigreeNode() {
    PedigreeNode pedigreeNode = new PedigreeNode();
    AlternateId alternateId = new AlternateId();
    alternateId.setValue("alt-id");
    pedigreeNode.setAlternateIds(Arrays.asList(alternateId));
    pedigreeNode.setAttribution(new Attribution());
    pedigreeNode.getAttribution().setProofStatement("explanation");
    pedigreeNode.setId("pn");
    pedigreeNode.setPersistentId(URI.create("urn:pid"));
    pedigreeNode.setCoupleRelationship(new ResourceReference());
    pedigreeNode.getCoupleRelationship().setResource(URI.create("urn:couple"));
    pedigreeNode.setChildRelationships(Arrays.asList(new ResourceReference()));
    pedigreeNode.getChildRelationships().get(0).setResource(URI.create("urn:child1"));
    ResourceReference sourceReference = new ResourceReference();
    sourceReference.setId("source-ref");
    pedigreeNode.setSources(Arrays.asList(sourceReference));
    pedigreeNode.setBibliographicCitation("pedigree node bibliographic citation");
    return pedigreeNode;
  }

  private void assertTestPedigreeNode(PedigreeNode pedigreeNode) {
    assertEquals("alt-id", pedigreeNode.getAlternateIds().get(0).getValue());
    assertEquals("explanation", pedigreeNode.getAttribution().getProofStatement());
    assertEquals("pn", pedigreeNode.getId());
    assertEquals(URI.create("urn:pid"), pedigreeNode.getPersistentId());
    assertEquals(URI.create("urn:couple"), pedigreeNode.getCoupleRelationship().getResource());
    assertEquals(URI.create("urn:child1"), pedigreeNode.getChildRelationships().get(0).getResource());
    assertEquals("source-ref", pedigreeNode.getSources().get(0).getId());
    assertEquals("pedigree node bibliographic citation", pedigreeNode.getBibliographicCitation());
  }

}

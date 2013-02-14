package org.gedcomx.common;

import org.gedcomx.Gedcomx;
import org.gedcomx.agent.Agent;
import org.gedcomx.conclusion.Document;
import org.gedcomx.conclusion.Event;
import org.gedcomx.conclusion.Person;
import org.gedcomx.conclusion.Relationship;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static org.gedcomx.rt.SerializationUtil.processThroughJson;
import static org.gedcomx.rt.SerializationUtil.processThroughXml;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertNotNull;

/**
 * @author Ryan Heaton
 */
@Test
public class GedcomxTest {

  /**
   * tests id xml
   */
  public void testResourceSetXml() throws Exception {
    Gedcomx meta = createData();
    meta = processThroughXml(meta);
    assertData(meta);
  }

  /**
   * tests id json
   */
  public void testResourceSetJson() throws Exception {
    Gedcomx meta = createData();
    meta = processThroughJson(meta);
    assertData(meta);
  }

  private void assertData(Gedcomx meta) {
    assertEquals("id", meta.getId());
    assertNotNull(meta.getAttribution());
    assertEquals("en", meta.getLang());
    assertEquals(1, meta.getAgents().size());
    assertEquals(1, meta.getDocuments().size());
    assertEquals(1, meta.getEvents().size());
    assertEquals(1, meta.getPersons().size());
    assertEquals(1, meta.getRelationships().size());
    assertEquals(1, meta.getExtensionElements().size());
  }

  private Gedcomx createData() {
    Gedcomx meta = new Gedcomx();
    meta.setId("id");
    meta.setAttribution(new Attribution());
    meta.setLang("en");
    meta.setAgents(new ArrayList<Agent>());
    meta.getAgents().add(new Agent());
    meta.setDocuments(new ArrayList<Document>());
    meta.getDocuments().add(new Document());
    meta.setEvents(new ArrayList<Event>());
    meta.getEvents().add(new Event());
    meta.setPersons(new ArrayList<Person>());
    meta.getPersons().add(new Person());
    meta.setRelationships(new ArrayList<Relationship>());
    meta.getRelationships().add(new Relationship());
    meta.setExtensionElements(new ArrayList<Object>());
    meta.getExtensionElements().add(new Gedcomx());
    return meta;
  }

}

package org.gedcomx.conclusion;

import org.gedcomx.common.Attribution;
import org.gedcomx.common.ResourceReference;
import org.gedcomx.common.SourceReference;
import org.gedcomx.common.URI;
import org.gedcomx.types.EventRoleType;
import org.gedcomx.types.EventType;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static org.gedcomx.rt.SerializationUtil.processThroughJson;
import static org.gedcomx.rt.SerializationUtil.processThroughXml;
import static org.testng.AssertJUnit.assertEquals;

/**
 * @author Ryan Heaton
 */
@Test
public class EventTest {

  /**
   * tests processing a event through xml...
   */
  public void testEventXml() throws Exception {
    Event event = createTestEvent();
    event = processThroughXml(event);
    assertTestEvent(event);
  }

  /**
   * tests processing a event through json...
   */
  public void testPersonJson() throws Exception {
    Event event = createTestEvent();
    event = processThroughJson(event);
    assertTestEvent(event);
  }

  private Event createTestEvent() {
    Event event = new Event();
    event.setKnownType(EventType.Marriage);
    event.setAttribution(new Attribution());
    event.getAttribution().setChangeMessage("explanation");
    event.setDate(new Date());
    event.getDate().setOriginal("date");
    event.setPlace(new Place());
    event.getPlace().setOriginal("place");
    event.setRoles(new ArrayList<EventRole>());
    EventRole role = new EventRole();
    role.setKnownType(EventRoleType.Official);
    role.setPerson(new ResourceReference());
    role.getPerson().setResource(URI.create("urn:person"));
    event.getRoles().add(role);
    SourceReference sourceReference = new SourceReference();
    sourceReference.setId("source-ref");
    event.addSource(sourceReference);
    return event;
  }

  private void assertTestEvent(Event event) {
    assertEquals(EventType.Marriage, event.getKnownType());
    assertEquals("explanation", event.getAttribution().getChangeMessage());
    assertEquals("date", event.getDate().getOriginal());
    assertEquals("place", event.getPlace().getOriginal());
    assertEquals(1, event.getRoles().size());
    assertEquals(EventRoleType.Official, event.getRoles().get(0).getKnownType());
    assertEquals("urn:person", event.getRoles().get(0).getPerson().getResource().toString());
    assertEquals("source-ref", event.getSources().get(0).getId());
  }

}

package org.gedcomx.record;

import org.gedcomx.common.Attribution;
import org.gedcomx.common.AlternateId;
import org.gedcomx.common.FormalizedValue;
import org.gedcomx.common.ResourceReference;
import org.gedcomx.types.*;
import org.testng.annotations.Test;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import static org.gedcomx.rt.SerializationUtil.processThroughJson;
import static org.gedcomx.rt.SerializationUtil.processThroughXml;
import static org.testng.AssertJUnit.*;

/**
 * @author Ryan Heaton
 */
@Test
public class TestRecord {

  /**
   * tests processing a WWW record through xml...
   */
  public void testRecordXml() throws Exception {
    Record record = createTestRecord();
    record = processThroughXml(record);
    assertTestRecord(record);
  }

  /**
   * tests processing a WWW record through json...
   */
  public void testRecordJson() throws Exception {
    Record record = createTestRecord();
    record = processThroughJson(record);
    assertTestRecord(record);
  }

  private Record createTestRecord() {
    Record record = new Record();

    ArrayList<AlternateId> alternateIds = new ArrayList<AlternateId>();
    AlternateId alternateId = new AlternateId();
    alternateId.setKnownType(AlternateIdType.Forwarded);
    alternateId.setValue("forward-value");
    alternateIds.add(alternateId);
    record.setAlternateIds(alternateIds);

    List<Event> events = new ArrayList<Event>();
    Event event = new Event();
    event.setDate(new Date());
    fillInField(event.getDate(), "event-date");
    event.getDate().setParts(new ArrayList<DatePart>());
    DatePart datePart = new DatePart();
    fillInField(datePart, "event-date-part");
    datePart.setKnownType(DatePartType.Months);
    event.getDate().getParts().add(datePart);
    event.setId("event-id");
    event.setKnownType(EventType.Adoption);
    event.setPlace(new Place());
    fillInField(event.getPlace(), "event-place");
    event.getPlace().setParts(new ArrayList<PlacePart>());
    PlacePart placePart = new PlacePart();
    fillInField(placePart, "event-place-part");
    placePart.setKnownType(PlacePartType.Cemetery);
    event.getPlace().getParts().add(placePart);
    event.setPrimary(true);
    events.add(event);
    record.setEvents(events);

    Persona persona = new Persona();
    List<Characteristic> characteristics = new ArrayList<Characteristic>();
    Characteristic characteristic = new Characteristic();
    fillInField(characteristic, "characteristic");
    characteristic.setKnownType(CharacteristicType.Occupation);
    characteristics.add(characteristic);
    persona.setCharacteristics(characteristics);

    List<Name> names = new ArrayList<Name>();
    Name name = new Name();
    fillInField(name, "name");
    name.setKnownType(NameType.Formal);

    ArrayList<NamePart> nameParts = new ArrayList<NamePart>();
    NamePart namePart = new NamePart();
    namePart.setKnownType(NamePartType.Surname);
    fillInField(namePart, "name-part");
    nameParts.add(namePart);
    name.setParts(nameParts);
    names.add(name);
    persona.setNames(names);

    Age age = new Age();
    fillInField(age, "age");
    ArrayList<AgePart> ageParts = new ArrayList<AgePart>();
    AgePart agePart = new AgePart();
    fillInField(agePart, "age-part");
    agePart.setKnownType(AgePartType.Days);
    ageParts.add(agePart);
    age.setParts(ageParts);
    persona.setAge(age);

    persona.setAlternateIds(alternateIds);
    persona.setAttribution(new Attribution());
    persona.getAttribution().setProofStatement("this persona exists.");

    Gender gender = new Gender();
    fillInField(gender, "gender");
    gender.setKnownType(GenderType.Female);
    persona.setGender(gender);

    persona.setId("persona-id");
    persona.setPersistentId(URI.create("urn:persona-id-value"));
    persona.setPrincipal(true);
    ArrayList<EventRole> eventRoles = new ArrayList<EventRole>();
    EventRole eventRole = new EventRole();
    eventRole.setDescription("event role description");
    eventRole.setPrincipal(false);
    eventRole.setEvent(URI.create("#" + event.getId()));
    eventRole.setAttribution(new Attribution());
    eventRole.getAttribution().setProofStatement("event role attribution");
    eventRoles.add(eventRole);
    persona.setEventRoles(eventRoles);

    record.setPersonas(Arrays.asList(persona));

    List<RecordField> fields = new ArrayList<RecordField>();
    RecordField field = new RecordField();
    field.setAttribution(new Attribution());
    field.getAttribution().setContributor(new ResourceReference());
    field.getAttribution().getContributor().setResource(URI.create("urn:field-attribution"));
    field.setId("field-id");
    field.setKnownType(FieldType.BatchNumber);
    field.setOriginal("field-value-original");
    field.setInterpreted("field-value-interpreted");
    field.setProcessed(new FormalizedValue());
    field.getProcessed().setText("field-value-normalized");
    fields.add(field);
    record.setFields(fields);

    record.setPersistentId(URI.create("pal"));

    ArrayList<Relationship> relationships = new ArrayList<Relationship>();
    Relationship coupleRelationship = new Relationship();
    coupleRelationship.setKnownType(RelationshipType.Couple);
    ArrayList<Characteristic> coupleCharacteristics = new ArrayList<Characteristic>();
    Characteristic coupleCharacteristic = new Characteristic();
    fillInField(coupleCharacteristic, "couple-characteristic");
    coupleCharacteristic.setKnownType(CharacteristicType.Couple.CommonLawMarriage);
    coupleCharacteristics.add(coupleCharacteristic);
    coupleRelationship.setCharacteristics(coupleCharacteristics);
    coupleRelationship.setId("couple-relationship-id");
    coupleRelationship.setPersona1(new ResourceReference());
    coupleRelationship.getPersona1().setResource(URI.create("#" + persona.getId()));
    coupleRelationship.setPersona2(new ResourceReference());
    coupleRelationship.getPersona2().setResource(URI.create("#" + persona.getId()));
    relationships.add(coupleRelationship);
    Relationship parentRelationship = new Relationship();
    parentRelationship.setKnownType(RelationshipType.ParentChild);
    parentRelationship.setId("parent-relationship-id");
    parentRelationship.setPersona1(new ResourceReference());
    parentRelationship.getPersona1().setResource(URI.create("#" + persona.getId()));
    parentRelationship.setPersona2(new ResourceReference());
    parentRelationship.getPersona2().setResource(URI.create("#" + persona.getId()));
    parentRelationship.setAttribution(new Attribution());
    parentRelationship.getAttribution().setProofStatement("relationship explanation");
    relationships.add(parentRelationship);

    record.setRelationships(relationships);

    ArrayList<ResourceReference> sources = new ArrayList<ResourceReference>();
    ResourceReference sourceReference = new ResourceReference();
    sourceReference.setResource(URI.create("urn:source-uri"));
    sourceReference.setId("source-reference-id");
    sourceReference.setKnownType(ResourceType.Collection);
    sources.add(sourceReference);
    record.setSources(sources);

    record.setBibliographicCitation("bibliographic citation");

    record.setId("rid");
    record.setLang(Locale.ENGLISH.getLanguage());
    return record;
  }

  private void fillInField(Field field, String label) {
    field.setAttribution(new Attribution());
    field.getAttribution().setContributor(new ResourceReference());
    field.getAttribution().getContributor().setResource(URI.create("urn:" + label + "-attribution"));
    field.setLabel(label + "-field-id");
    field.setId(label + "-id");
    field.setOriginal(label + "-original");
    field.setInterpreted(label + "-interpreted");
    field.setProcessed(new FormalizedValue());
    field.getProcessed().setText(label + "-normalized");
  }

  private void assertField(Field field, String label) {
    assertEquals("urn:" + label + "-attribution", field.getAttribution().getContributor().getResource().toString());
    assertEquals(label + "-field-id", field.getLabel());
    assertEquals(label + "-id", field.getId());
    assertEquals(label + "-original", field.getOriginal());
    assertEquals(label + "-interpreted", field.getInterpreted());
    assertEquals(label + "-normalized", field.getProcessed().getText());
  }

  private void assertTestRecord(Record record) {
    assertEquals(1, record.getAlternateIds().size());
    assertEquals(AlternateIdType.Forwarded, record.getAlternateIds().get(0).getKnownType());
    assertEquals("forward-value", record.getAlternateIds().get(0).getValue());

    assertEquals(1, record.getEvents().size());
    Event event = record.getEvents().get(0);
    assertField(event.getDate(), "event-date");
    assertEquals("event-id", event.getId());
    assertEquals(EventType.Adoption, event.getKnownType());
    assertField(event.getPlace(), "event-place");
    assertTrue(event.getPrimary());
    assertEquals(1, event.getDate().getParts().size());
    assertField(event.getDate().getParts().get(0), "event-date-part");
    assertEquals(DatePartType.Months, event.getDate().getParts().get(0).getKnownType());
    assertEquals(1, event.getPlace().getParts().size());
    assertField(event.getPlace().getParts().get(0), "event-place-part");
    assertEquals(PlacePartType.Cemetery, event.getPlace().getParts().get(0).getKnownType());

    assertEquals(1, record.getPersonas().size());
    Persona persona = record.getPersonas().get(0);
    assertEquals(1, persona.getCharacteristics().size());
    assertField(persona.getCharacteristics().get(0), "characteristic");
    assertEquals(CharacteristicType.Occupation, persona.getCharacteristics().get(0).getKnownType());

    assertEquals(1, persona.getNames().size());
    Name name = persona.getNames().get(0);
    assertField(name, "name");
    assertEquals(NameType.Formal, name.getKnownType());

    assertEquals(1, name.getParts().size());
    NamePart namePart = name.getParts().get(0);
    namePart.setKnownType(NamePartType.Surname);
    assertField(namePart, "name-part");

    assertField(persona.getAge(), "age");
    assertEquals(1, persona.getAge().getParts().size());
    AgePart agePart = persona.getAge().getParts().get(0);
    assertField(agePart, "age-part");
    assertEquals(AgePartType.Days, agePart.getKnownType());

    assertEquals(1, persona.getAlternateIds().size());
    assertEquals(AlternateIdType.Forwarded, persona.getAlternateIds().get(0).getKnownType());
    assertEquals("forward-value", persona.getAlternateIds().get(0).getValue());

    assertEquals("this persona exists.", persona.getAttribution().getProofStatement());

    assertField(persona.getGender(), "gender");
    assertEquals(GenderType.Female, persona.getGender().getKnownType());

    assertEquals("persona-id", persona.getId());
    assertEquals("urn:persona-id-value", persona.getPersistentId().toString());
    assertTrue(persona.getPrincipal());
    assertEquals(1, persona.getEventRoles().size());
    EventRole eventRole = persona.getEventRoles().get(0);
    assertEquals("event role description", eventRole.getDescription());
    assertEquals("event role attribution", eventRole.getAttribution().getProofStatement());
    assertFalse(eventRole.getPrincipal());
    assertEquals("#" + event.getId(), eventRole.getEvent().toString());

    assertEquals(1, record.getFields().size());
    RecordField field = record.getFields().get(0);
    assertEquals("urn:field-attribution", field.getAttribution().getContributor().getResource().toString());
    assertEquals("field-id", field.getId());
    assertEquals(FieldType.BatchNumber, field.getKnownType());
    assertEquals("field-value-original", field.getOriginal());
    assertEquals("field-value-interpreted", field.getInterpreted());
    assertEquals("field-value-normalized", field.getProcessed().getText());

    assertEquals("pal", record.getPersistentId().toString());
    assertEquals("bibliographic citation", record.getBibliographicCitation());

    assertEquals(2, record.getRelationships().size());
    Relationship coupleRelationship = record.getRelationships().get(0);
    assertEquals(RelationshipType.Couple, coupleRelationship.getKnownType());
    assertEquals(1, coupleRelationship.getCharacteristics().size());
    Characteristic coupleCharacteristic = coupleRelationship.getCharacteristics().get(0);
    assertField(coupleCharacteristic, "couple-characteristic");
    assertEquals(CharacteristicType.Couple.CommonLawMarriage, coupleCharacteristic.getKnownType());
    assertEquals("couple-relationship-id", coupleRelationship.getId());
    assertEquals("#" + persona.getId(), coupleRelationship.getPersona1().getResource().toString());
    assertEquals("#" + persona.getId(), coupleRelationship.getPersona2().getResource().toString());

    Relationship parentRelationship = record.getRelationships().get(1);
    assertEquals(RelationshipType.ParentChild, parentRelationship.getKnownType());
    assertEquals("parent-relationship-id", parentRelationship.getId());
    assertEquals("#" + persona.getId(), parentRelationship.getPersona1().getResource().toString());
    assertEquals("#" + persona.getId(), parentRelationship.getPersona2().getResource().toString());
    assertEquals("relationship explanation", parentRelationship.getAttribution().getProofStatement());

    assertEquals(1, record.getSources().size());
    ResourceReference sourceReference = record.getSources().get(0);
    assertEquals("urn:source-uri", sourceReference.getResource().toString());
    assertEquals("source-reference-id", sourceReference.getId());
    assertEquals(ResourceType.Collection, sourceReference.getKnownType());

    assertEquals("rid", record.getId());
    assertEquals(Locale.ENGLISH.getLanguage(), record.getLang());
  }

}

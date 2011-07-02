package org.gedcomx.record;

import org.gedcomx.attribution.Attribution;
import org.gedcomx.attribution.ContributorReference;
import org.gedcomx.common.AlternateId;
import org.gedcomx.source.SourceQualifier;
import org.gedcomx.source.SourceQualifierProperty;
import org.gedcomx.source.SourceReference;
import org.gedcomx.types.*;
import org.testng.annotations.Test;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
    alternateId.setKnownType(AlternateIdType.forwarded);
    alternateId.setValue("forward-value");
    alternateIds.add(alternateId);
    record.setAlternateIds(alternateIds);

    List<Event> events = new ArrayList<Event>();
    Event event = new Event();
    event.setDate(new Date());
    fillInField(event.getDate(), "event-date");
    event.setId("event-id");
    event.setKnownType(EventType.adoption);
    event.setPlace(new Place());
    fillInField(event.getPlace(), "event-place");
    event.setPrimary(true);
    events.add(event);
    record.setEvents(events);

    Persona persona = new Persona();
    List<Characteristic> characteristics = new ArrayList<Characteristic>();
    Characteristic characteristic = new Characteristic();
    fillInField(characteristic, "characteristic");
    characteristic.setDate(new Date());
    fillInField(characteristic.getDate(), "characteristic-date");
    characteristic.setKnownType(CharacteristicType.occupation);
    characteristic.setPlace(new Place());
    fillInField(characteristic.getPlace(), "characteristic-place");
    characteristics.add(characteristic);
    persona.setCharacteristics(characteristics);

    List<Name> names = new ArrayList<Name>();
    Name name = new Name();
    fillInField(name, "name");
    name.setKnownStyle(NameStyle.spanish);
    name.setKnownType(NameType.formal);

    ArrayList<NamePart> nameParts = new ArrayList<NamePart>();
    NamePart namePart = new NamePart();
    namePart.setKnownType(NamePartType.surname);
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
    ageParts.add(agePart);
    age.setParts(ageParts);
    persona.setAge(age);

    persona.setAlternateIds(alternateIds);

    Gender gender = new Gender();
    fillInField(gender, "gender");
    gender.setType(GenderType.female);
    persona.setGender(gender);

    persona.setId("persona-id");
    persona.setPersistentId(URI.create("urn:persona-id-value"));
    persona.setPrincipal(true);
    ArrayList<EventRole> eventRoles = new ArrayList<EventRole>();
    EventRole eventRole = new EventRole();
    eventRole.setDescription("event role description");
    eventRole.setPrincipal(false);
    eventRole.setEvent(new EventReference());
    eventRole.getEvent().setHref(URI.create("#" + event.getId()));
    eventRoles.add(eventRole);
    persona.setEventRoles(eventRoles);

    record.setPersonas(Arrays.asList(persona));

    List<RecordField> fields = new ArrayList<RecordField>();
    RecordField field = new RecordField();
    field.setAttribution(new Attribution());
    field.getAttribution().setContributor(new ContributorReference());
    field.getAttribution().getContributor().setHref(URI.create("urn:field-attribution"));
    field.setId("field-id");
    field.setKnownType(FieldType.batch_number);
    field.setOriginal("field-value-original");
    field.setInterpreted("field-value-interpreted");
    field.setNormalized("field-value-normalized");
    fields.add(field);
    record.setFields(fields);

    record.setPersistentId(URI.create("pal"));

    ArrayList<Relationship> relationships = new ArrayList<Relationship>();
    Relationship coupleRelationship = new Relationship();
    coupleRelationship.setKnownType(RelationshipType.couple);
    ArrayList<Characteristic> coupleCharacteristics = new ArrayList<Characteristic>();
    Characteristic coupleCharacteristic = new Characteristic();
    fillInField(coupleCharacteristic, "couple-characteristic");
    coupleCharacteristic.setKnownType(CharacteristicType.Couple.common_law_marriage);
    coupleCharacteristic.setDate(new Date());
    fillInField(coupleCharacteristic.getDate(), "couple-characteristic-date");
    coupleCharacteristic.setPlace(new Place());
    fillInField(coupleCharacteristic.getPlace(), "couple-characteristic-place");
    coupleCharacteristics.add(coupleCharacteristic);
    coupleRelationship.setCharacteristics(coupleCharacteristics);
    coupleRelationship.setId("couple-relationship-id");
    coupleRelationship.setPersona1(new PersonaReference());
    coupleRelationship.getPersona1().setHref(URI.create("#" + persona.getId()));
    coupleRelationship.setPersona2(new PersonaReference());
    coupleRelationship.getPersona2().setHref(URI.create("#" + persona.getId()));
    relationships.add(coupleRelationship);
    Relationship parentRelationship = new Relationship();
    parentRelationship.setKnownType(RelationshipType.parent_child);
    parentRelationship.setId("parent-relationship-id");
    parentRelationship.setPersona1(new PersonaReference());
    parentRelationship.getPersona1().setHref(URI.create("#" + persona.getId()));
    parentRelationship.setPersona2(new PersonaReference());
    parentRelationship.getPersona2().setHref(URI.create("#" + persona.getId()));
    relationships.add(parentRelationship);

    record.setRelationships(relationships);

    ArrayList<SourceReference> sources = new ArrayList<SourceReference>();
    SourceReference sourceReference = new SourceReference();
    sourceReference.setHref(URI.create("urn:source-uri"));
    sourceReference.setId("source-reference-id");
    sourceReference.setKnownType(SourceReferenceType.source);
    ArrayList<SourceQualifier> qualifiers = new ArrayList<SourceQualifier>();
    SourceQualifier qualifier = new SourceQualifier();
    qualifier.setProperty(SourceQualifierProperty.x_pixels, "2");
    qualifiers.add(qualifier);
    sourceReference.setQualifiers(qualifiers);
    sources.add(sourceReference);
    record.setSources(sources);

    record.setId("rid");
    return record;
  }

  private void fillInField(Field field, String label) {
    field.setAttribution(new Attribution());
    field.getAttribution().setContributor(new ContributorReference());
    field.getAttribution().getContributor().setHref(URI.create("urn:" + label + "-attribution"));
    field.setFieldId(label + "-field-id");
    field.setId(label + "-id");
    field.setOriginal(label + "-original");
    field.setInterpreted(label + "-interpreted");
    field.setNormalized(label + "-normalized");
  }

  private void assertField(Field field, String label) {
    assertEquals("urn:" + label + "-attribution", field.getAttribution().getContributor().getHref().toString());
    assertEquals(label + "-field-id", field.getFieldId());
    assertEquals(label + "-id", field.getId());
    assertEquals(label + "-original", field.getOriginal());
    assertEquals(label + "-interpreted", field.getInterpreted());
    assertEquals(label + "-normalized", field.getNormalized());
  }

  private void assertTestRecord(Record record) {
    assertEquals(1, record.getAlternateIds().size());
    assertEquals(AlternateIdType.forwarded, record.getAlternateIds().get(0).getKnownType());
    assertEquals("forward-value", record.getAlternateIds().get(0).getValue());

    assertEquals(1, record.getEvents().size());
    Event event = record.getEvents().get(0);
    assertField(event.getDate(), "event-date");
    assertEquals("event-id", event.getId());
    assertEquals(EventType.adoption, event.getKnownType());
    assertField(event.getPlace(), "event-place");
    assertTrue(event.getPrimary());

    assertEquals(1, record.getPersonas().size());
    Persona persona = record.getPersonas().get(0);
    assertEquals(1, persona.getCharacteristics().size());
    assertField(persona.getCharacteristics().get(0), "characteristic");
    assertField(persona.getCharacteristics().get(0).getDate(), "characteristic-date");
    assertEquals(CharacteristicType.occupation, persona.getCharacteristics().get(0).getKnownType());
    assertField(persona.getCharacteristics().get(0).getPlace(), "characteristic-place");

    assertEquals(1, persona.getNames().size());
    Name name = persona.getNames().get(0);
    assertField(name, "name");
    assertEquals(NameStyle.spanish, name.getKnownStyle());
    assertEquals(NameType.formal, name.getKnownType());

    assertEquals(1, name.getParts().size());
    NamePart namePart = name.getParts().get(0);
    namePart.setKnownType(NamePartType.surname);
    assertField(namePart, "name-part");

    assertField(persona.getAge(), "age");
    assertEquals(1, persona.getAge().getParts().size());
    AgePart agePart = persona.getAge().getParts().get(0);
    assertField(agePart, "age-part");

    assertEquals(1, persona.getAlternateIds().size());
    assertEquals(AlternateIdType.forwarded, persona.getAlternateIds().get(0).getKnownType());
    assertEquals("forward-value", persona.getAlternateIds().get(0).getValue());

    assertField(persona.getGender(), "gender");
    assertEquals(GenderType.female, persona.getGender().getType());

    assertEquals("persona-id", persona.getId());
    assertEquals("urn:persona-id-value", persona.getPersistentId().toString());
    assertTrue(persona.getPrincipal());
    assertEquals(1, persona.getEventRoles().size());
    EventRole eventRole = persona.getEventRoles().get(0);
    assertEquals("event role description", eventRole.getDescription());
    assertFalse(eventRole.getPrincipal());
    assertEquals("#" + event.getId(), eventRole.getEvent().getHref().toString());

    assertEquals(1, record.getFields().size());
    RecordField field = record.getFields().get(0);
    assertEquals("urn:field-attribution", field.getAttribution().getContributor().getHref().toString());
    assertEquals("field-id", field.getId());
    assertEquals(FieldType.batch_number, field.getKnownType());
    assertEquals("field-value-original", field.getOriginal());
    assertEquals("field-value-interpreted", field.getInterpreted());
    assertEquals("field-value-normalized", field.getNormalized());

    assertEquals("pal", record.getPersistentId().toString());

    assertEquals(2, record.getRelationships().size());
    Relationship coupleRelationship = record.getRelationships().get(0);
    assertEquals(RelationshipType.couple, coupleRelationship.getKnownType());
    assertEquals(1, coupleRelationship.getCharacteristics().size());
    Characteristic coupleCharacteristic = coupleRelationship.getCharacteristics().get(0);
    assertField(coupleCharacteristic, "couple-characteristic");
    assertEquals(CharacteristicType.Couple.common_law_marriage, coupleCharacteristic.getKnownType());
    assertField(coupleCharacteristic.getDate(), "couple-characteristic-date");
    assertField(coupleCharacteristic.getPlace(), "couple-characteristic-place");
    assertEquals("couple-relationship-id", coupleRelationship.getId());
    assertEquals("#" + persona.getId(), coupleRelationship.getPersona1().getHref().toString());
    assertEquals("#" + persona.getId(), coupleRelationship.getPersona2().getHref().toString());

    Relationship parentRelationship = record.getRelationships().get(1);
    assertEquals(RelationshipType.parent_child, parentRelationship.getKnownType());
    assertEquals("parent-relationship-id", parentRelationship.getId());
    assertEquals("#" + persona.getId(), parentRelationship.getPersona1().getHref().toString());
    assertEquals("#" + persona.getId(), parentRelationship.getPersona2().getHref().toString());

    assertEquals(1, record.getSources().size());
    SourceReference sourceReference = record.getSources().get(0);
    assertEquals("urn:source-uri", sourceReference.getHref().toString());
    assertEquals("source-reference-id", sourceReference.getId());
    assertEquals(SourceReferenceType.source, sourceReference.getKnownType());
    assertEquals(1, sourceReference.getQualifiers().size());
    SourceQualifier qualifier = sourceReference.getQualifiers().get(0);
    assertEquals("2", qualifier.getProperty(SourceQualifierProperty.x_pixels));

    assertEquals("rid", record.getId());
  }

}

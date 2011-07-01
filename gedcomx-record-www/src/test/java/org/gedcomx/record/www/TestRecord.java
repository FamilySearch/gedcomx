package org.gedcomx.record.www;

import org.gedcomx.attribution.Attribution;
import org.gedcomx.attribution.ContributorReference;
import org.gedcomx.id.AlternateId;
import org.gedcomx.id.PersistentId;
import org.gedcomx.record.*;
import org.gedcomx.source.SourceQualifier;
import org.gedcomx.source.SourceQualifierProperty;
import org.gedcomx.source.SourceReference;
import org.gedcomx.types.*;
import org.gedcomx.www.Link;
import org.gedcomx.www.Links;
import org.testng.annotations.Test;

import javax.xml.bind.JAXBContext;
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
    record = processThroughXml(record, Record.class, JAXBContext.newInstance(Record.class, Links.class));
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
    event.setExtension(new Extension());
    Link eventLink = new Link();
    eventLink.setHref(URI.create("urn:event-link"));
    event.getExtension().addElement(eventLink);
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
    Link personaLink = new Link();
    personaLink.setHref(URI.create("urn:persona-link"));
    persona.setExtension(new Extension());
    persona.getExtension().addElement(personaLink);
    List<org.gedcomx.record.Characteristic> characteristics = new ArrayList<org.gedcomx.record.Characteristic>();
    Characteristic characteristic = new Characteristic();
    fillInField(characteristic, "characteristic");
    characteristic.setDate(new Date());
    fillInField(characteristic.getDate(), "characteristic-date");
    characteristic.setKnownType(CharacteristicType.occupation);
    characteristic.setPlace(new Place());
    fillInField(characteristic.getPlace(), "characteristic-place");
    characteristics.add(characteristic);
    persona.setCharacteristics(characteristics);

    List<org.gedcomx.record.Name> names = new ArrayList<org.gedcomx.record.Name>();
    Name name = new Name();
    fillInField(name, "name");
    name.setKnownStyle(NameStyle.spanish);
    name.setKnownType(NameType.formal);

    ArrayList<org.gedcomx.record.NamePart> nameParts = new ArrayList<org.gedcomx.record.NamePart>();
    NamePart namePart = new NamePart();
    namePart.setKnownType(NamePartType.surname);
    fillInField(namePart, "name-part");
    nameParts.add(namePart);
    name.setParts(nameParts);
    names.add(name);
    persona.setNames(names);

    Age age = new Age();
    fillInField(age, "age");
    ArrayList<org.gedcomx.record.AgePart> ageParts = new ArrayList<org.gedcomx.record.AgePart>();
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
    persona.setPersistentId(new PersistentId());
    persona.getPersistentId().setValue(URI.create("urn:persona-id-value"));
    persona.setPrincipal(true);
    ArrayList<EventRole> eventRoles = new ArrayList<EventRole>();
    EventRole eventRole = new EventRole();
    eventRole.setDescription("event role description");
    eventRole.setPrincipal(false);
    eventRole.setEvent(new EventReference());
    eventRole.getEvent().setHref(URI.create("#" + event.getId()));
    eventRoles.add(eventRole);
    persona.setEventRoles(eventRoles);

    record.setPersonas(Arrays.<org.gedcomx.record.Persona>asList(persona));

    List<org.gedcomx.record.RecordField> fields = new ArrayList<org.gedcomx.record.RecordField>();
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

    record.setPersistentId(new PersistentId());
    record.getPersistentId().setValue(URI.create("pal"));

    ArrayList<org.gedcomx.record.Relationship> relationships = new ArrayList<org.gedcomx.record.Relationship>();
    CoupleRelationship coupleRelationship = new CoupleRelationship();
    ArrayList<org.gedcomx.record.Characteristic> coupleCharacteristics = new ArrayList<org.gedcomx.record.Characteristic>();
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
    ParentChildRelationship parentRelationship = new ParentChildRelationship();
    parentRelationship.setId("parent-relationship-id");
    parentRelationship.setParent(new PersonaReference());
    parentRelationship.getParent().setHref(URI.create("#" + persona.getId()));
    parentRelationship.setChild(new PersonaReference());
    parentRelationship.getChild().setHref(URI.create("#" + persona.getId()));
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
    List<Link> links = event.getExtension().findExtensionsOfType(Link.class);
    assertEquals(1, links.size());
    assertEquals("urn:event-link", links.get(0).getHref().toString());

    assertEquals(1, record.getPersonas().size());
    Persona persona = record.getPersonas().get(0);
    links = persona.getExtension().findExtensionsOfType(Link.class);
    assertEquals(1, links.size());
    assertEquals("urn:persona-link", links.get(0).getHref().toString());

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
    assertEquals("urn:persona-id-value", persona.getPersistentId().getValue().toString());
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

    assertEquals("pal", record.getPersistentId().getValue().toString());

    assertEquals(1, record.getCoupleRelationships().size());
    assertEquals(1, record.getParentChildRelationships().size());
    CoupleRelationship coupleRelationship = record.getCoupleRelationships().get(0);
    assertEquals(1, coupleRelationship.getCharacteristics().size());
    Characteristic coupleCharacteristic = coupleRelationship.getCharacteristics().get(0);
    assertField(coupleCharacteristic, "couple-characteristic");
    assertEquals(CharacteristicType.Couple.common_law_marriage, coupleCharacteristic.getKnownType());
    assertField(coupleCharacteristic.getDate(), "couple-characteristic-date");
    assertField(coupleCharacteristic.getPlace(), "couple-characteristic-place");
    assertEquals("couple-relationship-id", coupleRelationship.getId());
    assertEquals("#" + persona.getId(), coupleRelationship.getPersona1().getHref().toString());
    assertEquals("#" + persona.getId(), coupleRelationship.getPersona2().getHref().toString());

    ParentChildRelationship parentRelationship = record.getParentChildRelationships().get(0);
    assertEquals("parent-relationship-id", parentRelationship.getId());
    assertEquals("#" + persona.getId(), parentRelationship.getParent().getHref().toString());
    assertEquals("#" + persona.getId(), parentRelationship.getChild().getHref().toString());

    assertEquals(1, record.getSources().size());
    SourceReference sourceReference = record.getSources().get(0);
    assertEquals("urn:source-uri", sourceReference.getHref().toString());
    assertEquals("source-reference-id", sourceReference.getId());
    assertEquals(SourceReferenceType.source, sourceReference.getKnownType());
    assertEquals(1, sourceReference.getQualifiers().size());
    SourceQualifier qualifier = sourceReference.getQualifiers().get(0);
    //todo: figure out why json doesn't deserialize anyattribute.
    //assertEquals("2", qualifier.getProperty(SourceQualifierProperty.x_pixels));

    assertEquals("rid", record.getId());
  }

}

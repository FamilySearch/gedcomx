package org.gedcomx.conclusion.www;

import org.gedcomx.attribution.Attribution;
import org.gedcomx.attribution.ContributorReference;
import org.gedcomx.conclusion.*;
import org.gedcomx.id.AlternateId;
import org.gedcomx.types.AlternateIdType;
import org.gedcomx.source.AttributedSourceReference;
import org.gedcomx.source.SourceQualifier;
import org.gedcomx.source.SourceQualifierProperty;
import org.gedcomx.types.*;
import org.gedcomx.www.Link;
import org.gedcomx.www.Links;
import org.testng.annotations.Test;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import static org.gedcomx.rt.SerializationUtil.processThroughJson;
import static org.gedcomx.rt.SerializationUtil.processThroughXml;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertFalse;
import static org.testng.AssertJUnit.assertTrue;

/**
 * @author Ryan Heaton
 */
@Test
public class TestPerson {

  /**
   * tests processing a WWW person through xml...
   */
  public void testWWWPersonXml() throws Exception {
    Person person = createTestWWWPerson();
    person = processThroughXml(person);
    assertTestWWWPerson(person);
  }

  /**
   * tests processing a WWW person through json...
   */
  public void testWWWPersonJson() throws Exception {
    Person person = createTestWWWPerson();
    person = processThroughJson(person);
    assertTestWWWPerson(person);
  }

  /**
   * tests serializing an instance of the www person to/from a "base" person via xml.
   */
  public void testWWWPersonToBasePersonViaXml() throws Exception {
    Person person = createTestWWWPerson();
    org.gedcomx.conclusion.Person p = processThroughXml(person, org.gedcomx.conclusion.Person.class);
    assertFalse(p instanceof Person);
    assertTestBasePerson(p);

    p = createTestBasePerson();
    person = processThroughXml(p, Person.class);
    assertTestBasePerson(person);
  }

  /**
   * tests serializing an instance of the www person to/from a "base" person via json.
   */
  public void testWWWPersonToBasePersonViaJson() throws Exception {
    //todo: figure out how to test to/from base via json. right now, the @type attribute is explicit...
  }


  private Person createTestWWWPerson() {
    Person person = new Person();
    Gender gender = new Gender();
    gender.setLinks(new Links());
    gender.getLinks().setLinks(new ArrayList<Link>());
    Link genderLink = new Link();
    genderLink.setHref(URI.create("urn:gender"));
    gender.getLinks().getLinks().add(genderLink);
    gender.setType(GenderType.male);
    person.setGender(gender);

    person.setLinks(new Links());
    person.getLinks().setLinks(new ArrayList<Link>());
    Link personLink = new Link();
    personLink.setHref(URI.create("urn:person"));
    person.getLinks().getLinks().add(personLink);

    ArrayList<AlternateId> alternateIds = new ArrayList<AlternateId>();
    AlternateId alternateId = new AlternateId();
    alternateId.setKnownType(AlternateIdType.forwarded);
    alternateId.setValue("forward-value");
    alternateIds.add(alternateId);
    person.setAlternateIds(alternateIds);

    List<org.gedcomx.conclusion.Characteristic> characteristics = new ArrayList<org.gedcomx.conclusion.Characteristic>();
    Characteristic characteristic = new Characteristic();
    characteristic.setLinks(new Links());
    characteristic.getLinks().setLinks(new ArrayList<Link>());
    Link characteristicLink = new Link();
    characteristicLink.setHref(URI.create("urn:characteristic"));
    characteristic.getLinks().getLinks().add(characteristicLink);
    characteristic.setAttribution(new Attribution());
    characteristic.getAttribution().setContributor(new ContributorReference());
    characteristic.getAttribution().getContributor().setHref(URI.create("urn:characteristic-attribution"));
    characteristic.setDate(new Date());
    characteristic.getDate().setOriginal("original date");
    characteristic.getDate().setNormalized("normalized date");
    characteristic.getDate().setJulianDay(new JulianDayRange());
    characteristic.getDate().getJulianDay().setEarliest(1);
    characteristic.getDate().getJulianDay().setLatest(2);
    characteristic.setId("characteristic-id");
    characteristic.setKnownType(CharacteristicType.occupation);
    characteristic.setPlace(new Place());
    characteristic.getPlace().setOriginal("original place");
    characteristic.getPlace().setNormalized("normalized place");
    characteristic.getPlace().setGeoCode(new GeoCode());
    characteristic.getPlace().getGeoCode().setLatitude(1.2F);
    characteristic.getPlace().getGeoCode().setLongitude(3.4F);
    characteristic.setValue("characteristic-value");
    characteristics.add(characteristic);
    person.setCharacteristics(characteristics);

    List<org.gedcomx.conclusion.Event> events = new ArrayList<org.gedcomx.conclusion.Event>();
    Event event = new Event();
    event.setLinks(new Links());
    event.getLinks().setLinks(new ArrayList<Link>());
    Link eventLink = new Link();
    eventLink.setHref(URI.create("urn:event"));
    event.getLinks().getLinks().add(eventLink);
    event.setAttribution(new Attribution());
    event.getAttribution().setContributor(new ContributorReference());
    event.getAttribution().getContributor().setHref(URI.create("urn:event-attribution"));
    event.setDate(new Date());
    event.getDate().setOriginal("original date");
    event.getDate().setNormalized("normalized date");
    event.getDate().setJulianDay(new JulianDayRange());
    event.getDate().getJulianDay().setEarliest(1);
    event.getDate().getJulianDay().setLatest(2);
    event.setId("event-id");
    event.setKnownType(EventType.adoption);
    event.setPlace(new Place());
    event.getPlace().setOriginal("original place");
    event.getPlace().setNormalized("normalized place");
    event.getPlace().setGeoCode(new GeoCode());
    event.getPlace().getGeoCode().setLatitude(1.2F);
    event.getPlace().getGeoCode().setLongitude(3.4F);
    events.add(event);
    person.setEvents(events);

    List<org.gedcomx.conclusion.Name> names = new ArrayList<org.gedcomx.conclusion.Name>();
    Name name = new Name();
    name.setLinks(new Links());
    name.getLinks().setLinks(new ArrayList<Link>());
    Link nameLink = new Link();
    nameLink.setHref(URI.create("urn:name"));
    name.getLinks().getLinks().add(nameLink);
    ArrayList<NameForm> alternateForms = new ArrayList<NameForm>();
    NameForm nameForm = new NameForm();
    nameForm.setFullText("alternate name form");
    nameForm.setKnownScript(NameScript.chinese);
    ArrayList<NamePart> parts = new ArrayList<NamePart>();
    NamePart part = new NamePart();
    part.setKnownType(NamePartType.given);
    part.setText("alternate name part");
    parts.add(part);
    nameForm.setParts(parts);
    alternateForms.add(nameForm);
    name.setAlternateForms(alternateForms);
    name.setAttribution(new Attribution());
    name.getAttribution().setContributor(new ContributorReference());
    name.getAttribution().getContributor().setHref(URI.create("urn:name-attribution"));
    name.setId("name-id");
    name.setKnownStyle(NameStyle.spanish);
    name.setKnownType(NameType.formal);
    NameForm primaryForm = new NameForm();
    primaryForm.setFullText("primary form");
    primaryForm.setKnownScript(NameScript.chinese);
    primaryForm.setParts(new ArrayList<NamePart>());
    NamePart namePart = new NamePart();
    namePart.setKnownType(NamePartType.surname);
    namePart.setText("primary surname");
    primaryForm.getParts().add(namePart);
    name.setPrimaryForm(primaryForm);
    names.add(name);
    person.setNames(names);

    person.setPersistentId(URI.create("pal"));

    person.setRelationships(new ArrayList<RelationshipReference>());
    RelationshipReference relationshipReference = new RelationshipReference();
    relationshipReference.setKnownRole(RelationshipRole.child);
    relationshipReference.setHref(URI.create("urn:relationship"));
    person.getRelationships().add(relationshipReference);

    ArrayList<AttributedSourceReference> sources = new ArrayList<AttributedSourceReference>();
    AttributedSourceReference attributedSourceReference = new AttributedSourceReference();
    attributedSourceReference.setAttribution(new Attribution());
    attributedSourceReference.getAttribution().setContributor(new ContributorReference());
    attributedSourceReference.getAttribution().getContributor().setHref(URI.create("urn:source-reference-attribution"));
    attributedSourceReference.setHref(URI.create("urn:source-uri"));
    attributedSourceReference.setId("source-reference-id");
    attributedSourceReference.setKnownType(SourceReferenceType.source);
    ArrayList<SourceQualifier> qualifiers = new ArrayList<SourceQualifier>();
    SourceQualifier qualifier = new SourceQualifier();
    qualifier.setProperty(SourceQualifierProperty.x_pixels, "2");
    qualifiers.add(qualifier);
    attributedSourceReference.setQualifiers(qualifiers);
    sources.add(attributedSourceReference);
    person.setSources(sources);

    person.setId("pid");
    return person;
  }

  private org.gedcomx.conclusion.Person createTestBasePerson() {
    org.gedcomx.conclusion.Person person = new org.gedcomx.conclusion.Person();
    org.gedcomx.conclusion.Gender gender = new org.gedcomx.conclusion.Gender();
    gender.setType(GenderType.male);
    person.setGender(gender);

    ArrayList<AlternateId> alternateIds = new ArrayList<AlternateId>();
    AlternateId alternateId = new AlternateId();
    alternateId.setKnownType(AlternateIdType.forwarded);
    alternateId.setValue("forward-value");
    alternateIds.add(alternateId);
    person.setAlternateIds(alternateIds);

    List<org.gedcomx.conclusion.Characteristic> characteristics = new ArrayList<org.gedcomx.conclusion.Characteristic>();
    org.gedcomx.conclusion.Characteristic characteristic = new org.gedcomx.conclusion.Characteristic();
    characteristic.setAttribution(new Attribution());
    characteristic.getAttribution().setContributor(new ContributorReference());
    characteristic.getAttribution().getContributor().setHref(URI.create("urn:characteristic-attribution"));
    characteristic.setDate(new Date());
    characteristic.getDate().setOriginal("original date");
    characteristic.getDate().setNormalized("normalized date");
    characteristic.getDate().setJulianDay(new JulianDayRange());
    characteristic.getDate().getJulianDay().setEarliest(1);
    characteristic.getDate().getJulianDay().setLatest(2);
    characteristic.setId("characteristic-id");
    characteristic.setKnownType(CharacteristicType.occupation);
    characteristic.setPlace(new Place());
    characteristic.getPlace().setOriginal("original place");
    characteristic.getPlace().setNormalized("normalized place");
    characteristic.getPlace().setGeoCode(new GeoCode());
    characteristic.getPlace().getGeoCode().setLatitude(1.2F);
    characteristic.getPlace().getGeoCode().setLongitude(3.4F);
    characteristic.setValue("characteristic-value");
    characteristics.add(characteristic);
    person.setCharacteristics(characteristics);

    List<org.gedcomx.conclusion.Event> events = new ArrayList<org.gedcomx.conclusion.Event>();
    org.gedcomx.conclusion.Event event = new org.gedcomx.conclusion.Event();
    event.setAttribution(new Attribution());
    event.getAttribution().setContributor(new ContributorReference());
    event.getAttribution().getContributor().setHref(URI.create("urn:event-attribution"));
    event.setDate(new Date());
    event.getDate().setOriginal("original date");
    event.getDate().setNormalized("normalized date");
    event.getDate().setJulianDay(new JulianDayRange());
    event.getDate().getJulianDay().setEarliest(1);
    event.getDate().getJulianDay().setLatest(2);
    event.setId("event-id");
    event.setKnownType(EventType.adoption);
    event.setPlace(new Place());
    event.getPlace().setOriginal("original place");
    event.getPlace().setNormalized("normalized place");
    event.getPlace().setGeoCode(new GeoCode());
    event.getPlace().getGeoCode().setLatitude(1.2F);
    event.getPlace().getGeoCode().setLongitude(3.4F);
    events.add(event);
    person.setEvents(events);

    List<org.gedcomx.conclusion.Name> names = new ArrayList<org.gedcomx.conclusion.Name>();
    org.gedcomx.conclusion.Name name = new org.gedcomx.conclusion.Name();
    ArrayList<NameForm> alternateForms = new ArrayList<NameForm>();
    NameForm nameForm = new NameForm();
    nameForm.setFullText("alternate name form");
    nameForm.setKnownScript(NameScript.chinese);
    ArrayList<NamePart> parts = new ArrayList<NamePart>();
    NamePart part = new NamePart();
    part.setKnownType(NamePartType.given);
    part.setText("alternate name part");
    parts.add(part);
    nameForm.setParts(parts);
    alternateForms.add(nameForm);
    name.setAlternateForms(alternateForms);
    name.setAttribution(new Attribution());
    name.getAttribution().setContributor(new ContributorReference());
    name.getAttribution().getContributor().setHref(URI.create("urn:name-attribution"));
    name.setId("name-id");
    name.setKnownStyle(NameStyle.spanish);
    name.setKnownType(NameType.formal);
    NameForm primaryForm = new NameForm();
    primaryForm.setFullText("primary form");
    primaryForm.setKnownScript(NameScript.chinese);
    primaryForm.setParts(new ArrayList<NamePart>());
    NamePart namePart = new NamePart();
    namePart.setKnownType(NamePartType.surname);
    namePart.setText("primary surname");
    primaryForm.getParts().add(namePart);
    name.setPrimaryForm(primaryForm);
    names.add(name);
    person.setNames(names);

    person.setPersistentId(URI.create("pal"));

    person.setRelationships(new ArrayList<RelationshipReference>());
    RelationshipReference relationshipReference = new RelationshipReference();
    relationshipReference.setKnownRole(RelationshipRole.child);
    relationshipReference.setHref(URI.create("urn:relationship"));
    person.getRelationships().add(relationshipReference);

    ArrayList<AttributedSourceReference> sources = new ArrayList<AttributedSourceReference>();
    AttributedSourceReference attributedSourceReference = new AttributedSourceReference();
    attributedSourceReference.setAttribution(new Attribution());
    attributedSourceReference.getAttribution().setContributor(new ContributorReference());
    attributedSourceReference.getAttribution().getContributor().setHref(URI.create("urn:source-reference-attribution"));
    attributedSourceReference.setHref(URI.create("urn:source-uri"));
    attributedSourceReference.setId("source-reference-id");
    attributedSourceReference.setKnownType(SourceReferenceType.source);
    ArrayList<SourceQualifier> qualifiers = new ArrayList<SourceQualifier>();
    SourceQualifier qualifier = new SourceQualifier();
    qualifier.setProperty(SourceQualifierProperty.x_pixels, "2");
    qualifiers.add(qualifier);
    attributedSourceReference.setQualifiers(qualifiers);
    sources.add(attributedSourceReference);
    person.setSources(sources);

    person.setId("pid");
    return person;
  }

  private void assertTestWWWPerson(Person person) {
    Characteristic characteristic;
    Event event;
    Name name;
    RelationshipReference relationshipReference;
    AttributedSourceReference attributedSourceReference;
    assertEquals(GenderType.male, person.getGender().getType());
    assertTrue(person.getGender() instanceof Gender);
    assertEquals("urn:gender", ((Gender) person.getGender()).getLinks().getLinks().get(0).getHref().toString());

    assertEquals(1, person.getLinks().getLinks().size());
    assertEquals("urn:person", person.getLinks().getLinks().get(0).getHref().toString());

    assertEquals(1, person.getAlternateIds().size());
    assertEquals(AlternateIdType.forwarded, person.getAlternateIds().get(0).getKnownType());
    assertEquals("forward-value", person.getAlternateIds().get(0).getValue());

    assertEquals(1, person.getCharacteristics().size());
    assertEquals(1, ((Characteristic) person.getCharacteristics().iterator().next()).getLinks().getLinks().size());
    characteristic = (Characteristic) person.getCharacteristics().iterator().next();
    assertEquals("urn:characteristic", characteristic.getLinks().getLinks().get(0).getHref().toString());
    assertEquals("urn:characteristic-attribution", characteristic.getAttribution().getContributor().getHref().toString());
    assertEquals("original date", characteristic.getDate().getOriginal());
    assertEquals("normalized date", characteristic.getDate().getNormalized());
    assertEquals(1, characteristic.getDate().getJulianDay().getEarliest());
    assertEquals(2, characteristic.getDate().getJulianDay().getLatest());
    assertEquals("characteristic-id", characteristic.getId());
    assertEquals(CharacteristicType.occupation, characteristic.getKnownType());
    assertEquals("original place", characteristic.getPlace().getOriginal());
    assertEquals("normalized place", characteristic.getPlace().getNormalized());
    assertEquals(1.2F, characteristic.getPlace().getGeoCode().getLatitude());
    assertEquals(3.4F, characteristic.getPlace().getGeoCode().getLongitude());
    assertEquals("characteristic-value", characteristic.getValue());

    assertEquals(1, person.getEvents().size());
    assertEquals(1, ((Event) person.getEvents().iterator().next()).getLinks().getLinks().size());
    event = (Event) person.getEvents().iterator().next();
    assertEquals("urn:event", event.getLinks().getLinks().get(0).getHref().toString());
    assertEquals("urn:event-attribution", event.getAttribution().getContributor().getHref().toString());
    assertEquals("original date", event.getDate().getOriginal());
    assertEquals("normalized date", event.getDate().getNormalized());
    assertEquals(1, event.getDate().getJulianDay().getEarliest());
    assertEquals(2, event.getDate().getJulianDay().getLatest());
    assertEquals("event-id", event.getId());
    assertEquals(EventType.adoption, event.getKnownType());
    assertEquals("original place", event.getPlace().getOriginal());
    assertEquals("normalized place", event.getPlace().getNormalized());
    assertEquals(1.2F, event.getPlace().getGeoCode().getLatitude());
    assertEquals(3.4F, event.getPlace().getGeoCode().getLongitude());

    assertEquals(1, person.getNames().size());
    assertEquals(1, ((Name) person.getNames().iterator().next()).getLinks().getLinks().size());
    name = (Name) person.getNames().iterator().next();
    assertEquals("urn:name", name.getLinks().getLinks().get(0).getHref().toString());
    name = (Name) person.getNames().iterator().next();
    assertEquals(1, name.getAlternateForms().size());
    assertEquals("alternate name form", name.getAlternateForms().get(0).getFullText());
    assertEquals(NameScript.chinese, name.getAlternateForms().get(0).getKnownScript());
    assertEquals(1, name.getAlternateForms().get(0).getParts().size());
    assertEquals("alternate name part", name.getAlternateForms().get(0).getParts().get(0).getText());
    assertEquals(NamePartType.given, name.getAlternateForms().get(0).getParts().get(0).getKnownType());
    assertEquals("urn:name-attribution", name.getAttribution().getContributor().getHref().toString());
    assertEquals("name-id", name.getId());
    assertEquals(NameStyle.spanish, name.getKnownStyle());
    assertEquals(NameType.formal, name.getKnownType());
    assertEquals("primary form", name.getPrimaryForm().getFullText());
    assertEquals(NameScript.chinese, name.getPrimaryForm().getKnownScript());
    assertEquals(1, name.getPrimaryForm().getParts().size());
    assertEquals("primary surname", name.getPrimaryForm().getParts().get(0).getText());
    assertEquals(NamePartType.surname, name.getPrimaryForm().getParts().get(0).getKnownType());

    assertEquals("pal", person.getPersistentId().toString());

    assertEquals(1, person.getRelationships().size());
    relationshipReference = person.getRelationships().iterator().next();
    assertEquals(RelationshipRole.child, relationshipReference.getKnownRole());
    assertEquals("urn:relationship", relationshipReference.getHref().toString());

    assertEquals(1, person.getSources().size());
    attributedSourceReference = person.getSources().iterator().next();
    assertEquals("urn:source-reference-attribution", attributedSourceReference.getAttribution().getContributor().getHref().toString());
    assertEquals("urn:source-uri", attributedSourceReference.getHref().toString());
    assertEquals("source-reference-id", attributedSourceReference.getId());
    assertEquals(SourceReferenceType.source, attributedSourceReference.getKnownType());
    assertEquals(1, attributedSourceReference.getQualifiers().size());
    assertEquals(1, attributedSourceReference.getQualifiers().get(0).getProperties().size());
    //todo: figure out JSON deserialization of 'other attributes'
    //assertEquals("2", attributedSourceReference.getQualifiers().get(0).getProperty(SourceQualifierProperty.x_pixels));

    assertEquals("pid", person.getId());
  }

  private void assertTestBasePerson(org.gedcomx.conclusion.Person person) {
    org.gedcomx.conclusion.Characteristic characteristic;
    org.gedcomx.conclusion.Event event;
    org.gedcomx.conclusion.Name name;
    RelationshipReference relationshipReference;
    AttributedSourceReference attributedSourceReference;
    assertEquals(GenderType.male, person.getGender().getType());

    assertEquals(1, person.getAlternateIds().size());
    assertEquals(AlternateIdType.forwarded, person.getAlternateIds().get(0).getKnownType());
    assertEquals("forward-value", person.getAlternateIds().get(0).getValue());

    assertEquals(1, person.getCharacteristics().size());
    characteristic = person.getCharacteristics().iterator().next();
    assertEquals("urn:characteristic-attribution", characteristic.getAttribution().getContributor().getHref().toString());
    assertEquals("original date", characteristic.getDate().getOriginal());
    assertEquals("normalized date", characteristic.getDate().getNormalized());
    assertEquals(1, characteristic.getDate().getJulianDay().getEarliest());
    assertEquals(2, characteristic.getDate().getJulianDay().getLatest());
    assertEquals("characteristic-id", characteristic.getId());
    assertEquals(CharacteristicType.occupation, characteristic.getKnownType());
    assertEquals("original place", characteristic.getPlace().getOriginal());
    assertEquals("normalized place", characteristic.getPlace().getNormalized());
    assertEquals(1.2F, characteristic.getPlace().getGeoCode().getLatitude());
    assertEquals(3.4F, characteristic.getPlace().getGeoCode().getLongitude());
    assertEquals("characteristic-value", characteristic.getValue());

    assertEquals(1, person.getEvents().size());
    event = person.getEvents().iterator().next();
    assertEquals("urn:event-attribution", event.getAttribution().getContributor().getHref().toString());
    assertEquals("original date", event.getDate().getOriginal());
    assertEquals("normalized date", event.getDate().getNormalized());
    assertEquals(1, event.getDate().getJulianDay().getEarliest());
    assertEquals(2, event.getDate().getJulianDay().getLatest());
    assertEquals("event-id", event.getId());
    assertEquals(EventType.adoption, event.getKnownType());
    assertEquals("original place", event.getPlace().getOriginal());
    assertEquals("normalized place", event.getPlace().getNormalized());
    assertEquals(1.2F, event.getPlace().getGeoCode().getLatitude());
    assertEquals(3.4F, event.getPlace().getGeoCode().getLongitude());

    assertEquals(1, person.getNames().size());
    name = person.getNames().iterator().next();
    assertEquals(1, name.getAlternateForms().size());
    assertEquals("alternate name form", name.getAlternateForms().get(0).getFullText());
    assertEquals(NameScript.chinese, name.getAlternateForms().get(0).getKnownScript());
    assertEquals(1, name.getAlternateForms().get(0).getParts().size());
    assertEquals("alternate name part", name.getAlternateForms().get(0).getParts().get(0).getText());
    assertEquals(NamePartType.given, name.getAlternateForms().get(0).getParts().get(0).getKnownType());
    assertEquals("urn:name-attribution", name.getAttribution().getContributor().getHref().toString());
    assertEquals("name-id", name.getId());
    assertEquals(NameStyle.spanish, name.getKnownStyle());
    assertEquals(NameType.formal, name.getKnownType());
    assertEquals("primary form", name.getPrimaryForm().getFullText());
    assertEquals(NameScript.chinese, name.getPrimaryForm().getKnownScript());
    assertEquals(1, name.getPrimaryForm().getParts().size());
    assertEquals("primary surname", name.getPrimaryForm().getParts().get(0).getText());
    assertEquals(NamePartType.surname, name.getPrimaryForm().getParts().get(0).getKnownType());

    assertEquals("pal", person.getPersistentId().toString());

    assertEquals(1, person.getRelationships().size());
    relationshipReference = person.getRelationships().iterator().next();
    assertEquals(RelationshipRole.child, relationshipReference.getKnownRole());
    assertEquals("urn:relationship", relationshipReference.getHref().toString());

    assertEquals(1, person.getSources().size());
    attributedSourceReference = person.getSources().iterator().next();
    assertEquals("urn:source-reference-attribution", attributedSourceReference.getAttribution().getContributor().getHref().toString());
    assertEquals("urn:source-uri", attributedSourceReference.getHref().toString());
    assertEquals("source-reference-id", attributedSourceReference.getId());
    assertEquals(SourceReferenceType.source, attributedSourceReference.getKnownType());
    assertEquals(1, attributedSourceReference.getQualifiers().size());
    assertEquals(1, attributedSourceReference.getQualifiers().get(0).getProperties().size());
    //todo: figure out JSON deserialization of 'other attributes'
    //assertEquals("2", attributedSourceReference.getQualifiers().get(0).getProperty(SourceQualifierProperty.x_pixels));

    assertEquals("pid", person.getId());
  }

}

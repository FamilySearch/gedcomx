package org.gedcomx.conclusion.www;

import org.gedcomx.attribution.Attribution;
import org.gedcomx.attribution.ContributorReference;
import org.gedcomx.common.AlternateId;
import org.gedcomx.common.Extension;
import org.gedcomx.conclusion.*;
import org.gedcomx.source.SourceQualifier;
import org.gedcomx.source.SourceQualifierProperty;
import org.gedcomx.source.SourceReference;
import org.gedcomx.types.*;
import org.gedcomx.www.Link;
import org.testng.annotations.Test;

import javax.xml.bind.JAXBContext;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import static org.gedcomx.rt.SerializationUtil.processThroughJson;
import static org.gedcomx.rt.SerializationUtil.processThroughXml;
import static org.testng.AssertJUnit.assertEquals;

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
    person = processThroughXml(person, Person.class, JAXBContext.newInstance(Person.class, Link.class));
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

  private Person createTestWWWPerson() {
    Person person = new Person();
    Gender gender = new Gender();
    gender.setExtension(new Extension());
    Link genderLink = new Link();
    genderLink.setHref(URI.create("urn:gender"));
    gender.getExtension().addElement(genderLink);
    gender.setType(GenderType.male);
    person.setGender(gender);

    person.setExtension(new Extension());
    Link personLink = new Link();
    personLink.setHref(URI.create("urn:person"));
    person.getExtension().addElement(personLink);

    ArrayList<AlternateId> alternateIds = new ArrayList<AlternateId>();
    AlternateId alternateId = new AlternateId();
    alternateId.setKnownType(AlternateIdType.forwarded);
    alternateId.setValue("forward-value");
    alternateIds.add(alternateId);
    person.setAlternateIds(alternateIds);

    List<org.gedcomx.conclusion.Characteristic> characteristics = new ArrayList<org.gedcomx.conclusion.Characteristic>();
    Characteristic characteristic = new Characteristic();
    characteristic.setExtension(new Extension());
    Link characteristicLink = new Link();
    characteristicLink.setHref(URI.create("urn:characteristic"));
    characteristic.getExtension().addElement(characteristicLink);
    characteristic.setAttribution(new Attribution());
    characteristic.getAttribution().setContributor(new ContributorReference());
    characteristic.getAttribution().getContributor().setHref(URI.create("urn:characteristic-attribution"));
    characteristic.setDate(new Date());
    characteristic.getDate().setOriginal("original date");
    characteristic.getDate().setNormalized("normalized date");
    characteristic.setId("characteristic-id");
    characteristic.setKnownType(CharacteristicType.occupation);
    characteristic.setPlace(new Place());
    characteristic.getPlace().setOriginal("original place");
    characteristic.getPlace().setNormalized("normalized place");
    characteristic.setValue("characteristic-value");
    characteristics.add(characteristic);
    person.setCharacteristics(characteristics);

    List<org.gedcomx.conclusion.Event> events = new ArrayList<org.gedcomx.conclusion.Event>();
    Event event = new Event();
    event.setExtension(new Extension());
    Link eventLink = new Link();
    eventLink.setHref(URI.create("urn:event"));
    event.getExtension().addElement(eventLink);
    event.setAttribution(new Attribution());
    event.getAttribution().setContributor(new ContributorReference());
    event.getAttribution().getContributor().setHref(URI.create("urn:event-attribution"));
    event.setDate(new Date());
    event.getDate().setOriginal("original date");
    event.getDate().setNormalized("normalized date");
    event.setId("event-id");
    event.setKnownType(EventType.adoption);
    event.setPlace(new Place());
    event.getPlace().setOriginal("original place");
    event.getPlace().setNormalized("normalized place");
    events.add(event);
    person.setEvents(events);

    List<org.gedcomx.conclusion.Name> names = new ArrayList<org.gedcomx.conclusion.Name>();
    Name name = new Name();
    name.setExtension(new Extension());
    Link nameLink = new Link();
    nameLink.setHref(URI.create("urn:name"));
    name.getExtension().addElement(nameLink);
    ArrayList<NameForm> alternateForms = new ArrayList<NameForm>();
    NameForm nameForm = new NameForm();
    nameForm.setFullText("alternate name form");
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

    ArrayList<SourceReference> sources = new ArrayList<SourceReference>();
    SourceReference attributedSourceReference = new SourceReference();
    Attribution attribution = new Attribution();
    attributedSourceReference.setExtension(new Extension());
    attributedSourceReference.getExtension().addElement(attribution);
    attribution.setContributor(new ContributorReference());
    attribution.getContributor().setHref(URI.create("urn:source-reference-attribution"));
    attributedSourceReference.setHref(URI.create("urn:source-uri"));
    attributedSourceReference.setId("source-reference-id");
    attributedSourceReference.setKnownType(SourceType.collection);
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
    SourceReference attributedSourceReference;
    assertEquals(GenderType.male, person.getGender().getType());
    assertEquals("urn:gender", person.getGender().getExtension().findExtensionsOfType(Link.class).get(0).getHref().toString());

    assertEquals(1, person.getExtension().findExtensionsOfType(Link.class).size());
    assertEquals("urn:person", person.getExtension().findExtensionsOfType(Link.class).get(0).getHref().toString());

    assertEquals(1, person.getAlternateIds().size());
    assertEquals(AlternateIdType.forwarded, person.getAlternateIds().get(0).getKnownType());
    assertEquals("forward-value", person.getAlternateIds().get(0).getValue());

    assertEquals(1, person.getCharacteristics().size());
    assertEquals(1, person.getCharacteristics().iterator().next().getExtension().findExtensionsOfType(Link.class).size());
    characteristic = person.getCharacteristics().iterator().next();
    assertEquals("urn:characteristic", characteristic.getExtension().findExtensionsOfType(Link.class).get(0).getHref().toString());
    assertEquals("urn:characteristic-attribution", characteristic.getAttribution().getContributor().getHref().toString());
    assertEquals("original date", characteristic.getDate().getOriginal());
    assertEquals("normalized date", characteristic.getDate().getNormalized());
    assertEquals("characteristic-id", characteristic.getId());
    assertEquals(CharacteristicType.occupation, characteristic.getKnownType());
    assertEquals("original place", characteristic.getPlace().getOriginal());
    assertEquals("normalized place", characteristic.getPlace().getNormalized());
    assertEquals("characteristic-value", characteristic.getValue());

    assertEquals(1, person.getEvents().size());
    assertEquals(1, person.getEvents().iterator().next().getExtension().findExtensionsOfType(Link.class).size());
    event = person.getEvents().iterator().next();
    assertEquals("urn:event", event.getExtension().findExtensionsOfType(Link.class).get(0).getHref().toString());
    assertEquals("urn:event-attribution", event.getAttribution().getContributor().getHref().toString());
    assertEquals("original date", event.getDate().getOriginal());
    assertEquals("normalized date", event.getDate().getNormalized());
    assertEquals("event-id", event.getId());
    assertEquals(EventType.adoption, event.getKnownType());
    assertEquals("original place", event.getPlace().getOriginal());
    assertEquals("normalized place", event.getPlace().getNormalized());

    assertEquals(1, person.getNames().size());
    assertEquals(1, person.getNames().iterator().next().getExtension().findExtensionsOfType(Link.class).size());
    name = person.getNames().iterator().next();
    assertEquals("urn:name", name.getExtension().findExtensionsOfType(Link.class).get(0).getHref().toString());
    name = person.getNames().iterator().next();
    assertEquals(1, name.getAlternateForms().size());
    assertEquals("alternate name form", name.getAlternateForms().get(0).getFullText());
    assertEquals(1, name.getAlternateForms().get(0).getParts().size());
    assertEquals("alternate name part", name.getAlternateForms().get(0).getParts().get(0).getText());
    assertEquals(NamePartType.given, name.getAlternateForms().get(0).getParts().get(0).getKnownType());
    assertEquals("urn:name-attribution", name.getAttribution().getContributor().getHref().toString());
    assertEquals("name-id", name.getId());
    assertEquals(NameStyle.spanish, name.getKnownStyle());
    assertEquals(NameType.formal, name.getKnownType());
    assertEquals("primary form", name.getPrimaryForm().getFullText());
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
    assertEquals("urn:source-reference-attribution", attributedSourceReference.getExtension().findExtensionOfType(Attribution.class).getContributor().getHref().toString());
    assertEquals("urn:source-uri", attributedSourceReference.getHref().toString());
    assertEquals("source-reference-id", attributedSourceReference.getId());
    assertEquals(SourceType.collection, attributedSourceReference.getKnownType());
    assertEquals(1, attributedSourceReference.getQualifiers().size());
    assertEquals(1, attributedSourceReference.getQualifiers().get(0).getProperties().size());
    assertEquals("2", attributedSourceReference.getQualifiers().get(0).getProperty(SourceQualifierProperty.x_pixels));

    assertEquals("pid", person.getId());
  }

}

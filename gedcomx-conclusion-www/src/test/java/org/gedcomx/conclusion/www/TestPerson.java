package org.gedcomx.conclusion.www;

import org.gedcomx.common.AlternateId;
import org.gedcomx.common.Attribution;
import org.gedcomx.common.ResourceReference;
import org.gedcomx.conclusion.*;
import org.gedcomx.metadata.rdf.RDFDescriptionSet;
import org.gedcomx.types.*;
import org.gedcomx.www.Link;
import org.testng.annotations.Test;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import static org.gedcomx.rt.SerializationUtil.processThroughJson;
import static org.gedcomx.rt.SerializationUtil.processThroughXml;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertNotNull;

/**
 * @author Ryan Heaton
 */
@Test
public class TestPerson {

  /**
   * tests processing a WWW person through xml...
   */
  public void testWWWPersonXml() throws Exception {
    PersonWWW person = createTestWWWPerson();
    person = processThroughXml(person);
    assertTestWWWPerson(person);
  }

  /**
   * tests processing a WWW person through json...
   */
  public void testWWWPersonJson() throws Exception {
    PersonWWW person = createTestWWWPerson();
    person = processThroughJson(person);
    assertTestWWWPerson(person);
  }

  private PersonWWW createTestWWWPerson() {
    PersonWWW personWWW = new PersonWWW();
    personWWW.setPerson(createTestPerson());
    personWWW.setMetadata(new RDFDescriptionSet());
    return personWWW;
  }

  private Person createTestPerson() {
    Person person = new Person();
    Gender gender = new Gender();
    Link genderLink = new Link();
    genderLink.setHref(URI.create("urn:gender"));
    gender.addExtensionElement(genderLink);
    gender.setKnownType(GenderType.Male);
    person.setGender(gender);

    Link personLink = new Link();
    personLink.setHref(URI.create("urn:person"));
    person.addExtensionElement(personLink);

    ArrayList<AlternateId> alternateIds = new ArrayList<AlternateId>();
    AlternateId alternateId = new AlternateId();
    alternateId.setKnownType(AlternateIdType.Forwarded);
    alternateId.setValue("forward-value");
    alternateIds.add(alternateId);
    person.setAlternateIds(alternateIds);

    List<org.gedcomx.conclusion.Characteristic> characteristics = new ArrayList<org.gedcomx.conclusion.Characteristic>();
    Characteristic characteristic = new Characteristic();
    Link characteristicLink = new Link();
    characteristicLink.setHref(URI.create("urn:characteristic"));
    characteristic.addExtensionElement(characteristicLink);
    characteristic.setAttribution(new Attribution());
    characteristic.getAttribution().setContributor(new ResourceReference());
    characteristic.getAttribution().getContributor().setResource(URI.create("urn:characteristic-attribution"));
    characteristic.setDate(new Date());
    characteristic.getDate().setOriginal("original date");
    characteristic.getDate().setNormalized("normalized date");
    characteristic.setId("characteristic-id");
    characteristic.setKnownType(CharacteristicType.Occupation);
    characteristic.setPlace(new Place());
    characteristic.getPlace().setOriginal("original place");
    characteristic.getPlace().setNormalized("normalized place");
    characteristic.setValue("characteristic-value");
    characteristics.add(characteristic);
    person.setCharacteristics(characteristics);

    List<org.gedcomx.conclusion.Event> events = new ArrayList<org.gedcomx.conclusion.Event>();
    Event event = new Event();
    Link eventLink = new Link();
    eventLink.setHref(URI.create("urn:event"));
    event.addExtensionElement(eventLink);
    event.setAttribution(new Attribution());
    event.getAttribution().setContributor(new ResourceReference());
    event.getAttribution().getContributor().setResource(URI.create("urn:event-attribution"));
    event.setDate(new Date());
    event.getDate().setOriginal("original date");
    event.getDate().setNormalized("normalized date");
    event.setId("event-id");
    event.setKnownType(EventType.Adoption);
    event.setPlace(new Place());
    event.getPlace().setOriginal("original place");
    event.getPlace().setNormalized("normalized place");
    events.add(event);
    person.setEvents(events);

    List<org.gedcomx.conclusion.Name> names = new ArrayList<org.gedcomx.conclusion.Name>();
    Name name = new Name();
    Link nameLink = new Link();
    nameLink.setHref(URI.create("urn:name"));
    name.addExtensionElement(nameLink);
    ArrayList<NameForm> alternateForms = new ArrayList<NameForm>();
    NameForm nameForm = new NameForm();
    nameForm.setFullText("alternate name form");
    ArrayList<NamePart> parts = new ArrayList<NamePart>();
    NamePart part = new NamePart();
    part.setKnownType(NamePartType.Given);
    part.setText("alternate name part");
    parts.add(part);
    nameForm.setParts(parts);
    alternateForms.add(nameForm);
    name.setAlternateForms(alternateForms);
    name.setAttribution(new Attribution());
    name.getAttribution().setContributor(new ResourceReference());
    name.getAttribution().getContributor().setResource(URI.create("urn:name-attribution"));
    name.setId("name-id");
    name.setKnownType(NameType.Formal);
    NameForm primaryForm = new NameForm();
    primaryForm.setFullText("primary form");
    primaryForm.setParts(new ArrayList<NamePart>());
    NamePart namePart = new NamePart();
    namePart.setKnownType(NamePartType.Surname);
    namePart.setText("primary surname");
    primaryForm.getParts().add(namePart);
    name.setPrimaryForm(primaryForm);
    names.add(name);
    person.setNames(names);

    person.setPersistentId(URI.create("pal"));

    ArrayList<ResourceReference> sources = new ArrayList<ResourceReference>();
    ResourceReference attributedSourceReference = new ResourceReference();
    Attribution attribution = new Attribution();
    attributedSourceReference.setExtensionElements(new ArrayList<Object>());
    attributedSourceReference.getExtensionElements().add(attribution);
    attribution.setContributor(new ResourceReference());
    attribution.getContributor().setResource(URI.create("urn:source-reference-attribution"));
    attributedSourceReference.setResource(URI.create("urn:source-uri"));
    attributedSourceReference.setId("source-reference-id");
    attributedSourceReference.setKnownType(ResourceType.Collection);
    sources.add(attributedSourceReference);
    person.setSources(sources);

    person.setId("pid");
    return person;
  }

  private void assertTestWWWPerson(PersonWWW person) {
    assertTestPerson(person.getPerson());
    assertNotNull(person.getMetadata());
  }

  private void assertTestPerson(Person person) {
    Characteristic characteristic;
    Event event;
    Name name;
    ResourceReference attributedSourceReference;
    assertEquals(GenderType.Male, person.getGender().getKnownType());
    assertEquals("urn:gender", person.getGender().findExtensionsOfType(Link.class).get(0).getHref().toString());

    assertEquals(1, person.findExtensionsOfType(Link.class).size());
    assertEquals("urn:person", person.findExtensionsOfType(Link.class).get(0).getHref().toString());

    assertEquals(1, person.getAlternateIds().size());
    assertEquals(AlternateIdType.Forwarded, person.getAlternateIds().get(0).getKnownType());
    assertEquals("forward-value", person.getAlternateIds().get(0).getValue());

    assertEquals(1, person.getCharacteristics().size());
    assertEquals(1, person.getCharacteristics().iterator().next().findExtensionsOfType(Link.class).size());
    characteristic = person.getCharacteristics().iterator().next();
    assertEquals("urn:characteristic", characteristic.findExtensionsOfType(Link.class).get(0).getHref().toString());
    assertEquals("urn:characteristic-attribution", characteristic.getAttribution().getContributor().getResource().toString());
    assertEquals("original date", characteristic.getDate().getOriginal());
    assertEquals("normalized date", characteristic.getDate().getNormalized());
    assertEquals("characteristic-id", characteristic.getId());
    assertEquals(CharacteristicType.Occupation, characteristic.getKnownType());
    assertEquals("original place", characteristic.getPlace().getOriginal());
    assertEquals("normalized place", characteristic.getPlace().getNormalized());
    assertEquals("characteristic-value", characteristic.getValue());

    assertEquals(1, person.getEvents().size());
    assertEquals(1, person.getEvents().iterator().next().findExtensionsOfType(Link.class).size());
    event = person.getEvents().iterator().next();
    assertEquals("urn:event", event.findExtensionsOfType(Link.class).get(0).getHref().toString());
    assertEquals("urn:event-attribution", event.getAttribution().getContributor().getResource().toString());
    assertEquals("original date", event.getDate().getOriginal());
    assertEquals("normalized date", event.getDate().getNormalized());
    assertEquals("event-id", event.getId());
    assertEquals(EventType.Adoption, event.getKnownType());
    assertEquals("original place", event.getPlace().getOriginal());
    assertEquals("normalized place", event.getPlace().getNormalized());

    assertEquals(1, person.getNames().size());
    assertEquals(1, person.getNames().iterator().next().findExtensionsOfType(Link.class).size());
    name = person.getNames().iterator().next();
    assertEquals("urn:name", name.findExtensionsOfType(Link.class).get(0).getHref().toString());
    name = person.getNames().iterator().next();
    assertEquals(1, name.getAlternateForms().size());
    assertEquals("alternate name form", name.getAlternateForms().get(0).getFullText());
    assertEquals(1, name.getAlternateForms().get(0).getParts().size());
    assertEquals("alternate name part", name.getAlternateForms().get(0).getParts().get(0).getText());
    assertEquals(NamePartType.Given, name.getAlternateForms().get(0).getParts().get(0).getKnownType());
    assertEquals("urn:name-attribution", name.getAttribution().getContributor().getResource().toString());
    assertEquals("name-id", name.getId());
    assertEquals(NameType.Formal, name.getKnownType());
    assertEquals("primary form", name.getPrimaryForm().getFullText());
    assertEquals(1, name.getPrimaryForm().getParts().size());
    assertEquals("primary surname", name.getPrimaryForm().getParts().get(0).getText());
    assertEquals(NamePartType.Surname, name.getPrimaryForm().getParts().get(0).getKnownType());

    assertEquals("pal", person.getPersistentId().toString());

    assertEquals(1, person.getSources().size());
    attributedSourceReference = person.getSources().iterator().next();
    assertEquals("urn:source-reference-attribution", ((Attribution) attributedSourceReference.getExtensionElements().iterator().next()).getContributor().getResource().toString());
    assertEquals("urn:source-uri", attributedSourceReference.getResource().toString());
    assertEquals("source-reference-id", attributedSourceReference.getId());
    assertEquals(ResourceType.Collection, attributedSourceReference.getKnownType());

    assertEquals("pid", person.getId());
  }

}

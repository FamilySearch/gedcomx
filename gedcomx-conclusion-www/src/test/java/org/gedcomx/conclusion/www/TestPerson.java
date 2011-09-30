package org.gedcomx.conclusion.www;

import org.gedcomx.common.AlternateId;
import org.gedcomx.common.Attribution;
import org.gedcomx.common.ResourceSet;
import org.gedcomx.common.ResourceReference;
import org.gedcomx.conclusion.*;
import org.gedcomx.metadata.dc.DublinCoreDescription;
import org.gedcomx.types.*;
import org.gedcomx.www.Link;
import org.testng.annotations.Test;

import javax.xml.bind.JAXBContext;
import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
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
    person = processThroughXml(person, PersonWWW.class, JAXBContext.newInstance(PersonWWW.class, DublinCoreDescription.class));
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
    personWWW.setMetadata(new ResourceSet());
    return personWWW;
  }

  private Person createTestPerson() {
    Person person = new Person();
    Gender gender = new Gender();
    Link genderLink = new Link();
    genderLink.setHref(URI.create("urn:gender"));
    gender.addExtensionElement(genderLink);
    gender.setKnownType(GenderType.Male);
    person.setGenders(Arrays.asList(gender));

    Link personLink = new Link();
    personLink.setHref(URI.create("urn:person"));
    person.addExtensionElement(personLink);

    ArrayList<AlternateId> alternateIds = new ArrayList<AlternateId>();
    AlternateId alternateId = new AlternateId();
    alternateId.setKnownType(AlternateIdType.Forwarded);
    alternateId.setValue("forward-value");
    alternateIds.add(alternateId);
    person.setAlternateIds(alternateIds);

    List<Fact> facts = new ArrayList<Fact>();

    Fact fact = new Fact();
    Link characteristicLink = new Link();
    characteristicLink.setHref(URI.create("urn:characteristic"));
    fact.addExtensionElement(characteristicLink);
    fact.setAttribution(new Attribution());
    fact.getAttribution().setContributor(new ResourceReference());
    fact.getAttribution().getContributor().setResource(URI.create("urn:characteristic-attribution"));
    fact.setDate(new Date());
    fact.getDate().setOriginal("original date");
    fact.getDate().setNormalized("normalized date");
    fact.setId("characteristic-id");
    fact.setKnownType(FactType.Occupation);
    fact.setPlace(new Place());
    fact.getPlace().setOriginal("original place");
    fact.getPlace().setNormalized("normalized place");
    fact.setValue("characteristic-value");
    facts.add(fact);

    Fact event = new Fact();
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
    event.setKnownType(FactType.Adoption);
    event.setPlace(new Place());
    event.getPlace().setOriginal("original place");
    event.getPlace().setNormalized("normalized place");
    facts.add(event);
    
    person.setFacts(facts);

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
    Fact fact;
    Fact event;
    Name name;
    ResourceReference attributedSourceReference;
    assertEquals(GenderType.Male, person.getGenders().get(0).getKnownType());
    assertEquals("urn:gender", person.getGenders().get(0).findExtensionsOfType(Link.class).get(0).getHref().toString());

    assertEquals(1, person.findExtensionsOfType(Link.class).size());
    assertEquals("urn:person", person.findExtensionsOfType(Link.class).get(0).getHref().toString());

    assertEquals(1, person.getAlternateIds().size());
    assertEquals(AlternateIdType.Forwarded, person.getAlternateIds().get(0).getKnownType());
    assertEquals("forward-value", person.getAlternateIds().get(0).getValue());

    assertEquals(2, person.getFacts().size());
    assertEquals(1, person.getFacts().get(0).findExtensionsOfType(Link.class).size());
    fact = person.getFacts().get(0);
    assertEquals("urn:characteristic", fact.findExtensionsOfType(Link.class).get(0).getHref().toString());
    assertEquals("urn:characteristic-attribution", fact.getAttribution().getContributor().getResource().toString());
    assertEquals("original date", fact.getDate().getOriginal());
    assertEquals("normalized date", fact.getDate().getNormalized());
    assertEquals("characteristic-id", fact.getId());
    assertEquals(FactType.Occupation, fact.getKnownType());
    assertEquals("original place", fact.getPlace().getOriginal());
    assertEquals("normalized place", fact.getPlace().getNormalized());
    assertEquals("characteristic-value", fact.getValue());

    assertEquals(1, person.getFacts().get(1).findExtensionsOfType(Link.class).size());
    event = person.getFacts().get(1);
    assertEquals("urn:event", event.findExtensionsOfType(Link.class).get(0).getHref().toString());
    assertEquals("urn:event-attribution", event.getAttribution().getContributor().getResource().toString());
    assertEquals("original date", event.getDate().getOriginal());
    assertEquals("normalized date", event.getDate().getNormalized());
    assertEquals("event-id", event.getId());
    assertEquals(FactType.Adoption, event.getKnownType());
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

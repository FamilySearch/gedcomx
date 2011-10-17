package org.gedcomx.conclusion;

import org.gedcomx.common.Attribution;
import org.gedcomx.common.AlternateId;
import org.gedcomx.common.ResourceReference;
import org.gedcomx.types.*;
import org.testng.annotations.Test;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
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
  public void testPersonXml() throws Exception {
    Person person = createTestPerson();
    person = processThroughXml(person);
    assertTestPerson(person);
  }

  /**
   * tests processing a WWW person through json...
   */
  public void testPersonJson() throws Exception {
    Person person = createTestPerson();
    person = processThroughJson(person);
    assertTestPerson(person);
  }

  private Person createTestPerson() {
    Person person = new Person();
    Gender gender = new Gender();
    gender.setKnownType(GenderType.Male);
    person.setGenders(Arrays.asList(gender));

    ArrayList<AlternateId> alternateIds = new ArrayList<AlternateId>();
    AlternateId alternateId = new AlternateId();
    alternateId.setKnownType(AlternateIdType.Forwarded);
    alternateId.setValue("forward-value");
    alternateIds.add(alternateId);
    person.setAlternateIds(alternateIds);

    List<Fact> facts = new ArrayList<Fact>();

    Fact fact = new Fact();
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
    event.setSources(new ArrayList<ResourceReference>());
    ResourceReference eventSource = new ResourceReference();
    eventSource.setId("event-source");
    event.getSources().add(eventSource);
    facts.add(event);

    person.setFacts(facts);

    List<Name> names = new ArrayList<Name>();
    Name name = new Name();
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
    attribution.setContributor(new ResourceReference());
    attribution.getContributor().setResource(URI.create("urn:source-reference-attribution"));
    attributedSourceReference.setExtensionElements(new ArrayList<Object>());
    attributedSourceReference.getExtensionElements().add(attribution);
    attributedSourceReference.setResource(URI.create("urn:source-uri"));
    attributedSourceReference.setId("source-reference-id");
    attributedSourceReference.setKnownType(ResourceType.Collection);
    sources.add(attributedSourceReference);
    person.setSources(sources);

    person.setId("pid");
    person.setBibliographicCitation("person bibliographic citation");
    person.setAttribution(new Attribution());
    person.getAttribution().setProofStatement("this person existed.");
    return person;
  }

  private void assertTestPerson(Person person) {
    Fact fact;
    Fact event;
    Name name;
    ResourceReference attributedSourceReference;
    assertEquals(GenderType.Male, person.getGenders().get(0).getKnownType());

    assertEquals(1, person.getAlternateIds().size());
    assertEquals(AlternateIdType.Forwarded, person.getAlternateIds().get(0).getKnownType());
    assertEquals("forward-value", person.getAlternateIds().get(0).getValue());

    assertEquals(2, person.getFacts().size());
    fact = person.getFacts().get(0);
    assertEquals("urn:characteristic-attribution", fact.getAttribution().getContributor().getResource().toString());
    assertEquals("original date", fact.getDate().getOriginal());
    assertEquals("normalized date", fact.getDate().getNormalized());
    assertEquals("characteristic-id", fact.getId());
    assertEquals(FactType.Occupation, fact.getKnownType());
    assertEquals("original place", fact.getPlace().getOriginal());
    assertEquals("normalized place", fact.getPlace().getNormalized());
    assertEquals("characteristic-value", fact.getValue());

    event = person.getFacts().get(1);
    assertEquals("urn:event-attribution", event.getAttribution().getContributor().getResource().toString());
    assertEquals("original date", event.getDate().getOriginal());
    assertEquals("normalized date", event.getDate().getNormalized());
    assertEquals("event-id", event.getId());
    assertEquals(FactType.Adoption, event.getKnownType());
    assertEquals("original place", event.getPlace().getOriginal());
    assertEquals("normalized place", event.getPlace().getNormalized());
    assertEquals("event-source", event.getSources().get(0).getId());

    assertEquals(1, person.getNames().size());
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
    assertEquals("person bibliographic citation", person.getBibliographicCitation());
    assertEquals("this person existed.", person.getAttribution().getProofStatement());
  }

}

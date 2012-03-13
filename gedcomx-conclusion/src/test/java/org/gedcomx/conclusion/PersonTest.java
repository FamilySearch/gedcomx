package org.gedcomx.conclusion;

import org.gedcomx.common.Attribution;
import org.gedcomx.common.AlternateId;
import org.gedcomx.common.FormalValue;
import org.gedcomx.common.ResourceReference;
import org.gedcomx.types.*;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import org.gedcomx.common.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.gedcomx.rt.SerializationUtil.processThroughJson;
import static org.gedcomx.rt.SerializationUtil.processThroughXml;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

/**
 * @author Ryan Heaton
 */
@Test
public class PersonTest {

  /**
   * tests processing a WWW person through xml...
   */
  static public void testPersonXml() throws Exception {
    Person person = create();
    person = processThroughXml(person);
    assertEquals(person);
  }

  /**
   * tests processing a WWW person through json...
   */
  static public void testPersonJson() throws Exception {
    Person person = create();
    person = processThroughJson(person);
    assertEquals(person);
  }

  static Person create() {
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
    fact.getAttribution().getContributor().setResource(URI.create("urn:fact-attribution"));
    fact.setDate(new Date());
    fact.getDate().setOriginal("original date");
    FormalValue normalized = new FormalValue();
    normalized.setText("normalized date");
    normalized.setDatatype(URI.create("urn:date"));
    normalized.setKnownValue(DatePartType.Years);
    fact.getDate().setFormal(normalized);
    fact.setId("fact-id");
    fact.setKnownType(FactType.Occupation);
    fact.setPlace(new Place());
    fact.getPlace().setOriginal("original place");
    normalized = new FormalValue();
    normalized.setText("normalized place");
    normalized.setDatatype(URI.create("urn:place"));
    normalized.setKnownValue(PlacePartType.Cemetery);
    fact.getPlace().setFormal(normalized);
    fact.setOriginal("fact-value");
    facts.add(fact);

    Fact event = new Fact();
    event.setAttribution(new Attribution());
    event.getAttribution().setContributor(new ResourceReference());
    event.getAttribution().getContributor().setResource(URI.create("urn:event-attribution"));
    event.setDate(new Date());
    event.getDate().setOriginal("original date");
    normalized = new FormalValue();
    normalized.setText("normalized date");
    normalized.setDatatype(URI.create("urn:date"));
    normalized.setKnownValue(DatePartType.Years);
    event.getDate().setFormal(normalized);
    event.setId("event-id");
    event.setKnownType(FactType.Adoption);
    event.setPlace(new Place());
    event.getPlace().setOriginal("original place");
    normalized = new FormalValue();
    normalized.setText("normalized place");
    normalized.setDatatype(URI.create("urn:place"));
    normalized.setKnownValue(PlacePartType.Cemetery);
    event.getPlace().setFormal(normalized);
    event.setSources(new ArrayList<ResourceReference>());
    ResourceReference eventSource = new ResourceReference();
    eventSource.setId("event-source");
    event.getSources().add(eventSource);
    facts.add(event);

    person.setFacts(facts);

    List<Name> names = new ArrayList<Name>();
    Name name = new Name();
    name.setPreferred(true);
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

    person.setLiving(true);

    return person;
  }

  static void assertEquals(Person person) {
    Fact fact;
    Fact event;
    Name name;
    ResourceReference attributedSourceReference;
    AssertJUnit.assertEquals(GenderType.Male, person.getGenders().get(0).getKnownType());

    AssertJUnit.assertEquals(1, person.getAlternateIds().size());
    AssertJUnit.assertEquals(AlternateIdType.Forwarded, person.getAlternateIds().get(0).getKnownType());
    AssertJUnit.assertEquals("forward-value", person.getAlternateIds().get(0).getValue());

    AssertJUnit.assertEquals(2, person.getFacts().size());
    fact = person.getFacts().get(0);
    AssertJUnit.assertEquals("urn:fact-attribution", fact.getAttribution().getContributor().getResource().toString());
    AssertJUnit.assertEquals("original date", fact.getDate().getOriginal());
    AssertJUnit.assertEquals("normalized date", fact.getDate().getFormal().getText());
    AssertJUnit.assertEquals(DatePartType.Years, fact.getDate().getFormal().getKnownValue(DatePartType.class));
    AssertJUnit.assertEquals("urn:date", fact.getDate().getFormal().getDatatype().toString());
    AssertJUnit.assertEquals("fact-id", fact.getId());
    AssertJUnit.assertEquals(FactType.Occupation, fact.getKnownType());
    AssertJUnit.assertEquals("original place", fact.getPlace().getOriginal());
    AssertJUnit.assertEquals("normalized place", fact.getPlace().getFormal().getText());
    AssertJUnit.assertEquals(PlacePartType.Cemetery, fact.getPlace().getFormal().getKnownValue(PlacePartType.class));
    AssertJUnit.assertEquals("urn:date", fact.getDate().getFormal().getDatatype().toString());
    AssertJUnit.assertEquals("fact-value", fact.getOriginal());

    event = person.getFacts().get(1);
    AssertJUnit.assertEquals("urn:event-attribution", event.getAttribution().getContributor().getResource().toString());
    AssertJUnit.assertEquals("original date", event.getDate().getOriginal());
    AssertJUnit.assertEquals("normalized date", event.getDate().getFormal().getText());
    AssertJUnit.assertEquals(DatePartType.Years, event.getDate().getFormal().getKnownValue(DatePartType.class));
    AssertJUnit.assertEquals("urn:date", event.getDate().getFormal().getDatatype().toString());
    AssertJUnit.assertEquals("event-id", event.getId());
    AssertJUnit.assertEquals(FactType.Adoption, event.getKnownType());
    AssertJUnit.assertEquals("original place", event.getPlace().getOriginal());
    AssertJUnit.assertEquals("normalized place", event.getPlace().getFormal().getText());
    AssertJUnit.assertEquals(PlacePartType.Cemetery, event.getPlace().getFormal().getKnownValue(PlacePartType.class));
    AssertJUnit.assertEquals("urn:date", event.getDate().getFormal().getDatatype().toString());

    AssertJUnit.assertEquals(1, person.getNames().size());
    name = person.getNames().iterator().next();
    assertTrue(name.getPreferred());
    AssertJUnit.assertEquals(1, name.getAlternateForms().size());
    AssertJUnit.assertEquals("alternate name form", name.getAlternateForms().get(0).getFullText());
    AssertJUnit.assertEquals(1, name.getAlternateForms().get(0).getParts().size());
    AssertJUnit.assertEquals("alternate name part", name.getAlternateForms().get(0).getParts().get(0).getText());
    AssertJUnit.assertEquals(NamePartType.Given, name.getAlternateForms().get(0).getParts().get(0).getKnownType());
    AssertJUnit.assertEquals("urn:name-attribution", name.getAttribution().getContributor().getResource().toString());
    AssertJUnit.assertEquals("name-id", name.getId());
    AssertJUnit.assertEquals(NameType.Formal, name.getKnownType());
    AssertJUnit.assertEquals("primary form", name.getPrimaryForm().getFullText());
    AssertJUnit.assertEquals(1, name.getPrimaryForm().getParts().size());
    AssertJUnit.assertEquals("primary surname", name.getPrimaryForm().getParts().get(0).getText());
    AssertJUnit.assertEquals(NamePartType.Surname, name.getPrimaryForm().getParts().get(0).getKnownType());

    AssertJUnit.assertEquals("pal", person.getPersistentId().toString());

    AssertJUnit.assertEquals(1, person.getSources().size());
    attributedSourceReference = person.getSources().iterator().next();
    AssertJUnit.assertEquals("urn:source-reference-attribution", ((Attribution) attributedSourceReference.getExtensionElements().iterator().next()).getContributor().getResource().toString());
    AssertJUnit.assertEquals("urn:source-uri", attributedSourceReference.getResource().toString());
    AssertJUnit.assertEquals("source-reference-id", attributedSourceReference.getId());
    AssertJUnit.assertEquals(ResourceType.Collection, attributedSourceReference.getKnownType());

    AssertJUnit.assertEquals("pid", person.getId());
    AssertJUnit.assertEquals("person bibliographic citation", person.getBibliographicCitation());
    AssertJUnit.assertEquals("this person existed.", person.getAttribution().getProofStatement());

    assertTrue(person.getLiving());
  }

}

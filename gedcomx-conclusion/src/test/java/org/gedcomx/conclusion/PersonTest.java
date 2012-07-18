package org.gedcomx.conclusion;

import org.gedcomx.common.*;
import org.gedcomx.types.*;
import org.testng.annotations.Test;

import java.util.ArrayList;
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
    assertPersonEquals(person);
  }

  /**
   * tests processing a WWW person through json...
   */
  static public void testPersonJson() throws Exception {
    Person person = create();
    person = processThroughJson(person);
    assertPersonEquals(person);
  }

  static Person create() {
    Person person = new Person();
    person.setGender(new Gender(GenderType.Male));

    ArrayList<Identifier> identifiers = new ArrayList<Identifier>();
    Identifier identifier = new Identifier();
    identifier.setKnownType(IdentifierType.Forwarded);
    identifier.setValue("forward-value");
    identifiers.add(identifier);
    identifier = new Identifier();
    identifier.setKnownType(IdentifierType.Primary);
    identifier.setValue("pal");
    identifiers.add(identifier);
    person.setIdentifiers(identifiers);

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
    person.addFact(fact);

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
    event.setSources(new ArrayList<SourceReference>());
    SourceReference eventSource = new SourceReference();
    eventSource.setId("event-source");
    eventSource.setAttribution(new Attribution());
    event.getSources().add(eventSource);

    List<Fact> facts = person.getFacts();
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

    ArrayList<SourceReference> sources = new ArrayList<SourceReference>();
    SourceReference attributedSourceReference = new SourceReference();
    Attribution attribution = new Attribution();
    attribution.setContributor(new ResourceReference());
    attribution.getContributor().setResource(URI.create("urn:source-reference-attribution"));
    attributedSourceReference.setAttribution(attribution);
    attributedSourceReference.setId("source-reference-id");
    attributedSourceReference.setKnownType(SourceReferenceType.WorkingConclusion);
    attributedSourceReference.setSourceDescription(new ResourceReference());
    attributedSourceReference.getSourceDescription().setResource(URI.create("urn:source-description"));
    sources.add(attributedSourceReference);
    person.setSources(sources);

    person.setId("pid");
    person.setAttribution(new Attribution());
    person.getAttribution().setChangeMessage("this person existed.");

    person.setLiving(true);

    return person;
  }

  static void assertPersonEquals(Person person) {
    Fact fact;
    Fact event;
    Name name;
    SourceReference attributedSourceReference;
    assertEquals(GenderType.Male, person.getGender().getKnownType());

    assertEquals(2, person.getIdentifiers().size());
    assertEquals(IdentifierType.Forwarded, person.getIdentifiers().get(0).getKnownType());
    assertEquals("forward-value", person.getIdentifiers().get(0).getValue());
    assertEquals(IdentifierType.Primary, person.getIdentifiers().get(1).getKnownType());
    assertEquals("pal", person.getIdentifiers().get(1).getValue());

    assertEquals(2, person.getFacts().size());
    fact = person.getFirstFactOfType(FactType.Occupation);
    assertEquals("urn:fact-attribution", fact.getAttribution().getContributor().getResource().toString());
    assertEquals("original date", fact.getDate().getOriginal());
    assertEquals("normalized date", fact.getDate().getFormal().getText());
    assertEquals(DatePartType.Years, fact.getDate().getFormal().getKnownValue(DatePartType.class));
    assertEquals("urn:date", fact.getDate().getFormal().getDatatype().toString());
    assertEquals("fact-id", fact.getId());
    assertEquals(FactType.Occupation, fact.getKnownType());
    assertEquals("original place", fact.getPlace().getOriginal());
    assertEquals("normalized place", fact.getPlace().getFormal().getText());
    assertEquals(PlacePartType.Cemetery, fact.getPlace().getFormal().getKnownValue(PlacePartType.class));
    assertEquals("urn:date", fact.getDate().getFormal().getDatatype().toString());
    assertEquals("fact-value", fact.getOriginal());

    event = person.getFirstFactOfType(FactType.Adoption);
    assertEquals("urn:event-attribution", event.getAttribution().getContributor().getResource().toString());
    assertEquals("original date", event.getDate().getOriginal());
    assertEquals("normalized date", event.getDate().getFormal().getText());
    assertEquals(DatePartType.Years, event.getDate().getFormal().getKnownValue(DatePartType.class));
    assertEquals("urn:date", event.getDate().getFormal().getDatatype().toString());
    assertEquals("event-id", event.getId());
    assertEquals(FactType.Adoption, event.getKnownType());
    assertEquals("original place", event.getPlace().getOriginal());
    assertEquals("normalized place", event.getPlace().getFormal().getText());
    assertEquals(PlacePartType.Cemetery, event.getPlace().getFormal().getKnownValue(PlacePartType.class));
    assertEquals("urn:date", event.getDate().getFormal().getDatatype().toString());

    assertEquals(1, person.getNames().size());
    name = person.getNames().iterator().next();
    assertTrue(name.getPreferred());
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
    assertEquals("urn:source-reference-attribution", attributedSourceReference.getAttribution().getContributor().getResource().toString());
    assertEquals("source-reference-id", attributedSourceReference.getId());
    assertEquals(SourceReferenceType.WorkingConclusion, attributedSourceReference.getKnownType());
    assertEquals("urn:source-description", attributedSourceReference.getSourceDescription().getResource().toString());

    assertEquals("pid", person.getId());
    assertEquals("this person existed.", person.getAttribution().getChangeMessage());

    assertTrue(person.getLiving());
  }

}

package org.gedcomx.conclusion;

import org.gedcomx.common.*;
import org.gedcomx.source.SourceReference;
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
    identifier.setKnownType(IdentifierType.Deprecated);
    identifier.setValue(URI.create("forward-value"));
    identifiers.add(identifier);
    identifier = new Identifier();
    identifier.setKnownType(IdentifierType.Persistent);
    identifier.setValue(URI.create("pal"));
    identifiers.add(identifier);
    person.setIdentifiers(identifiers);

    Fact fact = new Fact();
    fact.setKnownConfidenceLevel(ConfidenceLevel.Certainly);
    fact.setDate(new Date());
    fact.getDate().setOriginal("original date");
    fact.getDate().setFormal("normalized date");
    fact.setId("fact-id");
    fact.setKnownType(FactType.Occupation);
    fact.setPlace(new Place());
    fact.getPlace().setOriginal("original place");
    fact.getPlace().setNormalized("normalized place");
    // TODO - support the place type concept
    //fact.getPlace().setKnownValue(PlacePartType.Cemetery);
    fact.getPlace().setResource(URI.create("urn:place"));
    fact.setValue("fact-value");
    person.addFact(fact);

    Fact event = new Fact();
    event.setDate(new Date());
    event.getDate().setOriginal("original date");
    event.getDate().setFormal("normalized date");
    event.setId("event-id");
    event.setKnownType(FactType.Adoption);
    event.setPlace(new Place());
    event.getPlace().setOriginal("original place");
    event.getPlace().setNormalized("normalized place");
    // TODO - support the place type concept
    //event.getPlace().setKnownValue(PlacePartType.Cemetery);
    event.getPlace().setResource(URI.create("urn:place"));
    event.setSources(new ArrayList<SourceReference>());
    SourceReference eventSource = new SourceReference();
    eventSource.setDescriptionRef(URI.create("urn:event-source"));
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
    part.setValue("alternate name part");
    parts.add(part);
    nameForm.setParts(parts);
    alternateForms.add(nameForm);
    name.setAlternateForms(alternateForms);
    name.setId("name-id");
    name.setKnownType(NameType.Formal);
    NameForm primaryForm = new NameForm();
    primaryForm.setFullText("primary form");
    primaryForm.setParts(new ArrayList<NamePart>());
    NamePart namePart = new NamePart();
    namePart.setKnownType(NamePartType.Surname);
    namePart.setValue("primary surname");
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
    attributedSourceReference.setDescriptionRef(URI.create("urn:source-description"));
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
    SourceReference sr;
    assertEquals(GenderType.Male, person.getGender().getKnownType());

    assertEquals(2, person.getIdentifiers().size());
    assertEquals(IdentifierType.Deprecated, person.getIdentifiers().get(0).getKnownType());
    assertEquals("forward-value", person.getIdentifiers().get(0).getValue().toString());
    assertEquals(IdentifierType.Persistent, person.getIdentifiers().get(1).getKnownType());
    assertEquals("pal", person.getIdentifiers().get(1).getValue().toString());

    assertEquals(2, person.getFacts().size());
    fact = person.getFirstFactOfType(FactType.Occupation);
    assertEquals(ConfidenceLevel.Certainly, fact.getKnownConfidenceLevel());
    assertEquals("original date", fact.getDate().getOriginal());
    assertEquals("normalized date", fact.getDate().getFormal());
    assertEquals("fact-id", fact.getId());
    assertEquals(FactType.Occupation, fact.getKnownType());
    assertEquals("original place", fact.getPlace().getOriginal());
    assertEquals("normalized place", fact.getPlace().getNormalized());
    assertEquals("urn:place", fact.getPlace().getResource().toString());
    // TODO - allow check when the functionality is provided
    //assertEquals(PlacePartType.Cemetery, fact.getPlace().getKnownValue(PlacePartType.class));
    assertEquals("fact-value", fact.getValue());

    event = person.getFirstFactOfType(FactType.Adoption);
    assertEquals("original date", event.getDate().getOriginal());
    assertEquals("normalized date", event.getDate().getFormal());
    assertEquals("event-id", event.getId());
    assertEquals(FactType.Adoption, event.getKnownType());
    assertEquals("original place", event.getPlace().getOriginal());
    assertEquals("normalized place", event.getPlace().getNormalized());
    // TODO - allow check when the functionality is provided
    //assertEquals(PlacePartType.Cemetery, event.getPlace().getKnownValue(PlacePartType.class));
    assertEquals("urn:place", event.getPlace().getResource().toString());

    assertEquals(1, person.getNames().size());
    name = person.getNames().iterator().next();
    assertTrue(name.getPreferred());
    assertEquals(1, name.getAlternateForms().size());
    assertEquals("alternate name form", name.getAlternateForms().get(0).getFullText());
    assertEquals(1, name.getAlternateForms().get(0).getParts().size());
    assertEquals("alternate name part", name.getAlternateForms().get(0).getParts().get(0).getValue());
    assertEquals(NamePartType.Given, name.getAlternateForms().get(0).getParts().get(0).getKnownType());
    assertEquals("name-id", name.getId());
    assertEquals(NameType.Formal, name.getKnownType());
    assertEquals("primary form", name.getPrimaryForm().getFullText());
    assertEquals(1, name.getPrimaryForm().getParts().size());
    assertEquals("primary surname", name.getPrimaryForm().getParts().get(0).getValue());
    assertEquals(NamePartType.Surname, name.getPrimaryForm().getParts().get(0).getKnownType());

    assertEquals("pal", person.getPersistentId().toString());

    assertEquals(1, person.getSources().size());
    sr = person.getSources().iterator().next();
    assertEquals("urn:source-reference-attribution", sr.getAttribution().getContributor().getResource().toString());
    assertEquals("urn:source-description", sr.getDescriptionRef().toString());

    assertEquals("pid", person.getId());
    assertEquals("this person existed.", person.getAttribution().getChangeMessage());

    assertTrue(person.getLiving());
  }

}

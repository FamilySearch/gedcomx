package org.gedcomx.record;

import org.gedcomx.common.Attribution;
import org.gedcomx.common.AlternateId;
import org.gedcomx.common.FormalValue;
import org.gedcomx.common.ResourceReference;
import org.gedcomx.types.*;
import org.testng.annotations.Test;

import org.gedcomx.common.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

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
    alternateId.setKnownType(AlternateIdType.Forwarded);
    alternateId.setValue("forward-value");
    alternateIds.add(alternateId);
    record.setAlternateIds(alternateIds);

    List<Fact> facts = new ArrayList<Fact>();
    Fact fact = new Fact();
    fact.setDate(new Date());
    fillInField(fact.getDate(), "event-date");
    fact.getDate().setParts(new ArrayList<DatePart>());
    DatePart datePart = new DatePart();
    fillInField(datePart, "event-date-part");
    datePart.setKnownType(DatePartType.Months);
    fact.getDate().getParts().add(datePart);
    fact.setId("event-id");
    fact.setKnownType(FactType.Adoption);
    fact.setPlace(new Place());
    fillInField(fact.getPlace(), "event-place");
    fact.getPlace().setParts(new ArrayList<PlacePart>());
    PlacePart placePart = new PlacePart();
    fillInField(placePart, "event-place-part");
    placePart.setKnownType(PlacePartType.Cemetery);
    fact.getPlace().getParts().add(placePart);
    fact.setPrimary(true);
    facts.add(fact);
    record.setFacts(facts);

    Persona persona = new Persona();
    facts = new ArrayList<Fact>();
    fact = new Fact();
    fillInField(fact, "fact");
    fact.setKnownType(FactType.Occupation);
    facts.add(fact);
    persona.setFacts(facts);

    List<Name> names = new ArrayList<Name>();
    Name name = new Name();
    fillInField(name, "name");
    name.setKnownType(NameType.Formal);

    ArrayList<NamePart> nameParts = new ArrayList<NamePart>();
    NamePart namePart = new NamePart();
    namePart.setKnownType(NamePartType.Surname);
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
    agePart.setKnownType(AgePartType.Days);
    ageParts.add(agePart);
    age.setParts(ageParts);
    persona.setAge(age);

    persona.setAlternateIds(alternateIds);
    persona.setAttribution(new Attribution());
    persona.getAttribution().setProofStatement("this persona exists.");

    Gender gender = new Gender();
    fillInField(gender, "gender");
    gender.setKnownType(GenderType.Female);
    persona.setGender(gender);

    persona.setId("persona-id");
    persona.setPersistentId(URI.create("urn:persona-id-value"));
    persona.setPrincipal(true);

    record.setPersonas(Arrays.asList(persona));

    record.setPersistentId(URI.create("pal"));

    ArrayList<Relationship> relationships = new ArrayList<Relationship>();
    Relationship coupleRelationship = new Relationship();
    coupleRelationship.setKnownType(RelationshipType.Couple);
    ArrayList<Fact> coupleFacts = new ArrayList<Fact>();
    Fact coupleFact = new Fact();
    fillInField(coupleFact, "couple-fact");
    coupleFact.setKnownType(FactType.Couple.CommonLawMarriage);
    coupleFacts.add(coupleFact);
    coupleRelationship.setFacts(coupleFacts);
    coupleRelationship.setId("couple-relationship-id");
    coupleRelationship.setPersona1(new ResourceReference());
    coupleRelationship.getPersona1().setResource(URI.create("#" + persona.getId()));
    coupleRelationship.setPersona2(new ResourceReference());
    coupleRelationship.getPersona2().setResource(URI.create("#" + persona.getId()));
    relationships.add(coupleRelationship);
    Relationship parentRelationship = new Relationship();
    parentRelationship.setKnownType(RelationshipType.ParentChild);
    parentRelationship.setId("parent-relationship-id");
    parentRelationship.setPersona1(new ResourceReference());
    parentRelationship.getPersona1().setResource(URI.create("#" + persona.getId()));
    parentRelationship.setPersona2(new ResourceReference());
    parentRelationship.getPersona2().setResource(URI.create("#" + persona.getId()));
    parentRelationship.setAttribution(new Attribution());
    parentRelationship.getAttribution().setProofStatement("relationship explanation");
    relationships.add(parentRelationship);

    record.setRelationships(relationships);

    ArrayList<ResourceReference> sources = new ArrayList<ResourceReference>();
    ResourceReference sourceReference = new ResourceReference();
    sourceReference.setResource(URI.create("urn:source-uri"));
    sourceReference.setId("source-reference-id");
    sourceReference.setKnownType(ResourceType.Collection);
    sources.add(sourceReference);
    record.setSources(sources);

    record.setBibliographicCitation("bibliographic citation");

    record.setId("rid");
    record.setLang(Locale.ENGLISH.getLanguage());
    return record;
  }

  private void fillInField(Field field, String label) {
    field.setAttribution(new Attribution());
    field.getAttribution().setContributor(new ResourceReference());
    field.getAttribution().getContributor().setResource(URI.create("urn:" + label + "-attribution"));
    field.setLabel(label + "-field-id");
    field.setId(label + "-id");
    field.setOriginal(label + "-original");
    field.setInterpreted(label + "-interpreted");
    field.setProcessed(new FormalValue());
    field.getProcessed().setText(label + "-normalized");
  }

  private void assertField(Field field, String label) {
    assertEquals("urn:" + label + "-attribution", field.getAttribution().getContributor().getResource().toString());
    assertEquals(label + "-field-id", field.getLabel());
    assertEquals(label + "-id", field.getId());
    assertEquals(label + "-original", field.getOriginal());
    assertEquals(label + "-interpreted", field.getInterpreted());
    assertEquals(label + "-normalized", field.getProcessed().getText());
  }

  private void assertTestRecord(Record record) {
    assertEquals(1, record.getAlternateIds().size());
    assertEquals(AlternateIdType.Forwarded, record.getAlternateIds().get(0).getKnownType());
    assertEquals("forward-value", record.getAlternateIds().get(0).getValue());

    assertEquals(1, record.getFacts().size());
    Fact fact = record.getFacts().get(0);
    assertField(fact.getDate(), "event-date");
    assertEquals("event-id", fact.getId());
    assertEquals(FactType.Adoption, fact.getKnownType());
    assertField(fact.getPlace(), "event-place");
    assertTrue(fact.getPrimary());
    assertEquals(1, fact.getDate().getParts().size());
    assertField(fact.getDate().getParts().get(0), "event-date-part");
    assertEquals(DatePartType.Months, fact.getDate().getParts().get(0).getKnownType());
    assertEquals(1, fact.getPlace().getParts().size());
    assertField(fact.getPlace().getParts().get(0), "event-place-part");
    assertEquals(PlacePartType.Cemetery, fact.getPlace().getParts().get(0).getKnownType());
    assertEquals("", fact.toString());
    assertEquals("event-date-normalized", fact.getDate().toString());
    assertEquals("event-place-normalized", fact.getPlace().toString());

    assertEquals(1, record.getPersonas().size());
    Persona persona = record.getPersonas().get(0);
    assertEquals(1, persona.getFacts().size());
    assertField(persona.getFacts().get(0), "fact");
    assertEquals(FactType.Occupation, persona.getFacts().get(0).getKnownType());
    assertEquals("persona-id: name-normalized", persona.toString());

    assertEquals(1, persona.getNames().size());
    Name name = persona.getNames().get(0);
    assertField(name, "name");
    assertEquals(NameType.Formal, name.getKnownType());
    assertEquals("name-normalized", name.toString());

    assertEquals(1, name.getParts().size());
    NamePart namePart = name.getParts().get(0);
    namePart.setKnownType(NamePartType.Surname);
    assertField(namePart, "name-part");
    assertEquals("name-part-normalized", namePart.toString());

    assertField(persona.getAge(), "age");
    assertEquals("age-normalized", persona.getAge().toString());
    assertEquals(1, persona.getAge().getParts().size());
    AgePart agePart = persona.getAge().getParts().get(0);
    assertField(agePart, "age-part");
    assertEquals(AgePartType.Days, agePart.getKnownType());
    assertEquals("age-part-normalized", agePart.toString());

    assertEquals(1, persona.getAlternateIds().size());
    assertEquals(AlternateIdType.Forwarded, persona.getAlternateIds().get(0).getKnownType());
    assertEquals("forward-value", persona.getAlternateIds().get(0).getValue());
    assertEquals("forward-value", persona.getAlternateIds().get(0).toString());

    assertEquals("this persona exists.", persona.getAttribution().getProofStatement());

    assertField(persona.getGender(), "gender");
    assertEquals(GenderType.Female, persona.getGender().getKnownType());
    assertEquals("gender-normalized", persona.getGender().toString());

    assertEquals("persona-id", persona.getId());
    assertEquals("urn:persona-id-value", persona.getPersistentId().toString());
    assertTrue(persona.getPrincipal());

    assertEquals("pal", record.getPersistentId().toString());
    assertEquals("bibliographic citation", record.getBibliographicCitation());

    assertEquals(2, record.getRelationships().size());
    Relationship coupleRelationship = record.getRelationships().get(0);
    assertEquals(RelationshipType.Couple, coupleRelationship.getKnownType());
    assertEquals(1, coupleRelationship.getFacts().size());
    Fact coupleFact = coupleRelationship.getFacts().get(0);
    assertField(coupleFact, "couple-fact");
    assertEquals(FactType.Couple.CommonLawMarriage, coupleFact.getKnownType());
    assertEquals("couple-relationship-id", coupleRelationship.getId());
    assertEquals("#" + persona.getId(), coupleRelationship.getPersona1().getResource().toString());
    assertEquals("#" + persona.getId(), coupleRelationship.getPersona2().getResource().toString());
    assertEquals("Couple couple-relationship-id: #persona-id - #persona-id", coupleRelationship.toString());

    Relationship parentRelationship = record.getRelationships().get(1);
    assertEquals(RelationshipType.ParentChild, parentRelationship.getKnownType());
    assertEquals("parent-relationship-id", parentRelationship.getId());
    assertEquals("#" + persona.getId(), parentRelationship.getPersona1().getResource().toString());
    assertEquals("#" + persona.getId(), parentRelationship.getPersona2().getResource().toString());
    assertEquals("relationship explanation", parentRelationship.getAttribution().getProofStatement());
    assertEquals("ParentChild parent-relationship-id: #persona-id - #persona-id", parentRelationship.toString());

    assertEquals(1, record.getSources().size());
    ResourceReference sourceReference = record.getSources().get(0);
    assertEquals("urn:source-uri", sourceReference.getResource().toString());
    assertEquals("urn:source-uri", sourceReference.toString());
    assertEquals("source-reference-id", sourceReference.getId());
    assertEquals(ResourceType.Collection, sourceReference.getKnownType());

    assertEquals("rid", record.getId());
    assertEquals("rid", record.toString());
    assertEquals(Locale.ENGLISH.getLanguage(), record.getLang());
  }

}

package org.gedcomx;

import org.gedcomx.common.*;
import org.gedcomx.conclusion.*;
import org.gedcomx.contributor.Agent;
import org.gedcomx.rt.SerializationUtil;
import org.gedcomx.source.SourceCitation;
import org.gedcomx.source.SourceDescription;
import org.gedcomx.source.SourceReference;
import org.gedcomx.types.FactType;
import org.gedcomx.types.GenderType;
import org.gedcomx.types.NamePartType;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Ryan Heaton
 */
@Test
public class GedcomxExamplesTest {

  public void testExample() throws Exception {
    Person george = createGeorge();
    Person martha = createMartha();
    Relationship marriage = createMarriage(george, martha);
    List<SourceDescription> sources = citeGeorgeMarthaAndMarriage(george, martha, marriage);
    Agent contributor = createContributor();
    Gedcomx gx = new Gedcomx();
    gx.setPersons(Arrays.asList(george, martha));
    gx.setRelationships(Arrays.asList(marriage));
    gx.setSourceDescriptions(sources);
    gx.setAttribution(new Attribution());
    gx.getAttribution().setContributor(new ResourceReference());
    gx.getAttribution().getContributor().setResource(URI.create("#" + contributor.getId()));

    SerializationUtil.processThroughXml(gx);
    SerializationUtil.processThroughJson(gx);
  }

  private Agent createContributor() {
    Agent agent = new Agent();
    agent.setId("GGG-GGGG");
    agent.setNames(Arrays.asList(new TextValue("Ryan Heaton")));
    return agent;
  }

  private Person createGeorge() {
    Person person = new Person();
    person.setGender(new Gender(GenderType.Male));

    Fact fact = new Fact();
    fact.setId("123");
    fact.setKnownType(FactType.Birth);

    fact.setDate(new Date());
    fact.getDate().setOriginal("February 22, 1732");
    fact.getDate().setFormal("+1732-02-22");

    fact.setPlace(new Place());
    fact.getPlace().setOriginal("Pope's Creek, Westmoreland, Virginia, United States");
    fact.getPlace().setNormalized("Pope's Creek, Westmoreland, Virginia, United States");

    person.addFact(fact);

    fact = new Fact();
    fact.setId("456");
    fact.setKnownType(FactType.Death);

    fact.setDate(new Date());
    fact.getDate().setOriginal("December 14, 1799");
    fact.getDate().setFormal("+1799-12-14T22:00:00");

    fact.setPlace(new Place());
    fact.getPlace().setOriginal("Mount Vernon, Virginia");
    fact.getPlace().setNormalized("Mount Vernon, Fairfax County, Virginia, United States");

    person.addFact(fact);

    List<Name> names = new ArrayList<Name>();
    Name name = new Name();
    name.setPreferred(true);
    NameForm nameForm = new NameForm();
    nameForm.setFullText("George Washington");
    ArrayList<NamePart> parts = new ArrayList<NamePart>();
    NamePart part = new NamePart();
    part.setKnownType(NamePartType.Given);
    part.setValue("George");
    parts.add(part);
    part = new NamePart();
    part.setKnownType(NamePartType.Surname);
    part.setValue("Washington");
    parts.add(part);
    nameForm.setParts(parts);
    name.setNameForms(Arrays.asList(nameForm));
    name.setId("789");
    names.add(name);
    person.setNames(names);

    person.setId("BBB-BBBB");

    return person;
  }

  private Person createMartha() {
    Person person = new Person();
    person.setGender(new Gender(GenderType.Male));

    Fact fact = new Fact();
    fact.setId("321");
    fact.setKnownType(FactType.Birth);

    fact.setDate(new Date());
    fact.getDate().setOriginal("June 2, 1731");
    fact.getDate().setFormal("+1731-06-02");

    fact.setPlace(new Place());
    fact.getPlace().setOriginal("Chestnut Grove, Virginia");
    fact.getPlace().setNormalized("Chestnut Grove, New Kent, Virginia, United States");

    person.addFact(fact);

    fact = new Fact();
    fact.setId("654");
    fact.setKnownType(FactType.Death);

    fact.setDate(new Date());
    fact.getDate().setOriginal("May 22, 1802");
    fact.getDate().setFormal("+1802-05-22");

    fact.setPlace(new Place());
    fact.getPlace().setOriginal("Mount Vernon, Virginia");
    fact.getPlace().setNormalized("Mount Vernon, Fairfax County, Virginia, United States");

    person.addFact(fact);

    List<Name> names = new ArrayList<Name>();
    Name name = new Name();
    name.setPreferred(true);
    NameForm nameForm = new NameForm();
    nameForm.setFullText("Martha Dandridge Custis");
    ArrayList<NamePart> parts = new ArrayList<NamePart>();
    NamePart part = new NamePart();
    part.setKnownType(NamePartType.Given);
    part.setValue("Martha Dandridge");
    parts.add(part);
    part = new NamePart();
    part.setKnownType(NamePartType.Surname);
    part.setValue("Custis");
    parts.add(part);
    nameForm.setParts(parts);
    name.setNameForms(Arrays.asList(nameForm));
    name.setId("987");
    names.add(name);
    person.setNames(names);

    person.setId("CCC-CCCC");

    return person;
  }

  private Relationship createMarriage(Person george, Person martha) {
    Relationship relationship = new Relationship();
    relationship.setId("DDD-DDDD");
    relationship.setPerson1(new ResourceReference(URI.create("#" + george.getId())));
    relationship.setPerson2(new ResourceReference(URI.create("#" + martha.getId())));
    Fact marriage = new Fact();
    marriage.setDate(new Date());
    marriage.getDate().setOriginal("January 6, 1759");
    marriage.getDate().setFormal("+01-06-1759");
    marriage.setPlace(new Place());
    marriage.getPlace().setOriginal("White House Plantation");
    relationship.setFacts(Arrays.asList(marriage));
    return relationship;
  }

  private List<SourceDescription> citeGeorgeMarthaAndMarriage(Person george, Person martha, Relationship relationship) {
    SourceDescription georgeSource = new SourceDescription();
    georgeSource.setId("EEE-EEEE");
    georgeSource.setAbout(URI.create("http://en.wikipedia.org/wiki/George_washington"));
    SourceCitation georgeCitation = new SourceCitation();
    georgeCitation.setValue("\"George Washington.\" Wikipedia, The Free Encyclopedia. Wikimedia Foundation, Inc. 24 October 2012.");
    georgeSource.setCitations(Arrays.asList(georgeCitation));

    SourceDescription marthaSource = new SourceDescription();
    marthaSource.setId("FFF-FFFF");
    marthaSource.setAbout(URI.create("http://en.wikipedia.org/wiki/Martha_washington"));
    SourceCitation marthaCitation = new SourceCitation();
    marthaCitation.setValue("\"Martha Washington.\" Wikipedia, The Free Encyclopedia. Wikimedia Foundation, Inc. 24 October 2012.");
    marthaSource.setCitations(Arrays.asList(marthaCitation));

    SourceReference reference = new SourceReference();
    reference.setDescriptionRef(URI.create("#" + georgeSource.getId()));
    george.setSources(Arrays.asList(reference));

    reference = new SourceReference();
    reference.setDescriptionRef(URI.create("#" + marthaSource.getId()));
    martha.setSources(Arrays.asList(reference));

    relationship.setSources(Arrays.asList(reference));

    return Arrays.asList(georgeSource, marthaSource);
  }


}

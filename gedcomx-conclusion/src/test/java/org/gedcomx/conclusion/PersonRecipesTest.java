package org.gedcomx.conclusion;

import org.gedcomx.common.Attribution;
import org.gedcomx.common.FormalValue;
import org.gedcomx.common.ResourceReference;
import org.gedcomx.common.URI;
import org.gedcomx.test.RecipeTest;
import org.gedcomx.test.Snippet;
import org.gedcomx.types.FactType;
import org.gedcomx.types.GenderType;
import org.gedcomx.types.NamePartType;
import org.gedcomx.types.ResourceType;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.gedcomx.rt.SerializationUtil.processThroughJson;
import static org.gedcomx.rt.SerializationUtil.processThroughXml;

/**
 * @author Ryan Heaton
 */
@Test
public class PersonRecipesTest extends RecipeTest {

  /**
   * tests processing a WWW person through xml...
   */
  public void testStandardPerson() throws Exception {
    createRecipe("Simple Person")
      .withDescription("Simple example for a person.")
      .applicableTo(Person.class);

    Person person = create();
    Snippet snippet = new Snippet();
    person = processThroughXml(person, snippet);
    person = processThroughJson(person, snippet);
    addSnippet(snippet);
//    assertEquals(person);
  }

  static Person create() {
    Person person = new Person();
    person.setGender(new Gender(GenderType.Male));

    Fact fact = new Fact();
    fact.setId("123");
    fact.setKnownType(FactType.Birth);

    fact.setAttribution(new Attribution());
    fact.getAttribution().setContributor(new ResourceReference());
    fact.getAttribution().getContributor().setResource(URI.create("https://familysearch.org/platform/contributors/BCD-FGHJ"));
    fact.setDate(new Date());
    fact.getDate().setOriginal("February 22, 1732");
    FormalValue normalized = new FormalValue();
    normalized.setText("1732-02-22");
    normalized.setDatatype(URI.create("http://www.w3.org/2001/XMLSchema#date"));
    fact.getDate().setFormal(normalized);

    fact.setPlace(new Place());
    fact.getPlace().setOriginal("Pope's Creek, Westmoreland, Virginia");
    normalized = new FormalValue();
    normalized.setText("Pope's Creek, Westmoreland, Virginia");
    normalized.setResource(URI.create("https://familysearch.org/platform/places/12345"));
    fact.getPlace().setFormal(normalized);

    person.addFact(fact);

    fact = new Fact();
    fact.setId("456");
    fact.setKnownType(FactType.Death);

    fact.setAttribution(new Attribution());
    fact.getAttribution().setContributor(new ResourceReference());
    fact.getAttribution().getContributor().setResource(URI.create("https://familysearch.org/platform/contributors/KLM-NPQR"));
    fact.setDate(new Date());
    fact.getDate().setOriginal("December 14, 1799");
    normalized = new FormalValue();
    normalized.setText("1799-12-14T22:00:00");
    normalized.setDatatype(URI.create("http://www.w3.org/2001/XMLSchema#dateTime"));
    fact.getDate().setFormal(normalized);

    fact.setPlace(new Place());
    fact.getPlace().setOriginal("Mount Vernon, Virginia");
    normalized = new FormalValue();
    normalized.setText("Mount Vernon, Fairfax County, Virginia");
    normalized.setResource(URI.create("https://familysearch.org/platform/places/67890"));
    fact.getPlace().setFormal(normalized);

    person.addFact(fact);

    List<Name> names = new ArrayList<Name>();
    Name name = new Name();
    name.setPreferred(true);
    NameForm nameForm = new NameForm();
    nameForm.setFullText("George Washington");
    ArrayList<NamePart> parts = new ArrayList<NamePart>();
    NamePart part = new NamePart();
    part.setKnownType(NamePartType.Given);
    part.setText("George");
    parts.add(part);
    part = new NamePart();
    part.setKnownType(NamePartType.Surname);
    part.setText("Washington");
    parts.add(part);
    nameForm.setParts(parts);
    name.setPrimaryForm(nameForm);
    name.setAttribution(new Attribution());
    name.getAttribution().setContributor(new ResourceReference());
    name.getAttribution().getContributor().setResource(URI.create("https://familysearch.org/platform/contributors/STV-WXZY"));
    name.setId("789");
    names.add(name);
    person.setNames(names);

    ArrayList<SourceReference> sources = new ArrayList<SourceReference>();
    SourceReference attributedSourceReference = new SourceReference();
    Attribution attribution = new Attribution();
    attribution.setContributor(new ResourceReference());
    attribution.getContributor().setResource(URI.create("https://familysearch.org/platform/contributors/STV-WXZY"));
    attributedSourceReference.setAttribution(attribution);
    attributedSourceReference.setResource(URI.create("http://en.wikipedia.org/wiki/George_washington"));
    attributedSourceReference.setKnownType(ResourceType.Text);
    sources.add(attributedSourceReference);
    person.setSources(sources);

    person.setId("BBB-BBBB");

    return person;
  }

  static void assertEquals(Person person) {
    //todo:
  }

}

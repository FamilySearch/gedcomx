package org.gedcomx.conclusion;

import org.gedcomx.common.Attribution;
import org.gedcomx.common.ResourceReference;
import org.gedcomx.common.SourceReference;
import org.gedcomx.common.URI;
import org.gedcomx.metadata.dc.DublinCoreDescriptionDecorator;
import org.gedcomx.metadata.rdf.Description;
import org.gedcomx.metadata.rdf.RDFLiteral;
import org.gedcomx.metadata.rdf.RDFValue;
import org.gedcomx.test.RecipeTest;
import org.gedcomx.test.Snippet;
import org.gedcomx.types.FactType;
import org.gedcomx.types.GenderType;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.gedcomx.rt.SerializationUtil.processThroughJson;
import static org.gedcomx.rt.SerializationUtil.processThroughXml;

/**
 * Recipes for citing evidence in GEDCOM X.
 * @author Ryan Heaton
 */
@Test
public class EvidenceRecipesTest extends RecipeTest {

  /**
   * tests citing an online record.
   */
  public void testCitingOnlineArtifact() throws Exception {
    createRecipe("Citing an Online Artifact")
      .withDescription("The following example illustrates how to cite an online record. Evidence for Israel Hoyt Heaton is found in the 1920 U.S. Census. The URI to the record is \"https://familysearch.org/pal:/MM9.1.1/M8PT-4GN\". The URI for a description of the record is \"https://familysearch.org/platform/sources/GGG-GGGG\".")
      .applicableTo(Person.class);

    Person person = createPersonCitingOnlineArtifact();
    Snippet snippet = new Snippet("The person.");
    processThroughXml(person, snippet);
    processThroughJson(person, snippet);
    addSnippet(snippet);

    snippet = new Snippet("The description of the source. The URI to the description is \"https://familysearch.org/platform/sources/GGG-GGGG\".");
    Description description = createDescriptionOfOnlineArtifact();
    processThroughXml(description, snippet);
    processThroughJson(description, snippet);
    addSnippet(snippet);

//    assertEquals(person);
  }

  static Description createDescriptionOfOnlineArtifact() {
    return DublinCoreDescriptionDecorator.newInstance()
      .bibliographicCitation(new RDFLiteral("\"United States Census, 1920,\" index and images, FamilySearch (https://familysearch.org/pal:/MM9.1.1/M8PT-4GN : accessed 31 May 2012), Israel H Heaton, , Kane, Utah."))
      .title(new RDFLiteral("\"United States Census, 1920,\" Israel H Heaton, , Kane, Utah"))
      .about(URI.create("https://familysearch.org/pal:/MM9.1.1/M8PT-4GN"))
      .getDecoratedDescription();
  }

  static Person createPersonCitingOnlineArtifact() {
    Person person = new Person();
    person.setGender(new Gender(GenderType.Male));

    Fact fact = new Fact();
    fact.setId("123");
    fact.setKnownType(FactType.Birth);

    fact.setAttribution(new Attribution());
    fact.getAttribution().setContributor(new ResourceReference());
    fact.getAttribution().getContributor().setResource(URI.create("https://familysearch.org/platform/contributors/BCD-FGHJ"));
    fact.setDate(new Date());
    fact.getDate().setOriginal("30 January 1880");

    fact.setPlace(new Place());
    fact.getPlace().setOriginal("Orderville, Utah");

    person.addFact(fact);

    fact = new Fact();
    fact.setId("456");
    fact.setKnownType(FactType.Death);

    fact.setAttribution(new Attribution());
    fact.getAttribution().setContributor(new ResourceReference());
    fact.getAttribution().getContributor().setResource(URI.create("https://familysearch.org/platform/contributors/KLM-NPQR"));
    fact.setDate(new Date());
    fact.getDate().setOriginal("29 August 1936");

    fact.setPlace(new Place());
    fact.getPlace().setOriginal("Kanab, Kane, UT");

    person.addFact(fact);

    List<Name> names = new ArrayList<Name>();
    Name name = new Name();
    name.setPreferred(true);
    NameForm nameForm = new NameForm();
    nameForm.setFullText("Israel Hoyt Heaton");
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
    attributedSourceReference.setSource(URI.create("https://familysearch.org/pal:/MM9.1.1/M8PT-4GN"));
    attributedSourceReference.setSourceDescription(new ResourceReference());
    attributedSourceReference.getSourceDescription().setResource(URI.create("https://familysearch.org/platform/sources/GGG-GGGG"));
    sources.add(attributedSourceReference);
    person.setSourceReferences(sources);

    person.setId("KWCD-QBC");

    return person;
  }

  /**
   * tests citing an online record.
   */
  public void testCitingPhysicalArtifact() throws Exception {
    createRecipe("Citing a Physical Artifact")
      .withDescription("The following example illustrates how to cite a physical artifact, such as a book. Evidence for Asa Phillips is found in a book authored by Helen Kelly Brink. The book doesn't have a URI, but the URI for a description of the book is \"https://familysearch.org/platform/sources/KKK-KKKK\".")
      .applicableTo(Person.class);

    Person person = createPersonCitingPhysicalArtifact();
    Snippet snippet = new Snippet("The person.");
    processThroughXml(person, snippet);
    processThroughJson(person, snippet);
    addSnippet(snippet);

    snippet = new Snippet("The description of the source. The URI to the description is \"https://familysearch.org/platform/sources/KKK-KKKK\".");
    Description description = createDescriptionOfPhysicalArtifact();
    processThroughXml(description, snippet);
    processThroughJson(description, snippet);
    addSnippet(snippet);

//    assertEquals(person);
  }

  static Description createDescriptionOfPhysicalArtifact() {
    return DublinCoreDescriptionDecorator.newInstance()
      .bibliographicCitation(new RDFLiteral("Helen Kelly Brink, Some of the Descendants of Asa Phillips (1793-1844); Who were Born in Vermont and Who Settled in Steuben County, New York in 1802, (Marco Island, Florida, By the Author, 1992) p.34"))
      .title(new RDFLiteral("Some of the Descendants of Asa Phillips (1793-1844); Who were Born in Vermont and Who Settled in Steuben County, New York in 1802"))
      .creator(new RDFValue("Helen Kelly Brink"))
      .publisher(new RDFValue("Helen Kelly Brink"))
      .temporal(new RDFValue("1802"))
      .spatial(new RDFValue("Steuben County, New York"))
      .id("KKK-KKKK")
      .getDecoratedDescription();
  }

  static Person createPersonCitingPhysicalArtifact() {
    Person person = new Person();
    person.setGender(new Gender(GenderType.Male));

    Fact fact = new Fact();
    fact.setId("123");
    fact.setKnownType(FactType.Birth);

    fact.setAttribution(new Attribution());
    fact.getAttribution().setContributor(new ResourceReference());
    fact.getAttribution().getContributor().setResource(URI.create("https://familysearch.org/platform/contributors/BCD-FGHJ"));
    fact.setDate(new Date());
    fact.getDate().setOriginal("1793");

    fact.setPlace(new Place());
    fact.getPlace().setOriginal("Vermont");

    person.addFact(fact);

    fact = new Fact();
    fact.setId("456");
    fact.setKnownType(FactType.Death);

    fact.setAttribution(new Attribution());
    fact.getAttribution().setContributor(new ResourceReference());
    fact.getAttribution().getContributor().setResource(URI.create("https://familysearch.org/platform/contributors/KLM-NPQR"));
    fact.setDate(new Date());
    fact.getDate().setOriginal("1844");

    fact.setPlace(new Place());
    fact.getPlace().setOriginal("Steuben County, New York");

    person.addFact(fact);

    List<Name> names = new ArrayList<Name>();
    Name name = new Name();
    name.setPreferred(true);
    NameForm nameForm = new NameForm();
    nameForm.setFullText("Asa Phillips");
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
    attributedSourceReference.setSourceDescription(new ResourceReference());
    attributedSourceReference.getSourceDescription().setResource(URI.create("https://familysearch.org/platform/sources/KKK-KKKK"));
    sources.add(attributedSourceReference);
    person.setSourceReferences(sources);

    person.setId("K2VD-4P2");

    return person;
  }


  /**
   * tests citing an online record.
   */
  public void testConclusionsCitingOtherConclusions() throws Exception {
    createRecipe("Citing Other Conclusions")
      .withDescription("The following example illustrates how to cite another conclusion. Evidence for Israel Heaton is found in another conclusion person that (presumably) describes the same person. The URI to the person being cited is \"https://familysearch.org/platform/persons/NNN-NNNN\".")
      .applicableTo(Person.class);

    Person person = createPersonCitingOtherConclusion();
    Snippet snippet = new Snippet("The person.");
    processThroughXml(person, snippet);
    processThroughJson(person, snippet);
    addSnippet(snippet);

    snippet = new Snippet("The person being cited. The URI to this conclusion person is \"https://familysearch.org/platform/sources/NNN-NNNN\".");
    Person description = createPersonBeingCitedByAnotherPerson();
    processThroughXml(description, snippet);
    processThroughJson(description, snippet);
    addSnippet(snippet);

//    assertEquals(person);
  }

  static Person createPersonCitingOtherConclusion() {
    Person person = new Person();
    person.setGender(new Gender(GenderType.Male));

    Fact fact = new Fact();
    fact.setId("123");
    fact.setKnownType(FactType.Birth);

    fact.setAttribution(new Attribution());
    fact.getAttribution().setContributor(new ResourceReference());
    fact.getAttribution().getContributor().setResource(URI.create("https://familysearch.org/platform/contributors/BCD-FGHJ"));
    fact.setDate(new Date());
    fact.getDate().setOriginal("30 January 1880");

    fact.setPlace(new Place());
    fact.getPlace().setOriginal("Orderville, Utah");

    person.addFact(fact);

    fact = new Fact();
    fact.setId("456");
    fact.setKnownType(FactType.Death);

    fact.setAttribution(new Attribution());
    fact.getAttribution().setContributor(new ResourceReference());
    fact.getAttribution().getContributor().setResource(URI.create("https://familysearch.org/platform/contributors/KLM-NPQR"));
    fact.setDate(new Date());
    fact.getDate().setOriginal("29 August 1936");

    fact.setPlace(new Place());
    fact.getPlace().setOriginal("Kanab, Kane, UT");

    person.addFact(fact);

    List<Name> names = new ArrayList<Name>();
    Name name = new Name();
    name.setPreferred(true);
    NameForm nameForm = new NameForm();
    nameForm.setFullText("Israel Hoyt Heaton");
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
    attributedSourceReference.setSource(URI.create("https://familysearch.org/platform/persons/NNN-NNNN"));
    sources.add(attributedSourceReference);
    person.setSourceReferences(sources);

    person.setId("KWCD-QBC");

    return person;
  }

  static Person createPersonBeingCitedByAnotherPerson() {
    Person person = new Person();
    person.setGender(new Gender(GenderType.Male));

    Fact fact = new Fact();
    fact.setId("123");
    fact.setKnownType(FactType.Birth);

    fact.setAttribution(new Attribution());
    fact.getAttribution().setContributor(new ResourceReference());
    fact.getAttribution().getContributor().setResource(URI.create("https://familysearch.org/platform/contributors/YYY-YYYY"));
    fact.setDate(new Date());
    fact.getDate().setOriginal("1880");

    fact.setPlace(new Place());
    fact.getPlace().setOriginal("Orderville, Utah");

    person.addFact(fact);

    List<Name> names = new ArrayList<Name>();
    Name name = new Name();
    name.setPreferred(true);
    NameForm nameForm = new NameForm();
    nameForm.setFullText("Israel H. Heaton");
    name.setPrimaryForm(nameForm);
    name.setAttribution(new Attribution());
    name.getAttribution().setContributor(new ResourceReference());
    name.getAttribution().getContributor().setResource(URI.create("https://familysearch.org/platform/contributors/XXX-XXXX"));
    name.setId("789");
    names.add(name);
    person.setNames(names);

    ArrayList<SourceReference> sources = new ArrayList<SourceReference>();
    SourceReference attributedSourceReference = new SourceReference();
    Attribution attribution = new Attribution();
    attribution.setContributor(new ResourceReference());
    attribution.getContributor().setResource(URI.create("https://familysearch.org/platform/contributors/ZZZ-ZZZZ"));
    attributedSourceReference.setAttribution(attribution);
    attributedSourceReference.setSourceDescription(new ResourceReference());
    attributedSourceReference.getSourceDescription().setResource(URI.create("https://familysearch.org/platform/sources/JJJ-JJJJ"));
    sources.add(attributedSourceReference);
    person.setSourceReferences(sources);

    person.setId("KWCD-QBC");

    return person;
  }

  static void assertEquals(Person person) {
    //todo:
  }

}

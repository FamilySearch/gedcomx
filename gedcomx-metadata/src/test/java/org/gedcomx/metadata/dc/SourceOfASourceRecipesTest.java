package org.gedcomx.metadata.dc;

import org.gedcomx.common.ResourceSet;
import org.gedcomx.common.URI;
import org.gedcomx.metadata.rdf.Description;
import org.gedcomx.metadata.rdf.RDFLiteral;
import org.gedcomx.metadata.rdf.RDFValue;
import org.gedcomx.rt.SerializationProcessListener;
import org.gedcomx.test.RecipeTest;
import org.gedcomx.test.Snippet;
import org.testng.annotations.Test;

import javax.xml.bind.JAXBContext;

import static org.gedcomx.rt.SerializationUtil.processThroughJson;
import static org.gedcomx.rt.SerializationUtil.processThroughXml;

/**
 * @author Ryan Heaton
 */
public class SourceOfASourceRecipesTest extends RecipeTest {

  @Test
  public void testTexasDeaths() throws Exception {
    createRecipe("Texas Deaths Online Citation")
      .withDescription("Example for citing online Texas Death records.")
      .applicableTo(Description.class);

    String sourceId = "1";
    String sourceOfSourceId = "2";

    RDFValue sourceOfSourceRef = new RDFValue();
    sourceOfSourceRef.setResource(URI.create("#" + sourceOfSourceId));

    DublinCoreDescriptionDecorator source = DublinCoreDescriptionDecorator.newInstance()
      .bibliographicCitation(new RDFLiteral("\"Texas Deaths, 1890-1976,\" index and images, FamilySearch (https://familysearch.org/pal:/MM9.1.1/J69H-GV1 : accessed 13 April 2012), Lyndon Baines Johnson, 1973"))
      .source(sourceOfSourceRef);
    source.getDecoratedDescription().setId(sourceId);

    DublinCoreDescriptionDecorator sourceOfTheSource = DublinCoreDescriptionDecorator.newInstance()
      .bibliographicCitation(new RDFLiteral("Bexar County, Texas, certificate 00340, Bureau of Vital Statistics, Department of Health, Austin; FHL microfilm 2,242,245."));
    sourceOfTheSource.getDecoratedDescription().setId(sourceOfSourceId);

    ResourceSet resourceSet = new ResourceSet();
    resourceSet.addExtensionElement(source.getDecoratedDescription());
    resourceSet.addExtensionElement(sourceOfTheSource.getDecoratedDescription());

    Snippet snippet = new Snippet();
    resourceSet = processThroughXml(resourceSet, ResourceSet.class, JAXBContext.newInstance(ResourceSet.class, Description.class, ObjectFactory.class), (SerializationProcessListener)snippet);
    //todo: verify person.
    resourceSet = processThroughJson(resourceSet, (SerializationProcessListener) snippet);
    //todo: verify person.
    addSnippet(snippet);

  }

  @Test
  public void test1930Census() throws Exception {
    createRecipe("1930 Census Online Citation")
      .withDescription("Example for citing online 1930 Census Records.")
      .applicableTo(Description.class);

    String sourceId = "1";
    String sourceOfSourceId = "2";

    RDFValue sourceOfSourceRef = new RDFValue();
    sourceOfSourceRef.setResource(URI.create("#" + sourceOfSourceId));

    DublinCoreDescriptionDecorator source = DublinCoreDescriptionDecorator.newInstance()
      .bibliographicCitation(new RDFLiteral("\"United States Census, 1930,\" index and images, FamilySearch (https://familysearch.org/pal:/MM9.1.1/XSYY-Q62 : accessed 13 April 2012), John E. Reagan, Dixon, Lee, Illinois"))
      .source(sourceOfSourceRef);
    source.getDecoratedDescription().setId(sourceId);

    DublinCoreDescriptionDecorator sourceOfTheSource = DublinCoreDescriptionDecorator.newInstance()
      .bibliographicCitation(new RDFLiteral("enumeration district 0017, sheet 7A, family 207, line 44, National Archives microfilm publication T626, roll 523."));
    sourceOfTheSource.getDecoratedDescription().setId(sourceOfSourceId);

    ResourceSet resourceSet = new ResourceSet();
    resourceSet.addExtensionElement(source.getDecoratedDescription());
    resourceSet.addExtensionElement(sourceOfTheSource.getDecoratedDescription());

    Snippet snippet = new Snippet();
    resourceSet = processThroughXml(resourceSet, ResourceSet.class, JAXBContext.newInstance(ResourceSet.class, Description.class, ObjectFactory.class), (SerializationProcessListener)snippet);
    //todo: verify person.
    resourceSet = processThroughJson(resourceSet, (SerializationProcessListener) snippet);
    //todo: verify person.
    addSnippet(snippet);

  }
}

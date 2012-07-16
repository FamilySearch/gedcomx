package org.gedcomx.metadata.dc;

import org.gedcomx.common.Attribution;
import org.gedcomx.common.Note;
import org.gedcomx.common.ResourceReference;
import org.gedcomx.common.ResourceSet;
import org.gedcomx.common.SourceReference;
import org.gedcomx.common.URI;
import org.gedcomx.metadata.foaf.Address;
import org.gedcomx.metadata.foaf.Organization;
import org.gedcomx.metadata.rdf.RDFLiteral;
import org.gedcomx.metadata.source.CitationField;
import org.gedcomx.metadata.source.SourceCitation;
import org.gedcomx.metadata.source.SourceDescription;
import org.gedcomx.rt.GedcomNamespaceManager;
import org.gedcomx.rt.SerializationProcessListener;
import org.gedcomx.test.RecipeTest;
import org.gedcomx.test.Snippet;
import org.testng.annotations.Test;

import javax.xml.bind.JAXBContext;

import java.util.ArrayList;
import java.util.Date;

import static org.gedcomx.rt.SerializationUtil.processThroughJson;
import static org.gedcomx.rt.SerializationUtil.processThroughXml;


/**
 * @author Ryan Heaton
 */
public class SourceOfASourceRecipesTest extends RecipeTest {
  static {
    GedcomNamespaceManager.registerKnownJsonType(SourceDescription.class);
    GedcomNamespaceManager.registerKnownJsonType(Organization.class);
    GedcomNamespaceManager.registerKnownJsonType(Note.class);
    GedcomNamespaceManager.registerKnownJsonType(ObjectFactory.class);
  }

  private String orgIdFamilySearch = "R1";
  private String orgIdFhl = "R2";
  private final Organization orgFamilySearch;
  private final Organization orgFhl;
  {
    orgFamilySearch = new Organization();
    orgFamilySearch.setId(orgIdFamilySearch);
    orgFamilySearch.setName(new RDFLiteral("FamilySearch International"));
    orgFamilySearch.setHomepage(new RDFLiteral("http://familysearch.org/"));

    orgFhl = new Organization();
    orgFhl.setId(orgIdFhl);
    orgFhl.setName(new RDFLiteral("Family History Library"));
    orgFhl.setHomepage(new RDFLiteral("https://familysearch.org/locations/saltlakecity-library"));
    orgFhl.setAddresses(new ArrayList<Address>());
    orgFhl.getAddresses().add(new Address());
    orgFhl.getAddresses().get(0).setValue("35 N West Temple St\nSalt Lake City, UT 84150");
    orgFhl.getAddresses().get(0).setStreet("35 N West Temple St");
    orgFhl.getAddresses().get(0).setCity("Salt Lake City");
    orgFhl.getAddresses().get(0).setStateOrProvince("UT");
    orgFhl.getAddresses().get(0).setPostalCode("84150");
    orgFhl.getAddresses().get(0).setCountry("United States");
    orgFhl.setPhones(new ArrayList<ResourceReference>());
    orgFhl.getPhones().add(new ResourceReference(URI.create("tel:+1-866-406-1830")));
  }

  @Test
  public void testTexasDeaths() throws Exception {
    createRecipe("Describing a Texas Deaths Online Record")
      .withDescription("Example for describing an online Texas Death record.")
      .applicableTo(SourceDescription.class);

    Note note = new Note();
    note.setLang("en-US");
    note.setText("Image available with record if you sign into FamilySearch.");
    note.setAttribution(new Attribution());
    note.getAttribution().setContributor(new ResourceReference(URI.create("#contributorid")));
    note.getAttribution().setModified(new Date(1321027871111L)); // 11 Nov 2011 11:11:11.111

    String sourceOfSourceId = "S1";
    String sourceId = "S2";

    SourceDescription srcDesc1 = new SourceDescription();
    srcDesc1.setId(sourceOfSourceId);
    srcDesc1.setCitation(new SourceCitation());
    srcDesc1.getCitation().setValue("Texas. Bureau of Vital Statistics. Texas death records, 1890-1976. State Registrar Office, Austin. FHL US/CAN Film 2242245. Family History Library, Salt Lake City, Utah");
    srcDesc1.getCitation().setCitationTemplate(new ResourceReference(new URI("http:/source-template-authority/fhl-film-collection-template")));
    srcDesc1.getCitation().setFields(new ArrayList<CitationField>());
    srcDesc1.getCitation().getFields().add(new CitationField("collection-locality", "Texas"));
    srcDesc1.getCitation().getFields().add(new CitationField("author", "Bureau of Vital Statistics"));
    srcDesc1.getCitation().getFields().add(new CitationField("title", "Texas death records, 1890-1976"));
    srcDesc1.getCitation().getFields().add(new CitationField("archive-name", "State Registrar Office"));
    srcDesc1.getCitation().getFields().add(new CitationField("archive-locality", "Austin"));
    srcDesc1.getCitation().getFields().add(new CitationField("fhl-film", "FHL US/CAN Film 2242245"));
    srcDesc1.setMediator(URI.create("repository#" + orgIdFhl));

    SourceDescription srcDesc2 = new SourceDescription();
    srcDesc2.setId(sourceId);
    srcDesc2.setCitation(new SourceCitation());
    srcDesc2.getCitation().setValue("\"Texas Deaths, 1890-1976,\" index and images, FamilySearch (https://familysearch.org/pal:/MM9.1.1/J69H-GV1 : accessed 13 April 2012), Lyndon Baines Johnson, 1973");
    srcDesc2.getCitation().setCitationTemplate(new ResourceReference(new URI("http://source-template-authority/fsindex-deathrecord-template")));
    srcDesc2.getCitation().setFields(new ArrayList<CitationField>());
    srcDesc2.getCitation().getFields().add(new CitationField("title", "Texas Deaths, 1890-1976"));
    srcDesc2.getCitation().getFields().add(new CitationField("description", "index and images"));
    srcDesc2.getCitation().getFields().add(new CitationField("publisher", "FamilySearch"));
    srcDesc2.getCitation().getFields().add(new CitationField("record-pal", "https://familysearch.org/pal:/MM9.1.1/J69H-GV1"));
    srcDesc2.getCitation().getFields().add(new CitationField("decadent", "Lyndon Baines Johnson"));
    srcDesc2.getCitation().getFields().add(new CitationField("death-year", "1973"));
    srcDesc2.getCitation().getFields().add(new CitationField("accessed", "13 April 2012"));
    srcDesc2.setAbout(URI.create("https://familysearch.org/pal:/MM9.1.1/J69H-GV1"));
    srcDesc2.setSourceReferences(new ArrayList<SourceReference>());
    srcDesc2.getSourceReferences().add(new SourceReference());
    srcDesc2.getSourceReferences().get(0).setSourceDescription(URI.create("#" + sourceOfSourceId));
    srcDesc2.setDisplayName("President Lyndon B Johnson's Death Certificate");
    srcDesc2.setMediator(URI.create("repository#" + orgIdFamilySearch));
    srcDesc2.setNotes(new ArrayList<Note>());
    srcDesc2.getNotes().add(note);

    ResourceSet resourceSet = new ResourceSet();
    resourceSet.addExtensionElement(srcDesc2);
    resourceSet.addExtensionElement(srcDesc1);
    resourceSet.addExtensionElement(orgFamilySearch);
    resourceSet.addExtensionElement(orgFhl);
    resourceSet.addExtensionElement(note);

    Snippet snippet = new Snippet();
    resourceSet = processThroughXml(resourceSet, ResourceSet.class, JAXBContext.newInstance(ResourceSet.class, SourceDescription.class, Organization.class, Note.class, ObjectFactory.class), (SerializationProcessListener)snippet);
    //todo: verify person.
    resourceSet = processThroughJson(resourceSet, (SerializationProcessListener) snippet);
    //todo: verify person.
    addSnippet(snippet);
  }

  @Test
  public void test1930Census() throws Exception {
    createRecipe("Describing a 1930 Census Online Record")
      .withDescription("Example for describing an online 1930 Census Record.")
      .applicableTo(SourceDescription.class);

    String orgIdNara = "R3";

    Organization orgNara = new Organization();
    orgNara.setId(orgIdNara);
    orgNara.setName(new RDFLiteral("National Archives and Records Administration"));
    orgNara.setHomepage(new RDFLiteral("http://www.archives.gov/"));
    orgNara.setAddresses(new ArrayList<Address>());
    orgNara.getAddresses().add(new Address());
    orgNara.getAddresses().get(0).setValue("The National Archives and Records Administration\n8601 Adelphi Road\nCollege Park, MD 20740-6001");
    orgNara.getAddresses().get(0).setStreet("8601 Adelphi Rd");
    orgNara.getAddresses().get(0).setCity("College Park");
    orgNara.getAddresses().get(0).setStateOrProvince("MD");
    orgNara.getAddresses().get(0).setPostalCode("20740-6001");
    orgNara.getAddresses().get(0).setCountry("United States");
    orgNara.setPhones(new ArrayList<ResourceReference>());
    orgNara.getPhones().add(new ResourceReference(URI.create("tel:+1-866-272-6272")));
    orgNara.getPhones().add(new ResourceReference(URI.create("fax:+1-301-837-0483")));

    Note note = new Note();
    note.setLang("en-US");
    note.setText("Image available with record.");
    note.setAttribution(new Attribution());
    note.getAttribution().setContributor(new ResourceReference(URI.create("#contributorid")));
    note.getAttribution().setModified(new Date(1321027871111L)); // 11 Nov 2011 11:11:11.111

    String sourceS1 = "S1";
    String sourceOfS1 = "S2";
    String sourceOfS2 = "S3";

    SourceDescription srcDesc0 = new SourceDescription();
    srcDesc0.setId(sourceOfS2);
    srcDesc0.setCitation(new SourceCitation());
    srcDesc0.getCitation().setValue("Bureau of the Census. \"Population Schedules for the 1930 Census.\" NARA microfilm publication T626, roll 523. National Archives and Records Administration, Washington D.C.");
    srcDesc0.getCitation().setCitationTemplate(new ResourceReference(new URI("http:/source-template-authority/nara-microfilm-pub-template")));
    srcDesc0.getCitation().setFields(new ArrayList<CitationField>());
    srcDesc0.getCitation().getFields().add(new CitationField("creator", "Bureau of the Census"));
    srcDesc0.getCitation().getFields().add(new CitationField("title", "Population Schedules for the 1930 Census"));
    srcDesc0.getCitation().getFields().add(new CitationField("nara-film-pub", "T626"));
    srcDesc0.getCitation().getFields().add(new CitationField("nara-film-roll", "523"));
    srcDesc0.getCitation().getFields().add(new CitationField("archive", "National Archives and Records Administration"));
    srcDesc0.getCitation().getFields().add(new CitationField("archive-locality", "Washington D.C."));
    srcDesc0.setMediator(URI.create("repository#" + orgIdNara));

    SourceDescription srcDesc1 = new SourceDescription();
    srcDesc1.setId(sourceOfS1);
    srcDesc1.setCitation(new SourceCitation());
    srcDesc1.getCitation().setValue("United States. Bureau of the Census. 15th census, 1930. United States, 1930 federal census : population schedules; NARA microfilm publication T626. National Archives and Records Administration, Washington D.C. FHL US/CAN Census Area Film 2340258. Family History Library, Salt Lake City, Utah");
    srcDesc1.getCitation().setCitationTemplate(new ResourceReference(new URI("http:/source-template-authority/fhl-film-collection-template")));
    srcDesc1.getCitation().setFields(new ArrayList<CitationField>());
    srcDesc1.getCitation().getFields().add(new CitationField("collection-locality", "United States"));
    srcDesc1.getCitation().getFields().add(new CitationField("author", "Bureau of the Census. 15th census, 1930"));
    srcDesc1.getCitation().getFields().add(new CitationField("title", "United States, 1930 federal census : population schedules ; NARA microfilm publication T626"));
    srcDesc1.getCitation().getFields().add(new CitationField("archive-name", "National Archives and Records Administration"));
    srcDesc1.getCitation().getFields().add(new CitationField("archive-locality", "Washington D.C"));
    srcDesc1.getCitation().getFields().add(new CitationField("fhl-film", "FHL US/CAN Census Area Film 2340258"));
    srcDesc1.setMediator(URI.create("repository#" + orgIdFhl));

    SourceDescription srcDesc2 = new SourceDescription();
    srcDesc2.setId(sourceS1);
    srcDesc2.setCitation(new SourceCitation());
    srcDesc2.getCitation().setValue("\"United States Census, 1930,\" index and images, FamilySearch (https://familysearch.org/pal:/MM9.1.1/XSYY-Q6P : accessed 12 July 2012), Ronald Reagan in household of John E Reagan, Dixon, Lee, Illinois.");
    srcDesc2.getCitation().setCitationTemplate(new ResourceReference(new URI("http://source-template-authority/fsindex-uscensus-template")));
    srcDesc2.getCitation().setFields(new ArrayList<CitationField>());
    srcDesc2.getCitation().getFields().add(new CitationField("title", "United States Census, 1930"));
    srcDesc2.getCitation().getFields().add(new CitationField("description", "index and images"));
    srcDesc2.getCitation().getFields().add(new CitationField("publisher", "FamilySearch"));
    srcDesc2.getCitation().getFields().add(new CitationField("record-pal", "https://familysearch.org/pal:/MM9.1.1/J69H-GV1"));
    srcDesc2.getCitation().getFields().add(new CitationField("person-of-interest", "Ronald Reagan"));
    srcDesc2.getCitation().getFields().add(new CitationField("head-of-household-if-not-poi", "John E Reagan"));
    srcDesc2.getCitation().getFields().add(new CitationField("line", "44"));
    srcDesc2.getCitation().getFields().add(new CitationField("family", "207"));
    srcDesc2.getCitation().getFields().add(new CitationField("sheet", "7A"));
    srcDesc2.getCitation().getFields().add(new CitationField("enumeration-district", "52-0017"));
    srcDesc2.getCitation().getFields().add(new CitationField("incorporated-place", "Dixon"));
    srcDesc2.getCitation().getFields().add(new CitationField("county", "Lee"));
    srcDesc2.getCitation().getFields().add(new CitationField("state", "Illinois"));
    srcDesc2.getCitation().getFields().add(new CitationField("accessed", "12 July 2012"));
    srcDesc2.setAbout(URI.create("https://familysearch.org/pal:/MM9.1.1/XSYY-Q6P"));
    srcDesc2.setSourceReferences(new ArrayList<SourceReference>());
    srcDesc2.getSourceReferences().add(new SourceReference());
    srcDesc2.getSourceReferences().get(0).setSourceDescription(URI.create("#" + sourceOfS1));
    srcDesc2.setDisplayName("President Ronald Reagan with his parents in 1830 census");
    srcDesc2.setMediator(URI.create("repository#" + orgIdFamilySearch));
    srcDesc2.setNotes(new ArrayList<Note>());
    srcDesc2.getNotes().add(note);

    ResourceSet resourceSet = new ResourceSet();
    resourceSet.addExtensionElement(srcDesc2);
    resourceSet.addExtensionElement(srcDesc1);
    resourceSet.addExtensionElement(srcDesc0);
    resourceSet.addExtensionElement(orgFamilySearch);
    resourceSet.addExtensionElement(orgFhl);
    resourceSet.addExtensionElement(orgNara);
    resourceSet.addExtensionElement(note);

    Snippet snippet = new Snippet();
    resourceSet = processThroughXml(resourceSet, ResourceSet.class, JAXBContext.newInstance(ResourceSet.class, SourceDescription.class, Organization.class, Note.class, ObjectFactory.class), (SerializationProcessListener)snippet);
    //todo: verify person.
    resourceSet = processThroughJson(resourceSet, (SerializationProcessListener) snippet);
    //todo: verify person.
    addSnippet(snippet);
  }
}

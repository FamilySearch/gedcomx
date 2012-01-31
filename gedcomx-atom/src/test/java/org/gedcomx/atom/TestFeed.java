package org.gedcomx.atom;

import org.gedcomx.common.URI;
import org.gedcomx.opensearch.Query;
import org.testng.annotations.Test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import java.util.ArrayList;
import java.util.Date;

import static org.gedcomx.rt.SerializationUtil.processThroughJson;
import static org.gedcomx.rt.SerializationUtil.processThroughXml;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.fail;

/**
 * @author Ryan Heaton
 */
@Test
public class TestFeed {

  public void testFeedXml() throws Exception {
    Feed feed = createFeed();
    feed = processThroughXml(feed, Feed.class, JAXBContext.newInstance(Feed.class, CustomEntity.class));
    assertFeed(feed);
  }

  public void testFeedJson() throws Exception {
    Feed feed = createFeed();
    feed = processThroughJson(feed);
    assertFeed(feed);
  }

  private Feed createFeed() {
    Feed feed = new Feed();
    feed.setAuthors(new ArrayList<Person>());
    Person author = new Person();
    author.setEmail("author@author.com");
    author.setName("Author");
    author.setUri(URI.create("urn:author"));
    author.setBase(URI.create("urn:base"));
    author.setLang("en");
    feed.getAuthors().add(author);

    feed.setContributors(new ArrayList<Person>());
    Person contributor = new Person();
    contributor.setEmail("contributor@contributor.com");
    contributor.setName("Contributor");
    contributor.setUri(URI.create("urn:contributor"));
    feed.getContributors().add(contributor);
    
    feed.setEntries(new ArrayList<Entry>());
    Entry entry = new Entry();
    entry.setAuthors(new ArrayList<Person>());
    Person author2 = new Person();
    author2.setEmail("author2@author.com");
    entry.getAuthors().add(author2);
    entry.setCategories(new ArrayList<Category>());
    Category category = new Category();
    category.setLabel("label");
    category.setScheme(URI.create("urn:scheme"));
    category.setTerm("term");
    entry.getCategories().add(category);
    entry.setContent(new Content());
    entry.getContent().setBase(URI.create("urn:base"));
    entry.getContent().setLang("fr");
    entry.getContent().setType(AtomContentType.text);
    entry.getContent().setValue("text content");
    entry.setContributors(new ArrayList<Person>());
    entry.getContributors().add(new Person());
    entry.getContributors().get(0).setEmail("contributor2@contributor.com");
    entry.setId(URI.create("urn:id"));
    entry.setLinks(new ArrayList<Link>());
    Link link = new Link();
    link.setHref(URI.create("urn:href"));
    link.setTitle("link title");
    link.setHreflang("en");
    link.setLength("1234");
    link.setRel("self");
    link.setType("text/plain");
    entry.getLinks().add(link);
    entry.setPublished(new Date(1234567L));
    entry.setRights("none");
    entry.setScore(0.6F);
    entry.setTitle("entry title");
    entry.setUpdated(new Date(1234568L));

    CustomEntity customEntity = new CustomEntity();
    customEntity.setId("entityid");
    CustomEntity subentity = new CustomEntity();
    subentity.setId("subentityid");
    customEntity.addExtensionElement(new ObjectFactory().createCustomEntitySubelement(subentity));
    entry.addExtensionElement(customEntity);
    feed.getEntries().add(entry);
    
    feed.setGenerator(new Generator());
    feed.getGenerator().setBase(URI.create("urn:base"));
    feed.getGenerator().setLang("de");
    feed.getGenerator().setUri(URI.create("urn:generator"));
    feed.getGenerator().setValue("generator value");
    feed.getGenerator().setVersion("1.2");
    
    feed.setIcon(URI.create("urn:icon"));
    feed.setId(URI.create("urn:feedid"));
    feed.setItemsPerPage(2);
    feed.setLinks(new ArrayList<Link>());
    feed.getLinks().add(new Link("self", URI.create("urn:feed")));
    feed.setLogo(URI.create("urn:logo"));
    feed.setQuery(new Query());
    feed.getQuery().setCount(4);
    feed.getQuery().setInputEncoding("utf-8");
    feed.getQuery().setLanguage("es");
    feed.getQuery().setOutputEncoding("ascii");
    feed.getQuery().setRole("role");
    feed.getQuery().setSearchTerms("terms");
    feed.getQuery().setStartIndex(5);
    feed.getQuery().setStartPage("page1");
    feed.getQuery().setTitle("query title");
    feed.getQuery().setTotalResults(6);

    feed.setRights("feed rights");
    feed.setSubtitle("subtitle");
    feed.setTitle("feed title");
    feed.setTotalResults(7);
    feed.setUpdated(new Date(54321L));
    
    return feed;
  }

  private void assertFeed(Feed feed) {
    assertEquals(1, feed.getAuthors().size());
    Person author = feed.getAuthors().get(0);
    assertEquals("author@author.com", author.getEmail());
    assertEquals("Author", author.getName());
    assertEquals(URI.create("urn:author"), author.getUri());
    assertEquals(URI.create("urn:base"), author.getBase());
    assertEquals("en", author.getLang());

    assertEquals(1, feed.getContributors().size());
    Person contributor = feed.getContributors().get(0);
    assertEquals("contributor@contributor.com", contributor.getEmail());
    assertEquals("Contributor", contributor.getName());
    assertEquals(URI.create("urn:contributor"), contributor.getUri());

    assertEquals(1, feed.getEntries().size());
    Entry entry = feed.getEntries().get(0);
    assertEquals(1, entry.getAuthors().size());
    Person author2 = entry.getAuthors().get(0);
    assertEquals("author2@author.com", author2.getEmail());
    assertEquals(1, entry.getCategories().size());
    Category category = entry.getCategories().get(0);
    assertEquals("label", category.getLabel());
    assertEquals(URI.create("urn:scheme"), category.getScheme());
    assertEquals("term", category.getTerm());

    assertEquals(URI.create("urn:base"), entry.getContent().getBase());
    assertEquals("fr", entry.getContent().getLang());
    assertEquals(AtomContentType.text, entry.getContent().getType());
    assertEquals("text content", entry.getContent().getValue());

    assertEquals(1, entry.getContributors().size());
    assertEquals("contributor2@contributor.com", entry.getContributors().get(0).getEmail());
    assertEquals(URI.create("urn:id"), entry.getId());
    assertEquals(1, entry.getLinks().size());
    Link link = entry.getLinks().get(0);
    assertEquals(URI.create("urn:href"), link.getHref());
    assertEquals("link title", link.getTitle());
    assertEquals("en", link.getHreflang());
    assertEquals("1234", link.getLength());
    assertEquals("self", link.getRel());
    assertEquals("text/plain", link.getType());

    assertEquals(new Date(1234567L), entry.getPublished());
    assertEquals("none", entry.getRights());
    assertEquals(0.6F, entry.getScore());
    assertEquals("entry title", entry.getTitle());
    assertEquals(new Date(1234568L), entry.getUpdated());
    assertEquals(1, entry.getExtensionElements().size());
    CustomEntity customEntity = entry.findExtensionOfType(CustomEntity.class);
    assertEquals("entityid", customEntity.getId());
    assertEquals(1, customEntity.getExtensionElements().size());
    Object ext = customEntity.getExtensionElements().get(0);
    CustomEntity subentity = null;
    if (ext instanceof CustomEntity) {
      subentity = (CustomEntity) ext;
    }
    else if (ext instanceof JAXBElement) {
      subentity = (CustomEntity) ((JAXBElement) ext).getValue();
    }
    else {
      fail("Extension element should be an instance of CustomEntity or JAXBElement<CustomEntity>");
    }
    assertEquals("subentityid", subentity.getId());

    assertEquals(URI.create("urn:base"), feed.getGenerator().getBase());
    assertEquals("de", feed.getGenerator().getLang());
    assertEquals(URI.create("urn:generator"), feed.getGenerator().getUri());
    assertEquals("generator value", feed.getGenerator().getValue());
    assertEquals("1.2", feed.getGenerator().getVersion());

    assertEquals(URI.create("urn:icon"), feed.getIcon());
    assertEquals(URI.create("urn:feedid"), feed.getId());
    assertEquals(2, feed.getItemsPerPage().intValue());
    assertEquals(1, feed.getLinks().size());
    assertEquals("self", feed.getLinks().get(0).getRel());
    assertEquals(URI.create("urn:feed"), feed.getLinks().get(0).getHref());
    assertEquals(URI.create("urn:logo"), feed.getLogo());
    assertEquals(4, feed.getQuery().getCount().intValue());
    assertEquals("utf-8", feed.getQuery().getInputEncoding());
    assertEquals("es", feed.getQuery().getLanguage());
    assertEquals("ascii", feed.getQuery().getOutputEncoding());
    assertEquals("role", feed.getQuery().getRole());
    assertEquals("terms", feed.getQuery().getSearchTerms());
    assertEquals(5, feed.getQuery().getStartIndex().intValue());
    assertEquals("page1", feed.getQuery().getStartPage());
    assertEquals("query title", feed.getQuery().getTitle());
    assertEquals(6, feed.getQuery().getTotalResults().intValue());

    assertEquals("feed rights", feed.getRights());
    assertEquals("subtitle", feed.getSubtitle());
    assertEquals("feed title", feed.getTitle());
    assertEquals(7, feed.getTotalResults().intValue());
    assertEquals(new Date(54321L), feed.getUpdated());
  }

}

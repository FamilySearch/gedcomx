package org.familysearch.ct.ws.rs.impl;

import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import org.familysearch.ct.ws.service.api.PersonService;
import org.familysearch.ct.ws.service.api.SearchParameter;
import org.gedcomx.atom.AtomModel;
import org.gedcomx.atom.Entry;
import org.gedcomx.atom.Feed;
import org.gedcomx.common.URI;
import org.gedcomx.conclusion.Name;
import org.gedcomx.conclusion.NameForm;
import org.gedcomx.conclusion.ObjectFactory;
import org.gedcomx.conclusion.Person;
import org.gedcomx.types.NameType;
import org.junit.Test;

import javax.ws.rs.core.Response;
import java.util.*;

import static org.easymock.EasyMock.*;
import static org.junit.Assert.assertEquals;

public class TestPersonSearchRSImpl extends ConclusionTreeUseCaseTest {

  @Test
  public void testSearchForPersons() throws Exception {
    createUseCase("Search For Persons")
      .withDescription("How to search for persons.")
      .applicableTo(PersonSearchRSImpl.class);
    ObjectFactory conclusionFactory = new ObjectFactory();
    
    Person searchedPerson1 = new Person();
    searchedPerson1.setId("98765");
    searchedPerson1.setPersistentId(URI.create("http://familysearch.org/persons/98765"));
    Name name = new Name();
    name.setKnownType(NameType.Name);
    name.setPrimaryForm(new NameForm());
    name.getPrimaryForm().setFullText("Israel Heaton");
    searchedPerson1.setNames(Arrays.asList(name));
    Person searchedPerson1Father = new Person();
    searchedPerson1Father.setNames(new ArrayList<Name>());
    name = new Name();
    name.setPrimaryForm(new NameForm());
    name.getPrimaryForm().setFullText("Jonathan Heaton");
    searchedPerson1Father.getNames().add(name);
    Person searchedPerson1Mother = new Person();
    searchedPerson1Mother.setNames(new ArrayList<Name>());
    name = new Name();
    name.setPrimaryForm(new NameForm());
    name.getPrimaryForm().setFullText("Clarissa Hoyt");
    searchedPerson1Mother.getNames().add(name);

    Person searchedPerson2 = new Person();
    searchedPerson2.setId("43210");
    searchedPerson2.setPersistentId(URI.create("http://familysearch.org/persons/43210"));
    name = new Name();
    name.setKnownType(NameType.Name);
    name.setPrimaryForm(new NameForm());
    name.getPrimaryForm().setFullText("Israel Hoyt Heaton");
    searchedPerson2.setNames(Arrays.asList(name));

    Feed serverSideSearchFeed = new Feed();
    URI feedId = URI.create("uuid:" + UUID.randomUUID().toString());
    serverSideSearchFeed.setId(feedId);
    serverSideSearchFeed.setItemsPerPage(2);
    serverSideSearchFeed.setStartIndex(0);
    serverSideSearchFeed.setTotalResults(2);
    serverSideSearchFeed.setTitle("Search Results for Israel Heaton");
    serverSideSearchFeed.setUpdated(new Date());
    serverSideSearchFeed.setEntries(new ArrayList<Entry>());

    Entry search1 = new Entry();
    search1.addExtensionElement(searchedPerson1);
    search1.setId(searchedPerson1.getPersistentId());
    search1.setScore(0.95F);
    search1.setUpdated(new Date());
    search1.addExtensionElement(conclusionFactory.createParentElement(searchedPerson1Father));
    search1.addExtensionElement(conclusionFactory.createParentElement(searchedPerson1Mother));
    serverSideSearchFeed.getEntries().add(search1);

    Entry search2 = new Entry();
    search2.addExtensionElement(searchedPerson2);
    search2.setId(searchedPerson2.getPersistentId());
    search2.setScore(0.95F);
    search2.setUpdated(new Date());
    serverSideSearchFeed.getEntries().add(search2);

    PersonService personService = getServerSideMock(PersonService.class);
    EnumMap<SearchParameter, String> params = new EnumMap<SearchParameter, String>(SearchParameter.class);
    params.put(SearchParameter.givenName, "Israel");
    params.put(SearchParameter.familyName, "Heaton");
    params.put(SearchParameter.fatherGivenName, "Jonathan");
    params.put(SearchParameter.fatherFamilyName, "Heaton");
    params.put(SearchParameter.motherGivenName, "Clarissa");
    params.put(SearchParameter.motherFamilyName, "Hoyt");
    expect(personService.searchForPersons(params)).andReturn(serverSideSearchFeed);
    replay(personService);
    WebResource resource = resource().path("/search")
      .queryParam("givenName", "Israel")
      .queryParam("familyName", "Heaton")
      .queryParam("fatherGivenName", "Jonathan")
      .queryParam("fatherFamilyName", "Heaton")
      .queryParam("motherGivenName", "Clarissa")
      .queryParam("motherFamilyName", "Hoyt");

    ClientResponse response = resource.accept(AtomModel.ATOM_XML_MEDIA_TYPE).get(ClientResponse.class);
    assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
    assertEquals(feedId, response.getEntity(Feed.class).getId());
    verify(personService);
    reset(personService);
  }


  @Test
  public void testSearchForPersonMatches() throws Exception {
    createUseCase("Search For Person Matches")
      .withDescription("How to search for matches of a person.")
      .applicableTo(PersonSearchRSImpl.class);
    ObjectFactory conclusionFactory = new ObjectFactory();

    Person searchedPerson1 = new Person();
    searchedPerson1.setId("98765");
    searchedPerson1.setPersistentId(URI.create("http://familysearch.org/persons/98765"));
    Name name = new Name();
    name.setKnownType(NameType.Name);
    name.setPrimaryForm(new NameForm());
    name.getPrimaryForm().setFullText("Israel Heaton");
    searchedPerson1.setNames(Arrays.asList(name));
    Person searchedPerson1Father = new Person();
    searchedPerson1Father.setNames(new ArrayList<Name>());
    name = new Name();
    name.setPrimaryForm(new NameForm());
    name.getPrimaryForm().setFullText("Jonathan Heaton");
    searchedPerson1Father.getNames().add(name);
    Person searchedPerson1Mother = new Person();
    searchedPerson1Mother.setNames(new ArrayList<Name>());
    name = new Name();
    name.setPrimaryForm(new NameForm());
    name.getPrimaryForm().setFullText("Clarissa Hoyt");
    searchedPerson1Mother.getNames().add(name);

    Person searchedPerson2 = new Person();
    searchedPerson2.setId("43210");
    searchedPerson2.setPersistentId(URI.create("http://familysearch.org/persons/43210"));
    name = new Name();
    name.setKnownType(NameType.Name);
    name.setPrimaryForm(new NameForm());
    name.getPrimaryForm().setFullText("Israel Hoyt Heaton");
    searchedPerson2.setNames(Arrays.asList(name));

    Feed serverSideSearchFeed = new Feed();
    URI feedId = URI.create("uuid:" + UUID.randomUUID().toString());
    serverSideSearchFeed.setId(feedId);
    serverSideSearchFeed.setItemsPerPage(2);
    serverSideSearchFeed.setStartIndex(0);
    serverSideSearchFeed.setTotalResults(2);
    serverSideSearchFeed.setTitle("Search Results for Israel Heaton");
    serverSideSearchFeed.setUpdated(new Date());
    serverSideSearchFeed.setEntries(new ArrayList<Entry>());

    Entry search1 = new Entry();
    search1.addExtensionElement(searchedPerson1);
    search1.setId(searchedPerson1.getPersistentId());
    search1.setScore(0.95F);
    search1.setUpdated(new Date());
    search1.addExtensionElement(conclusionFactory.createParentElement(searchedPerson1Father));
    search1.addExtensionElement(conclusionFactory.createParentElement(searchedPerson1Mother));
    serverSideSearchFeed.getEntries().add(search1);

    Entry search2 = new Entry();
    search2.addExtensionElement(searchedPerson2);
    search2.setId(searchedPerson2.getPersistentId());
    search2.setScore(0.95F);
    search2.setUpdated(new Date());
    serverSideSearchFeed.getEntries().add(search2);

    PersonService personService = getServerSideMock(PersonService.class);
    EnumMap<SearchParameter, String> params = new EnumMap<SearchParameter, String>(SearchParameter.class);
    params.put(SearchParameter.givenName, "Israel");
    params.put(SearchParameter.familyName, "Heaton");
    params.put(SearchParameter.fatherGivenName, "Jonathan");
    params.put(SearchParameter.fatherFamilyName, "Heaton");
    params.put(SearchParameter.motherGivenName, "Clarissa");
    params.put(SearchParameter.motherFamilyName, "Hoyt");
    expect(personService.searchForPersonMatches(params)).andReturn(serverSideSearchFeed);
    replay(personService);
    WebResource resource = resource().path("/search")
      .queryParam("resourceType", "person-matches")
      .queryParam("givenName", "Israel")
      .queryParam("familyName", "Heaton")
      .queryParam("fatherGivenName", "Jonathan")
      .queryParam("fatherFamilyName", "Heaton")
      .queryParam("motherGivenName", "Clarissa")
      .queryParam("motherFamilyName", "Hoyt");

    ClientResponse response = resource.accept(AtomModel.ATOM_XML_MEDIA_TYPE).get(ClientResponse.class);
    assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
    assertEquals(feedId, response.getEntity(Feed.class).getId());
    verify(personService);
    reset(personService);
  }

}
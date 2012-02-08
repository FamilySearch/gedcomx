package org.familysearch.ct.ws.rs.impl;

import com.sun.jersey.api.client.ClientResponse;
import org.familysearch.ct.ws.service.api.EntityBundle;
import org.familysearch.ct.ws.service.api.PersonService;
import org.gedcomx.atom.AtomModel;
import org.gedcomx.atom.Entry;
import org.gedcomx.atom.Feed;
import org.gedcomx.common.URI;
import org.gedcomx.conclusion.*;
import org.gedcomx.types.NameType;
import org.junit.Test;

import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.UUID;

import static org.easymock.EasyMock.*;
import static org.junit.Assert.assertEquals;

public class TestPersonMatchesRSImpl extends ConclusionTreeUseCaseTest {

  @Test
  public void testGet() throws Exception {
    createUseCase("Person Matches")
      .withDescription("How to get the matches for a person.")
      .applicableTo(PersonMatchesRSImpl.class);
    ObjectFactory conclusionFactory = new ObjectFactory();
    
    long timestamp = System.currentTimeMillis();
    Date now = new Date(timestamp - (timestamp % 1000));
    Person matchedPerson1 = new Person();
    matchedPerson1.setId("98765");
    matchedPerson1.setPersistentId(URI.create("http://familysearch.org/persons/98765"));
    Name name = new Name();
    name.setKnownType(NameType.Name);
    name.setPrimaryForm(new NameForm());
    name.getPrimaryForm().setFullText("Israel Heaton");
    matchedPerson1.setNames(Arrays.asList(name));
    Person matchedPerson1Father = new Person();
    matchedPerson1Father.setNames(new ArrayList<Name>());
    name = new Name();
    name.setPrimaryForm(new NameForm());
    name.getPrimaryForm().setFullText("Jonathan Heaton");
    matchedPerson1Father.getNames().add(name);
    Person matchedPerson1Mother = new Person();
    matchedPerson1Mother.setNames(new ArrayList<Name>());
    name = new Name();
    name.setPrimaryForm(new NameForm());
    name.getPrimaryForm().setFullText("Clarissa Hoyt");
    matchedPerson1Mother.getNames().add(name);

    Person matchedPerson2 = new Person();
    matchedPerson2.setId("43210");
    matchedPerson2.setPersistentId(URI.create("http://familysearch.org/persons/43210"));
    name = new Name();
    name.setKnownType(NameType.Name);
    name.setPrimaryForm(new NameForm());
    name.getPrimaryForm().setFullText("Israel Hoyt Heaton");
    matchedPerson2.setNames(Arrays.asList(name));

    Feed serverSideMatchFeed = new Feed();
    URI feedId = URI.create("uuid:" + UUID.randomUUID().toString());
    serverSideMatchFeed.setId(feedId);
    serverSideMatchFeed.setItemsPerPage(2);
    serverSideMatchFeed.setStartIndex(0);
    serverSideMatchFeed.setTotalResults(2);
    serverSideMatchFeed.setTitle("Matches for Israel Heaton");
    serverSideMatchFeed.setUpdated(new Date());
    serverSideMatchFeed.setEntries(new ArrayList<Entry>());

    Entry match1 = new Entry();
    match1.addExtensionElement(matchedPerson1);
    match1.setId(matchedPerson1.getPersistentId());
    match1.setScore(0.95F);
    match1.setUpdated(new Date());
    match1.addExtensionElement(conclusionFactory.createFatherElement(matchedPerson1Father));
    match1.addExtensionElement(conclusionFactory.createMotherElement(matchedPerson1Mother));
    serverSideMatchFeed.getEntries().add(match1);

    Entry match2 = new Entry();
    match2.addExtensionElement(matchedPerson2);
    match2.setId(matchedPerson2.getPersistentId());
    match2.setScore(0.95F);
    match2.setUpdated(new Date());
    serverSideMatchFeed.getEntries().add(match2);

    PersonService personService = getServerSideMock(PersonService.class);
    EntityBundle entity = createMock(EntityBundle.class);
    expect(personService.getPersonMatches("12345")).andReturn(entity);
    expect(entity.getLastModified()).andReturn(now);
    expect(entity.getEntity()).andReturn(serverSideMatchFeed);
    replay(personService, entity);
    ClientResponse response = resource().path("/persons/12345/matches").accept(AtomModel.ATOM_XML_MEDIA_TYPE).get(ClientResponse.class);
    assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
    assertEquals(now.getTime(), response.getLastModified().getTime());
    assertEquals(feedId, response.getEntity(Feed.class).getId());
    verify(personService, entity);
    reset(personService, entity);

    createUseCase("Caching The Person Matches")
      .withDescription("Example illustrating how the cacheing mechanism works on the person matches.")
      .applicableTo(PersonMatchesRSImpl.class);
    Date later = new Date(now.getTime() + (1000 * 60 * 60)); //one hour later
    expect(personService.getPersonMatches("12345")).andReturn(entity);
    expect(entity.getLastModified()).andReturn(now);
    replay(personService, entity);
    response = resource().path("/persons/12345/matches").accept(AtomModel.ATOM_XML_MEDIA_TYPE).header("If-Modified-Since", later).get(ClientResponse.class);
    assertEquals(Response.Status.NOT_MODIFIED.getStatusCode(), response.getStatus());
    verify(personService, entity);
    reset(personService, entity);
  }

  @Test
  public void testNotFound() {
    createUseCase("Person Matches Not Found")
      .withDescription("Example illustrating a request for person matches that don't exist.")
      .applicableTo(PersonMatchesRSImpl.class);
    PersonService personService = getServerSideMock(PersonService.class);
    EntityBundle entity = createMock(EntityBundle.class);
    expect(personService.getPersonMatches("NOTFOUND")).andReturn(null);
    replay(personService, entity);
    ClientResponse response = resource().path("/persons/NOTFOUND/matches").accept(AtomModel.ATOM_XML_MEDIA_TYPE).get(ClientResponse.class);
    assertEquals(Response.Status.NOT_FOUND.getStatusCode(), response.getStatus());
    verify(personService, entity);
    reset(personService, entity);
  }

}
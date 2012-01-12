package org.familysearch.ct.ws.rs.impl;

import com.sun.jersey.api.client.ClientResponse;
import org.familysearch.ct.ws.service.api.EntityBundle;
import org.familysearch.ct.ws.service.api.PersonService;
import org.gedcomx.conclusion.ConclusionModel;
import org.gedcomx.conclusion.Name;
import org.gedcomx.conclusion.NameForm;
import org.gedcomx.conclusion.Person;
import org.gedcomx.types.NameType;
import org.junit.Test;

import javax.ws.rs.core.Response;
import java.util.Arrays;
import java.util.Date;

import static org.easymock.EasyMock.*;
import static org.junit.Assert.assertEquals;

public class TestPersonSummaryRSImpl extends ConclusionTreeUseCaseTest {

  @Test
  public void testGet() throws Exception {
    createUseCase("Person Summary")
      .withDescription("How to get the person summary resource.")
      .applicableTo(PersonSummaryRSImpl.class);
    long timestamp = System.currentTimeMillis();
    Date now = new Date(timestamp - (timestamp % 1000));
    Person serverSidePerson = new Person();
    serverSidePerson.setId("12345");
    Name name = new Name();
    name.setKnownType(NameType.Name);
    name.setPreferred(true);
    name.setPrimaryForm(new NameForm());
    name.getPrimaryForm().setFullText("Israel Heaton");
    serverSidePerson.setNames(Arrays.asList(name));

    PersonService personService = getServerSideMock(PersonService.class);
    EntityBundle entity = createMock(EntityBundle.class);
    expect(personService.getPersonSummary("12345")).andReturn(entity);
    expect(entity.getLastModified()).andReturn(now);
    expect(entity.getEntity()).andReturn(serverSidePerson);
    replay(personService, entity);
    ClientResponse response = resource().path("/persons/12345/summary").accept(ConclusionModel.GEDCOMX_CONCLUSION_V1_XML_MEDIA_TYPE).get(ClientResponse.class);
    verify(personService, entity);
    reset(personService, entity);
    assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
    assertEquals(now.getTime(), response.getLastModified().getTime());
    assertEquals("12345", response.getEntity(Person.class).getId());

    createUseCase("Caching The Person Summary")
      .withDescription("Example illustrating how the cacheing mechanism works on the person summary.")
      .applicableTo(PersonSummaryRSImpl.class);
    Date later = new Date(now.getTime() + (1000 * 60 * 60)); //one hour later
    expect(personService.getPersonSummary("12345")).andReturn(entity);
    expect(entity.getLastModified()).andReturn(now);
    replay(personService, entity);
    response = resource().path("/persons/12345/summary").accept(ConclusionModel.GEDCOMX_CONCLUSION_V1_XML_MEDIA_TYPE).header("If-Modified-Since", later).get(ClientResponse.class);
    verify(personService, entity);
    reset(personService, entity);
    assertEquals(Response.Status.NOT_MODIFIED.getStatusCode(), response.getStatus());
  }

  @Test
  public void testNotFound() {
    createUseCase("Person Summary Not Found")
      .withDescription("Example illustrating a request for a person summary that doesn't exist.")
      .applicableTo(PersonSummaryRSImpl.class);
    PersonService personService = getServerSideMock(PersonService.class);
    EntityBundle entity = createMock(EntityBundle.class);
    expect(personService.getPersonSummary("NOTFOUND")).andReturn(null);
    replay(personService, entity);
    ClientResponse response = resource().path("/persons/NOTFOUND/summary").accept(ConclusionModel.GEDCOMX_CONCLUSION_V1_XML_MEDIA_TYPE).get(ClientResponse.class);
    verify(personService, entity);
    reset(personService, entity);
    assertEquals(Response.Status.NOT_FOUND.getStatusCode(), response.getStatus());
  }

}
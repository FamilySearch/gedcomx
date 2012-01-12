package org.familysearch.ct.ws.rs.impl;

import com.sun.jersey.api.client.ClientResponse;
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
      .withDescription("How to get the person summary resource.");
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

    expect(this.mockPersonService.getSummaryLastModified("12345")).andReturn(now);
    expect(this.mockPersonService.getSummary("12345")).andReturn(serverSidePerson);
    replay(this.mockPersonService);
    ClientResponse response = resource().path("/persons/12345/summary").accept(ConclusionModel.GEDCOMX_CONCLUSION_V1_XML_MEDIA_TYPE).get(ClientResponse.class);
    verify(this.mockPersonService);
    reset(this.mockPersonService);
    assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
    assertEquals(now.getTime(), response.getLastModified().getTime());
    assertEquals("12345", response.getEntity(Person.class).getId());
  }

}
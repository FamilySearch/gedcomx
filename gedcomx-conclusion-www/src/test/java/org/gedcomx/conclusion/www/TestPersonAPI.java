package org.gedcomx.conclusion.www;

import org.gedcomx.conclusion.Person;
import org.testng.annotations.Test;

import javax.ws.rs.WebApplicationException;

import static org.testng.AssertJUnit.assertEquals;

/**
 * @author Ryan Heaton
 */
@Test
public class TestPersonAPI {

  public void test501Responses() throws Exception {
    PersonRsd api = new PersonRsd() {};
    try {
      api.createPerson(new Person());
    }
    catch (WebApplicationException wae) {
      assertEquals(501, wae.getResponse().getStatus());
    }
    try {
      api.readPerson(null);
    }
    catch (WebApplicationException wae) {
      assertEquals(501, wae.getResponse().getStatus());
    }
    try {
      api.readPersonWWW(null);
    }
    catch (WebApplicationException wae) {
      assertEquals(501, wae.getResponse().getStatus());
    }
    try {
      api.updatePerson(null, new Person());
    }
    catch (WebApplicationException wae) {
      assertEquals(501, wae.getResponse().getStatus());
    }
    try {
      api.deletePerson(null);
    }
    catch (WebApplicationException wae) {
      assertEquals(501, wae.getResponse().getStatus());
    }
  }

}

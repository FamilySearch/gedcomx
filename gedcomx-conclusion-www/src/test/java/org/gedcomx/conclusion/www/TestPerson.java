package org.gedcomx.conclusion.www;

import org.gedcomx.conclusion.GenderType;
import org.gedcomx.www.Link;
import org.gedcomx.www.Links;
import org.testng.annotations.Test;

import java.net.URI;
import java.util.ArrayList;

import static org.gedcomx.conclusion.www.SerializationUtil.processThroughJson;
import static org.gedcomx.conclusion.www.SerializationUtil.processThroughXml;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

/**
 * @author Ryan Heaton
 */
@Test
public class TestPerson {

  /**
   * tests processing a WWW person through xml...
   */
  public void testWWWPersonXml() throws Exception {
    Person person = new Person();
    person.setGender(new Gender());
    person.getGender().setType(GenderType.male);
    ((Gender)person.getGender()).setLinks(new Links());
    ((Gender)person.getGender()).getLinks().setLinks(new ArrayList<Link>());
    Link link = new Link();
    link.setHref(URI.create("urn:gender"));
    ((Gender) person.getGender()).getLinks().getLinks().add(link);

    person = processThroughXml(person);
    assertEquals(GenderType.male, person.getGender().getType());
    assertTrue(person.getGender() instanceof Gender);
    assertEquals("urn:gender", ((Gender) person.getGender()).getLinks().getLinks().get(0).getHref().toString());

  }

  /**
   * tests processing a WWW person through json...
   */
  public void testWWWPersonJson() throws Exception {
    Person person = new Person();
    person.setGender(new Gender());
    person.getGender().setType(GenderType.male);
    ((Gender)person.getGender()).setLinks(new Links());
    ((Gender)person.getGender()).getLinks().setLinks(new ArrayList<Link>());
    Link link = new Link();
    link.setHref(URI.create("urn:gender"));
    ((Gender) person.getGender()).getLinks().getLinks().add(link);

    person = processThroughJson(person);
    assertEquals(GenderType.male, person.getGender().getType());
    assertTrue(person.getGender() instanceof Gender);
    assertEquals("urn:gender", ((Gender) person.getGender()).getLinks().getLinks().get(0).getHref().toString());
  }
  
  /**
   * tests serializing an instance of the www person to/from a "base" person via xml.
   */
  public void testWWWPersonToBasePersonViaXml() throws Exception {
    //todo: figure this out.
  }

  /**
   * tests serializing an instance of the www person to/from a "base" person via json.
   */
  public void testWWWPersonToBasePersonViaJson() throws Exception {
    //todo: figure this out.
  }


}

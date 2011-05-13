package org.gedcomx.conclusion.www;

import org.gedcomx.types.GenderType;
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
public class TestGender {

  /**
   * tests processing a WWW person through xml...
   */
  public void testWWWGenderXml() throws Exception {
    Gender gender = new Gender();
    gender.setType(GenderType.male);
    gender.setLinks(new Links());
    gender.getLinks().setLinks(new ArrayList<Link>());
    Link link = new Link();
    link.setHref(URI.create("urn:gender"));
    gender.getLinks().getLinks().add(link);

    gender = processThroughXml(gender);
    assertEquals(GenderType.male, gender.getType());
    assertEquals("urn:gender", gender.getLinks().getLinks().get(0).getHref().toString());

  }

  /**
   * tests processing a WWW person through json...
   */
  public void testWWWGenderJson() throws Exception {
    Gender gender = new Gender();
    gender.setType(GenderType.male);
    gender.setLinks(new Links());
    gender.getLinks().setLinks(new ArrayList<Link>());
    Link link = new Link();
    link.setHref(URI.create("urn:gender"));
    gender.getLinks().getLinks().add(link);

    gender = processThroughJson(gender);
    assertEquals(GenderType.male, gender.getType());
    assertEquals("urn:gender", gender.getLinks().getLinks().get(0).getHref().toString());
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

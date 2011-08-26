package org.gedcomx.conclusion.www;

import org.gedcomx.common.Extension;
import org.gedcomx.conclusion.Gender;
import org.gedcomx.types.GenderType;
import org.gedcomx.www.Link;
import org.testng.annotations.Test;

import javax.xml.bind.JAXBContext;
import java.net.URI;

import static org.gedcomx.rt.SerializationUtil.processThroughJson;
import static org.gedcomx.rt.SerializationUtil.processThroughXml;
import static org.testng.AssertJUnit.assertEquals;

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
    gender.setKnownType(GenderType.male);
    Link link = new Link();
    link.setHref(URI.create("urn:gender"));
    gender.setExtension(new Extension());
    gender.getExtension().addElement(link);

    gender = processThroughXml(gender, Gender.class, JAXBContext.newInstance(Gender.class, Link.class));
    assertEquals(GenderType.male, gender.getKnownType());
    assertEquals("urn:gender", gender.getExtension().findExtensionsOfType(Link.class).get(0).getHref().toString());
  }

  /**
   * tests processing a WWW person through json...
   */
  public void testWWWGenderJson() throws Exception {
    Gender gender = new Gender();
    gender.setKnownType(GenderType.male);
    Link link = new Link();
    link.setHref(URI.create("urn:gender"));
    gender.setExtension(new Extension());
    gender.getExtension().addElement(link);

    gender = processThroughJson(gender);
    assertEquals(GenderType.male, gender.getKnownType());
    assertEquals("urn:gender", gender.getExtension().findExtensionsOfType(Link.class).get(0).getHref().toString());
  }
  
}

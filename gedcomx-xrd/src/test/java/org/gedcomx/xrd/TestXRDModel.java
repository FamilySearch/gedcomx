package org.gedcomx.xrd;

import org.testng.annotations.Test;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.util.JAXBSource;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.InputStream;
import java.net.URI;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.gedcomx.rt.SerializationUtil.processThroughXml;
import static org.gedcomx.rt.SerializationUtil.toXmlStream;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertNotNull;

/**
 * @author Mike Gardiner
 */

@Test
public class TestXRDModel {

  public void testGenerateXRD() throws Exception {
    final URI subject = new URI("http://gedcomx.com/xrd/test");
    final Date expires = new Date();

    // Lists
    final List<URI> aliases = new ArrayList<URI>();
    final URI alias1 = new URI("http://www.one.com");
    final URI alias2 = new URI("http://www.two.com");
    aliases.add(alias1);
    aliases.add(alias2);

    // Links
    final List<Link> links = new ArrayList<Link>();

    final Link link1 = new Link();
    link1.setRel(new URI("test1"));
    link1.setHref(new URI("http://www.test.com/one"));
    links.add(link1);

    final Link link2 = new Link();
    link2.setRel(new URI("test2"));
    link2.setHref(new URI("http://www.test.com/two"));
      
    Title title = new Title();
    title.setLang("en");
    title.setValue("Title1");
    link2.getTitles().add(title);
      
    Title noLangTitle = new Title();
    noLangTitle.setValue("No Lang Attribute");
    link2.getTitles().add(noLangTitle);
      
    Property prop1 = new Property();
    prop1.setType(new URI("http://wwww.test.com/test"));
    prop1.setValue("test");
    link2.getProperties().add(prop1);
    links.add(link2);

    // Properties
    final List<Property> properties = new ArrayList<Property>();
    final Property property1 = new Property();
    property1.setType(new URI("http://example.com/property1"));
    property1.setValue("property1");
    properties.add(property1);

    final Property property2 = new Property();
    property2.setType(new URI("http://example.com/property2"));
    property2.setValue("property2");
    properties.add(property2);

    // Now build the XRD Model
    XRD xrd = new XRD();
    xrd.setSubject(subject);
    xrd.setExpires(expires);
    xrd.setAliases(aliases);
    xrd.setLinks(links);
    xrd.setProperties(properties);

    xrd = processThroughXml(xrd);

    // Subject
    assertNotNull(xrd.getSubject());
    assertEquals(xrd.getSubject(), subject);

    // Expires
    assertNotNull(xrd.getExpires());
    assertEquals(xrd.getExpires(), expires);

    // Aliases
    assertNotNull(xrd.getAliases());
    assertEquals(xrd.getAliases().get(0), alias1);
    assertEquals(xrd.getAliases().get(1), alias2);

    // Links
    assertNotNull(xrd.getLinks());
    assertEquals(xrd.getLinks().get(0).getRel().getPath(), "test1");
    assertEquals(xrd.getLinks().get(1).getRel().getPath(), "test2");

    // Properties
    assertNotNull(xrd.getProperties());
    assertEquals(xrd.getProperties().get(0).getValue(), "property1");
    assertEquals(xrd.getProperties().get(1).getValue(), "property2");

    String xml = new String(toXmlStream(xrd));
    System.out.print(xml);

    // Validate against XSD
    SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
    InputStream is = this.getClass().getResourceAsStream("/xrd-1.0-os.xsd");
    Schema schema = sf.newSchema(new StreamSource(is));
    Validator validator = schema.newValidator();
    JAXBContext context = JAXBContext.newInstance(XRD.class);
    validator.validate(new JAXBSource(context, xrd));
  }
}

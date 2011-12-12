package org.gedcomx.xrd;

import org.testng.annotations.Test;
import java.net.URI;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.gedcomx.rt.SerializationUtil.processThroughXml;
import static org.gedcomx.rt.SerializationUtil.toXmlStream;

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
    assert xrd.getSubject() != null;
    assert xrd.getSubject().equals(subject);

    // Expires
    assert xrd.getExpires() != null;
    assert xrd.getExpires().equals(expires);

    // Aliases
    assert xrd.getAliases() != null;
    assert xrd.getAliases().get(0).equals(alias1);
    assert xrd.getAliases().get(1).equals(alias2);

    // Links
    assert xrd.getLinks() != null;
    assert xrd.getLinks().get(0).getRel().getPath().equals("test1");
    assert xrd.getLinks().get(1).getRel().getPath().equals("test2");

    // Properties
    assert xrd.getProperties() != null;
    assert xrd.getProperties().get(0).getValue().equals("property1");
    assert xrd.getProperties().get(1).getValue().equals("property2");

    byte[] bytes = toXmlStream(xrd);
    System.out.print(new String(bytes));
  }
}

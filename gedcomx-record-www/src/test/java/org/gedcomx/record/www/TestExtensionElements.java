package org.gedcomx.record.www;

import org.gedcomx.record.Characteristic;
import org.gedcomx.record.Extension;
import org.gedcomx.www.Link;
import org.gedcomx.www.Links;
import org.testng.annotations.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.bind.JAXBContext;
import javax.xml.parsers.DocumentBuilderFactory;
import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;

import static org.gedcomx.rt.SerializationUtil.processThroughXml;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertNotNull;
import static org.testng.AssertJUnit.assertTrue;

/**
 * @author Ryan Heaton
 */
@Test
public class TestExtensionElements {

  public void testCharacteristicTypes() throws Exception {

    Characteristic ch = new Characteristic();
    ch.setId("id");

    Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
    Element el1 = doc.createElementNS("urn:test", "test1");
    Element el2 = doc.createElementNS("urn:test", "test2");
    Element el3 = doc.createElementNS("urn:test2", "test3");
    Links links = new Links();
    Link link = new Link();
    link.setHref(URI.create("urn:somehref"));
    links.setLinks(Arrays.asList(link));
    ArrayList<Object> extensions = new ArrayList<Object>();
    extensions.add(el1);
    extensions.add(el2);
    extensions.add(el3);
    extensions.add(links);
    ch.setExtension(new Extension());
    ch.getExtension().setElements(extensions);

    JAXBContext context = JAXBContext.newInstance(Characteristic.class, Links.class);
    ch = processThroughXml(ch, Characteristic.class, context);
    assertEquals("id", ch.getId());
    assertEquals(4, ch.getExtension().getElements().size());
    assertTrue(ch.getExtension().getElements().get(0) instanceof Element);
    assertEquals("urn:test", ((Element) ch.getExtension().getElements().get(0)).getNamespaceURI());
    assertEquals("test1", ((Element) ch.getExtension().getElements().get(0)).getLocalName());
    assertEquals("urn:test", ((Element) ch.getExtension().getElements().get(1)).getNamespaceURI());
    assertEquals("test2", ((Element) ch.getExtension().getElements().get(1)).getLocalName());
    assertEquals("urn:test2", ((Element) ch.getExtension().getElements().get(2)).getNamespaceURI());
    assertEquals("test3", ((Element) ch.getExtension().getElements().get(2)).getLocalName());
    assertTrue(ch.getExtension().getElements().get(3) instanceof Links);
    assertEquals(1, ((Links) ch.getExtension().getElements().get(3)).getLinks().size());
    assertEquals("urn:somehref", ((Links)ch.getExtension().getElements().get(3)).getLinks().get(0).getHref().toString());

    links = ch.getExtension().findExtensionOfType(Links.class);
    assertNotNull(links);

    assertEquals(1, ch.getExtension().findExtensionsOfType(Links.class).size());

  }
}

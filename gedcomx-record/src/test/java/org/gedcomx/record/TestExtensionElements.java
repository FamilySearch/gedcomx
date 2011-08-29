package org.gedcomx.record;

import org.testng.annotations.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilderFactory;
import java.util.ArrayList;

import static org.gedcomx.rt.SerializationUtil.processThroughXml;
import static org.testng.AssertJUnit.assertEquals;
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
    ArrayList<Object> extensions = new ArrayList<Object>();
    extensions.add(el1);
    extensions.add(el2);
    extensions.add(el3);
    ch.setExtensionElements(extensions);

    ch = processThroughXml(ch);
    assertEquals("id", ch.getId());
    assertEquals(3, ch.getExtensionElements().size());
    assertTrue(ch.getExtensionElements().get(0) instanceof Element);
    assertEquals("urn:test", ((Element) ch.getExtensionElements().get(0)).getNamespaceURI());
    assertEquals("test1", ((Element) ch.getExtensionElements().get(0)).getLocalName());
    assertEquals("urn:test", ((Element) ch.getExtensionElements().get(1)).getNamespaceURI());
    assertEquals("test2", ((Element) ch.getExtensionElements().get(1)).getLocalName());
    assertEquals("urn:test2", ((Element) ch.getExtensionElements().get(2)).getNamespaceURI());
    assertEquals("test3", ((Element) ch.getExtensionElements().get(2)).getLocalName());

  }
}

package org.gedcomx.common;

import org.gedcomx.types.SourceType;
import org.testng.annotations.Test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;
import java.net.URI;
import java.util.ArrayList;

import static org.gedcomx.rt.SerializationUtil.processThroughJson;
import static org.gedcomx.rt.SerializationUtil.processThroughXml;
import static org.testng.AssertJUnit.assertEquals;

/**
 * @author Ryan Heaton
 */
@Test
public class TestSourceReference {

  /**
   * tests source reference xml
   */
  public void testSourceReferenceXml() throws Exception {
    SourceReference reference = new SourceReference();
    reference.setHref(URI.create("urn:someid"));
    reference.setKnownType(SourceType.collection);
    reference.setId("refid");
    reference.setQualifiers(new ArrayList<SourceQualifier>());
    SourceQualifier q = new SourceQualifier();
    q.setAttribute(SourceQualifierAttribute.height_pixels, "1234");
    reference.getQualifiers().add(q);
    reference.setExtension(new Extension());
    reference.getExtension().addElement(new CustomElement("alt"));
    CustomElement custom = new CustomElement();
    custom.setSource(reference);
    custom = processThroughXml(custom);
    assertEquals("urn:someid", custom.getSource().getHref().toString());
    assertEquals(SourceType.collection, custom.getSource().getKnownType());
    assertEquals("refid", custom.getSource().getId());
    assertEquals("1234", custom.getSource().getQualifiers().get(0).getAttribute(SourceQualifierAttribute.height_pixels));
    assertEquals("alt", ((CustomElement) custom.getSource().getExtension().getElements().get(0)).getId());
  }

  /**
   * tests source reference json
   */
  public void testSourceReferenceJson() throws Exception {
    SourceReference reference = new SourceReference();
    reference.setHref(URI.create("urn:someid"));
    reference.setKnownType(SourceType.collection);
    reference.setId("refid");
    reference.setQualifiers(new ArrayList<SourceQualifier>());
    SourceQualifier q = new SourceQualifier();
    q.setAttribute(SourceQualifierAttribute.height_pixels, "1234");
    reference.getQualifiers().add(q);
    reference.setExtension(new Extension());
    reference.getExtension().addElement(new CustomElement("alt"));
    CustomElement custom = new CustomElement();
    custom.setSource(reference);
    custom = processThroughJson(custom);
    assertEquals("urn:someid", custom.getSource().getHref().toString());
    assertEquals(SourceType.collection, custom.getSource().getKnownType());
    assertEquals("refid", custom.getSource().getId());
    assertEquals("1234", custom.getSource().getQualifiers().get(0).getAttribute(SourceQualifierAttribute.height_pixels));
    assertEquals("alt", ((CustomElement) custom.getSource().getExtension().getElements().get(0)).getId());
  }

}

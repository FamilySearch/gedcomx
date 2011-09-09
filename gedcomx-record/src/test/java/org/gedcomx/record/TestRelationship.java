package org.gedcomx.record;

import org.codehaus.jackson.node.ObjectNode;
import org.gedcomx.rt.CommonNamespaces;
import org.gedcomx.types.RelationshipType;
import org.testng.annotations.Test;
import org.w3c.dom.Document;

import java.net.URI;

import static org.gedcomx.rt.SerializationUtil.toJsonNode;
import static org.gedcomx.rt.SerializationUtil.toXmlDom;
import static org.testng.AssertJUnit.*;

/**
 * @author Ryan Heaton
 */
@Test
public class TestRelationship {

  public void testSerializationOfRelationshipType() throws Exception {
    Relationship cr = new Relationship();
    cr.setKnownType(RelationshipType.Couple);
    cr.setId("id");
    Document dom = toXmlDom(cr);
    assertNotNull(dom.getDocumentElement().getAttributeNodeNS(CommonNamespaces.GEDCOMX_COMMON_NAMESPACE, "type"));
    assertEquals(0, dom.getDocumentElement().getElementsByTagNameNS(CommonNamespaces.GEDCOMX_COMMON_NAMESPACE, "type").getLength());

    ObjectNode node = toJsonNode(cr);
    assertNotNull(node.get("type"));
    
    Relationship or = new Relationship();
    or.setId("id");
    or.setType(URI.create("urn:custom#custom"));
    dom = toXmlDom(or);
    assertNotNull(dom.getDocumentElement().getAttributeNodeNS(CommonNamespaces.GEDCOMX_COMMON_NAMESPACE, "type"));
    assertEquals(0, dom.getDocumentElement().getElementsByTagNameNS(CommonNamespaces.GEDCOMX_COMMON_NAMESPACE, "type").getLength());

    node = toJsonNode(or);
    assertNotNull(node.get("type"));
  }
}

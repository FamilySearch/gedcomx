package org.gedcomx.metadata.foaf;

import org.gedcomx.metadata.CustomEntity;
import org.gedcomx.rt.SerializationUtil;
import org.gedcomx.rt.json.GedcomJsonProvider;
import org.testng.annotations.Test;

import javax.xml.bind.JAXBContext;
import javax.xml.namespace.QName;

import static org.testng.Assert.assertEquals;


public class AgentTest {
  private static final QName qnameAttrib1 = new QName("altAttribNS", "attrib1");
  private static final QName qnameAttrib2 = new QName("altAttribNS", "attrib2");
  private static final QName qnameAttrib3 = new QName("altAttribNS", "attrib3");

  @Test
  public void testExtensionsThruXML() throws Exception {
    Agent agent = new Organization();
    agent.setId("1234");
    agent.addExtensionAttribute(qnameAttrib1, "attVal1");
    agent.addExtensionAttribute(qnameAttrib2, "attVal2");
    agent.addExtensionElement(new CustomEntity("4321"));
    agent.addExtensionElement(new CustomEntity("5432"));
    agent.getExtensionElements().add(new CustomEntity("6543"));
    agent = SerializationUtil.processThroughXml(agent, Organization.class, JAXBContext.newInstance(Organization.class, CustomEntity.class));
    assertEquals(agent.getExtensionElements().size(), 3);
    assertEquals(agent.findExtensionOfType(CustomEntity.class).getId(), "4321");
    assertEquals(agent.findExtensionsOfType(String.class).size(), 0);
    assertEquals(agent.findExtensionsOfType(CustomEntity.class).size(), 3);
    assertEquals(agent.findExtensionsOfType(CustomEntity.class).get(1).getId(), "5432");
    assertEquals(((CustomEntity)agent.getExtensionElements().get(2)).getId(), "6543");
  }

  @Test
  public void testExtensionsThruJSON() throws Exception {
    Agent agent = new Organization();
    agent.setId("1234");
    agent.addExtensionAttribute(qnameAttrib1, "attVal1");
    agent.addExtensionAttribute(qnameAttrib2, "attVal2");
    agent.addExtensionElement(new CustomEntity("4321"));
    agent.addExtensionElement(new CustomEntity("5432"));
    agent.getExtensionElements().add(new CustomEntity("6543"));
    agent = SerializationUtil.processThroughJson(agent, Organization.class, GedcomJsonProvider.createObjectMapper(Organization.class, CustomEntity.class));
    assertEquals(agent.getExtensionElements().size(), 3);
    assertEquals(agent.findExtensionOfType(CustomEntity.class).getId(), "4321");
    assertEquals(agent.findExtensionsOfType(String.class).size(), 0);
    assertEquals(agent.findExtensionsOfType(CustomEntity.class).size(), 3);
    assertEquals(agent.findExtensionsOfType(CustomEntity.class).get(1).getId(), "5432");
    assertEquals(agent.findExtensionsOfType(CustomEntity.class).get(2).getId(), "6543");
  }
}

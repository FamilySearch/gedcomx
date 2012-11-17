package org.gedcomx.links;

import org.gedcomx.common.URI;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static org.gedcomx.rt.SerializationUtil.processThroughJson;
import static org.gedcomx.rt.SerializationUtil.processThroughXml;
import static org.testng.AssertJUnit.assertEquals;

/**
 * @author Ryan Heaton
 */
@Test
public class HypermediaConrollableDataTest {

  /**
   * tests link xml
   */
  public void testDataXml() throws Exception {
    CustomData data = createData();
    data = processThroughXml(data);
    assertLink(data);
  }

  /**
   * tests link json
   */
  public void testDataJson() throws Exception {
    CustomData data = createData();
    data = processThroughJson(data);
    assertLink(data);
  }

  private void assertLink(CustomData data) {
    assertEquals(3, data.getLinkExtensions().size());
    assertEquals("href1", data.getLinkExtension("rel1").getHref().toString());
    assertEquals("template1", data.getLinkExtensions("rel1").get(1).getTemplate());
    assertEquals("href3", data.getLinkExtension("rel2").getHref().toString());
  }

  private CustomData createData() {
    CustomData data = new CustomData();
    data.setLinkExtensions(new ArrayList<Link>());
    data.addLinkExtension("rel1", URI.create("href1"));
    data.addTemplatedLinkExtension("rel1", "template1");
    data.getLinkExtensions().add(new Link("rel2", URI.create("href3")));
    return data;
  }

}

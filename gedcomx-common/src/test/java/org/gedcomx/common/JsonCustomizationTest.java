package org.gedcomx.common;

import org.gedcomx.rt.GedcomNamespaceManager;
import org.testng.annotations.Test;

import javax.xml.bind.JAXBContext;
import java.util.ArrayList;
import java.util.List;

import static org.gedcomx.rt.SerializationUtil.processThroughJson;
import static org.gedcomx.rt.SerializationUtil.processThroughXml;
import static org.testng.AssertJUnit.assertEquals;

/**
 * @author Ryan Heaton
 */
@Test
public class JsonCustomizationTest {

  /**
   * tests source reference xml
   */
  public void testKeyedItemsXml() throws Exception {
    CustomEntity custom = new CustomEntity();
    custom.setRefToSomething(new org.gedcomx.common.URI("uri:hello"));
    custom.setKeyedItems(new ArrayList<CustomKeyedItem>());
    CustomKeyedItem item1 = new CustomKeyedItem();
    item1.setVal1("1");
    item1.setVal2("2");
    String key1 = item1.getKey();
    custom.getKeyedItems().add(item1);
    CustomKeyedItem item2 = new CustomKeyedItem();
    item2.setVal1("one");
    item2.setVal2("two");
    String key2 = item2.getKey();
    custom.getKeyedItems().add(item2);
    custom = processThroughXml(custom);
    assertEquals("uri:hello", custom.getRefToSomething().toString());
    assertEquals(2, custom.getKeyedItems().size());
    assertEquals("1", custom.getKeyedItems().get(0).getVal1());
    assertEquals("2", custom.getKeyedItems().get(0).getVal2());
    assertEquals(key1, custom.getKeyedItems().get(0).getKey());
    assertEquals("one", custom.getKeyedItems().get(1).getVal1());
    assertEquals("two", custom.getKeyedItems().get(1).getVal2());
    assertEquals(key2, custom.getKeyedItems().get(1).getKey());
  }

  /**
   * tests source reference json
   */
  public void testKeyedItemsJson() throws Exception {
    CustomEntity custom = new CustomEntity();
    custom.setRefToSomething(new org.gedcomx.common.URI("uri:hello"));
    custom.setKeyedItems(new ArrayList<CustomKeyedItem>());
    CustomKeyedItem item1 = new CustomKeyedItem();
    item1.setVal1("1");
    item1.setVal2("2");
    String key1 = item1.getKey();
    custom.getKeyedItems().add(item1);
    CustomKeyedItem item2 = new CustomKeyedItem();
    item2.setVal1("one");
    item2.setVal2("two");
    String key2 = item2.getKey();
    custom.getKeyedItems().add(item2);
    custom = processThroughJson(custom);
    assertEquals("uri:hello", custom.getRefToSomething().toString());
    assertEquals(2, custom.getKeyedItems().size());
    assertEquals("1", custom.getKeyedItems().get(0).getVal1());
    assertEquals("2", custom.getKeyedItems().get(0).getVal2());
    assertEquals(key1, custom.getKeyedItems().get(0).getKey());
    assertEquals("one", custom.getKeyedItems().get(1).getVal1());
    assertEquals("two", custom.getKeyedItems().get(1).getVal2());
    assertEquals(key2, custom.getKeyedItems().get(1).getKey());
  }

  public void testKeyedItemsAsExtensionsXml() throws Exception {
    ResourceSet set = new ResourceSet();
    CustomKeyedItem item1 = new CustomKeyedItem();
    item1.setVal1("1");
    item1.setVal2("2");
    String key1 = item1.getKey();
    set.addExtensionElement(item1);
    CustomKeyedItem item2 = new CustomKeyedItem();
    item2.setVal1("one");
    item2.setVal2("two");
    String key2 = item2.getKey();
    set.addExtensionElement(item2);
    set = processThroughXml(set, ResourceSet.class, JAXBContext.newInstance(ResourceSet.class, CustomKeyedItem.class));
    List<CustomKeyedItem> keyedItems = set.findExtensionsOfType(CustomKeyedItem.class);
    assertEquals(2, keyedItems.size());
    assertEquals("1", keyedItems.get(0).getVal1());
    assertEquals("2", keyedItems.get(0).getVal2());
    assertEquals(key1, keyedItems.get(0).getKey());
    assertEquals("one", keyedItems.get(1).getVal1());
    assertEquals("two", keyedItems.get(1).getVal2());
    assertEquals(key2, keyedItems.get(1).getKey());
  }

  public void testKeyedItemsAsExtensionsJson() throws Exception {
    ResourceSet set = new ResourceSet();
    CustomKeyedItem item1 = new CustomKeyedItem();
    item1.setVal1("1");
    item1.setVal2("2");
    String key1 = item1.getKey();
    set.addExtensionElement(item1);
    CustomKeyedItem item2 = new CustomKeyedItem();
    item2.setVal1("one");
    item2.setVal2("two");
    String key2 = item2.getKey();
    set.addExtensionElement(item2);
    GedcomNamespaceManager.registerKnownJsonType(CustomKeyedItem.class);
    set = processThroughJson(set);
    List<CustomKeyedItem> keyedItems = set.findExtensionsOfType(CustomKeyedItem.class);
    assertEquals(2, keyedItems.size());
    assertEquals("1", keyedItems.get(0).getVal1());
    assertEquals("2", keyedItems.get(0).getVal2());
    assertEquals(key1, keyedItems.get(0).getKey());
    assertEquals("one", keyedItems.get(1).getVal1());
    assertEquals("two", keyedItems.get(1).getVal2());
    assertEquals(key2, keyedItems.get(1).getKey());
  }

}

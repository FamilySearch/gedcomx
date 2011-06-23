package org.gedcomx.metadata.dc;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Date;

import static org.gedcomx.rt.SerializationUtil.processThroughXml;
import static org.testng.AssertJUnit.assertEquals;

/**
 * @author Ryan Heaton
 */
@Test
public class TestDublinCoreMetadata {

  /**
   * tests alternate id xml
   */
  public void testDublinCoreMetadataXml() throws Exception {
    DublinCoreMetadata metadata = new DublinCoreMetadata();
    metadata.setTitle(new ArrayList<DublinCoreStringProperty>());
    DublinCoreStringProperty titleProperty = new DublinCoreStringProperty();
    titleProperty.setValue("title");
    metadata.getTitle().add(titleProperty);
    metadata.setDate(new ArrayList<DublinCoreDateProperty>());
    DublinCoreDateProperty dateProperty = new DublinCoreDateProperty();
    Date now = new Date();
    dateProperty.setValue(now);
    metadata.getDate().add(dateProperty);
    metadata.setType(new ArrayList<DublinCoreTypeProperty>());
    DublinCoreTypeProperty typeProperty = new DublinCoreTypeProperty();
    typeProperty.setKnownValue(DublinCoreType.Collection);
    metadata.getType().add(typeProperty);

    metadata = processThroughXml(metadata);
    assertEquals("title", metadata.getTitle().get(0).getValue());
    assertEquals(now, metadata.getDate().get(0).getValue());
    assertEquals(DublinCoreType.Collection, metadata.getType().get(0).getKnownValue());
  }

  /**
   * tests alternate id json
   */
  public void testDublinCoreMetadataJson() throws Exception {
    //todo: fill in dc metadata tests.
  }

}

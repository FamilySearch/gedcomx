package org.gedcomx.record;

import org.testng.annotations.Test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;
import javax.xml.transform.stream.StreamSource;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.net.URI;

import static org.testng.AssertJUnit.assertEquals;

/**
 * @author Ryan Heaton
 */
@Test
public class TestRecord {

  /**
   * Tests referencing a collection.
   */
  public void testCollectionRef() throws Exception {
    Record record = new Record();
    CollectionReference collectionReference = new CollectionReference();
    collectionReference.setHref(URI.create("urn:hello"));
    record.setCollection(collectionReference);
    ByteArrayOutputStream out = new ByteArrayOutputStream();
    JAXBContext jaxbContext = JAXBContext.newInstance(Record.class);
    jaxbContext.createMarshaller().marshal(new JAXBElement<Record>(new QName(RecordConstants.GEDCOMX_RECORD_NAMESPACE, "record"), Record.class, record), out);
//    System.out.println(out.toString("utf-8"));
    record = jaxbContext.createUnmarshaller().unmarshal(new StreamSource(new ByteArrayInputStream(out.toByteArray())), Record.class).getValue();
    assertEquals("urn:hello", record.getCollection().getHref().toString());
  }

}

package org.gedcomx.fileformat;

import org.gedcomx.common.Extension;
import org.gedcomx.conclusion.ConclusionNamespaces;
import org.gedcomx.conclusion.Person;
import org.gedcomx.conclusion.PersonReference;
import org.gedcomx.conclusion.Relationship;
import org.gedcomx.record.Record;
import org.gedcomx.record.RecordNamespaces;
import org.gedcomx.types.RelationshipType;
import org.gedcomx.www.Link;
import org.testng.annotations.Test;

import javax.mail.BodyPart;
import javax.mail.internet.MimeMultipart;
import javax.mail.util.ByteArrayDataSource;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.ByteArrayOutputStream;
import java.net.URI;

import static org.testng.AssertJUnit.*;

/**
 * @author Ryan Heaton
 */
@Test
public class TestJerseyMultipartGedcomxFileWriter {

  /**
   * tests the builder methods for the writer.
   */
  public void testBuilder() throws Exception {
    JerseyMultipartGedcomxFileWriter writer = new JerseyMultipartGedcomxFileWriter();
    com.sun.jersey.multipart.BodyPart bp = new com.sun.jersey.multipart.BodyPart();
    try {
      writer.part(bp);
      fail();
    }
    catch (IllegalArgumentException e) {
    }

    bp.getHeaders().putSingle("Content-ID", "12345");
    try {
      writer.part(bp);
      fail();
    }
    catch (IllegalArgumentException e) {
    }

    bp.setMediaType(MediaType.APPLICATION_JSON_TYPE);
    try {
      writer.part(bp);
      fail();
    }
    catch (IllegalArgumentException e) {
    }

    bp.setEntity(new Object());
    writer.part(bp); //success.

    try {
      writer.header("X-Custom", "value");
      fail();
    }
    catch (IllegalArgumentException e) {

    }

    writer.header("Content-Description", "Description");
  }

  /**
   * Tests the basic structure of the format...
   */
  public void testSimpleTextPartWriter() throws Exception {
    JerseyMultipartGedcomxFileWriter writer = new JerseyMultipartGedcomxFileWriter();
    String plainCid = writer.addPart("text/plain", "here is some plain text");
    String htmlCid = writer.addPart("text/html", "<b>here</b> is some html text");
    ByteArrayOutputStream out = new ByteArrayOutputStream();
    writer.writeTo(out);

    //now parse it and test it using standard multipart
    MimeMultipart message = new MimeMultipart(new ByteArrayDataSource(out.toByteArray(), "multipart/parallel"));
    BodyPart plainBp = message.getBodyPart("<" + plainCid + ">");
    assertNotNull(plainBp);
    assertEquals("text/plain", plainBp.getContentType());
    assertEquals("here is some plain text", plainBp.getContent());
    BodyPart htmlBp = message.getBodyPart("<" + htmlCid + ">");
    assertNotNull(htmlBp);
    assertEquals("text/html", htmlBp.getContentType());
    assertEquals("<b>here</b> is some html text", htmlBp.getContent());
  }
  
  /**
   * Tests writing more complex objects.
   */
  public void testWriteMoreComplexObjects() throws Exception {
    JerseyMultipartGedcomxFileWriter writer = new JerseyMultipartGedcomxFileWriter(Record.class, Person.class, Relationship.class, Link.class);

    Record record = new Record();
    URI recordPersistentId = URI.create("record_pid");
    record.setPersistentId(recordPersistentId);
    record.setExtension(new Extension());
    Link link = new Link();
    link.setHref(URI.create("urn:some-source"));
    record.getExtension().addElement(link);
    String cid = writer.addPart(RecordNamespaces.GEDCOMX_RECORD_XML_MEDIA_TYPE, record);
    record.setId(cid);

    Person person = new Person();
    URI personPersistentId = URI.create("person_pid");
    person.setPersistentId(personPersistentId);
    cid = writer.addPart(ConclusionNamespaces.GEDCOMX_CONCLUSION_XML_MEDIA_TYPE, person);
    person.setId(cid);
    
    Relationship relationship = new Relationship();
    URI relationshipPersistentId = URI.create("relationship_pid");
    relationship.setPersistentId(relationshipPersistentId);
    relationship.setPerson1(new PersonReference());
    relationship.getPerson1().setHref(URI.create("cid:" + person.getId()));
    cid = writer.addPart(ConclusionNamespaces.GEDCOMX_CONCLUSION_XML_MEDIA_TYPE, relationship);
    relationship.setKnownType(RelationshipType.couple);
    relationship.setId(cid);

    ByteArrayOutputStream out = new ByteArrayOutputStream();
    writer.writeTo(out);
    //writer.writeTo(System.out);
    
    //now parse it and test it using standard multipart
    Unmarshaller unmarshaller = JAXBContext.newInstance(Record.class, Person.class, Relationship.class, Link.class).createUnmarshaller();
    MimeMultipart message = new MimeMultipart(new ByteArrayDataSource(out.toByteArray(), "multipart/parallel"));
    BodyPart recordPart = message.getBodyPart("<" + record.getId() + ">");
    assertNotNull(recordPart);
    assertEquals(RecordNamespaces.GEDCOMX_RECORD_XML_MEDIA_TYPE, recordPart.getContentType());
    record = (Record) unmarshaller.unmarshal(recordPart.getDataHandler().getInputStream());
    assertEquals(recordPersistentId, record.getPersistentId());
    assertNotNull(record.getExtension());
    assertEquals(link.getHref(), record.getExtension().findExtensionOfType(Link.class).getHref());
    
    BodyPart personPart = message.getBodyPart("<" + person.getId() + ">");
    assertNotNull(personPart);
    assertEquals(ConclusionNamespaces.GEDCOMX_CONCLUSION_XML_MEDIA_TYPE, personPart.getContentType());
    person = (Person) unmarshaller.unmarshal(personPart.getDataHandler().getInputStream());
    assertEquals(personPersistentId, person.getPersistentId());

    BodyPart relationshipPart = message.getBodyPart("<" + relationship.getId() + ">");
    assertNotNull(relationshipPart);
    assertEquals(ConclusionNamespaces.GEDCOMX_CONCLUSION_XML_MEDIA_TYPE, relationshipPart.getContentType());
    relationship = (Relationship) unmarshaller.unmarshal(relationshipPart.getDataHandler().getInputStream());
    assertEquals(relationshipPersistentId, relationship.getPersistentId());
    assertNotNull(relationship.getPerson1());
    assertEquals(RelationshipType.couple, relationship.getKnownType());
    URI href = relationship.getPerson1().getHref();
    assertEquals("relationship should be referencing the person", person.getId(), href.getSchemeSpecificPart());
  }

  /**
   * tests the notion of gzipping parts of the message.
   */
  public void testGZippedParts() throws Exception {
    //todo: try it out.
  }

}

package org.gedcomx.fileformat;

import com.sun.jersey.multipart.Boundary;
import org.codehaus.jackson.map.ObjectMapper;
import org.gedcomx.common.Extension;
import org.gedcomx.conclusion.ConclusionNamespaces;
import org.gedcomx.conclusion.Person;
import org.gedcomx.conclusion.PersonReference;
import org.gedcomx.conclusion.Relationship;
import org.gedcomx.record.Record;
import org.gedcomx.record.RecordNamespaces;
import org.gedcomx.www.Link;
import org.jvnet.mimepull.MIMEConfig;
import org.jvnet.mimepull.MIMEMessage;
import org.jvnet.mimepull.MIMEPart;
import org.testng.annotations.Test;

import javax.activation.DataHandler;
import javax.mail.Session;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.util.ByteArrayDataSource;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.io.*;
import java.net.URI;
import java.util.Collection;
import java.util.Properties;
import java.util.UUID;
import java.util.zip.GZIPOutputStream;

import static org.testng.AssertJUnit.*;

/**
 * @author Ryan Heaton
 */
@Test
public class TestJerseyMultipartGedcomxFileReader {

  /**
   * tests the behavior of MIMEMessage
   */
  public void testMimeMessageBehavior() throws Exception {
    String messageBody = "------=_Part_0_1666903383.1311712876195\n" +
      "Content-Type: text/plain; charset=us-ascii\n" +
      "Content-Transfer-Encoding: 7bit\n" +
      "Content-ID: e230b1be-ee07-46bb-9cd2-31a6865f5cce\n" +
      "\n" +
      "here is some plain text\n" +
      "------=_Part_0_1666903383.1311712876195\n" +
      "Content-Type: text/html; charset=us-ascii\n" +
      "Content-Transfer-Encoding: 7bit\n" +
      "Content-ID: e66f8da3-786d-4da6-b2c2-13792bb81573\n" +
      "\n" +
      "<b>here</b> is some html text\n" +
      "------=_Part_0_1666903383.1311712876195--";

    MIMEMessage mm = new MIMEMessage(new ByteArrayInputStream(messageBody.getBytes("utf-8")), "----=_Part_0_1666903383.1311712876195", new MIMEConfig());
    for (MIMEPart mimePart : mm.getAttachments()) {
      mimePart.read();
    }
  }

  /**
   * Tests the basic structure of the format...
   */
  public void testSimpleTextPartReader() throws Exception {
    //create a message using the standard multipart library.
    MimeMessage message = new MimeMessage(Session.getDefaultInstance(new Properties()));
    MimeMultipart mp = new MimeMultipart(GedcomxFileWriter.MEDIA_TYPE.getSubtype());
    message.setContent(mp);
    MimeBodyPart bp = new MimeBodyPart();
    bp.setContentID(UUID.randomUUID().toString());
    bp.addHeader("Content-Type", "text/plain");
    bp.setDataHandler(new DataHandler(new ByteArrayDataSource("here is some plain text", "text/plain")));
    mp.addBodyPart(bp);
    bp = new MimeBodyPart();
    bp.setContentID(UUID.randomUUID().toString());
    bp.addHeader("Content-Type", "text/html");
    bp.setDataHandler(new DataHandler(new ByteArrayDataSource("<b>here</b> is some html text", "text/html")));
    mp.addBodyPart(bp);
    ByteArrayOutputStream out = new ByteArrayOutputStream();
    message.writeTo(out);

    JerseyMultipartGedcomxFileReader reader = new JerseyMultipartGedcomxFileReader(new ByteArrayInputStream(out.toByteArray()));
    Collection<GedcomxFilePart> parts = reader.getParts();
    assertEquals(2, parts.size());
    for (GedcomxFilePart part : parts) {
      assertNotNull(part.getCid());
      MediaType mt = MediaType.valueOf(part.getMediaType());
      assertEquals("text", mt.getType());
      InputStream in = (InputStream) part.getContent();
      if ("plain".equals(mt.getSubtype())) {
        assertEquals("here is some plain text", readString(in));
      }
      else if ("html".equals(mt.getSubtype())) {
        assertEquals("<b>here</b> is some html text", readString(in));
      }
      else {
        fail("Unexpected body part media type: " + part.getMediaType());
      }
    }
  }

  private String readString(InputStream in) throws IOException {
    StringWriter writer = new StringWriter();
    byte[] buf = new byte[1024];
    int len = in.read(buf);
    while (len >= 0) {
      writer.write(new String(buf, 0, len, "utf-8"));
      len = in.read(buf);
    }
    return writer.toString();
  }

  /**
   * Tests writing more complex objects.
   */
  public void testReadMoreComplexObjects() throws Exception {
    //create a message using the standard multipart library.
    Marshaller marshaller = JAXBContext.newInstance(Record.class, Person.class, Relationship.class, Link.class).createMarshaller();
    MimeMessage message = new MimeMessage(Session.getDefaultInstance(new Properties()));
    MimeMultipart mp = new MimeMultipart(GedcomxFileWriter.MEDIA_TYPE.getSubtype());
    message.setContent(mp);

    Record record = new Record();
    record.setId(UUID.randomUUID().toString());
    URI recordPersistentId = URI.create("record_pid");
    record.setPersistentId(recordPersistentId);
    record.setExtension(new Extension());
    Link link = new Link();
    link.setHref(URI.create("urn:some-source"));
    record.getExtension().addElement(link);
    MimeBodyPart bp = new MimeBodyPart();
    bp.setContentID("<" + record.getId() + ">");
    bp.addHeader("Content-Type", RecordNamespaces.GEDCOMX_RECORD_XML_MEDIA_TYPE);
    ByteArrayOutputStream out = new ByteArrayOutputStream();
    marshaller.marshal(record, out);
    bp.setDataHandler(new DataHandler(new ByteArrayDataSource(out.toByteArray(), RecordNamespaces.GEDCOMX_RECORD_XML_MEDIA_TYPE)));
    mp.addBodyPart(bp);

    Person person = new Person();
    URI personPersistentId = URI.create("person_pid");
    person.setPersistentId(personPersistentId);
    person.setId(UUID.randomUUID().toString());
    bp = new MimeBodyPart();
    bp.setContentID("<" + person.getId() + ">");
    bp.addHeader("Content-Type", ConclusionNamespaces.GEDCOMX_CONCLUSION_XML_MEDIA_TYPE);
    out = new ByteArrayOutputStream();
    marshaller.marshal(person, out);
    bp.setDataHandler(new DataHandler(new ByteArrayDataSource(out.toByteArray(), ConclusionNamespaces.GEDCOMX_CONCLUSION_XML_MEDIA_TYPE)));
    mp.addBodyPart(bp);

    Relationship relationship = new Relationship();
    URI relationshipPersistentId = URI.create("relationship_pid");
    relationship.setPersistentId(relationshipPersistentId);
    relationship.setPerson1(new PersonReference());
    relationship.getPerson1().setHref(URI.create("cid:" + person.getId()));
    relationship.setId(UUID.randomUUID().toString());
    bp = new MimeBodyPart();
    bp.setContentID("<" + relationship.getId() + ">");
    bp.addHeader("Content-Type", ConclusionNamespaces.GEDCOMX_CONCLUSION_XML_MEDIA_TYPE);
    out = new ByteArrayOutputStream();
    marshaller.marshal(relationship, out);
    bp.setDataHandler(new DataHandler(new ByteArrayDataSource(out.toByteArray(), ConclusionNamespaces.GEDCOMX_CONCLUSION_XML_MEDIA_TYPE)));
    mp.addBodyPart(bp);

    bp = new MimeBodyPart();
    bp.setContentID("<" + UUID.randomUUID().toString() + ">");
    bp.addHeader("Content-Type", "text/html");
    bp.setDataHandler(new DataHandler(new ByteArrayDataSource("<b>here</b> is some html text", "text/html")));
    mp.addBodyPart(bp);

    out = new ByteArrayOutputStream();
    message.writeTo(out);
    //writer.writeTo(System.out);
    
    JerseyMultipartGedcomxFileReader reader = new JerseyMultipartGedcomxFileReader(new ByteArrayInputStream(out.toByteArray()), Record.class, Person.class, Relationship.class, Link.class);
    Collection<GedcomxFilePart> parts = reader.getParts();
    assertEquals(4, parts.size());
    for (GedcomxFilePart part : parts) {
      assertNotNull(part.getCid());
      MediaType mt = MediaType.valueOf(part.getMediaType());
      Object content = part.getContent();
      if (content instanceof Record) {
        record = (Record) content;
        assertEquals(RecordNamespaces.GEDCOMX_RECORD_XML_MEDIA_TYPE, mt.toString());
        assertEquals(recordPersistentId, record.getPersistentId());
        assertNotNull(record.getExtension());
        assertEquals(link.getHref(), record.getExtension().findExtensionOfType(Link.class).getHref());
      }
      else if (content instanceof Person) {
        person = (Person) content;
        assertEquals(ConclusionNamespaces.GEDCOMX_CONCLUSION_XML_MEDIA_TYPE, mt.toString());
        assertEquals(personPersistentId, person.getPersistentId());
      }
      else if (content instanceof Relationship) {
        relationship = (Relationship) content;
        assertEquals(ConclusionNamespaces.GEDCOMX_CONCLUSION_XML_MEDIA_TYPE, mt.toString());
        assertEquals(relationshipPersistentId, relationship.getPersistentId());
        assertNotNull(relationship.getPerson1());
        URI href = relationship.getPerson1().getHref();
        assertEquals("relationship should be referencing the person", person.getId(), href.getSchemeSpecificPart());
      }
      else {
        assertEquals("text", mt.getType());
        assertEquals("html", mt.getSubtype());
        assertEquals("<b>here</b> is some html text", readString((InputStream) content));
      }
    }
  }

  /**
   * Tests writing more complex objects.
   */
  public void testReadMoreComplexJsonObjects() throws Exception {
    //create a message using the standard multipart library.
    ObjectMapper mapper = new ObjectMapper();
    MimeMessage message = new MimeMessage(Session.getDefaultInstance(new Properties()));
    MimeMultipart mp = new MimeMultipart(GedcomxFileWriter.MEDIA_TYPE.getSubtype());
    message.setContent(mp);

    Record record = new Record();
    record.setId(UUID.randomUUID().toString());
    URI recordPersistentId = URI.create("record_pid");
    record.setPersistentId(recordPersistentId);
    record.setExtension(new Extension());
    Link link = new Link();
    link.setHref(URI.create("urn:some-source"));
    record.getExtension().addElement(link);
    MimeBodyPart bp = new MimeBodyPart();
    bp.setContentID("<" + record.getId() + ">");
    bp.addHeader("Content-Type", RecordNamespaces.GEDCOMX_RECORD_JSON_MEDIA_TYPE);
    ByteArrayOutputStream out = new ByteArrayOutputStream();
    mapper.writeValue(out, record);
    bp.setDataHandler(new DataHandler(new ByteArrayDataSource(out.toByteArray(), RecordNamespaces.GEDCOMX_RECORD_JSON_MEDIA_TYPE)));
    mp.addBodyPart(bp);

    Person person = new Person();
    URI personPersistentId = URI.create("person_pid");
    person.setPersistentId(personPersistentId);
    person.setId(UUID.randomUUID().toString());
    bp = new MimeBodyPart();
    bp.setContentID("<" + person.getId() + ">");
    bp.addHeader("Content-Type", ConclusionNamespaces.GEDCOMX_CONCLUSION_JSON_MEDIA_TYPE);
    out = new ByteArrayOutputStream();
    mapper.writeValue(out, person);
    bp.setDataHandler(new DataHandler(new ByteArrayDataSource(out.toByteArray(), ConclusionNamespaces.GEDCOMX_CONCLUSION_JSON_MEDIA_TYPE)));
    mp.addBodyPart(bp);

    Relationship relationship = new Relationship();
    URI relationshipPersistentId = URI.create("relationship_pid");
    relationship.setPersistentId(relationshipPersistentId);
    relationship.setPerson1(new PersonReference());
    relationship.getPerson1().setHref(URI.create("cid:" + person.getId()));
    relationship.setId(UUID.randomUUID().toString());
    bp = new MimeBodyPart();
    bp.setContentID("<" + relationship.getId() + ">");
    bp.addHeader("Content-Type", ConclusionNamespaces.GEDCOMX_CONCLUSION_JSON_MEDIA_TYPE);
    out = new ByteArrayOutputStream();
    mapper.writeValue(out, relationship);
    bp.setDataHandler(new DataHandler(new ByteArrayDataSource(out.toByteArray(), ConclusionNamespaces.GEDCOMX_CONCLUSION_JSON_MEDIA_TYPE)));
    mp.addBodyPart(bp);

    out = new ByteArrayOutputStream();
    message.writeTo(out);
    //writer.writeTo(System.out);

    JerseyMultipartGedcomxFileReader reader = new JerseyMultipartGedcomxFileReader(new ByteArrayInputStream(out.toByteArray()), Record.class, Person.class, Link.class);
    Collection<GedcomxFilePart> parts = reader.getParts();
    assertEquals(3, parts.size());
    for (GedcomxFilePart part : parts) {
      assertNotNull(part.getCid());
      MediaType mt = MediaType.valueOf(part.getMediaType());
      Object content = part.getContent();
      if (content instanceof Record) {
        record = (Record) content;
        assertEquals(RecordNamespaces.GEDCOMX_RECORD_JSON_MEDIA_TYPE, mt.toString());
        assertEquals(recordPersistentId, record.getPersistentId());
        assertNotNull(record.getExtension());
        assertEquals(link.getHref(), record.getExtension().findExtensionOfType(Link.class).getHref());
      }
      else if (content instanceof Person) {
        person = (Person) content;
        assertEquals(ConclusionNamespaces.GEDCOMX_CONCLUSION_JSON_MEDIA_TYPE, mt.toString());
        assertEquals(personPersistentId, person.getPersistentId());
      }
      else {
        relationship = mapper.readValue((InputStream) content, Relationship.class);
        assertEquals(ConclusionNamespaces.GEDCOMX_CONCLUSION_JSON_MEDIA_TYPE, mt.toString());
        assertEquals(relationshipPersistentId, relationship.getPersistentId());
        assertNotNull(relationship.getPerson1());
        URI href = relationship.getPerson1().getHref();
        assertEquals("relationship should be referencing the person", person.getId(), href.getSchemeSpecificPart());
      }
    }
  }

  /**
   * Tests the basic structure of the format...
   */
  public void testGZippedParts() throws Exception {
    //create a message using the standard multipart library.
    Marshaller marshaller = JAXBContext.newInstance(Record.class, Person.class, Relationship.class, Link.class).createMarshaller();
    ByteArrayOutputStream messageOut = new ByteArrayOutputStream(); //we have to construct our multipart message by hand because javamail doesn't let us but raw binary data in the content body.
    MediaType boundedContentType = Boundary.addBoundary(GedcomxFileWriter.MEDIA_TYPE);
    String boundary = boundedContentType.getParameters().get("boundary");
    messageOut.write(String.format("Content-Type: %s\r\n\r\n--%s\r\n", boundedContentType, boundary).getBytes("utf-8"));

    Record record = new Record();
    record.setId(UUID.randomUUID().toString());
    URI recordPersistentId = URI.create("record_pid");
    record.setPersistentId(recordPersistentId);
    record.setExtension(new Extension());
    Link link = new Link();
    link.setHref(URI.create("urn:some-source"));
    record.getExtension().addElement(link);
    messageOut.write(String.format("Content-ID: %s\r\nContent-Type: %s\r\nContent-Encoding: gzip\r\n\r\n", record.getId(), RecordNamespaces.GEDCOMX_RECORD_XML_MEDIA_TYPE).getBytes("utf-8"));
    GZIPOutputStream gzipOut = new GZIPOutputStream(messageOut);
    marshaller.marshal(record, gzipOut);
    gzipOut.flush();
    gzipOut.finish();
    messageOut.write(String.format("\r\n--%s\r\n", boundary).getBytes("utf-8"));

    messageOut.write(String.format("Content-ID: %s\r\nContent-Type: %s\r\nContent-Encoding: gzip\r\n\r\n", UUID.randomUUID().toString(), "text/html").getBytes("utf-8"));
    gzipOut = new GZIPOutputStream(messageOut);
    gzipOut.write("<b>here</b> is some html text".getBytes("utf-8"));
    gzipOut.flush();
    gzipOut.finish();
    messageOut.write(String.format("\r\n--%s--", boundary).getBytes("utf-8"));

//    System.out.println(new String(messageOut.toByteArray(), "utf-8"));

    JerseyMultipartGedcomxFileReader reader = new JerseyMultipartGedcomxFileReader(new ByteArrayInputStream(messageOut.toByteArray()), Record.class, Person.class, Relationship.class, Link.class);
    Collection<GedcomxFilePart> parts = reader.getParts();
    assertEquals(2, parts.size());
    for (GedcomxFilePart part : parts) {
      assertNotNull(part.getCid());
      MediaType mt = MediaType.valueOf(part.getMediaType());
      Object content = part.getContent();
      if (content instanceof Record) {
        record = (Record) content;
        assertEquals(RecordNamespaces.GEDCOMX_RECORD_XML_MEDIA_TYPE, mt.toString());
        assertEquals(recordPersistentId, record.getPersistentId());
        assertNotNull(record.getExtension());
        assertEquals(link.getHref(), record.getExtension().findExtensionOfType(Link.class).getHref());
      }
      else {
        assertEquals("text", mt.getType());
        assertEquals("html", mt.getSubtype());
        assertEquals("<b>here</b> is some html text", readString((InputStream) content));
      }
    }
  }

}

package org.gedcomx.common;

import org.testng.annotations.Test;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

import static org.testng.Assert.*;


public class LiteralValueTest {
  @Test
  public void testDefaultCtor() throws Exception {
    LiteralValue literal = new LiteralValue();
    literal.setDatatype(URI.create("urn:dataType"));
    literal.setLang("en-US");
    literal.setValue("value");

    assertEquals(literal.getDatatype().toURI().toString(), "urn:dataType");
    assertEquals(literal.getLang(), "en-US");
    assertEquals(literal.getValue(), "value");
    try {
      literal.getValueAsDate();
      fail("expected an IllegalStateException because the value was not a date");
    } catch (IllegalStateException ex) {
      assertTrue(true); // expected
    }
  }

  @Test
  public void testValueCtor() throws Exception {
    LiteralValue literal = new LiteralValue("value");

    assertNull(literal.getDatatype());
    assertNull(literal.getLang());
    assertEquals(literal.getValue(), "value");
  }

  @Test
  public void testDateCtor() throws Exception {
    long date_2011_11_11_11_11_11_111_millis = 1321027871111L;
    TimeZone utcTimeZone = TimeZone.getTimeZone("UTC");
    final DatatypeFactory DATATYPE_FACTORY;
    try {
      DATATYPE_FACTORY = DatatypeFactory.newInstance();
    }
    catch (DatatypeConfigurationException e) {
      throw new RuntimeException(e);
    }

    GregorianCalendar gcUTC = new GregorianCalendar();
    gcUTC.setTimeZone(utcTimeZone);
    gcUTC.setTimeInMillis(date_2011_11_11_11_11_11_111_millis); // 11 Nov 2011 11:11:11.111

    LiteralValue literal = new LiteralValue(gcUTC.getTime());

    assertEquals(literal.getDatatype().toURI().toString(), "http://www.w3.org/2001/XMLSchema#dateTime");
    assertNull(literal.getLang());
    try {
      GregorianCalendar gcDefault = new GregorianCalendar();
      Date retrievedDate = literal.getValueAsDate();
      gcDefault.setTime(retrievedDate);

      assertEquals(literal.getValue(), DATATYPE_FACTORY.newXMLGregorianCalendar(gcDefault).toXMLFormat());

      gcDefault.setTimeZone(utcTimeZone);
      assertEquals(gcDefault.getTime().getTime(), date_2011_11_11_11_11_11_111_millis);
    } catch (IllegalStateException ex) {
      fail("unexpected exception", ex);
    }
  }

  @Test
  public void testBadGetValueAsDateRequests() throws Exception {
    LiteralValue literal = new LiteralValue("value");

    assertNull(literal.getLang());
    assertEquals(literal.getValue(), "value");

    try {
      assertNull(literal.getDatatype());
      literal.getValueAsDate();
      fail("expected an IllegalStateException because the value was not a date");
    } catch (IllegalStateException ex) {
      assertTrue(true); // expected
    }
    try {
      literal.setDatatype(URI.create("urn:junk"));
      literal.getValueAsDate();
      fail("expected an IllegalStateException because the value was not a date");
    } catch (IllegalStateException ex) {
      assertTrue(true); // expected
    }
    try {
      literal.setDatatype(URI.create("http://www.w3.org/2001/XMLSchema#dateTime"));
      literal.getValueAsDate();
      fail("expected an IllegalArgumentException because the value \"value\" is not a date");
    } catch (IllegalArgumentException ex) {
      assertTrue(true); // expected
    }
    literal.setValue(null);
    assertNull(literal.getValueAsDate());
  }
}

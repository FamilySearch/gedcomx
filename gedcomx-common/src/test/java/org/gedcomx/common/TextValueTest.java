package org.gedcomx.common;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNull;


public class TextValueTest {
  @Test
  public void testDefaultCtor() throws Exception {
    TextValue literal = new TextValue();
    literal.setLang("en-US");
    literal.setValue("value");

    assertEquals(literal.getLang(), "en-US");
    assertEquals(literal.getValue(), "value");
  }

  @Test
  public void testValueCtor() throws Exception {
    TextValue literal = new TextValue("value");

    assertNull(literal.getLang());
    assertEquals(literal.getValue(), "value");
  }
}

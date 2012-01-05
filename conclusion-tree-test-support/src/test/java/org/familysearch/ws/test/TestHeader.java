package org.familysearch.ws.test;

import org.familysearch.ct.ws.test.Header;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Mike Gardiner
 */
public class TestHeader {
  /**
   * Trivial test to ensure getters and setters work
   */
  @Test
  public void testGetterAndSetterMethods() {
    Header header = new Header();
    header.setName("name");
    header.setValue("value");

    assertEquals("name", header.getName());
    assertEquals("value", header.getValue());
  }
}

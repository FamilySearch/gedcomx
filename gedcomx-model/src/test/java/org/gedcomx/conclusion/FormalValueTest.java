package org.gedcomx.conclusion;

import org.gedcomx.common.URI;
import org.gedcomx.types.EventType;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNull;


public class FormalValueTest {
  @Test
  public void testGetDatatype() throws Exception {
    FormalValue formalValue = new FormalValue();

    // test initial state
    assertNull(formalValue.getDatatype());
    assertNull(formalValue.getResource());
    assertNull(formalValue.getText());

    // set some values
    formalValue.setDatatype(URI.create("#myDataType"));
    formalValue.setKnownValue(EventType.Baptism); // sets the resource property
    formalValue.setText("Mayo");

    // validate values
    assertEquals(formalValue.getDatatype().toString(), "#myDataType");
    assertEquals(formalValue.getResource().toString(), EventType.Baptism.toQNameURI().toString());
    assertEquals(formalValue.getKnownValue(EventType.class), EventType.Baptism);
    assertEquals(formalValue.getText(), "Mayo");
    assertEquals(formalValue.toString(), "Mayo");

    // set values to null again
    formalValue.setDatatype(null);
    formalValue.setResource(null);
    formalValue.setText(null);

    // test null state
    assertNull(formalValue.getDatatype());
    assertNull(formalValue.getResource());
    assertNull(formalValue.getKnownValue(EventType.class));
    assertNull(formalValue.getText());
    assertEquals(formalValue.toString(), "");
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testSetKnownValueAsNull() throws Exception {
    FormalValue formalValue = new FormalValue();
    formalValue.setKnownValue(null);
  }
}

package org.gedcomx.common;

import org.gedcomx.types.DatePartType;
import org.gedcomx.types.PlacePartType;
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
    formalValue.setKnownValue(DatePartType.Months); // sets the resource property
    formalValue.setText("Mayo");

    // validate values
    assertEquals(formalValue.getDatatype().toString(), "#myDataType");
    assertEquals(formalValue.getResource().toString(), DatePartType.Months.toQNameURI().toString());
    assertEquals(formalValue.getKnownValue(DatePartType.class), DatePartType.Months);
    assertEquals(formalValue.getKnownValue(PlacePartType.class), PlacePartType.OTHER);
    assertEquals(formalValue.getText(), "Mayo");
    assertEquals(formalValue.toString(), "Mayo");

    // set values to null again
    formalValue.setDatatype(null);
    formalValue.setResource(null);
    formalValue.setText(null);

    // test null state
    assertNull(formalValue.getDatatype());
    assertNull(formalValue.getResource());
    assertNull(formalValue.getKnownValue(DatePartType.class));
    assertNull(formalValue.getText());
    assertEquals(formalValue.toString(), "");
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testSetKnownValueAsNull() throws Exception {
    FormalValue formalValue = new FormalValue();
    formalValue.setKnownValue(null);
  }
}

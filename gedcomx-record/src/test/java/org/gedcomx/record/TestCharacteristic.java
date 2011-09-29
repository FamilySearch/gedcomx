package org.gedcomx.record;

import org.gedcomx.types.FactType;
import org.testng.annotations.Test;

import java.util.Arrays;

/**
 * @author Ryan Heaton
 */
@Test
public class TestCharacteristic {

  public void testCharacteristicTypes() throws Exception {

    Characteristic ch = new Characteristic();
    ch.setKnownType(FactType.Person.Age);
    ch.setInterpreted("int");
    Persona persona = new Persona();
    persona.setCharacteristics(Arrays.asList(ch));

  }
}

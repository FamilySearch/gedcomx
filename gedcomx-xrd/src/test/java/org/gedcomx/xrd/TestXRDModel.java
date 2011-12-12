package org.gedcomx.xrd;

import org.testng.annotations.Test;

import static org.gedcomx.rt.SerializationUtil.processThroughXml;

/**
 * @author Mike Gardiner
 */

@Test
public class TestXRDModel {

  public void testXRDType() throws Exception {
    XRD xrd = new XRD();
    //todo: fill in xrd with stuff
    xrd = processThroughXml(xrd);
    //todo: verify all the properties.
  }
}

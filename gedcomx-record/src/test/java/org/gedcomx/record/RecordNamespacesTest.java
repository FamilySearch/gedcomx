package org.gedcomx.record;

import org.gedcomx.rt.GedcomNamespaceManager;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertNotNull;

/**
 * @author Ryan Heaton
 */
@Test
public class RecordNamespacesTest {

  public void testRuntimeVersion() throws Exception {
    assertNotNull(GedcomNamespaceManager.getRuntimeVersion(RecordModel.GEDCOMX_RECORD_V1_NAMESPACE));
  }
}

package org.familysearch.ws.test;

import org.familysearch.ct.ws.test.UseCase;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Unit tests for the UseCase class
 *
 * @author Mike Gardiner
 */
public class TestUseCase {

  @Test
  public void testUseCase() throws Exception {
    final String title = "Title";
    final String description = "Description";

    UseCase uc = new UseCase();
    uc.setTitle(title);
    uc.setDescription(description);

    assertEquals(title, uc.getTitle());
    assertEquals(description, uc.getDescription());
    assertEquals(0, uc.getRequests().size());
  }
}

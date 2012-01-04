package org.familysearch.ws.test;

import com.sun.jersey.test.framework.spi.container.TestContainerException;
import org.familysearch.ct.ws.test.DocAwareJerseyTest;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;


/**
 * @author Mike Gardiner
 */
public class TestDocAwareJerseyTest extends DocAwareJerseyTest {

  public TestDocAwareJerseyTest() throws TestContainerException {
    super("org.familysearch.ws.test");
  }

  @Test
  public void testCreateUseCase() throws Exception {

    createUseCase()
      .title("title")
      .description("description");

    super.tearDown();

    assertEquals(1, this.filter.getUseCases().size());
  }

  @Test
  public void testTestNonUniqueTitle() throws Exception {

    try {
      createUseCase()
        .title("title2")
        .description("description");

      createUseCase()
        .title("title2")
        .description("description");

      super.tearDown();
      assertTrue(false);  // We shouldn't get here
    }
    catch (Exception e) {
      assertTrue(true);  // We should get here
    }
  }

  @Override
  public void tearDown() throws Exception {

  }
}

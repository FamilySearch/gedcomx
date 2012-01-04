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

  /**
   * Create a UseCase and verify it exists
   *
   * @throws Exception - An error occurred
   */
  @Test
  public void testCreateUseCase() throws Exception {

    createUseCase()
      .title("title")
      .description("description");

    super.tearDown();

    assertEquals(1, this.filter.getUseCases().size());
  }

  /**
   * Test to ensure that all the UseCase titles are unique
   *
   * @throws Exception - Shouldn't throw anything since we trap the exception
   */
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

  /**
   * Override tearDown since we are testing the logic in each test
   *
   * @throws Exception - An exception occurred
   */
  @Override
  public void tearDown() throws Exception {

  }
}

package org.familysearch.ws.test;

import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.test.framework.spi.container.TestContainerException;
import org.familysearch.ct.ws.test.DocAwareJerseyTest;
import org.junit.Test;

import java.io.File;

import static junit.framework.Assert.*;


/**
 * @author Mike Gardiner
 */
public class TestDocAwareJerseyTest extends DocAwareJerseyTest {

  /**
   * Setup the package to look for Jersey resources
   *
   * @throws TestContainerException if error occurs
   */
  public TestDocAwareJerseyTest() throws TestContainerException {
  }

  /**
   * Create a UseCase and verify it exists
   *
   * @throws Exception - An error occurred
   */
  @Test
  public void testCreateUseCase() throws Exception {
    final String title = "title";

    createUseCase(title)
      .withDescription("description");

    super.tearDown();

    assertEquals(1, this.filter.getUseCases().size());

    // Make sure file exists
    assertTrue(fileExists(title));
  }

  /**
   * Make sure an exception is thrown if a UseCase is created without
   * a title
   */
  @Test
  public void testUseCaseNoTitle() {
    // Null Title
    try {
      createUseCase(null);
      assertTrue(false);  // Shouldn't get here
    }
    catch (Exception e) {
      assertTrue(true);   // Should get here
    }

    // Empty Title
    try {
      createUseCase("");
      assertTrue(false);  // Shouldn't get here
    }
    catch (Exception e) {
      assertTrue(true);   // Should get here
    }
  }

  /**
   * Test to ensure that all the UseCase titles are unique
   *
   * @throws Exception - Shouldn't throw anything since we trap the exception
   */
  @Test
  public void testTestNonUniqueTitle() throws Exception {

    try {
      createUseCase("title2")
        .withDescription("description");

      createUseCase("title2")
        .withDescription("description");

      super.tearDown();
      assertTrue(false);  // We shouldn't get here
    }
    catch (Exception e) {
      assertTrue(true);  // We should get here
    }
  }

  /**
   * Create a couple of UseCases each with their own request
   * description.
   *
   * @throws Exception - If an unexpected error occurred
   */
  @Test
  public void testRequestDescription() throws Exception {

    String requestDesc1 = "Request Description";
    setRequestDescription(requestDesc1);

    createUseCase("Request Description")
      .withDescription("Title with request description");

    ClientResponse response = resource().path("/root").get(ClientResponse.class);
    assertNotNull(response);
    assertEquals(200, response.getStatus());

    String requestDesc2 = "Request Description 2";
    setRequestDescription(requestDesc2);

    createUseCase("Request Description 2")
      .withDescription("Title with request description 2");

    response = resource().path("/root").get(ClientResponse.class);
    assertNotNull(response);
    assertEquals(200, response.getStatus());

    super.tearDown();

    assertEquals(requestDesc1, filter.getUseCases().get(0).getRequests().get(0).getDescription());
    assertEquals(requestDesc2, filter.getUseCases().get(1).getRequests().get(0).getDescription());
  }

  /**
   * Helper method for seeing if a file exists. The title is used to build
   * the filename.
   *
   * EXAMPLE: A title of "Unit Test" would create a file called
   * "Unit-Test.usecase.xml" in the target/generated-doc directory.
   *
   * @param title - Title of the usecase
   * @return true if the file indicated by the title exists
   */
  private boolean fileExists(String title) {
    StringBuilder sb = new StringBuilder(DEFAULT_OUTPUT_DIR);
    sb.append(File.separator);
    sb.append(title);
    sb.append(".usecase.xml");

    File file = new File(sb.toString());

    return file.exists();
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

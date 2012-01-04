package org.familysearch.ws.test;

import com.sun.jersey.test.framework.spi.container.TestContainerException;
import org.familysearch.ct.ws.test.DocAwareJerseyTest;
import org.junit.Test;


/**
 * @author Mike Gardiner
 */
public class TestDocAwareJerseyTest extends DocAwareJerseyTest {

  public TestDocAwareJerseyTest() throws TestContainerException {
    super("org.familysearch.ws.test");
  }

  @Test
  public void testGet() throws Exception {
    createUseCase()
      .title("title")
      .description("description");
  }
}

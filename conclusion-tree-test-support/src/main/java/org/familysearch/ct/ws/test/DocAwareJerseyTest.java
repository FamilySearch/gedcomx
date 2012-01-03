package org.familysearch.ct.ws.test;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.test.framework.AppDescriptor;
import com.sun.jersey.test.framework.JerseyTest;
import com.sun.jersey.test.framework.spi.container.TestContainer;
import com.sun.jersey.test.framework.spi.container.TestContainerException;
import com.sun.jersey.test.framework.spi.container.TestContainerFactory;
import com.sun.jersey.test.framework.spi.container.inmemory.InMemoryTestContainerFactory;
import org.familysearch.ct.ws.test.filter.UseCaseLoggingFilter;

/**
 * @author Mike Gardiner and Ryan Heaton
 */
public class DocAwareJerseyTest extends JerseyTest {

  protected UseCaseLoggingFilter filter;

  public DocAwareJerseyTest() throws TestContainerException {
  }

  public DocAwareJerseyTest(TestContainerFactory testContainerFactory) {
    super(testContainerFactory);
  }

  public DocAwareJerseyTest(AppDescriptor ad) throws TestContainerException {
    super(ad);
  }

  public DocAwareJerseyTest(String... packages) throws TestContainerException {
    super(packages);
  }

  @Override
  protected TestContainerFactory getTestContainerFactory() throws TestContainerException {
    return new InMemoryTestContainerFactory();
  }

  @Override
  protected Client getClient(TestContainer tc, AppDescriptor ad) {
    this.filter = new UseCaseLoggingFilter();
    Client client = super.getClient(tc, ad);
    client.addFilter(filter);
    return client;
  }

  protected static UseCase createUseCase() {
    UseCase uc = new UseCase();
    UseCaseLoggingFilter.setCurrentUseCase(uc);
    return uc;
  }

}

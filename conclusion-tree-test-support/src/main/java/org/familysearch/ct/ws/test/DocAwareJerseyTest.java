package org.familysearch.ct.ws.test;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.test.framework.AppDescriptor;
import com.sun.jersey.test.framework.JerseyTest;
import com.sun.jersey.test.framework.spi.container.TestContainer;
import com.sun.jersey.test.framework.spi.container.TestContainerException;
import com.sun.jersey.test.framework.spi.container.TestContainerFactory;
import com.sun.jersey.test.framework.spi.container.inmemory.InMemoryTestContainerFactory;
import org.familysearch.ct.ws.test.filter.UseCaseLoggingFilter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

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

  protected UseCase createUseCase() {
    UseCase uc = new UseCase();
    this.filter.setCurrentUseCase(uc);
    return uc;
  }

  @Override
  public void tearDown() throws Exception {
    super.tearDown();

    Marshaller marshaller = JAXBContext.newInstance(UseCase.class).createMarshaller();
    for (UseCase useCase : this.filter.getUseCases()) {
      //todo: serialize out this use case to [id].usecase.xml
      //marshaller.marshal(useCase, out);
      //1. fill in this todo
      //2. write some tests for this class and for the serialization of the UseCase object.
      //3. fix the maven project so it packages up and attaches the jar with the .usecase.xml files in it.
    }
  }
}

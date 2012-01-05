package org.familysearch.ct.ws.test;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.test.framework.AppDescriptor;
import com.sun.jersey.test.framework.JerseyTest;
import com.sun.jersey.test.framework.LowLevelAppDescriptor;
import com.sun.jersey.test.framework.spi.client.ClientFactory;
import com.sun.jersey.test.framework.spi.container.TestContainer;
import com.sun.jersey.test.framework.spi.container.TestContainerException;
import com.sun.jersey.test.framework.spi.container.TestContainerFactory;
import com.sun.jersey.test.framework.spi.container.inmemory.InMemoryTestContainerFactory;
import org.familysearch.ct.ws.test.filter.UseCaseLoggingFilter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.net.URI;

/**
 * @author Mike Gardiner and Ryan Heaton
 */
public class DocAwareJerseyTest extends JerseyTest {

  protected static final String DEFAULT_OUTPUT_DIR = "target" + File.separator + "generated-doc";

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
    return new InMemoryTestContainerFactory() {
      @Override
      public TestContainer create(URI baseUri, AppDescriptor ad) {
        //make sure xml is formatted for documentation purposes.
        ((LowLevelAppDescriptor) ad).getResourceConfig().getSingletons().add(new FormattingJAXBContextResolver());
        return super.create(baseUri, ad);
      }
    };
  }

  @Override
  protected Client getClient(TestContainer tc, AppDescriptor ad) {
    this.filter = new UseCaseLoggingFilter();
    Client client = super.getClient(tc, ad);
    client.removeAllFilters();
    client.addFilter(filter);
    return client;
  }

  protected UseCase createUseCase() {
    UseCase uc = new UseCase();
    this.filter.setCurrentUseCase(uc);
    return uc;
  }

  protected void setRequestDescription(String description) {
    this.filter.setCurrentRequestDescription(description);
  }

  @Override
  public void tearDown() throws Exception {
    super.tearDown();
    endUseCase();

    String usecaseDir = System.getProperty("usecase.dir");
    if (usecaseDir == null) {
      usecaseDir = DEFAULT_OUTPUT_DIR;
    }

    File directory = new File(usecaseDir);
    directory.mkdirs();

    Marshaller marshaller = JAXBContext.newInstance(UseCase.class).createMarshaller();

    for (UseCase useCase : this.filter.getUseCases()) {
      File file = new File(usecaseDir, generateFilename(useCase.getTitle()));

      if (file.exists()) {
        throw new Exception("File is not unique, please ensure the UseCase title is unique!\n" + useCase.getTitle());
      }

      OutputStream os = new FileOutputStream(file);
      marshaller.marshal(useCase, os);
      os.close();
    }
  }

  private String generateFilename(String title) {
    StringBuilder filename = new StringBuilder(title.replace(' ', '-'));
    filename.append(".");
    filename.append("usecase.xml");
    return filename.toString();
  }

  protected void endUseCase() {
    this.filter.setCurrentUseCase(null);
  }
}

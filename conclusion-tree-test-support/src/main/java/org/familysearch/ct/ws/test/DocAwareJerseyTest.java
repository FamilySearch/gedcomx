package org.familysearch.ct.ws.test;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.test.framework.AppDescriptor;
import com.sun.jersey.test.framework.JerseyTest;
import com.sun.jersey.test.framework.LowLevelAppDescriptor;
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
 * This class is used to document RESTful resources by describing uses cases for a given
 * request and response to a RESTful resource.  It depends of JUnit 4 and the Jersey test
 * framework. Use case documentation files are written to the configured target location
 * and the format of the filename is [some-title].usecase.xml.  By default the files will
 * be put into the target/generated-doc directory.
 *
 * @author Mike Gardiner and Ryan Heaton
 */
public class DocAwareJerseyTest extends JerseyTest {

  protected static final String DEFAULT_OUTPUT_DIR = "target" + File.separator + "generated-doc";

  protected UseCaseLoggingFilter filter;

  /**
   * Default constructor
   *
   * @throws TestContainerException - An error occurred
   */
  public DocAwareJerseyTest() throws TestContainerException {
  }

  /**
   * Constructor
   *
   * @param testContainerFactory - A test container factory to use
   */
  public DocAwareJerseyTest(TestContainerFactory testContainerFactory) {
    super(testContainerFactory);
  }

  /**
   * Constructor
   *
   * @param ad - The application descriptor to use
   * @throws TestContainerException - An error occurred
   */
  public DocAwareJerseyTest(AppDescriptor ad) throws TestContainerException {
    super(ad);
  }

  /**
   * Constructor
   *
   * @param packages - Packages to scan for resources
   * @throws TestContainerException - An error occurred
   */
  public DocAwareJerseyTest(String... packages) throws TestContainerException {
    super(packages);
  }

  /**
   * @return The test container factory
   * @throws TestContainerException - An error occurred
   */
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

  /**
   * Get the client
   *
   * @param tc - Test container
   * @param ad - Application descriptor
   * @return Client
   */
  @Override
  protected Client getClient(TestContainer tc, AppDescriptor ad) {
    this.filter = new UseCaseLoggingFilter();
    Client client = super.getClient(tc, ad);
    client.removeAllFilters();
    client.addFilter(filter);
    return client;
  }

  /**
   * Create a new use case
   *
   * @param title - Title of the use case
   * @return UseCase
   */
  protected UseCase createUseCase(String title) {
    if (title == null || title.isEmpty()) {
      throw new IllegalArgumentException("title must not be null or empty");
    }

    UseCase uc = new UseCase();
    uc.setTitle(title);
    this.filter.setCurrentUseCase(uc);
    return uc;
  }

  /**
   * Sets a description for the use case
   *
   * @param description - A description for the use case
   */
  protected void setRequestDescription(String description) {
    this.filter.setCurrentRequestDescription(description);
  }

  /**
   * This is where the use case files are created containing the
   * request and response information.
   *
   * @throws Exception
   */
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

  /**
   * Generate a new filename based on the title of the use case
   *
   * @param title - The title to use
   * @return String representing the filename
   */
  private String generateFilename(String title) {
    StringBuilder filename = new StringBuilder(title.replace(' ', '-'));
    filename.append(".");
    filename.append("usecase.xml");
    return filename.toString();
  }

  /**
   * Marks the use case as ended
   */
  protected void endUseCase() {
    this.filter.setCurrentUseCase(null);
  }
}

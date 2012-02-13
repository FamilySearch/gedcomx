package org.familysearch.ct.ws.test;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.test.framework.AppDescriptor;
import com.sun.jersey.test.framework.JerseyTest;
import com.sun.jersey.test.framework.LowLevelAppDescriptor;
import com.sun.jersey.test.framework.WebAppDescriptor;
import com.sun.jersey.test.framework.spi.container.TestContainer;
import com.sun.jersey.test.framework.spi.container.TestContainerException;
import com.sun.jersey.test.framework.spi.container.TestContainerFactory;
import com.sun.jersey.test.framework.spi.container.http.HTTPContainerFactory;
import org.familysearch.ct.ws.test.filter.UseCaseLoggingFilter;

import javax.ws.rs.core.UriBuilder;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;

/**
 * This class is used to document RESTful resources by describing uses cases for a given
 * request and response to a RESTful resource.  It depends of JUnit 4 and the Jersey test
 * framework. Use case documentation files are written to the configured target location
 * and the format of the filename is [some-title].usecase.xml.  By default the files will
 * be put into the target/generated-doc directory.
 *
 * @author Mike Gardiner
 * @author Ryan Heaton
 */
public class DocAwareJerseyTest extends JerseyTest {

  protected Map<Class<?>, Object> serverSideComponents;
  protected static final String DEFAULT_OUTPUT_DIR = "target" + File.separator + "generated-doc";

  protected UseCaseLoggingFilter filter;

  /**
   * Default constructor
   *
   * @throws TestContainerException - An error occurred
   */
  public DocAwareJerseyTest() throws TestContainerException {
  }

  protected void registerServerSideComponents(Map<Class<?>, Object> serverSideComponents) {
    //default: no server-side components to register.
  }

  @Override
  protected AppDescriptor configure() {
    this.serverSideComponents = new HashMap<Class<?>, Object>();
    registerServerSideComponents(this.serverSideComponents);
    LowLevelAppDescriptor app = LowLevelAppDescriptor.transform(new WebAppDescriptor.Builder(getClass().getPackage().getName()).build());
    app.getResourceConfig().getSingletons().add(new BasicComponentRegistry(this.serverSideComponents));
    configure(app);
    return app;
  }

  @Override
  protected URI getBaseURI() {
    return UriBuilder.fromUri(super.getBaseURI()).path(getContextPath()).build();
  }

  protected String getContextPath() {
    return "";
  }

  /**
   * Add extra configuration to the app descriptor.
   *
   * @param app The app descriptor.
   */
  protected void configure(LowLevelAppDescriptor app) {
    //no-op
  }

  /**
   * @return The test container factory
   * @throws TestContainerException - An error occurred
   */
  @Override
  protected TestContainerFactory getTestContainerFactory() throws TestContainerException {
    return new HTTPContainerFactory();
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
  public void setUp() throws Exception {
    super.setUp();
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

    boolean ensureUniqueUseCases = !"false".equals(System.getProperty("ensure.unique.usecases")) && !isRunningFromIntelliJ();
    for (UseCase useCase : this.filter.getUseCases()) {
      File file = new File(usecaseDir, generateFilename(useCase.getTitle()));

      if (ensureUniqueUseCases && file.exists()) {
        throw new Exception("File is not unique, please ensure the UseCase title is unique!\n" + useCase.getTitle());
      }

      OutputStream os = new FileOutputStream(file);
      marshaller.marshal(useCase, os);
      os.close();
    }
  }

  private boolean isRunningFromIntelliJ() {
    try {
      Class.forName("com.intellij.rt.execution.application.AppMain", false, getClass().getClassLoader());
      return true;
    }
    catch (Throwable e) {
      return false;
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

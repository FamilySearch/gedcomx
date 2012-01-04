package org.familysearch.ct.ws.build;

import org.codehaus.enunciate.main.ClasspathHandler;
import org.codehaus.enunciate.main.ClasspathResource;
import org.codehaus.enunciate.main.Enunciate;
import org.familysearch.ct.ws.test.UseCase;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Ryan Heaton
 */
public class UseCaseClasspathHandler implements ClasspathHandler {

  private final Enunciate enunciate;
  private final List<UseCase> cases = new ArrayList<UseCase>();
  private final Unmarshaller unmarshaller;

  public UseCaseClasspathHandler(Enunciate enunciate) {
    this.enunciate = enunciate;
    try {
      unmarshaller = JAXBContext.newInstance(UseCase.class).createUnmarshaller();
    }
    catch (JAXBException e) {
      throw new RuntimeException(e);
    }
  }

  public List<UseCase> getCases() {
    return cases;
  }

  @Override
  public void startPathEntry(File pathEntry) {
  }

  @Override
  public void handleResource(ClasspathResource resource) {
    if (resource.getPath().endsWith(".usecase.xml")) {
      try {
        this.cases.add((UseCase) unmarshaller.unmarshal(resource.read()));
      }
      catch (Exception e) {
        this.enunciate.error("Unable to unmarshal use case %s: %s.", resource.getPath(), e.getMessage());
      }
    }
  }

  @Override
  public boolean endPathEntry(File pathEntry) {
    return false;
  }
}

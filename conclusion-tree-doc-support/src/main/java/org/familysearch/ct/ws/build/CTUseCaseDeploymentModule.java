package org.familysearch.ct.ws.build;

import freemarker.template.TemplateException;
import org.codehaus.enunciate.EnunciateException;
import org.codehaus.enunciate.apt.EnunciateFreemarkerModel;
import org.codehaus.enunciate.contract.jaxrs.RootResource;
import org.codehaus.enunciate.main.Enunciate;
import org.codehaus.enunciate.main.FileArtifact;
import org.codehaus.enunciate.modules.FreemarkerDeploymentModule;
import org.familysearch.ct.ws.test.Header;
import org.familysearch.ct.ws.test.RequestAndResponse;
import org.familysearch.ct.ws.test.UseCase;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Ryan Heaton
 */
public class CTUseCaseDeploymentModule extends FreemarkerDeploymentModule {

  private UseCaseClasspathHandler useCaseManager;

  @Override
  public int getOrder() {
    //just before gedcomx processing...
    return 99;
  }

  @Override
  public String getName() {
    return "ct-use-case";
  }

  protected URL getUseCaseTemplateURL() {
    return CTUseCaseDeploymentModule.class.getResource("/META-INF/usecase.fmt");
  }

  @Override
  public void init(Enunciate enunciate) throws EnunciateException {
    super.init(enunciate);
    this.useCaseManager = new UseCaseClasspathHandler(enunciate);
    enunciate.addClasspathHandler(this.useCaseManager);
  }

  @Override
  public void doFreemarkerGenerate() throws EnunciateException, IOException, TemplateException {
    //no-op template processing is done in the build phase.
  }

  @Override
  protected void doBuild() throws EnunciateException, IOException {
    File buildDir = getBuildDir();
    if (!getEnunciate().isUpToDateWithSources(buildDir)) {
      EnunciateFreemarkerModel model = getModel();
      model.setFileOutputDirectory(buildDir);
      try {
        InputStream base = CTUseCaseDeploymentModule.class.getResourceAsStream("/gedcomx.ext.docs.base.zip");
        if (base != null) {
          getEnunciate().extractBase(base, buildDir);
        }

        List<UseCase> cases = this.useCaseManager.getCases();
        Map<String, List<UseCase>> casesByFqn = new HashMap<String, List<UseCase>>();
        for (UseCase useCase : cases) {
          for (String bindingFqn : useCase.getApplicableBindings()) {
            List<UseCase> useCases = casesByFqn.get(bindingFqn);
            if (useCases == null) {
              useCases = new ArrayList<UseCase>();
              casesByFqn.put(bindingFqn, useCases);
            }
            useCases.add(useCase);
          }
        }

        model.put("usecases", cases);
        model.put("casesByFqn", casesByFqn);
        processTemplate(getUseCaseTemplateURL(), model);
      }
      catch (TemplateException e) {
        throw new EnunciateException(e);
      }
    }
    else {
      info("Skipping documentation of use cases as everything appears up-to-date...");
    }

    //export the generated documentation as an artifact.
    getEnunciate().addArtifact(new FileArtifact(getName(), "ct-use-cases", buildDir));
  }

  @Override
  public boolean isDisabled() {
    if (super.isDisabled()) {
      return true;
    }
    else if (this.useCaseManager != null && this.useCaseManager.getCases().isEmpty()) {
      debug("Module '%s' is disabled because there were no use cases found on the classpath.", getName());
      return true;
    }

    return false;
  }
}

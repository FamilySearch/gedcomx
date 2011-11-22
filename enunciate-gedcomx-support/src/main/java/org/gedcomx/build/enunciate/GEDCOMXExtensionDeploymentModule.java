/**
 * Copyright 2011 Intellectual Reserve, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.gedcomx.build.enunciate;

import freemarker.template.TemplateException;
import org.codehaus.enunciate.EnunciateException;
import org.codehaus.enunciate.apt.EnunciateFreemarkerModel;
import org.codehaus.enunciate.main.Enunciate;
import org.codehaus.enunciate.main.FileArtifact;
import org.codehaus.enunciate.modules.FreemarkerDeploymentModule;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 * @author Ryan Heaton
 */
public class GEDCOMXExtensionDeploymentModule extends FreemarkerDeploymentModule {

  private String gedcomxRoot = "http://www.gedcomx.org/";

  @Override
  public String getName() {
    return "gedcomx-ext";
  }

  @Override
  public final int getOrder() {
    return 101; //just after the gedcomx processing is done.
  }

  public String getGedcomxRoot() {
    return gedcomxRoot;
  }

  public void setGedcomxRoot(String gedcomxRoot) {
    this.gedcomxRoot = gedcomxRoot;
  }

  @Override
  public void init(Enunciate enunciate) throws EnunciateException {
    super.init(enunciate);

    if (!isDisabled()) {
      if (!enunciate.isModuleEnabled("gedcomx")) {
        throw new EnunciateException("The 'gedcomx' enunciate module must be enabled for extension processing.");
      }
    }
  }

  protected URL getDocsTemplateURL() {
    return GEDCOMXExtensionDeploymentModule.class.getResource("/META-INF/gedcomx-ext-docs.fmt");
  }

  @Override
  public void doFreemarkerGenerate() throws EnunciateException, IOException, TemplateException {
    //no-op. template processing is done in the build phase.
  }

  @Override
  protected void doBuild() throws EnunciateException, IOException {
    File buildDir = getBuildDir();
    if (!getEnunciate().isUpToDateWithSources(buildDir)) {
      EnunciateFreemarkerModel model = getModel();
      model.setFileOutputDirectory(buildDir);
      InputStream base = GEDCOMXExtensionDeploymentModule.class.getResourceAsStream("/gedcomx.ext.docs.base.zip");
      if (base != null) {
        getEnunciate().extractBase(base, buildDir);
      }
      try {
        model.put("gedcomxRoot", getGedcomxRoot());
        processTemplate(getDocsTemplateURL(), model);
      }
      catch (TemplateException e) {
        throw new EnunciateException(e);
      }
    }
    else {
      info("Skipping build of documentation as everything appears up-to-date...");
    }

    //export the generated documentation as an artifact.
    getEnunciate().addArtifact(new FileArtifact(getName(), "docs-ext", buildDir));
  }

  @Override
  public boolean isDisabled() {
    if (super.isDisabled()) {
      return true;
    }
    else if (getDocsTemplateURL() == null) {
      info("Module %s is disabled because nothing's at /META-INF/gedcomx-ext-docs.fmt is null", getName());
      return true;
    }
    return false;
  }
}

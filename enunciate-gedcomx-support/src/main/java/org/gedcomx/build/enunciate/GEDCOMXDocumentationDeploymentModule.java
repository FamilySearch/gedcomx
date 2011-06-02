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
import net.sf.jelly.apt.decorations.JavaDoc;
import org.codehaus.enunciate.EnunciateException;
import org.codehaus.enunciate.apt.EnunciateFreemarkerModel;
import org.codehaus.enunciate.config.SchemaInfo;
import org.codehaus.enunciate.config.WsdlInfo;
import org.codehaus.enunciate.contract.jaxb.Schema;
import org.codehaus.enunciate.main.Artifact;
import org.codehaus.enunciate.main.Enunciate;
import org.codehaus.enunciate.main.FileArtifact;
import org.codehaus.enunciate.main.NamedArtifact;
import org.codehaus.enunciate.modules.DocumentationAwareModule;
import org.codehaus.enunciate.modules.FreemarkerDeploymentModule;
import org.codehaus.enunciate.template.freemarker.GetGroupsMethod;
import org.codehaus.enunciate.template.freemarker.IsDefinedGloballyMethod;
import org.codehaus.enunciate.template.freemarker.UniqueContentTypesMethod;
import org.gedcomx.rt.GedcomNamespacePrefixMapper;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author Ryan Heaton
 */
public class GEDCOMXDocumentationDeploymentModule extends FreemarkerDeploymentModule implements DocumentationAwareModule {

  /**
   * @return "gedcomx-docs"
   */
  @Override
  public String getName() {
    return "gedcomx-docs";
  }

  /**
   * @return 100
   */
  @Override
  public int getOrder() {
    return 100;
  }

  /**
   * The title of the documentation.
   *
   * @return The title of the documentation.
   */
  public String getTitle() {
    return "GEDCOMX";
  }

  /**
   * The title of the documentation.
   *
   * @param title The title of the documentation.
   */
  public void setTitle(String title) {
  }

  /**
   * Set the title for this project iff it hasn't already been set.
   *
   * @param title The title.
   */
  public void setTitleConditionally(String title) {
  }

  /**
   * The subdirectory in the web application where the documentation will be put.
   *
   * @return The subdirectory in the web application where the documentation will be put.
   */
  public String getDocsDir() {
    return null;
  }

  /**
   * The name of the index page.
   *
   * @return The name of the index page.
   */
  public String getIndexPageName() {
    return "index.html";
  }

  /**
   * The name of the index page.
   *
   * @param indexPageName The name of the index page.
   */
  public void setIndexPageName(String indexPageName) {
  }

  /**
   * The subdirectory in the web application where the documentation will be put.
   *
   * @param docsDir The subdirectory in the web application where the documentation will be put.
   */
  public void setDocsDir(String docsDir) {
  }

  protected URL getDocsTemplateURL() {
    return GEDCOMXDocumentationDeploymentModule.class.getResource("docs.fmt");
  }

  protected URL getCodeTemplateURL() {
    return GEDCOMXDocumentationDeploymentModule.class.getResource("code.fmt");
  }

  @Override
  public void initModel(EnunciateFreemarkerModel model) {
    super.initModel(model);

    Map<String,String> knownPrefixes = GedcomNamespacePrefixMapper.getKnownPrefixes();
    model.getNamespacesToPrefixes().putAll(knownPrefixes);
    for (SchemaInfo schemaInfo : model.getNamespacesToSchemas().values()) {
      String knownPrefix = knownPrefixes.get(schemaInfo.getNamespace());
      if (knownPrefix != null) {
        schemaInfo.setId(knownPrefix);
      }

      //ensure the correct filenames are used for the schemas.
      schemaInfo.setProperty("filename", schemaInfo.getId() + ".xsd");
      schemaInfo.setProperty("location", schemaInfo.getId() + ".xsd");

      if (!schemaInfo.getTypeDefinitions().isEmpty()) {
        String label = "\"" + schemaInfo.getId() + "\" Profile";
        Schema pkg = schemaInfo.getTypeDefinitions().iterator().next().getPackage();
        JavaDoc.JavaDocTagList labels = pkg.getJavaDoc().get("label");
        String summary = pkg.getDocValue();
        if (summary != null) {
          int begin = summary.indexOf("<p>");
          if (begin < 0) {
            begin = 0;
          }
          else {
            begin += 3;
          }

          int end = summary.indexOf("</p>");
          if (end < 0) {
            end = summary.indexOf('.');
            if (end < 0) {
              end = summary.length();
            }
            else {
              end += 1;
            }
          }

          summary = summary.substring(begin, end);
          if (summary.length() == 0) {
            summary = null;
          }
        }
        schemaInfo.setProperty("summary", summary);

        if (labels != null && labels.size() > 0) {
          label = labels.get(0);
        }
        schemaInfo.setProperty("label", label);
      }
    }
  }

  /**
   * The generate logic builds the XML documentation structure for the enunciated API.
   */
  public void doFreemarkerGenerate() throws EnunciateException, IOException, TemplateException {
    //no-op; documentation is done in the build phase.
  }

  @Override
  protected void doBuild() throws EnunciateException, IOException {
    if (!getEnunciate().isUpToDateWithSources(getBuildDir())) {
      Set<Artifact> downloadableArtifacts = buildBase();
      EnunciateFreemarkerModel model = getModel();
      model.setFileOutputDirectory(getBuildDir());
      model.put("downloads", downloadableArtifacts);
      model.setVariable("uniqueContentTypes", new UniqueContentTypesMethod());
      model.setVariable("schemaForNamespace", new SchemaForNamespaceMethod(model.getNamespacesToSchemas()));
      model.put("isDefinedGlobally", new IsDefinedGloballyMethod());
      model.put("getGroups", new GetGroupsMethod());
      model.put("defaultDate", new Date());
      model.setVariable("generateExampleJson", new GenerateExampleJsonMethod());
      model.setVariable("generateExampleXml", new GenerateExampleXmlMethod());
      model.setVariable("typeName", new TypeNameMethod(model.getNamespacesToPrefixes()));
      try {
        processTemplate(getDocsTemplateURL(), model);
        processTemplate(getCodeTemplateURL(), model);
      }
      catch (TemplateException e) {
        throw new EnunciateException(e);
      }
    }
    else {
      info("Skipping build of documentation as everything appears up-to-date...");
    }

    //export the generated documentation as an artifact.
    getEnunciate().addArtifact(new FileArtifact(getName(), "docs", getBuildDir()));
  }

  /**
   * Builds the base output directory.
   *
   * @return The set of artifacts available for download.
   */
  protected Set<Artifact> buildBase() throws IOException {
    Enunciate enunciate = getEnunciate();
    File buildDir = getBuildDir();
    buildDir.mkdirs();

    for (SchemaInfo schemaInfo : getModel().getNamespacesToSchemas().values()) {
      if (schemaInfo.getProperty("file") != null) {
        File from = (File) schemaInfo.getProperty("file");
        String filename = schemaInfo.getProperty("filename") != null ? (String) schemaInfo.getProperty("filename") : from.getName();
        File to = new File(getBuildDir(), filename);
        enunciate.copyFile(from, to);
      }
    }

    for (WsdlInfo wsdlInfo : getModel().getNamespacesToWSDLs().values()) {
      if (wsdlInfo.getProperty("file") != null) {
        File from = (File) wsdlInfo.getProperty("file");
        String filename = wsdlInfo.getProperty("filename") != null ? (String) wsdlInfo.getProperty("filename") : from.getName();
        File to = new File(getBuildDir(), filename);
        enunciate.copyFile(from, to);
      }
    }

    File wadlFile = getModelInternal().getWadlFile();
    if (wadlFile != null) {
      enunciate.copyFile(wadlFile, new File(getBuildDir(), wadlFile.getName()));
    }

    Set<Artifact> downloads = new TreeSet<Artifact>();
    for (Artifact artifact : enunciate.getArtifacts()) {
      if (artifact instanceof NamedArtifact && artifact.isPublic()) {
        downloads.add(artifact);
      }
    }

    for (Artifact download : downloads) {
      debug("Exporting %s to directory %s.", download.getId(), buildDir);
      download.exportTo(buildDir, enunciate);
    }

    return downloads;
  }

}

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

import com.sun.mirror.apt.Messager;
import com.sun.mirror.declaration.TypeDeclaration;
import freemarker.template.TemplateException;
import net.sf.jelly.apt.Context;
import org.codehaus.enunciate.EnunciateException;
import org.codehaus.enunciate.apt.EnunciateFreemarkerModel;
import org.codehaus.enunciate.apt.EnunciateTypeDeclarationListener;
import org.codehaus.enunciate.config.SchemaInfo;
import org.codehaus.enunciate.config.WsdlInfo;
import org.codehaus.enunciate.contract.jaxb.RootElementDeclaration;
import org.codehaus.enunciate.contract.validation.ValidationException;
import org.codehaus.enunciate.contract.validation.ValidationMessage;
import org.codehaus.enunciate.contract.validation.ValidationResult;
import org.codehaus.enunciate.contract.validation.Validator;
import org.codehaus.enunciate.main.Artifact;
import org.codehaus.enunciate.main.Enunciate;
import org.codehaus.enunciate.main.FileArtifact;
import org.codehaus.enunciate.main.NamedArtifact;
import org.codehaus.enunciate.modules.DeploymentModule;
import org.codehaus.enunciate.modules.DocumentationAwareModule;
import org.codehaus.enunciate.modules.FreemarkerDeploymentModule;
import org.codehaus.enunciate.modules.docs.GenerateExampleXmlMethod;
import org.codehaus.enunciate.modules.docs.SchemaForNamespaceMethod;
import org.codehaus.enunciate.modules.objc.ObjCDeploymentModule;
import org.codehaus.enunciate.template.freemarker.GetGroupsMethod;
import org.codehaus.enunciate.template.freemarker.IsDefinedGloballyMethod;
import org.codehaus.enunciate.template.freemarker.UniqueContentTypesMethod;
import org.gedcomx.rt.DocIgnoreXmlRootElement;
import org.gedcomx.rt.GedcomNamespaceManager;
import org.gedcomx.rt.Namespace;
import org.gedcomx.rt.Namespaces;
import org.gedcomx.rt.www.ResourceServiceBinding;
import org.gedcomx.rt.www.ResourceServiceDefinition;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.*;

/**
 * The GEDCOM X deployment module handles the generation of the GEDCOM X documentation, validates common patterns, and
 * supplies needed metadata for the namespaces.
 *
 * @author Ryan Heaton
 */
public class GEDCOMXDeploymentModule extends FreemarkerDeploymentModule implements DocumentationAwareModule, EnunciateTypeDeclarationListener {

  private final Map<String, TypeDeclaration> knownNamespaceDeclarations = new HashMap<String, TypeDeclaration>();
  private final Map<String, TypeDeclaration> knownRsdDeclarations = new HashMap<String, TypeDeclaration>();
  private RDFProcessor rdfProcessor;
  private ResourceServiceProcessor resourceServiceProcessor;

  /**
   * @return "gedcomx"
   */
  @Override
  public String getName() {
    return "gedcomx";
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

  public void onTypeDeclarationInspected(TypeDeclaration typeDeclaration) {
    if (typeDeclaration.getAnnotation(Namespaces.class) != null) {
      this.knownNamespaceDeclarations.put(typeDeclaration.getQualifiedName(), typeDeclaration);
    }
    if (typeDeclaration.getAnnotation(ResourceServiceDefinition.class) != null) {
      this.knownRsdDeclarations.put(typeDeclaration.getQualifiedName(), typeDeclaration);
    }
  }

  protected URL getDocsTemplateURL() {
    return GEDCOMXDeploymentModule.class.getResource("docs.fmt");
  }

  protected URL getCodeTemplateURL() {
    return GEDCOMXDeploymentModule.class.getResource("code.fmt");
  }

  protected URL getRDFSchemaTemplateURL() {
    return GEDCOMXDeploymentModule.class.getResource("rdfschema.fmt");
  }

  @Override
  public void init(Enunciate enunciate) throws EnunciateException {
    super.init(enunciate);

    SortedSet<DeploymentModule> modules = enunciate.getConfig().getAllModules();
    for (DeploymentModule module : modules) {
      if (module instanceof ObjCDeploymentModule) {
        ((ObjCDeploymentModule)module).setTranslateIdTo("objectId");
      }
    }

    this.rdfProcessor = new RDFProcessor();
    this.resourceServiceProcessor = new ResourceServiceProcessor();
  }

  @Override
  public void initModel(EnunciateFreemarkerModel model) {
    super.initModel(model);

    Iterator<RootElementDeclaration> it = model.getRootElementDeclarations().iterator();
    while (it.hasNext()) {
      if (it.next().getAnnotation(DocIgnoreXmlRootElement.class) != null) {
        //remove any root elements that are requested to be kept separate from the docs.
        it.remove();
      }
    }

    Map<String,String> knownPrefixes = GedcomNamespaceManager.getKnownPrefixes();
    model.getNamespacesToPrefixes().putAll(knownPrefixes);
    for (SchemaInfo schemaInfo : model.getNamespacesToSchemas().values()) {
      String knownPrefix = knownPrefixes.get(schemaInfo.getNamespace());
      if (knownPrefix != null) {
        schemaInfo.setId(knownPrefix);
      }

      it = schemaInfo.getGlobalElements().iterator();
      while (it.hasNext()) {
        if (it.next().getAnnotation(DocIgnoreXmlRootElement.class) != null) {
          //remove any root elements that are requested to be kept separate from the docs.
          it.remove();
        }
      }
    }

    Collection<TypeDeclaration> namespaceDeclarations = gatherNamespaceDeclarations();
    Map<String, String> prefix_version_to_ns = new HashMap<String, String>();
    for (TypeDeclaration namespacesDeclaration : namespaceDeclarations) {
      info("Found namespaces declaration at %s.", namespacesDeclaration.getQualifiedName());
      Namespaces namespacesInfo = namespacesDeclaration.getAnnotation(Namespaces.class);
      for (Namespace ns : namespacesInfo.value()) {
        String id = ns.id();
        SchemaInfo schemaInfo = model.getNamespacesToSchemas().get(ns.uri());
        model.getNamespacesToPrefixes().put(ns.uri(), id);
        if (schemaInfo != null) {
          String version = ns.version();

          schemaInfo.setProperty("version", version);

          String xmlMediaType = ns.xmlMediaType();
          if ("".equals(xmlMediaType)) {
            xmlMediaType = null;
          }
          if (!schemaInfo.getGlobalElements().isEmpty() && xmlMediaType == null) {
            warn("Namespace %s is missing an xml media type for its root elements.", schemaInfo.getNamespace());
          }
          schemaInfo.setProperty("xmlMediaType", xmlMediaType);

          String jsonMediaType = ns.jsonMediaType();
          if ("".equals(jsonMediaType)) {
            jsonMediaType = null;
          }
          if (!schemaInfo.getGlobalElements().isEmpty() && jsonMediaType == null) {
            warn("Metadata for namespace %s is missing an json media type for its root elements.", schemaInfo.getNamespace());
          }
          schemaInfo.setProperty("jsonMediaType", jsonMediaType);

          schemaInfo.setId(id);
          String previousNamespace = prefix_version_to_ns.put(id + version, schemaInfo.getNamespace());
          if (previousNamespace != null && !previousNamespace.equals(schemaInfo.getNamespace())) {
            String message = namespacesDeclaration.getPosition() == null ?
              String.format("%s version %s is already being used by namespace %s.", id, version, previousNamespace) :
              String.format("%s: %s version %s is already being used by namespace %s.", namespacesDeclaration.getQualifiedName(), id, version, previousNamespace);
            throw new ValidationException(namespacesDeclaration.getPosition(), message);
          }

          String label = ns.label();
          if ("".equals(label)) {
            label = "\"" + id + "\" Namespace";
          }
          schemaInfo.setProperty("label", label);

          String description = ns.description();
          if ("".equals(description)) {
            description = null;
          }
          schemaInfo.setProperty("description", description);

          schemaInfo.setProperty("definesRDFSchema", ns.definesRDFSchema());

          //ensure the correct filenames are used for the schemas.
          schemaInfo.setProperty("filename", id + "-" + version + ".xsd");
          schemaInfo.setProperty("location", id + "-" + version + ".xsd");
        }
      }
    }

    ValidationResult validationResult = this.rdfProcessor.processModel(model);
    validationResult.aggregate(this.resourceServiceProcessor.processModel(model, this.knownRsdDeclarations.values()));
    Messager messager = Context.getCurrentEnvironment().getMessager();
    if (validationResult.hasWarnings()) {
      warn("Warnings while processing RDF and resource services.");
      for (ValidationMessage warning : validationResult.getWarnings()) {
        StringBuilder text = new StringBuilder();
        if (warning.getLabel() != null) {
          text.append('[').append(warning.getLabel()).append("] ");
        }
        text.append(warning.getText());

        if (warning.getPosition() != null) {
          messager.printWarning(warning.getPosition(), text.toString());
        }
        else {
          messager.printWarning(text.toString());
        }
      }
    }

    if (validationResult.hasErrors()) {
      for (ValidationMessage error : validationResult.getErrors()) {
        StringBuilder text = new StringBuilder();
        if (error.getLabel() != null) {
          text.append('[').append(error.getLabel()).append("] ");
        }
        text.append(error.getText());

        if (error.getPosition() != null) {
          messager.printError(error.getPosition(), text.toString());
        }
        else {
          messager.printError(text.toString());
        }
      }

      throw new RuntimeException("Errors while processing RDF and resource services.");
    }
  }

  protected Collection<TypeDeclaration> gatherNamespaceDeclarations() {
    return this.knownNamespaceDeclarations.values();
  }

  public void doFreemarkerGenerate() throws EnunciateException, IOException, TemplateException {
    //no-op...
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
      model.setVariable("generateExampleJson", new GenerateExampleJsonMethod(model));
      model.setVariable("generateExampleXml", new GenerateExampleXmlMethod(null, model));
      model.setVariable("typeName", new TypeNameMethod(model.getNamespacesToPrefixes()));
      model.setVariable("jsonExtensionElementName", new JsonExtensionElementNameMethod());
      model.put("rdfschema", this.rdfProcessor.getRdfSchema());
      model.put("resourceServiceDefinitions", this.resourceServiceProcessor.getResourceServiceDefinitions());
      model.put("resourceServiceBindings", this.resourceServiceProcessor.getResourceServiceBindings());
      try {
        for (SchemaInfo schemaInfo : model.getNamespacesToSchemas().values()) {
          String namespace = schemaInfo.getNamespace();
          if (Boolean.TRUE.equals(schemaInfo.getProperty("definesRDFSchema"))) {
            if (!this.rdfProcessor.isKnownRDFNamespace(namespace)) {
              model.put("schema", schemaInfo);
              processTemplate(getRDFSchemaTemplateURL(), model);
              schemaInfo.setProperty("rdfSchemaLocation", schemaInfo.getId() + ".rdf.xml");
            }
            else {
              schemaInfo.setProperty("rdfSchemaLocation", namespace);
            }
          }
        }
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

  @Override
  public Validator getValidator() {
    return new GEDCOMXValidator();
  }
}

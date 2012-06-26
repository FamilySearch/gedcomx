/**
 * Copyright 2011-2012 Intellectual Reserve, Inc.
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
import org.apache.commons.digester.RuleSet;
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
import org.gedcomx.build.enunciate.rdf.RDFProcessor;
import org.gedcomx.build.enunciate.rs.*;
import org.gedcomx.rt.*;
import org.gedcomx.rt.GedcomNamespaceManager;
import org.gedcomx.rt.rs.ResourceDefinition;
import org.gedcomx.test.Recipe;

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
public class GedcomxDeploymentModule extends FreemarkerDeploymentModule implements DocumentationAwareModule, EnunciateTypeDeclarationListener {

  private String projectId = CommonModels.GEDCOMX_PROJECT_ID;
  private String projectLabelModifier = null;
  private final Map<String, String> baseProjectUris = new HashMap<String, String>();
  private final Map<String, TypeDeclaration> knownModelDeclarations = new HashMap<String, TypeDeclaration>();
  private final Map<String, TypeDeclaration> knownRsdDeclarations = new HashMap<String, TypeDeclaration>();
  private RDFProcessor rdfProcessor;
  private ResourceServiceProcessor resourceServiceProcessor;
  private final Map<String, String> primaryNav = new LinkedHashMap<String, String>();
  private boolean disableProcessing = false;
  private RecipeClasspathHandler recipeManager;
  private String stylesheet;

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

  /**
   * Whether to disable processing.
   *
   * @return Whether to disable processing.
   */
  public boolean isDisableProcessing() {
    return disableProcessing;
  }

  /**
   * Whether to disable processing.
   *
   * @param disableProcessing Whether to disable processing.
   */
  public void setDisableProcessing(boolean disableProcessing) {
    this.disableProcessing = disableProcessing;
  }

  /**
   * Add a primary nav element.
   *
   * @param label The label for the nav.
   * @param href The href.
   */
  public void addPrimaryNav(String label, String href) {
    this.primaryNav.put(label, href);
  }

  /**
   * The id of the GEDCOM X project to be built.
   *
   * @param projectId The id of the GEDCOM X project to be built.
   */
  public void setProjectId(String projectId) {
    this.projectId = projectId;
  }

  public void setProjectLabelModifier(String projectLabelModifier) {
    this.projectLabelModifier = projectLabelModifier;
  }

  public void setStylesheet(String stylesheet) {
    this.stylesheet = stylesheet;
  }

  public void onTypeDeclarationInspected(TypeDeclaration typeDeclaration) {
    if (typeDeclaration.getAnnotation(Models.class) != null) {
      this.knownModelDeclarations.put(typeDeclaration.getQualifiedName(), typeDeclaration);
    }
    if (typeDeclaration.getAnnotation(ResourceDefinition.class) != null) {
      this.knownRsdDeclarations.put(typeDeclaration.getQualifiedName(), typeDeclaration);
    }
  }

  protected URL getDocsTemplateURL() {
    return GedcomxDeploymentModule.class.getResource("docs.fmt");
  }

  protected URL getCodeTemplateURL() {
    return GedcomxDeploymentModule.class.getResource("code.fmt");
  }

  protected URL getRDFSchemaTemplateURL() {
    return GedcomxDeploymentModule.class.getResource("rdfschema.fmt");
  }

  protected URL getRecipeTemplateURL() {
    return GedcomxDeploymentModule.class.getResource("recipes.fmt");
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
    this.recipeManager = new RecipeClasspathHandler(enunciate);
    enunciate.addClasspathHandler(this.recipeManager);
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

    Collection<TypeDeclaration> modelDeclarations = gatherModelDeclarations();
    Map<String, String> prefix_version_to_ns = new HashMap<String, String>();
    for (TypeDeclaration modelDeclaration : modelDeclarations) {
      info("Found model declaration at %s.", modelDeclaration.getQualifiedName());
      Models modelsInfo = modelDeclaration.getAnnotation(Models.class);
      for (Model m : modelsInfo.value()) {
        String id = m.id();
        SchemaInfo schemaInfo = model.getNamespacesToSchemas().get(m.namespace());
        model.getNamespacesToPrefixes().put(m.namespace(), id);
        if (schemaInfo != null) {
          String version = m.version();

          schemaInfo.setProperty("version", version);

          String xmlMediaType = m.xmlMediaType();
          if ("".equals(xmlMediaType)) {
            xmlMediaType = null;
          }
          if (!schemaInfo.getGlobalElements().isEmpty() && xmlMediaType == null) {
            warn("Model %s is missing an xml media type for its root elements.", schemaInfo.getNamespace());
          }
          schemaInfo.setProperty("xmlMediaType", xmlMediaType);

          String jsonMediaType = m.jsonMediaType();
          if ("".equals(jsonMediaType)) {
            jsonMediaType = null;
          }
          if (!schemaInfo.getGlobalElements().isEmpty() && jsonMediaType == null) {
            warn("Metadata for model %s is missing an json media type for its root elements.", schemaInfo.getNamespace());
          }
          schemaInfo.setProperty("jsonMediaType", jsonMediaType);

          schemaInfo.setId(id);
          String previousNamespace = prefix_version_to_ns.put(id + version, schemaInfo.getNamespace());
          if (previousNamespace != null && !previousNamespace.equals(schemaInfo.getNamespace())) {
            String message = modelDeclaration.getPosition() == null ?
              String.format("%s version %s is already being used by model %s.", id, version, previousNamespace) :
              String.format("%s: %s version %s is already being used by model %s.", modelDeclaration.getQualifiedName(), id, version, previousNamespace);
            throw new ValidationException(modelDeclaration.getPosition(), message);
          }

          String label = m.label();
          if ("".equals(label)) {
            label = "\"" + id + "\" Model";
          }
          schemaInfo.setProperty("label", label);

          String description = m.description();
          if ("".equals(description)) {
            description = null;
          }
          schemaInfo.setProperty("description", description);
          schemaInfo.setProperty("definesRDFSchema", m.definesRDFSchema());

          schemaInfo.setProperty("projectId", m.projectId());

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

  protected Collection<TypeDeclaration> gatherModelDeclarations() {
    return this.knownModelDeclarations.values();
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
      model.setVariable("generateExampleRequestHeaders", new GenerateExampleRequestHeadersMethod(model));
      model.setVariable("generateExampleRequestBody", new GenerateExampleRequestBodyMethod(model));
      model.setVariable("generateExampleResponseHeaders", new GenerateExampleResponseHeadersMethod(model));
      model.setVariable("generateExampleResponseBody", new GenerateExampleResponseBodyMethod(model));
      model.setVariable("typeName", new TypeNameMethod());
      model.setVariable("jsonExtensionElementName", new JsonExtensionElementNameMethod());
      model.put("rdfschema", this.rdfProcessor.getRdfSchema());
      model.put("resourceDefinitions", this.resourceServiceProcessor.getResourceDefinitions());
      model.put("resourceBindingsByPath", this.resourceServiceProcessor.getBindingsByPath());
      model.put("primaryNav", this.primaryNav);
      model.put("projectId", this.projectId);
      if (this.projectLabelModifier != null) {
        model.put("projectLabelModifier", this.projectLabelModifier);
      }
      model.put("isOfProject", new IsOfProjectMethod(getModelInternal().getNamespacesToSchemas(), projectId));
      model.put("baseProjectUri", new BaseProjectUriMethod(getBaseProjectUris(), getModelInternal().getNamespacesToSchemas()));
      try {
        for (SchemaInfo schemaInfo : model.getNamespacesToSchemas().values()) {
          String namespace = schemaInfo.getNamespace();
          if (Boolean.TRUE.equals(schemaInfo.getProperty("definesRDFSchema"))) {
            if (!this.rdfProcessor.isKnownRDFNamespace(namespace)) {
              model.put("schema", schemaInfo);
              if (!isDisableProcessing()) {
                processTemplate(getRDFSchemaTemplateURL(), model);
              }
              schemaInfo.setProperty("rdfSchemaLocation", schemaInfo.getId() + ".rdf.xml");
            }
            else {
              schemaInfo.setProperty("rdfSchemaLocation", namespace);
            }
          }
        }

        List<Recipe> recipes = this.recipeManager.getRecipes();
        Map<String, List<Recipe>> recipesByFqn = new HashMap<String, List<Recipe>>();
        for (Recipe recipe : recipes) {
          for (String modelFqn : recipe.getApplicableTypes()) {
            List<Recipe> recipeList = recipesByFqn.get(modelFqn);
            if (recipeList == null) {
              recipeList = new ArrayList<Recipe>();
              recipesByFqn.put(modelFqn, recipeList);
            }
            recipeList.add(recipe);
          }
        }

        model.put("recipes", recipes);
        model.put("recipesByFqn", recipesByFqn);

        if (!isDisableProcessing()) {
          processTemplate(getDocsTemplateURL(), model);
          processTemplate(getCodeTemplateURL(), model);
          processTemplate(getRecipeTemplateURL(), model);
        }
      }
      catch (TemplateException e) {
        throw new EnunciateException(e);
      }
    }
    else {
      info("Skipping build of documentation as everything appears up-to-date...");
    }

    //export the generated documentation as an artifact.
    getEnunciate().addArtifact(new FileArtifact(getName(), "gedcomx-docs", getBuildDir()));
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

    enunciate.extractBase(GedcomxDeploymentModule.class.getResourceAsStream("/docs.base.zip"), buildDir);
    if (this.stylesheet != null) {
      File styleSheet = enunciate.resolvePath(stylesheet);
      enunciate.copyFile(styleSheet, new File(new File(buildDir, "css"), "style.css"));
    }

    for (SchemaInfo schemaInfo : getModel().getNamespacesToSchemas().values()) {
      if (schemaInfo.getProperty("file") != null) {
        File from = (File) schemaInfo.getProperty("file");
        String filename = schemaInfo.getProperty("filename") != null ? (String) schemaInfo.getProperty("filename") : from.getName();
        File to = new File(buildDir, filename);
        enunciate.copyFile(from, to);
      }
    }

    for (WsdlInfo wsdlInfo : getModel().getNamespacesToWSDLs().values()) {
      if (wsdlInfo.getProperty("file") != null) {
        File from = (File) wsdlInfo.getProperty("file");
        String filename = wsdlInfo.getProperty("filename") != null ? (String) wsdlInfo.getProperty("filename") : from.getName();
        File to = new File(buildDir, filename);
        enunciate.copyFile(from, to);
      }
    }

    File wadlFile = getModelInternal().getWadlFile();
    if (wadlFile != null) {
      enunciate.copyFile(wadlFile, new File(buildDir, wadlFile.getName()));
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
    return new GedcomxValidator();
  }

  @Override
  public RuleSet getConfigurationRules() {
    return new GedcomxRuleSet();
  }

  public Map<String, String> getBaseProjectUris() {
    return baseProjectUris;
  }

  public void putProjectBase(String id, String uri) {
    this.baseProjectUris.put(id, uri);
  }

}

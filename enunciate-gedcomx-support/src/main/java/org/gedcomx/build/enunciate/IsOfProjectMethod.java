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

import freemarker.ext.beans.BeansWrapper;
import freemarker.template.TemplateMethodModelEx;
import freemarker.template.TemplateModel;
import freemarker.template.TemplateModelException;
import org.codehaus.enunciate.config.SchemaInfo;
import org.codehaus.enunciate.contract.jaxb.Accessor;
import org.codehaus.enunciate.contract.jaxb.RootElementDeclaration;
import org.codehaus.enunciate.contract.jaxb.TypeDefinition;
import org.codehaus.enunciate.contract.jaxb.types.XmlType;
import org.gedcomx.build.enunciate.rs.ResourceDefinitionDeclaration;

import java.util.List;
import java.util.Map;

/**
 * @author Ryan Heaton
 */
public class IsOfProjectMethod implements TemplateMethodModelEx {

  final String currentProjectId;
  final Map<String, SchemaInfo> namespacesToSchemas;

  public IsOfProjectMethod(Map<String, SchemaInfo> namespacesToSchemas, String currentProjectId) {
    this.namespacesToSchemas = namespacesToSchemas;
    this.currentProjectId = currentProjectId;
  }

  @Override
  public Object exec(List list) throws TemplateModelException {
    if (list.size() < 1) {
      throw new TemplateModelException("The IsOfProjectMethod method must take something with a namespace and a project id as a parameter.");
    }

    Object object = BeansWrapper.getDefaultInstance().unwrap((TemplateModel) list.get(0));
    if (object instanceof ResourceDefinitionDeclaration) {
      String projectId = list.size() > 1 ? String.valueOf(BeansWrapper.getDefaultInstance().unwrap((TemplateModel) list.get(1))) : this.currentProjectId;
      return projectId.equals(((ResourceDefinitionDeclaration) object).getProjectId());
    }
    else {
      String ns;
      if (object instanceof SchemaInfo) {
        ns = ((SchemaInfo) object).getNamespace();
      }
      else if (object instanceof TypeDefinition) {
        ns = ((TypeDefinition) object).getNamespace();
      }
      else if (object instanceof RootElementDeclaration) {
        ns = ((RootElementDeclaration) object).getNamespace();
      }
      else if (object instanceof XmlType) {
        ns = ((XmlType) object).getNamespace();
      }
      else if (object instanceof Accessor) {
        ns = ((Accessor) object).getNamespace();
      }
      else {
        ns = String.valueOf(object);
      }

      SchemaInfo schemaInfo = this.namespacesToSchemas.get(ns);
      String projectId = list.size() > 1 ? String.valueOf(BeansWrapper.getDefaultInstance().unwrap((TemplateModel) list.get(1))) : this.currentProjectId;
      return isOfProject(schemaInfo, projectId);
    }
  }

  public static boolean isOfProject(SchemaInfo schemaInfo, String projectId) {
    return (schemaInfo != null && projectId.equals(schemaInfo.getProperty("projectId")));
  }
}
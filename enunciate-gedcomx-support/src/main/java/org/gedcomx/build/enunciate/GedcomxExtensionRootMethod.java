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
import org.gedcomx.build.enunciate.rs.ResourceServiceDefinitionDeclaration;

import java.util.List;

/**
 * @author Ryan Heaton
 */
public class GedcomxExtensionRootMethod implements TemplateMethodModelEx {

  private final String gedcomxRoot;

  public GedcomxExtensionRootMethod(String gedcomxRoot) {
    this.gedcomxRoot = gedcomxRoot;
  }

  @Override
  public Object exec(List list) throws TemplateModelException {
    if (list.size() < 1) {
      throw new TemplateModelException("The IsGedcomxNamespace method must have a string as a parameter.");
    }

    Object object = BeansWrapper.getDefaultInstance().unwrap((TemplateModel) list.get(0));
    if (object instanceof ResourceServiceDefinitionDeclaration) {
      if (IsGedcomxNamespaceMethod.isGedcomxNamepace(((ResourceServiceDefinitionDeclaration) object).getNamespace())) {
        return this.gedcomxRoot + "rs/";
      }
    }
    else if (object instanceof SchemaInfo) {
      if (IsGedcomxNamespaceMethod.isGedcomxNamepace(((SchemaInfo) object).getNamespace())) {
        return this.gedcomxRoot + "model/";
      }
    }
    else if (object instanceof XmlType) {
      if (IsGedcomxNamespaceMethod.isGedcomxNamepace(((XmlType) object).getNamespace())) {
        return this.gedcomxRoot + "model/";
      }
    }
    else if (object instanceof Accessor) {
      if (IsGedcomxNamespaceMethod.isGedcomxNamepace(((Accessor) object).getBaseType().getNamespace())) {
        return this.gedcomxRoot + "model/";
      }
    }
    else if (object instanceof TypeDefinition) {
      if (IsGedcomxNamespaceMethod.isGedcomxNamepace(((TypeDefinition) object).getNamespace())) {
        return this.gedcomxRoot + "model/";
      }
    }
    else if (object instanceof RootElementDeclaration) {
      if (IsGedcomxNamespaceMethod.isGedcomxNamepace(((RootElementDeclaration) object).getNamespace())) {
        return this.gedcomxRoot + "model/";
      }
    }
    else {
      if (IsGedcomxNamespaceMethod.isGedcomxNamepace(String.valueOf(object))) {
        return this.gedcomxRoot;
      }
    }

    return "";
  }
}
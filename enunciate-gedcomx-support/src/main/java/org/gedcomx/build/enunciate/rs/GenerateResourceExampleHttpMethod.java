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
package org.gedcomx.build.enunciate.rs;

import freemarker.ext.beans.BeansWrapper;
import freemarker.template.TemplateMethodModelEx;
import freemarker.template.TemplateModel;
import freemarker.template.TemplateModelException;
import org.codehaus.enunciate.apt.EnunciateFreemarkerModel;
import org.codehaus.enunciate.contract.jaxb.ElementDeclaration;
import org.codehaus.enunciate.contract.jaxb.RootElementDeclaration;
import org.codehaus.enunciate.contract.jaxrs.ResourceMethod;

import javax.xml.namespace.QName;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Ryan Heaton
 */
public abstract class GenerateResourceExampleHttpMethod implements TemplateMethodModelEx {

  final EnunciateFreemarkerModel model;

  protected GenerateResourceExampleHttpMethod(EnunciateFreemarkerModel model) {
    this.model = model;
  }

  public Object exec(List list) throws TemplateModelException {
    if (list.size() < 1) {
      throw new TemplateModelException("The generateExampleRequestHeaders method must have a resource method as a parameter.");
    }

    Object object = BeansWrapper.getDefaultInstance().unwrap((TemplateModel) list.get(0));

    ResourceMethod resourceMethod;
    if (object instanceof ResourceMethod) {
      resourceMethod = (ResourceMethod) object;
    }
    else {
      throw new TemplateModelException("The generateExampleRequestHeaders method must have a resource method as a parameter.");
    }

    ResourceServiceDefinitionDeclaration def;
    if (resourceMethod.getParent() instanceof ResourceServiceDefinitionDeclaration) {
      def = (ResourceServiceDefinitionDeclaration) resourceMethod.getParent();
    }
    else if (resourceMethod.getMetaData().get("serviceBinding") instanceof ResourceServiceBindingMetadata) {
      ResourceServiceBindingMetadata binding = (ResourceServiceBindingMetadata) resourceMethod.getMetaData().get("serviceBinding");
      def = binding.getDefinition();
    }
    else {
      throw new TemplateModelException("Unable to find a resource definition for " + resourceMethod.toString());
    }

    List<ElementDeclaration> elements = def.getResourceElements();
    RootElementDeclaration element = null;
    if (elements.size() > 0) {
      element = (RootElementDeclaration) elements.get(0);
    }

    Map<QName, ResourceServiceDefinitionDeclaration> subresourcesByType = new HashMap<QName, ResourceServiceDefinitionDeclaration>();
    List<ResourceServiceDefinitionDeclaration> subresourceDeclarations = def.getSubresources();
    for (ResourceServiceDefinitionDeclaration subresourceDeclaration : subresourceDeclarations) {
      for (ElementDeclaration subresource : subresourceDeclaration.getResourceElements()) {
        subresourcesByType.put(((RootElementDeclaration) subresource).getTypeDefinition().getQname(), subresourceDeclaration);
      }
    }

    boolean json = list.size() > 1 && Boolean.TRUE.equals(BeansWrapper.getDefaultInstance().unwrap((TemplateModel) list.get(1)));
    return generateExample(def, resourceMethod, element, subresourcesByType, json);
  }

  protected abstract Object generateExample(ResourceServiceDefinitionDeclaration def, ResourceMethod resourceMethod, RootElementDeclaration element, Map<QName, ResourceServiceDefinitionDeclaration> subresourcesByType, boolean json);
}
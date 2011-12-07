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
import org.codehaus.enunciate.contract.jaxrs.ResourceEntityParameter;
import org.codehaus.enunciate.contract.jaxrs.ResourceMethod;
import org.codehaus.enunciate.contract.jaxrs.ResourceRepresentationMetadata;

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

    ResourceDefinitionDeclaration def = null;
    if (resourceMethod.getParent() instanceof ResourceDefinitionDeclaration) {
      def = (ResourceDefinitionDeclaration) resourceMethod.getParent();
    }
    else if (resourceMethod.getMetaData().get("definedBy") instanceof ResourceDefinitionDeclaration) {
      def = (ResourceDefinitionDeclaration) resourceMethod.getMetaData().get("definedBy");
    }

    RootElementDeclaration element = null;
    if (def != null) {
      List<ElementDeclaration> elements = def.getResourceElements();
      if (elements.size() > 0) {
        element = (RootElementDeclaration) elements.get(0);
      }
    }
    else {
      ResourceRepresentationMetadata representationMetadata = resourceMethod.getRepresentationMetadata();
      if (representationMetadata != null) {
        element = (RootElementDeclaration) representationMetadata.getXmlElement();
      }
      else {
        ResourceEntityParameter entityParam = resourceMethod.getEntityParameter();
        if (entityParam != null) {
          element = (RootElementDeclaration) entityParam.getXmlElement();
        }
      }
    }

    Map<QName, ResourceDefinitionDeclaration> subresourcesByType = new HashMap<QName, ResourceDefinitionDeclaration>();
    if (def != null) {
      List<ResourceDefinitionDeclaration> subresourceDeclarations = def.getSubresources();
      for (ResourceDefinitionDeclaration subresourceDeclaration : subresourceDeclarations) {
        for (ElementDeclaration subresource : subresourceDeclaration.getResourceElements()) {
          subresourcesByType.put(((RootElementDeclaration) subresource).getTypeDefinition().getQname(), subresourceDeclaration);
        }
      }
    }

    boolean json = list.size() > 1 && Boolean.TRUE.equals(BeansWrapper.getDefaultInstance().unwrap((TemplateModel) list.get(1)));
    //todo: validate that the method actually produces,consumes json?
    return generateExample(def, resourceMethod, element, subresourcesByType, json);
  }

  protected abstract Object generateExample(ResourceDefinitionDeclaration def, ResourceMethod resourceMethod, RootElementDeclaration element, Map<QName, ResourceDefinitionDeclaration> subresourcesByType, boolean json);
}
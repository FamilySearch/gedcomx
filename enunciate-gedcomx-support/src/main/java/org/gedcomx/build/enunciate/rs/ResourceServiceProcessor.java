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

import com.sun.mirror.declaration.ClassDeclaration;
import com.sun.mirror.declaration.Declaration;
import com.sun.mirror.declaration.InterfaceDeclaration;
import com.sun.mirror.declaration.TypeDeclaration;
import com.sun.mirror.type.InterfaceType;
import com.sun.mirror.type.MirroredTypesException;
import org.codehaus.enunciate.apt.EnunciateFreemarkerModel;
import org.codehaus.enunciate.contract.jaxb.ElementDeclaration;
import org.codehaus.enunciate.contract.jaxb.RootElementDeclaration;
import org.codehaus.enunciate.contract.jaxrs.RootResource;
import org.codehaus.enunciate.contract.jaxrs.SubResourceLocator;
import org.codehaus.enunciate.contract.validation.ValidationResult;
import org.gedcomx.rt.rs.ResourceRelationships;
import org.gedcomx.rt.rs.ResourceServiceBinding;
import org.gedcomx.rt.rs.ResourceServiceDefinition;
import org.gedcomx.rt.rs.StatusCodes;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Basic processor for validating integration the model with RDF.
 *
 * @author Ryan Heaton
 */
public class ResourceServiceProcessor {

  private final List<ResourceServiceDefinitionDeclaration> resourceServiceDefinitions = new ArrayList<ResourceServiceDefinitionDeclaration>();
  private final List<ResourceServiceBindingMetadata> resourceServiceBindings = new ArrayList<ResourceServiceBindingMetadata>();
  private final List<ClassDeclaration> resourceServiceImplementations = new ArrayList<ClassDeclaration>();

  public List<ResourceServiceDefinitionDeclaration> getResourceServiceDefinitions() {
    return resourceServiceDefinitions;
  }

  public List<ResourceServiceBindingMetadata> getResourceServiceBindings() {
    return resourceServiceBindings;
  }

  public List<ClassDeclaration> getResourceServiceImplementations() {
    return resourceServiceImplementations;
  }

  public ValidationResult processModel(EnunciateFreemarkerModel model, Collection<TypeDeclaration> resourceServiceDefinitions) {
    ValidationResult result = new ValidationResult();

    //todo: error if setter-based resource parameters in the implementation don't carry the annotations defined in the definition, binding...

    for (TypeDeclaration resourceServiceDefinition : resourceServiceDefinitions) {
      ResourceServiceDefinition rsdInfo = resourceServiceDefinition.getAnnotation(ResourceServiceDefinition.class);
      if (rsdInfo != null) {
        List<String> resourceElementsFqn = new ArrayList<String>();

        try {
          Class<?>[] classes = rsdInfo.resourceElement();
          for (Class<?> clazz : classes) {
            resourceElementsFqn.add(clazz.getName());
          }
        }
        catch (MirroredTypesException e) {
          resourceElementsFqn.addAll(e.getQualifiedNames());
        }

        List<RootElementDeclaration> rootElementDeclarations = model.getRootElementDeclarations();
        ArrayList<ElementDeclaration> resourceElements = new ArrayList<ElementDeclaration>();
        for (String resourceElementFqn : resourceElementsFqn) {
          ElementDeclaration resourceElement = null;
          for (RootElementDeclaration rootElementDeclaration : rootElementDeclarations) {
            if (resourceElementFqn.equals(rootElementDeclaration.getQualifiedName())) {
              resourceElement = rootElementDeclaration;
              break;
            }
          }

          if (resourceElement == null) {
            result.addWarning(resourceServiceDefinition, "Unable to find element declaration for " + resourceElementFqn + ".");
          }

          else {
            resourceElements.add(resourceElement);
          }
        }

        ResourceServiceDefinitionDeclaration rsd = new ResourceServiceDefinitionDeclaration(resourceServiceDefinition, resourceElements, this);
        //todo: validate the rsd:
        //todo: iterate through the subresource qualified names to make sure each one is annotated with @ResourceServiceDefinition
        this.resourceServiceDefinitions.add(rsd);
      }
      else {
        result.addWarning(resourceServiceDefinition, "No @ResourceServiceDefinition found.");
      }
    }

    for (RootResource rootResource : model.getRootResources()) {
      ResourceServiceBindingMetadata bindingMetadata = ResourceServiceBindingMetadata.decorate(rootResource, this);
      if (bindingMetadata != null) {
        this.resourceServiceBindings.add(bindingMetadata);
      }

      List<SubResourceLocator> resourceLocators = rootResource.getResourceLocators();
      for (SubResourceLocator resourceLocator : resourceLocators) {
        bindingMetadata = ResourceServiceBindingMetadata.decorate(resourceLocator.getResource(), this);
        if (bindingMetadata != null) {
          this.resourceServiceBindings.add(bindingMetadata);
        }
      }
    }

    return result;
  }

  public List<ResourceRelationship> extractResourceRelationships(TypeDeclaration delegate) {
    List<ResourceRelationship> rels = new ArrayList<ResourceRelationship>();
    org.gedcomx.rt.rs.ResourceRelationship[] resourceRelationshipInfo = {};
    ResourceRelationships resourceRelationships = delegate.getAnnotation(ResourceRelationships.class);
    if (resourceRelationships != null) {
      resourceRelationshipInfo = resourceRelationships.value();
    }
    for (org.gedcomx.rt.rs.ResourceRelationship rel : resourceRelationshipInfo) {
      rels.add(new ResourceRelationship(rel, this));
    }

    Collection<InterfaceType> supers = delegate.getSuperinterfaces();
    for (InterfaceType iface : supers) {
      InterfaceDeclaration decl = iface.getDeclaration();
      if (decl != null && decl.getAnnotation(ResourceServiceDefinition.class) == null && decl.getAnnotation(ResourceServiceBinding.class) == null) {
        rels.addAll(extractResourceRelationships(decl));
      }
    }

    return rels;
  }

  public List<StatusCode> extractStatusCodes(Declaration delegate) {
    List<StatusCode> codes = new ArrayList<StatusCode>();
    org.gedcomx.rt.rs.StatusCode[] statusCodes = {};
    StatusCodes statusCodesContainer = delegate.getAnnotation(StatusCodes.class);
    if (statusCodesContainer != null) {
      statusCodes = statusCodesContainer.value();
    }
    for (org.gedcomx.rt.rs.StatusCode statusCode : statusCodes) {
      codes.add(new StatusCode(statusCode.code(), statusCode.condition(), statusCode.warningCode() >= 0 ? statusCode.warningCode() : null));
    }

    if (delegate instanceof TypeDeclaration) {
      Collection<InterfaceType> supers = ((TypeDeclaration) delegate).getSuperinterfaces();
      for (InterfaceType iface : supers) {
        InterfaceDeclaration decl = iface.getDeclaration();
        if (decl != null && decl.getAnnotation(ResourceServiceDefinition.class) == null && decl.getAnnotation(ResourceServiceBinding.class) == null) {
          codes.addAll(extractStatusCodes(decl));
        }
      }
    }

    return codes;
  }

  public ResourceServiceDefinitionDeclaration findResourceService(String fqn) {
    for (ResourceServiceDefinitionDeclaration definition : resourceServiceDefinitions) {
      if (fqn.equals(definition.getQualifiedName())) {
        return definition;
      }
    }
    return null;
  }
}

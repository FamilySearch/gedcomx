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

import com.sun.mirror.declaration.ClassDeclaration;
import com.sun.mirror.declaration.Declaration;
import com.sun.mirror.declaration.TypeDeclaration;
import com.sun.mirror.type.InterfaceType;
import org.codehaus.enunciate.apt.EnunciateFreemarkerModel;
import org.codehaus.enunciate.contract.jaxrs.ResourceMethod;
import org.codehaus.enunciate.contract.jaxrs.RootResource;
import org.codehaus.enunciate.contract.validation.ValidationResult;
import org.gedcomx.rt.www.LinkRelationships;
import org.gedcomx.rt.www.ResourceServiceBinding;
import org.gedcomx.rt.www.StatusCodes;

import java.util.*;

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

    //todo: warn if links are defined across multiple resource service definitions
    //todo: error if setter-based resource parameters in the implementation don't carry the annotations defined in the definition, binding...

    for (TypeDeclaration resourceServiceDefinition : resourceServiceDefinitions) {
      this.resourceServiceDefinitions.add(new ResourceServiceDefinitionDeclaration(resourceServiceDefinition));
    }

    for (RootResource rootResource : model.getRootResources()) {
      ResourceServiceBinding bindingInfo = rootResource.getAnnotation(ResourceServiceBinding.class);
      if (bindingInfo != null) {

        String name = rootResource.getSimpleName();
        if (!"##default".equals(bindingInfo.name())) {
          name = bindingInfo.name();
        }

        String namespace = "";
        if (!"##default".equals(bindingInfo.namespace())) {
          //todo: use xml schema namespace?
          namespace = bindingInfo.namespace();
        }

        Set<ResourceServiceDefinitionDeclaration> defs = new HashSet<ResourceServiceDefinitionDeclaration>();
        gatherDefinitions(rootResource.getDelegate(), defs);
        ResourceServiceBindingMetadata bindingMetadata = new ResourceServiceBindingMetadata(name, namespace, rootResource, defs);

        List<ResourceMethod> resourceMethods = rootResource.getResourceMethods();
        for (ResourceMethod resourceMethod : resourceMethods) {
          resourceMethod.putMetaData("serviceBinding", bindingMetadata);
        }

        this.resourceServiceBindings.add(bindingMetadata);
      }

      List<ResourceMethod> resourceMethods = rootResource.getResourceMethods();
      for (ResourceMethod resourceMethod : resourceMethods) {
        resourceMethod.putMetaData("statusCodes", extractStatusCodes(resourceMethod));
        resourceMethod.putMetaData("linkRelationships", extractLinkRelationships(resourceMethod));
      }
    }

    return result;
  }

  private void gatherDefinitions(Declaration delegate, Set<ResourceServiceDefinitionDeclaration> defs) {
    if (delegate instanceof TypeDeclaration) {
      TypeDeclaration typeDeclaration = (TypeDeclaration) delegate;
      if (!Object.class.getName().equals(typeDeclaration.getQualifiedName())) {
        for (ResourceServiceDefinitionDeclaration resourceServiceDefinition : resourceServiceDefinitions) {
          if (typeDeclaration.getQualifiedName().equals(resourceServiceDefinition.getQualifiedName())) {
            defs.add(resourceServiceDefinition);
          }
        }

        Collection<InterfaceType> supers = typeDeclaration.getSuperinterfaces();
        for (InterfaceType superif : supers) {
          if (superif.getDeclaration() != null) {
            String fqn = superif.getDeclaration().getQualifiedName();
            for (ResourceServiceDefinitionDeclaration resourceServiceDefinition : resourceServiceDefinitions) {
              if (fqn.equals(resourceServiceDefinition.getQualifiedName())) {
                defs.add(resourceServiceDefinition);
              }
            }
          }
        }

        if (typeDeclaration instanceof ClassDeclaration) {
          ClassDeclaration superDecl = ((ClassDeclaration) typeDeclaration).getSuperclass().getDeclaration();
          if (superDecl != null) {
            gatherDefinitions(superDecl, defs);
          }
        }
      }
    }
  }

  public static List<LinkRelationship> extractLinkRelationships(Declaration delegate) {
    List<LinkRelationship> linkRelationships = new ArrayList<LinkRelationship>();
    org.gedcomx.rt.www.LinkRelationship[] linkRelationshipInfo = {};
    LinkRelationships linkRelationshipsInfo = delegate.getAnnotation(LinkRelationships.class);
    if (linkRelationshipsInfo != null) {
      linkRelationshipInfo = linkRelationshipsInfo.value();
    }
    for (org.gedcomx.rt.www.LinkRelationship linkRelationship : linkRelationshipInfo) {
      ResourceServiceDefinitionDeclaration definedBy = null;
      //todo: find the resource service def decl.
      linkRelationships.add(new LinkRelationship(linkRelationship.name(), linkRelationship.description(), definedBy));
    }
    return linkRelationships;
  }

  public static List<StatusCode> extractStatusCodes(Declaration delegate) {
    List<StatusCode> statusCodes = new ArrayList<StatusCode>();
    org.gedcomx.rt.www.StatusCode[] statusCodeInfo = {};
    StatusCodes statusCodesInfo = delegate.getAnnotation(StatusCodes.class);
    if (statusCodesInfo != null) {
      statusCodeInfo = statusCodesInfo.value();
    }
    for (org.gedcomx.rt.www.StatusCode statusCode : statusCodeInfo) {
      statusCodes.add(new StatusCode(statusCode.code(), statusCode.condition()));
    }
    return statusCodes;
  }

}

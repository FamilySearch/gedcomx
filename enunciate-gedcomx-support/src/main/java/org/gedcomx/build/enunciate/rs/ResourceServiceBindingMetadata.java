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
import com.sun.mirror.declaration.TypeDeclaration;
import com.sun.mirror.type.InterfaceType;
import org.codehaus.enunciate.contract.jaxrs.Resource;
import org.codehaus.enunciate.contract.jaxrs.ResourceMethod;
import org.gedcomx.rt.rs.ResourceServiceBinding;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Ryan Heaton
 */
public class ResourceServiceBindingMetadata {

  private final String name;
  private final String namespace;
  private final Resource rawResource;
  private final Set<ResourceServiceDefinitionDeclaration> definitions;
  private final List<StatusCode> statusCodes;
  private final List<ResourceRelationship> resourceRelationships;

  public ResourceServiceBindingMetadata(String name, String namespace, Resource rawResource, Set<ResourceServiceDefinitionDeclaration> definitions, List<StatusCode> statusCodes, List<ResourceRelationship> resourceRelationships) {
    this.name = name;
    this.namespace = namespace;
    this.rawResource = rawResource;
    this.definitions = definitions;
    this.statusCodes = statusCodes;
    this.resourceRelationships = resourceRelationships;
  }

  public String getName() {
    return name;
  }

  public String getNamespace() {
    return namespace;
  }

  public Resource getRawResource() {
    return rawResource;
  }

  public Set<ResourceServiceDefinitionDeclaration> getDefinitions() {
    return definitions;
  }

  public List<StatusCode> getStatusCodes() {
    return statusCodes;
  }

  public List<ResourceRelationship> getResourceRelationships() {
    return resourceRelationships;
  }

  public static ResourceServiceBindingMetadata decorate(Resource rawResource, ResourceServiceProcessor processor) {
    ResourceServiceBinding bindingInfo = rawResource.getAnnotation(ResourceServiceBinding.class);
    ResourceServiceBindingMetadata bindingMetadata = null;
    if (bindingInfo != null) {

      String name = rawResource.getSimpleName();
      if (!"##default".equals(bindingInfo.name())) {
        name = bindingInfo.name();
      }

      String namespace = "";
      if (!"##default".equals(bindingInfo.namespace())) {
        //todo: use xml schema namespace?
        namespace = bindingInfo.namespace();
      }

      Set<ResourceServiceDefinitionDeclaration> defs = new HashSet<ResourceServiceDefinitionDeclaration>();
      gatherDefinitions(rawResource.getDelegate(), defs, processor);
      bindingMetadata = new ResourceServiceBindingMetadata(name, namespace, rawResource, defs, processor.extractStatusCodes(rawResource), processor.extractResourceRelationships(rawResource));

      List<ResourceMethod> resourceMethods = rawResource.getResourceMethods();
      for (ResourceMethod resourceMethod : resourceMethods) {
        resourceMethod.putMetaData("serviceBinding", bindingMetadata);
      }
    }

    List<ResourceMethod> resourceMethods = rawResource.getResourceMethods();
    for (ResourceMethod resourceMethod : resourceMethods) {
      resourceMethod.putMetaData("statusCodes", processor.extractStatusCodes(resourceMethod));
    }

    return bindingMetadata;
  }

  private static void gatherDefinitions(Declaration delegate, Set<ResourceServiceDefinitionDeclaration> defs, ResourceServiceProcessor processor) {
    if (delegate instanceof TypeDeclaration) {
      TypeDeclaration typeDeclaration = (TypeDeclaration) delegate;
      if (!Object.class.getName().equals(typeDeclaration.getQualifiedName())) {
        ResourceServiceDefinitionDeclaration rs = processor.findResourceService(typeDeclaration.getQualifiedName());
        if (rs != null) {
          defs.add(rs);
        }

        Collection<InterfaceType> supers = typeDeclaration.getSuperinterfaces();
        for (InterfaceType superif : supers) {
          if (superif.getDeclaration() != null) {
            String fqn = superif.getDeclaration().getQualifiedName();
            rs = processor.findResourceService(fqn);
            if (rs != null) {
              defs.add(rs);
            }
          }
        }

        if (typeDeclaration instanceof ClassDeclaration) {
          ClassDeclaration superDecl = ((ClassDeclaration) typeDeclaration).getSuperclass().getDeclaration();
          if (superDecl != null) {
            gatherDefinitions(superDecl, defs, processor);
          }
        }
      }
    }
  }

}

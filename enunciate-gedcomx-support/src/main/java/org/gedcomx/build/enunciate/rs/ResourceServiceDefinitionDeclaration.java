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

import com.sun.mirror.declaration.InterfaceDeclaration;
import com.sun.mirror.declaration.TypeDeclaration;
import com.sun.mirror.type.InterfaceType;
import com.sun.mirror.type.MirroredTypesException;
import org.codehaus.enunciate.contract.jaxb.ElementDeclaration;
import org.codehaus.enunciate.contract.jaxrs.Resource;
import org.codehaus.enunciate.contract.jaxrs.ResourceMethod;
import org.codehaus.enunciate.contract.jaxrs.ResourceParameter;
import org.gedcomx.rt.CommonModels;
import org.gedcomx.rt.rs.ResourceServiceBinding;
import org.gedcomx.rt.rs.ResourceServiceDefinition;

import java.util.*;

/**
 * @author Ryan Heaton
 */
public class ResourceServiceDefinitionDeclaration extends Resource {

  private final ResourceServiceProcessor processor;
  private final String name;
  private final String namespace;
  private final List<StatusCode> statusCodes;
  private final List<ResourceRelationship> resourceRelationships;
  private final List<ElementDeclaration> resourceElements;
  final Set<String> subresourceQualfiedNames = new TreeSet<String>();

  public ResourceServiceDefinitionDeclaration(TypeDeclaration delegate, List<ElementDeclaration> resourceElements, ResourceServiceProcessor processor) {
    super(delegate);

    this.resourceElements = resourceElements;

    this.processor = processor;

    ResourceServiceDefinition rsdInfo = delegate.getAnnotation(ResourceServiceDefinition.class);
    String name = rsdInfo.name();
    if ("##default".equals(name)) {
      name = delegate.getSimpleName();
    }
    this.name = name;

    String namespace = rsdInfo.namespace();
    if ("##default".equals(namespace)) {
      //todo: use xml schema namespace?
      namespace = "";
    }
    this.namespace = namespace;

    this.statusCodes = processor.extractStatusCodes(delegate);

    this.resourceRelationships = processor.extractResourceRelationships(delegate);

    for (ResourceMethod resourceMethod : getResourceMethods()) {
      resourceMethod.putMetaData("statusCodes", processor.extractStatusCodes(resourceMethod));
    }

    try {
      Class<?>[] subresources = rsdInfo.subresources();
      for (Class<?> subresource : subresources) {
        this.subresourceQualfiedNames.add(subresource.getName());
      }
    }
    catch (MirroredTypesException e) {
      this.subresourceQualfiedNames.addAll(e.getQualifiedNames());
    }
  }

  @Override
  protected List<ResourceParameter> getResourceParameters(TypeDeclaration delegate) {
    ArrayList<ResourceParameter> params = new ArrayList<ResourceParameter>(super.getResourceParameters(delegate));
    //in this case, we're going to consider the params on superinterfaces, too.
    Collection<InterfaceType> supers = delegate.getSuperinterfaces();
    for (InterfaceType iface : supers) {
      InterfaceDeclaration decl = iface.getDeclaration();
      if (decl != null && decl.getAnnotation(ResourceServiceDefinition.class) == null && decl.getAnnotation(ResourceServiceBinding.class) == null) {
        params.addAll(super.getResourceParameters(decl));
      }
    }
    return params;
  }

  @Override
  public String getPath() {
    return null;
  }

  @Override
  public Resource getParent() {
    return null;
  }

  public String getName() {
    return name;
  }

  public String getNamespace() {
    return namespace;
  }

  public List<ElementDeclaration> getResourceElements() {
    return resourceElements;
  }

  public List<ResourceServiceDefinitionDeclaration> getSubresources() {
    ArrayList<ResourceServiceDefinitionDeclaration> subresources = new ArrayList<ResourceServiceDefinitionDeclaration>();
    for (String fqn : this.subresourceQualfiedNames) {
      ResourceServiceDefinitionDeclaration rs = this.processor.findResourceService(fqn);
      if (rs != null) {
        subresources.add(rs);
      }
    }
    return subresources;
  }

  public List<StatusCode> getStatusCodes() {
    return statusCodes;
  }

  public List<ResourceRelationship> getResourceRelationships() {
    return resourceRelationships;
  }

  public boolean isResourceBundle() {
    for (ElementDeclaration resourceElement : this.resourceElements) {
      if (CommonModels.RDF_NAMESPACE.equals(resourceElement.getNamespace()) && "RDF".equals(resourceElement.getName())) {
        return true;
      }
    }
    return false;
  }

}

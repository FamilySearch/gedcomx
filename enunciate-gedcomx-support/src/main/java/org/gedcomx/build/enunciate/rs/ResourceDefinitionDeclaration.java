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
import org.codehaus.enunciate.contract.jaxb.ElementDeclaration;
import org.codehaus.enunciate.contract.jaxrs.Resource;
import org.codehaus.enunciate.contract.jaxrs.ResourceMethod;
import org.codehaus.enunciate.contract.jaxrs.ResourceParameter;
import org.gedcomx.rt.CommonModels;
import org.gedcomx.rt.rs.ResourceDefinition;

import javax.ws.rs.Path;
import javax.xml.namespace.QName;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

/**
 * @author Ryan Heaton
 */
public class ResourceDefinitionDeclaration extends Resource {

  private final ResourceServiceProcessor processor;
  private final String name;
  private final String namespace;
  private final Set<ResponseCode> statusCodes;
  private final Set<ResponseCode> warnings;
  private final Set<ResourceRelationship> resourceRelationships;
  private final List<ElementDeclaration> resourceElements;
  private final Set<QName> subresources;

  public ResourceDefinitionDeclaration(TypeDeclaration delegate, List<ElementDeclaration> resourceElements, Set<QName> subresources, ResourceServiceProcessor processor) {
    super(delegate);

    this.processor = processor;
    this.resourceElements = resourceElements;
    this.subresources = subresources;

    ResourceDefinition rsdInfo = delegate.getAnnotation(ResourceDefinition.class);
    this.name = rsdInfo.name();
    this.namespace = rsdInfo.namespace();
    this.statusCodes = processor.extractStatusCodes(delegate);
    this.warnings = processor.extractWarnings(delegate);
    this.resourceRelationships = processor.extractResourceRelationships(delegate);
    for (ResourceMethod resourceMethod : getResourceMethods()) {
      resourceMethod.putMetaData("statusCodes", processor.extractStatusCodes(resourceMethod));
      resourceMethod.putMetaData("warnings", processor.extractWarnings(resourceMethod));
    }
  }

  @Override
  protected List<ResourceParameter> getResourceParameters(TypeDeclaration delegate) {
    ArrayList<ResourceParameter> params = new ArrayList<ResourceParameter>(super.getResourceParameters(delegate));
    //in this case, we're going to consider the params on superinterfaces, too.
    Collection<InterfaceType> supers = delegate.getSuperinterfaces();
    for (InterfaceType iface : supers) {
      InterfaceDeclaration decl = iface.getDeclaration();
      if (decl != null && decl.getAnnotation(ResourceDefinition.class) == null && decl.getAnnotation(Path.class) == null) {
        params.addAll(super.getResourceParameters(decl));
      }
    }
    return params;
  }

  @Override
  public String getPath() {
    return "";
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

  public List<ResourceDefinitionDeclaration> getSubresources() {
    ArrayList<ResourceDefinitionDeclaration> subresources = new ArrayList<ResourceDefinitionDeclaration>();
    for (QName sub : this.subresources) {
      ResourceDefinitionDeclaration rs = this.processor.findResourceDefinition(sub);
      if (rs != null) {
        subresources.add(rs);
      }
    }
    return subresources;
  }

  public Set<ResponseCode> getStatusCodes() {
    return statusCodes;
  }

  public Set<ResponseCode> getWarnings() {
    return warnings;
  }

  public Set<ResourceRelationship> getResourceRelationships() {
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

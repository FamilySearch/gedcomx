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

import org.codehaus.enunciate.contract.jaxrs.RootResource;

import java.util.List;
import java.util.Set;

import static org.gedcomx.build.enunciate.ResourceServiceProcessor.extractLinkRelationships;
import static org.gedcomx.build.enunciate.ResourceServiceProcessor.extractStatusCodes;

/**
 * @author Ryan Heaton
 */
public class ResourceServiceBindingMetadata {

  private final String name;
  private final String namespace;
  private final RootResource rootResource;
  private final Set<ResourceServiceDefinitionDeclaration> definitions;
  private final List<StatusCode> statusCodes;
  private final List<LinkRelationship> linkRelationships;

  public ResourceServiceBindingMetadata(String name, String namespace, RootResource rootResource, Set<ResourceServiceDefinitionDeclaration> definitions) {
    this.name = name;
    this.namespace = namespace;
    this.rootResource = rootResource;
    this.definitions = definitions;
    this.statusCodes = extractStatusCodes(rootResource);
    this.linkRelationships = extractLinkRelationships(rootResource);
  }

  public String getName() {
    return name;
  }

  public String getNamespace() {
    return namespace;
  }

  public RootResource getRootResource() {
    return rootResource;
  }

  public Set<ResourceServiceDefinitionDeclaration> getDefinitions() {
    return definitions;
  }

  public List<StatusCode> getStatusCodes() {
    return statusCodes;
  }

  public List<LinkRelationship> getLinkRelationships() {
    return linkRelationships;
  }
}

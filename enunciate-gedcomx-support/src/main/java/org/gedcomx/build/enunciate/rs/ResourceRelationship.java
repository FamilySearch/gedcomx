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

import com.sun.mirror.type.MirroredTypeException;

/**
 * @author Ryan Heaton
 */
public class ResourceRelationship {

  final String name;
  final String description;
  final String resourceDefQualifiedName;
  final ResourceServiceProcessor processor;

  public ResourceRelationship(org.gedcomx.rt.rs.ResourceRelationship meta, ResourceServiceProcessor processor) {
    this.name = meta.name();
    this.description = meta.description();
    this.processor = processor;
    String fqn;
    try {
      fqn = meta.definedBy().getName();
    }
    catch (MirroredTypeException e) {
      fqn = e.getQualifiedName();
    }
    this.resourceDefQualifiedName = fqn;
  }

  public String getName() {
    return name;
  }

  public String getDescription() {
    return description;
  }

  public ResourceServiceDefinitionDeclaration getDefinedBy() {
    return this.processor.findResourceService(this.resourceDefQualifiedName);
  }
}

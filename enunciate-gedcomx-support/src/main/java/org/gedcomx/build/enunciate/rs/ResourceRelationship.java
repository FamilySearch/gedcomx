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

import com.sun.mirror.type.DeclaredType;
import com.sun.mirror.type.MirroredTypeException;
import com.sun.mirror.type.TypeMirror;
import org.gedcomx.rt.rs.ResourceDefinition;

import javax.xml.namespace.QName;

/**
 * @author Ryan Heaton
 */
public final class ResourceRelationship {

  private final String identifier;
  private final String description;
  private final boolean template;
  private final QName resource;
  private final ResourceServiceProcessor processor;

  public ResourceRelationship(org.gedcomx.rt.rs.ResourceRelationship meta, ResourceServiceProcessor processor) {
    this.identifier = meta.identifier();
    this.description = meta.description();
    this.template = meta.template();
    this.processor = processor;
    String fqn;
    ResourceDefinition def = null;
    try {
      def = meta.definedBy().getAnnotation(ResourceDefinition.class);
    }
    catch (MirroredTypeException e) {
      TypeMirror typeMirror = e.getTypeMirror();
      if (typeMirror instanceof DeclaredType && ((DeclaredType) typeMirror).getDeclaration() != null) {
        def = ((DeclaredType) typeMirror).getDeclaration().getAnnotation(ResourceDefinition.class);
      }
    }
    this.resource = new QName(def.namespace(), def.name());
  }

  public String getIdentifier() {
    return identifier;
  }

  public String getDescription() {
    return description;
  }

  public ResourceDefinitionDeclaration getDefinedBy() {
    return this.processor.findResourceDefinition(this.resource);
  }

  public boolean isTemplate() {
    return template;
  }
}

/**
 * Copyright 2011-2012 Intellectual Reserve, Inc.
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
public final class ResourceLink {

  final String rel;
  final String description;
  final boolean template;
  final QName resource;
  final ResourceServiceProcessor processor;

  public ResourceLink(org.gedcomx.rt.rs.ResourceLink meta, ResourceServiceProcessor processor) {
    this.rel = meta.rel();
    this.description = meta.description();
    this.template = meta.template();
    this.processor = processor;
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

  public String getRel() {
    return rel;
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

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    ResourceLink that = (ResourceLink) o;

    if (rel != null ? !rel.equals(that.rel) : that.rel != null) {
      return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    return rel != null ? rel.hashCode() : 0;
  }
}

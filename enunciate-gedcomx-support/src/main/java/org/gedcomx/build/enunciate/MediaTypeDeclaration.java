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
package org.gedcomx.build.enunciate;

import org.codehaus.enunciate.config.SchemaInfo;
import org.codehaus.enunciate.contract.jaxb.ElementDeclaration;
import org.codehaus.enunciate.contract.jaxb.RootElementDeclaration;
import org.codehaus.enunciate.contract.jaxb.TypeDefinition;

import java.util.*;

/**
 * The root document of a media type.
 *
 * @author Ryan Heaton
 */
public class MediaTypeDeclaration {

  private final String id;
  private final String name;
  private final String description;
  private final String version;
  private final String xmlMediaType;
  private final String jsonMediaType;
  private final String projectId;
  private final RootElementDeclaration rootElement;
  private final List<SchemaInfo> schemas = new ArrayList<SchemaInfo>();
  private final List<MediaTypeDeclaration> others;

  public MediaTypeDeclaration(String id, String name, String description, String version, String xmlMediaType, String jsonMediaType, String projectId, RootElementDeclaration rootElement, List<MediaTypeDeclaration> others) {
    this.id = id;
    this.name = name;
    this.description = description;
    this.version = version;
    this.xmlMediaType = xmlMediaType;
    this.jsonMediaType = jsonMediaType;
    this.projectId = projectId;
    this.rootElement = rootElement;
    this.others = others;
  }

  public String getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getDescription() {
    return description;
  }

  public String getVersion() {
    return version;
  }

  public String getProjectId() {
    return projectId;
  }

  public String getXmlMediaType() {
    return xmlMediaType;
  }

  public String getJsonMediaType() {
    return jsonMediaType;
  }

  public List<SchemaInfo> getSchemas() {
    return schemas;
  }

  public RootElementDeclaration getRootElement() {
    return rootElement;
  }

  public MediaTypeDeclaration getExtension() {
    for (MediaTypeDeclaration other : others) {
      if (getRootElement().getTypeDefinition().getQualifiedName().equals(other.getRootElement().getQualifiedName())) {
        return other;
      }
    }

    return null;
  }

  public Set<ElementDeclaration> getElements() {
    Set<ElementDeclaration> elements = new TreeSet<ElementDeclaration>(new Comparator<ElementDeclaration>() {
      @Override
      public int compare(ElementDeclaration o1, ElementDeclaration o2) {
        return o1.getQname().toString().compareTo(o2.getQname().toString());
      }
    });
    for (SchemaInfo schema : schemas) {
      elements.addAll(schema.getGlobalElements());
      elements.addAll(schema.getLocalElementDeclarations());
    }
    return elements;
  }

  public Set<TypeDefinition> getDataTypes() {
    Set<TypeDefinition> elements = new TreeSet<TypeDefinition>(new Comparator<TypeDefinition>() {
      @Override
      public int compare(TypeDefinition o1, TypeDefinition o2) {
        return o1.getQname().toString().compareTo(o2.getQname().toString());
      }
    });
    for (SchemaInfo schema : schemas) {
      elements.addAll(schema.getTypeDefinitions());
    }
    return elements;
  }
}

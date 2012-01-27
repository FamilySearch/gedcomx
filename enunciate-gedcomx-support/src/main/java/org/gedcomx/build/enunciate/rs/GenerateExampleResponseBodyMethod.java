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

import org.codehaus.enunciate.apt.EnunciateFreemarkerModel;
import org.codehaus.enunciate.contract.jaxb.Element;
import org.codehaus.enunciate.contract.jaxb.ElementDeclaration;
import org.codehaus.enunciate.contract.jaxb.RootElementDeclaration;
import org.codehaus.enunciate.contract.jaxrs.ResourceMethod;
import org.gedcomx.rt.JsonElementWrapper;

import javax.ws.rs.HttpMethod;
import javax.xml.namespace.QName;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.*;

/**
 * @author Ryan Heaton
 */
public class GenerateExampleResponseBodyMethod extends GenerateResourceExampleHttpMethod {

  public GenerateExampleResponseBodyMethod(EnunciateFreemarkerModel model) {
    super(model);
  }

  protected Object generateExample(ResourceDefinitionDeclaration def, ResourceMethod resourceMethod, RootElementDeclaration element, Map<QName, ResourceDefinitionDeclaration> subresourcesByType, boolean json) {
    if (element == null) {
      return "...";
    }

    String method = resourceMethod.getHttpMethods().iterator().next().toUpperCase();
    StringWriter out = new StringWriter();
    PrintWriter writer = new PrintWriter(out);

    if (HttpMethod.GET.equals(method)) {
      if (json) {
        writer.printf("{\n");
        writer.printf("  \"@type\" : \"%s%s\",\n", element.getTypeDefinition().getNamespace(), element.getTypeDefinition().getName());
        writer.printf("  ...\n");
        Iterator<ResourceRelationship> relIt = def != null ? def.getResourceRelationships().iterator() : Collections.<ResourceRelationship>emptyList().iterator();
        if (relIt.hasNext()) {
          writer.printf("  \"links\" : [\n");
        }
        while (relIt.hasNext()) {
          ResourceRelationship rel = relIt.next();
          writer.printf("    { \"rel\" : \"%s\", \"href\" : \"...\" }", rel.getIdentifier());
          if (!relIt.hasNext()) {
            writer.printf("\n  ],\n");
          }
          else {
            writer.printf(",\n");
          }
        }

        Map<String, ResourceDefinitionDeclaration> subresources = new LinkedHashMap<String, ResourceDefinitionDeclaration>();
        Map<String, Boolean> collectionTypes = new HashMap<String, Boolean>();
        if (def != null && def.isResourceBundle()) {
          for (ResourceDefinitionDeclaration subresource : subresourcesByType.values()) {
            for (ElementDeclaration el : subresource.getResourceElements()) {
              JsonElementWrapper elementWrapper = el.getAnnotation(JsonElementWrapper.class);
              String key = elementWrapper != null ? (elementWrapper.namespace() + elementWrapper.name()) : (el.getNamespace() + el.getName());
              subresources.put(key, subresource);
              collectionTypes.put(key, true);
            }
          }
        }
        else {
          for (Element childElement : element.getTypeDefinition().getElements()) {
            ResourceDefinitionDeclaration subresource = subresourcesByType.get(childElement.getBaseType().getQname());
            if (subresource != null) {
              String key = childElement.getJsonMemberName();
              subresources.put(key, subresource);
              collectionTypes.put(key, childElement.isCollectionType());
            }
          }
        }

        for (Map.Entry<String, ResourceDefinitionDeclaration> entry : subresources.entrySet()) {
          writer.printf("  \"%s\" :%s{\n", entry.getKey(), collectionTypes.get(entry.getKey()) ? " [ " : " ");
          writer.printf("    ...\n");
          relIt = entry.getValue().getResourceRelationships().iterator();
          if (relIt.hasNext()) {
            writer.printf("    \"links\" : [\n");
          }
          while (relIt.hasNext()) {
            ResourceRelationship rel = relIt.next();
            writer.printf("      { \"rel\" : \"%s\", \"href\" : \"...\" }", rel.getIdentifier());
            if (!relIt.hasNext()) {
              writer.printf("\n    ],\n");
            }
            else {
              writer.printf(",\n");
            }
          }
          writer.printf("  }%s,\n", collectionTypes.get(entry.getKey()) ? " ]" : "");
          writer.printf("  ...\n");
        }
        writer.printf("}");
      }
      else {
        writer.printf("<%s xmlns=\"%s\" xmlns:rs=\"...\">\n", element.getName(), element.getNamespace());
        writer.printf("  ...\n");
        Iterator<ResourceRelationship> relIt = def != null ? def.getResourceRelationships().iterator() : Collections.<ResourceRelationship>emptyList().iterator();
        while (relIt.hasNext()) {
          ResourceRelationship rel = relIt.next();
          writer.printf("  <atom:link rel=\"%s\" href=\"...\"/>\n", rel.getIdentifier());
          if (!relIt.hasNext()) {
            writer.printf("  ...\n");
          }
        }

        Map<QName, ResourceDefinitionDeclaration> subresources = new LinkedHashMap<QName, ResourceDefinitionDeclaration>();
        if (def != null && def.isResourceBundle()) {
          for (ResourceDefinitionDeclaration subresource : subresourcesByType.values()) {
            for (ElementDeclaration el : subresource.getResourceElements()) {
              subresources.put(el.getQname(), subresource);
            }
          }
        }
        else {
          for (Element childElement : element.getTypeDefinition().getElements()) {
            ResourceDefinitionDeclaration subresource = subresourcesByType.get(childElement.getBaseType().getQname());
            if (subresource != null) {
              subresources.put(new QName(childElement.getNamespace(), childElement.getName()), subresource);
            }
          }
        }

        for (Map.Entry<QName, ResourceDefinitionDeclaration> entry : subresources.entrySet()) {
          writer.printf("  <%s", entry.getKey().getLocalPart());
          if (!"".equals(entry.getKey().getNamespaceURI()) && !element.getNamespace().equals(entry.getKey().getNamespaceURI())) {
            writer.printf(" xmlns=\"%s\"", entry.getKey().getNamespaceURI());
          }
          writer.printf(">\n");
          writer.printf("    ...\n");
          relIt = entry.getValue().getResourceRelationships().iterator();
          while (relIt.hasNext()) {
            ResourceRelationship rel = relIt.next();
            writer.printf("    <atom:link rel=\"%s\" href=\"...\"/>\n", rel.getIdentifier());
            if (!relIt.hasNext()) {
              writer.printf("    ...\n");
            }
          }
          writer.printf("  </%s>\n", entry.getKey().getLocalPart());
          writer.printf("  ...\n");
        }
        writer.printf("</%s>", element.getName());
      }
    }

    return out.toString();
  }

}
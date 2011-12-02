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
import org.codehaus.enunciate.config.SchemaInfo;
import org.codehaus.enunciate.contract.jaxb.RootElementDeclaration;
import org.codehaus.enunciate.contract.jaxrs.ResourceMethod;

import javax.ws.rs.HttpMethod;
import javax.xml.namespace.QName;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Map;

/**
 * @author Ryan Heaton
 */
public class GenerateExampleResponseHeadersMethod extends GenerateResourceExampleHttpMethod {

  public GenerateExampleResponseHeadersMethod(EnunciateFreemarkerModel model) {
    super(model);
  }

  protected Object generateExample(ResourceServiceDefinitionDeclaration def, ResourceMethod resourceMethod, RootElementDeclaration element, Map<QName, ResourceServiceDefinitionDeclaration> subresourcesByType, boolean json) {
    String label = def.getName().toLowerCase();
    String method = resourceMethod.getHttpMethods().iterator().next().toUpperCase();
    StringWriter out = new StringWriter();
    PrintWriter writer = new PrintWriter(out);

    if (HttpMethod.POST.equals(method)) {
      writer.printf("HTTP/1.1 201 Created\n");
      writer.printf("Location: /path/to/%s\n", label);
    }
    else if (HttpMethod.PUT.equals(method) || HttpMethod.DELETE.equals(method)) {
      writer.printf("HTTP/1.1 204 No Content\n");
    }
    else {
      writer.printf("HTTP/1.1 200 OK\n");
      //todo: HEAD?
      if (HttpMethod.GET.equals(method)) {
        String mediaType = null;
        SchemaInfo schemaInfo = model.getNamespacesToSchemas().get(element.getNamespace());
        if (schemaInfo != null) {
          mediaType = json ? (String) schemaInfo.getProperty("jsonMediaType") : (String) schemaInfo.getProperty("xmlMediaType");
          writer.printf("Content-Type: %s\n", mediaType);
        }
      }
    }

    return out.toString();
  }

}
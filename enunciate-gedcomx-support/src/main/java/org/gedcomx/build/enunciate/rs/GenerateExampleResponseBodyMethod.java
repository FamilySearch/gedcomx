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
import org.codehaus.enunciate.contract.jaxb.ElementDeclaration;
import org.codehaus.enunciate.contract.jaxrs.ResourceMethod;

import javax.ws.rs.HttpMethod;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;

/**
 * @author Ryan Heaton
 */
public class GenerateExampleResponseBodyMethod extends GenerateResourceExampleHttpMethod {

  public GenerateExampleResponseBodyMethod(EnunciateFreemarkerModel model) {
    super(model);
  }

  protected Object generateExample(ResourceDefinitionDeclaration def, ResourceMethod resourceMethod, ElementDeclaration element, List<SubresourceElement> subresources, boolean json) {
    if (element == null) {
      return "...";
    }

    String method = resourceMethod.getHttpMethods().iterator().next().toUpperCase();
    StringWriter out = new StringWriter();
    PrintWriter writer = new PrintWriter(out);

    if (HttpMethod.GET.equals(method)) {
      writeExampleToBody(element, subresources, json, writer, true, def.getLinks());
    }

    return out.toString();
  }

}
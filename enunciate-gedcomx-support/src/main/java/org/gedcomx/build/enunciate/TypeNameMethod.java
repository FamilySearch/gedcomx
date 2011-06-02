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

import freemarker.ext.beans.BeansWrapper;
import freemarker.template.TemplateMethodModelEx;
import freemarker.template.TemplateModel;
import freemarker.template.TemplateModelException;
import org.codehaus.enunciate.contract.jaxb.Accessor;
import org.codehaus.enunciate.contract.jaxb.RootElementDeclaration;
import org.codehaus.enunciate.contract.jaxb.types.XmlType;

import java.util.List;
import java.util.Map;

/**
 * @author Ryan Heaton
 */
public class TypeNameMethod implements TemplateMethodModelEx {

  private final Map<String, String> namespaces2Prefixes;

  public TypeNameMethod(Map<String, String> namespaces2Prefixes) {
    this.namespaces2Prefixes = namespaces2Prefixes;
  }

  public Object exec(List list) throws TemplateModelException {
    if (list.size() < 1) {
      throw new TemplateModelException("The typeName method must have an accessor and a default ns as a parameter.");
    }

    Object object = BeansWrapper.getDefaultInstance().unwrap((TemplateModel) list.get(0));
    String namespace;
    String name;
    String defaultNs = "";
    if (list.size() > 1) {
      defaultNs = BeansWrapper.getDefaultInstance().unwrap((TemplateModel) list.get(1)).toString();
    }

    if (object instanceof Accessor) {
      namespace = ((Accessor) object).getBaseType().getNamespace();
      name = ((Accessor) object).getBaseType().getName();
    }
    else if (object instanceof RootElementDeclaration) {
      namespace = ((RootElementDeclaration) object).getTypeDefinition().getNamespace();
      name = ((RootElementDeclaration) object).getTypeDefinition().getName();
    }
    else if (object instanceof XmlType) {
      namespace = ((XmlType) object).getNamespace();
      name = ((XmlType) object).getName();
    }
    else {
      throw new TemplateModelException("The typeName method must have an accessor as a parameter.");
    }

    StringBuilder builder = new StringBuilder();
    if (!defaultNs.equals(namespace) && !"http://www.w3.org/2001/XMLSchema".equals(namespace)) {
      String prefix = namespaces2Prefixes.get(namespace);
      builder.append(prefix).append(':');
    }
    builder.append(name);

    return builder.toString();
  }

}
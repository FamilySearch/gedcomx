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

import freemarker.ext.beans.BeansWrapper;
import freemarker.template.TemplateMethodModelEx;
import freemarker.template.TemplateModel;
import freemarker.template.TemplateModelException;
import org.codehaus.enunciate.config.SchemaInfo;
import org.codehaus.enunciate.contract.jaxb.*;
import org.codehaus.enunciate.contract.jaxb.types.XmlType;

import javax.xml.namespace.QName;
import java.util.List;
import java.util.Map;

/**
 * @author Ryan Heaton
 */
public class TypeNameMethod implements TemplateMethodModelEx {

  private final Map<String, SchemaInfo> namespacesToSchemas;

  public TypeNameMethod(Map<String, SchemaInfo> namespacesToSchemas) {
    this.namespacesToSchemas = namespacesToSchemas;
  }

  public Object exec(List list) throws TemplateModelException {
    if (list.size() < 1) {
      throw new TemplateModelException("The typeName method must have an accessor as a parameter.");
    }

    Object object = BeansWrapper.getDefaultInstance().unwrap((TemplateModel) list.get(0));
    String name;

    if (object instanceof Accessor) {
      Accessor accessor = (Accessor) object;
      QName ref = accessor.getRef();
      if (ref != null) {
        name = null;
        SchemaInfo schemaInfo = this.namespacesToSchemas.get(ref.getNamespaceURI());
        if (schemaInfo != null) {
          for (ImplicitSchemaElement implicitElement : schemaInfo.getImplicitSchemaElements()) {
            if (implicitElement.getElementName().equals(ref.getLocalPart())) {
              name = implicitElement.getTypeQName().getLocalPart();
              break;
            }
          }

          if (name == null) {
            for (ImplicitSchemaAttribute implicitElement : schemaInfo.getImplicitSchemaAttributes()) {
              if (implicitElement.getAttributeName().equals(ref.getLocalPart())) {
                name = implicitElement.getTypeQName().getLocalPart();
                break;
              }
            }
          }

          if (name == null) {
            name = ref.getLocalPart();
          }
        }
      }
      else {
        name = accessor.getBaseType().getName();
      }
    }
    else if (object instanceof RootElementDeclaration) {
      name = ((RootElementDeclaration) object).getTypeDefinition().getName();
    }
    else if (object instanceof XmlType) {
      name = ((XmlType) object).getName();
    }
    else {
      throw new TemplateModelException("The typeName method must have an accessor as a parameter.");
    }

    return name;
  }

}
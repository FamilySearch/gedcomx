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
import org.codehaus.enunciate.contract.jaxb.ElementDeclaration;
import org.gedcomx.rt.JsonElementWrapper;

import java.util.List;

/**
 * @author Ryan Heaton
 */
public class JsonExtensionElementNameMethod implements TemplateMethodModelEx {

  public Object exec(List list) throws TemplateModelException {
    if (list.size() < 1) {
      throw new TemplateModelException("The jsonExtensionElementName method must have a root element as a parameter.");
    }

    Object object = BeansWrapper.getDefaultInstance().unwrap((TemplateModel) list.get(0));

    if (object instanceof ElementDeclaration) {
      ElementDeclaration el = (ElementDeclaration) object;
      String name = el.getName();
      String namespace = el.getNamespace();
      JsonElementWrapper ext = el.getAnnotation(JsonElementWrapper.class);
      if (ext != null) {
        name = ext.name();
        namespace = ext.namespace();
      }

      return namespace + name;
    }
    else {
      throw new TemplateModelException("The jsonExtensionElementName method must have an element declaration as a parameter.");
    }
  }

}
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

import com.sun.mirror.type.ClassType;
import com.sun.mirror.type.InterfaceType;
import net.sf.jelly.apt.decorations.TypeMirrorDecorator;
import net.sf.jelly.apt.decorations.type.DecoratedClassType;
import net.sf.jelly.apt.decorations.type.DecoratedInterfaceType;
import org.codehaus.enunciate.apt.EnunciateFreemarkerModel;
import org.codehaus.enunciate.contract.jaxb.TypeDefinition;
import org.codehaus.enunciate.modules.docs.WhateverNode;
import org.codehaus.jackson.annotate.JsonTypeInfo;
import org.codehaus.jackson.node.ArrayNode;
import org.codehaus.jackson.node.JsonNodeFactory;
import org.codehaus.jackson.node.ObjectNode;
import org.gedcomx.rt.SupportsExtensionAttributes;
import org.gedcomx.rt.SupportsExtensionElements;
import org.gedcomx.rt.XmlTypeIdResolver;

/**
 * @author Ryan Heaton
 */
public class GenerateExampleJsonMethod extends org.codehaus.enunciate.modules.docs.GenerateExampleJsonMethod {

  public GenerateExampleJsonMethod(EnunciateFreemarkerModel model) {
    super(model);
  }

  protected void generateExampleJson(TypeDefinition type, ObjectNode jsonNode, int maxDepth) {
    if (type != null) {
      if (!jsonNode.has(XmlTypeIdResolver.TYPE_PROPERTY_NAME) && type.getAnnotation(JsonTypeInfo.class) != null) {
        jsonNode.put(XmlTypeIdResolver.TYPE_PROPERTY_NAME, JsonNodeFactory.instance.textNode(type.getNamespace() + type.getName()));
      }

      super.generateExampleJson(type, jsonNode, maxDepth);

      if (isInstanceOf(type, SupportsExtensionAttributes.class.getName())) {
        jsonNode.put("http://extension/attribute", JsonNodeFactory.instance.textNode("..."));
      }

      if (isInstanceOf(type, SupportsExtensionElements.class.getName())) {
        ArrayNode exampleValues = JsonNodeFactory.instance.arrayNode();
        exampleValues.add(WhateverNode.instance);
        exampleValues.add(WhateverNode.instance);
        jsonNode.put("http://extension/element", exampleValues);
        exampleValues = JsonNodeFactory.instance.arrayNode();
        exampleValues.add(WhateverNode.instance);
        exampleValues.add(WhateverNode.instance);
        jsonNode.put("extension", exampleValues);
      }
    }
  }

  private boolean isInstanceOf(TypeDefinition typeDef, String name) {
    for (InterfaceType interfaceType : typeDef.getSuperinterfaces()) {
      if (((DecoratedInterfaceType) TypeMirrorDecorator.decorate(interfaceType)).isInstanceOf(name)) {
        return true;
      }
    }

    ClassType superclass = typeDef.getSuperclass();
    if (superclass != null && ((DecoratedClassType) TypeMirrorDecorator.decorate(superclass)).isInstanceOf(name)) {
      return true;
    }

    return false;
  }
}
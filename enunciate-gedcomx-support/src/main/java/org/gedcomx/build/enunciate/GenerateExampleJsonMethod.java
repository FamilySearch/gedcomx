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

import com.sun.mirror.declaration.TypeDeclaration;
import com.sun.mirror.type.DeclaredType;
import com.sun.mirror.type.TypeMirror;
import net.sf.jelly.apt.decorations.type.DecoratedTypeMirror;
import org.codehaus.enunciate.apt.EnunciateFreemarkerModel;
import org.codehaus.enunciate.contract.jaxb.Element;
import org.codehaus.enunciate.contract.jaxb.TypeDefinition;
import org.codehaus.enunciate.contract.jaxb.types.XmlClassType;
import org.codehaus.enunciate.contract.jaxb.types.XmlType;
import org.codehaus.enunciate.doc.DocumentationExample;
import org.codehaus.enunciate.modules.docs.WhateverNode;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.node.JsonNodeFactory;
import org.codehaus.jackson.node.ObjectNode;
import org.gedcomx.rt.json.HasUniqueJsonKey;
import org.gedcomx.rt.json.JsonSimpleValue;

/**
 * @author Ryan Heaton
 */
public class GenerateExampleJsonMethod extends org.codehaus.enunciate.modules.docs.GenerateExampleJsonMethod {

  public GenerateExampleJsonMethod(EnunciateFreemarkerModel model) {
    super(model);
  }

  @Override
  protected void generateExampleJson(Element element, ObjectNode jsonNode, int maxDepth) {
    if (element.isCollectionType() && ((DecoratedTypeMirror)element.getBareAccessorType()).isInstanceOf(HasUniqueJsonKey.class.getName())) {
      String jsonName = element.getJsonMemberName();
      ObjectNode on = JsonNodeFactory.instance.objectNode();
      JsonNode val = generateExampleJson(element.getBaseType(), "...", maxDepth);
      on.put("type1", val);
      on.put("type2", val);
      on.put("...", WhateverNode.instance);
      jsonNode.put(jsonName, on);
    }
    else {
      String simpleValue = getSimpleValue(element);
      if (simpleValue != null) {
        jsonNode.put(element.getJsonMemberName(), simpleValue);
      }
      else {
        super.generateExampleJson(element, jsonNode, maxDepth);
      }
    }
  }

  private String getSimpleValue(Element element) {
    String val = null;
    TypeMirror accessorType = element.getAccessorType();
    if (accessorType instanceof DeclaredType) {
      TypeDeclaration decl = ((DeclaredType) accessorType).getDeclaration();
      if (decl != null) {
        JsonSimpleValue sv = decl.getAnnotation(JsonSimpleValue.class);
        if (sv != null) {
          DocumentationExample example = element.getAnnotation(DocumentationExample.class);
          val = example == null || "##default".equals(example.value()) ? "##default".equals(sv.example()) ? "..." : sv.example() : example.value();
        }
      }
    }
    return val;
  }

  @Override
  protected JsonNode generateExampleJson(XmlType type, String specifiedValue, int maxDepth) {
    if (type instanceof XmlClassType) {
      TypeDefinition typeDef = ((XmlClassType) type).getTypeDefinition();
      JsonSimpleValue sv = typeDef == null ? null : typeDef.getAnnotation(JsonSimpleValue.class);
      if (sv != null) {
        if ("...".equals(specifiedValue) && !"##default".equals(sv.example())) {
          specifiedValue = sv.example();
        }
        return JsonNodeFactory.instance.textNode(specifiedValue);
      }
    }

    return super.generateExampleJson(type, specifiedValue, maxDepth);
  }

}
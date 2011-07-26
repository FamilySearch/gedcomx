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
package org.gedcomx.rt;

import org.codehaus.jackson.annotate.JsonTypeInfo;
import org.codehaus.jackson.map.jsontype.TypeIdResolver;
import org.codehaus.jackson.map.type.SimpleType;
import org.codehaus.jackson.type.JavaType;

import javax.xml.bind.annotation.XmlSchema;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;
import javax.xml.namespace.QName;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * JSON type id resolver for supporting <a href="http://wiki.fasterxml.com/JacksonPolymorphicDeserialization ">polymorphic type handling</a> in JSON.
 *
 * @author Ryan Heaton
 */
@XmlTransient
public class XmlTypeIdResolver implements TypeIdResolver {

  private static final Map<String, JavaType> ID_TO_TYPE = new ConcurrentHashMap<String, JavaType>();
  private static final Map<Class<?>, String> TYPE_TO_ID = new ConcurrentHashMap<Class<?>, String>();

  public static void initContextClass(JavaType javaType) {
    Class<?> rawClass = javaType.getRawClass();
    String typeQName = typeQName(rawClass);
    ID_TO_TYPE.put(typeQName, javaType);
    TYPE_TO_ID.put(rawClass, typeQName);
  }

  public void init(JavaType javaType) {
    initContextClass(javaType);
  }

  public String idFromValue(Object o) {
    return idFromValueAndType(o, o.getClass());
  }

  public String idFromValueAndType(Object o, Class<?> clazz) {
    String id = TYPE_TO_ID.get(clazz);
    if (id == null) {
      init(SimpleType.construct(clazz));
    }
    return TYPE_TO_ID.get(clazz);
  }

  public JavaType typeFromId(String s) {
    return ID_TO_TYPE.get(s);
  }

  public JsonTypeInfo.Id getMechanism() {
    return JsonTypeInfo.Id.CLASS;
  }

  private static String typeQName(Class<?> rawClass) {
    String ns = "";
    Package pckg = rawClass.getPackage();
    if (pckg != null) {
      XmlSchema schemaInfo = pckg.getAnnotation(XmlSchema.class);
      if (schemaInfo != null) {
        ns = schemaInfo.namespace();
      }
    }

    String name = java.beans.Introspector.decapitalize(rawClass.getSimpleName());
    XmlType annotation = rawClass.getAnnotation(XmlType.class);
    if (annotation != null) {
      if (!"##default".equals(annotation.namespace())) {
        ns = annotation.namespace();
      }
      if (!"##default".equals(annotation.name())) {
        name = annotation.name();
      }
    }

    return new QName(ns, name).toString();
  }

}

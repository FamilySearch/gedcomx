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
package org.gedcomx.fileformat;

import org.codehaus.jackson.map.AnnotationIntrospector;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.introspect.JacksonAnnotationIntrospector;
import org.codehaus.jackson.map.type.SimpleType;
import org.codehaus.jackson.xc.JaxbAnnotationIntrospector;
import org.gedcomx.rt.XmlTypeIdResolver;

import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;
import javax.xml.bind.JAXBException;
import java.util.Set;

/**
 * A context resolver that resolves a JAXB context for a specified set of classes.
 *
 * @author Ryan Heaton
 */
@Provider
public class ObjectMapperContextResolver implements ContextResolver<ObjectMapper> {

  final ObjectMapper mapper;

  public ObjectMapperContextResolver(Class<?>... contextClasses) throws JAXBException {
    ObjectMapper mapper = new ObjectMapper();
    AnnotationIntrospector introspector = AnnotationIntrospector.pair(new JacksonAnnotationIntrospector(), new JaxbAnnotationIntrospector());
    mapper.getSerializationConfig().withAnnotationIntrospector(introspector);
    mapper.getDeserializationConfig().withAnnotationIntrospector(introspector);
    for (Class<?> contextClass : contextClasses) {
      XmlTypeIdResolver.initContextClass(SimpleType.construct(contextClass));
    }
    this.mapper = mapper;
  }

  /**
   * {@inheritDoc}
   */
  public ObjectMapper getContext(Class<?> type) {
    return this.mapper;
  }

}

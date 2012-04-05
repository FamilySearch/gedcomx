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
package org.gedcomx.rt;

import org.codehaus.jackson.jaxrs.JacksonJaxbJsonProvider;
import org.codehaus.jackson.map.AnnotationIntrospector;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.introspect.JacksonAnnotationIntrospector;
import org.codehaus.jackson.map.type.SimpleType;
import org.codehaus.jackson.xc.JaxbAnnotationIntrospector;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.ext.Provider;

/**
 * The custom json provider for GEDCOM JSON data.
 *
 * @author Ryan Heaton
 */
@Provider
@Consumes ({MediaType.WILDCARD}) //wildcard to support our custom "+json" media types.
@Produces ({MediaType.WILDCARD}) //wildcard to support our custom "+json" media types.
public class GedcomJsonProvider extends JacksonJaxbJsonProvider {

  public GedcomJsonProvider() {
    super(createObjectMapper(), DEFAULT_ANNOTATIONS);
  }

  public GedcomJsonProvider(Class<?>... classes) {
    super(createObjectMapper(classes), DEFAULT_ANNOTATIONS);
  }

  /**
   * Creates an object mapper given the specified context classes.
   *
   * @param classes the context classes.
   * @return The object mapper.
   */
  public static ObjectMapper createObjectMapper(Class<?>... classes) {
    ObjectMapper mapper = new ObjectMapper();
    AnnotationIntrospector introspector = AnnotationIntrospector.pair(new JacksonAnnotationIntrospector(), new JaxbAnnotationIntrospector());
    mapper.getSerializationConfig().withAnnotationIntrospector(introspector);
    mapper.getDeserializationConfig().withAnnotationIntrospector(introspector);
    mapper.registerModule(new GedcomJacksonModule());
    for (Class<?> contextClass : classes) {
      XmlTypeIdResolver.initContextClass(SimpleType.construct(contextClass));
    }
    return mapper;
  }
}

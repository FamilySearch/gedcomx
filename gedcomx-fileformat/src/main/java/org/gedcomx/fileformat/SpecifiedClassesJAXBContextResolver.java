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

import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import java.util.Set;

/**
 * A context resolver that resolves a JAXB context for a specified set of classes.
 *
 * @author Ryan Heaton
 */
@Provider
public class SpecifiedClassesJAXBContextResolver implements ContextResolver<JAXBContext> {

  private final Set<Class<?>> contextClasses;
  private final JAXBContext context;

  public SpecifiedClassesJAXBContextResolver(Set<Class<?>> contextClasses) throws JAXBException {
    this.contextClasses = contextClasses;
    this.context = JAXBContext.newInstance(contextClasses.toArray(new Class<?>[contextClasses.size()]));
  }

  /**
   * {@inheritDoc}
   */
  public JAXBContext getContext(Class<?> type) {
    return contextClasses.contains(type) ? context : null;
  }
}

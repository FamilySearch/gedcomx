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
package org.gedcomx.types;

import javax.xml.bind.annotation.XmlType;
import java.net.URI;

/**
 * A resource that is typed.
 *
 * @author Ryan Heaton
 */
@XmlType (
  name = "Typed"
)
public interface Typed {

  /**
   * Reference to the resource type. Note that this differs from rdf:type and dcterms:type because
   * it's a <em>reference</em> to the type as opposed to the actual type.
   *
   * @return Reference to the resource type.
   */
  URI getType();
}

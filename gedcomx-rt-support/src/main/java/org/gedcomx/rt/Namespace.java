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

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Metadata about specific namespace.
 *
 * @author Ryan Heaton
 */
@Retention( RetentionPolicy.RUNTIME )
@Target( {} )
public @interface Namespace {

  /**
   * The id of the namespace. Used to for things like naming the schema file and assigning an xml prefix.
   *
   * @return The id of the namespace.
   */
  String id();

  /**
   * The namespace uri.
   *
   * @return The namespace uri.
   */
  String uri();

  /**
   * A label associated with the namespace, used to identify the namespace in the user documentation.
   *
   * @return A label associated with the namespace.
   */
  String label() default "";

  /**
   * An identifier for the version of the namespace.
   *
   * @return An identifier for the version of the namespace.
   */
  String version();

  /**
   * A description of the namespace, used for user documentation.
   *
   * @return A description of the namespace, used for user documentation.
   */
  String description() default "";

  /**
   * The XML media type for representations of data in this namespace.
   *
   * @return The XML media type for representations of data in this namespace.
   */
  String xmlMediaType() default "";

  /**
   * The JSON media type for representations of data in this namespace.
   *
   * @return The JSON media type for representations of data in this namespace.
   */
  String jsonMediaType() default "";
}

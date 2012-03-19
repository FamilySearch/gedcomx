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
 * Metadata about a specific object model.
 *
 * @author Ryan Heaton
 */
@Retention( RetentionPolicy.RUNTIME )
@Target( {} )
public @interface Model {

  /**
   * The id of the model. Used to for things like naming the schema file and assigning an xml prefix.
   *
   * @return The id of the model.
   */
  String id();

  /**
   * The namespace of the model.
   *
   * @return The namespace of the model.
   */
  String namespace();

  /**
   * An identifier for a project to which this model belongs.
   *
   * @return An identifier for a project to which this model belongs.
   */
  String projectId();

  /**
   * A label associated with the model, used to identify the model in the user documentation.
   *
   * @return A label associated with the model.
   */
  String label() default "";

  /**
   * An identifier for the version of the model.
   *
   * @return An identifier for the version of the model.
   */
  String version();

  /**
   * A description of the model, used for user documentation.
   *
   * @return A description of the model, used for user documentation.
   */
  String description() default "";

  /**
   * The XML media type for representations that use this model.
   *
   * @return The XML media type for representations that use this model.
   */
  String xmlMediaType() default "";

  /**
   * The JSON media type for representations that use this model.
   *
   * @return The JSON media type for representations that use this model.
   */
  String jsonMediaType() default "";

  /**
   * Whether the model defines an RDF schema.
   *
   * @return Whether the model defines an RDF schema.
   */
  boolean definesRDFSchema() default false;

  /**
   * The object factories that supply possible local element names and json properties for types in this model.
   *
   * @return The object factories that supply possible local element names and json properties for types in this model.
   */
  Class[] objectFactory() default {};
}

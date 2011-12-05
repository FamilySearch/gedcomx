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
package org.gedcomx.rt.rs;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Metadata used to describe the way a {@link ResourceServiceDefinition resource service definition} is bound
 * to a specific system. Since a {@link ResourceServiceDefinition resource service definition} is defined in a way
 * so as to not dictate the paths of specific resources, a binding describes what paths the resources are <i>bound</i>
 * to in a specific system, using JAX-RS annotations. A binding also includes any additional refinements that are specific
 * to the system, such as {@link StatusCodes status codes}, {@link Warnings warnings}, and
 * {@link ResourceRelationship resource relationship}s.
 *
 * @author Ryan Heaton
 */
@Retention ( RetentionPolicy.RUNTIME )
@Target ({ ElementType.TYPE })
public @interface ResourceServiceBinding {

  /**
   * A name for the binding.
   *
   * @return A name for the binding.
   */
  String name() default "##default";

  /**
   * A namespace for the binding.
   *
   * @return A namespace for the binding.
   */
  String namespace() default "##default";

}

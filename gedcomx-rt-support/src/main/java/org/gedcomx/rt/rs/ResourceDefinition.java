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

import javax.xml.bind.annotation.XmlElement;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Metadata used to describe a resource and the way the HTTP operations apply to the resource. A resource
 * definition does not dictate the paths at which the resources are bound, but describes the resource in generic
 * terms such as the representation model, {@link StatusCodes status codes}, {@link Warnings warnings}, and
 * {@link ResourceRelationship resource relationship}s.
 *
 * @author Ryan Heaton
 */
@Retention ( RetentionPolicy.RUNTIME )
@Target ({ ElementType.TYPE })
public @interface ResourceDefinition {

  /**
   * The name of the resource being defined. Default is the name of the annotated class.
   *
   * @return The name of the resource being defined.
   */
  String name();

  /**
   * A namespace for the resource. Default is the empty namespace.
   *
   * @return A namespace for the resource.
   */
  String namespace() default "";

  /**
   * The class defining the element used as the representation model for the resource. The
   * resource element should be a JAXB {@link javax.xml.bind.annotation.XmlRootElement}.
   *
   * @return The class defining the element used as the representation model for the resource.
   */
  Class<?>[] resourceElement() default {};

  /**
   * The resource service definitions that are considered subresources of this resource.
   *
   * @return The resource service definitions that are considered subresources of this resource.
   */
  Class<?>[] subresources() default {};

  /**
   * The valid elements that are used to carry the subresources of this resource. This is currently only applicable
   * to resources that are represented by an extensible element that will use its extension mechanism
   * to supply subresources.
   *
   * @return The valid elements that are used to carry the subresources of this resource.
   */
  XmlElement[] subresourceElements() default {};
}

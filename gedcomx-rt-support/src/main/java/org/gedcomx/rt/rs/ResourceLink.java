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

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Metadata used to describe the links between resources.
 *
 * @author Ryan Heaton
 */
@Retention ( RetentionPolicy.RUNTIME )
@Target ({ })
public @interface ResourceLink {

  /**
   * Identifier for the resource relationship. This is the value that will be used for the
   * <tt>rel</tt> attribute of the link. Per <a href="http://tools.ietf.org/html/draft-nottingham-http-link-header-10#section-4">Web Linking,
   * section 4</a>, the identifier should be either a registered relationship type (e.g. "self")
   * or it should be a URI.
   *
   * @see <a href="http://tools.ietf.org/html/draft-nottingham-http-link-header-10">Web Linking</a>
   * @return The relationship identifier.
   */
  String rel();

  /**
   * The resource service definition that defines the resource being related to.
   *
   * @return The resource service definition that defines the resource being related to.
   */
  Class<?> definedBy();

  /**
   * A human-readable description of the resource relationship.
   *
   * @return A human-readable description of the resource relationship.
   */
  String description();

  /**
   * Whether this is a template link instead of an href.
   *
   * @return Whether this is a template link instead of an href.
   */
  boolean template() default false;

}

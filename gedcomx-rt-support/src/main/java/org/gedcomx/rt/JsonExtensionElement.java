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

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotates a class as a known GEDCOM X extension element.
 *
 * @author Ryan Heaton
 */
@Retention ( RetentionPolicy.RUNTIME )
@Target ( { ElementType.TYPE } )
public @interface JsonExtensionElement {

  /**
   * The name of the JSON property if this element is added as an extension element. Default
   * value is the simple name of the class.
   *
   * @return The name of the JSON property if this element is added as an extension element.
   */
  String name() default "##default";

  /**
   * The namespace of the JSON property if this element is added as an extension element. The
   * namespace will be prepended to the name during JSON serialization. Note the default value
   * is the empty string, which overrides the namespace of @XmlRootElement and @XmlSchema.
   *
   * @return The namespace of the JSON property if this element is added as an extension element.
   */
  String namespace() default "";
}

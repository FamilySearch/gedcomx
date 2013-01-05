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
package org.gedcomx.common;

import java.util.Map;

/**
 * @author Ryan Heaton
 */
public interface HasTransientProperties {

  /**
   * Get the transient properties.
   *
   * @return the transient properties.
   */
  Map<String, Object> getTransientProperties();

  /**
   * Get a transient (non-serialized) property.
   *
   * @param name The name of the property.
   * @return The property.
   */
  Object getTransientProperty(String name);

  /**
   * Set a transient (non-serialized) property.
   *
   * @param name the name of the property.
   * @param value the property value.
   */
  void setTransientProperty(String name, Object value);
}

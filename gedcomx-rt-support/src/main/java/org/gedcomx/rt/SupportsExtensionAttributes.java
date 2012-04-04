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

import javax.xml.namespace.QName;
import java.util.Map;

/**
 * @author Ryan Heaton
 */
public interface SupportsExtensionAttributes {

  /**
   * Custom extension attributes for a resource.
   *
   * @return Custom extension attributes for a resource.
   */
  Map<QName, String> getExtensionAttributes();

  /**
   * Add a custom extension attribute.
   *
   * @param qname The qname of the attribute.
   * @param value The value of the attribute.
   */
  void addExtensionAttribute(QName qname, String value);

}

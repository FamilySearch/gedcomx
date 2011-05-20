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
package org.gedcomx.id;

import javax.xml.bind.annotation.XmlValue;
import java.net.URI;

/**
 * A long-lived, persistent identifier.
 *
 * @author Ryan Heaton
 */
public final class PersistentIdentifier {

  private URI value;

  /**
   * The value of the persistent identifier.
   *
   * @return The value of the persistent identifier.
   */
  @XmlValue
  public URI getValue() {
    return value;
  }

  /**
   * The value of the persistent identifier.
   *
   * @param value The value of the persistent identifier.
   */
  public void setValue(URI value) {
    this.value = value;
  }
}

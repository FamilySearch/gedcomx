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

import org.codehaus.jackson.annotate.JsonValue;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * A wrapper object for a URI.
 *
 * @author Ryan Heaton
 */
@XmlJavaTypeAdapter(URIAdapter.class)
public final class URI {

  private final String value;

  public URI(String value) {
    if (value == null) {
      throw new IllegalArgumentException("value cannot be null");
    }

    this.value = value;
  }

  public static URI create(String uri) {
    return new URI(uri);
  }

  public java.net.URI toURI() {
    return java.net.URI.create(this.value);
  }

  @Override
  @JsonValue
  public String toString() {
    return this.value;
  }

  @Override
  public boolean equals(Object o) {
    return this == o || !(o == null || getClass() != o.getClass()) && value.equals(((URI) o).value);
  }

  @Override
  public int hashCode() {
    return value.hashCode();
  }
}

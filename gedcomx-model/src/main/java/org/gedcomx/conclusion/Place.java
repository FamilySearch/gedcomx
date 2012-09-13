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
package org.gedcomx.conclusion;

import org.gedcomx.common.URI;
import org.gedcomx.rt.RDFSubClassOf;

import javax.xml.bind.annotation.XmlType;

/**
 * A concluded genealogical place.
 *
 * @author Ryan Heaton
 */
@XmlType ( name = "Place", propOrder = { "original", "normal", "resource" } )
public class Place {

  private String original;
  private String normal;
  private URI resource;

  /**
   * The original text as supplied by the user.
   *
   * @return The original text as supplied by the user.
   */
  public String getOriginal() {
    return original;
  }

  /**
   * The original value as supplied by the user.
   *
   * @param original The original value as supplied by the user.
   */
  public void setOriginal(String original) {
    this.original = original;
  }

  /**
   * The standardized and/or normalized resource value.
   *
   * @return The resource value.
   */
  public URI getResource() {
    return resource;
  }

  /**
   * The standardized and/or normalized resource value.
   *
   * @param resource The resource value.
   */
  public void setResource(URI resource) {
    this.resource = resource;
  }

  /**
   * The normalized value of the place
   * @return the normalized value
   */
  public String getNormal() {
    return normal;
  }

  /**
   * The normalized value of the place
   * @param normal the normalized value
   */
  public void setNormal(String normal) {
    this.normal = normal;
  }

  public String toString() {
    return "Place{" + "original='" + original + '\'' + "normal='" + normal + '\'' + ", resource=" + resource + '}';
  }
}

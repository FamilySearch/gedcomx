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
package org.gedcomx.conclusion;

import org.gedcomx.rt.RDFSubClassOf;
import org.gedcomx.types.TypesNamespaces;

import javax.xml.bind.annotation.XmlType;

/**
 * A concluded genealogical place.
 *
 * @author Ryan Heaton
 */
@XmlType ( name = "Place", propOrder = {"original", "normalized"} )
@RDFSubClassOf ( TypesNamespaces.DUBLIN_CORE_NAMESPACE + "Location" )
public final class Place implements Normalizeable {

  private String original;
  private String normalized;

  /**
   * The original value of the place that was concluded as supplied by the user.
   *
   * @return The original value of the place that was concluded as supplied by the user.
   */
  public String getOriginal() {
    return original;
  }

  /**
   * The original value of the place that was concluded as supplied by the user.
   *
   * @param original The original value of the place that was concluded as supplied by the user.
   */
  public void setOriginal(String original) {
    this.original = original;
  }

  /**
   * The normalized representation of the original value of the place. Intended for convenience
   * to the user in interpreting the place. The normalized representation is optional and is
   * often supplied by an automated standardization process.
   *
   * @return The normalized representation of the original value of the place. Intended for convenience
   * to the user in interpreting the place. The normalized representation is optional and is
   * often supplied by an automated standardization process.
   */
  public String getNormalized() {
    return normalized;
  }

  /**
   * The normalized representation of the original value of the place. Intended for convenience
   * to the user in interpreting the place. The normalized representation is optional and is
   * often supplied by an automated standardization process.
   *
   * @param normalized The normalized representation of the original value of the place. Intended for convenience
   * to the user in interpreting the place. The normalized representation is optional and is
   * often supplied by an automated standardization process.
   */
  public void setNormalized(String normalized) {
    this.normalized = normalized;
  }

}

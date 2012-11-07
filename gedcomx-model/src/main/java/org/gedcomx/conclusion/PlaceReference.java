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

import org.gedcomx.common.ExtensibleData;
import org.gedcomx.common.ResourceReference;
import org.gedcomx.rt.RDFRange;

import javax.xml.bind.annotation.XmlType;


/**
 * A reference to genealogical place.
 */
@XmlType ( name = "PlaceReference", propOrder = { "original", "standardPlace" } )
public class PlaceReference extends ExtensibleData {

  private String original;
  private ResourceReference standardPlace;

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
   * A reference to a normalize and/or standard place.
   *
   * @return A reference to the standard place.
   */
  @RDFRange (PlaceDescription.class)
  public ResourceReference getStandardPlace() {
    return standardPlace;
  }

  /**
   * A reference to the normalize and/or standard place.
   *
   * @param standardPlace A reference to the standard place.
   */
  public void setStandardPlace(ResourceReference standardPlace) {
    this.standardPlace = standardPlace;
  }

  public String toString() {
    return "PlaceReference{" + "original='" + original + "', " + "standardPlace='" + standardPlace + '\'' + '}';
  }
}

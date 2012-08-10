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

import org.gedcomx.rt.CommonModels;
import org.gedcomx.rt.RDFSubClassOf;

import javax.xml.bind.annotation.XmlType;

/**
 * A concluded genealogical place.
 *
 * @author Ryan Heaton
 */
@XmlType ( name = "Place", propOrder = { "original", "formal" } )
@RDFSubClassOf ( CommonModels.DUBLIN_CORE_NAMESPACE + "Location" )
public final class Place implements Formalizeable {

  private String original;
  private FormalValue formal;

  /**
   * The original text as supplied by the user.
   *
   * @return The original text as supplied by the user.
   */
  @Override
  public String getOriginal() {
    return original;
  }

  /**
   * The original value as supplied by the user.
   *
   * @param original The original value as supplied by the user.
   */
  @Override
  public void setOriginal(String original) {
    this.original = original;
  }

  /**
   * The formal value.
   *
   * @return The formal value.
   */
  @Override
  public FormalValue getFormal() {
    return formal;
  }

  /**
   * The formal value.
   *
   * @param formal The formal value.
   */
  @Override
  public void setFormal(FormalValue formal) {
    this.formal = formal;
  }

  @Override
  public String toString() {
    return "Place{" + "original='" + original + '\'' + ", formal=" + formal + '}';
  }
}

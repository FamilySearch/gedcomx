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

import org.codehaus.jackson.annotate.JsonTypeInfo;
import org.codehaus.jackson.map.annotate.JsonTypeIdResolver;
import org.gedcomx.common.FormalValue;
import org.gedcomx.rt.XmlTypeIdResolver;

import javax.xml.bind.annotation.XmlType;

/**
 * A value that is able to be formalized, possibly from some original text.
 *
 * @see FormalValue
 * @author Ryan Heaton
 */
@XmlType ( name = "FormalizeableValue", propOrder = {"original", "formal"} )
@JsonTypeInfo ( use =JsonTypeInfo.Id.CUSTOM, property = XmlTypeIdResolver.TYPE_PROPERTY_NAME)
@JsonTypeIdResolver (XmlTypeIdResolver.class)
public class FormalizeableValue {

  private String original;
  private FormalValue formal;

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
   * The formal value.
   *
   * @return The formal value.
   */
  public FormalValue getFormal() {
    return formal;
  }

  /**
   * The formal value.
   *
   * @param formal The formal value.
   */
  public void setFormal(FormalValue formal) {
    this.formal = formal;
  }
}

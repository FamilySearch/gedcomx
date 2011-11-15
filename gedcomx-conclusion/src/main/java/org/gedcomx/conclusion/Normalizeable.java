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

import javax.xml.bind.annotation.XmlType;

/**
 * A conclusion resource that has a value that is able to be normalized.
 *
 * @author Ryan Heaton
 */
@XmlType ( name = "Normalizeable" )
public interface Normalizeable {

  /**
   * The original value.
   *
   * @return The original value.
   */
  String getOriginal();

  /**
   * The original value of the date that was concluded as supplied by the user.
   *
   * @param original The original value of the date that was concluded as supplied by the user.
   */
  void setOriginal(String original);

  /**
   * The original value.
   *
   * @return The original value.
   */
  String getNormalized();

  /**
   * The normalized representation of the original value of the date. Intended for convenience
   * to the user in interpreting the date. The normalized representation is optional and is
   * often supplied by an automated standardization process.
   *
   * @param normalized The normalized representation of the original value of the date. Intended for convenience
   * to the user in interpreting the date. The normalized representation is optional and is
   * often supplied by an automated standardization process.
   */
  void setNormalized(String normalized);
}

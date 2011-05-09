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
 * A concluded genealogical place.
 *
 * @author Ryan Heaton
 */
@XmlType (propOrder = {"original", "normalized", "geoCode"})
public class Place {

  private String original;
  private String normalized;
  private GeoCode geoCode;

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

  /**
   * The geocode for this place. Intended for convenience to an automated process in
   * interpreting the place (e.g. for sorting purposes). The geocode is optional and is
   * often supplied by an automated standardization process.
   *
   * @return The geocode for this place. Intended for convenience to an automated process in
   * interpreting the place (e.g. for sorting purposes). The geocode is optional and is
   * often supplied by an automated standardization process.
   */
  public GeoCode getGeoCode() {
    return geoCode;
  }

  /**
   * The geocode for this place. Intended for convenience to an automated process in
   * interpreting the place (e.g. for sorting purposes). The geocode is optional and is
   * often supplied by an automated standardization process.
   *
   * @param geoCode The geocode for this place. Intended for convenience to an automated process in
   * interpreting the place (e.g. for sorting purposes). The geocode is optional and is
   * often supplied by an automated standardization process.
   */
  public void setGeoCode(GeoCode geoCode) {
    this.geoCode = geoCode;
  }
}

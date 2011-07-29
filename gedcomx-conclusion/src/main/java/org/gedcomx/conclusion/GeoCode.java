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

import javax.xml.bind.annotation.XmlAttribute;

/**
 * A geocode.
 * 
 * @author Ryan Heaton
 */
public final class GeoCode {

  private double longitude;
  private double latitude;

  /**
   * The longitude.
   * 
   * @return The longitude.
   */
  @XmlAttribute
  public double getLongitude() {
    return longitude;
  }

  /**
   * The longitude.
   * 
   * @param longitude The longitude.
   */
  public void setLongitude(double longitude) {
    this.longitude = longitude;
  }

  /**
   * The latitude.
   * 
   * @return The latitude.
   */
  @XmlAttribute
  public double getLatitude() {
    return latitude;
  }

  /**
   * The latitude.
   * 
   * @param latitude The latitude.
   */
  public void setLatitude(double latitude) {
    this.latitude = latitude;
  }
}
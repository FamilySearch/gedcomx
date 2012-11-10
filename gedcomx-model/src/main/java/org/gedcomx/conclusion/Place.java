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

import org.codehaus.enunciate.json.JsonName;
import org.codehaus.jackson.annotate.JsonProperty;
import org.gedcomx.common.Attribution;
import org.gedcomx.common.TextValue;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.List;


/**
 * An abstraction of place independent of its potential jurisdictional hierarchies.
 */
@XmlType ( name = "Place", propOrder = { "names", "latitude", "longitude", "identifiers", "attribution" } )
public class Place extends Conclusion {

  private List<TextValue> names;
  private double latitude;
  private double longitude;
  private List<Identifier> identifiers;
  private Attribution attribution;

  /**
   * A list of standardized (or normalized) names associated with this place.
   *
   * It is RECOMMENDED that instances provide at least one name.
   *
   * @return A list of standardized (or normalized) names associated with this place.
   */
  @XmlElement (name = "name")
  @JsonName ("names")
  @JsonProperty ("names")
  public List<TextValue> getNames() {
    return names;
  }

  /**
   * A list of standardized (or normalized) names associated with this place.
   *
   * It is RECOMMENDED that instances provide at least one name.
   *
   * @param names A list of standardized (or normalized) names associated with this place.
   */
  @JsonProperty ("names")
  public void setNames(List<TextValue> names) {
    this.names = names;
  }

  /**
   * Degrees north or south of the Equator (0 degrees).  Values range from −90 degrees (south) to 90 degrees (north).
   *
   * @return Degrees north or south of the Equator.
   */
  public double getLatitude() {
    return latitude;
  }

  /**
   * Degrees north or south of the Equator (0 degrees).  Values range from −90 degrees (south) to 90 degrees (north).
   *
   * @param latitude Degrees north or south of the Equator.
   */
  public void setLatitude(double latitude) {
    this.latitude = latitude;
  }

  /**
   * Angular distance in degrees, relative to the Prime Meridian.  Values west of the Meridian range from −180 to 0 degrees.  Values east of the Meridian range from 0 to 180 degrees.
   *
   * @return Angular distance in degrees, relative to the Prime Meridian.
   */
  public double getLongitude() {
    return longitude;
  }

  /**
   * Angular distance in degrees, relative to the Prime Meridian.  Values west of the Meridian range from −180 to 0 degrees.  Values east of the Meridian range from 0 to 180 degrees.
   *
   * @param longitude Angular distance in degrees, relative to the Prime Meridian.
   */
  public void setLongitude(double longitude) {
    this.longitude = longitude;
  }

  /**
   * A list of known identifiers for this place (e.g., place authority identifiers).
   *
   * @return A list of known identifiers for this place.
   */
  @XmlElement (name = "identifier")
  @JsonName ("identifiers")
  @JsonProperty ("identifiers")
  public List<Identifier> getIdentifiers() {
    return identifiers;
  }

  /**
   * A list of known identifiers for this place (e.g., place authority identifiers).
   *
   * @param identifiers A list of known identifiers for this place.
   */
  @JsonProperty ("identifiers")
  public void setIdentifiers(List<Identifier> identifiers) {
    this.identifiers = identifiers;
  }

  /**
   * Attribution metadata for this place.
   *
   * @return Attribution metadata for this place.
   */
  public Attribution getAttribution() {
    return attribution;
  }

  /**
   * Attribution metadata for this place.
   *
   * @param attribution Attribution metadata for this place.
   */
  public void setAttribution(Attribution attribution) {
    this.attribution = attribution;
  }
}

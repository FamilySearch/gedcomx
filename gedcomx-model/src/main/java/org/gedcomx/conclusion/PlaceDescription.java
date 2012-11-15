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
import org.gedcomx.common.ResourceReference;
import org.gedcomx.common.TextValue;
import org.gedcomx.common.URI;

import javax.xml.XMLConstants;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import java.util.List;


/**
 * A PlaceDescription is used to describe the details of a place in terms of its name
 * and possibly its type, time period, and/or a geospatial description -- a description
 * of a place as a snapshot in time.
 */
@XmlType ( name = "PlaceDescription", propOrder = { "names", "type", "temporalDescription", "latitude", "longitude", "spatialDescription", "identifiers", "attribution" } )
public class PlaceDescription extends Conclusion {

  private URI about;
  private List<TextValue> names;
  private URI type;
  private Date temporalDescription;
  private double latitude;
  private double longitude;
  private ResourceReference spatialDescription;
  private List<Identifier> identifiers;
  private Attribution attribution;

  /**
   * The identifier of the place that this description is about.
   *
   * @return The identifier of the place that this description is about.
   */
  @XmlAttribute
  @XmlSchemaType (name = "anyURI", namespace = XMLConstants.W3C_XML_SCHEMA_NS_URI)
  public URI getAbout() {
    return about;
  }

  /**
   * The identifier of the place that this description is about.
   *
   * @param about The identifier of the place that this description is about.
   */
  public void setAbout(URI about) {
    this.about = about;
  }

  /**
   * An ordered list of standardized (or normalized), fully-qualified (in terms of what is known of the applicable jurisdictional hierarchy) names for this place that are applicable to this description of this place.
   *
   * The list MUST include at least one value. It is RECOMMENDED that instances include a single name and any equivalents from other cultural contexts;
   * name variants should more typically be described in separate PlaceDescription instances.  The list is assumed to be given in order of preference,
   * with the most preferred value in the first position in the list.
   *
   * @return An ordered list of standardized (or normalized), fully-qualified (in terms of what is known of the applicable jurisdictional hierarchy) names for this place that are applicable to this description of this place.
   */
  @XmlElement (name = "name")
  @JsonName ("names")
  @JsonProperty ("names")
  public List<TextValue> getNames() {
    return names;
  }

  /**
   * An ordered list of standardized (or normalized), fully-qualified (in terms of what is known of the applicable jurisdictional hierarchy) names for this place that are applicable to this description of this place.
   *
   * The list MUST include at least one value. It is RECOMMENDED that instances include a single name and any equivalents from other cultural contexts;
   * name variants should more typically be described in separate PlaceDescription instances.  The list is assumed to be given in order of preference,
   * with the most preferred value in the first position in the list.
   *
   * @param names An ordered list of standardized (or normalized), fully-qualified (in terms of what is known of the applicable jurisdictional hierarchy) names for this place that are applicable to this description of this place.
   */
  @JsonProperty ("names")
  public void setNames(List<TextValue> names) {
    this.names = names;
  }

  /**
   * An implementation-specify type identifier (e.g., address, city, county, province, state, country, etc.).
   *
   * @return An implementation-specify type identifier (e.g., address, city, county, province, state, country, etc.).
   */
  @XmlAttribute
  public URI getType() {
    return type;
  }

  /**
   * An implementation-specify type identifier (e.g., address, city, county, province, state, country, etc.).
   *
   * @param type An implementation-specify type identifier (e.g., address, city, county, province, state, country, etc.).
   */
  public void setType(URI type) {
    this.type = type;
  }

  /**
   * A description of the time period to which this place description is relevant.
   *
   * @return A description of the time period to which this place description is relevant.
   */
  public Date getTemporalDescription() {
    return temporalDescription;
  }

  /**
   *  A description of the time period to which this place description is relevant.
   *
   * @param temporalDescription A description of the time period to which this place description is relevant.
   */
  public void setTemporalDescription(Date temporalDescription) {
    this.temporalDescription = temporalDescription;
  }

  /**
   * Degrees north or south of the Equator (0.0 degrees).   Values range from −90.0 degrees (south) to 90.0 degrees (north).
   *
   * @return Degrees north or south of the Equator.
   */
  public double getLatitude() {
    return latitude;
  }

  /**
   * Degrees north or south of the Equator (0.0 degrees).   Values range from −90.0 degrees (south) to 90.0 degrees (north).
   *
   * @param latitude Degrees north or south of the Equator.
   */
  public void setLatitude(double latitude) {
    this.latitude = latitude;
  }

  /**
   * Angular distance in degrees, relative to the Prime Meridian.   Values range from −180.0 degrees (west of the Meridian) to 180.0 degrees (east of the Meridian).
   *
   * @return Angular distance in degrees, relative to the Prime Meridian.
   */
  public double getLongitude() {
    return longitude;
  }

  /**
   * Angular distance in degrees, relative to the Prime Meridian.   Values range from −180.0 degrees (west of the Meridian) to 180.0 degrees (east of the Meridian).
   *
   * @param longitude Angular distance in degrees, relative to the Prime Meridian.
   */
  public void setLongitude(double longitude) {
    this.longitude = longitude;
  }

  /**
   * A reference to a geospatial description of this place.
   *
   * It is RECOMMENDED that this description resolve to a KML document.
   *
   * @return  A reference to a geospatial description of this place.
   */
  public ResourceReference getSpatialDescription() {
    return spatialDescription;
  }

  /**
   *  A reference to a geospatial description of this place.
   *
   *  It is RECOMMENDED that this description resolve to a KML document.
   *
   * @param spatialDescription A reference to a geospatial description of this place.
   */
  public void setSpatialDescription(ResourceReference spatialDescription) {
    this.spatialDescription = spatialDescription;
  }

  /**
   * A list of known identifiers for this place description (e.g., identifiers for a description in place authority).
   *
   * @return A list of known identifiers for this place description.
   */
  @XmlElement (name = "identifier")
  @JsonName ("identifiers")
  @JsonProperty ("identifiers")
  public List<Identifier> getIdentifiers() {
    return identifiers;
  }

  /**
   * A list of known identifiers for this place description (e.g., identifiers for a description in place authority).
   *
   * @param identifiers A list of known identifiers for this place description.
   */
  @JsonProperty ("identifiers")
  public void setIdentifiers(List<Identifier> identifiers) {
    this.identifiers = identifiers;
  }

  /**
   * Attribution metadata for this place description.
   *
   * @return Attribution metadata for this place description.
   */
  public Attribution getAttribution() {
    return attribution;
  }

  /**
   *  Attribution metadata for this place description.
   *
   * @param attribution Attribution metadata for this place description.
   */
  public void setAttribution(Attribution attribution) {
    this.attribution = attribution;
  }
}

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

import org.gedcomx.common.Attribution;
import org.gedcomx.common.ResourceReference;
import org.gedcomx.common.TextValue;
import org.gedcomx.common.URI;
import org.gedcomx.rt.RDFRange;

import javax.xml.bind.annotation.XmlType;
import java.util.List;


/**
 * A PlaceDescription is used to describe the details of a place in terms of its name
 * and possibly its type, time period, and/or a geospatial description -- a description
 * of a place as a snapshot in time.
 */
@XmlType ( name = "PlaceDescription", propOrder = { "about", "names", "type", "temporalDescription", "spatialDescription", "identifiers", "attribution" } )
public class PlaceDescription extends Conclusion {

  private ResourceReference about;
  private List<TextValue> names;
  private URI type;
  private Date temporalDescription;
  private ResourceReference spatialDescription;
  private List<Identifier> identifiers;
  private Attribution attribution;

  /**
   * A reference to the Place that this description is about.
   *
   * @return A reference to the Place that this description is about.
   */
  @RDFRange (Place.class)
  public ResourceReference getAbout() {
    return about;
  }

  /**
   * A reference to the Place that this description is about.
   *
   * @param about A reference to the Place that this description is about.
   */
  public void setAbout(ResourceReference about) {
    this.about = about;
  }

  /**
   * An ordered list of normalized/standardized, fully-qualified (in terms of what is known of the applicable jurisdictional hierarchy) names for this place applicable to this description.
   *
   * The list MUST include at least one value. It is RECOMMENDED that instances include a single name and any equivalents from other cultural contexts;
   * name variants should more typically be described in separate PlaceDescription instances.  The list is assumed to be given in order of preference,
   * with the most preferred value in the first position in the list.
   *
   * @return An ordered list of normalized/standardized, fully-qualified (in terms of what is known of the applicable jurisdictional hierarchy) names for this place applicable to this description.
   */
  public List<TextValue> getNames() {
    return names;
  }

  /**
   * An ordered list of normalized/standardized, fully-qualified (in terms of what is known of the applicable jurisdictional hierarchy) names for this place applicable to this description.
   *
   * The list MUST include at least one value. It is RECOMMENDED that instances include a single name and any equivalents from other cultural contexts;
   * name variants should more typically be described in separate PlaceDescription instances.  The list is assumed to be given in order of preference,
   * with the most preferred value in the first position in the list.
   *
   * @param names An ordered list of normalized/standardized, fully-qualified (in terms of what is known of the applicable jurisdictional hierarchy) names for this place applicable to this description.
   */
  public void setNames(List<TextValue> names) {
    this.names = names;
  }

  /**
   * An implementation-specify type identifier (e.g., address, city, county, province, state, country, etc.).
   *
   * @return An implementation-specify type identifier (e.g., address, city, county, province, state, country, etc.).
   */
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
   * A genealogical date describing of the time period to which this place description is relevant.
   *
   * @return A genealogical date describing of the time period to which this place description is relevant.
   */
  public Date getTemporalDescription() {
    return temporalDescription;
  }

  /**
   *  A genealogical date describing of the time period to which this place description is relevant.
   *
   * @param temporalDescription A genealogical date describing of the time period to which this place description is relevant.
   */
  public void setTemporalDescription(Date temporalDescription) {
    this.temporalDescription = temporalDescription;
  }

  /**
   * A reference to a geospatial description of this place.
   *
   * @return  A reference to a geospatial description of this place.
   */
  public ResourceReference getSpatialDescription() {
    return spatialDescription;
  }

  /**
   *  A reference to a geospatial description of this place.
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
  public List<Identifier> getIdentifiers() {
    return identifiers;
  }

  /**
   * A list of known identifiers for this place description (e.g., identifiers for a description in place authority).
   *
   * @param identifiers A list of known identifiers for this place description.
   */
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

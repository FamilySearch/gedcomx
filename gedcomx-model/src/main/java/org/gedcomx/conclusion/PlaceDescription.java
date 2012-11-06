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

import java.util.List;


public class PlaceDescription extends Conclusion {

  private ResourceReference about;
  private List<TextValue> names;
  private URI type;
  private Date temporalDescription;
  private ResourceReference spatialDescription;
  private Attribution attribution;

  public ResourceReference getAbout() {
    return about;
  }

  public void setAbout(ResourceReference about) {
    this.about = about;
  }

  public List<TextValue> getNames() {
    return names;
  }

  public void setNames(List<TextValue> names) {
    this.names = names;
  }

  public URI getType() {
    return type;
  }

  public void setType(URI type) {
    this.type = type;
  }

  public Date getTemporalDescription() {
    return temporalDescription;
  }

  public void setTemporalDescription(Date temporalDescription) {
    this.temporalDescription = temporalDescription;
  }

  public ResourceReference getSpatialDescription() {
    return spatialDescription;
  }

  public void setSpatialDescription(ResourceReference spatialDescription) {
    this.spatialDescription = spatialDescription;
  }

  public Attribution getAttribution() {
    return attribution;
  }

  public void setAttribution(Attribution attribution) {
    this.attribution = attribution;
  }
}

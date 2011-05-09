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

import org.gedcomx.attribution.AttributionReference;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlID;

/**
 * A conclusion about a person.
 *
 * @author Ryan Heaton
 */
public abstract class Conclusion {

  private String id;
  private AttributionReference attribution;
  //todo: how do we extend this for the api when we want to support links?

  /**
   * The id of this conclusion, unique to its person or relationship.
   *
   * @return The id of this conclusion, unique to its person or relationship.
   */
  @XmlID
  @XmlAttribute
  public String getId() {
    return id;
  }

  /**
   * The id of this conclusion, unique to its person or relationship.
   *
   * @param id The id of this conclusion, unique to its person or relationship.
   */
  public void setId(String id) {
    this.id = id;
  }

  /**
   * The link to the attribution metadata for this conclusion.
   *
   * @return The link to the attribution metadata for this conclusion.
   */
  public AttributionReference getAttribution() {
    return attribution;
  }

  /**
   * The link to the attribution metadata for this conclusion.
   *
   * @param attribution The link to the attribution metadata for this conclusion.
   */
  public void setAttribution(AttributionReference attribution) {
    this.attribution = attribution;
  }
}

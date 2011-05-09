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
 * Range between two <a href="http://en.wikipedia.org/wiki/Julian_day">Julian Days</a>.
 *
 * @author Ryan Heaton
 */
public class JulianDayRange {

  private int earliest;
  private int latest;

  /**
   * The earliest julian day in the range.
   *
   * @return The earliest julian day in the range.
   */
  @XmlAttribute
  public int getEarliest() {
    return earliest;
  }

  /**
   * The earliest julian day in the range.
   *
   * @param earliest The earliest julian day in the range.
   */
  public void setEarliest(int earliest) {
    this.earliest = earliest;
  }

  /**
   * The latest julian day in the range.
   *
   * @return The latest julian day in the range.
   */
  @XmlAttribute
  public int getLatest() {
    return latest;
  }

  /**
   * The latest julian day in the range.
   *
   * @param latest The latest julian day in the range.
   */
  public void setLatest(int latest) {
    this.latest = latest;
  }
}

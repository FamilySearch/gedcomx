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
package org.gedcomx.source;

import org.codehaus.enunciate.qname.XmlQNameEnum;
import org.codehaus.enunciate.qname.XmlUnknownQNameEnumValue;

/**
 * Known list of source qualifier properties.
 *
 * @author Ryan Heaton
 */
@XmlQNameEnum
public enum SourceQualifierProperty {

  /**
   * The pixel x-coordinate for a source, such as for specifying the top-left corner of an image bounding box.
   */
  x_pixels,

  /**
   * The pixel y-coordinate for a source, such as for specifying the top-left corner of an image bounding box.
   */
  y_pixels,

  /**
   * The width of the qualifier, such as for specifying the width of an image bounding box.
   */
  width_pixels,

  /**
   * The height of the qualifier, such as for specifying the height of an image bounding box.
   */
  height_pixels,

  /**
   * The number of milliseconds indicating the start of the qualifier, such as for an audio recording.
   */
  start_milliseconds,

  /**
   * The number of milliseconds indicating the end of the qualifier, such as for an audio recording.
   */
  end_milliseconds,

  /**
   * The id of the field to which this qualifier applies.
   */
  field_id,

  /**
   * The id of the conclusion to which this qualifier applies.
   */
  conclusion_id,

  @XmlUnknownQNameEnumValue
  other
}

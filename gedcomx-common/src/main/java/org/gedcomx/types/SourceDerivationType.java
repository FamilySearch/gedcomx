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
package org.gedcomx.types;

import org.codehaus.enunciate.qname.XmlQNameEnum;
import org.codehaus.enunciate.qname.XmlUnknownQNameEnumValue;
import org.gedcomx.common.URI;


/**
 * An enumeration of known source derivation types.
 */
@XmlQNameEnum (
  base = XmlQNameEnum.BaseType.URI
)
public enum SourceDerivationType {

  /**
   * An indication that a source description is about an original source.
   */
  Original,

  /**
   * An indication that a source description is about a preservation copy of another source.
   */
  PreservationCopy,

  /**
   * An indication that a source description is about an abstract of another source.
   */
  Abstract,

  /**
   * An indication that a source description is about a transcription (can be full or partial) of another source.
   */
  Transcription,

  /**
   * An indication that a source description is about a translation (can be full or partial) of another source.
   */
  Translation,

  /**
   * An indication that a source description is about a conclusion (e.g., relationship, fact, event, etc.) that was extracted from another source.
   */
  ExtractedConclusion,

  /**
   * An indication that a source description is about a document that contains analysis (e.g., a genealogical proof statement).
   */
  Analysis,

  /**
   * An indication that a source description is about a working conclusion (e.g., relationship, fact, event, etc.) -- typically the conclusion representing the current state of one's research.
   */
  WorkingConclusion,

  /**
   * Something else.
   */
  @XmlUnknownQNameEnumValue
  OTHER;


  /**
   * Return the QName value for this enum.
   *
   * @return The QName value for this enum.
   */
  public URI toQNameURI() {
    return URI.create(org.codehaus.enunciate.XmlQNameEnumUtil.toURIValue(this));
  }

  /**
   * Get the enumeration from the QName.
   *
   * @param qname The qname.
   * @return The enumeration.
   */
  public static SourceDerivationType fromQNameURI(URI qname) {
    return org.codehaus.enunciate.XmlQNameEnumUtil.fromURIValue(qname.toString(), SourceDerivationType.class);
  }
}

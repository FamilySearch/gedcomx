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
 * An enumeration of known source reference types.
 */
@XmlQNameEnum (
  base = XmlQNameEnum.BaseType.URI
)
public enum SourceReferenceType {

  /**
   * An indication that the object making the reference is a component of the referenced object.
   */
  ComponentOf,

  /**
   * An indication that the object making the reference is a preservation copy of the referenced object.
   */
  PreservationCopy,

  /**
   * An indication that the object making the reference is an abstract of the referenced object.
   */
  Abstract,

  /**
   * An indication that the object making the reference is a transcription (can be full or partial) of the referenced object.
   */
  Transcription,

  /**
   * An indication that the object making the reference is a translation (can be full or partial) of the referenced object.
   */
  Translation,

  /**
   * An indication that the object making the reference is an extracted conclusion from the referenced object.
   */
  ExtractedConclusion,

  /**
   * An indication that the object making the reference contains analysis involving the referenced object.
   */
  Analysis,

  /**
   * An indication that the object making the reference is a working conclusion based in part on the referenced object.
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
  public static SourceReferenceType fromQNameURI(URI qname) {
    return org.codehaus.enunciate.XmlQNameEnumUtil.fromURIValue(qname.toString(), SourceReferenceType.class);
  }
}

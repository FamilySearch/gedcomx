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
package org.gedcomx.types;

import org.codehaus.enunciate.qname.XmlQNameEnum;
import org.codehaus.enunciate.qname.XmlUnknownQNameEnumValue;

import java.net.URI;

/**
 * Enumeration of levels of confidence. This is taken directly from <i>Evidence Explained, Section 1.6</i>[1].
 *
 * [1] Mills, Elizabeth Shown. "Fundamentals of Evidence Analysis." <i>Evidence Explained.</i> 2nd ed. (Baltimore, Maryland: Genealogical Publishing Company, 2009), 19-20 (Section 1.6).
 *
 * @author Ryan Heaton
 */
@XmlQNameEnum (
  base = XmlQNameEnum.BaseType.URI
)
public enum ConfidenceLevel {

  /**
   * The author has no reasonable doubt about the assertion, based upon sound research and good evidence.
   */
  Certainly,

  /**
   * The author feels the assertion is more likely than not, based upon sound research and good evidence.
   */
  Probably,

  /**
   * The author feels some evidence supports the assertion, but the assertion is far from proved.
   */
  Possibly,

  /**
   * The author feels the odds weigh at least slightly in favor of the assertion.
   */
  Likely,

  /**
   * The author has formed an impression or presumption, typically based upon common experience, but has not
   * tested the matter.
   */
  Apparently,

  /**
   * The author suggests that an idea is plausible, although it remains to be tested.
   */
  Perhaps,

  @XmlUnknownQNameEnumValue
  OTHER;

  /**
   * Return the QName value for this enum.
   *
   * @return The QName value for this enum.
   */
  public URI toQNameURI() {
    return org.codehaus.enunciate.XmlQNameEnumUtil.toURI(this);
  }

  /**
   * Get the enumeration from the QName.
   *
   * @param qname The qname.
   * @return The enumeration.
   */
  public static ConfidenceLevel fromQNameURI(URI qname) {
    return org.codehaus.enunciate.XmlQNameEnumUtil.fromURI(qname, ConfidenceLevel.class);
  }

}

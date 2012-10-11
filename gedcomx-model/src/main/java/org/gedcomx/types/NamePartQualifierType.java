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
 * Enumeration of standard name part types.
 */
@XmlQNameEnum (
  base = XmlQNameEnum.BaseType.URI
)
public enum NamePartQualifierType {

  /**
   * A designation for honorifics (e.g. Dr., Rev., His Majesty, Haji),
   * ranks (e.g. Colonel, General, Knight, Esquire),
   * positions (e.g. Count, Chief, Father, King) or other titles (e.g., PhD, MD)
   */
  Title,

  /**
   * A designation for the given name most prominent in importance.
   */
  PrimaryGiven,

  /**
   * A designation for a given name that is not primary in its importance.
   */
  SecondaryGiven,

  /**
   * A designation useful for cultures that designate a middle name that is distinct from a given name and a surname.
   */
  Middle,

  /**
   * A designation for one's familiar name.
   */
  Familiar,

  /**
   * A designation for a name given for religious purposes.
   */
  Religious,

  /**
   * A name that associates a person with a group, such as a clan, tribe, or patriarchal hierarchy.
   */
  Family,

  /**
   * A designation given by women to their original surname after they adopt a new surname upon marriage.
   */
  Maiden,

  /**
   * A name derived from a father or paternal ancestor.
   */
  Patronymic,

  /**
   * A name derived from a mother or maternal ancestor.
   */
  Matronymic,

  /**
   * A name derived from associated geography.
   */
  Geographic,

  /**
   * A name derived from one's occupation.
   */
  Occupational,

  /**
   * A name derived from a characteristic.
   */
  Characteristic,

  /**
   * A name mandedated by law populations from Congo Free State / Belgian Congo / Congo / Democratic Republic of Congo (formerly Zaire).
   */
  Postnom,

  /**
   * A grammatical designation for articles (a, the, dem, las, el, etc.),
   * prepositions (of, from, aus, zu, op, etc.), initials (e.g. PhD, MD),
   * annotations (e.g. twin, wife of, infant, unknown),
   * comparators (e.g. Junior, Senior, younger, little), ordinals (e.g. III, eighth),
   * and conjunctions (e.g. and, or, nee, ou, y, o, ne, &amp;).
   */
  Particle,

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
  public static NamePartQualifierType fromQNameURI(URI qname) {
    return org.codehaus.enunciate.XmlQNameEnumUtil.fromURIValue(qname.toString(), NamePartQualifierType.class);
  }

}

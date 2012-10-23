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
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;
import org.gedcomx.common.URI;
import org.gedcomx.rt.json.JsonElementWrapper;
import org.gedcomx.types.NameType;

import javax.xml.bind.annotation.*;
import java.util.List;


/**
 * A name conclusion.
 *
 * @author Ryan Heaton
 */
@XmlType ( name = "Name", propOrder = { "preferred", "nameForms"} )
@XmlRootElement
@JsonElementWrapper ( name = "names" )
public class Name extends Conclusion {

  private URI type;
  private Date date;
  private List<NameForm> nameForms;
  private Boolean preferred;

  /**
   * The type of the name.
   *
   * @return The type of the name.
   */
  @XmlAttribute
  public URI getType() {
    return type;
  }

  /**
   * The type of the name.
   *
   * @param type The type of the name.
   */
  public void setType(URI type) {
    this.type = type;
  }

  /**
   * The enum referencing the known name type, or {@link org.gedcomx.types.NameType#OTHER} if not known.
   *
   * @return The enum referencing the known name type, or {@link org.gedcomx.types.NameType#OTHER} if not known.
   */
  @XmlTransient
  @JsonIgnore
  public NameType getKnownType() {
    return getType() == null ? null : NameType.fromQNameURI(getType());
  }

  /**
   * Set the name type from an enumeration of known name types.
   *
   * @param knownType The known type.
   */
  @JsonIgnore
  public void setKnownType(NameType knownType) {
    setType(knownType == null ? null : URI.create(org.codehaus.enunciate.XmlQNameEnumUtil.toURIValue(knownType)));
  }

  /**
   * The date the name was first applied or adopted.
   *
   * @return The date the name was first applied or adopted.
   */
  public Date getDate() {
    return date;
  }

  /**
   * The date the name was first applied or adopted.
   *
   * @param date The date the name was first applied or adopted.
   */
  public void setDate(Date date) {
    this.date = date;
  }

  /**
   * Alternate forms of the name, such as the romanized form of a non-latin name.
   *
   * @return Alternate forms of the name, such as the romanized form of a non-latin name.
   */
  @XmlElement (name = "nameForm")
  @JsonName ("nameForms")
  @JsonProperty ("nameForms")
  public List<NameForm> getNameForms() {
    return nameForms;
  }

  /**
   * Alternate forms of the name, such as the romanized form of a non-latin name.
   *
   * @param nameForms Alternate forms of the name, such as the romanized form of a non-latin name.
   */
  @JsonProperty ("nameForms")
  public void setNameForms(List<NameForm> nameForms) {
    this.nameForms = nameForms;
  }

  /**
   * Whether the conclusion is preferred above other conclusions of the same type. Useful, for example, for display purposes.
   *
   * @return Whether the conclusion is preferred above other conclusions of the same type. Useful, for example, for display purposes.
   */
  public Boolean getPreferred() {
    return preferred;
  }

  /**
   * Whether the conclusion is preferred above other conclusions of the same type. Useful, for example, for display purposes.
   *
   * @param preferred Whether the conclusion is preferred above other conclusions of the same type. Useful, for example, for display purposes.
   */
  public void setPreferred(Boolean preferred) {
    this.preferred = preferred;
  }

  @Override
  public String toString() {
    return "type=" + getKnownType() + ",nameForms[0]=" + (nameForms == null ? "null" : nameForms.get(0).getFullText()) + ",pref=" + getPreferred();
  }
}

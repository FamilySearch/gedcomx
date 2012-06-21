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
import org.gedcomx.rt.CommonModels;
import org.gedcomx.rt.JsonElementWrapper;
import org.gedcomx.types.NameType;
import org.gedcomx.types.TypeReference;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;
import java.util.List;

/**
 * A name conclusion.
 *
 * @author Ryan Heaton
 */
@XmlType ( name = "Name", propOrder = { "type", "preferred", "primaryForm", "alternateForms" } )
@XmlRootElement
@JsonElementWrapper ( name = "names" )
public class Name extends Conclusion {

  @XmlElement (namespace = CommonModels.RDF_NAMESPACE)
  @JsonProperty
  private TypeReference<NameType> type;
  private NameForm primaryForm;
  private List<NameForm> alternateForms;
  private Boolean preferred;

  /**
   * The type of the name.
   *
   * @return The type of the name.
   */
  @XmlTransient
  @JsonIgnore
  public URI getType() {
    return this.type == null ? null : this.type.getType();
  }

  /**
   * The type of the name.
   *
   * @param type The type of the name.
   */
  @JsonIgnore
  public void setType(URI type) {
    this.type = type == null ? null : new TypeReference<NameType>(type);
  }

  /**
   * The enum referencing the known name type, or {@link org.gedcomx.types.NameType#OTHER} if not known.
   *
   * @return The enum referencing the known name type, or {@link org.gedcomx.types.NameType#OTHER} if not known.
   */
  @XmlTransient
  @JsonIgnore
  public NameType getKnownType() {
    return this.type == null ? null : NameType.fromQNameURI(this.type.getType());
  }

  /**
   * Set the name type from an enumeration of known name types.
   *
   * @param knownType The known type.
   */
  @JsonIgnore
  public void setKnownType(NameType knownType) {
    this.type = knownType == null ? null : new TypeReference<NameType>(knownType);
  }

  /**
   * The primary form of the name.
   *
   * @return The primary form of the name.
   */
  public NameForm getPrimaryForm() {
    return primaryForm;
  }

  /**
   * The primary form of the name.
   *
   * @param primaryForm The primary form of the name.
   */
  public void setPrimaryForm(NameForm primaryForm) {
    this.primaryForm = primaryForm;
  }

  /**
   * Alternate forms of the name, such as the romanized form of a non-latin name.
   *
   * @return Alternate forms of the name, such as the romanized form of a non-latin name.
   */
  @XmlElement (name = "alternateForm")
  @JsonName ("alternateForms")
  @JsonProperty ("alternateForms")
  public List<NameForm> getAlternateForms() {
    return alternateForms;
  }

  /**
   * Alternate forms of the name, such as the romanized form of a non-latin name.
   *
   * @param alternateForms Alternate forms of the name, such as the romanized form of a non-latin name.
   */
  @JsonProperty ("alternateForms")
  public void setAlternateForms(List<NameForm> alternateForms) {
    this.alternateForms = alternateForms;
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
    return "type=" + getKnownType() + ",primaryform=" + (primaryForm == null?"null":primaryForm.getFullText()) + ",pref=" + getPreferred();
  }
}

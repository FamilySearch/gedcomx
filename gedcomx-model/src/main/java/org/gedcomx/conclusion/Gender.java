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

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;
import org.gedcomx.common.TypeReference;
import org.gedcomx.common.URI;
import org.gedcomx.rt.json.JsonElementWrapper;
import org.gedcomx.types.GenderType;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

/**
 * A gender conclusion.
 *
 * @author Ryan Heaton
 */
@XmlType ( name = "Gender" )
@XmlRootElement
@JsonElementWrapper ( name = "genders" )
public class Gender extends Conclusion {

  @XmlElement
  @JsonProperty
  private TypeReference<GenderType> type;

  /**
   * Default constructor.
   */
  public Gender() {
  }

  /**
   * Constructs a new gender object with the passed in type.
   *
   * @param type The type of the gender.
   */
  public Gender(GenderType type) {
    setKnownType(type);
  }

  /**
   * The type of the gender.
   *
   * @return The type of the gender.
   */
  @XmlTransient
  @JsonIgnore
  public URI getType() {
    return this.type == null ? null : this.type.getType();
  }

  /**
   * The type of the gender.
   *
   * @param type The type of the gender.
   */
  @JsonIgnore
  public void setType(URI type) {
    this.type = type == null ? null : new TypeReference<GenderType>(type);
  }

  /**
   * The known type of the gender.
   *
   * @return The type of the gender.
   */
  @XmlTransient
  @JsonIgnore
  public GenderType getKnownType() {
    return this.type == null ? null : GenderType.fromQNameURI(this.type.getType());
  }

  /**
   * The type of the gender.
   *
   * @param type The type of the gender.
   */
  @JsonIgnore
  public void setKnownType(GenderType type) {
    this.type = type == null ? null : new TypeReference<GenderType>(type);
  }

  @Override
  public String toString() {
    return "type=" + getKnownType();
  }
}

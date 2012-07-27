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
import org.gedcomx.common.HasText;
import org.gedcomx.common.URI;
import org.gedcomx.rt.CommonModels;
import org.gedcomx.types.NamePartType;
import org.gedcomx.types.TypeReference;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;


/**
 * A part of a name.
 *
 * @author Ryan Heaton
 */
@XmlType ( name = "NamePart", propOrder = {"type", "text"})
public final class NamePart {

  @XmlElement (namespace = CommonModels.RDF_NAMESPACE)
  @JsonProperty
  private TypeReference<NamePartType> type;
  private String text;

  /**
   * The type of the name part.
   *
   * @return The type of the name part.
   */
  @XmlTransient
  @JsonIgnore
  public URI getType() {
    return this.type == null ? null : this.type.getType();
  }

  /**
   * The type of the name part.
   *
   * @param type The type of the name part.
   */
  @JsonIgnore
  public void setType(URI type) {
    this.type = type == null ? null : new TypeReference<NamePartType>(type);
  }

  /**
   * The enum referencing the known name part type, or {@link org.gedcomx.types.NamePartType#OTHER} if not known.
   *
   * @return The enum referencing the known name part type, or {@link org.gedcomx.types.NamePartType#OTHER} if not known.
   */
  @XmlTransient
  @JsonIgnore
  public NamePartType getKnownType() {
    return this.type == null ? null : NamePartType.fromQNameURI(this.type.getType());
  }

  /**
   * Set the type of this name part from an enumeration of known name part types.
   *
   * @param knownType The name part type.
   */
  @JsonIgnore
  public void setKnownType(NamePartType knownType) {
    this.type = knownType == null ? null : new TypeReference<NamePartType>(knownType);
  }

  /**
   * The text of the name part.
   *
   * @return The text of the name part.
   */
  public String getText() {
    return text;
  }

  /**
   * The text of the name part.
   *
   * @param text The text of the name part.
   */
  public void setText(String text) {
    this.text = text;
  }
}

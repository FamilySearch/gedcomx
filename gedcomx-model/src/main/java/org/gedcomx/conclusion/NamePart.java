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
import org.gedcomx.common.ExtensibleData;
import org.gedcomx.common.ResourceReference;
import org.gedcomx.common.URI;
import org.gedcomx.rt.GedcomxModelVisitor;
import org.gedcomx.types.NamePartType;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;
import java.util.List;


/**
 * A part of a name.
 *
 * @author Ryan Heaton
 */
@XmlType ( name = "NamePart" )
public final class NamePart extends ExtensibleData {

  private URI type;
  private String value;
  private List<ResourceReference> qualifiers;

  /**
   * The type of the name part.
   *
   * @return The type of the name part.
   */
  @XmlAttribute
  public URI getType() {
    return type;
  }

  /**
   * The type of the name part.
   *
   * @param type The type of the name part.
   */
  public void setType(URI type) {
    this.type = type;
  }

  /**
   * The enum referencing the known name part type, or {@link org.gedcomx.types.NamePartType#OTHER} if not known.
   *
   * @return The enum referencing the known name part type, or {@link org.gedcomx.types.NamePartType#OTHER} if not known.
   */
  @XmlTransient
  @JsonIgnore
  public NamePartType getKnownType() {
    return getType() == null ? null : NamePartType.fromQNameURI(getType());
  }

  /**
   * Set the type of this name part from an enumeration of known name part types.
   *
   * @param knownType The name part type.
   */
  @JsonIgnore
  public void setKnownType(NamePartType knownType) {
    setType(knownType == null ? null : URI.create(org.codehaus.enunciate.XmlQNameEnumUtil.toURIValue(knownType)));
  }

  /**
   * The value of the name part.
   *
   * @return The value of the name part.
   */
  @XmlAttribute
  public String getValue() {
    return value;
  }

  /**
   * The value of the name part.
   *
   * @param value The value of the name part.
   */
  public void setValue(String value) {
    this.value = value;
  }

  /**
   * The qualifiers associated with this name part.
   *
   * @return The qualifiers associated with this name part.
   */
  @XmlElement (name = "qualifier")
  @JsonName ("qualifiers")
  @JsonProperty ("qualifiers")
  public List<ResourceReference> getQualifiers() {
    return qualifiers;
  }

  /**
   * Set the qualifiers associated with this name part.
   * @param qualifiers qualifiers to associate with this name part
   */
  @JsonProperty ("qualifiers")
  public void setQualifiers(List<ResourceReference> qualifiers) {
    this.qualifiers = qualifiers;
  }

  /**
   * Accept a visitor.
   *
   * @param visitor The visitor.
   */
  public void accept(GedcomxModelVisitor visitor) {
    visitor.visitNamePart(this);
  }
}

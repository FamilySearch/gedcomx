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
package org.gedcomx.source;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.gedcomx.common.URI;
import org.gedcomx.rt.CommonModels;
import org.gedcomx.rt.json.HasUniqueJsonKey;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;


/**
 * Represents a citation field -- its name and value.
 */
@XmlType ( name = "CitationField" )
public class CitationField implements HasUniqueJsonKey {
  private URI name;
  private String value;

  public CitationField() {
  }

  public CitationField(URI name, String value) {
    setName(name);
    setValue(value);
  }

  public CitationField(String name, String value) {
    setName(name);
    setValue(value);
  }

  /**
   * The citation field's name.
   *
   * @return The citation field's name.
   */
  public URI getName() {
    return name;
  }

  /**
   * The citation field's name.
   *
   * @param name The citation field's name.
   */
  public void setName(URI name) {
    this.name = name;
  }

  /**
   * The citation field's name.
   *
   * @param name The citation field's name.
   */
  @XmlTransient
  @JsonIgnore
  public void setName(String name) {
    this.name = name != null ? new URI(name) : null;
  }

  /**
   * The json key that is used define this link in a map.
   *
   * @return The json key that is used define this link in a map.
   */
  @XmlTransient
  @JsonIgnore
  @Override
  public String getJsonKey() {
    return getName().toString();
  }

  /**
   * The json key that is used define this link in a map.
   *
   * @param jsonKey The json key that is used define this link in a map.
   */
  @JsonIgnore
  @Override
  public void setJsonKey(String jsonKey) {
    setName(jsonKey);
  }

  /**
   * The citation field's value.
   *
   * @return The citation field's value.
   */
  @XmlElement ( name = "value", namespace = CommonModels.RDF_NAMESPACE )
  public String getValue() {
    return value;
  }

  /**
   * The citation field's value.
   *
   * @param value The citation field's value.
   */
  public void setValue(String value) {
    this.value = value;
  }
}

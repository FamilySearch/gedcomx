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
package org.gedcomx.records;

import org.codehaus.enunciate.json.JsonName;
import org.codehaus.jackson.annotate.JsonProperty;
import org.gedcomx.common.URI;
import org.gedcomx.conclusion.Conclusion;
import org.gedcomx.rt.GedcomxModelVisitor;
import org.gedcomx.rt.json.JsonElementWrapper;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.List;

/**
 * A conclusion about a fact applicable to a person or relationship.
 */
@XmlType ( name = "Field", propOrder = { "label", "values" })
@XmlRootElement
@JsonElementWrapper ( name = "fields" )
public class Field extends Conclusion {

  private String label;
  private URI type;
  private List<FieldValue> values;

  /**
   * The type of the gender.
   *
   * @return The type of the gender.
   */
  @XmlAttribute
  public URI getType() {
    return type;
  }

  /**
   * The type of the gender.
   *
   * @param type The type of the gender.
   */
  public void setType(URI type) {
    this.type = type;
  }

  //todo: known field types?

  /**
   * A unique label for the field.
   *
   * @return A unique label for the field.
   */
  public String getLabel() {
    return label;
  }

  /**
   * A unique label for the field.
   *
   * @param label A unique label for the field.
   */
  public void setLabel(String label) {
    this.label = label;
  }

  /**
   * The set of values for the field.
   *
   * @return The set of values for the field.
   */
  @XmlElement (name="value")
  @JsonProperty ("values")
  @JsonName ("values")
  public List<FieldValue> getValues() {
    return values;
  }

  /**
   * The set of values for the field.
   *
   * @param values The set of values for the field.
   */
  @JsonProperty ("values")
  public void setValues(List<FieldValue> values) {
    this.values = values;
  }

  public void accept(GedcomxModelVisitor visitor) {
    visitor.visitField(this);
  }

}

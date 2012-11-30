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

import org.codehaus.enunciate.ClientName;
import org.codehaus.jackson.annotate.JsonProperty;
import org.gedcomx.common.ExtensibleData;
import org.gedcomx.common.TextValue;
import org.gedcomx.rt.GedcomxModelVisitor;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.List;

/**
 * A concluded genealogical date.
 */
@ClientName ("DateInfo")
@XmlType ( name = "Date", propOrder = { "original", "formal", "normalizedExtensions" })
public class Date extends ExtensibleData {

  private String original;
  private String formal;
  private List<TextValue> normalized;

  /**
   * The original text as supplied by the user.
   *
   * @return The original text as supplied by the user.
   */
  public String getOriginal() {
    return original;
  }

  /**
   * The original text as supplied by the user.
   *
   * @param original The original text as supplied by the user.
   */
  public void setOriginal(String original) {
    this.original = original;
  }

  /**
   * The standardized and/or normalized formal value.
   *
   * @return The formal value.
   */
  public String getFormal() {
    return formal;
  }

  /**
   * The standardized and/or normalized formal value.
   *
   * @param formal The formal value.
   */
  public void setFormal(String formal) {
    this.formal = formal;
  }

  /**
   * The list of normalized values for the date, provided for display purposes by the application. Normalized values are
   * not specified by GEDCOM X core, but as extension elements by GEDCOM X RS.
   *
   * @return The list of normalized values for the date, provided for display purposes by the application. Normalized values
   * are not specified by GEDCOM X core, but as extension elements by GEDCOM X RS.
   */
  @XmlElement ( name = "normalized" )
  @JsonProperty ("normalized")
  public List<TextValue> getNormalizedExtensions() {
    return normalized;
  }

  /**
   * The list of normalized values for the date, provided for display purposes by the application. Normalized values are
   * not specified by GEDCOM X core, but as extension elements by GEDCOM X RS.
   *
   * @param normalized The list of normalized values for the date, provided for display purposes by the application. Normalized values are
   * not specified by GEDCOM X core, but as extension elements by GEDCOM X RS.
   */
  @JsonProperty ("normalized")
  public void setNormalizedExtensions(List<TextValue> normalized) {
    this.normalized = normalized;
  }

  @Override
  public String toString() {
    return "Date{" + "original='" + original + '\'' + ", formal=" + formal + '}';
  }

  /**
   * Accept a visitor.
   *
   * @param visitor The visitor.
   */
  public void accept(GedcomxModelVisitor visitor) {
    visitor.visitDate(this);
  }
}

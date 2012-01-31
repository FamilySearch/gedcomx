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
package org.gedcomx.atom;

import org.gedcomx.common.URI;

import javax.xml.XMLConstants;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

/**
 * conveys information about a category associated with an entry or feed.
 * 
 * @author Ryan Heaton
 * @see <a href="http://tools.ietf.org/html/rfc4287#section-4.2.2">The atom spec, section 4.2.2.</a>
 */
@XmlType ( name = "Category" )
public final  class Category extends CommonAttributes {
  
  private String term;
  private URI scheme;
  private String label;

  /**
   * identifies the category to which the entry or feed belongs
   *
   * @return identifies the category to which the entry or feed belongs
   */
  @XmlAttribute
  public String getTerm() {
    return term;
  }

  /**
   * identifies the category to which the entry or feed belongs
   *
   * @param term identifies the category to which the entry or feed belongs
   */
  public void setTerm(String term) {
    this.term = term;
  }

  /**
   * identifies a categorization scheme
   *
   * @return identifies a categorization scheme
   */
  @XmlAttribute
  @XmlSchemaType (name = "anyURI", namespace = XMLConstants.W3C_XML_SCHEMA_NS_URI)
  public URI getScheme() {
    return scheme;
  }

  /**
   * identifies a categorization scheme
   *
   * @param scheme identifies a categorization scheme
   */
  public void setScheme(URI scheme) {
    this.scheme = scheme;
  }

  /**
   * a human-readable label for display in end-user applications
   *
   * @return a human-readable label for display in end-user applications
   */
  @XmlAttribute
  public String getLabel() {
    return label;
  }

  /**
   * a human-readable label for display in end-user applications
   *
   * @param label a human-readable label for display in end-user applications
   */
  public void setLabel(String label) {
    this.label = label;
  }
}

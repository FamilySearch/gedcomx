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

import org.codehaus.enunciate.json.JsonName;
import org.codehaus.jackson.annotate.JsonProperty;
import org.gedcomx.common.ResourceReference;

import javax.xml.XMLConstants;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.List;


/**
 * Represents a source citation.
 */
@XmlType ( name = "SourceCitation" )
public class SourceCitation {

  private String lang;
  private String value;
  private ResourceReference citationTemplate;
  private List<CitationField> fields;

  /**
   * The language of the citation. See <a href="http://www.w3.org/International/articles/language-tags/">http://www.w3.org/International/articles/language-tags/</a>
   *
   * @return The language of the note.
   */
  @XmlAttribute ( namespace = XMLConstants.XML_NS_URI )
  public String getLang() {
    return lang;
  }

  /**
   * The language of the citation. See <a href="http://www.w3.org/International/articles/language-tags/">http://www.w3.org/International/articles/language-tags/</a>
   *
   * @param lang The language of the citation.
   */
  public void setLang(String lang) {
    this.lang = lang;
  }

  /**
   * A rendering (as a string) of a source citation.  This rendering should be the most complete rendering available.
   *
   * @return A rendering (as a string) of a source citation.  This rendering should be the most complete rendering available.
   */
  public String getValue() {
    return value;
  }

  /**
   * A rendering (as a string) of a source citation.  This rendering should be the most complete rendering available.
   *
   * @param value A rendering (as a string) of a source citation.  This rendering should be the most complete rendering available.
   */
  public void setValue(String value) {
    this.value = value;
  }

  /**
   * A reference to the citation template for this citation.
   *
   * @return A reference to the citation template for this citation.
   */
  public ResourceReference getCitationTemplate() {
    return citationTemplate;
  }


  /**
   * A reference to the citation template for this citation.
   *
   * @return A reference to the citation template for this citation.
   */
  public void setCitationTemplate(ResourceReference citationTemplate) {
    this.citationTemplate = citationTemplate;
  }

  /**
   * The list of citation fields.
   *
   * @return The list of citation fields.
   */
  @XmlElement (name="field")
  @JsonProperty ("fields")
  @JsonName ("fields")
  public List<CitationField> getFields() {
    return fields;
  }

  /**
   * The list of citation fields.
   *
   * @param fields The list of citation fields.
   */
  @JsonProperty ("fields")
  public void setFields(List<CitationField> fields) {
    this.fields = fields;
  }
}

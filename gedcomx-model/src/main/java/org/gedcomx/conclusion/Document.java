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
import org.gedcomx.common.Attributable;
import org.gedcomx.common.HasText;
import org.gedcomx.common.URI;
import org.gedcomx.rt.json.JsonElementWrapper;
import org.gedcomx.types.DocumentType;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;


/**
 * An abstract document that contains derived (conclusionary) text -- for example, a transcription or researcher analysis.
 */
@XmlRootElement (name = "abstract")
@JsonElementWrapper (name = "abstracts")
@XmlType(name = "Document", propOrder = { "text" })
public class Document extends Conclusion implements HasText, Attributable {

  private URI type;
  private String text;


  /**
   * The type of the document.
   *
   * @return The type of the document.
   */
  @XmlAttribute
  public URI getType() {
    return type;
  }

  /**
   * The type of the document.
   *
   * @param type The type of the document.
   */
  public void setType(URI type) {
    this.type = type;
  }

  /**
   * The enum referencing the known type of the document, or {@link org.gedcomx.types.DocumentType#OTHER} if not known.
   *
   * @return The enum referencing the known type of the document, or {@link org.gedcomx.types.DocumentType#OTHER} if not known.
   */
  @XmlTransient
  @JsonIgnore
  public org.gedcomx.types.DocumentType getKnownType() {
    return getType() == null ? null : DocumentType.fromQNameURI(getType());
  }

  /**
   * Set the type of this document from a known enumeration of document types.
   *
   * @param knownType the document type.
   */
  @JsonIgnore
  public void setKnownType(org.gedcomx.types.DocumentType knownType) {
    setType(knownType == null ? null : URI.create(org.codehaus.enunciate.XmlQNameEnumUtil.toURIValue(knownType)));
  }

  /**
   * The document text.
   *
   * @return The document text.
   */
  public String getText() {
    return text;
  }

  /**
   * The document text.
   *
   * @param text The document text.
   */
  public void setText(String text) {
    this.text = text;
  }
}

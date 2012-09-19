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

import org.gedcomx.common.Attributable;
import org.gedcomx.common.Attribution;
import org.gedcomx.common.HasText;
import org.gedcomx.common.TextValue;

import javax.xml.bind.annotation.XmlType;


/**
 * An abstract document that contains derived (conclusionary) text -- for example, a transcription or researcher analysis.
 */
@XmlType(name = "Document", propOrder = { "attribution", "text" })
public abstract class Document extends Conclusion implements HasText, Attributable {

  private Attribution attribution;
  private TextValue text;

  /**
   * Attribution metadata for a conclusion.
   *
   * @return Attribution metadata for a conclusion.
   */
  @Override
  public Attribution getAttribution() {
    return attribution;
  }

  /**
   * Attribution metadata for a conclusion.
   *
   * @param attribution Attribution metadata for a conclusion.
   */
  @Override
  public void setAttribution(Attribution attribution) {
    this.attribution = attribution;
  }

  /**
   * The document text.
   *
   * @return The document text.
   */
  public TextValue getText() {
    return text;
  }

  /**
   * The document text.
   *
   * @param text The document text.
   */
  public void setText(TextValue text) {
    this.text = text;
  }
}

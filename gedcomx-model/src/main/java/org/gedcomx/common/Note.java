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
package org.gedcomx.common;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.gedcomx.rt.SupportsExtensionElements;
import org.gedcomx.rt.json.JsonElementWrapper;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;


/**
 * A note about a genealogical resource (e.g. conclusion or source).
 *
 * @author Ryan Heaton
 */
@XmlRootElement
@JsonElementWrapper(name = "notes")
@XmlType ( name = "Note", propOrder = { "subject", "text", "attribution" } )
public class Note extends ExtensibleData implements Attributable, HasText {

  private String id;
  private TextValue subject;
  private TextValue text;
  private Attribution attribution;

  /**
   * A local, context-specific id for the data.
   *
   * @return A local, context-specific id for the data.
   */
  @XmlID
  @XmlAttribute
  public String getId() {
    return id;
  }

  /**
   * A local, context-specific id for the data.
   *
   * @param id A local, context-specific id for the data.
   */
  public void setId(String id) {
    this.id = id;
  }

  /**
   * The subject of the note. This is a short title describing the contents of the note text.
   *
   * @return The subject of the note.
   */
  public TextValue getSubject() {
    return subject;
  }

  /**
   * The subject of the note.
   *
   * @param text The subject of the note.
   */
  public void setSubject(TextValue text) {
    this.subject = text;
  }

  /**
   * The text of the note.
   *
   * @return The text of the note.
   */
  @Override
  public TextValue getText() {
    return text;
  }

  /**
   * The text of the note.
   *
   * @param text The text of the note.
   */
  @Override
  public void setText(TextValue text) {
    this.text = text;
  }

  /**
   * Attribution metadata for a note.
   *
   * @return Attribution metadata for a note.
   */
  @Override
  public Attribution getAttribution() {
    return attribution;
  }

  /**
   * Attribution metadata for a note.
   *
   * @param attribution Attribution metadata for a note.
   */
  @Override
  public void setAttribution(Attribution attribution) {
    this.attribution = attribution;
  }

  private String getTextBrief( TextValue text ) {
    if (text != null && text.getValue() != null) {
      final int substrLen = 40;
      if (text.getValue().length() > substrLen)
        return text.getValue().substring(0, substrLen) + "...";
      return text.getValue();
    }
    return null;
  }

  @Override
  public String toString() {
    return "Note{" +
      "subject=" + getTextBrief(subject) +
      ", text=" + getTextBrief(text) +
      ", attribution=" + attribution +
      '}';
  }
}

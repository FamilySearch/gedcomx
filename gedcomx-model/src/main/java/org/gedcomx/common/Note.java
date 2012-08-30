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

import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


/**
 * A note about a genealogical resource (e.g. conclusion or source).
 *
 * @author Ryan Heaton
 */
@XmlRootElement
@JsonElementWrapper(name = "notes")
@XmlType ( name = "Note", propOrder = { "subject", "text", "attribution", "extensionElements" } )
public class Note implements Attributable, HasText, SupportsExtensionElements {

  private TextValue subject;
  private TextValue text;
  private Attribution attribution;
  private List<Object> extensionElements;

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

  /**
   * The other elements such as a note title (<code>NoteTitle</code>).
   *
   * @return The other elements.
   */
  @XmlAnyElement ( lax = true )
  @JsonIgnore
  public List<Object> getExtensionElements() {
    return extensionElements;
  }

  /**
   * The other elements such as a note title (<code>NoteTitle</code>).
   *
   * @param extensionElements The other elements.
   */
  @JsonIgnore
  public void setExtensionElements(List<Object> extensionElements) {
    this.extensionElements = extensionElements;
  }

  /**
   * Add an extension element.
   *
   * @param element The extension element to add.
   */
  public void addExtensionElement(Object element) {
    if (this.extensionElements == null) {
      this.extensionElements = new ArrayList<Object>();
    }

    this.extensionElements.add(element);
  }

  /**
   * Finds the first extension of a specified type.
   *
   * @param clazz The type.
   * @return The extension, or null if none found.
   */
  @SuppressWarnings ( {"unchecked"} )
  public <E> E findExtensionOfType(Class<E> clazz) {
    if (this.extensionElements != null) {
      for (Object extension : extensionElements) {
        if (clazz.isInstance(extension)) {
          return (E) extension;
        }
      }
    }

    return null;
  }

  /**
   * Find the extensions of a specified type.
   *
   * @param clazz The type.
   * @return The extensions, possibly empty but not null.
   */
  @SuppressWarnings ( {"unchecked"} )
  public <E> List<E> findExtensionsOfType(Class<E> clazz) {
    List<E> ext = new ArrayList<E>();
    if (this.extensionElements != null) {
      for (Object extension : extensionElements) {
        if (clazz.isInstance(extension)) {
          ext.add((E) extension);
        }
      }
    }

    return ext;
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

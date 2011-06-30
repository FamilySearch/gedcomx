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
package org.gedcomx.record;

import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.gedcomx.rt.AnyElementDeserializer;
import org.gedcomx.rt.AnyElementSerializer;

import javax.xml.bind.annotation.XmlAnyElement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * An extension point to the record model.
 *
 * @author Ryan Heaton
 */
public final class Extension implements Iterable<Object> {

  private List<Object> elements;

  /**
   * The extension elements.
   *
   * @return The extension elements.
   */
  @XmlAnyElement (lax = true)
  @JsonSerialize(using = AnyElementSerializer.class)
  public List<Object> getElements() {
    return elements;
  }

  /**
   * The extension elements.
   *
   * @param elements The extension elements.
   */
  @JsonDeserialize(using = AnyElementDeserializer.class)
  public void setElements(List<Object> elements) {
    this.elements = elements;
  }

  /**
   * Add an extension element.
   *
   * @param element The extension element to add.
   */
  public void addElement(Object element) {
    if (this.elements == null) {
      this.elements = new ArrayList<Object>();
    }

    this.elements.add(element);
  }

  /**
   * Iterator through the extension elements.
   *
   * @return The iterator through the extension elements.
   */
  public Iterator<Object> iterator() {
    return this.elements == null ? Collections.<Object>emptyList().iterator() : this.elements.iterator();
  }

  /**
   * Finds the first extension of a specified type.
   *
   * @param clazz The type.
   * @return The extension, or null if none found.
   */
  @SuppressWarnings ( {"unchecked"} )
  public <E> E findExtensionOfType(Class<E> clazz) {
    if (this.elements != null) {
      for (Object extension : elements) {
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
    if (this.elements != null) {
      for (Object extension : elements) {
        if (clazz.isInstance(extension)) {
          ext.add((E) extension);
        }
      }
    }

    return ext;
  }
}

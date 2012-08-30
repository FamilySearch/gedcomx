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
 * Generic holder/container/collection for a set of resources.
 *
 * @author Ryan Heaton
 */
@XmlRootElement ( name = "resources" )
@JsonElementWrapper (name = "resourceSets")
@XmlType ( name = "ResourceSet" )
public class ResourceSet implements SupportsExtensionElements {

  private String id;
  private List<Object> extensionElements;

  /**
   * The id of this bundle.
   *
   * @return The id of this bundle.
   */
  @XmlAttribute
  @XmlID
  public String getId() {
    return id;
  }

  /**
   * The id of this bundle.
   *
   * @param id The id of this bundle.
   */
  public void setId(String id) {
    this.id = id;
  }

  /**
   * The list of resources contained in this set.
   *
   * @return The list of resources contained in this set.
   */
  @XmlAnyElement ( lax = true )
  @JsonIgnore
  public List<Object> getExtensionElements() {
    return extensionElements;
  }

  /**
   * The list of resources contained in this set.
   *
   * @param extensionElements The list of resources contained in this set.
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
}

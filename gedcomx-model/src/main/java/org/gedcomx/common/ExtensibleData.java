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

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.*;
import java.util.*;

/**
 * A set of data that supports extension elements.
 *
 * @author Ryan Heaton
 */
@XmlType( name = "ExtensibleData" )
public abstract class ExtensibleData implements SupportsExtensionElements, HasTransientProperties {

  private String id;
  protected List<Object> extensionElements;
  protected final Map<String, Object> transientProperties = new TreeMap<String, Object>();

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
   * Custom extension elements for a conclusion.
   *
   * @return Custom extension elements for a conclusion.
   */
  @XmlAnyElement (lax = true)
  @JsonIgnore
  public List<Object> getExtensionElements() {
    return extensionElements;
  }

  /**
   * Custom extension elements for a conclusion.
   *
   * @param extensionElements Custom extension elements for a conclusion.
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
    List<E> candidates = findExtensionsOfType(clazz);

    if (candidates.size() > 0) {
      return candidates.get(0);
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

  /**
   * Finds the first extension of a specified type in the given name and namespace.
   *
   * @param clazz The type.
   * @param name The name of the extension element.
   * @param namespace The namespace of the extension element.
   * @return The extension, or null if none found.
   */
  @SuppressWarnings ( {"unchecked"} )
  public <E> E findExtensionOfType(Class<E> clazz, String name, String namespace) {
    List<E> candidates = findExtensionsOfType(clazz, name, namespace);

    if (candidates.size() > 0) {
      return candidates.get(0);
    }

    return null;
  }

  /**
   * Find the extension elements of a specified type in the given name and namespace.
   *
   * @param clazz The type of the extension element.
   * @param name The name of the extension element.
   * @param namespace The namespace of the extension element.
   * @return The extensions, possibly empty but not null.
   */
  @SuppressWarnings ( {"unchecked"} )
  public <E> List<E> findExtensionsOfType(Class<E> clazz, String name, String namespace) {
    List<E> ext = new ArrayList<E>();
    if (this.extensionElements != null) {
      for (Object extension : extensionElements) {
        if (JAXBElement.class.isInstance(extension)) {
          JAXBElement<E> element = (JAXBElement<E>) extension;
          if (clazz.isInstance(element.getValue()) && element.getName().getLocalPart().equals(name) && element.getName().getNamespaceURI().equals(namespace)) {
            ext.add(element.getValue());
          }
        }
      }
    }

    return ext;
  }

  /**
   * Get the transient properties.
   *
   * @return the transient properties.
   */
  @JsonIgnore
  @XmlTransient
  @Override
  public Map<String, Object> getTransientProperties() {
    return Collections.unmodifiableMap(transientProperties);
  }

  /**
   * Get a transient (non-serialized) property.
   *
   * @param name The name of the property.
   * @return The property.
   */
  @Override
  public Object getTransientProperty(String name) {
    return this.transientProperties.get(name);
  }

  /**
   * Set a transient (non-serialized) property.
   *
   * @param name the name of the property.
   * @param value the property value.
   */
  @Override
  public void setTransientProperty(String name, Object value) {
    this.transientProperties.put(name, value);
  }
}

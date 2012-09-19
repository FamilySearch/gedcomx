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

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;
import org.gedcomx.common.Attributable;
import org.gedcomx.common.Attribution;
import org.gedcomx.common.ResourceReference;
import org.gedcomx.common.URI;
import org.gedcomx.rt.RDFRange;
import org.gedcomx.rt.SupportsExtensionElements;
import org.gedcomx.rt.json.JsonElementWrapper;

import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


/**
 * An attributable reference to a description of a source.
 *
 * @author Ryan Heaton
 */
@XmlRootElement ( name = "sourceReference" )
@JsonElementWrapper ( name = "source-references" )
@XmlType ( name = "SourceReference" )
public class SourceReference implements SupportsExtensionElements {

  private ResourceReference sourceDescription;
  private List<Object> extensionElements;

  /**
   * A reference to a description of the source being referenced.
   *
   * @return A reference to a description of the source being referenced.
   */
  @JsonProperty
  @RDFRange( external = "org.gedcomx.source.SourceDescription" )
  public ResourceReference getSourceDescription() {
    return sourceDescription;
  }

  /**
   * A reference to a description of the source being referenced.
   *
   * @param sourceDescription A reference to a description of the source being referenced.
   */
  public void setSourceDescription(ResourceReference sourceDescription) {
    this.sourceDescription = sourceDescription;
  }

  /**
   * A reference to a description of the source being referenced.
   *
   * @param descriptionRef A reference to a description of the source being referenced.
   */
  @XmlTransient
  @JsonIgnore
  public void setSourceDescriptionURI(URI descriptionRef) {
    this.sourceDescription = descriptionRef != null ? new ResourceReference(descriptionRef) : null;
  }

  /**
   * Custom attributes applicable to this resource reference.
   *
   * @return Custom attributes applicable to this resource reference.
   */
  @XmlAnyElement ( lax = true )
  @JsonIgnore
  public List<Object> getExtensionElements() {
    return extensionElements;
  }

  /**
   * Custom attributes applicable to this resource reference.
   *
   * @param extensionElements Custom attributes applicable to this resource reference.
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

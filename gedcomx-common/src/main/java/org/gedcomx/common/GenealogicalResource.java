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
package org.gedcomx.common;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.gedcomx.rt.CommonModels;
import org.gedcomx.rt.SupportsExtensionElements;

import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;

/**
 * A genealogical resource.
 *
 * @author Ryan Heaton
 */
@XmlType ( name = "GenealogicalResource", propOrder = { "attribution", "extensionElements" } )
public abstract class GenealogicalResource implements SupportsExtensionElements {

  private String id;
  private Attribution attribution;
  protected List<Object> extensionElements;

  /**
   * The id of this genealogical resource. As defined by RDF, the nature of this id
   * is local to a specific context and not necessarily globally unique.
   *
   * @return The id of this genealogical resource. As defined by RDF, the nature of this id
   * is local to a specific context and not necessarily globally unique.
   */
  @XmlID
  @XmlAttribute ( name = "ID", namespace = CommonModels.RDF_NAMESPACE )
  public String getId() {
    return id;
  }

  /**
   * The id of this genealogical resource. As defined by RDF, the nature of this id
   * is local to a specific context and not necessarily globally unique.
   *
   * @param id The id of this genealogical resource. As defined by RDF, the nature of this id
   * is local to a specific context and not necessarily globally unique.
   */
  public void setId(String id) {
    this.id = id;
  }

  /**
   * Attribution metadata for a genealogical resource. Attribution data is necessary to support
   * a sound <a href="https://wiki.familysearch.org/en/Genealogical_Proof_Standard">genealogical proof statement</a>.
   *
   * @return Attribution metadata for a genealogical resource. Attribution data is necessary to support
   * a sound <a href="https://wiki.familysearch.org/en/Genealogical_Proof_Standard">genealogical proof statement</a>.
   */
  public Attribution getAttribution() {
    return attribution;
  }

  /**
   * Attribution metadata for a genealogical resource. Attribution data is necessary to support
   * a sound <a href="https://wiki.familysearch.org/en/Genealogical_Proof_Standard">genealogical proof statement</a>.
   *
   * @param attribution Attribution metadata for a genealogical resource. Attribution data is necessary to support
   * a sound <a href="https://wiki.familysearch.org/en/Genealogical_Proof_Standard">genealogical proof statement</a>.
   */
  public void setAttribution(Attribution attribution) {
    this.attribution = attribution;
  }

  /**
   * Custom extension elements for a genealogical resource.
   *
   * @return Custom extension elements for a genealogical resource.
   */
  @XmlAnyElement (lax = true)
  @JsonIgnore
  public List<Object> getExtensionElements() {
    return extensionElements;
  }

  /**
   * Custom extension elements for a genealogical resource.
   *
   * @param extensionElements Custom extension elements for a genealogical resource.
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

  /**
   * Provide a simple toString() method.
   */
  @Override
  public String toString() {
    StringBuilder s = new StringBuilder((getId() == null) ? "" : getId());

    if (getAttribution() != null) {
      s.append(": ").append(getAttribution().toString());
    }

    return s.toString();
  }
}

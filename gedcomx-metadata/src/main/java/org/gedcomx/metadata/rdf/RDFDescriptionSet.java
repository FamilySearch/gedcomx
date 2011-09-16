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
package org.gedcomx.metadata.rdf;

import org.codehaus.enunciate.json.JsonName;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonTypeInfo;
import org.codehaus.jackson.map.annotate.JsonTypeIdResolver;
import org.gedcomx.rt.*;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

/**
 * A set of RDF descriptions, <a href="http://www.w3.org/TR/2004/REC-rdf-primer-20040210/#rdfxml">according to the RDF spec</a>.
 *
 * @author Ryan Heaton
 */
@XmlRootElement ( name = "RDF" )
@JsonExtensionElement
@JsonTypeInfo ( use = JsonTypeInfo.Id.CUSTOM, property = XmlTypeIdResolver.TYPE_PROPERTY_NAME )
@JsonTypeIdResolver ( XmlTypeIdResolver.class )
@XmlType (name = "RDF")
public class RDFDescriptionSet implements SupportsExtensionElements {

  private String id;
  private List<RDFDescription> rdfDescriptions;
  private List<Object> extensionElements;

  /**
   * The id of this bundle.
   *
   * @return The id of this bundle.
   */
  @XmlAttribute ( name = "ID" )
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
   * The RDF descriptions contained in this bundle.
   *
   * @return The RDF descriptions contained in this bundle.
   */
  @XmlElement ( name = "Description" )
  @JsonProperty ( "rdfDescriptions" )
  @JsonName ( "rdfDescriptions" )
  public List<RDFDescription> getRdfDescriptions() {
    return rdfDescriptions;
  }

  /**
   * The RDF descriptions contained in this bundle.
   *
   * @param rdfDescriptions The RDF descriptions contained in this bundle.
   */
  @JsonProperty ( "rdfDescriptions" )
  public void setRdfDescriptions(List<RDFDescription> rdfDescriptions) {
    this.rdfDescriptions = rdfDescriptions;
  }

  /**
   * The other (non-RDF) descriptions in this bundle.
   *
   * @return The other (non-RDF) descriptions in this bundle.
   */
  @XmlAnyElement ( lax = true )
  @JsonIgnore
  public List<Object> getExtensionElements() {
    return extensionElements;
  }

  /**
   * The other (non-RDF) descriptions in this bundle.
   *
   * @param extensionElements The other (non-RDF) descriptions in this bundle.
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

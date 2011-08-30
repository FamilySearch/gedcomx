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

import org.codehaus.enunciate.json.JsonName;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.gedcomx.rt.AnyElementDeserializer;
import org.gedcomx.rt.AnyElementSerializer;
import org.gedcomx.rt.RDFSubPropertyOf;
import org.gedcomx.types.TypesNamespaces;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

/**
 * A genealogical resource.
 *
 * @author Ryan Heaton
 */
@XmlType ( name = "GenealogicalResource", propOrder = { "attribution", "sources", "extensionElements" } )
public abstract class GenealogicalResource implements SourceSupported {

  private String id;
  private Attribution attribution;
  private List<ResourceReference> sources;
  private List<Object> extensionElements;

  /**
   * The id of this genealogical resource. As defined by RDF, the nature of this id
   * is local to a specific context and not necessarily globally unique.
   *
   * @return The id of this genealogical resource. As defined by RDF, the nature of this id
   * is local to a specific context and not necessarily globally unique.
   */
  @XmlID
  @XmlAttribute ( name = "ID", namespace = TypesNamespaces.RDF_NAMESPACE )
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
   * The sources for the conclusions about this person.
   *
   * @return The sources for the conclusions about this person.
   */
  @XmlElement (name="source")
  @JsonProperty ("sources")
  @JsonName ("sources")
  @RDFSubPropertyOf ( TypesNamespaces.DUBLIN_CORE_NAMESPACE + "source")
  public List<ResourceReference> getSources() {
    return sources;
  }

  /**
   * The sources for the conclusions about this person.
   *
   * @param sources The sources for the conclusions about this person.
   */
  @JsonProperty("sources")
  public void setSources(List<ResourceReference> sources) {
    this.sources = sources;
  }

  /**
   * Custom extension elements for a genealogical resource.
   *
   * @return Custom extension elements for a genealogical resource.
   */
  @XmlAnyElement (lax = true)
  @JsonSerialize(using = AnyElementSerializer.class)
  public List<Object> getExtensionElements() {
    return extensionElements;
  }

  /**
   * Custom extension elements for a genealogical resource.
   *
   * @param extensionElements Custom extension elements for a genealogical resource.
   */
  @JsonDeserialize(using = AnyElementDeserializer.class)
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

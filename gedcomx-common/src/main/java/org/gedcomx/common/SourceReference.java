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

import org.codehaus.enunciate.doc.DocumentationExample;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;
import org.gedcomx.rt.CommonModels;
import org.gedcomx.rt.RDFRange;
import org.gedcomx.rt.SupportsExtensionElements;
import org.gedcomx.rt.json.JsonElementWrapper;
import org.gedcomx.types.SourceReferenceType;
import org.gedcomx.types.TypeReference;

import javax.xml.bind.annotation.*;
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
public class SourceReference implements Attributable, SupportsExtensionElements {

  private String id;
  @XmlElement (namespace = CommonModels.RDF_NAMESPACE)
  @JsonProperty
  private TypeReference<SourceReferenceType> type;
  private ResourceReference sourceDescription;
  private Attribution attribution;
  private List<Object> extensionElements;

  /**
   * The id of this resource reference. Note the distinction between this id and the id of the
   * resource being referenced.
   *
   * @return The id of this resource reference. Note the distinction between this id and the id of the
   * resource being referenced.
   */
  @XmlID
  @XmlAttribute ( name = "ID", namespace = CommonModels.RDF_NAMESPACE )
  @DocumentationExample (exclude = true)
  public String getId() {
    return id;
  }

  /**
   * The id of this resource reference. Note the distinction between this id and the id of the
   * resource being referenced.
   *
   * @param id The id of this resource reference. Note the distinction between this id and the id of the
   * resource being referenced.
   */
  public void setId(String id) {
    this.id = id;
  }

  /**
   * The type of source reference.
   *
   * @return The type of source reference.
   */
  @XmlTransient
  @JsonIgnore
  public URI getType() {
    return this.type == null ? null : this.type.getType();
  }

  /**
   * The type of source reference.
   *
   * @param type The type of source reference.
   */
  @JsonIgnore
  public void setType(URI type) {
    this.type = type == null ? null : new TypeReference<SourceReferenceType>(type);
  }

  /**
   * The value the known type of source reference, or {@link org.gedcomx.types.SourceReferenceType#OTHER} if not known.
   *
   * @return value the known type of source reference, or {@link org.gedcomx.types.SourceReferenceType#OTHER} if not known.
   */
  @XmlTransient
  @JsonIgnore
  public SourceReferenceType getKnownType() {
    return this.type == null ? null : SourceReferenceType.fromQNameURI(this.type.getType());
  }

  /**
   * Set the type of this source reference from an enumeration of known source reference types.
   *
   * @param knownType The known source reference type.
   */
  @JsonIgnore
  public void setKnownType(SourceReferenceType knownType) {
    this.type = knownType == null ? null : new TypeReference<SourceReferenceType>(knownType);
  }

  /**
   * The attribution metadata for this source reference.
   *
   * @return The attribution metadata for this source reference.
   */
  @XmlElement ( namespace = CommonModels.GEDCOMX_COMMON_NAMESPACE )
  public Attribution getAttribution() {
    return attribution;
  }

  /**
   * The attribution metadata for this source reference.
   *
   * @param attribution The attribution metadata for this source reference.
   */
  public void setAttribution(Attribution attribution) {
    this.attribution = attribution;
  }

  /**
   * A reference to a description of the source being referenced.
   *
   * @return A reference to a description of the source being referenced.
   */
  @RDFRange( external = "org.gedcomx.metadata.source.SourceDescription" )
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
  public void setSourceDescription(URI descriptionRef) {
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

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
import org.gedcomx.common.Attribution;
import org.gedcomx.common.ResourceReference;
import org.gedcomx.rt.AnyElementDeserializer;
import org.gedcomx.rt.AnyElementSerializer;
import org.gedcomx.rt.CommonNamespaces;
import org.gedcomx.rt.RDFSubPropertyOf;

import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;

/**
 * A field on a record.
 */
@XmlType ( name = "Field", propOrder = { "original", "interpreted", "normalized", "attribution", "source", "extensionElements" } )
public abstract class Field {

  private String id;
  private String label;
  private String original;
  private String interpreted;
  private String normalized;
  private Attribution attribution;
  private ResourceReference source;
  private List<Object> extensionElements;

  /**
   * The resource id of this field.
   *
   * @return The resource id of this field.
   */
  @XmlID
  @XmlAttribute ( name = "ID", namespace = CommonNamespaces.RDF_NAMESPACE )
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
   * A label for the field. The label can be used to associate fields that were taken from the same section of
   * the source, such as identified by an indexing template.
   *
   * @return The field label.
   */
  @XmlAttribute
  public String getLabel() {
    return label;
  }

  /**
   * A label for the field. The label can be used to associate fields that were taken from the same section of
   * the source, such as identified by an indexing template.
   *
   * @param label The field label.
   */
  public void setLabel(String label) {
    this.label = label;
  }

  /**
   * The original value of the field, meant to record exactly what is displayed.
   *
   * @return The original value of the field, meant to record exactly what is displayed.
   */
  public String getOriginal() {
    return original;
  }

  /**
   * The original value of the field, meant to record exactly what is displayed.
   *
   * @param original The original value of the field, meant to record exactly what is displayed.
   */
  public void setOriginal(String original) {
    this.original = original;
  }

  /**
   * The value of the field as interpreted by the user. For example, if the original value were 'MN', the user-interpreted value could be "Minnesota".
   *
   * @return the interpreted The value of the field as interpreted by the user. For example, if the original value were 'MN', the user-interpreted value could be "Minnesota".
   */
  public String getInterpreted() {
    return interpreted;
  }

  /**
   * The value of the field as interpreted by the user. For example, if the original value were 'MN', the user-interpreted value could be "Minnesota".
   * 
   * @param interpreted The value of the field as interpreted by the user. For example, if the original value were 'MN', the user-interpreted value could be "Minnesota".
   */
  public void setInterpreted(String interpreted) {
    this.interpreted = interpreted;
  }

  /**
   * The normalized value of the field as interpreted by an automated process.
   * 
   * @return The normalized value of the field as interpreted by an automated process.
   */
  public String getNormalized() {
    return normalized;
  }

  /**
   * The normalized value of the field as interpreted by an automated process.
   * 
   * @param normalized The normalized value of the field as interpreted by an automated process.
   */
  public void setNormalized(String normalized) {
    this.normalized = normalized;
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
   * The source for the field.
   *
   * @return The source for the field.
   */
  @RDFSubPropertyOf ( CommonNamespaces.DUBLIN_CORE_NAMESPACE + "source")
  public ResourceReference getSource() {
    return source;
  }

  /**
   * The source for the field.
   *
   * @param source The source for the field.
   */
  public void setSource(ResourceReference source) {
    this.source = source;
  }

  /**
   * Custom extension elements for a genealogical resource.
   *
   * @return Custom extension elements for a genealogical resource.
   */
  @XmlAnyElement (lax = true)
  @JsonSerialize (using = AnyElementSerializer.class, include = JsonSerialize.Inclusion.NON_NULL)
  public List<Object> getExtensionElements() {
    return extensionElements;
  }

  /**
   * Custom extension elements for a genealogical resource.
   *
   * @param extensionElements Custom extension elements for a genealogical resource.
   */
  @JsonDeserialize (using = AnyElementDeserializer.class)
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

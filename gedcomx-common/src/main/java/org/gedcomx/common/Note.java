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

import org.codehaus.jackson.annotate.JsonTypeInfo;
import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.codehaus.jackson.map.annotate.JsonTypeIdResolver;
import org.gedcomx.rt.AnyElementDeserializer;
import org.gedcomx.rt.AnyElementSerializer;
import org.gedcomx.rt.CommonNamespaces;
import org.gedcomx.rt.XmlTypeIdResolver;

import javax.xml.XMLConstants;
import javax.xml.bind.annotation.*;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Ryan Heaton
 */
@XmlRootElement
@JsonTypeInfo ( use = JsonTypeInfo.Id.CUSTOM, property = "@type")
@JsonTypeIdResolver (XmlTypeIdResolver.class)
@XmlType ( name = "Note", propOrder = {"text", "attribution", "extensionElements" } )
public final class Note implements Attributable, Extensible {

  private String id;
  private URI about;
  private String text;
  private Attribution attribution;
  private List<Object> extensionElements;

  /**
   * The id of the note.
   *
   * @return The id of the note.
   */
  @XmlID
  @XmlAttribute ( name = "ID", namespace = CommonNamespaces.RDF_NAMESPACE )
  public String getId() {
    return id;
  }

  /**
   * The id of the note.
   *
   * @param id The id of the note.
   */
  public void setId(String id) {
    this.id = id;
  }


  /**
   * URI to the resource that the note is attached to.
   *
   * @return URI to the resource that the note is attached to.
   */
  @XmlAttribute ( namespace = CommonNamespaces.RDF_NAMESPACE )
  @XmlSchemaType (name = "anyURI", namespace = XMLConstants.W3C_XML_SCHEMA_NS_URI)
  public URI getAbout() {
    return about;
  }

  /**
   * URI to the resource that the note is attached to.
   *
   * @param about URI to the resource that the note is attached to.
   */
  public void setAbout(URI about) {
    this.about = about;
  }

  /**
   * The text of the note.
   *
   * @return The text of the note.
   */
  public String getText() {
    return text;
  }

  /**
   * The text of the note.
   *
   * @param text The text of the note.
   */
  public void setText(String text) {
    this.text = text;
  }

  /**
   * Attribution metadata for the note.
   *
   * @return Attribution metadata for the note.
   */
  public Attribution getAttribution() {
    return attribution;
  }

  /**
   * Attribution metadata for the note.
   *
   * @param attribution Attribution metadata for the note.
   */
  public void setAttribution(Attribution attribution) {
    this.attribution = attribution;
  }

  /**
   * Custom extension elements for the note.
   *
   * @return Custom extension elements for the note.
   */
  @XmlAnyElement (lax = true)
  @JsonSerialize (using = AnyElementSerializer.class)
  public List<Object> getExtensionElements() {
    return extensionElements;
  }

  /**
   * Custom extension elements for the note.
   *
   * @param extensionElements Custom extension elements for the note.
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

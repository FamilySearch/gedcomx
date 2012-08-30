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
import org.gedcomx.rt.RDFRange;
import org.gedcomx.rt.RDFSubPropertyOf;
import org.gedcomx.rt.SupportsExtensionElements;
import org.gedcomx.types.ConfidenceLevel;

import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * Attribution for genealogical information. Attribution is used to model the who is contributing/modifying information,
 * when they contributited it, why they are making the contribution/modification, and a statement about their confidence
 * in the information being provided.
 */
@XmlType ( name = "Attribution", propOrder = { "contributor", "modified", "confidence", "changeMessage", "extensionElements" } )
@SuppressWarnings("gedcomx:no_id")
public final class Attribution implements SupportsExtensionElements {

  private ResourceReference contributor;
  private URI confidence;
  private Date modified;
  private String changeMessage;
  private List<Object> extensionElements;

  /**
   * Reference to the contributor of the attributed data.
   *
   * @return Reference to the contributor of the attributed data.
   */
  @RDFRange({})
  @RDFSubPropertyOf( "http://purl.org/dc/terms/contributor")
  public ResourceReference getContributor() {
    return contributor;
  }

  /**
   * Reference to the contributor of the attributed data.
   *
   * @param contributor Reference to the contributor of the attributed data.
   */
  public void setContributor(ResourceReference contributor) {
    this.contributor = contributor;
  }

  /**
   * The level of confidence the contributor has about the data.
   *
   * @return The level of confidence the contributor has about the data.
   */
  public URI getConfidence() {
    return confidence;
  }

  /**
   * The level of confidence the contributor has about the data.
   *
   * @param confidence The level of confidence the contributor has about the data.
   */
  public void setConfidence(URI confidence) {
    this.confidence = confidence;
  }

  /**
   * The value of a the known confidence level, or {@link org.gedcomx.types.ConfidenceLevel#OTHER} if not known.
   *
   * @return The value of a the known confidence level, or {@link org.gedcomx.types.ConfidenceLevel#OTHER} if not known.
   */
  @XmlTransient
  @JsonIgnore
  public ConfidenceLevel getKnownConfidenceLevel() {
    return getConfidence() == null ? null : ConfidenceLevel.fromQNameURI(getConfidence());
  }

  /**
   * Set the confidence level from a known enumeration of confidence levels.
   *
   * @param level The known level.
   */
  @JsonIgnore
  public void setKnownConfidenceLevel(ConfidenceLevel level) {
    setConfidence(level == null ? null : URI.create(org.codehaus.enunciate.XmlQNameEnumUtil.toURIValue(level)));
  }

  /**
   * The modified timestamp for the attributed data.
   *
   * @return The modified timestamp for the attributed data.
   */
  @RDFSubPropertyOf( "http://purl.org/dc/terms/modified")
  public Date getModified() {
    return modified;
  }

  /**
   * The modified timestamp for the attributed data.
   *
   * @param modified The modified timestamp for the attributed data.
   */
  public void setModified(Date modified) {
    this.modified = modified;
  }

  /**
   * The "change message" for the attributed data provided by the contributor.
   *
   * @return The "change message" for the attributed data provided by the contributor.
   */
  @RDFSubPropertyOf( "http://purl.org/dc/terms/description")
  public String getChangeMessage() {
    return changeMessage;
  }

  /**
   * The "change message" for the attributed data provided by the contributor.
   *
   * @param changeMessage The "change message" for the attributed data provided by the contributor.
   */
  public void setChangeMessage(String changeMessage) {
    this.changeMessage = changeMessage;
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

  /**
   * Provide a simple toString() method.
   */
  @Override
  public String toString() {
    return (contributor == null) ? "" : contributor.toString();
  }
}

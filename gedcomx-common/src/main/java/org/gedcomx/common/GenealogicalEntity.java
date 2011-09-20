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
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;
import org.gedcomx.rt.*;

import javax.xml.XMLConstants;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import java.net.URI;
import java.util.List;

/**
 * A top-level genealogical resource, i.e. an entity.
 *
 * @author Ryan Heaton
 */
@XmlType ( name = "GenealogicalEntity", propOrder = { "persistentId", "alternateIds", "bibliographicCitation", "sources", "notes" } )
@RDFSubClassOf ( CommonNamespaces.DUBLIN_CORE_NAMESPACE + "BibliographicResource" )
public abstract class GenealogicalEntity extends GenealogicalResource implements PersistentIdentifiable {

  private URI persistentId;
  private List<AlternateId> alternateIds;
  private String bibliographicCitation;
  private List<ResourceReference> sources;
  private List<Note> notes;

  /**
   * A long-term, persistent, globally unique identifier for this entity.
   *
   * @return A long-term, persistent, globally unique identifier for this entity.
   */
  @XmlSchemaType (name = "anyURI", namespace = XMLConstants.W3C_XML_SCHEMA_NS_URI)
  public URI getPersistentId() {
    return persistentId;
  }

  /**
   * A long-term, persistent, globally unique identifier for this entity.
   *
   * @param persistentId A long-term, persistent, globally unique identifier for this entity.
   */
  public void setPersistentId(URI persistentId) {
    this.persistentId = persistentId;
  }

  /**
   * The list of alternate ids of the entity.
   *
   * @return The list of alternate ids of the entity.
   */
  @XmlElement (name="alternateId")
  @JsonProperty ("alternateIds")
  @JsonName ("alternateIds")
  public List<AlternateId> getAlternateIds() {
    return alternateIds;
  }

  /**
   * The list of alternate ids of the entity.
   *
   * @param alternateIds The list of alternate ids of the entity.
   */
  @JsonProperty ("alternateIds")
  public void setAlternateIds(List<AlternateId> alternateIds) {
    this.alternateIds = alternateIds;
  }

  /**
   * The bibliographic citation for this entity.
   *
   * @return The bibliographic citation for this entity.
   */
  @RDFSubPropertyOf ( CommonNamespaces.DUBLIN_CORE_NAMESPACE + "bibliographicCitation" )
  public String getBibliographicCitation() {
    return bibliographicCitation;
  }

  /**
   * The bibliographic citation for this entity.
   *
   * @param bibliographicCitation The bibliographic citation for this entity.
   */
  public void setBibliographicCitation(String bibliographicCitation) {
    this.bibliographicCitation = bibliographicCitation;
  }

  /**
   * The source references for a resource.
   *
   * @return The source references for a resource.
   */
  @XmlElement (name="source")
  @JsonProperty ("sources")
  @JsonName ("sources")
  @RDFSubPropertyOf ( CommonNamespaces.DUBLIN_CORE_NAMESPACE + "source")
  @RDFDomain ({}) //any resource can be identified persistently.
  @RDFRange ({}) //any resource can be identified as a source.
  @SuppressWarnings("rdf:no_range")
  public List<ResourceReference> getSources() {
    return sources;
  }

  /**
   * The source references for a resource.
   *
   * @param sources The source references for a resource.
   */
  @JsonProperty("sources")
  public void setSources(List<ResourceReference> sources) {
    this.sources = sources;
  }

  /**
   * Notes about a resource.
   *
   * @return Notes about a resource.
   */
  @XmlElement (name = "note")
  @JsonProperty ("notes")
  @JsonName ("notes")
  public List<Note> getNotes() {
    return notes;
  }

  /**
   * Notes about a resource.
   *
   * @param notes Notes about a resource.
   */
  @JsonProperty ("notes")
  public void setNotes(List<Note> notes) {
    this.notes = notes;
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

}

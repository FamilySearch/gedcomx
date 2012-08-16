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

import org.codehaus.enunciate.json.JsonName;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;
import org.gedcomx.common.*;
import org.gedcomx.rt.CommonModels;
import org.gedcomx.rt.json.JsonElementWrapper;

import javax.xml.XMLConstants;
import javax.xml.bind.annotation.*;
import java.util.List;


/**
 * Represents a description of a source.
 */
@XmlRootElement
@XmlType ( name = "SourceDescription", propOrder = { "citation", "mediator", "sources", "componentOf", "displayName", "alternateNames", "notes", "attribution" } )
@JsonElementWrapper ( name = "source-descriptions" )
public class SourceDescription implements Attributable, HasNotes, ReferencesSources {
  private String id;
  private SourceCitation citation;
  private URI about;
  private ResourceReference mediator;
  private List<SourceReference> sources;
  private SourceReference componentOf;
  private String displayName;
  private List<TextValue> alternateNames;
  private List<Note> notes;
  private Attribution attribution;

  /**
   * A local, context-specific id for the data.
   *
   * @return A local, context-specific id for the data.
   */
  @XmlID
  @XmlAttribute ( name = "ID", namespace = CommonModels.RDF_NAMESPACE )
  public String getId() {
    return id;
  }

  /**
   * A local, context-specific id for the data.
   * @param id A local, context-specific id for the data.
   */
  public void setId(String id) {
    this.id = id;
  }

  /**
   * The bibliographic citation for this source.
   *
   * @return The bibliographic citation for this source.
   */
  public SourceCitation getCitation() {
    return citation;
  }

  /**
   * The bibliographic citation for this source.
   *
   * @param citation The bibliographic citation for this source.
   */
  public void setCitation(SourceCitation citation) {
    this.citation = citation;
  }

  /**
   * The URI (if applicable) of the actual source.
   *
   * @return The URI (if applicable) of the actual source.
   */
  @XmlAttribute
  @XmlSchemaType (name = "anyURI", namespace = XMLConstants.W3C_XML_SCHEMA_NS_URI)
  public URI getAbout() {
    return about;
  }

  /**
   * The URI (if applicable) of the actual source.
   *
   * @param about The URI (if applicable) of the actual source.
   */
  public void setAbout(URI about) {
    this.about = about;
  }

  /**
   * A reference to the entity that mediates access to the described source.
   *
   * @return A reference to the entity that mediates access to the described source.
   */
  public ResourceReference getMediator() {
    return mediator;
  }

  /**
   * A reference to the entity that mediates access to the described source.
   *
   * @param mediator A reference to the entity that mediates access to the described source.
   */
  public void setMediator(ResourceReference mediator) {
    this.mediator = mediator;
  }

  /**
   * A reference to the entity that mediates access to the described source.
   *
   * @param mediator A reference to the entity that mediates access to the described source.
   */
  @XmlTransient
  @JsonIgnore
  public void setMediatorURI(URI mediator) {
    this.mediator = mediator != null ? new ResourceReference(mediator) : null;
  }

  /**
   * References to any sources to which this source is related (usually applicable to sources that are derived from or contained in another source).
   *
   * @return References to any sources to which this source is related (usually applicable to sources that are derived from or contained in another source).
   */
  @XmlElement (name="source")
  @JsonProperty ("sources")
  @JsonName ("sources")
  public List<SourceReference> getSources() {
    return sources;
  }

  /**
   * References to any sources to which this source is related (usually applicable to sources that are derived from or contained in another source).
   *
   * @param sources References to any sources to which this source is related (usually applicable to sources that are derived from or contained in another source).
   */
  @JsonProperty ("sources")
  public void setSources(List<SourceReference> sources) {
    this.sources = sources;
  }

  /**
   * A reference to the source that contains this source.
   *
   * @return A reference to the source that contains this source.
   */
  public SourceReference getComponentOf() {
    return componentOf;
  }

  /**
   * A reference to the source that contains this source.
   *
   * @param componentOf A reference to the source that contains this source.
   */
  public void setComponentOf(SourceReference componentOf) {
    this.componentOf = componentOf;
  }

  /**
   * A display name for this source.
   *
   * @return A display name for this source.
   */
  public String getDisplayName() {
    return displayName;
  }

  /**
   * A display name for this source.
   *
   * @param displayName A display name for this source.
   */
  public void setDisplayName(String displayName) {
    this.displayName = displayName;
  }

  /**
   * A list of alternate display names for this source.
   *
   * @return A list of alternate display names for this source.
   */
  @XmlElement (name="alternateName")
  @JsonProperty ("alternateNames")
  @JsonName ("alternateNames")
  public List<TextValue> getAlternateNames() {
    return alternateNames;
  }

  /**
   * A list of alternate display names for this source.
   *
   * @param alternateNames A list of alternate display names for this source.
   */
  @JsonProperty ("alternateNames")
  public void setAlternateNames(List<TextValue> alternateNames) {
    this.alternateNames = alternateNames;
  }

  /**
   * Notes about a source.
   *
   * @return Notes about a source.
   */
  @XmlElement (name="note")
  @JsonProperty ("notes")
  @JsonName ("notes")
  public List<Note> getNotes() {
    return notes;
  }

  /**
   * Notes about a source.
   *
   * @param notes Notes about a source.
   */
  @JsonProperty ("notes")
  public void setNotes(List<Note> notes) {
    this.notes = notes;
  }

  /**
   * The attribution metadata for this source description.
   *
   * @return The attribution metadata for this source description.
   */
  @XmlElement ( namespace = CommonModels.GEDCOMX_COMMON_NAMESPACE )
  public Attribution getAttribution() {
    return attribution;
  }

  /**
   * The attribution metadata for this source description.
   *
   * @param attribution The attribution metadata for this source description.
   */
  public void setAttribution(Attribution attribution) {
    this.attribution = attribution;
  }

}

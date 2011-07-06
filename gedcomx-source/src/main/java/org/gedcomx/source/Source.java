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
package org.gedcomx.source;

import org.codehaus.enunciate.XmlQNameEnumUtil;
import org.codehaus.enunciate.json.JsonName;
import org.codehaus.enunciate.qname.XmlQNameEnumRef;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonTypeInfo;
import org.codehaus.jackson.map.annotate.JsonTypeIdResolver;
import org.gedcomx.attribution.Attribution;
import org.gedcomx.common.AlternateId;
import org.gedcomx.common.Extension;
import org.gedcomx.rt.XmlTypeIdResolver;
import org.gedcomx.types.SourceType;

import javax.xml.XMLConstants;
import javax.xml.bind.annotation.*;
import javax.xml.namespace.QName;
import java.net.URI;
import java.util.List;

/**
 * A user-defined, user-managed source.
 *
 * @author Ryan Heaton
 */
@XmlRootElement
@XmlType (
  propOrder =  {"persistentId", "alternateIds", "webLocation", "title", "note", "bibliographicCitation", "attribution", "extension"}
)
@JsonTypeInfo ( use =JsonTypeInfo.Id.CUSTOM, property = "@type")
@JsonTypeIdResolver (XmlTypeIdResolver.class)
public class Source {

  private String id;
  private URI persistentId;
  private List<AlternateId> alternateIds;
  private QName type;
  private URI webLocation;
  private String title;
  private String note; //todo: rename to something like "user note" or something?
  private String bibliographicCitation;
  private Attribution attribution;
  private Extension extension;

  /**
   * The id of the source, unique to the context and not necessarily globally unique.
   *
   * @return The id of the source, unique to the context and not necessarily globally unique.
   */
  @XmlID
  @XmlAttribute
  public String getId() {
    return id;
  }

  /**
   * The id of the source, unique to the context and not necessarily globally unique.
   *
   * @param id The id of the source, unique to the context and not necessarily globally unique.
   */
  public void setId(String id) {
    this.id = id;
  }

  /**
   * The type of the source.
   *
   * @return The type of the source.
   */
  @XmlAttribute
  @XmlQNameEnumRef(SourceType.class)
  public QName getType() {
    return type;
  }

  /**
   * The type of the source.
   *
   * @param type The type of the source.
   */
  public void setType(QName type) {
    this.type = type;
  }

  /**
   * The enum referencing the known type of the source, or {@link org.gedcomx.types.SourceType#other} if not known.
   *
   * @return The enum referencing the known type of the source, or {@link org.gedcomx.types.SourceType#other} if not known.
   */
  @XmlTransient
  public SourceType getKnownType() {
    return XmlQNameEnumUtil.fromQName(getType(), SourceType.class);
  }

  /**
   * Set the source type from an enumeration of known source types.
   * 
   * @param knownType The source type.
   */
  public void setKnownType(SourceType knownType) {
    this.type = XmlQNameEnumUtil.toQName(knownType);
  }

  /**
   * A long-term, persistent, globally unique identifier for this source.
   *
   * @return A long-term, persistent, globally unique identifier for this source.
   */
  @XmlSchemaType(name = "anyURI", namespace = XMLConstants.W3C_XML_SCHEMA_NS_URI)
  public URI getPersistentId() {
    return persistentId;
  }

  /**
   * A long-term, persistent, globally unique identifier for this source.
   *
   * @param persistentId A long-term, persistent, globally unique identifier for this source.
   */
  public void setPersistentId(URI persistentId) {
    this.persistentId = persistentId;
  }

  /**
   * The list of alternate ids of the source.
   *
   * @return The list of alternate ids of the source.
   */
  @XmlElement (name="alternateId")
  @JsonProperty ("alternateIds")
  @JsonName ("alternateIds")
  public List<AlternateId> getAlternateIds() {
    return alternateIds;
  }

  /**
   * The list of alternate ids of the source.
   *
   * @param alternateIds The list of alternate ids of the source.
   */
  @JsonProperty ("alternateIds")
  public void setAlternateIds(List<AlternateId> alternateIds) {
    this.alternateIds = alternateIds;
  }

  /**
   * The online location of the source.
   * 
   * @return The online location of the source.
   */
  @XmlSchemaType(name = "anyURI", namespace = XMLConstants.W3C_XML_SCHEMA_NS_URI)
  public URI getWebLocation() {
    return webLocation;
  }

  /**
   * The online location of the source.
   * 
   * @param webLocation The online location of the source.
   */
  public void setWebLocation(URI webLocation) {
    this.webLocation = webLocation;
  }

  /**
   * The title of the source.
   * 
   * @return The title of the source.
   */
  public String getTitle() {
    return title;
  }

  /**
   * The title of the source.
   * 
   * @param title The title of the source.
   */
  public void setTitle(String title) {
    this.title = title;
  }

  /**
   * A note for the source.
   * 
   * @return A note for the source.
   */
  public String getNote() {
    return note;
  }

  /**
   * A note for the source.
   * 
   * @param note A note for the source.
   */
  public void setNote(String note) {
    this.note = note;
  }

  /**
   * The bibliographic citation for the source.
   * 
   * @return The bibliographic citation for the source.
   */
  public String getBibliographicCitation() {
    return bibliographicCitation;
  }

  /**
   * The bibliographic citation for the source.
   * 
   * @param bibliographicCitation The bibliographic citation for the source.
   */
  public void setBibliographicCitation(String bibliographicCitation) {
    this.bibliographicCitation = bibliographicCitation;
  }

  /**
   * The attribution metadata for this source.
   *
   * @return The attribution metadata for this source.
   */
  public Attribution getAttribution() {
    return attribution;
  }

  /**
   * The attribution metadata for this source.
   *
   * @param attribution The attribution metadata for this source.
   */
  public void setAttribution(Attribution attribution) {
    this.attribution = attribution;
  }

  /**
   * The extension point for the source.
   *
   * @return The extension point for the source.
   */
  @XmlElement( name = "ext" )
  public Extension getExtension() {
    return extension;
  }

  /**
   * The extension point for the source.
   *
   * @param extension The extension point for the source.
   */
  public void setExtension(Extension extension) {
    this.extension = extension;
  }
}

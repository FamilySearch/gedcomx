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
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonTypeInfo;
import org.codehaus.jackson.map.annotate.JsonTypeIdResolver;
import org.gedcomx.attribution.Attribution;
import org.gedcomx.common.AlternateId;
import org.gedcomx.common.Extension;
import org.gedcomx.common.SourceReference;
import org.gedcomx.rt.XmlTypeIdResolver;
import org.gedcomx.types.SourceType;

import javax.xml.XMLConstants;
import javax.xml.bind.annotation.*;
import javax.xml.namespace.QName;
import java.net.URI;
import java.util.List;

/**
 * A description of a source. The source being described may have a presence on the World Wide Web (e.g. a digital image)
 * or it may be a <i>physical artifact</i> that doesn't have an online presence.
 *
 * @author Ryan Heaton
 */
@XmlRootElement
@XmlType (
  propOrder =  {"persistentId", "alternateIds", "about", "title", "bibliographicCitation", "sources", "attribution", "extension"}
)
@JsonTypeInfo ( use =JsonTypeInfo.Id.CUSTOM, property = "@type")
@JsonTypeIdResolver (XmlTypeIdResolver.class)
public class SourceDescription {

  private String id;
  private URI persistentId;
  private List<AlternateId> alternateIds;
  private QName type;
  private URI about;
  private String title;
  private String bibliographicCitation;
  private List<SourceReference> sources;
  private Attribution attribution;
  private Extension extension;

  /**
   * The id of this source description, unique to the context and not necessarily globally unique.
   *
   * @return The id of this source description, unique to the context and not necessarily globally unique.
   */
  @XmlID
  @XmlAttribute
  public String getId() {
    return id;
  }

  /**
   * The id of this source description, unique to the context and not necessarily globally unique.
   *
   * @param id The id of this source description, unique to the context and not necessarily globally unique.
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
  @JsonIgnore
  public SourceType getKnownType() {
    return XmlQNameEnumUtil.fromQName(getType(), SourceType.class);
  }

  /**
   * Set the source type from an enumeration of known source types.
   * 
   * @param knownType The source type.
   */
  @org.codehaus.enunciate.json.JsonIgnore
  public void setKnownType(SourceType knownType) {
    this.type = XmlQNameEnumUtil.toQName(knownType);
  }

  /**
   * A long-term, persistent, globally unique identifier for this source description.
   *
   * @return A long-term, persistent, globally unique identifier for this source description.
   */
  @XmlSchemaType(name = "anyURI", namespace = XMLConstants.W3C_XML_SCHEMA_NS_URI)
  public URI getPersistentId() {
    return persistentId;
  }

  /**
   * A long-term, persistent, globally unique identifier for this source description.
   *
   * @param persistentId A long-term, persistent, globally unique identifier for this source description.
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
   * The URI to the source being described, if the source has an online presence (e.g. a digital image).
   * 
   * @return The URI to the source being described, if the source has an online presence (e.g. a digital image).
   */
  @XmlSchemaType(name = "anyURI", namespace = XMLConstants.W3C_XML_SCHEMA_NS_URI)
  public URI getAbout() {
    return about;
  }

  /**
   * The URI to the source being described, if the source has an online presence (e.g. a digital image).
   * 
   * @param about The URI to the source being described, if the source has an online presence (e.g. a digital image).
   */
  public void setAbout(URI about) {
    this.about = about;
  }

  /**
   * The title of the source being described.
   * 
   * @return The title of the source being described.
   */
  public String getTitle() {
    return title;
  }

  /**
   * The title of the source being described.
   * 
   * @param title The title of the source being described.
   */
  public void setTitle(String title) {
    this.title = title;
  }

  /**
   * The bibliographic citation for the source being described.
   * 
   * @return The bibliographic citation for the source being described.
   */
  public String getBibliographicCitation() {
    return bibliographicCitation;
  }

  /**
   * The bibliographic citation for the source being described.
   * 
   * @param bibliographicCitation The bibliographic citation for the source being described.
   */
  public void setBibliographicCitation(String bibliographicCitation) {
    this.bibliographicCitation = bibliographicCitation;
  }

  /**
   * The sources of the source being described.
   *
   * @return The sources of the source being described.
   */
  @XmlElement(name="source")
  @JsonProperty("sources")
  @JsonName("sources")
  public List<SourceReference> getSources() {
    return sources;
  }

  /**
   * The sources of the source being described.
   *
   * @param sources The sources of the source being described.
   */
  @JsonProperty("sources")
  public void setSources(List<SourceReference> sources) {
    this.sources = sources;
  }

  /**
   * The attribution metadata for this source description.
   *
   * @return The attribution metadata for this source description.
   */
  @XmlElementRef
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

  /**
   * The extension point for this source description.
   *
   * @return The extension point for this source description.
   */
  @XmlElement( name = "ext" )
  public Extension getExtension() {
    return extension;
  }

  /**
   * The extension point for this source description.
   *
   * @param extension The extension point for this source description.
   */
  public void setExtension(Extension extension) {
    this.extension = extension;
  }
}

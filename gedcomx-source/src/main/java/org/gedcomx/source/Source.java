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
import org.codehaus.enunciate.qname.XmlQNameEnumRef;
import org.gedcomx.attribution.AttributionReference;
import org.gedcomx.types.SourceType;

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
  propOrder =  {"alternateIds", "webLocation", "title", "note", "bibliographicCitation", "attribution"}
)
public class Source {

  private String id;
  private List<AlternateId> alternateIds;
  private QName type;
  private URI webLocation;
  private String title;
  private String note; //todo: rename to something like "user note" or something?
  private String bibliographicCitation;
  private AttributionReference attribution;

  @XmlID
  @XmlAttribute
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  @XmlAttribute
  @XmlQNameEnumRef(SourceType.class)
  public QName getType() {
    return type;
  }

  public void setType(QName type) {
    this.type = type;
  }

  @XmlTransient
  public SourceType getKnownType() {
    return XmlQNameEnumUtil.fromQName(getType(), SourceType.class);
  }

  public void setKnownType(SourceType knownType) {
    this.type = XmlQNameEnumUtil.toQName(knownType);
  }

  public List<AlternateId> getAlternateIds() {
    return alternateIds;
  }

  public void setAlternateIds(List<AlternateId> alternateIds) {
    this.alternateIds = alternateIds;
  }

  public URI getWebLocation() {
    return webLocation;
  }

  public void setWebLocation(URI webLocation) {
    this.webLocation = webLocation;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getNote() {
    return note;
  }

  public void setNote(String note) {
    this.note = note;
  }

  public String getBibliographicCitation() {
    return bibliographicCitation;
  }

  public void setBibliographicCitation(String bibliographicCitation) {
    this.bibliographicCitation = bibliographicCitation;
  }

  public AttributionReference getAttribution() {
    return attribution;
  }

  public void setAttribution(AttributionReference attribution) {
    this.attribution = attribution;
  }
}

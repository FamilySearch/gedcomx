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
import org.gedcomx.types.SourceReferenceType;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.namespace.QName;
import java.net.URI;
import java.util.List;

/**
 * A reference to a source.
 *
 * @author Ryan Heaton
 */
public class SourceReference {

  private String id;
  private URI href;
  private QName type;
  private List<SourceQualifier> qualifiers;

  /**
   * The id of this source reference, unique to its entity.
   *
   * @return The id of this source reference, unique to its entity.
   */
  @XmlID
  @XmlAttribute
  public String getId() {
    return id;
  }

  /**
   * The id of this source reference, unique to its entity.
   *
   * @param id The id of this source reference, unique to its entity.
   */
  public void setId(String id) {
    this.id = id;
  }

  /**
   * The link to the source.
   *
   * @return The link to the source.
   */
  @XmlAttribute(namespace="http://www.w3.org/1999/xlink")
  public URI getHref() {
    return href;
  }

  /**
   * The link to the source.
   *
   * @param href The link to the source.
   */
  public void setHref(URI href) {
    this.href = href;
  }

  /**
   * The type of the source reference.
   *
   * @return The type of the source reference.
   */
  @XmlAttribute
  @XmlQNameEnumRef (SourceReferenceType.class)
  public QName getType() {
    return type;
  }

  /**
   * The type of the source reference.
   *
   * @param type The type of the source reference.
   */
  public void setType(QName type) {
    this.type = type;
  }

  /**
   * The enum referencing the known type of the source reference, or {@link org.gedcomx.types.SourceReferenceType#other} if not known.
   *
   * @return The enum referencing the known type of the source reference, or {@link org.gedcomx.types.SourceReferenceType#other} if not known.
   */
  @XmlTransient
  public SourceReferenceType getKnownType() {
    return XmlQNameEnumUtil.fromQName(getType(), SourceReferenceType.class);
  }

  /**
   * Set the type of this source reference from an enumeration of known source reference types.
   *
   * @param knownType The source reference type.
   */
  public void setKnownType(SourceReferenceType knownType) {
    this.type = XmlQNameEnumUtil.toQName(knownType);
  }

  /**
   * The qualifiers for the source being referenced.
   *
   * @return The qualifiers for the source being referenced.
   */
  public List<SourceQualifier> getQualifiers() {
    return qualifiers;
  }

  /**
   * The qualifiers for the source being referenced.
   *
   * @param qualifiers The qualifiers for the source being referenced.
   */
  public void setQualifiers(List<SourceQualifier> qualifiers) {
    this.qualifiers = qualifiers;
  }
}

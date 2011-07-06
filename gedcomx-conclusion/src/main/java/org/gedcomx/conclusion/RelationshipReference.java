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
package org.gedcomx.conclusion;

import org.codehaus.enunciate.XmlQNameEnumUtil;
import org.codehaus.enunciate.qname.XmlQNameEnumRef;
import org.gedcomx.types.RelationshipRole;

import javax.xml.XMLConstants;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.namespace.QName;
import java.net.URI;

/**
 * A reference to a relationship.
 *
 * @author Ryan Heaton
 */
public final class RelationshipReference {

  private QName role;
  private URI href;

  /**
   * The applicable role in the relationship. Context-specific.
   *
   * @return The applicable role in the relationship. Context-specific.
   */
  @XmlAttribute
  @XmlQNameEnumRef (RelationshipRole.class)
  public QName getRole() {
    return role;
  }

  /**
   * The applicable role in the relationship. Context-specific.
   *
   * @param role The applicable role in the relationship. Context-specific.
   */
  public void setRole(QName role) {
    this.role = role;
  }

  /**
   * The enum referencing the known role, or {@link org.gedcomx.types.RelationshipRole#other} if not known.
   *
   * @return The enum referencing the known role, or {@link org.gedcomx.types.RelationshipRole#other} if not known.
   */
  @XmlTransient
  public RelationshipRole getKnownRole() {
    return XmlQNameEnumUtil.fromQName(getRole(), RelationshipRole.class);
  }

  /**
   * Set the role from a known enumeration of roles.
   *
   * @param knownRole The role.
   */
  public void setKnownRole(RelationshipRole knownRole) {
    this.role = XmlQNameEnumUtil.toQName(knownRole);
  }

  /**
   * The link to the person.
   *
   * @return The link to the person.
   */
  @XmlAttribute(namespace="http://www.w3.org/1999/xlink")
  @XmlSchemaType (name = "anyURI", namespace = XMLConstants.W3C_XML_SCHEMA_NS_URI)
  public URI getHref() {
    return href;
  }

  /**
   * The link to the person.
   *
   * @param href The link to the person.
   */
  public void setHref(URI href) {
    this.href = href;
  }

}

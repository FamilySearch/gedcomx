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

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.namespace.QName;
import java.net.URI;

/**
 * @author Ryan Heaton
 */
public class RelationshipReference {

  private QName role;
  private URI href;
  
  @XmlAttribute
  @XmlQNameEnumRef (RelationshipRole.class)
  public QName getRole() {
    return role;
  }

  public void setRole(QName role) {
    this.role = role;
  }

  @XmlTransient
  public RelationshipRole getKnownRole() {
    return XmlQNameEnumUtil.fromQName(getRole(), RelationshipRole.class);
  }

  public void setKnownRole(RelationshipRole knownRole) {
    this.role = XmlQNameEnumUtil.toQName(knownRole);
  }

  @XmlAttribute(namespace="http://www.w3.org/1999/xlink")
  public URI getHref() {
    return href;
  }

  public void setHref(URI href) {
    this.href = href;
  }

}

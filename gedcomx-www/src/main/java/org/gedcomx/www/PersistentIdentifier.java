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
package org.gedcomx.www;

import org.codehaus.enunciate.XmlQNameEnumUtil;
import org.codehaus.enunciate.qname.XmlQNameEnumRef;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlValue;
import javax.xml.namespace.QName;
import java.net.URI;

/**
 * @author Ryan Heaton
 */
public class PersistentIdentifier {

  private QName type;
  private URI value;

  @XmlAttribute
  @XmlQNameEnumRef(PersistentIdentifierType.class)
  public QName getType() {
    return type;
  }

  public void setType(QName type) {
    this.type = type;
  }

  @XmlTransient
  public PersistentIdentifierType getKnownType() {
    return XmlQNameEnumUtil.fromQName(getType(), PersistentIdentifierType.class);
  }

  public void setKnownType(PersistentIdentifierType type) {
    this.type = XmlQNameEnumUtil.toQName(type);
  }

  @XmlValue
  public URI getValue() {
    return value;
  }

  public void setValue(URI value) {
    this.value = value;
  }
}

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

import org.codehaus.jackson.annotate.JsonTypeInfo;
import org.codehaus.jackson.map.annotate.JsonTypeIdResolver;
import org.gedcomx.rt.JsonExtensionElement;
import org.gedcomx.rt.XmlTypeIdResolver;

import javax.xml.XMLConstants;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.namespace.QName;
import java.net.URI;

/**
 * A WWW link.
 *
 * @author Ryan Heaton
 */
@XmlRootElement
@JsonExtensionElement
@JsonTypeInfo ( use =JsonTypeInfo.Id.CUSTOM, property = XmlTypeIdResolver.TYPE_PROPERTY_NAME)
@JsonTypeIdResolver (XmlTypeIdResolver.class)
public final class Link {

  private QName rel;
  private URI href;

  /**
   * The link relationship.
   *
   * @return The link relationship.
   */
  @XmlAttribute
  public QName getRel() {
    return rel;
  }

  /**
   * The link relationship.
   *
   * @param rel The link relationship.
   */
  public void setRel(QName rel) {
    this.rel = rel;
  }

  /**
   * The link URI.
   *
   * @return The link URI.
   */
  @XmlAttribute
  @XmlSchemaType (name = "anyURI", namespace = XMLConstants.W3C_XML_SCHEMA_NS_URI)
  public URI getHref() {
    return href;
  }

  /**
   * The link URI.
   *
   * @param href The link URI.
   */
  public void setHref(URI href) {
    this.href = href;
  }
}

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
package org.gedcomx.rs;

import org.codehaus.jackson.annotate.JsonTypeInfo;
import org.codehaus.jackson.map.annotate.JsonTypeIdResolver;
import org.gedcomx.rt.JsonElementWrapper;
import org.gedcomx.rt.XmlTypeIdResolver;

import javax.xml.XMLConstants;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import java.net.URI;

/**
 * A WWW link.
 *
 * @author Ryan Heaton
 */
@XmlRootElement
@JsonElementWrapper (name = "links")
@JsonTypeInfo ( use =JsonTypeInfo.Id.CUSTOM, property = XmlTypeIdResolver.TYPE_PROPERTY_NAME)
@JsonTypeIdResolver (XmlTypeIdResolver.class)
@SuppressWarnings("unqualified-attribute")
public final class Link {

  private String rel;
  private URI href;

  /**
   * The link relationship.
   *
   * @return The link relationship.
   */
  @XmlAttribute
  public String getRel() {
    return rel;
  }

  /**
   * The link relationship.
   *
   * @param rel The link relationship.
   */
  public void setRel(String rel) {
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

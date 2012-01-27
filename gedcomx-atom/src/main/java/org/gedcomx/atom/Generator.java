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
package org.gedcomx.atom;

import org.gedcomx.common.URI;

import javax.xml.XMLConstants;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;

/**
 * identifies the agent used to generate a feed, for debugging and other purposes.
 * 
 * @author Ryan Heaton
 * @see <a href="http://tools.ietf.org/html/rfc4287#section-4.2.4">The atom spec, section 4.2.4.</a>
 */
@XmlType ( name = "Generator" )
public final class Generator {

  private String lang;
  private URI base;
  private URI uri;
  private String version;
  private String value;

  /**
   * The language.
   *
   * @return The language.
   * @see <a href="http://tools.ietf.org/html/rfc4287#section-2">The atom spec, section 2.</a>
   */
  @XmlAttribute ( namespace = XMLConstants.XML_NS_URI )
  public String getLang() {
    return lang;
  }

  /**
   * The language.
   *
   * @param lang The language.
   * @see <a href="http://tools.ietf.org/html/rfc4287#section-2">The atom spec, section 2.</a>
   */
  public void setLang(String lang) {
    this.lang = lang;
  }

  /**
   * The base.
   *
   * @return The base.
   * @see <a href="http://tools.ietf.org/html/rfc4287#section-2">The atom spec, section 2.</a>
   */
  @XmlAttribute
  @XmlSchemaType (name = "anyURI", namespace = XMLConstants.W3C_XML_SCHEMA_NS_URI)
  public URI getBase() {
    return base;
  }

  /**
   * The base.
   *
   * @param base The base.
   * @see <a href="http://tools.ietf.org/html/rfc4287#section-2">The atom spec, section 2.</a>
   */
  public void setBase(URI base) {
    this.base = base;
  }

  /**
   * link to a representation that is relevant to the generating agent.
   *
   * @return link to a representation that is relevant to the generating agent.
   */
  @XmlAttribute
  @XmlSchemaType (name = "anyURI", namespace = XMLConstants.W3C_XML_SCHEMA_NS_URI)
  public URI getUri() {
    return uri;
  }

  /**
   * link to a representation that is relevant to the generating agent.
   *
   * @param uri link to a representation that is relevant to the generating agent.
   */
  public void setUri(URI uri) {
    this.uri = uri;
  }

  /**
   * the version of the generating agent
   *
   * @return the version of the generating agent
   */
  @XmlAttribute
  public String getVersion() {
    return version;
  }

  /**
   * the version of the generating agent
   *
   * @param version the version of the generating agent
   */
  public void setVersion(String version) {
    this.version = version;
  }

  /**
   * human-readable name for the generating agent
   *
   * @return human-readable name for the generating agent
   */
  @XmlValue
  public String getValue() {
    return value;
  }

  /**
   * human-readable name for the generating agent
   *
   * @param value human-readable name for the generating agent
   */
  public void setValue(String value) {
    this.value = value;
  }
}

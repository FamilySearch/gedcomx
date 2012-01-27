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

import org.codehaus.jackson.annotate.JsonTypeInfo;
import org.codehaus.jackson.map.annotate.JsonTypeIdResolver;
import org.gedcomx.common.URI;
import org.gedcomx.rt.XmlTypeIdResolver;

import javax.xml.XMLConstants;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;

/**
 * @author Ryan Heaton
 */
@XmlType ( name = "Content" )
@JsonTypeInfo ( use =JsonTypeInfo.Id.CUSTOM, property = XmlTypeIdResolver.TYPE_PROPERTY_NAME)
@JsonTypeIdResolver (XmlTypeIdResolver.class)
@SuppressWarnings("gedcomx:no_id")
public class Content {

  private String lang;
  private URI base;
  private AtomContentType type;
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
   * The type of the content.
   *
   * @return The type of the content.
   */
  @XmlAttribute
  public AtomContentType getType() {
    return type;
  }

  /**
   * The type of the content.
   *
   * @param type The type of the content.
   */
  public void setType(AtomContentType type) {
    this.type = type;
  }

  /**
   * The value of the content.
   *
   * @return The value of the content.
   */
  @XmlValue
  public String getValue() {
    return value;
  }

  /**
   * The value of the content.
   *
   * @param value The value of the content.
   */
  public void setValue(String value) {
    this.value = value;
  }
}

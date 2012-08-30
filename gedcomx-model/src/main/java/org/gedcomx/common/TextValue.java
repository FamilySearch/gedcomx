/**
 * Copyright 2011-2012 Intellectual Reserve, Inc.
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
package org.gedcomx.common;

import javax.xml.XMLConstants;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;


/**
 * An element representing a text value that may be in a specific language.
 */
@XmlType ( name = "TextValue" )
public class TextValue {

  private String lang;
  private String value;

  public TextValue() {
  }

  public TextValue(String value) {
    this.value = value;
  }

  /**
   * The language of the text value. See <a href="http://www.w3.org/International/articles/language-tags/>http://www.w3.org/International/articles/language-tags/</a>
   *
   * @return The language of the text value.
   */
  @XmlAttribute( namespace = XMLConstants.XML_NS_URI )
  public String getLang() {
    return lang;
  }

  /**
   * The language of the text value. See <a href="http://www.w3.org/International/articles/language-tags/>http://www.w3.org/International/articles/language-tags/</a>
   *
   * @param lang The language of the text value.
   */
  public void setLang(String lang) {
    this.lang = lang;
  }

  /**
   * The text value.
   *
   * @return The text value.
   */
  @XmlValue
  public String getValue() {
    return value;
  }

  /**
   * The text value.
   *
   * @param value The text value.
   */
  public void setValue(String value) {
    this.value = value;
  }

  @Override
  public boolean equals( Object o ) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    TextValue textValue = (TextValue) o;

    if (lang != null ? !lang.equals( textValue.lang ) : textValue.lang != null) {
      return false;
    }
    if (value != null ? !value.equals( textValue.value ) : textValue.value != null) {
      return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int result = lang != null ? lang.hashCode() : 0;
    result = 31 * result + (value != null ? value.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "TextValue{" +
      "value='" + value + '\'' +
      ", lang='" + lang + '\'' +
      '}';
  }
}

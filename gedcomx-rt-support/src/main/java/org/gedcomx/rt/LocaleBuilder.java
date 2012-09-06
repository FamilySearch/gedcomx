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
package org.gedcomx.rt;

import java.util.HashMap;
import java.util.Locale;

/**
 * Helper class compose the cultural context (locale) String from its parts
 *
 * @author DaveySE
 * Creation Date: 9/5/12
 */
public class LocaleBuilder {
  private String language;
  private Locale locale;
  private String script;
  private String region;
  private String variant;
  private HashMap<Character,String> extensions = new HashMap<Character,String>();


  /**
   *
   */
  public LocaleBuilder() {
  }

  /**
   *
   * @return this builder
   */
  public LocaleBuilder clear() {
    language = null;
    script = null;
    region = null;
    variant = null;
    extensions.clear();
    return this;
  }

  /**
   *
   * @return this builder
   */
  public LocaleBuilder clearExtensions() {
    extensions.clear();
    return this;
  }

  /**
   *
   * @return this builder
   */
  public String build() {
    // TODO - compose the String
    return null;
  }

  /**
   *
   * @param locale
   * @return this builder
   */
  public LocaleBuilder setByLocale(Locale locale) {
    // TODO - parse into its pieces, then save them into the member vars
    return this;
  }

  /**
   * Resets the LocaleBuilder to match the provided IETF BCP 47 language tag.
   * Null and the empty string cause the builder to be reset.
   * The language tag must be well-formed; otherwise the ill-formed and following portions
   * of the tag are discarded.
   * @param tag
   * @return this builder
   */
  public LocaleBuilder setByLanguageTag(String tag) {
    // TODO - parse into its pieces, then save them into the member vars
    return this;
  }

  /* ===========================================================================
   * ================ Standard getters and setters =============================
   * ===========================================================================
   */

  /**
   * Sets the language portion of the locale
   * The string must be a two or three-letter language code as defined in ISO 639. Otherwise,
   * the language portion will not be set.
   * The empty string or null will clear the language value.
   * @param language the language portion to be set
   * @return this builder
   */
  public LocaleBuilder setLanguage(String language) {
    this.language = language;
    return this;
  }

  /**
   * Sets the script portion of the locale
   * The string must be a four-letter script code as defined in ISO 15924.
   * Otherwise, the script portion will not be set.
   * The empty string or null will clear the script value
   * @param script the script portion to be set
   * @return this builder
   */
  public LocaleBuilder setScript(String script) {
    this.script = script;
    return this;
  }

  /**
   * Sets the region portion of the locale
   * The string must be a two-letter ISO 3166 code or a three-letter UN M.49 area code. Otherwise,
   * the region portion will not be set.
   * The empty string or null will clear the region value.
   * @param region the region portion to be set
   * @return this builder
   */
  public LocaleBuilder setRegion(String region) {
    this.region = region;
    return this;
  }

  /**
   * Sets the variant portion of the locale
   * The string must satisfy the IETF BCP 47 variant subtag syntax requirements. Otherwise,
   * the variant portion will not be set.
   * The empty string or null will clear the language value.
   * @param variant the variant portion to be set
   * @return this builder
   */
  public LocaleBuilder setVariant(String variant) {
    this.variant = variant;
    return this;
  }

  /**
   * Sets the value for the specified extension portion of the locale
   * The string must be a two or three-letter language code as defined in ISO 639. Otherwise,
   * the language portion will not be set.
   * The empty string or null will clear the language value.
   * @param key character key for the extension
   * @param value value for this extension. The empty string or null will clear the value for this extension
   * @return this builder
   */
  public LocaleBuilder setExtension(char key, String value) {
    this.extensions.put(key,value);
    return this;
  }
}

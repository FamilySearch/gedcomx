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
package org.gedcomx.record;

import org.gedcomx.attribution.Attribution;

import javax.xml.bind.annotation.*;

/**
 * A field on a record.
 */
@XmlType ( propOrder = { "attribution", "original", "interpreted", "normalized", "extension"})
public abstract class Field {

  private String id;
  private String fieldId;
  private String original;
  private String interpreted;
  private String normalized;
  private Attribution attribution;
  private Extension extension;

  /**
   * The id of this field data, unique to its record.
   *
   * @return The id of this field data, unique to its record.
   */
  @XmlID
  @XmlAttribute
  public String getId() {
    return id;
  }

  /**
   * The id of this field data, unique to its record.
   *
   * @param id The id of this field data, unique to its record.
   */
  public void setId(String id) {
    this.id = id;
  }

  /**
   * The id of the field, unique to the record but common across records of the same type. Used, for example, for record templates.
   *
   * @return The id of the field, unique to the record but common across records of the same type. Used, for example, for record templates.
   */
  @XmlAttribute
  public String getFieldId() {
    return fieldId;
  }

  /**
   * The id of the field, unique to the record but common across records of the same type. Used, for example, for record templates.
   *
   * @param fieldId The id of the field, unique to the record but common across records of the same type. Used, for example, for record templates.
   */
  public void setFieldId(String fieldId) {
    this.fieldId = fieldId;
  }

  /**
   * The original value of the field, meant to record exactly what is displayed.
   *
   * @return The original value of the field, meant to record exactly what is displayed.
   */
  public String getOriginal() {
    return original;
  }

  /**
   * The original value of the field, meant to record exactly what is displayed.
   *
   * @param original The original value of the field, meant to record exactly what is displayed.
   */
  public void setOriginal(String original) {
    this.original = original;
  }

  /**
   * The value of the field as interpreted by the user. For example, if the original value were 'MN', the user-interpreted value could be "Minnesota".
   *
   * @return the interpreted The value of the field as interpreted by the user. For example, if the original value were 'MN', the user-interpreted value could be "Minnesota".
   */
  public String getInterpreted() {
    return interpreted;
  }

  /**
   * The value of the field as interpreted by the user. For example, if the original value were 'MN', the user-interpreted value could be "Minnesota".
   * 
   * @param interpreted The value of the field as interpreted by the user. For example, if the original value were 'MN', the user-interpreted value could be "Minnesota".
   */
  public void setInterpreted(String interpreted) {
    this.interpreted = interpreted;
  }

  /**
   * The normalized value of the field as interpreted by an automated process.
   * 
   * @return The normalized value of the field as interpreted by an automated process.
   */
  public String getNormalized() {
    return normalized;
  }

  /**
   * The normalized value of the field as interpreted by an automated process.
   * 
   * @param normalized The normalized value of the field as interpreted by an automated process.
   */
  public void setNormalized(String normalized) {
    this.normalized = normalized;
  }

  /**
   * The attribution metadata for this field.
   *
   * @return The attribution metadata for this field.
   */
  public Attribution getAttribution() {
    return attribution;
  }

  /**
   * The attribution metadata for this field.
   *
   * @param attribution The attribution metadata for this field.
   */
  public void setAttribution(Attribution attribution) {
    this.attribution = attribution;
  }

  /**
   * The extension point for the field.
   *
   * @return The extension point for the field.
   */
  @XmlElement( name = "ext" )
  public Extension getExtension() {
    return extension;
  }

  /**
   * The extension point for the field.
   *
   * @param extension The extension point for the field.
   */
  public void setExtension(Extension extension) {
    this.extension = extension;
  }
}

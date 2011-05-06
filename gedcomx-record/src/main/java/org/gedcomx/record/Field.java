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

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlType;

@XmlType ( propOrder = { "original", "interpreted", "normalized" })
public class Field {

  private String id;
  private String fieldId;
  private String original;
  private String interpreted;
  private String normalized;
  //todo: how do we extend 'field' for the api when we want to support links?

  public Field() {
  }

  @XmlID
  @XmlAttribute
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  @XmlAttribute
  public String getFieldId() {
    return fieldId;
  }

  public void setFieldId(String fieldId) {
    this.fieldId = fieldId;
  }

  /**
   * @return the original
   */
  public String getOriginal() {
    return original;
  }

  /**
   * @param original the original to set
   */
  public void setOriginal(String original) {
    this.original = original;
  }

  /**
   * @return the interpreted
   */
  public String getInterpreted() {
    return interpreted;
  }

  /**
   * @param interpreted the interpreted to set
   */
  public void setInterpreted(String interpreted) {
    this.interpreted = interpreted;
  }

  /**
   * @return the normalized
   */
  public String getNormalized() {
    return normalized;
  }

  /**
   * @param normalized the normalized to set
   */
  public void setNormalized(String normalized) {
    this.normalized = normalized;
  }

}

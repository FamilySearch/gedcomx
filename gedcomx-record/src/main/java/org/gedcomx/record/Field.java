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

import org.gedcomx.common.GenealogicalResource;
import org.gedcomx.common.ResourceReference;
import org.gedcomx.rt.CommonNamespaces;
import org.gedcomx.rt.RDFSubPropertyOf;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

/**
 * A field on a record.
 */
@XmlType ( name = "Field", propOrder = { "original", "interpreted", "processed", "source" } )
public abstract class Field extends GenealogicalResource {

  private String label;
  private String original;
  private String interpreted;
  private String processed;
  private ResourceReference source;

  /**
   * A label for the field. The label can be used to associate fields that were taken from the same section of
   * the source, such as identified by an indexing template.
   *
   * @return The field label.
   */
  @XmlAttribute
  public String getLabel() {
    return label;
  }

  /**
   * A label for the field. The label can be used to associate fields that were taken from the same section of
   * the source, such as identified by an indexing template.
   *
   * @param label The field label.
   */
  public void setLabel(String label) {
    this.label = label;
  }

  /**
   * Text directly extracted from the record field. What you see is what you get, including misspellings and other errors.
   *
   * @return Text directly extracted from the record field. What you see is what you get, including misspellings and other errors.
   */
  public String getOriginal() {
    return original;
  }

  /**
   * Text directly extracted from the record field. What you see is what you get, including misspellings and other errors.
   *
   * @param original Text directly extracted from the record field. What you see is what you get, including misspellings and other errors.
   */
  public void setOriginal(String original) {
    this.original = original;
  }

  /**
   * User interpretation of what the {@link #getOriginal() original} value <i>means</i>, used optionally as needed to enhance the original
   * value by correcting misspellings and other ambiguities. The interpretation is different from a conclusion because it should be made
   * only within the context of the record and not be based on knowledge obtained from other sources.
   *
   * @return User interpretation of what the {@link #getOriginal() original} value <i>means</i>, used optionally as needed to enhance the original
   * value by correcting misspellings and other ambiguities. The interpretation is different from a conclusion because it should be made
   * only within the context of the record and not be based on knowledge obtained from other sources.
   */
  public String getInterpreted() {
    return interpreted;
  }

  /**
   * User interpretation of what the {@link #getOriginal() original} value <i>means</i>, used optionally as needed to enhance the original
   * value by correcting misspellings and other ambiguities. The interpretation is different from a conclusion because it should be made
   * only within the context of the record and not be based on knowledge obtained from other sources.
   * 
   * @param interpreted User interpretation of what the {@link #getOriginal() original} value <i>means</i>, used optionally as needed to enhance the original
   * value by correcting misspellings and other ambiguities. The interpretation is different from a conclusion because it should be made
   * only within the context of the record and not be based on knowledge obtained from other sources.
   */
  public void setInterpreted(String interpreted) {
    this.interpreted = interpreted;
  }

  /**
   * Programmatic interpretation of the value based on an algorithm that considers the original and interpreted values.
   * 
   * @return Programmatic interpretation of the value based on an algorithm that considers the original and interpreted values.
   */
  public String getProcessed() {
    return processed;
  }

  /**
   * Programmatic interpretation of the value based on an algorithm that considers the original and interpreted values.
   * 
   * @param processed Programmatic interpretation of the value based on an algorithm that considers the original and interpreted values.
   */
  public void setProcessed(String processed) {
    this.processed = processed;
  }

  /**
   * The source for the field.
   *
   * @return The source for the field.
   */
  @RDFSubPropertyOf ( CommonNamespaces.DUBLIN_CORE_NAMESPACE + "source")
  public ResourceReference getSource() {
    return source;
  }

  /**
   * The source for the field.
   *
   * @param source The source for the field.
   */
  public void setSource(ResourceReference source) {
    this.source = source;
  }

}

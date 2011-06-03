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
package org.gedcomx.build.enunciate;

/**
 * @author Ryan Heaton
 */
public class ProfileMetadata {

  private String id;
  private String namespace;
  private String xmlMediaType;
  private String jsonMediaType;
  private String version;
  private String label;
  private String description;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getNamespace() {
    return namespace;
  }

  public void setNamespace(String namespace) {
    this.namespace = namespace;
  }

  public String getXmlMediaType() {
    return xmlMediaType;
  }

  public void setXmlMediaType(String xmlMediaType) {
    this.xmlMediaType = xmlMediaType;
  }

  public String getJsonMediaType() {
    return jsonMediaType;
  }

  public void setJsonMediaType(String jsonMediaType) {
    this.jsonMediaType = jsonMediaType;
  }

  public String getVersion() {
    return version;
  }

  public void setVersion(String version) {
    this.version = version;
  }

  public String getLabel() {
    return label;
  }

  public void setLabel(String label) {
    this.label = label;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }
}

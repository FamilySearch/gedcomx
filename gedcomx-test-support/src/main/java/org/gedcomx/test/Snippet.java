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
package org.gedcomx.test;

import org.codehaus.jackson.map.ObjectMapper;
import org.gedcomx.rt.SerializationProcessListener;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

/**
 * A code snippet.
 *
 * @author Mike Gardiner and Ryan Heaton
 */
@XmlType
public class Snippet implements Serializable, SerializationProcessListener {

  private String xml;
  private String json;
  private String description;

  /**
   * The default constructor
   */
  public Snippet() {
  }

  public Snippet(String description) {
    this.description = description;
  }

  public Snippet(String xml, String json) {
    this.xml = xml;
    this.json = json;
  }

  public Snippet(String xml, String json, String description) {
    this.xml = xml;
    this.json = json;
    this.description = description;
  }

  /**
   * The xml code associated with this snippet.
   *
   * @return The xml code associated with this snippet.
   */
  public String getXml() {
    return xml;
  }

  /**
   * The xml code associated with this snippet.
   *
   * @param xml The xml code associated with this snippet.
   */
  public void setXml(String xml) {
    this.xml = xml;
  }

  @Override
  public void xmlProcessed(Object reference, Class<?> instanceClass, JAXBContext context, String xml) {
    setXml(xml);
  }

  /**
   * The json code associated with this snippet.
   *
   * @return The json code associated with this snippet.
   */
  public String getJson() {
    return json;
  }

  /**
   * The json code associated with this snippet.
   *
   * @param json The json code associated with this snippet.
   */
  public void setJson(String json) {
    this.json = json;
  }

  @Override
  public void jsonProcessed(Object reference, Class<?> instanceClass, ObjectMapper mapper, String json) {
    setJson(json);
  }

  /**
   * @return A description
   */
  public String getDescription() {
    return description;
  }

  /**
   * @param description - A description
   */
  public void setDescription(String description) {
    this.description = description;
  }
}

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
package org.gedcomx.conclusion;

import org.codehaus.jackson.annotate.JsonTypeInfo;
import org.codehaus.jackson.map.annotate.JsonTypeIdResolver;
import org.gedcomx.common.Extension;
import org.gedcomx.rt.XmlTypeIdResolver;
import org.gedcomx.types.TypesNamespaces;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlType;

/**
 * The vital information about a conclusion person; a subset of the full person data.
 */
@XmlType (
  propOrder = {"name", "gender", "birth", "death", "extension"}
)
@JsonTypeInfo ( use =JsonTypeInfo.Id.CUSTOM, property = "@type")
@JsonTypeIdResolver (XmlTypeIdResolver.class)
public final class PersonVitals {

  private String id;
  private Name name;
  private Gender gender;
  private Event birth;
  private Event death;
  private Extension extension;

  /**
   * The id of the person, unique to the context and not necessarily globally unique.
   *
   * @return The id of the person, unique to the context and not necessarily globally unique.
   */
  @XmlID
  @XmlAttribute(name = "ID", namespace = TypesNamespaces.RDF_NAMESPACE)
  public String getId() {
    return id;
  }

  /**
   * The id of the person, unique to the context and not necessarily globally unique.
   *
   * @param id The id of the person, unique to the context and not necessarily globally unique.
   */
  public void setId(String id) {
    this.id = id;
  }

  /**
   * The conclusion for the primary name of the person.
   *
   * @return The conclusion for the primary name of the person.
   */
  public Name getName() {
    return name;
  }

  /**
   * The conclusion for the primary name of the person.
   *
   * @param name The conclusion for the primary name of the person.
   */
  public void setName(Name name) {
    this.name = name;
  }

  /**
   * The conclusion for the gender of the person.
   *
   * @return The conclusion for the gender of the person.
   */
  public Gender getGender() {
    return gender;
  }

  /**
   * The conclusion for the gender of the person.
   *
   * @param gender The conclusion for the gender of the person.
   */
  public void setGender(Gender gender) {
    this.gender = gender;
  }

  /**
   * The conclusion for the birth of the person.
   *
   * @return The conclusion for the birth of the person.
   */
  public Event getBirth() {
    return birth;
  }

  /**
   * The conclusion for the birth of the person.
   *
   * @param birth The conclusion for the birth of the person.
   */
  public void setBirth(Event birth) {
    this.birth = birth;
  }

  /**
   * The conclusion for the death of the person.
   *
   * @return The conclusion for the death of the person.
   */
  public Event getDeath() {
    return death;
  }

  /**
   * The conclusion for the death of the person.
   *
   * @param death The conclusion for the death of the person.
   */
  public void setDeath(Event death) {
    this.death = death;
  }

  /**
   * The extension point for the person vitals.
   *
   * @return The extension point for the person vitals.
   */
  public Extension getExtension() {
    return extension;
  }

  /**
   * The extension point for the person vitals.
   *
   * @param extension The extension point for the person vitals.
   */
  public void setExtension(Extension extension) {
    this.extension = extension;
  }
}

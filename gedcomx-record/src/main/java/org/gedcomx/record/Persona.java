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

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlType (
  propOrder = {"alternateIds", "gender", "age", "names", "eventRoles", "characteristics"}
)
public class Persona {

  private String id;
  private List<AlternateId> alternateIds;
  private Gender gender;
  private Age age;
  private List<Name> names = new ArrayList<Name>();
  private List<EventRole> eventRoles = new ArrayList<EventRole>();
  private List<Characteristic> characteristics = new ArrayList<Characteristic>();
  private Boolean principal;

  public Persona() {
  }

  @XmlAttribute
  @XmlID
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  @XmlElement(name="alternateId")
  public List<AlternateId> getAlternateIds() {
    return alternateIds;
  }

  public void setAlternateIds(List<AlternateId> alternateIds) {
    this.alternateIds = alternateIds;
  }

  public Gender getGender() {
    return gender;
  }

  public void setGender(Gender gender) {
    this.gender = gender;
  }

  public Age getAge() {
    return age;
  }

  public void setAge(Age age) {
    this.age = age;
  }

  @XmlElement(name = "name")
  public List<Name> getNames() {
    return names;
  }

  public void addName(Name name) {
    if (names == null) {
      names = new ArrayList<Name>();
    }
    names.add(name);
  }

  public void setNames(List<Name> names) {
    this.names = names;
  }

  @XmlElement(name = "characteristic")
  public List<Characteristic> getCharacteristics() {
    return characteristics;
  }

  public void setCharacteristics(List<Characteristic> characteristics) {
    this.characteristics = characteristics;
  }

  @XmlElement(name = "eventRole")
  public List<EventRole> getEventRoles() {
    return eventRoles;
  }

  public void setEventRoles(List<EventRole> eventRoles) {
    this.eventRoles = eventRoles;
  }

  @XmlAttribute
  public Boolean getPrincipal() {
    return principal;
  }

  public void setPrincipal(Boolean isPrincipal) {
    this.principal = isPrincipal;
  }
}

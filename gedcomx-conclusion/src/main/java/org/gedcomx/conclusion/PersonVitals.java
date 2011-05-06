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

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlType;

@XmlType (
  propOrder = {"name", "gender", "birth", "christening", "death", "burial"}
)
public class PersonVitals {

  private String id;
  private Name name;
  private Gender gender;
  private Event birth;
  private Event christening;
  private Event death;
  private Event burial;

  @XmlID
  @XmlAttribute
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Name getName() {
    return name;
  }

  public void setName(Name name) {
    this.name = name;
  }

  public Gender getGender() {
    return gender;
  }

  public void setGender(Gender gender) {
    this.gender = gender;
  }

  public Event getBirth() {
    return birth;
  }

  public void setBirth(Event birth) {
    this.birth = birth;
  }

  public Event getChristening() {
    return christening;
  }

  public void setChristening(Event christening) {
    this.christening = christening;
  }

  public Event getDeath() {
    return death;
  }

  public void setDeath(Event death) {
    this.death = death;
  }

  public Event getBurial() {
    return burial;
  }

  public void setBurial(Event burial) {
    this.burial = burial;
  }
}

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

/**
 * @author Merlin Carpenter
 *         Date: Jul 30, 2008
 */
public abstract class Relationship {

  private String id;
  protected Persona role1Persona;
  protected Persona role2Persona;
  private List<Characteristic> characteristics = new ArrayList<Characteristic>();

  public Relationship() {
  }

  @XmlAttribute
  @XmlID
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  @XmlTransient
  public Persona getRole1Persona() {
    return role1Persona;
  }

  public void setRole1Persona(Persona role1Persona) {
    this.role1Persona = role1Persona;
  }

  @XmlTransient
  public Persona getRole2Persona() {
    return role2Persona;
  }

  public void setRole2Persona(Persona role2Persona) {
    this.role2Persona = role2Persona;
  }

  @XmlElement(name = "characteristic")
  public List<Characteristic> getCharacteristics() {
    return characteristics;
  }

  public void setCharacteristics(List<Characteristic> characteristics) {
    this.characteristics = characteristics;
  }

}

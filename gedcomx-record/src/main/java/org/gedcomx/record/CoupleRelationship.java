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
import javax.xml.bind.annotation.XmlIDREF;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class CoupleRelationship extends Relationship {

  public CoupleRelationship() {
  }

  @XmlAttribute
  @XmlIDREF
  public Persona getPersona1() {
    return getRole1Persona();
  }

  public void setPersona1(Persona person1) {
    role1Persona = person1;
  }

  @XmlAttribute
  @XmlIDREF
  public Persona getPersona2() {
    return getRole2Persona();
  }

  public void setPersona2(Persona person2) {
    role2Persona = person2;
  }

}

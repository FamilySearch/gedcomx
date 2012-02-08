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

import org.gedcomx.rt.JsonElementWrapper;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

/**
 * @author Ryan Heaton
 */
@XmlRegistry
public class ObjectFactory {

  /**
   * The parent of a person.
   *
   * @param person The parent.
   * @return The element.
   */
  @XmlElementDecl( namespace = ConclusionModel.GEDCOMX_CONCLUSION_V1_NAMESPACE, name = "parent" )
  @JsonElementWrapper( name = "parents" )
  public JAXBElement<Person> createParentElement(Person person) {
    return new JAXBElement<Person>(new QName(ConclusionModel.GEDCOMX_CONCLUSION_V1_NAMESPACE, "parent"), Person.class,  person);
  }

  /**
   * The spouse of a person.
   *
   * @param person The spouse.
   * @return The element.
   */
  @XmlElementDecl( namespace = ConclusionModel.GEDCOMX_CONCLUSION_V1_NAMESPACE, name = "spouse" )
  @JsonElementWrapper( name = "spouses" )
  public JAXBElement<Person> createSpouseElement(Person person) {
    return new JAXBElement<Person>(new QName(ConclusionModel.GEDCOMX_CONCLUSION_V1_NAMESPACE, "spouse"), Person.class,  person);
  }

}

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
   * The father of a person.
   *
   * @param person The father.
   * @return The element.
   */
  @XmlElementDecl( namespace = ConclusionModel.GEDCOMX_CONCLUSION_V1_NAMESPACE, name = "father" )
  @JsonElementWrapper( name = "fathers" )
  public JAXBElement<Person> createFatherElement(Person person) {
    return new JAXBElement<Person>(new QName(ConclusionModel.GEDCOMX_CONCLUSION_V1_NAMESPACE, "father"), Person.class,  person);
  }

  /**
   * The mother of a person.
   *
   * @param person The mother.
   * @return The element.
   */
  @XmlElementDecl( namespace = ConclusionModel.GEDCOMX_CONCLUSION_V1_NAMESPACE, name = "mother" )
  @JsonElementWrapper( name = "mothers" )
  public JAXBElement<Person> createMotherElement(Person person) {
    return new JAXBElement<Person>(new QName(ConclusionModel.GEDCOMX_CONCLUSION_V1_NAMESPACE, "mother"), Person.class,  person);
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

  /**
   * The relationship of a person to the father.
   *
   * @param rel The relationship
   * @return The element.
   */
  @XmlElementDecl( namespace = ConclusionModel.GEDCOMX_CONCLUSION_V1_NAMESPACE, name = "fatherRelationship" )
  @JsonElementWrapper( name = "fatherRelationships" )
  public JAXBElement<Relationship> createFatherRelationshipElement(Relationship rel) {
    return new JAXBElement<Relationship>(new QName(ConclusionModel.GEDCOMX_CONCLUSION_V1_NAMESPACE, "fatherRelationship"), Relationship.class,  rel);
  }

  /**
   * The relationship of a person to the mother.
   *
   * @param rel The relationship
   * @return The element.
   */
  @XmlElementDecl( namespace = ConclusionModel.GEDCOMX_CONCLUSION_V1_NAMESPACE, name = "motherRelationship" )
  @JsonElementWrapper( name = "motherRelationships" )
  public JAXBElement<Relationship> createMotherRelationshipElement(Relationship rel) {
    return new JAXBElement<Relationship>(new QName(ConclusionModel.GEDCOMX_CONCLUSION_V1_NAMESPACE, "motherRelationship"), Relationship.class,  rel);
  }

  /**
   * The relationship of a person to the spouse.
   *
   * @param rel The relationship
   * @return The element.
   */
  @XmlElementDecl( namespace = ConclusionModel.GEDCOMX_CONCLUSION_V1_NAMESPACE, name = "spouseRelationship" )
  @JsonElementWrapper( name = "spouseRelationships" )
  public JAXBElement<Relationship> createSpouseRelationshipElement(Relationship rel) {
    return new JAXBElement<Relationship>(new QName(ConclusionModel.GEDCOMX_CONCLUSION_V1_NAMESPACE, "spouseRelationship"), Relationship.class,  rel);
  }

}

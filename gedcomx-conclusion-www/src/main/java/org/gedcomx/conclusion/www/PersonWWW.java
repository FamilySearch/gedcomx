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
package org.gedcomx.conclusion.www;

import org.codehaus.jackson.annotate.JsonTypeInfo;
import org.codehaus.jackson.map.annotate.JsonTypeIdResolver;
import org.gedcomx.conclusion.Person;
import org.gedcomx.metadata.rdf.RDFDescriptionSet;
import org.gedcomx.rt.XmlTypeIdResolver;
import org.gedcomx.www.Link;

import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;

/**
 * A representation of a person for the WWW.
 * 
 * @author Ryan Heaton
 */
@XmlRootElement(name = "person")
@JsonTypeInfo ( use =JsonTypeInfo.Id.CUSTOM, property = "@type")
@JsonTypeIdResolver (XmlTypeIdResolver.class)
@XmlType ( name = "PersonWWW", propOrder = {"person", "metadata"})
@XmlSeeAlso (Link.class)
public final class PersonWWW {

  private Person person;
  private RDFDescriptionSet metadata;

  /**
   * The person.
   *
   * @return The person.
   */
  @XmlElementRef
  public Person getPerson() {
    return person;
  }

  /**
   * The person.
   *
   * @param person The person.
   */
  public void setPerson(Person person) {
    this.person = person;
  }

  /**
   * Metadata associated with the person.
   *
   * @return Metadata associated with the person.
   */
  public RDFDescriptionSet getMetadata() {
    return metadata;
  }

  /**
   * Metadata associated with the person.
   *
   * @param metadata Metadata associated with the person.
   */
  public void setMetadata(RDFDescriptionSet metadata) {
    this.metadata = metadata;
  }
}

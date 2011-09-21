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
package org.gedcomx.metadata.foaf;

import org.codehaus.jackson.annotate.JsonTypeInfo;
import org.codehaus.jackson.map.annotate.JsonTypeIdResolver;
import org.gedcomx.metadata.rdf.RDFLiteral;
import org.gedcomx.rt.CommonNamespaces;
import org.gedcomx.rt.XmlTypeIdResolver;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * A person as described by FOAF.
 *
 * @see <a href="http://xmlns.com/foaf/spec/#term_Person">foaf:Person</a>
 * @author Ryan Heaton
 */
@XmlType( name = "Person" )
@XmlRootElement ( name = "Person" )
@JsonTypeInfo ( use =JsonTypeInfo.Id.CUSTOM, property = XmlTypeIdResolver.TYPE_PROPERTY_NAME)
@JsonTypeIdResolver (XmlTypeIdResolver.class)
public class Person extends Agent {

  private RDFLiteral familyName;
  private RDFLiteral givenName;
  private RDFLiteral language;

  /**
   * The family name of the person.
   *
   * @return The family name of the person.
   */
  public RDFLiteral getFamilyName() {
    return familyName;
  }

  /**
   * The family name of the person.
   *
   * @param familyName The family name of the person.
   */
  public void setFamilyName(RDFLiteral familyName) {
    this.familyName = familyName;
  }

  /**
   * The given name of the person.
   *
   * @return The given name of the person.
   */
  public RDFLiteral getGivenName() {
    return givenName;
  }

  /**
   * The given name of the person.
   *
   * @param givenName The given name of the person.
   */
  public void setGivenName(RDFLiteral givenName) {
    this.givenName = givenName;
  }

  /**
   * The language of the person.
   *
   * @return The language of the person.
   */
  @XmlElement ( namespace = CommonNamespaces.DUBLIN_CORE_NAMESPACE )
  public RDFLiteral getLanguage() {
    return language;
  }

  /**
   * The language of the person.
   *
   * @param language The language of the person.
   */
  public void setLanguage(RDFLiteral language) {
    this.language = language;
  }

}

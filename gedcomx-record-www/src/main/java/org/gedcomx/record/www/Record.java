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
package org.gedcomx.record.www;

import org.codehaus.jackson.annotate.JsonTypeInfo;
import org.codehaus.jackson.map.annotate.JsonTypeIdResolver;
import org.gedcomx.id.XmlTypeIdResolver;
import org.gedcomx.www.Links;

import javax.xml.XMLConstants;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import java.net.URI;

/**
 * A record that can support WWW links.
 * 
 * @author Ryan Heaton
 */
@XmlRootElement
@JsonTypeInfo ( use =JsonTypeInfo.Id.CUSTOM, property = "@type")
@JsonTypeIdResolver (XmlTypeIdResolver.class)
@XmlSeeAlso ({ Age.class, AgePart.class, Characteristic.class, CoupleRelationship.class, Date.class, DatePart.class,
               Event.class, Gender.class, Name.class, NamePart.class, OtherRelationship.class, ParentChildRelationship.class,
               Persona.class, Place.class, PlacePart.class, RecordField.class})
public class Record extends org.gedcomx.record.Record {

  private URI base;
  private Links links;

  /**
   * The base uri for all relative links within the context of this record.
   *
   * @return The base uri for all relative links within the context of this record.
   */
  @XmlAttribute (namespace = XMLConstants.XML_NS_URI)
  public URI getBase() {
    return base;
  }

  /**
   * The base uri for all relative links within the context of this record.
   *
   * @param base The base uri for all relative links within the context of this record.
   */
  public void setBase(URI base) {
    this.base = base;
  }

  /**
   * The WWW links for this record.
   *
   * @return The WWW links for this record.
   */
  public Links getLinks() {
    return links;
  }

  /**
   * The WWW links for this source.
   *
   * @param links The WWW links for this record.
   */
  public void setLinks(Links links) {
    this.links = links;
  }
}

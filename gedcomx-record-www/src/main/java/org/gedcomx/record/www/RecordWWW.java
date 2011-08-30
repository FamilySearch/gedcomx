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
import org.gedcomx.metadata.rdf.RDFDescriptionSet;
import org.gedcomx.record.Record;
import org.gedcomx.rt.XmlTypeIdResolver;
import org.gedcomx.www.Link;

import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;

/**
 * A representation of a record for the WWW.
 *
 * @author Ryan Heaton
 */
@XmlRootElement( name = "record" )
@JsonTypeInfo ( use =JsonTypeInfo.Id.CUSTOM, property = "@type")
@JsonTypeIdResolver (XmlTypeIdResolver.class)
@XmlType( name = "RecordWWW", propOrder = {"record", "metadata"})
@XmlSeeAlso(Link.class)
public final class RecordWWW {

  private Record record;
  private RDFDescriptionSet metadata;

  /**
   * The record.
   *
   * @return The record.
   */
  @XmlElementRef
  public Record getRecord() {
    return record;
  }

  /**
   * The record.
   *
   * @param record The record.
   */
  public void setRecord(Record record) {
    this.record = record;
  }

  /**
   * Metadata associated with the record.
   *
   * @return Metadata associated with the record.
   */
  public RDFDescriptionSet getMetadata() {
    return metadata;
  }

  /**
   * Metadata associated with the record.
   *
   * @param metadata Metadata associated with the record.
   */
  public void setMetadata(RDFDescriptionSet metadata) {
    this.metadata = metadata;
  }
}

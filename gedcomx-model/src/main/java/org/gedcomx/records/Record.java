/**
 * Copyright 2011-2012 Intellectual Reserve, Inc.
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
package org.gedcomx.records;

import org.codehaus.enunciate.json.JsonName;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;
import org.gedcomx.common.*;
import org.gedcomx.conclusion.Identifier;
import org.gedcomx.links.HypermediaEnabledData;
import org.gedcomx.rt.GedcomxModelVisitor;
import org.gedcomx.rt.json.JsonElementWrapper;
import org.gedcomx.source.SourceReference;
import org.gedcomx.types.IdentifierType;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


/**
 * A "record" describes the set of fields and other conclusions that are directly extracted from a source
 * during field-based indexed record extraction. A record is designed to more closely match the fields and structure
 * of the sources from which the data is being extracted.
 */
@XmlRootElement
@XmlType ( name = "Record", propOrder = { "sources", "identifiers", "principalPerson", "primaryEvent", "fields", "notes", "attribution" } )
@JsonElementWrapper ( name = "records" )
public class Record extends HypermediaEnabledData implements Attributable, HasNotes {

  private ResourceReference principalPerson;
  private ResourceReference primaryEvent;
  private List<SourceReference> sources;
  private List<Identifier> identifiers;
  private List<Field> fields;
  private List<Note> notes;
  private Attribution attribution;
  private URI descriptionRef;

  /**
   * The principal person of this record.
   *
   * @return The principal person of this record.
   */
  public ResourceReference getPrincipalPerson() {
    return principalPerson;
  }

  /**
   * The principal person of this record.
   *
   * @param principalPerson The principal person of this record.
   */
  public void setPrincipalPerson(ResourceReference principalPerson) {
    this.principalPerson = principalPerson;
  }

  /**
   * The primary event of this record.
   *
   * @return The primary event of this record.
   */
  public ResourceReference getPrimaryEvent() {
    return primaryEvent;
  }

  /**
   * The primary event of this record.
   *
   * @param primaryEvent The primary event of this record.
   */
  public void setPrimaryEvent(ResourceReference primaryEvent) {
    this.primaryEvent = primaryEvent;
  }

  /**
   * The source references for a record.
   *
   * @return The source references for a record.
   */
  @XmlElement (name="source")
  @JsonProperty ("sources")
  @JsonName ("sources")
  public List<SourceReference> getSources() {
    return sources;
  }

  /**
   * The source references for a record.
   *
   * @param sourceReferences The source references for a record.
   */
  @JsonProperty("sources")
  public void setSources(List<SourceReference> sourceReferences) {
    this.sources = sourceReferences;
  }

  /**
   * Add a source reference.
   *
   * @param source The source reference to be added.
   */
  public void addSource(SourceReference source) {
    if (source != null) {
      if (sources == null) {
        sources = new ArrayList<SourceReference>();
      }
      sources.add(source);
    }
  }

  /**
   * Find the long-term, persistent identifier for this person from the list of identifiers.
   *
   * @return The long-term, persistent identifier for this person.
   */
  @XmlTransient
  @JsonIgnore
  public URI getPersistentId() {
    URI identifier = null;
    if (this.identifiers != null) {
      for (Identifier id : this.identifiers) {
        if (IdentifierType.Persistent.equals(id.getKnownType())) {
          identifier = id.getValue();
          break;
        }
      }
    }
    return identifier;
  }

  /**
   * A long-term, persistent, globally unique identifier for this person.
   *
   * @param persistentId A long-term, persistent, globally unique identifier for this person.
   */
  @JsonIgnore
  public void setPersistentId(URI persistentId) {
    if (this.identifiers == null) {
      this.identifiers = new ArrayList<Identifier>();
    }

    //clear out any other primary ids.
    Iterator<Identifier> it = this.identifiers.iterator();
    while (it.hasNext()) {
      if (IdentifierType.Persistent.equals(it.next().getKnownType())) {
        it.remove();
      }
    }

    Identifier identifier = new Identifier();
    identifier.setKnownType(IdentifierType.Persistent);
    identifier.setValue(persistentId);
    this.identifiers.add(identifier);
  }

  /**
   * The list of identifiers for the person.
   *
   * @return The list of identifiers for the person.
   */
  @XmlElement (name="identifier")
  @JsonProperty ("identifiers")
  @JsonName ("identifiers")
  public List<Identifier> getIdentifiers() {
    return identifiers;
  }

  /**
   * The list of identifiers of the person.
   *
   * @param identifiers The list of identifiers of the person.
   */
  @JsonProperty ("identifiers")
  public void setIdentifiers(List<Identifier> identifiers) {
    this.identifiers = identifiers;
  }

  /**
   * The fields that were extracted from the source of this record.
   *
   * @return The fields that were extracted from the source of this record.
   */
  @XmlElement (name="field")
  @JsonProperty ("fields")
  @JsonName ("fields")
  public List<Field> getFields() {
    return fields;
  }

  /**
   * The fields that were extracted from the source of this record.
   *
   * @param fields The fields that were extracted from the source of this record.
   */
  @JsonProperty ("fields")
  public void setFields(List<Field> fields) {
    this.fields = fields;
  }

  /**
   * Notes about a source.
   *
   * @return Notes about a source.
   */
  @XmlElement (name="note")
  @JsonProperty ("notes")
  @JsonName ("notes")
  public List<Note> getNotes() {
    return notes;
  }

  /**
   * Notes about a source.
   *
   * @param notes Notes about a source.
   */
  @JsonProperty ("notes")
  public void setNotes(List<Note> notes) {
    this.notes = notes;
  }

  /**
   * The attribution metadata for this source description.
   *
   * @return The attribution metadata for this source description.
   */
  public Attribution getAttribution() {
    return attribution;
  }

  /**
   * The attribution metadata for this source description.
   *
   * @param attribution The attribution metadata for this source description.
   */
  public void setAttribution(Attribution attribution) {
    this.attribution = attribution;
  }

  /**
   * A reference to a description of the record.
   *
   * @return A reference to a description of the record.
   */
  @XmlAttribute ( name = "description" )
  @JsonName ( "description" )
  @JsonProperty ( "description" )
  public URI getDescriptionRef() {
    return descriptionRef;
  }

  /**
   * A reference to a description of the record.
   *
   * @param descriptionRef A reference to a description of the record.
   */
  @JsonProperty ( "description" )
  public void setDescriptionRef(URI descriptionRef) {
    this.descriptionRef = descriptionRef;
  }

  /**
   * Accept a visitor.
   *
   * @param visitor The visitor.
   */
  public void accept(GedcomxModelVisitor visitor) {
    visitor.visitRecord(this);
  }
}

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

import org.codehaus.enunciate.XmlQNameEnumUtil;
import org.codehaus.enunciate.qname.XmlQNameEnumRef;
import org.codehaus.jackson.annotate.JsonTypeInfo;
import org.codehaus.jackson.map.annotate.JsonTypeIdResolver;
import org.gedcomx.attribution.AttributionReference;
import org.gedcomx.id.AlternateId;
import org.gedcomx.id.PersistentIdentifier;
import org.gedcomx.id.XmlTypeIdResolver;
import org.gedcomx.source.SourceReference;
import org.gedcomx.types.RecordType;

import javax.xml.bind.annotation.*;
import javax.xml.namespace.QName;
import java.util.*;

/**
 * A record.
 */
@XmlRootElement
@XmlType (
  propOrder = {"persistentId", "alternateIds", "attribution", "collection", "personas", "events", "coupleRelationships", "parentChildRelationships", "otherRelationships", "fields", "sources"}
)
@JsonTypeInfo ( use =JsonTypeInfo.Id.CUSTOM, property = "@type")
@JsonTypeIdResolver (XmlTypeIdResolver.class)
public class Record {

  private String id;
  private QName type;
  private PersistentIdentifier persistentId;
  private List<AlternateId> alternateIds;
  private AttributionReference attribution;
  private CollectionReference collection;

  //todo: change to List<? extends Persona> when http://jira.codehaus.org/browse/ENUNCIATE-562 is fixed.
  private List<Persona> personas;
  private List<Event> events;
  private List<CoupleRelationship> coupleRelationships;
  private List<ParentChildRelationship> parentChildRelationships;
  private List<OtherRelationship> otherRelationships;
  private List<RecordField> fields;
  private List<SourceReference> sources;

  /**
   * The id of the record, unique to the context and not necessarily globally unique.
   *
   * @return The id of the record, unique to the context and not necessarily globally unique.
   */
  @XmlID
  @XmlAttribute
  public String getId() {
    return id;
  }

  /**
   * The id of the record, unique to the context and not necessarily globally unique.
   *
   * @param id The id of the record, unique to the context and not necessarily globally unique.
   */
  public void setId(String id) {
    this.id = id;
  }

  /**
   * The type of the record.
   * 
   * @return The type of the record.
   */
  @XmlAttribute
  @XmlQNameEnumRef(RecordType.class)
  public QName getType() {
    return type;
  }

  /**
   * The type of the record.
   * 
   * @param type The type of the record.
   */
  public void setType(QName type) {
    this.type = type;
  }

  /**
   * The enum referencing the known type of the record, or {@link org.gedcomx.types.RecordType#other} if not known.
   * 
   * @return The enum referencing the known type of the record, or {@link org.gedcomx.types.RecordType#other} if not known.
   */
  @XmlTransient
  public RecordType getKnownType() {
    return XmlQNameEnumUtil.fromQName(getType(), RecordType.class);
  }

  /**
   * The enum referencing the known type of the record, or {@link org.gedcomx.types.RecordType#other} if not known.
   * 
   * @param knownType The enum referencing the known type of the record, or {@link org.gedcomx.types.RecordType#other} if not known.
   */
  public void setKnownType(RecordType knownType) {
    this.type = XmlQNameEnumUtil.toQName(knownType);
  }


  /**
   * A long-term, persistent, globally unique identifier for this record.
   *
   * @return A long-term, persistent, globally unique identifier for this record.
   */
  public PersistentIdentifier getPersistentId() {
    return persistentId;
  }

  /**
   * A long-term, persistent, globally unique identifier for this record.
   *
   * @param persistentId A long-term, persistent, globally unique identifier for this record.
   */
  public void setPersistentId(PersistentIdentifier persistentId) {
    this.persistentId = persistentId;
  }

  /**
   * The list of alternate ids of the record.
   *
   * @return The list of alternate ids of the record.
   */
  @XmlElement (name="alternateId")
  public List<AlternateId> getAlternateIds() {
    return alternateIds;
  }

  /**
   * The list of alternate ids of the record.
   *
   * @param alternateIds The list of alternate ids of the record.
   */
  public void setAlternateIds(List<AlternateId> alternateIds) {
    this.alternateIds = alternateIds;
  }

  /**
   * The link to the attribution metadata for this record.
   *
   * @return The link to the attribution metadata for this record.
   */
  public AttributionReference getAttribution() {
    return attribution;
  }

  /**
   * The link to the attribution metadata for this record.
   *
   * @param attribution The link to the attribution metadata for this record.
   */
  public void setAttribution(AttributionReference attribution) {
    this.attribution = attribution;
  }

  /**
   * The reference to the collection containing this record.
   *
   * @return The reference to the collection containing this record.
   */
  public CollectionReference getCollection() {
    return collection;
  }

  /**
   * The reference to the collection containing this record.
   *
   * @param collection The reference to the collection containing this record.
   */
  public void setCollection(CollectionReference collection) {
    this.collection = collection;
  }

  /**
   * The personas of this record.
   *
   * @return The personas of this record.
   */
  @XmlElement(name = "persona")
  public List<Persona> getPersonas() {
    return personas;
  }

  /**
   * The personas of this record.
   *
   * @param personas The personas of this record.
   */
  public void setPersonas(List<Persona> personas) {
    this.personas = personas;
  }

  /**
   * The events of the record.
   *
   * @return The events of the record.
   */
  @XmlElement(name = "event")
  public List<Event> getEvents() {
    return events;
  }

  /**
   * The events of the record.
   *
   * @param events The events of the record.
   */
  public void setEvents(List<Event> events) {
    this.events = events;
  }

  /**
   * The couple relationships on this record.
   *
   * @return The couple relationships on this record.
   */
  @XmlElement(name = "coupleRelationship")
  public List<CoupleRelationship> getCoupleRelationships() {
    return coupleRelationships;
  }

  /**
   * The couple relationships on this record.
   *
   * @param coupleRelationships The couple relationships on this record.
   */
  public void setCoupleRelationships(List<CoupleRelationship> coupleRelationships) {
    this.coupleRelationships = coupleRelationships;
  }

  /**
   * The parent-child relationships on this record.
   *
   * @return The parent-child relationships on this record.
   */
  @XmlElement(name = "parentChildRelationship")
  public List<ParentChildRelationship> getParentChildRelationships() {
    return parentChildRelationships;
  }

  /**
   * The parent-child relationships on this record.
   *
   * @param parentChildRelationships The parent-child relationships on this record.
   */
  public void setParentChildRelationships(List<ParentChildRelationship> parentChildRelationships) {
    this.parentChildRelationships = parentChildRelationships;
  }

  /**
   * The "other" (i.e. not couple, parent-child) relationships on this record.
   *
   * @return The "other" (i.e. not couple, parent-child) relationships on this record.
   */
  @XmlElement(name = "otherRelationship")
  public List<OtherRelationship> getOtherRelationships() {
    return otherRelationships;
  }

  /**
   * The "other" (i.e. not couple, parent-child) relationships on this record.
   *
   * @param otherRelationships The "other" (i.e. not couple, parent-child) relationships on this record.
   */
  public void setOtherRelationships(List<OtherRelationship> otherRelationships) {
    this.otherRelationships = otherRelationships;
  }

  /**
   * The relationships of the record.
   *
   * @return The relationships of the record.
   */
  @XmlTransient
  public java.util.Collection<Relationship> getRelationships() {
    ArrayList<Relationship> relationships = new ArrayList<Relationship>();
    if (this.coupleRelationships != null) {
      relationships.addAll(this.coupleRelationships);
    }
    if (this.parentChildRelationships != null) {
      relationships.addAll(this.parentChildRelationships);
    }
    if (this.otherRelationships != null) {
      relationships.addAll(this.otherRelationships);
    }
    return relationships;
  }

  /**
   * The relationships of the record. Convenience method for setting the collection of couple, parent-child, and other relationships.
   *
   * @param relationships The relationships of the record.
   */
  public void setRelationships(java.util.Collection<Relationship> relationships) {
    ArrayList<CoupleRelationship> coupleRelationships = new ArrayList<CoupleRelationship>();
    ArrayList<ParentChildRelationship> parentChildRelationships = new ArrayList<ParentChildRelationship>();
    ArrayList<OtherRelationship> otherRelationships = new ArrayList<OtherRelationship>();

    if (relationships != null) {
      for (Relationship relationship : relationships) {
        if (relationship instanceof CoupleRelationship) {
          coupleRelationships.add((CoupleRelationship) relationship);
        }
        else if (relationship instanceof ParentChildRelationship) {
          parentChildRelationships.add((ParentChildRelationship) relationship);
        }
        else if (relationship instanceof OtherRelationship) {
          otherRelationships.add((OtherRelationship) relationship);
        }
        else {
          throw new IllegalArgumentException("Unknown relationship type: " + relationship.getClass().getName());
        }
      }
    }

    this.coupleRelationships = coupleRelationships.isEmpty() ? null : coupleRelationships;
    this.parentChildRelationships = parentChildRelationships.isEmpty() ? null : parentChildRelationships;
    this.otherRelationships = otherRelationships.isEmpty() ? null : otherRelationships;
  }

  /**
   * Any generic fields that are on the record (not belonging to a persona or relationship).
   *
   * @return Any generic fields that are on the record (not belonging to a persona or relationship).
   */
  @XmlElement(name = "field")
  public List<RecordField> getFields() {
    return fields;
  }

  /**
   * Any generic fields that are on the record (not belonging to a persona or relationship).
   *
   * @param fields Any generic fields that are on the record (not belonging to a persona or relationship).
   */
  public void setFields(List<RecordField> fields) {
    this.fields = fields;
  }

  /**
   * The references to the sources of the record.
   *
   * @return The references to the sources of the record.
   */
  @XmlElement(name = "source")
  public List<SourceReference> getSources() {
    return sources;
  }

  /**
   * The references to the sources of the record.
   *
   * @param sources The references to the sources of the record.
   */
  public void setSources(List<SourceReference> sources) {
    this.sources = sources;
  }
}

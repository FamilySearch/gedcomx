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
package org.gedcomx.metadata.dc;

import org.gedcomx.metadata.rdf.RDFMetadata;

import java.util.List;

/**
 * The model for the <a href="http://dublincore.org/documents/dcmi-terms/">Dublin Core metadata set</a>. Fits into the
 * RDF model <a href="http://dublincore.org/documents/dcq-rdf-xml/">according to the Dublin Core documentation</a>. Note that
 * this model is a stricter subset of the loose model defined by the spec. The tightening is intended to improve consumability.
 *
 *
 * @author Ryan Heaton
 */
public class DublinCoreMetadata extends RDFMetadata {

  private List<DublinCoreStringProperty> abstrct;
  private List<DublinCoreStringProperty> accessRights;
  private List<DublinCoreStringProperty> accrualMethod;
  private List<DublinCoreStringProperty> accrualPeriodicity;
  private List<DublinCoreStringProperty> accrualPolicy;
  private List<DublinCoreStringProperty> alternative;
  private List<DublinCoreStringProperty> audience;
  private List<DublinCoreDateProperty> available;
  private List<DublinCoreStringProperty> bibliographicCitation;
  private List<DublinCoreStringProperty> conformsTo;
  private List<DublinCoreStringProperty> contributor;
  private List<DublinCoreStringProperty> coverage;
  private List<DublinCoreDateProperty> created;
  private List<DublinCoreStringProperty> creator;
  private List<DublinCoreDateProperty> date;
  private List<DublinCoreDateProperty> dateAccepted;
  private List<DublinCoreDateProperty> dateCopyrighted;
  private List<DublinCoreDateProperty> dateSubmitted;
  private List<DublinCoreStringProperty> description;
  private List<DublinCoreStringProperty> educationLevel;
  private List<DublinCoreStringProperty> extent;
  private List<DublinCoreStringProperty> format;
  private List<DublinCoreStringProperty> hasFormat;
  private List<DublinCoreStringProperty> hasPart;
  private List<DublinCoreStringProperty> hasVersion;
  private List<DublinCoreStringProperty> identifier;
  private List<DublinCoreStringProperty> instructionalMethod;
  private List<DublinCoreStringProperty> isFormatOf;
  private List<DublinCoreStringProperty> isPartOf;
  private List<DublinCoreStringProperty> isReferencedBy;
  private List<DublinCoreStringProperty> isReplacedBy;
  private List<DublinCoreStringProperty> isRequiredBy;
  private List<DublinCoreDateProperty> issued;
  private List<DublinCoreStringProperty> isVersionOf;
  private List<DublinCoreStringProperty> language;
  private List<DublinCoreStringProperty> license;
  private List<DublinCoreStringProperty> mediator;
  private List<DublinCoreStringProperty> medium;
  private List<DublinCoreDateProperty> modified;
  private List<DublinCoreStringProperty> provenance;
  private List<DublinCoreStringProperty> publisher;
  private List<DublinCoreStringProperty> references;
  private List<DublinCoreStringProperty> relation;
  private List<DublinCoreStringProperty> replaces;
  private List<DublinCoreStringProperty> requires;
  private List<DublinCoreStringProperty> rights;
  private List<DublinCoreStringProperty> rightsHolder;
  private List<DublinCoreStringProperty> source;
  private List<DublinCoreStringProperty> spatial;
  private List<DublinCoreStringProperty> subject;
  private List<DublinCoreStringProperty> tableOfContents;
  private List<DublinCoreStringProperty> temporal;
  private List<DublinCoreStringProperty> title;
  private List<DublinCoreTypeProperty> type;
  private List<DublinCoreDateProperty> valid;

  /**
   * A summary of the resource.
   *
   * @return A summary of the resource.
   * @link http://dublincore.org/documents/dcmi-terms/#terms-abstract
   */
  public List<DublinCoreStringProperty> getAbstract() {
    return abstrct;
  }

  /**
   * A summary of the resource.
   *
   * @param abstrct A summary of the resource.
   * @link http://dublincore.org/documents/dcmi-terms/#terms-abstract
   */
  public void setAbstract(List<DublinCoreStringProperty> abstrct) {
    this.abstrct = abstrct;
  }

  /**
   * Information about who can access the resource or an indication of its security status. Access Rights may include information
   * regarding access or restrictions based on privacy, security, or other policies.
   *
   * @return Information about who can access the resource or an indication of its security status. Access Rights may include information
   * regarding access or restrictions based on privacy, security, or other policies.
   * 
   * @link http://dublincore.org/documents/dcmi-terms/#terms-accessRights
   */
  public List<DublinCoreStringProperty> getAccessRights() {
    return accessRights;
  }

  /**
   * Information about who can access the resource or an indication of its security status. Access Rights may include information
   * regarding access or restrictions based on privacy, security, or other policies.
   *
   * @param accessRights Information about who can access the resource or an indication of its security status. Access Rights may include information
   * regarding access or restrictions based on privacy, security, or other policies.
   *
   * @link http://dublincore.org/documents/dcmi-terms/#terms-accessRights
   */
  public void setAccessRights(List<DublinCoreStringProperty> accessRights) {
    this.accessRights = accessRights;
  }

  /**
   * The method by which items are added to a collection.
   *
   * @return The method by which items are added to a collection.
   * @link http://dublincore.org/documents/dcmi-terms/#terms-accrualMethod
   */
  public List<DublinCoreStringProperty> getAccrualMethod() {
    return accrualMethod;
  }

  /**
   * The method by which items are added to a collection.
   *
   * @param accrualMethod The method by which items are added to a collection.
   * @link http://dublincore.org/documents/dcmi-terms/#terms-accrualMethod
   */
  public void setAccrualMethod(List<DublinCoreStringProperty> accrualMethod) {
    this.accrualMethod = accrualMethod;
  }

  /**
   * The frequency with which items are added to a collection.
   *
   * @return The frequency with which items are added to a collection.
   * @link http://dublincore.org/documents/dcmi-terms/#terms-accrualPeriodicity
   */
  public List<DublinCoreStringProperty> getAccrualPeriodicity() {
    return accrualPeriodicity;
  }

  /**
   * The frequency with which items are added to a collection.
   *
   * @param accrualPeriodicity The frequency with which items are added to a collection.
   * @link http://dublincore.org/documents/dcmi-terms/#terms-accrualPeriodicity
   */
  public void setAccrualPeriodicity(List<DublinCoreStringProperty> accrualPeriodicity) {
    this.accrualPeriodicity = accrualPeriodicity;
  }

  /**
   * The policy governing the addition of items to a collection.
   *
   * @return The policy governing the addition of items to a collection.
   * @link http://dublincore.org/documents/dcmi-terms/#terms-accrualPolicy
   */
  public List<DublinCoreStringProperty> getAccrualPolicy() {
    return accrualPolicy;
  }

  /**
   * The policy governing the addition of items to a collection.
   *
   * @param accrualPolicy The policy governing the addition of items to a collection.
   * @link http://dublincore.org/documents/dcmi-terms/#terms-accrualPolicy
   */
  public void setAccrualPolicy(List<DublinCoreStringProperty> accrualPolicy) {
    this.accrualPolicy = accrualPolicy;
  }

  /**
   * An alternative name for the resource. The distinction between titles and alternative titles is application-specific.
   *
   * @return An alternative name for the resource. The distinction between titles and alternative titles is application-specific.
   * @link http://dublincore.org/documents/dcmi-terms/#terms-alternative
   */
  public List<DublinCoreStringProperty> getAlternative() {
    return alternative;
  }

  /**
   * An alternative name for the resource. The distinction between titles and alternative titles is application-specific.
   *
   * @param alternative An alternative name for the resource. The distinction between titles and alternative titles is application-specific.
   * @link http://dublincore.org/documents/dcmi-terms/#terms-alternative
   */
  public void setAlternative(List<DublinCoreStringProperty> alternative) {
    this.alternative = alternative;
  }

  /**
   * A class of entity for whom the resource is intended or useful.
   *
   * @return A class of entity for whom the resource is intended or useful.
   * @link http://dublincore.org/documents/dcmi-terms/#terms-audience
   */
  public List<DublinCoreStringProperty> getAudience() {
    return audience;
  }

  /**
   * A class of entity for whom the resource is intended or useful.
   *
   * @param audience A class of entity for whom the resource is intended or useful.
   * @link http://dublincore.org/documents/dcmi-terms/#terms-audience
   */
  public void setAudience(List<DublinCoreStringProperty> audience) {
    this.audience = audience;
  }

  /**
   * Date that the resource became or will become available.
   *
   * @return Date that the resource became or will become available.
   * @link http://dublincore.org/documents/dcmi-terms/#terms-available
   */
  public List<DublinCoreDateProperty> getAvailable() {
    return available;
  }

  /**
   * Date that the resource became or will become available.
   *
   * @param available Date that the resource became or will become available.
   * @link http://dublincore.org/documents/dcmi-terms/#terms-available
   */
  public void setAvailable(List<DublinCoreDateProperty> available) {
    this.available = available;
  }

  /**
   * A bibliographic reference for the resource. Recommended practice is to include sufficient
   * bibliographic detail to identify the resource as unambiguously as possible.
   *
   * @return A bibliographic reference for the resource. Recommended practice is to include sufficient
   * bibliographic detail to identify the resource as unambiguously as possible.
   * @link http://dublincore.org/documents/dcmi-terms/#terms-bibliographicCitation
   */
  public List<DublinCoreStringProperty> getBibliographicCitation() {
    return bibliographicCitation;
  }

  /**
   * A bibliographic reference for the resource. Recommended practice is to include sufficient
   * bibliographic detail to identify the resource as unambiguously as possible.
   *
   * @param bibliographicCitation A bibliographic reference for the resource. Recommended practice is to include sufficient
   * bibliographic detail to identify the resource as unambiguously as possible.
   * @link http://dublincore.org/documents/dcmi-terms/#terms-bibliographicCitation
   */
  public void setBibliographicCitation(List<DublinCoreStringProperty> bibliographicCitation) {
    this.bibliographicCitation = bibliographicCitation;
  }

  /**
   * An established standard to which the described resource conforms.
   *
   * @return An established standard to which the described resource conforms.
   * @link http://dublincore.org/documents/dcmi-terms/#terms-conformsTo
   */
  public List<DublinCoreStringProperty> getConformsTo() {
    return conformsTo;
  }

  /**
   * An established standard to which the described resource conforms.
   *
   * @param conformsTo An established standard to which the described resource conforms.
   * @link http://dublincore.org/documents/dcmi-terms/#terms-conformsTo
   */
  public void setConformsTo(List<DublinCoreStringProperty> conformsTo) {
    this.conformsTo = conformsTo;
  }

  /**
   * An entity responsible for making contributions to the resource. Examples of a Contributor include a person, an organization, or a service.
   *
   * @return An entity responsible for making contributions to the resource. Examples of a Contributor include a person, an organization, or a service.
   * @link http://dublincore.org/documents/dcmi-terms/#terms-contributor
   */
  public List<DublinCoreStringProperty> getContributor() {
    return contributor;
  }

  /**
   * An entity responsible for making contributions to the resource. Examples of a Contributor include a person, an organization, or a service.
   *
   * @param contributor An entity responsible for making contributions to the resource. Examples of a Contributor include a person, an organization, or a service.
   * @link http://dublincore.org/documents/dcmi-terms/#terms-contributor
   */
  public void setContributor(List<DublinCoreStringProperty> contributor) {
    this.contributor = contributor;
  }

  /**
   * The spatial or temporal topic of the resource, the spatial applicability of the resource, or the jurisdiction under which the resource is relevant.
   *
   * @return The spatial or temporal topic of the resource, the spatial applicability of the resource, or the jurisdiction under which the resource is relevant.
   * @link http://dublincore.org/documents/dcmi-terms/#terms-coverage
   */
  public List<DublinCoreStringProperty> getCoverage() {
    return coverage;
  }

  /**
   * The spatial or temporal topic of the resource, the spatial applicability of the resource, or the jurisdiction under which the resource is relevant.
   *
   * @param coverage The spatial or temporal topic of the resource, the spatial applicability of the resource, or the jurisdiction under which the resource is relevant.
   * @link http://dublincore.org/documents/dcmi-terms/#terms-coverage
   */
  public void setCoverage(List<DublinCoreStringProperty> coverage) {
    this.coverage = coverage;
  }

  /**
   * Date of creation of the resource.
   *
   * @return Date of creation of the resource.
   * @link http://dublincore.org/documents/dcmi-terms/#terms-created
   */
  public List<DublinCoreDateProperty> getCreated() {
    return created;
  }

  /**
   * Date of creation of the resource.
   *
   * @param created Date of creation of the resource.
   * @link http://dublincore.org/documents/dcmi-terms/#terms-created
   */
  public void setCreated(List<DublinCoreDateProperty> created) {
    this.created = created;
  }

  /**
   * An entity primarily responsible for making the resource.
   *
   * @return An entity primarily responsible for making the resource.
   * @link http://dublincore.org/documents/dcmi-terms/#terms-creator
   */
  public List<DublinCoreStringProperty> getCreator() {
    return creator;
  }

  /**
   * An entity primarily responsible for making the resource.
   *
   * @param creator An entity primarily responsible for making the resource.
   * @link http://dublincore.org/documents/dcmi-terms/#terms-creator
   */
  public void setCreator(List<DublinCoreStringProperty> creator) {
    this.creator = creator;
  }

  /**
   * A point or period of time associated with an event in the lifecycle of the resource.
   *
   * @return A point or period of time associated with an event in the lifecycle of the resource.
   * @link http://dublincore.org/documents/dcmi-terms/#terms-date
   */
  public List<DublinCoreDateProperty> getDate() {
    return date;
  }

  /**
   * A point or period of time associated with an event in the lifecycle of the resource.
   *
   * @param date A point or period of time associated with an event in the lifecycle of the resource.
   * @link http://dublincore.org/documents/dcmi-terms/#terms-date
   */
  public void setDate(List<DublinCoreDateProperty> date) {
    this.date = date;
  }

  /**
   * Date of acceptance of the resource.
   *
   * @return Date of acceptance of the resource.
   * @link http://dublincore.org/documents/dcmi-terms/#terms-dateAccepted
   */
  public List<DublinCoreDateProperty> getDateAccepted() {
    return dateAccepted;
  }

  /**
   * Date of acceptance of the resource.
   *
   * @param dateAccepted Date of acceptance of the resource.
   * @link http://dublincore.org/documents/dcmi-terms/#terms-dateAccepted
   */
  public void setDateAccepted(List<DublinCoreDateProperty> dateAccepted) {
    this.dateAccepted = dateAccepted;
  }

  /**
   * Date of copyright.
   *
   * @return Date of copyright.
   * @link http://dublincore.org/documents/dcmi-terms/#terms-dateCopyrighted
   */
  public List<DublinCoreDateProperty> getDateCopyrighted() {
    return dateCopyrighted;
  }

  /**
   * Date of copyright.
   *
   * @param dateCopyrighted Date of copyright.
   * @link http://dublincore.org/documents/dcmi-terms/#terms-dateCopyrighted
   */
  public void setDateCopyrighted(List<DublinCoreDateProperty> dateCopyrighted) {
    this.dateCopyrighted = dateCopyrighted;
  }

  /**
   * Date of submission of the resource.
   *
   * @return Date of submission of the resource.
   * @link http://dublincore.org/documents/dcmi-terms/#terms-dateSubmitted
   */
  public List<DublinCoreDateProperty> getDateSubmitted() {
    return dateSubmitted;
  }

  /**
   * Date of submission of the resource.
   *
   * @param dateSubmitted Date of submission of the resource.
   * @link http://dublincore.org/documents/dcmi-terms/#terms-dateSubmitted
   */
  public void setDateSubmitted(List<DublinCoreDateProperty> dateSubmitted) {
    this.dateSubmitted = dateSubmitted;
  }

  /**
   * An account of the resource.
   *
   * @return An account of the resource.
   * @link http://dublincore.org/documents/dcmi-terms/#terms-description
   */
  public List<DublinCoreStringProperty> getDescription() {
    return description;
  }

  /**
   * An account of the resource.
   *
   * @param description An account of the resource.
   * @link http://dublincore.org/documents/dcmi-terms/#terms-description
   */
  public void setDescription(List<DublinCoreStringProperty> description) {
    this.description = description;
  }

  /**
   * A class of entity, defined in terms of progression through an educational or training context, for which the described resource is intended.
   *
   * @return A class of entity, defined in terms of progression through an educational or training context, for which the described resource is intended.
   * @link http://dublincore.org/documents/dcmi-terms/#terms-educationLevel
   */
  public List<DublinCoreStringProperty> getEducationLevel() {
    return educationLevel;
  }

  /**
   * A class of entity, defined in terms of progression through an educational or training context, for which the described resource is intended.
   *
   * @param educationLevel A class of entity, defined in terms of progression through an educational or training context, for which the described resource is intended.
   * @link http://dublincore.org/documents/dcmi-terms/#terms-educationLevel
   */
  public void setEducationLevel(List<DublinCoreStringProperty> educationLevel) {
    this.educationLevel = educationLevel;
  }

  /**
   * The size or duration of the resource.
   *
   * @return The size or duration of the resource.
   * @link http://dublincore.org/documents/dcmi-terms/#terms-extent
   */
  public List<DublinCoreStringProperty> getExtent() {
    return extent;
  }

  /**
   * The size or duration of the resource.
   *
   * @param extent The size or duration of the resource.
   * @link http://dublincore.org/documents/dcmi-terms/#terms-extent
   */
  public void setExtent(List<DublinCoreStringProperty> extent) {
    this.extent = extent;
  }

  /**
   * The file format, physical medium, or dimensions of the resource. Examples of dimensions include size and duration. Recommended best practice is
   * to use a controlled vocabulary such as the list of Internet Media Types [MIME].
   *
   * @return The file format, physical medium, or dimensions of the resource. Examples of dimensions include size and duration. Recommended best practice is to
   * use a controlled vocabulary such as the list of Internet Media Types [MIME].
   *
   * @link http://dublincore.org/documents/dcmi-terms/#terms-format
   */
  public List<DublinCoreStringProperty> getFormat() {
    return format;
  }

  /**
   * The file format, physical medium, or dimensions of the resource. Examples of dimensions include size and duration. Recommended best practice is
   * to use a controlled vocabulary such as the list of Internet Media Types [MIME].
   *
   * @param format The file format, physical medium, or dimensions of the resource. Examples of dimensions include size and duration. Recommended best practice is to
   * use a controlled vocabulary such as the list of Internet Media Types [MIME].
   *
   * @link http://dublincore.org/documents/dcmi-terms/#terms-format
   */
  public void setFormat(List<DublinCoreStringProperty> format) {
    this.format = format;
  }

  /**
   * A related resource that is substantially the same as the pre-existing described resource, but in another format.
   *
   * @return A related resource that is substantially the same as the pre-existing described resource, but in another format.
   * @link http://dublincore.org/documents/dcmi-terms/#terms-hasFormat
   */
  public List<DublinCoreStringProperty> getHasFormat() {
    return hasFormat;
  }

  /**
   * A related resource that is substantially the same as the pre-existing described resource, but in another format.
   *
   * @param hasFormat A related resource that is substantially the same as the pre-existing described resource, but in another format.
   * @link http://dublincore.org/documents/dcmi-terms/#terms-hasFormat
   */
  public void setHasFormat(List<DublinCoreStringProperty> hasFormat) {
    this.hasFormat = hasFormat;
  }

  /**
   * A related resource that is included either physically or logically in the described resource.
   *
   * @return A related resource that is included either physically or logically in the described resource.
   * @link http://dublincore.org/documents/dcmi-terms/#terms-hasPart
   */
  public List<DublinCoreStringProperty> getHasPart() {
    return hasPart;
  }

  /**
   * A related resource that is included either physically or logically in the described resource.
   *
   * @param hasPart A related resource that is included either physically or logically in the described resource.
   * @link http://dublincore.org/documents/dcmi-terms/#terms-hasPart
   */
  public void setHasPart(List<DublinCoreStringProperty> hasPart) {
    this.hasPart = hasPart;
  }

  /**
   * A related resource that is a version, edition, or adaptation of the described resource.
   *
   * @return A related resource that is a version, edition, or adaptation of the described resource.
   * @link http://dublincore.org/documents/dcmi-terms/#terms-hasVersion
   */
  public List<DublinCoreStringProperty> getHasVersion() {
    return hasVersion;
  }

  /**
   * A related resource that is a version, edition, or adaptation of the described resource.
   *
   * @param hasVersion A related resource that is a version, edition, or adaptation of the described resource.
   * @link http://dublincore.org/documents/dcmi-terms/#terms-hasVersion
   */
  public void setHasVersion(List<DublinCoreStringProperty> hasVersion) {
    this.hasVersion = hasVersion;
  }

  /**
   * An unambiguous reference to the resource within a given context.
   *
   * @return An unambiguous reference to the resource within a given context.
   * @link http://dublincore.org/documents/dcmi-terms/#terms-identifier
   */
  public List<DublinCoreStringProperty> getIdentifier() {
    return identifier;
  }

  /**
   * An unambiguous reference to the resource within a given context.
   *
   * @param identifier An unambiguous reference to the resource within a given context.
   * @link http://dublincore.org/documents/dcmi-terms/#terms-identifier
   */
  public void setIdentifier(List<DublinCoreStringProperty> identifier) {
    this.identifier = identifier;
  }

  /**
   * A process, used to engender knowledge, attitudes and skills, that the described resource is designed to support.
   * 
   * @return A process, used to engender knowledge, attitudes and skills, that the described resource is designed to support.
   * @link http://dublincore.org/documents/dcmi-terms/#terms-instructionalMethod
   */
  public List<DublinCoreStringProperty> getInstructionalMethod() {
    return instructionalMethod;
  }

  /**
   * A process, used to engender knowledge, attitudes and skills, that the described resource is designed to support.
   *
   * @param instructionalMethod A process, used to engender knowledge, attitudes and skills, that the described resource is designed to support.
   * @link http://dublincore.org/documents/dcmi-terms/#terms-instructionalMethod
   */
  public void setInstructionalMethod(List<DublinCoreStringProperty> instructionalMethod) {
    this.instructionalMethod = instructionalMethod;
  }

  /**
   * A related resource that is substantially the same as the described resource, but in another format.
   *
   * @return A related resource that is substantially the same as the described resource, but in another format.
   * @link http://dublincore.org/documents/dcmi-terms/#terms-isFormatOf
   */
  public List<DublinCoreStringProperty> getFormatOf() {
    return isFormatOf;
  }

  /**
   * A related resource that is substantially the same as the described resource, but in another format.
   *
   * @param formatOf A related resource that is substantially the same as the described resource, but in another format.
   * @link http://dublincore.org/documents/dcmi-terms/#terms-isFormatOf
   */
  public void setFormatOf(List<DublinCoreStringProperty> formatOf) {
    isFormatOf = formatOf;
  }

  /**
   * A related resource in which the described resource is physically or logically included.
   *
   * @return A related resource in which the described resource is physically or logically included.
   * @link http://dublincore.org/documents/dcmi-terms/#terms-isPartOf
   */
  public List<DublinCoreStringProperty> getPartOf() {
    return isPartOf;
  }

  /**
   * A related resource in which the described resource is physically or logically included.
   *
   * @param partOf A related resource in which the described resource is physically or logically included.
   * @link http://dublincore.org/documents/dcmi-terms/#terms-isPartOf
   */
  public void setPartOf(List<DublinCoreStringProperty> partOf) {
    isPartOf = partOf;
  }

  /**
   * A related resource that references, cites, or otherwise points to the described resource.
   *
   * @return A related resource that references, cites, or otherwise points to the described resource.
   * @link http://dublincore.org/documents/dcmi-terms/#terms-isReferencedBy
   */
  public List<DublinCoreStringProperty> getReferencedBy() {
    return isReferencedBy;
  }

  /**
   * A related resource that references, cites, or otherwise points to the described resource.
   *
   * @param referencedBy A related resource that references, cites, or otherwise points to the described resource.
   * @link http://dublincore.org/documents/dcmi-terms/#terms-isReferencedBy
   */
  public void setReferencedBy(List<DublinCoreStringProperty> referencedBy) {
    isReferencedBy = referencedBy;
  }

  /**
   * A related resource that supplants, displaces, or supersedes the described resource.
   *
   * @return A related resource that supplants, displaces, or supersedes the described resource.
   * @link http://dublincore.org/documents/dcmi-terms/#terms-isReplacedBy
   */
  public List<DublinCoreStringProperty> getReplacedBy() {
    return isReplacedBy;
  }

  /**
   * A related resource that supplants, displaces, or supersedes the described resource.
   *
   * @param replacedBy A related resource that supplants, displaces, or supersedes the described resource.
   * @link http://dublincore.org/documents/dcmi-terms/#terms-isReplacedBy
   */
  public void setReplacedBy(List<DublinCoreStringProperty> replacedBy) {
    isReplacedBy = replacedBy;
  }

  /**
   * A related resource that requires the described resource to support its function, delivery, or coherence.
   *
   * @return A related resource that requires the described resource to support its function, delivery, or coherence.
   * @link http://dublincore.org/documents/dcmi-terms/#terms-isRequiredBy
   */
  public List<DublinCoreStringProperty> getRequiredBy() {
    return isRequiredBy;
  }

  /**
   * A related resource that requires the described resource to support its function, delivery, or coherence.
   *
   * @param requiredBy A related resource that requires the described resource to support its function, delivery, or coherence.
   * @link http://dublincore.org/documents/dcmi-terms/#terms-isRequiredBy
   */
  public void setRequiredBy(List<DublinCoreStringProperty> requiredBy) {
    isRequiredBy = requiredBy;
  }

  /**
   * Date of formal issuance (e.g., publication) of the resource.
   *
   * @return Date of formal issuance (e.g., publication) of the resource.
   * @link http://dublincore.org/documents/dcmi-terms/#terms-issued
   */
  public List<DublinCoreDateProperty> getIssued() {
    return issued;
  }

  /**
   * Date of formal issuance (e.g., publication) of the resource.
   *
   * @param issued Date of formal issuance (e.g., publication) of the resource.
   * @link http://dublincore.org/documents/dcmi-terms/#terms-issued
   */
  public void setIssued(List<DublinCoreDateProperty> issued) {
    this.issued = issued;
  }

  /**
   * A related resource of which the described resource is a version, edition, or adaptation. Changes in version imply substantive changes
   * in content rather than differences in format.
   *
   * @return A related resource of which the described resource is a version, edition, or adaptation. Changes in version imply substantive
   * changes in content rather than differences in format.
   *
   * @link http://dublincore.org/documents/dcmi-terms/#terms-isVersionOf
   */
  public List<DublinCoreStringProperty> getVersionOf() {
    return isVersionOf;
  }

  /**
   * A related resource of which the described resource is a version, edition, or adaptation. Changes in version imply substantive changes
   * in content rather than differences in format.
   *
   * @param versionOf A related resource of which the described resource is a version, edition, or adaptation. Changes in version imply substantive
   * changes in content rather than differences in format.
   *
   * @link http://dublincore.org/documents/dcmi-terms/#terms-isVersionOf
   */
  public void setVersionOf(List<DublinCoreStringProperty> versionOf) {
    isVersionOf = versionOf;
  }

  /**
   * A language of the resource. Recommended best practice is to use a controlled vocabulary such as RFC 4646 [RFC4646].
   *
   * @return A language of the resource. Recommended best practice is to use a controlled vocabulary such as RFC 4646 [RFC4646].
   * @link http://dublincore.org/documents/dcmi-terms/#terms-language
   */
  public List<DublinCoreStringProperty> getLanguage() {
    return language;
  }

  /**
   * A language of the resource. Recommended best practice is to use a controlled vocabulary such as RFC 4646 [RFC4646].
   *
   * @param language A language of the resource. Recommended best practice is to use a controlled vocabulary such as RFC 4646 [RFC4646].
   * @link http://dublincore.org/documents/dcmi-terms/#terms-language
   */
  public void setLanguage(List<DublinCoreStringProperty> language) {
    this.language = language;
  }

  /**
   * A legal document giving official permission to do something with the resource.
   *
   * @return A legal document giving official permission to do something with the resource.
   * @link http://dublincore.org/documents/dcmi-terms/#terms-license
   */
  public List<DublinCoreStringProperty> getLicense() {
    return license;
  }

  /**
   * A legal document giving official permission to do something with the resource.
   *
   * @param license A legal document giving official permission to do something with the resource.
   * @link http://dublincore.org/documents/dcmi-terms/#terms-license
   */
  public void setLicense(List<DublinCoreStringProperty> license) {
    this.license = license;
  }

  /**
   * An entity that mediates access to the resource and for whom the resource is intended or useful.
   *
   * @return An entity that mediates access to the resource and for whom the resource is intended or useful.
   * @link http://dublincore.org/documents/dcmi-terms/#terms-mediator
   */
  public List<DublinCoreStringProperty> getMediator() {
    return mediator;
  }

  /**
   * An entity that mediates access to the resource and for whom the resource is intended or useful.
   *
   * @param mediator An entity that mediates access to the resource and for whom the resource is intended or useful.
   * @link http://dublincore.org/documents/dcmi-terms/#terms-mediator
   */
  public void setMediator(List<DublinCoreStringProperty> mediator) {
    this.mediator = mediator;
  }

  /**
   * The material or physical carrier of the resource.
   *
   * @return The material or physical carrier of the resource.
   * @link http://dublincore.org/documents/dcmi-terms/#terms-medium
   */
  public List<DublinCoreStringProperty> getMedium() {
    return medium;
  }

  /**
   * The material or physical carrier of the resource.
   *
   * @param medium The material or physical carrier of the resource.
   * @link http://dublincore.org/documents/dcmi-terms/#terms-medium
   */
  public void setMedium(List<DublinCoreStringProperty> medium) {
    this.medium = medium;
  }

  /**
   * Date on which the resource was changed.
   *
   * @return Date on which the resource was changed.
   * @link http://dublincore.org/documents/dcmi-terms/#terms-modified
   */
  public List<DublinCoreDateProperty> getModified() {
    return modified;
  }

  /**
   * Date on which the resource was changed.
   *
   * @param modified Date on which the resource was changed.
   * @link http://dublincore.org/documents/dcmi-terms/#terms-modified
   */
  public void setModified(List<DublinCoreDateProperty> modified) {
    this.modified = modified;
  }

  /**
   * A statement of any changes in ownership and custody of the resource since its creation that are significant for its authenticity, integrity, and interpretation.
   *
   * @return A statement of any changes in ownership and custody of the resource since its creation that are significant for its authenticity, integrity, and interpretation.
   * @link http://dublincore.org/documents/dcmi-terms/#terms-provenance
   */
  public List<DublinCoreStringProperty> getProvenance() {
    return provenance;
  }

  /**
   * A statement of any changes in ownership and custody of the resource since its creation that are significant for its authenticity, integrity, and interpretation.
   *
   * @param provenance A statement of any changes in ownership and custody of the resource since its creation that are significant for its authenticity, integrity, and interpretation.
   * @link http://dublincore.org/documents/dcmi-terms/#terms-provenance
   */
  public void setProvenance(List<DublinCoreStringProperty> provenance) {
    this.provenance = provenance;
  }

  /**
   * An entity responsible for making the resource available.
   *
   * @return An entity responsible for making the resource available.
   * @link http://dublincore.org/documents/dcmi-terms/#terms-publisher
   */
  public List<DublinCoreStringProperty> getPublisher() {
    return publisher;
  }

  /**
   * An entity responsible for making the resource available.
   *
   * @param publisher An entity responsible for making the resource available.
   * @link http://dublincore.org/documents/dcmi-terms/#terms-publisher
   */
  public void setPublisher(List<DublinCoreStringProperty> publisher) {
    this.publisher = publisher;
  }

  /**
   * A related resource that is referenced, cited, or otherwise pointed to by the described resource.
   *
   * @return A related resource that is referenced, cited, or otherwise pointed to by the described resource.
   * @link http://dublincore.org/documents/dcmi-terms/#terms-references
   */
  public List<DublinCoreStringProperty> getReferences() {
    return references;
  }

  /**
   * A related resource that is referenced, cited, or otherwise pointed to by the described resource.
   *
   * @param references A related resource that is referenced, cited, or otherwise pointed to by the described resource.
   * @link http://dublincore.org/documents/dcmi-terms/#terms-references
   */
  public void setReferences(List<DublinCoreStringProperty> references) {
    this.references = references;
  }

  /**
   * A related resource.
   *
   * @return A related resource.
   * @link http://dublincore.org/documents/dcmi-terms/#terms-relation
   */
  public List<DublinCoreStringProperty> getRelation() {
    return relation;
  }

  /**
   * A related resource.
   *
   * @param relation A related resource.
   * @link http://dublincore.org/documents/dcmi-terms/#terms-relation
   */
  public void setRelation(List<DublinCoreStringProperty> relation) {
    this.relation = relation;
  }

  /**
   * A related resource that is supplanted, displaced, or superseded by the described resource.
   *
   * @return A related resource that is supplanted, displaced, or superseded by the described resource.
   * @link http://dublincore.org/documents/dcmi-terms/#terms-replaces
   */
  public List<DublinCoreStringProperty> getReplaces() {
    return replaces;
  }

  /**
   * A related resource that is supplanted, displaced, or superseded by the described resource.
   *
   * @param replaces A related resource that is supplanted, displaced, or superseded by the described resource.
   * @link http://dublincore.org/documents/dcmi-terms/#terms-replaces
   */
  public void setReplaces(List<DublinCoreStringProperty> replaces) {
    this.replaces = replaces;
  }

  /**
   * A related resource that is required by the described resource to support its function, delivery, or coherence.
   *
   * @return A related resource that is required by the described resource to support its function, delivery, or coherence.
   * @link http://dublincore.org/documents/dcmi-terms/#terms-requires
   */
  public List<DublinCoreStringProperty> getRequires() {
    return requires;
  }

  /**
   * A related resource that is required by the described resource to support its function, delivery, or coherence.
   *
   * @param requires A related resource that is required by the described resource to support its function, delivery, or coherence.
   * @link http://dublincore.org/documents/dcmi-terms/#terms-requires
   */
  public void setRequires(List<DublinCoreStringProperty> requires) {
    this.requires = requires;
  }

  /**
   * Information about rights held in and over the resource.
   *
   * @return Information about rights held in and over the resource.
   * @link http://dublincore.org/documents/dcmi-terms/#terms-rights
   */
  public List<DublinCoreStringProperty> getRights() {
    return rights;
  }

  /**
   * Information about rights held in and over the resource.
   *
   * @param rights Information about rights held in and over the resource.
   * @link http://dublincore.org/documents/dcmi-terms/#terms-rights
   */
  public void setRights(List<DublinCoreStringProperty> rights) {
    this.rights = rights;
  }

  /**
   * A person or organization owning or managing rights over the resource.
   *
   * @return A person or organization owning or managing rights over the resource.
   * @link http://dublincore.org/documents/dcmi-terms/#terms-rightsHolder
   */
  public List<DublinCoreStringProperty> getRightsHolder() {
    return rightsHolder;
  }

  /**
   * A person or organization owning or managing rights over the resource.
   *
   * @param rightsHolder A person or organization owning or managing rights over the resource.
   * @link http://dublincore.org/documents/dcmi-terms/#terms-rightsHolder
   */
  public void setRightsHolder(List<DublinCoreStringProperty> rightsHolder) {
    this.rightsHolder = rightsHolder;
  }

  /**
   * A related resource from which the described resource is derived.
   *
   * @return A related resource from which the described resource is derived.
   * @link http://dublincore.org/documents/dcmi-terms/#terms-source
   */
  public List<DublinCoreStringProperty> getSource() {
    return source;
  }

  /**
   * A related resource from which the described resource is derived.
   *
   * @param source A related resource from which the described resource is derived.
   * @link http://dublincore.org/documents/dcmi-terms/#terms-source
   */
  public void setSource(List<DublinCoreStringProperty> source) {
    this.source = source;
  }

  /**
   * Spatial characteristics of the resource.
   *
   * @return Spatial characteristics of the resource.
   * @see #getCoverage()
   * @link http://dublincore.org/documents/dcmi-terms/#terms-spatial
   */
  public List<DublinCoreStringProperty> getSpatial() {
    return spatial;
  }

  /**
   * Spatial characteristics of the resource.
   *
   * @param spatial Spatial characteristics of the resource.
   * @see #getCoverage()
   * @link http://dublincore.org/documents/dcmi-terms/#terms-spatial
   */
  public void setSpatial(List<DublinCoreStringProperty> spatial) {
    this.spatial = spatial;
  }

  /**
   * The topic of the resource. Typically, the subject will be represented using keywords, key phrases, or classification codes.
   * Recommended best practice is to use a controlled vocabulary. To describe the spatial or temporal topic of the resource,
   * use the Coverage element.
   * 
   * @return The topic of the resource. Typically, the subject will be represented using keywords, key phrases, or classification codes.
   * Recommended best practice is to use a controlled vocabulary. To describe the spatial or temporal topic of the resource,
   * use the Coverage element.
   * @link http://dublincore.org/documents/dcmi-terms/#terms-subject
   */
  public List<DublinCoreStringProperty> getSubject() {
    return subject;
  }

  /**
   * The topic of the resource. Typically, the subject will be represented using keywords, key phrases, or classification codes.
   * Recommended best practice is to use a controlled vocabulary. To describe the spatial or temporal topic of the resource,
   * use the Coverage element.
   *
   * @param subject The topic of the resource. Typically, the subject will be represented using keywords, key phrases, or classification codes.
   * Recommended best practice is to use a controlled vocabulary. To describe the spatial or temporal topic of the resource,
   * use the Coverage element.
   * @link http://dublincore.org/documents/dcmi-terms/#terms-subject
   */
  public void setSubject(List<DublinCoreStringProperty> subject) {
    this.subject = subject;
  }

  /**
   * A list of subunits of the resource.
   *
   * @return A list of subunits of the resource.
   * @link http://dublincore.org/documents/dcmi-terms/#terms-tableOfContents
   */
  public List<DublinCoreStringProperty> getTableOfContents() {
    return tableOfContents;
  }

  /**
   * A list of subunits of the resource.
   *
   * @param tableOfContents A list of subunits of the resource.
   * @link http://dublincore.org/documents/dcmi-terms/#terms-tableOfContents
   */
  public void setTableOfContents(List<DublinCoreStringProperty> tableOfContents) {
    this.tableOfContents = tableOfContents;
  }

  /**
   * Temporal characteristics of the resource.
   *
   * @return Temporal characteristics of the resource.
   * @link http://dublincore.org/documents/dcmi-terms/#terms-temporal
   */
  public List<DublinCoreStringProperty> getTemporal() {
    return temporal;
  }

  /**
   * Temporal characteristics of the resource.
   *
   * @param temporal Temporal characteristics of the resource.
   * @link http://dublincore.org/documents/dcmi-terms/#terms-temporal
   */
  public void setTemporal(List<DublinCoreStringProperty> temporal) {
    this.temporal = temporal;
  }

  /**
   * A name given to the resource.
   *
   * @return A name given to the resource.
   * @link http://dublincore.org/documents/dcmi-terms/#terms-title
   */
  public List<DublinCoreStringProperty> getTitle() {
    return title;
  }

  /**
   * A name given to the resource.
   *
   * @param title A name given to the resource.
   * @link http://dublincore.org/documents/dcmi-terms/#terms-title
   */
  public void setTitle(List<DublinCoreStringProperty> title) {
    this.title = title;
  }

  /**
   * The nature or genre of the resource. Recommended best practice is to use a controlled vocabulary such as the DCMI Type Vocabulary [DCMITYPE]. To
   * describe the file format, physical medium, or dimensions of the resource, use the Format element.
   *
   * @return The nature or genre of the resource. Recommended best practice is to use a controlled vocabulary such as the DCMI Type Vocabulary [DCMITYPE].
   * To describe the file format, physical medium, or dimensions of the resource, use the Format element.
   * @link http://dublincore.org/documents/dcmi-terms/#terms-type
   */
  public List<DublinCoreTypeProperty> getType() {
    return type;
  }

  /**
   * The nature or genre of the resource. Recommended best practice is to use a controlled vocabulary such as the DCMI Type Vocabulary [DCMITYPE]. To
   * describe the file format, physical medium, or dimensions of the resource, use the Format element.
   *
   * @param type The nature or genre of the resource. Recommended best practice is to use a controlled vocabulary such as the DCMI Type Vocabulary [DCMITYPE].
   * To describe the file format, physical medium, or dimensions of the resource, use the Format element.
   * @link http://dublincore.org/documents/dcmi-terms/#terms-type
   */
  public void setType(List<DublinCoreTypeProperty> type) {
    this.type = type;
  }

  /**
   * Date of validity of a resource.
   *
   * @return Date of validity of a resource.
   * @link http://dublincore.org/documents/dcmi-terms/#terms-valid
   */
  public List<DublinCoreDateProperty> getValid() {
    return valid;
  }

  /**
   * Date of validity of a resource.
   *
   * @param valid Date of validity of a resource.
   * @link http://dublincore.org/documents/dcmi-terms/#terms-valid
   */
  public void setValid(List<DublinCoreDateProperty> valid) {
    this.valid = valid;
  }
}

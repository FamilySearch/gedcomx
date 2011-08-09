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

import org.codehaus.enunciate.XmlQNameEnumUtil;
import org.codehaus.jackson.annotate.JsonIgnore
;
import org.codehaus.enunciate.json.JsonName;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonTypeInfo;
import org.codehaus.jackson.map.annotate.JsonTypeIdResolver;
import org.gedcomx.metadata.rdf.RDFLiteral;
import org.gedcomx.metadata.rdf.RDFValue;
import org.gedcomx.metadata.rdf.RDFDescription;
import org.gedcomx.rt.XmlTypeIdResolver;

import javax.xml.bind.annotation.XmlTransient;
import javax.xml.namespace.QName;
import java.util.Date;
import java.util.List;

/**
 * A model for a generic description of a resource using <a href="http://dublincore.org/documents/dcmi-terms/">Dublin Core Metadata Terms</a>.
 * Fits into the RDF model <a href="http://dublincore.org/documents/2008/01/14/dc-rdf/">according to recommendation provided by Dublin Core</a>.
 * Note that this definition is a stricter subset of the looser definition provided by the recommendation. The tightening is intended to improve
 * consumability.
 *
 * @link http://dublincore.org/documents/2008/01/14/dc-rdf/#app-a
 * @link http://dublincore.org/documents/profile-guidelines/#appc
 * @author Ryan Heaton
 */
@JsonTypeInfo ( use =JsonTypeInfo.Id.CUSTOM, property = "@type")
@JsonTypeIdResolver (XmlTypeIdResolver.class)
public class DublinCoreDescription extends RDFDescription {

  private RDFValue abstrct;
  private List<RDFValue> accessRights;
  private RDFValue accrualMethod;
  private RDFValue accrualPeriodicity;
  private RDFValue accrualPolicy;
  private List<RDFLiteral> alternative;
  private List<RDFValue> audience;
  private Date available;
  private RDFLiteral bibliographicCitation;
  private List<RDFValue> conformsTo;
  private List<RDFValue> contributor;
  private RDFValue coverage;
  private Date created;
  private List<RDFValue> creator;
  private Date date;
  private Date dateAccepted;
  private Date dateCopyrighted;
  private Date dateSubmitted;
  private RDFValue description;
  private RDFValue educationLevel;
  private RDFValue extent;
  private RDFValue format;
  private List<RDFValue> hasFormat;
  private List<RDFValue> hasPart;
  private List<RDFValue> hasVersion;
  private RDFValue identifier;
  private RDFValue instructionalMethod;
  private List<RDFValue> isFormatOf;
  private List<RDFValue> isPartOf;
  private List<RDFValue> isReferencedBy;
  private List<RDFValue> isReplacedBy;
  private List<RDFValue> isRequiredBy;
  private Date issued;
  private RDFValue isVersionOf;
  private List<RDFValue> language;
  private List<RDFValue> license;
  private List<RDFValue> mediator;
  private RDFValue medium;
  private Date modified;
  private RDFValue provenance;
  private RDFValue publisher;
  private List<RDFValue> references;
  private List<RDFValue> relation;
  private List<RDFValue> replaces;
  private List<RDFValue> requires;
  private List<RDFValue> rights;
  private RDFValue rightsHolder;
  private List<RDFValue> source;
  private List<RDFValue> spatial;
  private List<RDFValue> subject;
  private RDFValue tableOfContents;
  private List<RDFValue> temporal;
  private RDFLiteral title;
  private QName type;
  private List<RDFValue> valid;

  /**
   * A summary of the resource.
   *
   * @return A summary of the resource.
   * @link http://dublincore.org/documents/dcmi-terms/#terms-abstract
   */
  public RDFValue getAbstract() {
    return abstrct;
  }

  /**
   * A summary of the resource.
   *
   * @param abstrct A summary of the resource.
   * @link http://dublincore.org/documents/dcmi-terms/#terms-abstract
   */
  public void setAbstract(RDFValue abstrct) {
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
  @SuppressWarnings("gedcomx:plural_xml_name")
  public List<RDFValue> getAccessRights() {
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
  public void setAccessRights(List<RDFValue> accessRights) {
    this.accessRights = accessRights;
  }

  /**
   * The method by which items are added to a collection.
   *
   * @return The method by which items are added to a collection.
   * @link http://dublincore.org/documents/dcmi-terms/#terms-accrualMethod
   */
  public RDFValue getAccrualMethod() {
    return accrualMethod;
  }

  /**
   * The method by which items are added to a collection.
   *
   * @param accrualMethod The method by which items are added to a collection.
   * @link http://dublincore.org/documents/dcmi-terms/#terms-accrualMethod
   */
  public void setAccrualMethod(RDFValue accrualMethod) {
    this.accrualMethod = accrualMethod;
  }

  /**
   * The frequency with which items are added to a collection.
   *
   * @return The frequency with which items are added to a collection.
   * @link http://dublincore.org/documents/dcmi-terms/#terms-accrualPeriodicity
   */
  public RDFValue getAccrualPeriodicity() {
    return accrualPeriodicity;
  }

  /**
   * The frequency with which items are added to a collection.
   *
   * @param accrualPeriodicity The frequency with which items are added to a collection.
   * @link http://dublincore.org/documents/dcmi-terms/#terms-accrualPeriodicity
   */
  public void setAccrualPeriodicity(RDFValue accrualPeriodicity) {
    this.accrualPeriodicity = accrualPeriodicity;
  }

  /**
   * The policy governing the addition of items to a collection.
   *
   * @return The policy governing the addition of items to a collection.
   * @link http://dublincore.org/documents/dcmi-terms/#terms-accrualPolicy
   */
  public RDFValue getAccrualPolicy() {
    return accrualPolicy;
  }

  /**
   * The policy governing the addition of items to a collection.
   *
   * @param accrualPolicy The policy governing the addition of items to a collection.
   * @link http://dublincore.org/documents/dcmi-terms/#terms-accrualPolicy
   */
  public void setAccrualPolicy(RDFValue accrualPolicy) {
    this.accrualPolicy = accrualPolicy;
  }

  /**
   * Alternative names for the resource. The distinction between titles and alternative titles is application-specific.
   *
   * @return Alternative names for the resource. The distinction between titles and alternative titles is application-specific.
   * @link http://dublincore.org/documents/dcmi-terms/#terms-alternative
   */
  @JsonName ("alternatives")
  @JsonProperty ("alternatives")
  public List<RDFLiteral> getAlternative() {
    return alternative;
  }

  /**
   * Alternative names for the resource. The distinction between titles and alternative titles is application-specific.
   *
   * @param alternative Alternative names for the resource. The distinction between titles and alternative titles is application-specific.
   * @link http://dublincore.org/documents/dcmi-terms/#terms-alternative
   */
  @JsonProperty ("alternatives")
  public void setAlternative(List<RDFLiteral> alternative) {
    this.alternative = alternative;
  }

  /**
   * Classes of entities for whom the resource is intended or useful.
   *
   * @return Classes of entities for whom the resource is intended or useful.
   * @link http://dublincore.org/documents/dcmi-terms/#terms-audience
   */
  @JsonName ("audiences")
  @JsonProperty ("audiences")
  public List<RDFValue> getAudience() {
    return audience;
  }

  /**
   * A class of entity for whom the resource is intended or useful.
   *
   * @param audience A class of entity for whom the resource is intended or useful.
   * @link http://dublincore.org/documents/dcmi-terms/#terms-audience
   */
  @JsonProperty ("audiences")
  public void setAudience(List<RDFValue> audience) {
    this.audience = audience;
  }

  /**
   * Date that the resource became or will become available.
   *
   * @return Date that the resource became or will become available.
   * @link http://dublincore.org/documents/dcmi-terms/#terms-available
   */
  public Date getAvailable() {
    return available;
  }

  /**
   * Date that the resource became or will become available.
   *
   * @param available Date that the resource became or will become available.
   * @link http://dublincore.org/documents/dcmi-terms/#terms-available
   */
  public void setAvailable(Date available) {
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
  public RDFLiteral getBibliographicCitation() {
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
  public void setBibliographicCitation(RDFLiteral bibliographicCitation) {
    this.bibliographicCitation = bibliographicCitation;
  }

  /**
   * Established standards to which the described resource conforms.
   *
   * @return Established standards to which the described resource conforms.
   * @link http://dublincore.org/documents/dcmi-terms/#terms-conformsTo
   */
  @SuppressWarnings("gedcomx:non_plural_json_name")
  public List<RDFValue> getConformsTo() {
    return conformsTo;
  }

  /**
   * Established standards to which the described resource conforms.
   *
   * @param conformsTo Established standards to which the described resource conforms.
   * @link http://dublincore.org/documents/dcmi-terms/#terms-conformsTo
   */
  public void setConformsTo(List<RDFValue> conformsTo) {
    this.conformsTo = conformsTo;
  }

  /**
   * Entities responsible for making contributions to the resource. Examples of a Contributor include a person, an organization, or a service.
   *
   * @return Entities responsible for making contributions to the resource. Examples of a Contributor include a person, an organization, or a service.
   * @link http://dublincore.org/documents/dcmi-terms/#terms-contributor
   */
  @JsonName ("contributors")
  @JsonProperty ("contributors")
  public List<RDFValue> getContributor() {
    return contributor;
  }

  /**
   * Entities responsible for making contributions to the resource. Examples of a Contributor include a person, an organization, or a service.
   *
   * @param contributor Entities responsible for making contributions to the resource. Examples of a Contributor include a person, an organization, or a service.
   * @link http://dublincore.org/documents/dcmi-terms/#terms-contributor
   */
  @JsonProperty ("contributors")
  public void setContributor(List<RDFValue> contributor) {
    this.contributor = contributor;
  }

  /**
   * The spatial or temporal topic of the resource, the spatial applicability of the resource, or the jurisdiction under which the resource is relevant.
   *
   * @return The spatial or temporal topic of the resource, the spatial applicability of the resource, or the jurisdiction under which the resource is relevant.
   * @link http://dublincore.org/documents/dcmi-terms/#terms-coverage
   */
  public RDFValue getCoverage() {
    return coverage;
  }

  /**
   * The spatial or temporal topic of the resource, the spatial applicability of the resource, or the jurisdiction under which the resource is relevant.
   *
   * @param coverage The spatial or temporal topic of the resource, the spatial applicability of the resource, or the jurisdiction under which the resource is relevant.
   * @link http://dublincore.org/documents/dcmi-terms/#terms-coverage
   */
  public void setCoverage(RDFValue coverage) {
    this.coverage = coverage;
  }

  /**
   * Date of creation of the resource.
   *
   * @return Date of creation of the resource.
   * @link http://dublincore.org/documents/dcmi-terms/#terms-created
   */
  public Date getCreated() {
    return created;
  }

  /**
   * Date of creation of the resource.
   *
   * @param created Date of creation of the resource.
   * @link http://dublincore.org/documents/dcmi-terms/#terms-created
   */
  public void setCreated(Date created) {
    this.created = created;
  }

  /**
   * Entities primarily responsible for making the resource.
   *
   * @return Entities primarily responsible for making the resource.
   * @link http://dublincore.org/documents/dcmi-terms/#terms-creator
   */
  @JsonName ("creators")
  @JsonProperty ("creators")
  public List<RDFValue> getCreator() {
    return creator;
  }

  /**
   * Entities primarily responsible for making the resource.
   *
   * @param creator Entities primarily responsible for making the resource.
   * @link http://dublincore.org/documents/dcmi-terms/#terms-creator
   */
  @JsonProperty ("creators")
  public void setCreator(List<RDFValue> creator) {
    this.creator = creator;
  }

  /**
   * A point or period of time associated with an event in the lifecycle of the resource.
   *
   * @return A point or period of time associated with an event in the lifecycle of the resource.
   * @link http://dublincore.org/documents/dcmi-terms/#terms-date
   */
  public Date getDate() {
    return date;
  }

  /**
   * A point or period of time associated with an event in the lifecycle of the resource.
   *
   * @param date A point or period of time associated with an event in the lifecycle of the resource.
   * @link http://dublincore.org/documents/dcmi-terms/#terms-date
   */
  public void setDate(Date date) {
    this.date = date;
  }

  /**
   * Date of acceptance of the resource.
   *
   * @return Date of acceptance of the resource.
   * @link http://dublincore.org/documents/dcmi-terms/#terms-dateAccepted
   */
  public Date getDateAccepted() {
    return dateAccepted;
  }

  /**
   * Date of acceptance of the resource.
   *
   * @param dateAccepted Date of acceptance of the resource.
   * @link http://dublincore.org/documents/dcmi-terms/#terms-dateAccepted
   */
  public void setDateAccepted(Date dateAccepted) {
    this.dateAccepted = dateAccepted;
  }

  /**
   * Date of copyright.
   *
   * @return Date of copyright.
   * @link http://dublincore.org/documents/dcmi-terms/#terms-dateCopyrighted
   */
  public Date getDateCopyrighted() {
    return dateCopyrighted;
  }

  /**
   * Date of copyright.
   *
   * @param dateCopyrighted Date of copyright.
   * @link http://dublincore.org/documents/dcmi-terms/#terms-dateCopyrighted
   */
  public void setDateCopyrighted(Date dateCopyrighted) {
    this.dateCopyrighted = dateCopyrighted;
  }

  /**
   * Date of submission of the resource.
   *
   * @return Date of submission of the resource.
   * @link http://dublincore.org/documents/dcmi-terms/#terms-dateSubmitted
   */
  public Date getDateSubmitted() {
    return dateSubmitted;
  }

  /**
   * Date of submission of the resource.
   *
   * @param dateSubmitted Date of submission of the resource.
   * @link http://dublincore.org/documents/dcmi-terms/#terms-dateSubmitted
   */
  public void setDateSubmitted(Date dateSubmitted) {
    this.dateSubmitted = dateSubmitted;
  }

  /**
   * An account of the resource.
   *
   * @return An account of the resource.
   * @link http://dublincore.org/documents/dcmi-terms/#terms-description
   */
  public RDFValue getDescription() {
    return description;
  }

  /**
   * An account of the resource.
   *
   * @param description An account of the resource.
   * @link http://dublincore.org/documents/dcmi-terms/#terms-description
   */
  public void setDescription(RDFValue description) {
    this.description = description;
  }

  /**
   * A class of entity, defined in terms of progression through an educational or training context, for which the described resource is intended.
   *
   * @return A class of entity, defined in terms of progression through an educational or training context, for which the described resource is intended.
   * @link http://dublincore.org/documents/dcmi-terms/#terms-educationLevel
   */
  public RDFValue getEducationLevel() {
    return educationLevel;
  }

  /**
   * A class of entity, defined in terms of progression through an educational or training context, for which the described resource is intended.
   *
   * @param educationLevel A class of entity, defined in terms of progression through an educational or training context, for which the described resource is intended.
   * @link http://dublincore.org/documents/dcmi-terms/#terms-educationLevel
   */
  public void setEducationLevel(RDFValue educationLevel) {
    this.educationLevel = educationLevel;
  }

  /**
   * The size or duration of the resource.
   *
   * @return The size or duration of the resource.
   * @link http://dublincore.org/documents/dcmi-terms/#terms-extent
   */
  public RDFValue getExtent() {
    return extent;
  }

  /**
   * The size or duration of the resource.
   *
   * @param extent The size or duration of the resource.
   * @link http://dublincore.org/documents/dcmi-terms/#terms-extent
   */
  public void setExtent(RDFValue extent) {
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
  public RDFValue getFormat() {
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
  public void setFormat(RDFValue format) {
    this.format = format;
  }

  /**
   * List of alternate formats of the pre-existing described resource. In REST terms, a list of the alternate "representations" that are available
   * for the described resource, probably in terms of the MIME type. If the alternate representations of the resource are accessed at
   * a different URI (bad practice, but an accepted reality), use a custom {http://www.w3.org/1999/xlink}href attribute instead of the
   * {http://www.w3.org/1999/02/22-rdf-syntax-ns#}resource attribute.
   *
   * @return Alternate formats of the described resource.
   * @link http://dublincore.org/documents/dcmi-terms/#terms-hasFormat
   */
  @JsonName ("hasFormats")
  @JsonProperty ("hasFormats")
  public List<RDFValue> getHasFormat() {
    return hasFormat;
  }

  /**
   * List of alternate formats of the pre-existing described resource. In REST terms, a list of the alternate "representations" that are available
   * for the described resource, probably in terms of the MIME type. If the alternate representations of the resource are accessed at
   * a different URI (bad practice, but an accepted reality), use a custom {http://www.w3.org/1999/xlink}href attribute instead of the
   * {http://www.w3.org/1999/02/22-rdf-syntax-ns#}resource attribute.
   *
   * @param hasFormat Alternate formats of the described resource.
   * @link http://dublincore.org/documents/dcmi-terms/#terms-hasFormat
   */
  @JsonProperty ("hasFormats")
  public void setHasFormat(List<RDFValue> hasFormat) {
    this.hasFormat = hasFormat;
  }

  /**
   * Related resources that are included either physically or logically in the described resource.
   *
   * @return Related resources that are included either physically or logically in the described resource.
   * @link http://dublincore.org/documents/dcmi-terms/#terms-hasPart
   */
  @JsonName ("hasParts")
  @JsonProperty ("hasParts")
  public List<RDFValue> getHasPart() {
    return hasPart;
  }

  /**
   * Related resources that are included either physically or logically in the described resource.
   *
   * @param hasPart Related resources that are included either physically or logically in the described resource.
   * @link http://dublincore.org/documents/dcmi-terms/#terms-hasPart
   */
  @JsonProperty ("hasParts")
  public void setHasPart(List<RDFValue> hasPart) {
    this.hasPart = hasPart;
  }

  /**
   * Related resources that are a version, edition, or adaptation of the described resource.
   *
   * @return Related resources that are a version, edition, or adaptation of the described resource.
   * @link http://dublincore.org/documents/dcmi-terms/#terms-hasVersion
   */
  @JsonName ("hasVersions")
  @JsonProperty ("hasVersions")
  public List<RDFValue> getHasVersion() {
    return hasVersion;
  }

  /**
   * Related resources that are a version, edition, or adaptation of the described resource.
   *
   * @param hasVersion Related resources that are a version, edition, or adaptation of the described resource.
   * @link http://dublincore.org/documents/dcmi-terms/#terms-hasVersion
   */
  @JsonProperty ("hasVersions")
  public void setHasVersion(List<RDFValue> hasVersion) {
    this.hasVersion = hasVersion;
  }

  /**
   * An unambiguous reference to the resource within a given context.
   *
   * @return An unambiguous reference to the resource within a given context.
   * @link http://dublincore.org/documents/dcmi-terms/#terms-identifier
   */
  public RDFValue getIdentifier() {
    return identifier;
  }

  /**
   * An unambiguous reference to the resource within a given context.
   *
   * @param identifier An unambiguous reference to the resource within a given context.
   * @link http://dublincore.org/documents/dcmi-terms/#terms-identifier
   */
  public void setIdentifier(RDFValue identifier) {
    this.identifier = identifier;
  }

  /**
   * A process, used to engender knowledge, attitudes and skills, that the described resource is designed to support.
   * 
   * @return A process, used to engender knowledge, attitudes and skills, that the described resource is designed to support.
   * @link http://dublincore.org/documents/dcmi-terms/#terms-instructionalMethod
   */
  public RDFValue getInstructionalMethod() {
    return instructionalMethod;
  }

  /**
   * A process, used to engender knowledge, attitudes and skills, that the described resource is designed to support.
   *
   * @param instructionalMethod A process, used to engender knowledge, attitudes and skills, that the described resource is designed to support.
   * @link http://dublincore.org/documents/dcmi-terms/#terms-instructionalMethod
   */
  public void setInstructionalMethod(RDFValue instructionalMethod) {
    this.instructionalMethod = instructionalMethod;
  }

  /**
   * Related resources that are substantially the same as the described resource, but in another format. In REST terms, the URI of
   * an alternate representation of the same resource. Note that having more than one URI for the same resource is generally bad
   * practice (see http://www.w3.org/TR/webarch/) but still an accepted reality.
   *
   * @return Related resources that are substantially the same as the described resource, but in another format.
   * @link http://dublincore.org/documents/dcmi-terms/#terms-isFormatOf
   */
  @SuppressWarnings("gedcomx:non_plural_json_name")
  public List<RDFValue> getFormatOf() {
    return isFormatOf;
  }

  /**
   * Related resources that are substantially the same as the described resource, but in another format. In REST terms, the URI of
   * an alternate representation of the same resource. Note that having more than one URI for the same resource is generally bad
   * practice (see http://www.w3.org/TR/webarch/) but still an accepted reality.
   *
   * @param formatOf Related resources that are substantially the same as the described resource, but in another format.
   * @link http://dublincore.org/documents/dcmi-terms/#terms-isFormatOf
   */
  public void setFormatOf(List<RDFValue> formatOf) {
    isFormatOf = formatOf;
  }

  /**
   * Related resources in which the described resource is physically or logically included.
   *
   * @return Related resources in which the described resource is physically or logically included.
   * @link http://dublincore.org/documents/dcmi-terms/#terms-isPartOf
   */
  @SuppressWarnings("gedcomx:non_plural_json_name")
  public List<RDFValue> getPartOf() {
    return isPartOf;
  }

  /**
   * Related resources in which the described resource is physically or logically included.
   *
   * @param partOf Related resources in which the described resource is physically or logically included.
   * @link http://dublincore.org/documents/dcmi-terms/#terms-isPartOf
   */
  public void setPartOf(List<RDFValue> partOf) {
    isPartOf = partOf;
  }

  /**
   * Related resources that reference, cite, or otherwise point to the described resource.
   *
   * @return Related resources that reference, cite, or otherwise point to the described resource.
   * @link http://dublincore.org/documents/dcmi-terms/#terms-isReferencedBy
   */
  @SuppressWarnings("gedcomx:non_plural_json_name")
  public List<RDFValue> getReferencedBy() {
    return isReferencedBy;
  }

  /**
   * Related resources that reference, cite, or otherwise point to the described resource.
   *
   * @param referencedBy Related resources that reference, cite, or otherwise point to the described resource.
   * @link http://dublincore.org/documents/dcmi-terms/#terms-isReferencedBy
   */
  public void setReferencedBy(List<RDFValue> referencedBy) {
    isReferencedBy = referencedBy;
  }

  /**
   * Related resources that supplant, displace, or supersede the described resource.
   *
   * @return Related resources that supplant, displace, or supersede the described resource.
   * @link http://dublincore.org/documents/dcmi-terms/#terms-isReplacedBy
   */
  @SuppressWarnings("gedcomx:non_plural_json_name")
  public List<RDFValue> getReplacedBy() {
    return isReplacedBy;
  }

  /**
   * Related resources that supplant, displace, or supersede the described resource.
   *
   * @param replacedBy Related resources that supplant, displace, or supersede the described resource.
   * @link http://dublincore.org/documents/dcmi-terms/#terms-isReplacedBy
   */
  public void setReplacedBy(List<RDFValue> replacedBy) {
    isReplacedBy = replacedBy;
  }

  /**
   * Related resources that require the described resource to support its function, delivery, or coherence.
   *
   * @return Related resources that require the described resource to support its function, delivery, or coherence.
   * @link http://dublincore.org/documents/dcmi-terms/#terms-isRequiredBy
   */
  @SuppressWarnings("gedcomx:non_plural_json_name")
  public List<RDFValue> getRequiredBy() {
    return isRequiredBy;
  }

  /**
   * Related resources that require the described resource to support its function, delivery, or coherence.
   *
   * @param requiredBy Related resources that require the described resource to support its function, delivery, or coherence.
   * @link http://dublincore.org/documents/dcmi-terms/#terms-isRequiredBy
   */
  public void setRequiredBy(List<RDFValue> requiredBy) {
    isRequiredBy = requiredBy;
  }

  /**
   * Date of formal issuance (e.g., publication) of the resource.
   *
   * @return Date of formal issuance (e.g., publication) of the resource.
   * @link http://dublincore.org/documents/dcmi-terms/#terms-issued
   */
  public Date getIssued() {
    return issued;
  }

  /**
   * Date of formal issuance (e.g., publication) of the resource.
   *
   * @param issued Date of formal issuance (e.g., publication) of the resource.
   * @link http://dublincore.org/documents/dcmi-terms/#terms-issued
   */
  public void setIssued(Date issued) {
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
  public RDFValue getVersionOf() {
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
  public void setVersionOf(RDFValue versionOf) {
    isVersionOf = versionOf;
  }

  /**
   * Languages of the resource. Recommended best practice is to use a controlled vocabulary such as RFC 4646 [RFC4646].
   *
   * @return Languages of the resource. Recommended best practice is to use a controlled vocabulary such as RFC 4646 [RFC4646].
   * @link http://dublincore.org/documents/dcmi-terms/#terms-language
   */
  @JsonName ("languages")
  @JsonProperty ("languages")
  public List<RDFValue> getLanguage() {
    return language;
  }

  /**
   * Languages of the resource. Recommended best practice is to use a controlled vocabulary such as RFC 4646 [RFC4646].
   *
   * @param language Languages of the resource. Recommended best practice is to use a controlled vocabulary such as RFC 4646 [RFC4646].
   * @link http://dublincore.org/documents/dcmi-terms/#terms-language
   */
  @JsonProperty ("languages")
  public void setLanguage(List<RDFValue> language) {
    this.language = language;
  }

  /**
   * Legal documents giving official permission to do something with the resource.
   *
   * @return Legal documents giving official permission to do something with the resource.
   * @link http://dublincore.org/documents/dcmi-terms/#terms-license
   */
  @JsonName ("licenses")
  @JsonProperty ("licenses")
  public List<RDFValue> getLicense() {
    return license;
  }

  /**
   * Legal documents giving official permission to do something with the resource.
   *
   * @param license Legal documents giving official permission to do something with the resource.
   * @link http://dublincore.org/documents/dcmi-terms/#terms-license
   */
  @JsonProperty ("licenses")
  public void setLicense(List<RDFValue> license) {
    this.license = license;
  }

  /**
   * Entities that mediate access to the resource and for whom the resource is intended or useful.
   *
   * @return Entities that mediate access to the resource and for whom the resource is intended or useful.
   * @link http://dublincore.org/documents/dcmi-terms/#terms-mediator
   */
  @JsonName ("mediators")
  @JsonProperty ("mediators")
  public List<RDFValue> getMediator() {
    return mediator;
  }

  /**
   * Entities that mediate access to the resource and for whom the resource is intended or useful.
   *
   * @param mediator Entities that mediate access to the resource and for whom the resource is intended or useful.
   * @link http://dublincore.org/documents/dcmi-terms/#terms-mediator
   */
  @JsonProperty ("mediators")
  public void setMediator(List<RDFValue> mediator) {
    this.mediator = mediator;
  }

  /**
   * The material or physical carrier of the resource.
   *
   * @return The material or physical carrier of the resource.
   * @link http://dublincore.org/documents/dcmi-terms/#terms-medium
   */
  public RDFValue getMedium() {
    return medium;
  }

  /**
   * The material or physical carrier of the resource.
   *
   * @param medium The material or physical carrier of the resource.
   * @link http://dublincore.org/documents/dcmi-terms/#terms-medium
   */
  public void setMedium(RDFValue medium) {
    this.medium = medium;
  }

  /**
   * Date on which the resource was changed.
   *
   * @return Date on which the resource was changed.
   * @link http://dublincore.org/documents/dcmi-terms/#terms-modified
   */
  public Date getModified() {
    return modified;
  }

  /**
   * Date on which the resource was changed.
   *
   * @param modified Date on which the resource was changed.
   * @link http://dublincore.org/documents/dcmi-terms/#terms-modified
   */
  public void setModified(Date modified) {
    this.modified = modified;
  }

  /**
   * A statement of any changes in ownership and custody of the resource since its creation that are significant for its authenticity, integrity, and interpretation.
   *
   * @return A statement of any changes in ownership and custody of the resource since its creation that are significant for its authenticity, integrity, and interpretation.
   * @link http://dublincore.org/documents/dcmi-terms/#terms-provenance
   */
  public RDFValue getProvenance() {
    return provenance;
  }

  /**
   * A statement of any changes in ownership and custody of the resource since its creation that are significant for its authenticity, integrity, and interpretation.
   *
   * @param provenance A statement of any changes in ownership and custody of the resource since its creation that are significant for its authenticity, integrity, and interpretation.
   * @link http://dublincore.org/documents/dcmi-terms/#terms-provenance
   */
  public void setProvenance(RDFValue provenance) {
    this.provenance = provenance;
  }

  /**
   * An entity responsible for making the resource available.
   *
   * @return An entity responsible for making the resource available.
   * @link http://dublincore.org/documents/dcmi-terms/#terms-publisher
   */
  public RDFValue getPublisher() {
    return publisher;
  }

  /**
   * An entity responsible for making the resource available.
   *
   * @param publisher An entity responsible for making the resource available.
   * @link http://dublincore.org/documents/dcmi-terms/#terms-publisher
   */
  public void setPublisher(RDFValue publisher) {
    this.publisher = publisher;
  }

  /**
   * Related resources that are referenced, cited, or otherwise pointed to by the described resource.
   *
   * @return Related resources that are referenced, cited, or otherwise pointed to by the described resource.
   * @link http://dublincore.org/documents/dcmi-terms/#terms-references
   */
  @SuppressWarnings("gedcomx:plural_xml_name")
  public List<RDFValue> getReferences() {
    return references;
  }

  /**
   * Related resources that are referenced, cited, or otherwise pointed to by the described resource.
   *
   * @param references Related resources that are referenced, cited, or otherwise pointed to by the described resource.
   * @link http://dublincore.org/documents/dcmi-terms/#terms-references
   */
  public void setReferences(List<RDFValue> references) {
    this.references = references;
  }

  /**
   * Related resources.
   *
   * @return Related resources.
   * @link http://dublincore.org/documents/dcmi-terms/#terms-relation
   */
  @JsonName ("relations")
  @JsonProperty ("relations")
  public List<RDFValue> getRelation() {
    return relation;
  }

  /**
   * Related resources.
   *
   * @param relation Related resources.
   * @link http://dublincore.org/documents/dcmi-terms/#terms-relation
   */
  @JsonProperty ("relations")
  public void setRelation(List<RDFValue> relation) {
    this.relation = relation;
  }

  /**
   * Related resources that are supplanted, displaced, or superseded by the described resource.
   *
   * @return Related resources that are supplanted, displaced, or superseded by the described resource.
   * @link http://dublincore.org/documents/dcmi-terms/#terms-replaces
   */
  @SuppressWarnings("gedcomx:plural_xml_name")
  public List<RDFValue> getReplaces() {
    return replaces;
  }

  /**
   * Related resources that are supplanted, displaced, or superseded by the described resource.
   *
   * @param replaces Related resources that are supplanted, displaced, or superseded by the described resource.
   * @link http://dublincore.org/documents/dcmi-terms/#terms-replaces
   */
  public void setReplaces(List<RDFValue> replaces) {
    this.replaces = replaces;
  }

  /**
   * Related resources that are required by the described resource to support its function, delivery, or coherence.
   *
   * @return Related resources that are required by the described resource to support its function, delivery, or coherence.
   * @link http://dublincore.org/documents/dcmi-terms/#terms-requires
   */
  @SuppressWarnings("gedcomx:plural_xml_name")
  public List<RDFValue> getRequires() {
    return requires;
  }

  /**
   * Related resources that are required by the described resource to support its function, delivery, or coherence.
   *
   * @param requires Related resources that are required by the described resource to support its function, delivery, or coherence.
   * @link http://dublincore.org/documents/dcmi-terms/#terms-requires
   */
  public void setRequires(List<RDFValue> requires) {
    this.requires = requires;
  }

  /**
   * Information about rights held in and over the resource.
   *
   * @return Information about rights held in and over the resource.
   * @link http://dublincore.org/documents/dcmi-terms/#terms-rights
   */
  @SuppressWarnings("gedcomx:plural_xml_name")
  public List<RDFValue> getRights() {
    return rights;
  }

  /**
   * Information about rights held in and over the resource.
   *
   * @param rights Information about rights held in and over the resource.
   * @link http://dublincore.org/documents/dcmi-terms/#terms-rights
   */
  public void setRights(List<RDFValue> rights) {
    this.rights = rights;
  }

  /**
   * A person or organization owning or managing rights over the resource.
   *
   * @return A person or organization owning or managing rights over the resource.
   * @link http://dublincore.org/documents/dcmi-terms/#terms-rightsHolder
   */
  public RDFValue getRightsHolder() {
    return rightsHolder;
  }

  /**
   * A person or organization owning or managing rights over the resource.
   *
   * @param rightsHolder A person or organization owning or managing rights over the resource.
   * @link http://dublincore.org/documents/dcmi-terms/#terms-rightsHolder
   */
  public void setRightsHolder(RDFValue rightsHolder) {
    this.rightsHolder = rightsHolder;
  }

  /**
   * A related resource from which the described resource is derived.
   *
   * @return A related resource from which the described resource is derived.
   * @link http://dublincore.org/documents/dcmi-terms/#terms-source
   */
  @JsonName ("sources")
  @JsonProperty ("sources")
  public List<RDFValue> getSource() {
    return source;
  }

  /**
   * A related resource from which the described resource is derived.
   *
   * @param source A related resource from which the described resource is derived.
   * @link http://dublincore.org/documents/dcmi-terms/#terms-source
   */
  @JsonProperty ("sources")
  public void setSource(List<RDFValue> source) {
    this.source = source;
  }

  /**
   * Spatial characteristics of the resource.
   *
   * @return Spatial characteristics of the resource.
   * @see #getCoverage()
   * @link http://dublincore.org/documents/dcmi-terms/#terms-spatial
   */
  @JsonName ("spatials")
  @JsonProperty ("spatials")
  public List<RDFValue> getSpatial() {
    return spatial;
  }

  /**
   * Spatial characteristics of the resource.
   *
   * @param spatial Spatial characteristics of the resource.
   * @see #getCoverage()
   * @link http://dublincore.org/documents/dcmi-terms/#terms-spatial
   */
  @JsonProperty ("spatials")
  public void setSpatial(List<RDFValue> spatial) {
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
  @JsonName ("subjects")
  @JsonProperty ("subjects")
  public List<RDFValue> getSubject() {
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
  @JsonProperty ("subjects")
  public void setSubject(List<RDFValue> subject) {
    this.subject = subject;
  }

  /**
   * A list of subunits of the resource.
   *
   * @return A list of subunits of the resource.
   * @link http://dublincore.org/documents/dcmi-terms/#terms-tableOfContents
   */
  @SuppressWarnings("gedcomx:plural_xml_name")
  public RDFValue getTableOfContents() {
    return tableOfContents;
  }

  /**
   * A list of subunits of the resource.
   *
   * @param tableOfContents A list of subunits of the resource.
   * @link http://dublincore.org/documents/dcmi-terms/#terms-tableOfContents
   */
  public void setTableOfContents(RDFValue tableOfContents) {
    this.tableOfContents = tableOfContents;
  }

  /**
   * Temporal characteristics of the resource.
   *
   * @return Temporal characteristics of the resource.
   * @link http://dublincore.org/documents/dcmi-terms/#terms-temporal
   */
  @JsonName ("temporals")
  @JsonProperty ("temporals")
  public List<RDFValue> getTemporal() {
    return temporal;
  }

  /**
   * Temporal characteristics of the resource.
   *
   * @param temporal Temporal characteristics of the resource.
   * @link http://dublincore.org/documents/dcmi-terms/#terms-temporal
   */
  @JsonProperty ("temporals")
  public void setTemporal(List<RDFValue> temporal) {
    this.temporal = temporal;
  }

  /**
   * A name given to the resource.
   *
   * @return A name given to the resource.
   * @link http://dublincore.org/documents/dcmi-terms/#terms-title
   */
  public RDFLiteral getTitle() {
    return title;
  }

  /**
   * A name given to the resource.
   *
   * @param title A name given to the resource.
   * @link http://dublincore.org/documents/dcmi-terms/#terms-title
   */
  public void setTitle(RDFLiteral title) {
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
  public QName getType() {
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
  public void setType(QName type) {
    this.type = type;
  }

  /**
   * Get the type from an enumeration of known types, or null if unknown.
   *
   * @return The type from an enumeration of known types, or null if unknown.
   */
  @XmlTransient
  @JsonIgnore
  public DublinCoreType getKnownType() {
    return XmlQNameEnumUtil.fromQName(getType(), DublinCoreType.class);
  }

  /**
   * Set the type from a known enumeration of Dublin Core types.
   *
   * @param knownType The type.
   */
  @JsonIgnore
  public void setKnownType(DublinCoreType knownType) {
    setType(XmlQNameEnumUtil.toQName(knownType));
  }

  /**
   * Date of validity of a resource.
   *
   * @return Date of validity of a resource.
   * @link http://dublincore.org/documents/dcmi-terms/#terms-valid
   */
  @SuppressWarnings("gedcomx:non_plural_json_name")
  public List<RDFValue> getValid() {
    return valid;
  }

  /**
   * Date of validity of a resource.
   *
   * @param valid Date of validity of a resource.
   * @link http://dublincore.org/documents/dcmi-terms/#terms-valid
   */
  public void setValid(List<RDFValue> valid) {
    this.valid = valid;
  }
}

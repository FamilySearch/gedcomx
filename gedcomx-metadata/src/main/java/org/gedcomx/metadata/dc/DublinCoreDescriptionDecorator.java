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
package org.gedcomx.metadata.dc;

import org.gedcomx.common.URI;
import org.gedcomx.metadata.rdf.Description;
import org.gedcomx.metadata.rdf.RDFLiteral;
import org.gedcomx.metadata.rdf.RDFValue;
import org.gedcomx.rt.CommonModels;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlTransient;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * A decorator for a description that uses dublin core terms.
 *
 * @author Ryan Heaton
 */
@XmlTransient
public class DublinCoreDescriptionDecorator {

  private static final ObjectFactory OBJECT_FACTORY = new ObjectFactory();

  private final Description description;

  /**
   * Create a new decorator with an empty description.
   *
   * @return The decorator.
   */
  public static DublinCoreDescriptionDecorator newInstance() {
    return new DublinCoreDescriptionDecorator();
  }

  /**
   * Create a new decorator from an existing description. New terms will be appended to the description.
   *
   * @return The description.
   * 
   */
  public static DublinCoreDescriptionDecorator newInstance(Description description) {
    return new DublinCoreDescriptionDecorator(description);
  }

  private DublinCoreDescriptionDecorator() {
    this(new Description());
  }

  private DublinCoreDescriptionDecorator(Description description) {
    this.description = description;
  }

  /**
   * Get the description being decorated.
   *
   * @return The description being decorated.
   */
  public Description getDecoratedDescription() {
    return description;
  }

  /**
   * The URI of the resource being described.
   *
   * @param uri The URI of the resource being described.
   * @return this builder.
   */
  public DublinCoreDescriptionDecorator about(URI uri) {
    this.description.setAbout(uri);
    return this;
  }

  /**
   * The URI of the resource being described.
   *
   * @return The URI of the resource being described.
   */
  public URI getAbout() {
    return this.description.getAbout();
  }

  /**
   * The id of the description.
   *
   * @param id The id of the description.
   * @return this builder.
   */
  public DublinCoreDescriptionDecorator id(String id) {
    this.description.setId(id);
    return this;
  }

  /**
   * The id of the description.
   *
   * @return The id of the description.
   */
  public String getId() {
    return this.description.getId();
  }

  /**
   * A summary of the resource.
   *
   * @return A summary of the resource.
   * 
   * @link http://dublincore.org/documents/dcmi-terms/#terms-abstract
   */
  public DublinCoreDescriptionDecorator abstrct(RDFValue abstrct) {
    this.description.addExtensionElement(OBJECT_FACTORY.createAbstractElement(abstrct));
    return this;
  }

  /**
   * Information about who can access the resource or an indication of its security status. Access Rights may include information
   * regarding access or restrictions based on privacy, security, or other policies.
   *
   * @return Information about who can access the resource or an indication of its security status. Access Rights may include information
   *                     regarding access or restrictions based on privacy, security, or other policies.
   * 
   * @link http://dublincore.org/documents/dcmi-terms/#terms-accessRights
   */
  public DublinCoreDescriptionDecorator accessRights(RDFValue accessRights) {
    this.description.addExtensionElement(OBJECT_FACTORY.createAccessRightsElement(accessRights));
    return this;
  }

  /**
   * The method by which items are added to a collection.
   *
   * @return The method by which items are added to a collection.
   * 
   * @link http://dublincore.org/documents/dcmi-terms/#terms-accrualMethod
   */
  public DublinCoreDescriptionDecorator accrualMethod(RDFValue accrualMethod) {
    this.description.addExtensionElement(OBJECT_FACTORY.createAccrualMethodElement(accrualMethod));
    return this;
  }

  /**
   * The frequency with which items are added to a collection.
   *
   * @return The frequency with which items are added to a collection.
   * 
   * @link http://dublincore.org/documents/dcmi-terms/#terms-accrualPeriodicity
   */
  public DublinCoreDescriptionDecorator accrualPeriodicity(RDFValue accrualPeriodicity) {
    this.description.addExtensionElement(OBJECT_FACTORY.createAccrualPeriodicityElement(accrualPeriodicity));
    return this;
  }

  /**
   * The policy governing the addition of items to a collection.
   *
   * @return The policy governing the addition of items to a collection.
   * 
   * @link http://dublincore.org/documents/dcmi-terms/#terms-accrualPolicy
   */
  public DublinCoreDescriptionDecorator accrualPolicy(RDFValue accrualPolicy) {
    this.description.addExtensionElement(OBJECT_FACTORY.createAccrualPolicyElement(accrualPolicy));
    return this;
  }

  /**
   * Alternative names for the resource. The distinction between titles and alternative titles is application-specific.
   *
   * @return Alternative names for the resource. The distinction between titles and alternative titles is application-specific.
   * 
   * @link http://dublincore.org/documents/dcmi-terms/#terms-alternative
   */
  public DublinCoreDescriptionDecorator alternative(RDFLiteral alternative) {
    this.description.addExtensionElement(OBJECT_FACTORY.createAlternativeElement(alternative));
    return this;
  }

  /**
   * A class of entity for whom the resource is intended or useful.
   *
   * @return A class of entity for whom the resource is intended or useful.
   * 
   * @link http://dublincore.org/documents/dcmi-terms/#terms-audience
   */
  public DublinCoreDescriptionDecorator audience(RDFValue audience) {
    this.description.addExtensionElement(OBJECT_FACTORY.createAudienceElement(audience));
    return this;
  }

  /**
   * Date that the resource became or will become available.
   *
   * @return Date that the resource became or will become available.
   *
   * @link http://dublincore.org/documents/dcmi-terms/#terms-available
   */
  public DublinCoreDescriptionDecorator available(Date available) {
    this.description.addExtensionElement(OBJECT_FACTORY.createAvailableElement(new RDFLiteral(available)));
    return this;
  }

  /**
   * Date that the resource became or will become available.
   *
   * @return Date that the resource became or will become available.
   *
   * @link http://dublincore.org/documents/dcmi-terms/#terms-available
   */
  public DublinCoreDescriptionDecorator available(String available) {
    this.description.addExtensionElement(OBJECT_FACTORY.createAvailableElement(new RDFLiteral(available)));
    return this;
  }

  /**
   * A bibliographic reference for the resource. Recommended practice is to include sufficient
   * bibliographic detail to identify the resource as unambiguously as possible.
   *
   * @return A bibliographic reference for the resource. Recommended practice is to include sufficient
   *                              bibliographic detail to identify the resource as unambiguously as possible.
   * 
   * @link http://dublincore.org/documents/dcmi-terms/#terms-bibliographicCitation
   */
  public DublinCoreDescriptionDecorator bibliographicCitation(RDFLiteral bibliographicCitation) {
    this.description.addExtensionElement(OBJECT_FACTORY.createBibliographicCitationElement(bibliographicCitation));
    return this;
  }

  /**
   * Established standards to which the described resource conforms.
   *
   * @return Established standards to which the described resource conforms.
   * 
   * @link http://dublincore.org/documents/dcmi-terms/#terms-conformsTo
   */
  public DublinCoreDescriptionDecorator conformsTo(RDFValue conformsTo) {
    this.description.addExtensionElement(OBJECT_FACTORY.createConformsToElement(conformsTo));
    return this;
  }

  /**
   * Entities responsible for making contributions to the resource. Examples of a Contributor include a person, an organization, or a service.
   *
   * @return Entities responsible for making contributions to the resource. Examples of a Contributor include a person, an organization, or a service.
   * 
   * @link http://dublincore.org/documents/dcmi-terms/#terms-contributor
   */
  public DublinCoreDescriptionDecorator contributor(RDFValue contributor) {
    this.description.addExtensionElement(OBJECT_FACTORY.createContributorElement(contributor));
    return this;
  }

  /**
   * The spatial or temporal topic of the resource, the spatial applicability of the resource, or the jurisdiction under which the resource is relevant.
   *
   * @return The spatial or temporal topic of the resource, the spatial applicability of the resource, or the jurisdiction under which the resource is relevant.
   * 
   * @link http://dublincore.org/documents/dcmi-terms/#terms-coverage
   */
  public DublinCoreDescriptionDecorator coverage(RDFValue coverage) {
    this.description.addExtensionElement(OBJECT_FACTORY.createCoverageElement(coverage));
    return this;
  }

  /**
   * Date of creation of the resource.
   *
   * @return Date of creation of the resource.
   *
   * @link http://dublincore.org/documents/dcmi-terms/#terms-created
   */
  public DublinCoreDescriptionDecorator created(Date created) {
    this.description.addExtensionElement(OBJECT_FACTORY.createCreatedElement(new RDFLiteral(created)));
    return this;
  }

  /**
   * Date of creation of the resource.
   *
   * @return Date of creation of the resource.
   *
   * @link http://dublincore.org/documents/dcmi-terms/#terms-created
   */
  public DublinCoreDescriptionDecorator created(String created) {
    this.description.addExtensionElement(OBJECT_FACTORY.createCreatedElement(new RDFLiteral(created)));
    return this;
  }

  /**
   * Entities primarily responsible for making the resource.
   *
   * @return Entities primarily responsible for making the resource.
   * 
   * @link http://dublincore.org/documents/dcmi-terms/#terms-creator
   */
  public DublinCoreDescriptionDecorator creator(RDFValue creator) {
    this.description.addExtensionElement(OBJECT_FACTORY.createCreatorElement(creator));
    return this;
  }

  /**
   * A point or period of time associated with an event in the lifecycle of the resource.
   *
   * @return A point or period of time associated with an event in the lifecycle of the resource.
   * 
   * @link http://dublincore.org/documents/dcmi-terms/#terms-date
   */
  public DublinCoreDescriptionDecorator date(Date date) {
    this.description.addExtensionElement(OBJECT_FACTORY.createDateElement(new RDFLiteral(date)));
    return this;
  }

  /**
   * A point or period of time associated with an event in the lifecycle of the resource.
   *
   * @return A point or period of time associated with an event in the lifecycle of the resource.
   *
   * @link http://dublincore.org/documents/dcmi-terms/#terms-date
   */
  public DublinCoreDescriptionDecorator date(String date) {
    this.description.addExtensionElement(OBJECT_FACTORY.createDateElement(new RDFLiteral(date)));
    return this;
  }

  /**
   * Date of acceptance of the resource.
   *
   * @return Date of acceptance of the resource.
   * 
   * @link http://dublincore.org/documents/dcmi-terms/#terms-dateAccepted
   */
  public DublinCoreDescriptionDecorator dateAccepted(Date dateAccepted) {
    this.description.addExtensionElement(OBJECT_FACTORY.createDateAcceptedElement(new RDFLiteral(dateAccepted)));
    return this;
  }

  /**
   * Date of acceptance of the resource.
   *
   * @return Date of acceptance of the resource.
   *
   * @link http://dublincore.org/documents/dcmi-terms/#terms-dateAccepted
   */
  public DublinCoreDescriptionDecorator dateAccepted(String dateAccepted) {
    this.description.addExtensionElement(OBJECT_FACTORY.createDateAcceptedElement(new RDFLiteral(dateAccepted)));
    return this;
  }

  /**
   * Date of copyright.
   *
   * @return Date of copyright.
   * 
   * @link http://dublincore.org/documents/dcmi-terms/#terms-dateCopyrighted
   */
  public DublinCoreDescriptionDecorator dateCopyrighted(Date dateCopyrighted) {
    this.description.addExtensionElement(OBJECT_FACTORY.createDateCopyrightedElement(new RDFLiteral(dateCopyrighted)));
    return this;
  }

  /**
   * Date of copyright.
   *
   * @return Date of copyright.
   *
   * @link http://dublincore.org/documents/dcmi-terms/#terms-dateCopyrighted
   */
  public DublinCoreDescriptionDecorator dateCopyrighted(String dateCopyrighted) {
    this.description.addExtensionElement(OBJECT_FACTORY.createDateCopyrightedElement(new RDFLiteral(dateCopyrighted)));
    return this;
  }

  /**
   * Date of submission of the resource.
   *
   * @return Date of submission of the resource.
   * 
   * @link http://dublincore.org/documents/dcmi-terms/#terms-dateSubmitted
   */
  public DublinCoreDescriptionDecorator dateSubmitted(Date dateSubmitted) {
    this.description.addExtensionElement(OBJECT_FACTORY.createDateSubmittedElement(new RDFLiteral(dateSubmitted)));
    return this;
  }

  /**
   * Date of submission of the resource.
   *
   * @return Date of submission of the resource.
   *
   * @link http://dublincore.org/documents/dcmi-terms/#terms-dateSubmitted
   */
  public DublinCoreDescriptionDecorator dateSubmitted(String dateSubmitted) {
    this.description.addExtensionElement(OBJECT_FACTORY.createDateSubmittedElement(new RDFLiteral(dateSubmitted)));
    return this;
  }

  /**
   * An account of the resource.
   *
   * @return An account of the resource.
   * 
   * @link http://dublincore.org/documents/dcmi-terms/#terms-description
   */
  public DublinCoreDescriptionDecorator description(RDFValue description) {
    this.description.addExtensionElement(OBJECT_FACTORY.createDescriptionElement(description));
    return this;
  }

  /**
   * A class of entity, defined in terms of progression through an educational or training context, for which the described resource is intended.
   *
   * @return A class of entity, defined in terms of progression through an educational or training context, for which the described resource is intended.
   * 
   * @link http://dublincore.org/documents/dcmi-terms/#terms-educationLevel
   */
  public DublinCoreDescriptionDecorator educationLevel(RDFValue educationLevel) {
    this.description.addExtensionElement(OBJECT_FACTORY.createEducationLevelElement(educationLevel));
    return this;
  }

  /**
   * The size or duration of the resource.
   *
   * @return The size or duration of the resource.
   * 
   * @link http://dublincore.org/documents/dcmi-terms/#terms-extent
   */
  public DublinCoreDescriptionDecorator extent(RDFValue extent) {
    this.description.addExtensionElement(OBJECT_FACTORY.createExtentElement(extent));
    return this;
  }

  /**
   * The file format, physical medium, or dimensions of the resource. Examples of dimensions include size and duration. Recommended best practice is
   * to use a controlled vocabulary such as the list of Internet Media Types [MIME].
   *
   * @return The file format, physical medium, or dimensions of the resource. Examples of dimensions include size and duration. Recommended best practice is to
   *               use a controlled vocabulary such as the list of Internet Media Types [MIME].
   * 
   * @link http://dublincore.org/documents/dcmi-terms/#terms-format
   */
  public DublinCoreDescriptionDecorator format(RDFValue format) {
    this.description.addExtensionElement(OBJECT_FACTORY.createFormatElement(format));
    return this;
  }

  /**
   * List of alternate formats of the pre-existing described resource. In REST terms, a list of the alternate "representations" that are available
   * for the described resource, probably in terms of the MIME type. If the alternate representations of the resource are accessed at
   * a different URI (bad practice, but an accepted reality), use a custom "href" attribute instead of the
   * {http://www.w3.org/1999/02/22-rdf-syntax-ns#}resource attribute.
   *
   * @return Alternate formats of the described resource.
   * 
   * @link http://dublincore.org/documents/dcmi-terms/#terms-hasFormat
   */
  public DublinCoreDescriptionDecorator hasFormat(RDFValue hasFormat) {
    this.description.addExtensionElement(OBJECT_FACTORY.createHasFormatElement(hasFormat));
    return this;
  }

  /**
   * Related resources that are included either physically or logically in the described resource.
   *
   * @return Related resources that are included either physically or logically in the described resource.
   * 
   * @link http://dublincore.org/documents/dcmi-terms/#terms-hasPart
   */
  public DublinCoreDescriptionDecorator hasPart(RDFValue hasPart) {
    this.description.addExtensionElement(OBJECT_FACTORY.createHasPartElement(hasPart));
    return this;
  }

  /**
   * Related resources that are a version, edition, or adaptation of the described resource.
   *
   * @return Related resources that are a version, edition, or adaptation of the described resource.
   * 
   * @link http://dublincore.org/documents/dcmi-terms/#terms-hasVersion
   */
  public DublinCoreDescriptionDecorator hasVersion(RDFValue hasVersion) {
    this.description.addExtensionElement(OBJECT_FACTORY.createHasVersionElement(hasVersion));
    return this;
  }

  /**
   * An unambiguous reference to the resource within a given context.
   *
   * @return An unambiguous reference to the resource within a given context.
   * 
   * @link http://dublincore.org/documents/dcmi-terms/#terms-identifier
   */
  public DublinCoreDescriptionDecorator identifier(RDFLiteral identifier) {
    this.description.addExtensionElement(OBJECT_FACTORY.createIdentifierElement(identifier));
    return this;
  }

  /**
   * A process, used to engender knowledge, attitudes and skills, that the described resource is designed to support.
   *
   * @return A process, used to engender knowledge, attitudes and skills, that the described resource is designed to support.
   * 
   * @link http://dublincore.org/documents/dcmi-terms/#terms-instructionalMethod
   */
  public DublinCoreDescriptionDecorator instructionalMethod(RDFValue instructionalMethod) {
    this.description.addExtensionElement(OBJECT_FACTORY.createInstructionalMethodElement(instructionalMethod));
    return this;
  }

  /**
   * Related resources that are substantially the same as the described resource, but in another format. In REST terms, the URI of
   * an alternate representation of the same resource. Note that having more than one URI for the same resource is generally bad
   * practice (see http://www.w3.org/TR/webarch/) but still an accepted reality.
   *
   * @return Related resources that are substantially the same as the described resource, but in another format.
   * 
   * @link http://dublincore.org/documents/dcmi-terms/#terms-isFormatOf
   */
  public DublinCoreDescriptionDecorator formatOf(RDFValue formatOf) {
    this.description.addExtensionElement(OBJECT_FACTORY.createIsFormatOfElement(formatOf));
    return this;
  }

  /**
   * Related resources in which the described resource is physically or logically included.
   *
   * @return Related resources in which the described resource is physically or logically included.
   * 
   * @link http://dublincore.org/documents/dcmi-terms/#terms-isPartOf
   */
  public DublinCoreDescriptionDecorator partOf(RDFValue partOf) {
    this.description.addExtensionElement(OBJECT_FACTORY.createIsPartOfElement(partOf));
    return this;
  }

  /**
   * Related resources that reference, cite, or otherwise point to the described resource.
   *
   * @return Related resources that reference, cite, or otherwise point to the described resource.
   * 
   * @link http://dublincore.org/documents/dcmi-terms/#terms-isReferencedBy
   */
  public DublinCoreDescriptionDecorator referencedBy(RDFValue referencedBy) {
    this.description.addExtensionElement(OBJECT_FACTORY.createIsReferencedByElement(referencedBy));
    return this;
  }

  /**
   * Related resources that supplant, displace, or supersede the described resource.
   *
   * @return Related resources that supplant, displace, or supersede the described resource.
   * 
   * @link http://dublincore.org/documents/dcmi-terms/#terms-isReplacedBy
   */
  public DublinCoreDescriptionDecorator replacedBy(RDFValue replacedBy) {
    this.description.addExtensionElement(OBJECT_FACTORY.createIsReplacedByElement(replacedBy));
    return this;
  }

  /**
   * Related resources that require the described resource to support its function, delivery, or coherence.
   *
   * @return Related resources that require the described resource to support its function, delivery, or coherence.
   * 
   * @link http://dublincore.org/documents/dcmi-terms/#terms-isRequiredBy
   */
  public DublinCoreDescriptionDecorator requiredBy(RDFValue requiredBy) {
    this.description.addExtensionElement(OBJECT_FACTORY.createIsRequiredByElement(requiredBy));
    return this;
  }

  /**
   * Date of formal issuance (e.g., publication) of the resource.
   *
   * @return Date of formal issuance (e.g., publication) of the resource.
   * 
   * @link http://dublincore.org/documents/dcmi-terms/#terms-issued
   */
  public DublinCoreDescriptionDecorator issued(Date issued) {
    this.description.addExtensionElement(OBJECT_FACTORY.createIssuedElement(new RDFLiteral(issued)));
    return this;
  }

  /**
   * Date of formal issuance (e.g., publication) of the resource.
   *
   * @return Date of formal issuance (e.g., publication) of the resource.
   *
   * @link http://dublincore.org/documents/dcmi-terms/#terms-issued
   */
  public DublinCoreDescriptionDecorator issued(String issued) {
    this.description.addExtensionElement(OBJECT_FACTORY.createIssuedElement(new RDFLiteral(issued)));
    return this;
  }

  /**
   * A related resource of which the described resource is a version, edition, or adaptation. Changes in version imply substantive changes
   * in content rather than differences in format.
   *
   * @return A related resource of which the described resource is a version, edition, or adaptation. Changes in version imply substantive
   *                  changes in content rather than differences in format.
   * 
   * @link http://dublincore.org/documents/dcmi-terms/#terms-isVersionOf
   */
  public DublinCoreDescriptionDecorator versionOf(RDFValue versionOf) {
    this.description.addExtensionElement(OBJECT_FACTORY.createIsVersionOfElement(versionOf));
    return this;
  }

  /**
   * Languages of the resource. Recommended best practice is to use a controlled vocabulary such as RFC 4646 [RFC4646].
   *
   * @return Languages of the resource. Recommended best practice is to use a controlled vocabulary such as RFC 4646 [RFC4646].
   * 
   * @link http://dublincore.org/documents/dcmi-terms/#terms-language
   */
  public DublinCoreDescriptionDecorator language(RDFValue language) {
    this.description.addExtensionElement(OBJECT_FACTORY.createLanguageElement(language));
    return this;
  }

  /**
   * Legal documents giving official permission to do something with the resource.
   *
   * @return Legal documents giving official permission to do something with the resource.
   * 
   * @link http://dublincore.org/documents/dcmi-terms/#terms-license
   */
  public DublinCoreDescriptionDecorator license(RDFValue license) {
    this.description.addExtensionElement(OBJECT_FACTORY.createLicenseElement(license));
    return this;
  }

  /**
   * Entities that mediate access to the resource and for whom the resource is intended or useful.
   *
   * @return Entities that mediate access to the resource and for whom the resource is intended or useful.
   * 
   * @link http://dublincore.org/documents/dcmi-terms/#terms-mediator
   */
  public DublinCoreDescriptionDecorator mediator(RDFValue mediator) {
    this.description.addExtensionElement(OBJECT_FACTORY.createMediatorElement(mediator));
    return this;
  }

  /**
   * The material or physical carrier of the resource.
   *
   * @return The material or physical carrier of the resource.
   * 
   * @link http://dublincore.org/documents/dcmi-terms/#terms-medium
   */
  public DublinCoreDescriptionDecorator medium(RDFValue medium) {
    this.description.addExtensionElement(OBJECT_FACTORY.createMediumElement(medium));
    return this;
  }

  /**
   * Date on which the resource was changed.
   *
   * @return Date on which the resource was changed.
   * 
   * @link http://dublincore.org/documents/dcmi-terms/#terms-modified
   */
  public DublinCoreDescriptionDecorator modified(Date modified) {
    this.description.addExtensionElement(OBJECT_FACTORY.createModifiedElement(new RDFLiteral(modified)));
    return this;
  }

  /**
   * Date on which the resource was changed.
   *
   * @return Date on which the resource was changed.
   *
   * @link http://dublincore.org/documents/dcmi-terms/#terms-modified
   */
  public DublinCoreDescriptionDecorator modified(String modified) {
    this.description.addExtensionElement(OBJECT_FACTORY.createModifiedElement(new RDFLiteral(modified)));
    return this;
  }

  /**
   * A statement of any changes in ownership and custody of the resource since its creation that are significant for its authenticity, integrity, and interpretation.
   *
   * @return A statement of any changes in ownership and custody of the resource since its creation that are significant for its authenticity, integrity, and interpretation.
   * 
   * @link http://dublincore.org/documents/dcmi-terms/#terms-provenance
   */
  public DublinCoreDescriptionDecorator provenance(RDFValue provenance) {
    this.description.addExtensionElement(OBJECT_FACTORY.createProvenanceElement(provenance));
    return this;
  }

  /**
   * An entity responsible for making the resource available.
   *
   * @return An entity responsible for making the resource available.
   * 
   * @link http://dublincore.org/documents/dcmi-terms/#terms-publisher
   */
  public DublinCoreDescriptionDecorator publisher(RDFValue publisher) {
    this.description.addExtensionElement(OBJECT_FACTORY.createPublisherElement(publisher));
    return this;
  }

  /**
   * Related resources that are referenced, cited, or otherwise pointed to by the described resource.
   *
   * @return Related resources that are referenced, cited, or otherwise pointed to by the described resource.
   * 
   * @link http://dublincore.org/documents/dcmi-terms/#terms-references
   */
  public DublinCoreDescriptionDecorator references(RDFValue references) {
    this.description.addExtensionElement(OBJECT_FACTORY.createReferencesElement(references));
    return this;
  }

  /**
   * Related resources.
   *
   * @return Related resources.
   * 
   * @link http://dublincore.org/documents/dcmi-terms/#terms-relation
   */
  public DublinCoreDescriptionDecorator relation(RDFValue relation) {
    this.description.addExtensionElement(OBJECT_FACTORY.createRelationElement(relation));
    return this;
  }

  /**
   * Related resources that are supplanted, displaced, or superseded by the described resource.
   *
   * @return Related resources that are supplanted, displaced, or superseded by the described resource.
   * 
   * @link http://dublincore.org/documents/dcmi-terms/#terms-replaces
   */
  public DublinCoreDescriptionDecorator replaces(RDFValue replaces) {
    this.description.addExtensionElement(OBJECT_FACTORY.createReplacesElement(replaces));
    return this;
  }

  /**
   * Related resources that are required by the described resource to support its function, delivery, or coherence.
   *
   * @return Related resources that are required by the described resource to support its function, delivery, or coherence.
   * 
   * @link http://dublincore.org/documents/dcmi-terms/#terms-requires
   */
  public DublinCoreDescriptionDecorator requires(RDFValue requires) {
    this.description.addExtensionElement(OBJECT_FACTORY.createRequiresElement(requires));
    return this;
  }

  /**
   * Information about rights held in and over the resource.
   *
   * @return Information about rights held in and over the resource.
   * 
   * @link http://dublincore.org/documents/dcmi-terms/#terms-rights
   */
  public DublinCoreDescriptionDecorator rights(RDFValue rights) {
    this.description.addExtensionElement(OBJECT_FACTORY.createRightsElement(rights));
    return this;
  }

  /**
   * A person or organization owning or managing rights over the resource.
   *
   * @return A person or organization owning or managing rights over the resource.
   * 
   * @link http://dublincore.org/documents/dcmi-terms/#terms-rightsHolder
   */
  public DublinCoreDescriptionDecorator rightsHolder(RDFValue rightsHolder) {
    this.description.addExtensionElement(OBJECT_FACTORY.createRightsHolderElement(rightsHolder));
    return this;
  }

  /**
   * A related resource from which the described resource is derived.
   *
   * @return A related resource from which the described resource is derived.
   * 
   * @link http://dublincore.org/documents/dcmi-terms/#terms-source
   */
  public DublinCoreDescriptionDecorator source(RDFValue source) {
    this.description.addExtensionElement(OBJECT_FACTORY.createSourceElement(source));
    return this;
  }

  /**
   * Spatial characteristics of the resource.
   *
   * @return Spatial characteristics of the resource.
   * 
   * @link http://dublincore.org/documents/dcmi-terms/#terms-spatial
   */
  public DublinCoreDescriptionDecorator spatial(RDFValue spatial) {
    this.description.addExtensionElement(OBJECT_FACTORY.createSpatialElement(spatial));
    return this;
  }

  /**
   * The topic of the resource. Typically, the subject will be represented using keywords, key phrases, or classification codes.
   * Recommended best practice is to use a controlled vocabulary. To describe the spatial or temporal topic of the resource,
   * use the Coverage element.
   *
   * @return The topic of the resource. Typically, the subject will be represented using keywords, key phrases, or classification codes.
   *                Recommended best practice is to use a controlled vocabulary. To describe the spatial or temporal topic of the resource,
   *                use the Coverage element.
   * 
   * @link http://dublincore.org/documents/dcmi-terms/#terms-subject
   */
  public DublinCoreDescriptionDecorator subject(RDFValue subject) {
    this.description.addExtensionElement(OBJECT_FACTORY.createSubjectElement(subject));
    return this;
  }

  /**
   * A list of subunits of the resource.
   *
   * @return A list of subunits of the resource.
   * 
   * @link http://dublincore.org/documents/dcmi-terms/#terms-tableOfContents
   */
  public DublinCoreDescriptionDecorator tableOfContents(RDFValue tableOfContents) {
    this.description.addExtensionElement(OBJECT_FACTORY.createTableOfContentsElement(tableOfContents));
    return this;
  }

  /**
   * Temporal characteristics of the resource.
   *
   * @return Temporal characteristics of the resource.
   * 
   * @link http://dublincore.org/documents/dcmi-terms/#terms-temporal
   */
  public DublinCoreDescriptionDecorator temporal(RDFValue temporal) {
    this.description.addExtensionElement(OBJECT_FACTORY.createTemporalElement(temporal));
    return this;
  }

  /**
   * A name given to the resource.
   *
   * @return A name given to the resource.
   * 
   * @link http://dublincore.org/documents/dcmi-terms/#terms-title
   */
  public DublinCoreDescriptionDecorator title(RDFLiteral title) {
    this.description.addExtensionElement(OBJECT_FACTORY.createTitleElement(title));
    return this;
  }

  /**
   * Date of validity of a resource.
   *
   * @return Date of validity of a resource.
   *
   * @link http://dublincore.org/documents/dcmi-terms/#terms-valid
   */
  public DublinCoreDescriptionDecorator valid(Date valid) {
    this.description.addExtensionElement(OBJECT_FACTORY.createValidElement(new RDFLiteral(valid)));
    return this;
  }

  /**
   * Date of validity of a resource.
   *
   * @return Date of validity of a resource.
   *
   * @link http://dublincore.org/documents/dcmi-terms/#terms-valid
   */
  public DublinCoreDescriptionDecorator valid(String valid) {
    this.description.addExtensionElement(OBJECT_FACTORY.createValidElement(new RDFLiteral(valid)));
    return this;
  }

  /**
   * A summary of the resource.
   *
   * @return A summary of the resource.
   * @link http://dublincore.org/documents/dcmi-terms/#terms-abstract
   */
  public List<RDFValue> getAbstract() {
    return findElements("abstract", RDFValue.class);
  }

  /**
   * Information about who can access the resource or an indication of its security status. Access Rights may include information
   * regarding access or restrictions based on privacy, security, or other policies.
   *
   * @return Information about who can access the resource or an indication of its security status. Access Rights may include information
   *                     regarding access or restrictions based on privacy, security, or other policies.
   * 
   * @link http://dublincore.org/documents/dcmi-terms/#terms-accessRights
   */
  public List<RDFValue> getAccessRights() {
    return findElements("accessRights", RDFValue.class);
  }

  /**
   * The method by which items are added to a collection.
   *
   * @return The method by which items are added to a collection.
   * 
   * @link http://dublincore.org/documents/dcmi-terms/#terms-accrualMethod
   */
  public List<RDFValue> getAccrualMethod() {
    return findElements("accrualMethod", RDFValue.class);
  }

  /**
   * The frequency with which items are added to a collection.
   *
   * @return The frequency with which items are added to a collection.
   * 
   * @link http://dublincore.org/documents/dcmi-terms/#terms-accrualPeriodicity
   */
  public List<RDFValue> getAccrualPeriodicity() {
    return findElements("accrualPeriodicity", RDFValue.class);
  }

  /**
   * The policy governing the addition of items to a collection.
   *
   * @return The policy governing the addition of items to a collection.
   * 
   * @link http://dublincore.org/documents/dcmi-terms/#terms-accrualPolicy
   */
  public List<RDFValue> getAccrualPolicy() {
    return findElements("accrualPolicy", RDFValue.class);
  }

  /**
   * Alternative names for the resource. The distinction between titles and alternative titles is application-specific.
   *
   * @return Alternative names for the resource. The distinction between titles and alternative titles is application-specific.
   * 
   * @link http://dublincore.org/documents/dcmi-terms/#terms-alternative
   */
  public List<RDFLiteral> getAlternative() {
    return findElements("alternative", RDFLiteral.class);
  }

  /**
   * A class of entity for whom the resource is intended or useful.
   *
   * @return A class of entity for whom the resource is intended or useful.
   * 
   * @link http://dublincore.org/documents/dcmi-terms/#terms-audience
   */
  public List<RDFValue> getAudience() {
    return findElements("audience", RDFValue.class);
  }

  /**
   * Date that the resource became or will become available.
   *
   * @return Date that the resource became or will become available.
   *
   * @link http://dublincore.org/documents/dcmi-terms/#terms-available
   */
  public List<RDFLiteral> getAvailable() {
    return findElements("available", RDFLiteral.class);
  }

  /**
   * Date that the resource became or will become available.
   *
   * @return Date that the resource became or will become available.
   * 
   * @link http://dublincore.org/documents/dcmi-terms/#terms-available
   */
  public List<Date> getAvailableAsDate() {
    return findElements("available", Date.class);
  }

  /**
   * A bibliographic reference for the resource. Recommended practice is to include sufficient
   * bibliographic detail to identify the resource as unambiguously as possible.
   *
   * @return A bibliographic reference for the resource. Recommended practice is to include sufficient
   *                              bibliographic detail to identify the resource as unambiguously as possible.
   * 
   * @link http://dublincore.org/documents/dcmi-terms/#terms-bibliographicCitation
   */
  public List<RDFLiteral> getBibliographicCitation() {
    return findElements("bibliographicCitation", RDFLiteral.class);
  }

  /**
   * Established standards to which the described resource conforms.
   *
   * @return Established standards to which the described resource conforms.
   * 
   * @link http://dublincore.org/documents/dcmi-terms/#terms-conformsTo
   */
  public List<RDFValue> getConformsTo() {
    return findElements("conformsTo", RDFValue.class);
  }

  /**
   * Entities responsible for making contributions to the resource. Examples of a Contributor include a person, an organization, or a service.
   *
   * @return Entities responsible for making contributions to the resource. Examples of a Contributor include a person, an organization, or a service.
   * 
   * @link http://dublincore.org/documents/dcmi-terms/#terms-contributor
   */
  public List<RDFValue> getContributor() {
    return findElements("contributor", RDFValue.class);
  }

  /**
   * The spatial or temporal topic of the resource, the spatial applicability of the resource, or the jurisdiction under which the resource is relevant.
   *
   * @return The spatial or temporal topic of the resource, the spatial applicability of the resource, or the jurisdiction under which the resource is relevant.
   * 
   * @link http://dublincore.org/documents/dcmi-terms/#terms-coverage
   */
  public List<RDFValue> getCoverage() {
    return findElements("coverage", RDFValue.class);
  }

  /**
   * Date of creation of the resource.
   *
   * @return Date of creation of the resource.
   * 
   * @link http://dublincore.org/documents/dcmi-terms/#terms-created
   */
  public List<RDFLiteral> getCreated() {
    return findElements("created", RDFLiteral.class);
  }

  /**
   * Date of creation of the resource.
   *
   * @return Date of creation of the resource.
   *
   * @link http://dublincore.org/documents/dcmi-terms/#terms-created
   */
  public List<Date> getCreatedAsDate() {
    return findElements("created", Date.class);
  }

  /**
   * Entities primarily responsible for making the resource.
   *
   * @return Entities primarily responsible for making the resource.
   * 
   * @link http://dublincore.org/documents/dcmi-terms/#terms-creator
   */
  public List<RDFValue> getCreator() {
    return findElements("creator", RDFValue.class);
  }

  /**
   * A point or period of time associated with an event in the lifecycle of the resource.
   *
   * @return A point or period of time associated with an event in the lifecycle of the resource.
   * 
   * @link http://dublincore.org/documents/dcmi-terms/#terms-date
   */
  public List<RDFLiteral> getDate() {
    return findElements("date", RDFLiteral.class);
  }

  /**
   * A point or period of time associated with an event in the lifecycle of the resource.
   *
   * @return A point or period of time associated with an event in the lifecycle of the resource.
   *
   * @link http://dublincore.org/documents/dcmi-terms/#terms-date
   */
  public List<Date> getDateAsDate() {
    return findElements("date", Date.class);
  }

  /**
   * Date of acceptance of the resource.
   *
   * @return Date of acceptance of the resource.
   *
   * @link http://dublincore.org/documents/dcmi-terms/#terms-dateAccepted
   */
  public List<RDFLiteral> getDateAccepted() {
    return findElements("dateAccepted", RDFLiteral.class);
  }

  /**
   * Date of acceptance of the resource.
   *
   * @return Date of acceptance of the resource.
   *
   * @link http://dublincore.org/documents/dcmi-terms/#terms-dateAccepted
   */
  public List<Date> getDateAcceptedAsDate() {
    return findElements("dateAccepted", Date.class);
  }

  /**
   * Date of copyright.
   *
   * @return Date of copyright.
   *
   * @link http://dublincore.org/documents/dcmi-terms/#terms-dateCopyrighted
   */
  public List<RDFLiteral> getDateCopyrighted() {
    return findElements("dateCopyrighted", RDFLiteral.class);
  }

  /**
   * Date of copyright.
   *
   * @return Date of copyright.
   *
   * @link http://dublincore.org/documents/dcmi-terms/#terms-dateCopyrighted
   */
  public List<Date> getDateCopyrightedAsDate() {
    return findElements("dateCopyrighted", Date.class);
  }

  /**
   * Date of submission of the resource.
   *
   * @return Date of submission of the resource.
   *
   * @link http://dublincore.org/documents/dcmi-terms/#terms-dateSubmitted
   */
  public List<RDFLiteral> getDateSubmitted() {
    return findElements("dateSubmitted", RDFLiteral.class);
  }

  /**
   * Date of submission of the resource.
   *
   * @return Date of submission of the resource.
   *
   * @link http://dublincore.org/documents/dcmi-terms/#terms-dateSubmitted
   */
  public List<Date> getDateSubmittedAsDate() {
    return findElements("dateSubmitted", Date.class);
  }

  /**
   * An account of the resource.
   *
   * @return An account of the resource.
   * 
   * @link http://dublincore.org/documents/dcmi-terms/#terms-description
   */
  public List<RDFValue> getDescription() {
    return findElements("description", RDFValue.class);
  }

  /**
   * A class of entity, defined in terms of progression through an educational or training context, for which the described resource is intended.
   *
   * @return A class of entity, defined in terms of progression through an educational or training context, for which the described resource is intended.
   * 
   * @link http://dublincore.org/documents/dcmi-terms/#terms-educationLevel
   */
  public List<RDFValue> getEducationLevel() {
    return findElements("educationLevel", RDFValue.class);
  }

  /**
   * The size or duration of the resource.
   *
   * @return The size or duration of the resource.
   * 
   * @link http://dublincore.org/documents/dcmi-terms/#terms-extent
   */
  public List<RDFValue> getExtent() {
    return findElements("extent", RDFValue.class);
  }

  /**
   * The file format, physical medium, or dimensions of the resource. Examples of dimensions include size and duration. Recommended best practice is
   * to use a controlled vocabulary such as the list of Internet Media Types [MIME].
   *
   * @return The file format, physical medium, or dimensions of the resource. Examples of dimensions include size and duration. Recommended best practice is to
   *               use a controlled vocabulary such as the list of Internet Media Types [MIME].
   * 
   * @link http://dublincore.org/documents/dcmi-terms/#terms-format
   */
  public List<RDFValue> getFormat() {
    return findElements("format", RDFValue.class);
  }

  /**
   * List of alternate formats of the pre-existing described resource. In REST terms, a list of the alternate "representations" that are available
   * for the described resource, probably in terms of the MIME type. If the alternate representations of the resource are accessed at
   * a different URI (bad practice, but an accepted reality), use a custom "href" attribute instead of the
   * {http://www.w3.org/1999/02/22-rdf-syntax-ns#}resource attribute.
   *
   * @return Alternate formats of the described resource.
   * 
   * @link http://dublincore.org/documents/dcmi-terms/#terms-hasFormat
   */
  public List<RDFValue> getHasFormat() {
    return findElements("hasFormat", RDFValue.class);
  }

  /**
   * Related resources that are included either physically or logically in the described resource.
   *
   * @return Related resources that are included either physically or logically in the described resource.
   * 
   * @link http://dublincore.org/documents/dcmi-terms/#terms-hasPart
   */
  public List<RDFValue> getHasPart() {
    return findElements("hasPart", RDFValue.class);
  }

  /**
   * Related resources that are a version, edition, or adaptation of the described resource.
   *
   * @return Related resources that are a version, edition, or adaptation of the described resource.
   * 
   * @link http://dublincore.org/documents/dcmi-terms/#terms-hasVersion
   */
  public List<RDFValue> getHasVersion() {
    return findElements("hasVersion", RDFValue.class);
  }

  /**
   * An unambiguous reference to the resource within a given context.
   *
   * @return An unambiguous reference to the resource within a given context.
   * 
   * @link http://dublincore.org/documents/dcmi-terms/#terms-identifier
   */
  public List<RDFLiteral> getIdentifier() {
    return findElements("identifier", RDFLiteral.class);
  }

  /**
   * A process, used to engender knowledge, attitudes and skills, that the described resource is designed to support.
   *
   * @return A process, used to engender knowledge, attitudes and skills, that the described resource is designed to support.
   * 
   * @link http://dublincore.org/documents/dcmi-terms/#terms-instructionalMethod
   */
  public List<RDFValue> getInstructionalMethod() {
    return findElements("instructionalMethod", RDFValue.class);
  }

  /**
   * Related resources that are substantially the same as the described resource, but in another format. In REST terms, the URI of
   * an alternate representation of the same resource. Note that having more than one URI for the same resource is generally bad
   * practice (see http://www.w3.org/TR/webarch/) but still an accepted reality.
   *
   * @return Related resources that are substantially the same as the described resource, but in another format.
   * 
   * @link http://dublincore.org/documents/dcmi-terms/#terms-isFormatOf
   */
  public List<RDFValue> getIsFormatOf() {
    return findElements("formatOf", RDFValue.class);
  }

  /**
   * Related resources in which the described resource is physically or logically included.
   *
   * @return Related resources in which the described resource is physically or logically included.
   * 
   * @link http://dublincore.org/documents/dcmi-terms/#terms-isPartOf
   */
  public List<RDFValue> getIsPartOf() {
    return findElements("partOf", RDFValue.class);
  }

  /**
   * Related resources that reference, cite, or otherwise point to the described resource.
   *
   * @return Related resources that reference, cite, or otherwise point to the described resource.
   * 
   * @link http://dublincore.org/documents/dcmi-terms/#terms-isReferencedBy
   */
  public List<RDFValue> getIsReferencedBy() {
    return findElements("referencedBy", RDFValue.class);
  }

  /**
   * Related resources that supplant, displace, or supersede the described resource.
   *
   * @return Related resources that supplant, displace, or supersede the described resource.
   * 
   * @link http://dublincore.org/documents/dcmi-terms/#terms-isReplacedBy
   */
  public List<RDFValue> getIsReplacedBy() {
    return findElements("replacedBy", RDFValue.class);
  }

  /**
   * Related resources that require the described resource to support its function, delivery, or coherence.
   *
   * @return Related resources that require the described resource to support its function, delivery, or coherence.
   * 
   * @link http://dublincore.org/documents/dcmi-terms/#terms-isRequiredBy
   */
  public List<RDFValue> getIsRequiredBy() {
    return findElements("requiredBy", RDFValue.class);
  }

  /**
   * Date of formal issuance (e.g., publication) of the resource.
   *
   * @return Date of formal issuance (e.g., publication) of the resource.
   *
   * @link http://dublincore.org/documents/dcmi-terms/#terms-issued
   */
  public List<RDFLiteral> getIssued() {
    return findElements("issued", RDFLiteral.class);
  }

  /**
   * Date of formal issuance (e.g., publication) of the resource.
   *
   * @return Date of formal issuance (e.g., publication) of the resource.
   *
   * @link http://dublincore.org/documents/dcmi-terms/#terms-issued
   */
  public List<Date> getIssuedAsDate() {
    return findElements("issued", Date.class);
  }

  /**
   * A related resource of which the described resource is a version, edition, or adaptation. Changes in version imply substantive changes
   * in content rather than differences in format.
   *
   * @return A related resource of which the described resource is a version, edition, or adaptation. Changes in version imply substantive
   *                  changes in content rather than differences in format.
   * 
   * @link http://dublincore.org/documents/dcmi-terms/#terms-isVersionOf
   */
  public List<RDFValue> getIsVersionOf() {
    return findElements("isVersionOf", RDFValue.class);
  }

  /**
   * Languages of the resource. Recommended best practice is to use a controlled vocabulary such as RFC 4646 [RFC4646].
   *
   * @return Languages of the resource. Recommended best practice is to use a controlled vocabulary such as RFC 4646 [RFC4646].
   * 
   * @link http://dublincore.org/documents/dcmi-terms/#terms-language
   */
  public List<RDFValue> getLanguage() {
    return findElements("language", RDFValue.class);
  }

  /**
   * Legal documents giving official permission to do something with the resource.
   *
   * @return Legal documents giving official permission to do something with the resource.
   * 
   * @link http://dublincore.org/documents/dcmi-terms/#terms-license
   */
  public List<RDFValue> getLicense() {
    return findElements("license", RDFValue.class);
  }

  /**
   * Entities that mediate access to the resource and for whom the resource is intended or useful.
   *
   * @return Entities that mediate access to the resource and for whom the resource is intended or useful.
   * 
   * @link http://dublincore.org/documents/dcmi-terms/#terms-mediator
   */
  public List<RDFValue> getMediator() {
    return findElements("mediator", RDFValue.class);
  }

  /**
   * The material or physical carrier of the resource.
   *
   * @return The material or physical carrier of the resource.
   * 
   * @link http://dublincore.org/documents/dcmi-terms/#terms-medium
   */
  public List<RDFValue> getMedium() {
    return findElements("medium", RDFValue.class);
  }

  /**
   * Date on which the resource was changed.
   *
   * @return Date on which the resource was changed.
   * 
   * @link http://dublincore.org/documents/dcmi-terms/#terms-modified
   */
  public List<RDFLiteral> getModified() {
    return findElements("modified", RDFLiteral.class);
  }

  /**
   * Date on which the resource was changed.
   *
   * @return Date on which the resource was changed.
   *
   * @link http://dublincore.org/documents/dcmi-terms/#terms-modified
   */
  public List<Date> getModifiedAsDate() {
    return findElements("modified", Date.class);
  }

  /**
   * A statement of any changes in ownership and custody of the resource since its creation that are significant for its authenticity, integrity, and interpretation.
   *
   * @return A statement of any changes in ownership and custody of the resource since its creation that are significant for its authenticity, integrity, and interpretation.
   * 
   * @link http://dublincore.org/documents/dcmi-terms/#terms-provenance
   */
  public List<RDFValue> getProvenance() {
    return findElements("provenance", RDFValue.class);
  }

  /**
   * An entity responsible for making the resource available.
   *
   * @return An entity responsible for making the resource available.
   * 
   * @link http://dublincore.org/documents/dcmi-terms/#terms-publisher
   */
  public List<RDFValue> getPublisher() {
    return findElements("publisher", RDFValue.class);
  }

  /**
   * Related resources that are referenced, cited, or otherwise pointed to by the described resource.
   *
   * @return Related resources that are referenced, cited, or otherwise pointed to by the described resource.
   * 
   * @link http://dublincore.org/documents/dcmi-terms/#terms-references
   */
  public List<RDFValue> getReferences() {
    return findElements("references", RDFValue.class);
  }

  /**
   * Related resources.
   *
   * @return Related resources.
   * 
   * @link http://dublincore.org/documents/dcmi-terms/#terms-relation
   */
  public List<RDFValue> getRelation() {
    return findElements("relation", RDFValue.class);
  }

  /**
   * Related resources that are supplanted, displaced, or superseded by the described resource.
   *
   * @return Related resources that are supplanted, displaced, or superseded by the described resource.
   * 
   * @link http://dublincore.org/documents/dcmi-terms/#terms-replaces
   */
  public List<RDFValue> getReplaces() {
    return findElements("replaces", RDFValue.class);
  }

  /**
   * Related resources that are required by the described resource to support its function, delivery, or coherence.
   *
   * @return Related resources that are required by the described resource to support its function, delivery, or coherence.
   * 
   * @link http://dublincore.org/documents/dcmi-terms/#terms-requires
   */
  public List<RDFValue> getRequires() {
    return findElements("requires", RDFValue.class);
  }

  /**
   * Information about rights held in and over the resource.
   *
   * @return Information about rights held in and over the resource.
   * 
   * @link http://dublincore.org/documents/dcmi-terms/#terms-rights
   */
  public List<RDFValue> getRights() {
    return findElements("rights", RDFValue.class);
  }

  /**
   * A person or organization owning or managing rights over the resource.
   *
   * @return A person or organization owning or managing rights over the resource.
   * 
   * @link http://dublincore.org/documents/dcmi-terms/#terms-rightsHolder
   */
  public List<RDFValue> getRightsHolder() {
    return findElements("rightsHolder", RDFValue.class);
  }

  /**
   * A related resource from which the described resource is derived.
   *
   * @return A related resource from which the described resource is derived.
   * 
   * @link http://dublincore.org/documents/dcmi-terms/#terms-source
   */
  public List<RDFValue> getSource() {
    return findElements("source", RDFValue.class);
  }

  /**
   * Spatial characteristics of the resource.
   *
   * @return Spatial characteristics of the resource.
   * 
   * @link http://dublincore.org/documents/dcmi-terms/#terms-spatial
   */
  public List<RDFValue> getSpatial() {
    return findElements("spatial", RDFValue.class);
  }

  /**
   * The topic of the resource. Typically, the subject will be represented using keywords, key phrases, or classification codes.
   * Recommended best practice is to use a controlled vocabulary. To describe the spatial or temporal topic of the resource,
   * use the Coverage element.
   *
   * @return The topic of the resource. Typically, the subject will be represented using keywords, key phrases, or classification codes.
   *                Recommended best practice is to use a controlled vocabulary. To describe the spatial or temporal topic of the resource,
   *                use the Coverage element.
   * 
   * @link http://dublincore.org/documents/dcmi-terms/#terms-subject
   */
  public List<RDFValue> getSubject() {
    return findElements("subject", RDFValue.class);
  }

  /**
   * A list of subunits of the resource.
   *
   * @return A list of subunits of the resource.
   * 
   * @link http://dublincore.org/documents/dcmi-terms/#terms-tableOfContents
   */
  public List<RDFValue> getTableOfContents() {
    return findElements("tableOfContents", RDFValue.class);
  }

  /**
   * Temporal characteristics of the resource.
   *
   * @return Temporal characteristics of the resource.
   * 
   * @link http://dublincore.org/documents/dcmi-terms/#terms-temporal
   */
  public List<RDFValue> getTemporal() {
    return findElements("temporal", RDFValue.class);
  }

  /**
   * A name given to the resource.
   *
   * @return A name given to the resource.
   * 
   * @link http://dublincore.org/documents/dcmi-terms/#terms-title
   */
  public List<RDFLiteral> getTitle() {
    return findElements("title", RDFLiteral.class);
  }

  /**
   * Date of validity of a resource.
   *
   * @return Date of validity of a resource.
   *
   * @link http://dublincore.org/documents/dcmi-terms/#terms-valid
   */
  public List<RDFLiteral> getValid() {
    return findElements("valid", RDFLiteral.class);
  }

  /**
   * Date of validity of a resource.
   *
   * @return Date of validity of a resource.
   *
   * @link http://dublincore.org/documents/dcmi-terms/#terms-valid
   */
  public List<Date> getValidAsDate() {
    return findElements("valid", Date.class);
  }

  private <V> List<V> findElements(String term, Class<V> valueClass) {
    ArrayList<V> elements = new ArrayList<V>();
    List<Object> extensionElements = this.description.getExtensionElements();
    if (extensionElements != null) {
      for (Object extensionElement : extensionElements) {
        if (extensionElement instanceof JAXBElement && CommonModels.DUBLIN_CORE_NAMESPACE.equals(((JAXBElement) extensionElement).getName().getNamespaceURI()) && term.equals(((JAXBElement) extensionElement).getName().getLocalPart())) {
          Object value = ((JAXBElement) extensionElement).getValue();
          if (valueClass == Date.class && value instanceof RDFLiteral) {
            value = ((RDFLiteral) value).getValueAsDate();
          }
          elements.add((V) value);
        }
      }
    }
    return elements;
  }

}

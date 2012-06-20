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

import org.gedcomx.metadata.rdf.RDFLiteral;
import org.gedcomx.metadata.rdf.RDFValue;
import org.gedcomx.rt.CommonModels;
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
   * A summary of the resource.
   *
   * @param abstrct A summary of the resource.
   * @return The element.
   * @link http://dublincore.org/documents/dcmi-terms/#terms-abstract
   */
  @XmlElementDecl ( namespace = CommonModels.DUBLIN_CORE_NAMESPACE, name = "abstract" )
  @JsonElementWrapper ( name = "abstracts" )
  public JAXBElement<RDFValue> createAbstractElement(RDFValue abstrct) {
    return new JAXBElement<RDFValue>(new QName(CommonModels.DUBLIN_CORE_NAMESPACE, "abstract"), RDFValue.class, abstrct);
  }

  /**
   * Information about who can access the resource or an indication of its security status. Access Rights may include information
   * regarding access or restrictions based on privacy, security, or other policies.
   *
   * @param accessRights Information about who can access the resource or an indication of its security status. Access Rights may include information
   *                     regarding access or restrictions based on privacy, security, or other policies.
   * @return The element.
   * @link http://dublincore.org/documents/dcmi-terms/#terms-accessRights
   */
  @XmlElementDecl ( namespace = CommonModels.DUBLIN_CORE_NAMESPACE, name = "accessRights" )
  @JsonElementWrapper ( name = "accessRights" )
  public JAXBElement<RDFValue> createAccessRightsElement(RDFValue accessRights) {
    return new JAXBElement<RDFValue>(new QName(CommonModels.DUBLIN_CORE_NAMESPACE, "accessRights"), RDFValue.class, accessRights);
  }

  /**
   * The method by which items are added to a collection.
   *
   * @param accrualMethod The method by which items are added to a collection.
   * @return The element.
   * @link http://dublincore.org/documents/dcmi-terms/#terms-accrualMethod
   */
  @XmlElementDecl ( namespace = CommonModels.DUBLIN_CORE_NAMESPACE, name = "accrualMethod" )
  @JsonElementWrapper ( name = "accrualMethods" )
  public JAXBElement<RDFValue> createAccrualMethodElement(RDFValue accrualMethod) {
    return new JAXBElement<RDFValue>(new QName(CommonModels.DUBLIN_CORE_NAMESPACE, "accrualMethod"), RDFValue.class, accrualMethod);
  }

  /**
   * The frequency with which items are added to a collection.
   *
   * @param accrualPeriodicity The frequency with which items are added to a collection.
   * @return The element.
   * @link http://dublincore.org/documents/dcmi-terms/#terms-accrualPeriodicity
   */
  @XmlElementDecl ( namespace = CommonModels.DUBLIN_CORE_NAMESPACE, name = "accrualPeriodicity" )
  @JsonElementWrapper ( name = "accrualPeriodicity" )
  public JAXBElement<RDFValue> createAccrualPeriodicityElement(RDFValue accrualPeriodicity) {
    return new JAXBElement<RDFValue>(new QName(CommonModels.DUBLIN_CORE_NAMESPACE, "accrualPeriodicity"), RDFValue.class, accrualPeriodicity);
  }

  /**
   * The policy governing the addition of items to a collection.
   *
   * @param accrualPolicy The policy governing the addition of items to a collection.
   * @return The element.
   * @link http://dublincore.org/documents/dcmi-terms/#terms-accrualPolicy
   */
  @XmlElementDecl ( namespace = CommonModels.DUBLIN_CORE_NAMESPACE, name = "accrualPolicy" )
  @JsonElementWrapper ( name = "accrualPolicies" )
  public JAXBElement<RDFValue> createAccrualPolicyElement(RDFValue accrualPolicy) {
    return new JAXBElement<RDFValue>(new QName(CommonModels.DUBLIN_CORE_NAMESPACE, "accrualPolicy"), RDFValue.class, accrualPolicy);
  }

  /**
   * Alternative names for the resource. The distinction between titles and alternative titles is application-specific.
   *
   * @param alternative Alternative names for the resource. The distinction between titles and alternative titles is application-specific.
   * @return The element.
   * @link http://dublincore.org/documents/dcmi-terms/#terms-alternative
   */
  @XmlElementDecl ( namespace = CommonModels.DUBLIN_CORE_NAMESPACE, name = "alternative" )
  @JsonElementWrapper ( name = "alternatives" )
  public JAXBElement<org.gedcomx.metadata.rdf.RDFLiteral> createAlternativeElement(org.gedcomx.metadata.rdf.RDFLiteral alternative) {
    return new JAXBElement<org.gedcomx.metadata.rdf.RDFLiteral>(new QName(CommonModels.DUBLIN_CORE_NAMESPACE, "alternative"), org.gedcomx.metadata.rdf.RDFLiteral.class, alternative);
  }

  /**
   * A class of entity for whom the resource is intended or useful.
   *
   * @param audience A class of entity for whom the resource is intended or useful.
   * @return The element.
   * @link http://dublincore.org/documents/dcmi-terms/#terms-audience
   */
  @XmlElementDecl ( namespace = CommonModels.DUBLIN_CORE_NAMESPACE, name = "audience" )
  @JsonElementWrapper ( name = "audiences" )
  public JAXBElement<RDFValue> createAudienceElement(RDFValue audience) {
    return new JAXBElement<RDFValue>(new QName(CommonModels.DUBLIN_CORE_NAMESPACE, "audience"), RDFValue.class, audience);
  }

  /**
   * Date that the resource became or will become available.
   *
   * @param available Date that the resource became or will become available.
   * @return The element.
   * @link http://dublincore.org/documents/dcmi-terms/#terms-available
   */
  @XmlElementDecl ( namespace = CommonModels.DUBLIN_CORE_NAMESPACE, name = "available" )
  @JsonElementWrapper ( name = "available" )
  public JAXBElement<RDFLiteral> createAvailableElement(RDFLiteral available) {
    return new JAXBElement<RDFLiteral>(new QName(CommonModels.DUBLIN_CORE_NAMESPACE, "available"), RDFLiteral.class, available);
  }

  /**
   * A bibliographic reference for the resource. Recommended practice is to include sufficient
   * bibliographic detail to identify the resource as unambiguously as possible.
   *
   * @param bibliographicCitation A bibliographic reference for the resource. Recommended practice is to include sufficient
   *                              bibliographic detail to identify the resource as unambiguously as possible.
   * @return The element.
   * @link http://dublincore.org/documents/dcmi-terms/#terms-bibliographicCitation
   */
  @XmlElementDecl ( namespace = CommonModels.DUBLIN_CORE_NAMESPACE, name = "bibliographicCitation" )
  @JsonElementWrapper ( name = "bibliographicCitations" )
  public JAXBElement<org.gedcomx.metadata.rdf.RDFLiteral> createBibliographicCitationElement(org.gedcomx.metadata.rdf.RDFLiteral bibliographicCitation) {
    return new JAXBElement<org.gedcomx.metadata.rdf.RDFLiteral>(new QName(CommonModels.DUBLIN_CORE_NAMESPACE, "bibliographicCitation"), org.gedcomx.metadata.rdf.RDFLiteral.class, bibliographicCitation);
  }

  /**
   * Established standards to which the described resource conforms.
   *
   * @param conformsTo Established standards to which the described resource conforms.
   * @return The element.
   * @link http://dublincore.org/documents/dcmi-terms/#terms-conformsTo
   */
  @XmlElementDecl ( namespace = CommonModels.DUBLIN_CORE_NAMESPACE, name = "conformsTo" )
  @JsonElementWrapper ( name = "conformsTo" )
  public JAXBElement<RDFValue> createConformsToElement(RDFValue conformsTo) {
    return new JAXBElement<RDFValue>(new QName(CommonModels.DUBLIN_CORE_NAMESPACE, "conformsTo"), RDFValue.class, conformsTo);
  }

  /**
   * Entities responsible for making contributions to the resource. Examples of a Contributor include a person, an organization, or a service.
   *
   * @param contributor Entities responsible for making contributions to the resource. Examples of a Contributor include a person, an organization, or a service.
   * @return The element.
   * @link http://dublincore.org/documents/dcmi-terms/#terms-contributor
   */
  @XmlElementDecl ( namespace = CommonModels.DUBLIN_CORE_NAMESPACE, name = "contributor" )
  @JsonElementWrapper ( name = "contributors" )
  public JAXBElement<RDFValue> createContributorElement(RDFValue contributor) {
    return new JAXBElement<RDFValue>(new QName(CommonModels.DUBLIN_CORE_NAMESPACE, "contributor"), RDFValue.class, contributor);
  }

  /**
   * The spatial or temporal topic of the resource, the spatial applicability of the resource, or the jurisdiction under which the resource is relevant.
   *
   * @param coverage The spatial or temporal topic of the resource, the spatial applicability of the resource, or the jurisdiction under which the resource is relevant.
   * @return The element.
   * @link http://dublincore.org/documents/dcmi-terms/#terms-coverage
   */
  @XmlElementDecl ( namespace = CommonModels.DUBLIN_CORE_NAMESPACE, name = "coverage" )
  @JsonElementWrapper ( name = "coverages" )
  public JAXBElement<RDFValue> createCoverageElement(RDFValue coverage) {
    return new JAXBElement<RDFValue>(new QName(CommonModels.DUBLIN_CORE_NAMESPACE, "coverage"), RDFValue.class, coverage);
  }

  /**
   * Date of creation of the resource.
   *
   * @param created Date of creation of the resource.
   * @return The element.
   * @link http://dublincore.org/documents/dcmi-terms/#terms-created
   */
  @XmlElementDecl ( namespace = CommonModels.DUBLIN_CORE_NAMESPACE, name = "created" )
  @JsonElementWrapper ( name = "created" )
  public JAXBElement<RDFLiteral> createCreatedElement(RDFLiteral created) {
    return new JAXBElement<RDFLiteral>(new QName(CommonModels.DUBLIN_CORE_NAMESPACE, "created"), RDFLiteral.class, created);
  }

  /**
   * Entities primarily responsible for making the resource.
   *
   * @param creator Entities primarily responsible for making the resource.
   * @return The element.
   * @link http://dublincore.org/documents/dcmi-terms/#terms-creator
   */
  @XmlElementDecl ( namespace = CommonModels.DUBLIN_CORE_NAMESPACE, name = "creator" )
  @JsonElementWrapper ( name = "creators" )
  public JAXBElement<RDFValue> createCreatorElement(RDFValue creator) {
    return new JAXBElement<RDFValue>(new QName(CommonModels.DUBLIN_CORE_NAMESPACE, "creator"), RDFValue.class, creator);
  }

  /**
   * A point or period of time associated with an event in the lifecycle of the resource.
   *
   * @param date A point or period of time associated with an event in the lifecycle of the resource.
   * @return The element.
   * @link http://dublincore.org/documents/dcmi-terms/#terms-date
   */
  @XmlElementDecl ( namespace = CommonModels.DUBLIN_CORE_NAMESPACE, name = "date" )
  @JsonElementWrapper ( name = "dates" )
  public JAXBElement<RDFLiteral> createDateElement(RDFLiteral date) {
    return new JAXBElement<RDFLiteral>(new QName(CommonModels.DUBLIN_CORE_NAMESPACE, "date"), RDFLiteral.class, date);
  }

  /**
   * Date of acceptance of the resource.
   *
   * @param dateAccepted Date of acceptance of the resource.
   * @return The element.
   * @link http://dublincore.org/documents/dcmi-terms/#terms-dateAccepted
   */
  @XmlElementDecl ( namespace = CommonModels.DUBLIN_CORE_NAMESPACE, name = "dateAccepted" )
  @JsonElementWrapper ( name = "datesAccepted" )
  public JAXBElement<RDFLiteral> createDateAcceptedElement(RDFLiteral dateAccepted) {
    return new JAXBElement<RDFLiteral>(new QName(CommonModels.DUBLIN_CORE_NAMESPACE, "dateAccepted"), RDFLiteral.class, dateAccepted);
  }

  /**
   * Date of copyright.
   *
   * @param dateCopyrighted Date of copyright.
   * @return The element.
   * @link http://dublincore.org/documents/dcmi-terms/#terms-dateCopyrighted
   */
  @XmlElementDecl ( namespace = CommonModels.DUBLIN_CORE_NAMESPACE, name = "dateCopyrighted" )
  @JsonElementWrapper ( name = "datesCopyrighted" )
  public JAXBElement<RDFLiteral> createDateCopyrightedElement(RDFLiteral dateCopyrighted) {
    return new JAXBElement<RDFLiteral>(new QName(CommonModels.DUBLIN_CORE_NAMESPACE, "dateCopyrighted"), RDFLiteral.class, dateCopyrighted);
  }

  /**
   * Date of submission of the resource.
   *
   * @param dateSubmitted Date of submission of the resource.
   * @return The element.
   * @link http://dublincore.org/documents/dcmi-terms/#terms-dateSubmitted
   */
  @XmlElementDecl ( namespace = CommonModels.DUBLIN_CORE_NAMESPACE, name = "dateSubmitted" )
  @JsonElementWrapper ( name = "datesSubmitted" )
  public JAXBElement<RDFLiteral> createDateSubmittedElement(RDFLiteral dateSubmitted) {
    return new JAXBElement<RDFLiteral>(new QName(CommonModels.DUBLIN_CORE_NAMESPACE, "dateSubmitted"), RDFLiteral.class, dateSubmitted);
  }

  /**
   * An account of the resource.
   *
   * @param description An account of the resource.
   * @return The element.
   * @link http://dublincore.org/documents/dcmi-terms/#terms-description
   */
  @XmlElementDecl ( namespace = CommonModels.DUBLIN_CORE_NAMESPACE, name = "description" )
  @JsonElementWrapper ( name = "dc-descriptions" )
  public JAXBElement<RDFValue> createDescriptionElement(RDFValue description) {
    return new JAXBElement<RDFValue>(new QName(CommonModels.DUBLIN_CORE_NAMESPACE, "description"), RDFValue.class, description);
  }

  /**
   * A class of entity, defined in terms of progression through an educational or training context, for which the described resource is intended.
   *
   * @param educationLevel A class of entity, defined in terms of progression through an educational or training context, for which the described resource is intended.
   * @return The element.
   * @link http://dublincore.org/documents/dcmi-terms/#terms-educationLevel
   */
  @XmlElementDecl ( namespace = CommonModels.DUBLIN_CORE_NAMESPACE, name = "educationLevel" )
  @JsonElementWrapper ( name = "educationLevels" )
  public JAXBElement<RDFValue> createEducationLevelElement(RDFValue educationLevel) {
    return new JAXBElement<RDFValue>(new QName(CommonModels.DUBLIN_CORE_NAMESPACE, "educationLevel"), RDFValue.class, educationLevel);
  }

  /**
   * The size or duration of the resource.
   *
   * @param extent The size or duration of the resource.
   * @return The element.
   * @link http://dublincore.org/documents/dcmi-terms/#terms-extent
   */
  @XmlElementDecl ( namespace = CommonModels.DUBLIN_CORE_NAMESPACE, name = "extent" )
  @JsonElementWrapper ( name = "extent" )
  public JAXBElement<RDFValue> createExtentElement(RDFValue extent) {
    return new JAXBElement<RDFValue>(new QName(CommonModels.DUBLIN_CORE_NAMESPACE, "extent"), RDFValue.class, extent);
  }

  /**
   * The file format, physical medium, or dimensions of the resource. Examples of dimensions include size and duration. Recommended best practice is
   * to use a controlled vocabulary such as the list of Internet Media Types [MIME].
   *
   * @param format The file format, physical medium, or dimensions of the resource. Examples of dimensions include size and duration. Recommended best practice is to
   *               use a controlled vocabulary such as the list of Internet Media Types [MIME].
   * @return The element.
   * @link http://dublincore.org/documents/dcmi-terms/#terms-format
   */
  @XmlElementDecl ( namespace = CommonModels.DUBLIN_CORE_NAMESPACE, name = "format" )
  @JsonElementWrapper ( name = "formats" )
  public JAXBElement<RDFValue> createFormatElement(RDFValue format) {
    return new JAXBElement<RDFValue>(new QName(CommonModels.DUBLIN_CORE_NAMESPACE, "format"), RDFValue.class, format);
  }

  /**
   * List of alternate formats of the pre-existing described resource. In REST terms, a list of the alternate "representations" that are available
   * for the described resource, probably in terms of the MIME type. If the alternate representations of the resource are accessed at
   * a different URI (bad practice, but an accepted reality), use a custom "href" attribute instead of the
   * {http://www.w3.org/1999/02/22-rdf-syntax-ns#}resource attribute.
   *
   * @param hasFormat Alternate formats of the described resource.
   * @return The element.
   * @link http://dublincore.org/documents/dcmi-terms/#terms-hasFormat
   */
  @XmlElementDecl ( namespace = CommonModels.DUBLIN_CORE_NAMESPACE, name = "hasFormat" )
  @JsonElementWrapper ( name = "hasFormats" )
  public JAXBElement<RDFValue> createHasFormatElement(RDFValue hasFormat) {
    return new JAXBElement<RDFValue>(new QName(CommonModels.DUBLIN_CORE_NAMESPACE, "hasFormat"), RDFValue.class, hasFormat);
  }

  /**
   * Related resources that are included either physically or logically in the described resource.
   *
   * @param hasPart Related resources that are included either physically or logically in the described resource.
   * @return The element.
   * @link http://dublincore.org/documents/dcmi-terms/#terms-hasPart
   */
  @XmlElementDecl ( namespace = CommonModels.DUBLIN_CORE_NAMESPACE, name = "hasPart" )
  @JsonElementWrapper ( name = "hasParts" )
  public JAXBElement<RDFValue> createHasPartElement(RDFValue hasPart) {
    return new JAXBElement<RDFValue>(new QName(CommonModels.DUBLIN_CORE_NAMESPACE, "hasPart"), RDFValue.class, hasPart);
  }

  /**
   * Related resources that are a version, edition, or adaptation of the described resource.
   *
   * @param hasVersion Related resources that are a version, edition, or adaptation of the described resource.
   * @return The element.
   * @link http://dublincore.org/documents/dcmi-terms/#terms-hasVersion
   */
  @XmlElementDecl ( namespace = CommonModels.DUBLIN_CORE_NAMESPACE, name = "hasVersion" )
  @JsonElementWrapper ( name = "hasVersions" )
  public JAXBElement<RDFValue> createHasVersionElement(RDFValue hasVersion) {
    return new JAXBElement<RDFValue>(new QName(CommonModels.DUBLIN_CORE_NAMESPACE, "hasVersion"), RDFValue.class, hasVersion);
  }

  /**
   * An unambiguous reference to the resource within a given context.
   *
   * @param identifier An unambiguous reference to the resource within a given context.
   * @return The element.
   * @link http://dublincore.org/documents/dcmi-terms/#terms-identifier
   */
  @XmlElementDecl ( namespace = CommonModels.DUBLIN_CORE_NAMESPACE, name = "identifier" )
  @JsonElementWrapper ( name = "identifiers" )
  public JAXBElement<org.gedcomx.metadata.rdf.RDFLiteral> createIdentifierElement(org.gedcomx.metadata.rdf.RDFLiteral identifier) {
    return new JAXBElement<org.gedcomx.metadata.rdf.RDFLiteral>(new QName(CommonModels.DUBLIN_CORE_NAMESPACE, "identifier"), org.gedcomx.metadata.rdf.RDFLiteral.class, identifier);
  }

  /**
   * A process, used to engender knowledge, attitudes and skills, that the described resource is designed to support.
   *
   * @param instructionalMethod A process, used to engender knowledge, attitudes and skills, that the described resource is designed to support.
   * @return The element.
   * @link http://dublincore.org/documents/dcmi-terms/#terms-instructionalMethod
   */
  @XmlElementDecl ( namespace = CommonModels.DUBLIN_CORE_NAMESPACE, name = "instructionalMethod" )
  @JsonElementWrapper ( name = "instructionalMethods" )
  public JAXBElement<RDFValue> createInstructionalMethodElement(RDFValue instructionalMethod) {
    return new JAXBElement<RDFValue>(new QName(CommonModels.DUBLIN_CORE_NAMESPACE, "instructionalMethod"), RDFValue.class, instructionalMethod);
  }

  /**
   * Related resources that are substantially the same as the described resource, but in another format. In REST terms, the URI of
   * an alternate representation of the same resource. Note that having more than one URI for the same resource is generally bad
   * practice (see http://www.w3.org/TR/webarch/) but still an accepted reality.
   *
   * @param formatOf Related resources that are substantially the same as the described resource, but in another format.
   * @return The element.
   * @link http://dublincore.org/documents/dcmi-terms/#terms-isFormatOf
   */
  @XmlElementDecl ( namespace = CommonModels.DUBLIN_CORE_NAMESPACE, name = "formatOf" )
  @JsonElementWrapper ( name = "formatOf" )
  public JAXBElement<RDFValue> createIsFormatOfElement(RDFValue formatOf) {
    return new JAXBElement<RDFValue>(new QName(CommonModels.DUBLIN_CORE_NAMESPACE, "formatOf"), RDFValue.class, formatOf);
  }

  /**
   * Related resources in which the described resource is physically or logically included.
   *
   * @param partOf Related resources in which the described resource is physically or logically included.
   * @return The element.
   * @link http://dublincore.org/documents/dcmi-terms/#terms-isPartOf
   */
  @XmlElementDecl ( namespace = CommonModels.DUBLIN_CORE_NAMESPACE, name = "partOf" )
  @JsonElementWrapper ( name = "partOf" )
  public JAXBElement<RDFValue> createIsPartOfElement(RDFValue partOf) {
    return new JAXBElement<RDFValue>(new QName(CommonModels.DUBLIN_CORE_NAMESPACE, "partOf"), RDFValue.class, partOf);
  }

  /**
   * Related resources that reference, cite, or otherwise point to the described resource.
   *
   * @param referencedBy Related resources that reference, cite, or otherwise point to the described resource.
   * @return The element.
   * @link http://dublincore.org/documents/dcmi-terms/#terms-isReferencedBy
   */
  @XmlElementDecl ( namespace = CommonModels.DUBLIN_CORE_NAMESPACE, name = "referencedBy" )
  @JsonElementWrapper ( name = "referencedBy" )
  public JAXBElement<RDFValue> createIsReferencedByElement(RDFValue referencedBy) {
    return new JAXBElement<RDFValue>(new QName(CommonModels.DUBLIN_CORE_NAMESPACE, "referencedBy"), RDFValue.class, referencedBy);
  }

  /**
   * Related resources that supplant, displace, or supersede the described resource.
   *
   * @param replacedBy Related resources that supplant, displace, or supersede the described resource.
   * @return The element.
   * @link http://dublincore.org/documents/dcmi-terms/#terms-isReplacedBy
   */
  @XmlElementDecl ( namespace = CommonModels.DUBLIN_CORE_NAMESPACE, name = "replacedBy" )
  @JsonElementWrapper ( name = "replacedBy" )
  public JAXBElement<RDFValue> createIsReplacedByElement(RDFValue replacedBy) {
    return new JAXBElement<RDFValue>(new QName(CommonModels.DUBLIN_CORE_NAMESPACE, "replacedBy"), RDFValue.class, replacedBy);
  }

  /**
   * Related resources that require the described resource to support its function, delivery, or coherence.
   *
   * @param requiredBy Related resources that require the described resource to support its function, delivery, or coherence.
   * @return The element.
   * @link http://dublincore.org/documents/dcmi-terms/#terms-isRequiredBy
   */
  @XmlElementDecl ( namespace = CommonModels.DUBLIN_CORE_NAMESPACE, name = "requiredBy" )
  @JsonElementWrapper ( name = "requiredBy" )
  public JAXBElement<RDFValue> createIsRequiredByElement(RDFValue requiredBy) {
    return new JAXBElement<RDFValue>(new QName(CommonModels.DUBLIN_CORE_NAMESPACE, "requiredBy"), RDFValue.class, requiredBy);
  }

  /**
   * Date of formal issuance (e.g., publication) of the resource.
   *
   * @param issued Date of formal issuance (e.g., publication) of the resource.
   * @return The element.
   * @link http://dublincore.org/documents/dcmi-terms/#terms-issued
   */
  @XmlElementDecl ( namespace = CommonModels.DUBLIN_CORE_NAMESPACE, name = "issued" )
  @JsonElementWrapper ( name = "issued" )
  public JAXBElement<RDFLiteral> createIssuedElement(RDFLiteral issued) {
    return new JAXBElement<RDFLiteral>(new QName(CommonModels.DUBLIN_CORE_NAMESPACE, "issued"), RDFLiteral.class, issued);
  }

  /**
   * A related resource of which the described resource is a version, edition, or adaptation. Changes in version imply substantive changes
   * in content rather than differences in format.
   *
   * @param versionOf A related resource of which the described resource is a version, edition, or adaptation. Changes in version imply substantive
   *                  changes in content rather than differences in format.
   * @return The element.
   * @link http://dublincore.org/documents/dcmi-terms/#terms-isVersionOf
   */
  @XmlElementDecl ( namespace = CommonModels.DUBLIN_CORE_NAMESPACE, name = "isVersionOf" )
  @JsonElementWrapper ( name = "isVersionOf" )
  public JAXBElement<RDFValue> createIsVersionOfElement(RDFValue versionOf) {
    return new JAXBElement<RDFValue>(new QName(CommonModels.DUBLIN_CORE_NAMESPACE, "isVersionOf"), RDFValue.class, versionOf);
  }

  /**
   * Languages of the resource. Recommended best practice is to use a controlled vocabulary such as RFC 4646 [RFC4646].
   *
   * @param language Languages of the resource. Recommended best practice is to use a controlled vocabulary such as RFC 4646 [RFC4646].
   * @return The element.
   * @link http://dublincore.org/documents/dcmi-terms/#terms-language
   */
  @XmlElementDecl ( namespace = CommonModels.DUBLIN_CORE_NAMESPACE, name = "language" )
  @JsonElementWrapper ( name = "languages" )
  public JAXBElement<RDFValue> createLanguageElement(RDFValue language) {
    return new JAXBElement<RDFValue>(new QName(CommonModels.DUBLIN_CORE_NAMESPACE, "language"), RDFValue.class, language);
  }

  /**
   * Legal documents giving official permission to do something with the resource.
   *
   * @param license Legal documents giving official permission to do something with the resource.
   * @return The element.
   * @link http://dublincore.org/documents/dcmi-terms/#terms-license
   */
  @XmlElementDecl ( namespace = CommonModels.DUBLIN_CORE_NAMESPACE, name = "license" )
  @JsonElementWrapper ( name = "licenses" )
  public JAXBElement<RDFValue> createLicenseElement(RDFValue license) {
    return new JAXBElement<RDFValue>(new QName(CommonModels.DUBLIN_CORE_NAMESPACE, "license"), RDFValue.class, license);
  }

  /**
   * Entities that mediate access to the resource and for whom the resource is intended or useful.
   *
   * @param mediator Entities that mediate access to the resource and for whom the resource is intended or useful.
   * @return The element.
   * @link http://dublincore.org/documents/dcmi-terms/#terms-mediator
   */
  @XmlElementDecl ( namespace = CommonModels.DUBLIN_CORE_NAMESPACE, name = "mediator" )
  @JsonElementWrapper ( name = "mediators" )
  public JAXBElement<RDFValue> createMediatorElement(RDFValue mediator) {
    return new JAXBElement<RDFValue>(new QName(CommonModels.DUBLIN_CORE_NAMESPACE, "mediator"), RDFValue.class, mediator);
  }

  /**
   * The material or physical carrier of the resource.
   *
   * @param medium The material or physical carrier of the resource.
   * @return The element.
   * @link http://dublincore.org/documents/dcmi-terms/#terms-medium
   */
  @XmlElementDecl ( namespace = CommonModels.DUBLIN_CORE_NAMESPACE, name = "medium" )
  @JsonElementWrapper ( name = "medium" )
  public JAXBElement<RDFValue> createMediumElement(RDFValue medium) {
    return new JAXBElement<RDFValue>(new QName(CommonModels.DUBLIN_CORE_NAMESPACE, "medium"), RDFValue.class, medium);
  }

  /**
   * Date on which the resource was changed.
   *
   * @param modified Date on which the resource was changed.
   * @return The element.
   * @link http://dublincore.org/documents/dcmi-terms/#terms-modified
   */
  @XmlElementDecl ( namespace = CommonModels.DUBLIN_CORE_NAMESPACE, name = "modified" )
  @JsonElementWrapper ( name = "modified" )
  public JAXBElement<RDFLiteral> createModifiedElement(RDFLiteral modified) {
    return new JAXBElement<RDFLiteral>(new QName(CommonModels.DUBLIN_CORE_NAMESPACE, "modified"), RDFLiteral.class, modified);
  }

  /**
   * A statement of any changes in ownership and custody of the resource since its creation that are significant for its authenticity, integrity, and interpretation.
   *
   * @param provenance A statement of any changes in ownership and custody of the resource since its creation that are significant for its authenticity, integrity, and interpretation.
   * @return The element.
   * @link http://dublincore.org/documents/dcmi-terms/#terms-provenance
   */
  @XmlElementDecl ( namespace = CommonModels.DUBLIN_CORE_NAMESPACE, name = "provenance" )
  @JsonElementWrapper ( name = "provenance" )
  public JAXBElement<RDFValue> createProvenanceElement(RDFValue provenance) {
    return new JAXBElement<RDFValue>(new QName(CommonModels.DUBLIN_CORE_NAMESPACE, "provenance"), RDFValue.class, provenance);
  }

  /**
   * An entity responsible for making the resource available.
   *
   * @param publisher An entity responsible for making the resource available.
   * @return The element.
   * @link http://dublincore.org/documents/dcmi-terms/#terms-publisher
   */
  @XmlElementDecl ( namespace = CommonModels.DUBLIN_CORE_NAMESPACE, name = "publisher" )
  @JsonElementWrapper ( name = "publishers" )
  public JAXBElement<RDFValue> createPublisherElement(RDFValue publisher) {
    return new JAXBElement<RDFValue>(new QName(CommonModels.DUBLIN_CORE_NAMESPACE, "publisher"), RDFValue.class, publisher);
  }

  /**
   * Related resources that are referenced, cited, or otherwise pointed to by the described resource.
   *
   * @param references Related resources that are referenced, cited, or otherwise pointed to by the described resource.
   * @return The element.
   * @link http://dublincore.org/documents/dcmi-terms/#terms-references
   */
  @XmlElementDecl ( namespace = CommonModels.DUBLIN_CORE_NAMESPACE, name = "references" )
  @JsonElementWrapper ( name = "references" )
  public JAXBElement<RDFValue> createReferencesElement(RDFValue references) {
    return new JAXBElement<RDFValue>(new QName(CommonModels.DUBLIN_CORE_NAMESPACE, "references"), RDFValue.class, references);
  }

  /**
   * Related resources.
   *
   * @param relation Related resources.
   * @return The element.
   * @link http://dublincore.org/documents/dcmi-terms/#terms-relation
   */
  @XmlElementDecl ( namespace = CommonModels.DUBLIN_CORE_NAMESPACE, name = "relation" )
  @JsonElementWrapper ( name = "relation" )
  public JAXBElement<RDFValue> createRelationElement(RDFValue relation) {
    return new JAXBElement<RDFValue>(new QName(CommonModels.DUBLIN_CORE_NAMESPACE, "relation"), RDFValue.class, relation);
  }

  /**
   * Related resources that are supplanted, displaced, or superseded by the described resource.
   *
   * @param replaces Related resources that are supplanted, displaced, or superseded by the described resource.
   * @return The element.
   * @link http://dublincore.org/documents/dcmi-terms/#terms-replaces
   */
  @XmlElementDecl ( namespace = CommonModels.DUBLIN_CORE_NAMESPACE, name = "replaces" )
  @JsonElementWrapper ( name = "replaces" )
  public JAXBElement<RDFValue> createReplacesElement(RDFValue replaces) {
    return new JAXBElement<RDFValue>(new QName(CommonModels.DUBLIN_CORE_NAMESPACE, "replaces"), RDFValue.class, replaces);
  }

  /**
   * Related resources that are required by the described resource to support its function, delivery, or coherence.
   *
   * @param requires Related resources that are required by the described resource to support its function, delivery, or coherence.
   * @return The element.
   * @link http://dublincore.org/documents/dcmi-terms/#terms-requires
   */
  @XmlElementDecl ( namespace = CommonModels.DUBLIN_CORE_NAMESPACE, name = "requires" )
  @JsonElementWrapper ( name = "requires" )
  public JAXBElement<RDFValue> createRequiresElement(RDFValue requires) {
    return new JAXBElement<RDFValue>(new QName(CommonModels.DUBLIN_CORE_NAMESPACE, "requires"), RDFValue.class, requires);
  }

  /**
   * Information about rights held in and over the resource.
   *
   * @param rights Information about rights held in and over the resource.
   * @return The element.
   * @link http://dublincore.org/documents/dcmi-terms/#terms-rights
   */
  @XmlElementDecl ( namespace = CommonModels.DUBLIN_CORE_NAMESPACE, name = "rights" )
  @JsonElementWrapper ( name = "rights" )
  public JAXBElement<RDFValue> createRightsElement(RDFValue rights) {
    return new JAXBElement<RDFValue>(new QName(CommonModels.DUBLIN_CORE_NAMESPACE, "rights"), RDFValue.class, rights);
  }

  /**
   * A person or organization owning or managing rights over the resource.
   *
   * @param rightsHolder A person or organization owning or managing rights over the resource.
   * @return The element.
   * @link http://dublincore.org/documents/dcmi-terms/#terms-rightsHolder
   */
  @XmlElementDecl ( namespace = CommonModels.DUBLIN_CORE_NAMESPACE, name = "rightsHolder" )
  @JsonElementWrapper ( name = "rightsHolders" )
  public JAXBElement<RDFValue> createRightsHolderElement(RDFValue rightsHolder) {
    return new JAXBElement<RDFValue>(new QName(CommonModels.DUBLIN_CORE_NAMESPACE, "rightsHolder"), RDFValue.class, rightsHolder);
  }

  /**
   * A related resource from which the described resource is derived.
   *
   * @param source A related resource from which the described resource is derived.
   * @return The element.
   * @link http://dublincore.org/documents/dcmi-terms/#terms-source
   */
  @XmlElementDecl ( namespace = CommonModels.DUBLIN_CORE_NAMESPACE, name = "source" )
  @JsonElementWrapper ( name = "sources" )
  public JAXBElement<RDFValue> createSourceElement(RDFValue source) {
    return new JAXBElement<RDFValue>(new QName(CommonModels.DUBLIN_CORE_NAMESPACE, "source"), RDFValue.class, source);
  }

  /**
   * Spatial characteristics of the resource.
   *
   * @param spatial Spatial characteristics of the resource.
   * @return The element.
   * @link http://dublincore.org/documents/dcmi-terms/#terms-spatial
   */
  @XmlElementDecl ( namespace = CommonModels.DUBLIN_CORE_NAMESPACE, name = "spatial" )
  @JsonElementWrapper ( name = "spatial" )
  public JAXBElement<RDFValue> createSpatialElement(RDFValue spatial) {
    return new JAXBElement<RDFValue>(new QName(CommonModels.DUBLIN_CORE_NAMESPACE, "spatial"), RDFValue.class, spatial);
  }

  /**
   * The topic of the resource. Typically, the subject will be represented using keywords, key phrases, or classification codes.
   * Recommended best practice is to use a controlled vocabulary. To describe the spatial or temporal topic of the resource,
   * use the Coverage element.
   *
   * @param subject The topic of the resource. Typically, the subject will be represented using keywords, key phrases, or classification codes.
   *                Recommended best practice is to use a controlled vocabulary. To describe the spatial or temporal topic of the resource,
   *                use the Coverage element.
   * @return The element.
   * @link http://dublincore.org/documents/dcmi-terms/#terms-subject
   */
  @XmlElementDecl ( namespace = CommonModels.DUBLIN_CORE_NAMESPACE, name = "subject" )
  @JsonElementWrapper ( name = "subjects" )
  public JAXBElement<RDFValue> createSubjectElement(RDFValue subject) {
    return new JAXBElement<RDFValue>(new QName(CommonModels.DUBLIN_CORE_NAMESPACE, "subject"), RDFValue.class, subject);
  }

  /**
   * A list of subunits of the resource.
   *
   * @param tableOfContents A list of subunits of the resource.
   * @return The element.
   * @link http://dublincore.org/documents/dcmi-terms/#terms-tableOfContents
   */
  @XmlElementDecl ( namespace = CommonModels.DUBLIN_CORE_NAMESPACE, name = "tableOfContents" )
  @JsonElementWrapper ( name = "tableOfContents" )
  public JAXBElement<RDFValue> createTableOfContentsElement(RDFValue tableOfContents) {
    return new JAXBElement<RDFValue>(new QName(CommonModels.DUBLIN_CORE_NAMESPACE, "tableOfContents"), RDFValue.class, tableOfContents);
  }

  /**
   * Temporal characteristics of the resource.
   *
   * @param temporal Temporal characteristics of the resource.
   * @return The element.
   * @link http://dublincore.org/documents/dcmi-terms/#terms-temporal
   */
  @XmlElementDecl ( namespace = CommonModels.DUBLIN_CORE_NAMESPACE, name = "temporal" )
  @JsonElementWrapper ( name = "temporal" )
  public JAXBElement<RDFValue> createTemporalElement(RDFValue temporal) {
    return new JAXBElement<RDFValue>(new QName(CommonModels.DUBLIN_CORE_NAMESPACE, "temporal"), RDFValue.class, temporal);
  }

  /**
   * A name given to the resource.
   *
   * @param title A name given to the resource.
   * @return The element.
   * @link http://dublincore.org/documents/dcmi-terms/#terms-title
   */
  @XmlElementDecl ( namespace = CommonModels.DUBLIN_CORE_NAMESPACE, name = "title" )
  @JsonElementWrapper ( name = "titles" )
  public JAXBElement<org.gedcomx.metadata.rdf.RDFLiteral> createTitleElement(org.gedcomx.metadata.rdf.RDFLiteral title) {
    return new JAXBElement<org.gedcomx.metadata.rdf.RDFLiteral>(new QName(CommonModels.DUBLIN_CORE_NAMESPACE, "title"), org.gedcomx.metadata.rdf.RDFLiteral.class, title);
  }

  /**
   * Date of validity of a resource.
   *
   * @param valid Date of validity of a resource.
   * @return The element.
   * @link http://dublincore.org/documents/dcmi-terms/#terms-valid
   */
  @XmlElementDecl ( namespace = CommonModels.DUBLIN_CORE_NAMESPACE, name = "valid" )
  @JsonElementWrapper ( name = "valid" )
  public JAXBElement<RDFLiteral> createValidElement(RDFLiteral valid) {
    return new JAXBElement<RDFLiteral>(new QName(CommonModels.DUBLIN_CORE_NAMESPACE, "valid"), RDFLiteral.class, valid);
  }

}

package org.gedcomx.metadata.dc;

import org.gedcomx.metadata.rdf.Description;
import org.gedcomx.metadata.rdf.RDFLiteral;
import org.gedcomx.metadata.rdf.RDFValue;
import org.testng.annotations.Test;

import javax.xml.bind.JAXBContext;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.gedcomx.rt.SerializationUtil.processThroughJson;
import static org.gedcomx.rt.SerializationUtil.processThroughXml;
import static org.testng.AssertJUnit.assertEquals;

/**
 * @author Ryan Heaton
 */
@Test
public class DublinCoreDescriptionDecoratorTest {

  /**
   * tests id xml
   */
  public void testDublinCoreMetadataXml() throws Exception {
    DublinCoreDescriptionDecorator metadata = createMetadata();
    metadata = DublinCoreDescriptionDecorator.newInstance(processThroughXml(metadata.getDecoratedDescription(), Description.class, JAXBContext.newInstance(Description.class, ObjectFactory.class)));
    assertMetadata(metadata);
  }

  /**
   * tests id json
   */
  public void testDublinCoreMetadataJson() throws Exception {
    DublinCoreDescriptionDecorator metadata = createMetadata();
    metadata = DublinCoreDescriptionDecorator.newInstance(processThroughJson(metadata.getDecoratedDescription(), Description.class));
    assertMetadata(metadata);
  }

  private DublinCoreDescriptionDecorator createMetadata() {
    DublinCoreDescriptionDecorator metadata = DublinCoreDescriptionDecorator.newInstance();
    /**
     * A summary of the resource.
     *
     * @return A summary of the resource.
     *
     * @link http://dublincore.org/documents/dcmi-terms/#terms-abstract
     */
    metadata.abstrct(new RDFValue("abstrct"));

    /**
     * Information about who can access the resource or an indication of its security status. Access Rights may include information
     * regarding access or restrictions based on privacy, security, or other policies.
     *
     * @return Information about who can access the resource or an indication of its security status. Access Rights may include information
     *                     regarding access or restrictions based on privacy, security, or other policies.
     *
     * @link http://dublincore.org/documents/dcmi-terms/#terms-accessRights
     */
    metadata.accessRights(new RDFValue("accessRights"));

    /**
     * The method by which items are added to a collection.
     *
     * @return The method by which items are added to a collection.
     *
     * @link http://dublincore.org/documents/dcmi-terms/#terms-accrualMethod
     */
    metadata.accrualMethod(new RDFValue("accrualMethod"));

    /**
     * The frequency with which items are added to a collection.
     *
     * @return The frequency with which items are added to a collection.
     *
     * @link http://dublincore.org/documents/dcmi-terms/#terms-accrualPeriodicity
     */
    metadata.accrualPeriodicity(new RDFValue("accrualPeriodicity"));

    /**
     * The policy governing the addition of items to a collection.
     *
     * @return The policy governing the addition of items to a collection.
     *
     * @link http://dublincore.org/documents/dcmi-terms/#terms-accrualPolicy
     */
    metadata.accrualPolicy(new RDFValue("accrualPolicy"));

    /**
     * Alternative names for the resource. The distinction between titles and alternative titles is application-specific.
     *
     * @return Alternative names for the resource. The distinction between titles and alternative titles is application-specific.
     *
     * @link http://dublincore.org/documents/dcmi-terms/#terms-alternative
     */
    metadata.alternative(new RDFLiteral("alternative"));

    /**
     * A class of entity for whom the resource is intended or useful.
     *
     * @return A class of entity for whom the resource is intended or useful.
     *
     * @link http://dublincore.org/documents/dcmi-terms/#terms-audience
     */
    metadata.audience(new RDFValue("audience"));

    /**
     * Date that the resource became or will become available.
     *
     * @return Date that the resource became or will become available.
     *
     * @link http://dublincore.org/documents/dcmi-terms/#terms-available
     */
    metadata.available(new Date("available".hashCode()));

    /**
     * A bibliographic reference for the resource. Recommended practice is to include sufficient
     * bibliographic detail to identify the resource as unambiguously as possible.
     *
     * @return A bibliographic reference for the resource. Recommended practice is to include sufficient
     *                              bibliographic detail to identify the resource as unambiguously as possible.
     *
     * @link http://dublincore.org/documents/dcmi-terms/#terms-bibliographicCitation
     */
    metadata.bibliographicCitation(new RDFLiteral("bibliographicCitation"));

    /**
     * Established standards to which the described resource conforms.
     *
     * @return Established standards to which the described resource conforms.
     *
     * @link http://dublincore.org/documents/dcmi-terms/#terms-conformsTo
     */
    metadata.conformsTo(new RDFValue("conformsTo"));

    /**
     * Entities responsible for making contributions to the resource. Examples of a Contributor include a person, an organization, or a service.
     *
     * @return Entities responsible for making contributions to the resource. Examples of a Contributor include a person, an organization, or a service.
     *
     * @link http://dublincore.org/documents/dcmi-terms/#terms-contributor
     */
    metadata.contributor(new RDFValue("contributor"));

    /**
     * The spatial or temporal topic of the resource, the spatial applicability of the resource, or the jurisdiction under which the resource is relevant.
     *
     * @return The spatial or temporal topic of the resource, the spatial applicability of the resource, or the jurisdiction under which the resource is relevant.
     *
     * @link http://dublincore.org/documents/dcmi-terms/#terms-coverage
     */
    metadata.coverage(new RDFValue("coverage"));

    /**
     * Date of creation of the resource.
     *
     * @return Date of creation of the resource.
     *
     * @link http://dublincore.org/documents/dcmi-terms/#terms-created
     */
    metadata.created(new Date("created".hashCode()));

    /**
     * Entities primarily responsible for making the resource.
     *
     * @return Entities primarily responsible for making the resource.
     *
     * @link http://dublincore.org/documents/dcmi-terms/#terms-creator
     */
    metadata.creator(new RDFValue("creator"));

    /**
     * A point or period of time associated with an event in the lifecycle of the resource.
     *
     * @return A point or period of time associated with an event in the lifecycle of the resource.
     *
     * @link http://dublincore.org/documents/dcmi-terms/#terms-date
     */
    metadata.date(new Date("date".hashCode()));

    /**
     * Date of acceptance of the resource.
     *
     * @return Date of acceptance of the resource.
     *
     * @link http://dublincore.org/documents/dcmi-terms/#terms-dateAccepted
     */
    metadata.dateAccepted(new Date("dateAccepted".hashCode()));

    /**
     * Date of copyright.
     *
     * @return Date of copyright.
     *
     * @link http://dublincore.org/documents/dcmi-terms/#terms-dateCopyrighted
     */
    metadata.dateCopyrighted(new Date("dateCopyrighted".hashCode()));

    /**
     * Date of submission of the resource.
     *
     * @return Date of submission of the resource.
     *
     * @link http://dublincore.org/documents/dcmi-terms/#terms-dateSubmitted
     */
    metadata.dateSubmitted(new Date("dateSubmitted".hashCode()));

    /**
     * An account of the resource.
     *
     * @return An account of the resource.
     *
     * @link http://dublincore.org/documents/dcmi-terms/#terms-description
     */
    metadata.description(new RDFValue("description"));

    /**
     * A class of entity, defined in terms of progression through an educational or training context, for which the described resource is intended.
     *
     * @return A class of entity, defined in terms of progression through an educational or training context, for which the described resource is intended.
     *
     * @link http://dublincore.org/documents/dcmi-terms/#terms-educationLevel
     */
    metadata.educationLevel(new RDFValue("educationLevel"));

    /**
     * The size or duration of the resource.
     *
     * @return The size or duration of the resource.
     *
     * @link http://dublincore.org/documents/dcmi-terms/#terms-extent
     */
    metadata.extent(new RDFValue("extent"));

    /**
     * The file format, physical medium, or dimensions of the resource. Examples of dimensions include size and duration. Recommended best practice is
     * to use a controlled vocabulary such as the list of Internet Media Types [MIME].
     *
     * @return The file format, physical medium, or dimensions of the resource. Examples of dimensions include size and duration. Recommended best practice is to
     *               use a controlled vocabulary such as the list of Internet Media Types [MIME].
     *
     * @link http://dublincore.org/documents/dcmi-terms/#terms-format
     */
    metadata.format(new RDFValue("format"));

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
    metadata.hasFormat(new RDFValue("hasFormat"));

    /**
     * Related resources that are included either physically or logically in the described resource.
     *
     * @return Related resources that are included either physically or logically in the described resource.
     *
     * @link http://dublincore.org/documents/dcmi-terms/#terms-hasPart
     */
    metadata.hasPart(new RDFValue("hasPart"));

    /**
     * Related resources that are a version, edition, or adaptation of the described resource.
     *
     * @return Related resources that are a version, edition, or adaptation of the described resource.
     *
     * @link http://dublincore.org/documents/dcmi-terms/#terms-hasVersion
     */
    metadata.hasVersion(new RDFValue("hasVersion"));

    /**
     * An unambiguous reference to the resource within a given context.
     *
     * @return An unambiguous reference to the resource within a given context.
     *
     * @link http://dublincore.org/documents/dcmi-terms/#terms-identifier
     */
    metadata.identifier(new RDFLiteral("identifier"));

    /**
     * A process, used to engender knowledge, attitudes and skills, that the described resource is designed to support.
     *
     * @return A process, used to engender knowledge, attitudes and skills, that the described resource is designed to support.
     *
     * @link http://dublincore.org/documents/dcmi-terms/#terms-instructionalMethod
     */
    metadata.instructionalMethod(new RDFValue("instructionalMethod"));

    /**
     * Related resources that are substantially the same as the described resource, but in another format. In REST terms, the URI of
     * an alternate representation of the same resource. Note that having more than one URI for the same resource is generally bad
     * practice (see http://www.w3.org/TR/webarch/) but still an accepted reality.
     *
     * @return Related resources that are substantially the same as the described resource, but in another format.
     *
     * @link http://dublincore.org/documents/dcmi-terms/#terms-isFormatOf
     */
    metadata.formatOf(new RDFValue("formatOf"));

    /**
     * Related resources in which the described resource is physically or logically included.
     *
     * @return Related resources in which the described resource is physically or logically included.
     *
     * @link http://dublincore.org/documents/dcmi-terms/#terms-isPartOf
     */
    metadata.partOf(new RDFValue("partOf"));

    /**
     * Related resources that reference, cite, or otherwise point to the described resource.
     *
     * @return Related resources that reference, cite, or otherwise point to the described resource.
     *
     * @link http://dublincore.org/documents/dcmi-terms/#terms-isReferencedBy
     */
    metadata.referencedBy(new RDFValue("referencedBy"));

    /**
     * Related resources that supplant, displace, or supersede the described resource.
     *
     * @return Related resources that supplant, displace, or supersede the described resource.
     *
     * @link http://dublincore.org/documents/dcmi-terms/#terms-isReplacedBy
     */
    metadata.replacedBy(new RDFValue("replacedBy"));

    /**
     * Related resources that require the described resource to support its function, delivery, or coherence.
     *
     * @return Related resources that require the described resource to support its function, delivery, or coherence.
     *
     * @link http://dublincore.org/documents/dcmi-terms/#terms-isRequiredBy
     */
    metadata.requiredBy(new RDFValue("requiredBy"));

    /**
     * Date of formal issuance (e.g., publication) of the resource.
     *
     * @return Date of formal issuance (e.g., publication) of the resource.
     *
     * @link http://dublincore.org/documents/dcmi-terms/#terms-issued
     */
    metadata.issued(new Date("issued".hashCode()));

    /**
     * A related resource of which the described resource is a version, edition, or adaptation. Changes in version imply substantive changes
     * in content rather than differences in format.
     *
     * @return A related resource of which the described resource is a version, edition, or adaptation. Changes in version imply substantive
     *                  changes in content rather than differences in format.
     *
     * @link http://dublincore.org/documents/dcmi-terms/#terms-isVersionOf
     */
    metadata.versionOf(new RDFValue("versionOf"));

    /**
     * Languages of the resource. Recommended best practice is to use a controlled vocabulary such as RFC 4646 [RFC4646].
     *
     * @return Languages of the resource. Recommended best practice is to use a controlled vocabulary such as RFC 4646 [RFC4646].
     *
     * @link http://dublincore.org/documents/dcmi-terms/#terms-language
     */
    metadata.language(new RDFValue("language"));

    /**
     * Legal documents giving official permission to do something with the resource.
     *
     * @return Legal documents giving official permission to do something with the resource.
     *
     * @link http://dublincore.org/documents/dcmi-terms/#terms-license
     */
    metadata.license(new RDFValue("license"));

    /**
     * Entities that mediate access to the resource and for whom the resource is intended or useful.
     *
     * @return Entities that mediate access to the resource and for whom the resource is intended or useful.
     *
     * @link http://dublincore.org/documents/dcmi-terms/#terms-mediator
     */
    metadata.mediator(new RDFValue("mediator"));

    /**
     * The material or physical carrier of the resource.
     *
     * @return The material or physical carrier of the resource.
     *
     * @link http://dublincore.org/documents/dcmi-terms/#terms-medium
     */
    metadata.medium(new RDFValue("medium"));

    /**
     * Date on which the resource was changed.
     *
     * @return Date on which the resource was changed.
     *
     * @link http://dublincore.org/documents/dcmi-terms/#terms-modified
     */
    metadata.modified(new Date("modified".hashCode()));

    /**
     * A statement of any changes in ownership and custody of the resource since its creation that are significant for its authenticity, integrity, and interpretation.
     *
     * @return A statement of any changes in ownership and custody of the resource since its creation that are significant for its authenticity, integrity, and interpretation.
     *
     * @link http://dublincore.org/documents/dcmi-terms/#terms-provenance
     */
    metadata.provenance(new RDFValue("provenance"));

    /**
     * An entity responsible for making the resource available.
     *
     * @return An entity responsible for making the resource available.
     *
     * @link http://dublincore.org/documents/dcmi-terms/#terms-publisher
     */
    metadata.publisher(new RDFValue("publisher"));

    /**
     * Related resources that are referenced, cited, or otherwise pointed to by the described resource.
     *
     * @return Related resources that are referenced, cited, or otherwise pointed to by the described resource.
     *
     * @link http://dublincore.org/documents/dcmi-terms/#terms-references
     */
    metadata.references(new RDFValue("references"));

    /**
     * Related resources.
     *
     * @return Related resources.
     *
     * @link http://dublincore.org/documents/dcmi-terms/#terms-relation
     */
    metadata.relation(new RDFValue("relation"));

    /**
     * Related resources that are supplanted, displaced, or superseded by the described resource.
     *
     * @return Related resources that are supplanted, displaced, or superseded by the described resource.
     *
     * @link http://dublincore.org/documents/dcmi-terms/#terms-replaces
     */
    metadata.replaces(new RDFValue("replaces"));

    /**
     * Related resources that are required by the described resource to support its function, delivery, or coherence.
     *
     * @return Related resources that are required by the described resource to support its function, delivery, or coherence.
     *
     * @link http://dublincore.org/documents/dcmi-terms/#terms-requires
     */
    metadata.requires(new RDFValue("requires"));

    /**
     * Information about rights held in and over the resource.
     *
     * @return Information about rights held in and over the resource.
     *
     * @link http://dublincore.org/documents/dcmi-terms/#terms-rights
     */
    metadata.rights(new RDFValue("rights"));

    /**
     * A person or organization owning or managing rights over the resource.
     *
     * @return A person or organization owning or managing rights over the resource.
     *
     * @link http://dublincore.org/documents/dcmi-terms/#terms-rightsHolder
     */
    metadata.rightsHolder(new RDFValue("rightsHolder"));

    /**
     * A related resource from which the described resource is derived.
     *
     * @return A related resource from which the described resource is derived.
     *
     * @link http://dublincore.org/documents/dcmi-terms/#terms-source
     */
    metadata.source(new RDFValue("source"));

    /**
     * Spatial characteristics of the resource.
     *
     * @return Spatial characteristics of the resource.
     *
     * @link http://dublincore.org/documents/dcmi-terms/#terms-spatial
     */
    metadata.spatial(new RDFValue("spatial"));

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
    metadata.subject(new RDFValue("subject"));

    /**
     * A list of subunits of the resource.
     *
     * @return A list of subunits of the resource.
     *
     * @link http://dublincore.org/documents/dcmi-terms/#terms-tableOfContents
     */
    metadata.tableOfContents(new RDFValue("tableOfContents"));

    /**
     * Temporal characteristics of the resource.
     *
     * @return Temporal characteristics of the resource.
     *
     * @link http://dublincore.org/documents/dcmi-terms/#terms-temporal
     */
    metadata.temporal(new RDFValue("temporal"));

    /**
     * A name given to the resource.
     *
     * @return A name given to the resource.
     *
     * @link http://dublincore.org/documents/dcmi-terms/#terms-title
     */
    metadata.title(new RDFLiteral("title"));

    /**
     * Date of validity of a resource.
     *
     * @return Date of validity of a resource.
     *
     * @link http://dublincore.org/documents/dcmi-terms/#terms-valid
     */
    metadata.valid(new Date("valid".hashCode()));
    return metadata;
  }

  private void assertMetadata(DublinCoreDescriptionDecorator metadata) {
    /**
     * A summary of the resource.
     *
     * @return A summary of the resource.
     *
     * @link http://dublincore.org/documents/dcmi-terms/#terms-abstract
     */
    assertEquals(1, metadata.getAbstract().size());
    assertEquals("abstrct", metadata.getAbstract().get(0).getValue());

    /**
     * Information about who can access the resource or an indication of its security status. Access Rights may include information
     * regarding access or restrictions based on privacy, security, or other policies.
     *
     * @return Information about who can access the resource or an indication of its security status. Access Rights may include information
     *                     regarding access or restrictions based on privacy, security, or other policies.
     *
     * @link http://dublincore.org/documents/dcmi-terms/#terms-accessRights
     */
    assertEquals(1, metadata.getAccessRights().size());
    assertEquals("accessRights", metadata.getAccessRights().get(0).getValue());

    /**
     * The method by which items are added to a collection.
     *
     * @return The method by which items are added to a collection.
     *
     * @link http://dublincore.org/documents/dcmi-terms/#terms-accrualMethod
     */
    assertEquals(1, metadata.getAccrualMethod().size());
    assertEquals("accrualMethod", metadata.getAccrualMethod().get(0).getValue());

    /**
     * The frequency with which items are added to a collection.
     *
     * @return The frequency with which items are added to a collection.
     *
     * @link http://dublincore.org/documents/dcmi-terms/#terms-accrualPeriodicity
     */
    assertEquals(1, metadata.getAccrualPeriodicity().size());
    assertEquals("accrualPeriodicity", metadata.getAccrualPeriodicity().get(0).getValue());

    /**
     * The policy governing the addition of items to a collection.
     *
     * @return The policy governing the addition of items to a collection.
     *
     * @link http://dublincore.org/documents/dcmi-terms/#terms-accrualPolicy
     */
    assertEquals(1, metadata.getAccrualPolicy().size());
    assertEquals("accrualPolicy", metadata.getAccrualPolicy().get(0).getValue());

    /**
     * Alternative names for the resource. The distinction between titles and alternative titles is application-specific.
     *
     * @return Alternative names for the resource. The distinction between titles and alternative titles is application-specific.
     *
     * @link http://dublincore.org/documents/dcmi-terms/#terms-alternative
     */
    assertEquals(1, metadata.getAlternative().size());
    assertEquals("alternative", metadata.getAlternative().get(0).getValue());

    /**
     * A class of entity for whom the resource is intended or useful.
     *
     * @return A class of entity for whom the resource is intended or useful.
     *
     * @link http://dublincore.org/documents/dcmi-terms/#terms-audience
     */
    assertEquals(1, metadata.getAudience().size());
    assertEquals("audience", metadata.getAudience().get(0).getValue());

    /**
     * Date that the resource became or will become available.
     *
     * @return Date that the resource became or will become available.
     *
     * @link http://dublincore.org/documents/dcmi-terms/#terms-available
     */
    assertEquals(1, metadata.getAvailable().size());
    assertEquals("available".hashCode(), metadata.getAvailable().get(0).getTime());

    /**
     * A bibliographic reference for the resource. Recommended practice is to include sufficient
     * bibliographic detail to identify the resource as unambiguously as possible.
     *
     * @return A bibliographic reference for the resource. Recommended practice is to include sufficient
     *                              bibliographic detail to identify the resource as unambiguously as possible.
     *
     * @link http://dublincore.org/documents/dcmi-terms/#terms-bibliographicCitation
     */
    assertEquals(1, metadata.getBibliographicCitation().size());
    assertEquals("bibliographicCitation", metadata.getBibliographicCitation().get(0).getValue());

    /**
     * Established standards to which the described resource conforms.
     *
     * @return Established standards to which the described resource conforms.
     *
     * @link http://dublincore.org/documents/dcmi-terms/#terms-conformsTo
     */
    assertEquals(1, metadata.getConformsTo().size());
    assertEquals("conformsTo", metadata.getConformsTo().get(0).getValue());

    /**
     * Entities responsible for making contributions to the resource. Examples of a Contributor include a person, an organization, or a service.
     *
     * @return Entities responsible for making contributions to the resource. Examples of a Contributor include a person, an organization, or a service.
     *
     * @link http://dublincore.org/documents/dcmi-terms/#terms-contributor
     */
    assertEquals(1, metadata.getContributor().size());
    assertEquals("contributor", metadata.getContributor().get(0).getValue());

    /**
     * The spatial or temporal topic of the resource, the spatial applicability of the resource, or the jurisdiction under which the resource is relevant.
     *
     * @return The spatial or temporal topic of the resource, the spatial applicability of the resource, or the jurisdiction under which the resource is relevant.
     *
     * @link http://dublincore.org/documents/dcmi-terms/#terms-coverage
     */
    assertEquals(1, metadata.getCoverage().size());
    assertEquals("coverage", metadata.getCoverage().get(0).getValue());

    /**
     * Date of creation of the resource.
     *
     * @return Date of creation of the resource.
     *
     * @link http://dublincore.org/documents/dcmi-terms/#terms-created
     */
    assertEquals(1, metadata.getCreatedAsDate().size());
    Date date = metadata.getCreatedAsDate().get(0);
    assertEquals("created".hashCode(), date.getTime());
    SimpleDateFormat dateFormat = (SimpleDateFormat)DateFormat.getDateTimeInstance();
    dateFormat.applyPattern("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
    StringBuilder builder = new StringBuilder(dateFormat.format(date));
    builder.insert(builder.length() - 2, ':');
    assertEquals(1, metadata.getCreated().size());
    assertEquals(builder.toString(), metadata.getCreated().get(0).getValue());

    /**
     * Entities primarily responsible for making the resource.
     *
     * @return Entities primarily responsible for making the resource.
     *
     * @link http://dublincore.org/documents/dcmi-terms/#terms-creator
     */
    assertEquals(1, metadata.getCreator().size());
    assertEquals("creator", metadata.getCreator().get(0).getValue());

    /**
     * A point or period of time associated with an event in the lifecycle of the resource.
     *
     * @return A point or period of time associated with an event in the lifecycle of the resource.
     *
     * @link http://dublincore.org/documents/dcmi-terms/#terms-date
     */
    assertEquals(1, metadata.getDate().size());
    assertEquals("date".hashCode(), metadata.getDate().get(0).getTime());

    /**
     * Date of acceptance of the resource.
     *
     * @return Date of acceptance of the resource.
     *
     * @link http://dublincore.org/documents/dcmi-terms/#terms-dateAccepted
     */
    assertEquals(1, metadata.getDateAccepted().size());
    assertEquals("dateAccepted".hashCode(), metadata.getDateAccepted().get(0).getTime());

    /**
     * Date of copyright.
     *
     * @return Date of copyright.
     *
     * @link http://dublincore.org/documents/dcmi-terms/#terms-dateCopyrighted
     */
    assertEquals(1, metadata.getDateCopyrighted().size());
    assertEquals("dateCopyrighted".hashCode(), metadata.getDateCopyrighted().get(0).getTime());

    /**
     * Date of submission of the resource.
     *
     * @return Date of submission of the resource.
     *
     * @link http://dublincore.org/documents/dcmi-terms/#terms-dateSubmitted
     */
    assertEquals(1, metadata.getDateSubmitted().size());
    assertEquals("dateSubmitted".hashCode(), metadata.getDateSubmitted().get(0).getTime());

    /**
     * An account of the resource.
     *
     * @return An account of the resource.
     *
     * @link http://dublincore.org/documents/dcmi-terms/#terms-description
     */
    assertEquals(1, metadata.getDescription().size());
    assertEquals("description", metadata.getDescription().get(0).getValue());

    /**
     * A class of entity, defined in terms of progression through an educational or training context, for which the described resource is intended.
     *
     * @return A class of entity, defined in terms of progression through an educational or training context, for which the described resource is intended.
     *
     * @link http://dublincore.org/documents/dcmi-terms/#terms-educationLevel
     */
    assertEquals(1, metadata.getEducationLevel().size());
    assertEquals("educationLevel", metadata.getEducationLevel().get(0).getValue());

    /**
     * The size or duration of the resource.
     *
     * @return The size or duration of the resource.
     *
     * @link http://dublincore.org/documents/dcmi-terms/#terms-extent
     */
    assertEquals(1, metadata.getExtent().size());
    assertEquals("extent", metadata.getExtent().get(0).getValue());

    /**
     * The file format, physical medium, or dimensions of the resource. Examples of dimensions include size and duration. Recommended best practice is
     * to use a controlled vocabulary such as the list of Internet Media Types [MIME].
     *
     * @return The file format, physical medium, or dimensions of the resource. Examples of dimensions include size and duration. Recommended best practice is to
     *               use a controlled vocabulary such as the list of Internet Media Types [MIME].
     *
     * @link http://dublincore.org/documents/dcmi-terms/#terms-format
     */
    assertEquals(1, metadata.getFormat().size());
    assertEquals("format", metadata.getFormat().get(0).getValue());

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
    assertEquals(1, metadata.getHasFormat().size());
    assertEquals("hasFormat", metadata.getHasFormat().get(0).getValue());

    /**
     * Related resources that are included either physically or logically in the described resource.
     *
     * @return Related resources that are included either physically or logically in the described resource.
     *
     * @link http://dublincore.org/documents/dcmi-terms/#terms-hasPart
     */
    assertEquals(1, metadata.getHasPart().size());
    assertEquals("hasPart", metadata.getHasPart().get(0).getValue());

    /**
     * Related resources that are a version, edition, or adaptation of the described resource.
     *
     * @return Related resources that are a version, edition, or adaptation of the described resource.
     *
     * @link http://dublincore.org/documents/dcmi-terms/#terms-hasVersion
     */
    assertEquals(1, metadata.getHasVersion().size());
    assertEquals("hasVersion", metadata.getHasVersion().get(0).getValue());

    /**
     * An unambiguous reference to the resource within a given context.
     *
     * @return An unambiguous reference to the resource within a given context.
     *
     * @link http://dublincore.org/documents/dcmi-terms/#terms-identifier
     */
    assertEquals(1, metadata.getIdentifier().size());
    assertEquals("identifier", metadata.getIdentifier().get(0).getValue());

    /**
     * A process, used to engender knowledge, attitudes and skills, that the described resource is designed to support.
     *
     * @return A process, used to engender knowledge, attitudes and skills, that the described resource is designed to support.
     *
     * @link http://dublincore.org/documents/dcmi-terms/#terms-instructionalMethod
     */
    assertEquals(1, metadata.getInstructionalMethod().size());
    assertEquals("instructionalMethod", metadata.getInstructionalMethod().get(0).getValue());

    /**
     * Related resources that are substantially the same as the described resource, but in another format. In REST terms, the URI of
     * an alternate representation of the same resource. Note that having more than one URI for the same resource is generally bad
     * practice (see http://www.w3.org/TR/webarch/) but still an accepted reality.
     *
     * @return Related resources that are substantially the same as the described resource, but in another format.
     *
     * @link http://dublincore.org/documents/dcmi-terms/#terms-isFormatOf
     */
    assertEquals(1, metadata.getIsFormatOf().size());
    assertEquals("formatOf", metadata.getIsFormatOf().get(0).getValue());

    /**
     * Related resources in which the described resource is physically or logically included.
     *
     * @return Related resources in which the described resource is physically or logically included.
     *
     * @link http://dublincore.org/documents/dcmi-terms/#terms-isPartOf
     */
    assertEquals(1, metadata.getIsPartOf().size());
    assertEquals("partOf", metadata.getIsPartOf().get(0).getValue());

    /**
     * Related resources that reference, cite, or otherwise point to the described resource.
     *
     * @return Related resources that reference, cite, or otherwise point to the described resource.
     *
     * @link http://dublincore.org/documents/dcmi-terms/#terms-isReferencedBy
     */
    assertEquals(1, metadata.getIsReferencedBy().size());
    assertEquals("referencedBy", metadata.getIsReferencedBy().get(0).getValue());

    /**
     * Related resources that supplant, displace, or supersede the described resource.
     *
     * @return Related resources that supplant, displace, or supersede the described resource.
     *
     * @link http://dublincore.org/documents/dcmi-terms/#terms-isReplacedBy
     */
    assertEquals(1, metadata.getIsReplacedBy().size());
    assertEquals("replacedBy", metadata.getIsReplacedBy().get(0).getValue());

    /**
     * Related resources that require the described resource to support its function, delivery, or coherence.
     *
     * @return Related resources that require the described resource to support its function, delivery, or coherence.
     *
     * @link http://dublincore.org/documents/dcmi-terms/#terms-isRequiredBy
     */
    assertEquals(1, metadata.getIsRequiredBy().size());
    assertEquals("requiredBy", metadata.getIsRequiredBy().get(0).getValue());

    /**
     * Date of formal issuance (e.g., publication) of the resource.
     *
     * @return Date of formal issuance (e.g., publication) of the resource.
     *
     * @link http://dublincore.org/documents/dcmi-terms/#terms-issued
     */
    assertEquals(1, metadata.getIssued().size());
    assertEquals("issued".hashCode(), metadata.getIssued().get(0).getTime());

    /**
     * A related resource of which the described resource is a version, edition, or adaptation. Changes in version imply substantive changes
     * in content rather than differences in format.
     *
     * @return A related resource of which the described resource is a version, edition, or adaptation. Changes in version imply substantive
     *                  changes in content rather than differences in format.
     *
     * @link http://dublincore.org/documents/dcmi-terms/#terms-isVersionOf
     */
    assertEquals(1, metadata.getIsVersionOf().size());
    assertEquals("versionOf", metadata.getIsVersionOf().get(0).getValue());

    /**
     * Languages of the resource. Recommended best practice is to use a controlled vocabulary such as RFC 4646 [RFC4646].
     *
     * @return Languages of the resource. Recommended best practice is to use a controlled vocabulary such as RFC 4646 [RFC4646].
     *
     * @link http://dublincore.org/documents/dcmi-terms/#terms-language
     */
    assertEquals(1, metadata.getLanguage().size());
    assertEquals("language", metadata.getLanguage().get(0).getValue());

    /**
     * Legal documents giving official permission to do something with the resource.
     *
     * @return Legal documents giving official permission to do something with the resource.
     *
     * @link http://dublincore.org/documents/dcmi-terms/#terms-license
     */
    assertEquals(1, metadata.getLicense().size());
    assertEquals("license", metadata.getLicense().get(0).getValue());

    /**
     * Entities that mediate access to the resource and for whom the resource is intended or useful.
     *
     * @return Entities that mediate access to the resource and for whom the resource is intended or useful.
     *
     * @link http://dublincore.org/documents/dcmi-terms/#terms-mediator
     */
    assertEquals(1, metadata.getMediator().size());
    assertEquals("mediator", metadata.getMediator().get(0).getValue());

    /**
     * The material or physical carrier of the resource.
     *
     * @return The material or physical carrier of the resource.
     *
     * @link http://dublincore.org/documents/dcmi-terms/#terms-medium
     */
    assertEquals(1, metadata.getMedium().size());
    assertEquals("medium", metadata.getMedium().get(0).getValue());

    /**
     * Date on which the resource was changed.
     *
     * @return Date on which the resource was changed.
     *
     * @link http://dublincore.org/documents/dcmi-terms/#terms-modified
     */
    assertEquals(1, metadata.getModified().size());
    assertEquals("modified".hashCode(), metadata.getModified().get(0).getTime());

    /**
     * A statement of any changes in ownership and custody of the resource since its creation that are significant for its authenticity, integrity, and interpretation.
     *
     * @return A statement of any changes in ownership and custody of the resource since its creation that are significant for its authenticity, integrity, and interpretation.
     *
     * @link http://dublincore.org/documents/dcmi-terms/#terms-provenance
     */
    assertEquals(1, metadata.getProvenance().size());
    assertEquals("provenance", metadata.getProvenance().get(0).getValue());

    /**
     * An entity responsible for making the resource available.
     *
     * @return An entity responsible for making the resource available.
     *
     * @link http://dublincore.org/documents/dcmi-terms/#terms-publisher
     */
    assertEquals(1, metadata.getPublisher().size());
    assertEquals("publisher", metadata.getPublisher().get(0).getValue());

    /**
     * Related resources that are referenced, cited, or otherwise pointed to by the described resource.
     *
     * @return Related resources that are referenced, cited, or otherwise pointed to by the described resource.
     *
     * @link http://dublincore.org/documents/dcmi-terms/#terms-references
     */
    assertEquals(1, metadata.getReferences().size());
    assertEquals("references", metadata.getReferences().get(0).getValue());

    /**
     * Related resources.
     *
     * @return Related resources.
     *
     * @link http://dublincore.org/documents/dcmi-terms/#terms-relation
     */
    assertEquals(1, metadata.getRelation().size());
    assertEquals("relation", metadata.getRelation().get(0).getValue());

    /**
     * Related resources that are supplanted, displaced, or superseded by the described resource.
     *
     * @return Related resources that are supplanted, displaced, or superseded by the described resource.
     *
     * @link http://dublincore.org/documents/dcmi-terms/#terms-replaces
     */
    assertEquals(1, metadata.getReplaces().size());
    assertEquals("replaces", metadata.getReplaces().get(0).getValue());

    /**
     * Related resources that are required by the described resource to support its function, delivery, or coherence.
     *
     * @return Related resources that are required by the described resource to support its function, delivery, or coherence.
     *
     * @link http://dublincore.org/documents/dcmi-terms/#terms-requires
     */
    assertEquals(1, metadata.getRequires().size());
    assertEquals("requires", metadata.getRequires().get(0).getValue());

    /**
     * Information about rights held in and over the resource.
     *
     * @return Information about rights held in and over the resource.
     *
     * @link http://dublincore.org/documents/dcmi-terms/#terms-rights
     */
    assertEquals(1, metadata.getRights().size());
    assertEquals("rights", metadata.getRights().get(0).getValue());

    /**
     * A person or organization owning or managing rights over the resource.
     *
     * @return A person or organization owning or managing rights over the resource.
     *
     * @link http://dublincore.org/documents/dcmi-terms/#terms-rightsHolder
     */
    assertEquals(1, metadata.getRightsHolder().size());
    assertEquals("rightsHolder", metadata.getRightsHolder().get(0).getValue());

    /**
     * A related resource from which the described resource is derived.
     *
     * @return A related resource from which the described resource is derived.
     *
     * @link http://dublincore.org/documents/dcmi-terms/#terms-source
     */
    assertEquals(1, metadata.getSource().size());
    assertEquals("source", metadata.getSource().get(0).getValue());

    /**
     * Spatial characteristics of the resource.
     *
     * @return Spatial characteristics of the resource.
     *
     * @link http://dublincore.org/documents/dcmi-terms/#terms-spatial
     */
    assertEquals(1, metadata.getSpatial().size());
    assertEquals("spatial", metadata.getSpatial().get(0).getValue());

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
    assertEquals(1, metadata.getSubject().size());
    assertEquals("subject", metadata.getSubject().get(0).getValue());

    /**
     * A list of subunits of the resource.
     *
     * @return A list of subunits of the resource.
     *
     * @link http://dublincore.org/documents/dcmi-terms/#terms-tableOfContents
     */
    assertEquals(1, metadata.getTableOfContents().size());
    assertEquals("tableOfContents", metadata.getTableOfContents().get(0).getValue());

    /**
     * Temporal characteristics of the resource.
     *
     * @return Temporal characteristics of the resource.
     *
     * @link http://dublincore.org/documents/dcmi-terms/#terms-temporal
     */
    assertEquals(1, metadata.getTemporal().size());
    assertEquals("temporal", metadata.getTemporal().get(0).getValue());

    /**
     * A name given to the resource.
     *
     * @return A name given to the resource.
     *
     * @link http://dublincore.org/documents/dcmi-terms/#terms-title
     */
    assertEquals(1, metadata.getTitle().size());
    assertEquals("title", metadata.getTitle().get(0).getValue());

    /**
     * Date of validity of a resource.
     *
     * @return Date of validity of a resource.
     *
     * @link http://dublincore.org/documents/dcmi-terms/#terms-valid
     */
    assertEquals(1, metadata.getValid().size());
    assertEquals("valid".hashCode(), metadata.getValid().get(0).getTime());
  }

}

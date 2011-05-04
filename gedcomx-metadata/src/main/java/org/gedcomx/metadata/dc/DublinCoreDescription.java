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

import org.gedcomx.metadata.rdf.RDFDataDescription;

import java.util.List;

/**
 * @author Ryan Heaton
 */
public class DublinCoreDescription extends RDFDataDescription {

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

  public List<DublinCoreStringProperty> getAbstract() {
    return abstrct;
  }

  public void setAbstract(List<DublinCoreStringProperty> abstrct) {
    this.abstrct = abstrct;
  }

  public List<DublinCoreStringProperty> getAccessRights() {
    return accessRights;
  }

  public void setAccessRights(List<DublinCoreStringProperty> accessRights) {
    this.accessRights = accessRights;
  }

  public List<DublinCoreStringProperty> getAccrualMethod() {
    return accrualMethod;
  }

  public void setAccrualMethod(List<DublinCoreStringProperty> accrualMethod) {
    this.accrualMethod = accrualMethod;
  }

  public List<DublinCoreStringProperty> getAccrualPeriodicity() {
    return accrualPeriodicity;
  }

  public void setAccrualPeriodicity(List<DublinCoreStringProperty> accrualPeriodicity) {
    this.accrualPeriodicity = accrualPeriodicity;
  }

  public List<DublinCoreStringProperty> getAccrualPolicy() {
    return accrualPolicy;
  }

  public void setAccrualPolicy(List<DublinCoreStringProperty> accrualPolicy) {
    this.accrualPolicy = accrualPolicy;
  }

  public List<DublinCoreStringProperty> getAlternative() {
    return alternative;
  }

  public void setAlternative(List<DublinCoreStringProperty> alternative) {
    this.alternative = alternative;
  }

  public List<DublinCoreStringProperty> getAudience() {
    return audience;
  }

  public void setAudience(List<DublinCoreStringProperty> audience) {
    this.audience = audience;
  }

  public List<DublinCoreDateProperty> getAvailable() {
    return available;
  }

  public void setAvailable(List<DublinCoreDateProperty> available) {
    this.available = available;
  }

  public List<DublinCoreStringProperty> getBibliographicCitation() {
    return bibliographicCitation;
  }

  public void setBibliographicCitation(List<DublinCoreStringProperty> bibliographicCitation) {
    this.bibliographicCitation = bibliographicCitation;
  }

  public List<DublinCoreStringProperty> getConformsTo() {
    return conformsTo;
  }

  public void setConformsTo(List<DublinCoreStringProperty> conformsTo) {
    this.conformsTo = conformsTo;
  }

  public List<DublinCoreStringProperty> getContributor() {
    return contributor;
  }

  public void setContributor(List<DublinCoreStringProperty> contributor) {
    this.contributor = contributor;
  }

  public List<DublinCoreStringProperty> getCoverage() {
    return coverage;
  }

  public void setCoverage(List<DublinCoreStringProperty> coverage) {
    this.coverage = coverage;
  }

  public List<DublinCoreDateProperty> getCreated() {
    return created;
  }

  public void setCreated(List<DublinCoreDateProperty> created) {
    this.created = created;
  }

  public List<DublinCoreStringProperty> getCreator() {
    return creator;
  }

  public void setCreator(List<DublinCoreStringProperty> creator) {
    this.creator = creator;
  }

  public List<DublinCoreDateProperty> getDate() {
    return date;
  }

  public void setDate(List<DublinCoreDateProperty> date) {
    this.date = date;
  }

  public List<DublinCoreDateProperty> getDateAccepted() {
    return dateAccepted;
  }

  public void setDateAccepted(List<DublinCoreDateProperty> dateAccepted) {
    this.dateAccepted = dateAccepted;
  }

  public List<DublinCoreDateProperty> getDateCopyrighted() {
    return dateCopyrighted;
  }

  public void setDateCopyrighted(List<DublinCoreDateProperty> dateCopyrighted) {
    this.dateCopyrighted = dateCopyrighted;
  }

  public List<DublinCoreDateProperty> getDateSubmitted() {
    return dateSubmitted;
  }

  public void setDateSubmitted(List<DublinCoreDateProperty> dateSubmitted) {
    this.dateSubmitted = dateSubmitted;
  }

  public List<DublinCoreStringProperty> getDescription() {
    return description;
  }

  public void setDescription(List<DublinCoreStringProperty> description) {
    this.description = description;
  }

  public List<DublinCoreStringProperty> getEducationLevel() {
    return educationLevel;
  }

  public void setEducationLevel(List<DublinCoreStringProperty> educationLevel) {
    this.educationLevel = educationLevel;
  }

  public List<DublinCoreStringProperty> getExtent() {
    return extent;
  }

  public void setExtent(List<DublinCoreStringProperty> extent) {
    this.extent = extent;
  }

  public List<DublinCoreStringProperty> getFormat() {
    return format;
  }

  public void setFormat(List<DublinCoreStringProperty> format) {
    this.format = format;
  }

  public List<DublinCoreStringProperty> getHasFormat() {
    return hasFormat;
  }

  public void setHasFormat(List<DublinCoreStringProperty> hasFormat) {
    this.hasFormat = hasFormat;
  }

  public List<DublinCoreStringProperty> getHasPart() {
    return hasPart;
  }

  public void setHasPart(List<DublinCoreStringProperty> hasPart) {
    this.hasPart = hasPart;
  }

  public List<DublinCoreStringProperty> getHasVersion() {
    return hasVersion;
  }

  public void setHasVersion(List<DublinCoreStringProperty> hasVersion) {
    this.hasVersion = hasVersion;
  }

  public List<DublinCoreStringProperty> getIdentifier() {
    return identifier;
  }

  public void setIdentifier(List<DublinCoreStringProperty> identifier) {
    this.identifier = identifier;
  }

  public List<DublinCoreStringProperty> getInstructionalMethod() {
    return instructionalMethod;
  }

  public void setInstructionalMethod(List<DublinCoreStringProperty> instructionalMethod) {
    this.instructionalMethod = instructionalMethod;
  }

  public List<DublinCoreStringProperty> getFormatOf() {
    return isFormatOf;
  }

  public void setFormatOf(List<DublinCoreStringProperty> formatOf) {
    isFormatOf = formatOf;
  }

  public List<DublinCoreStringProperty> getPartOf() {
    return isPartOf;
  }

  public void setPartOf(List<DublinCoreStringProperty> partOf) {
    isPartOf = partOf;
  }

  public List<DublinCoreStringProperty> getReferencedBy() {
    return isReferencedBy;
  }

  public void setReferencedBy(List<DublinCoreStringProperty> referencedBy) {
    isReferencedBy = referencedBy;
  }

  public List<DublinCoreStringProperty> getReplacedBy() {
    return isReplacedBy;
  }

  public void setReplacedBy(List<DublinCoreStringProperty> replacedBy) {
    isReplacedBy = replacedBy;
  }

  public List<DublinCoreStringProperty> getRequiredBy() {
    return isRequiredBy;
  }

  public void setRequiredBy(List<DublinCoreStringProperty> requiredBy) {
    isRequiredBy = requiredBy;
  }

  public List<DublinCoreDateProperty> getIssued() {
    return issued;
  }

  public void setIssued(List<DublinCoreDateProperty> issued) {
    this.issued = issued;
  }

  public List<DublinCoreStringProperty> getVersionOf() {
    return isVersionOf;
  }

  public void setVersionOf(List<DublinCoreStringProperty> versionOf) {
    isVersionOf = versionOf;
  }

  public List<DublinCoreStringProperty> getLanguage() {
    return language;
  }

  public void setLanguage(List<DublinCoreStringProperty> language) {
    this.language = language;
  }

  public List<DublinCoreStringProperty> getLicense() {
    return license;
  }

  public void setLicense(List<DublinCoreStringProperty> license) {
    this.license = license;
  }

  public List<DublinCoreStringProperty> getMediator() {
    return mediator;
  }

  public void setMediator(List<DublinCoreStringProperty> mediator) {
    this.mediator = mediator;
  }

  public List<DublinCoreStringProperty> getMedium() {
    return medium;
  }

  public void setMedium(List<DublinCoreStringProperty> medium) {
    this.medium = medium;
  }

  public List<DublinCoreDateProperty> getModified() {
    return modified;
  }

  public void setModified(List<DublinCoreDateProperty> modified) {
    this.modified = modified;
  }

  public List<DublinCoreStringProperty> getProvenance() {
    return provenance;
  }

  public void setProvenance(List<DublinCoreStringProperty> provenance) {
    this.provenance = provenance;
  }

  public List<DublinCoreStringProperty> getPublisher() {
    return publisher;
  }

  public void setPublisher(List<DublinCoreStringProperty> publisher) {
    this.publisher = publisher;
  }

  public List<DublinCoreStringProperty> getReferences() {
    return references;
  }

  public void setReferences(List<DublinCoreStringProperty> references) {
    this.references = references;
  }

  public List<DublinCoreStringProperty> getRelation() {
    return relation;
  }

  public void setRelation(List<DublinCoreStringProperty> relation) {
    this.relation = relation;
  }

  public List<DublinCoreStringProperty> getReplaces() {
    return replaces;
  }

  public void setReplaces(List<DublinCoreStringProperty> replaces) {
    this.replaces = replaces;
  }

  public List<DublinCoreStringProperty> getRequires() {
    return requires;
  }

  public void setRequires(List<DublinCoreStringProperty> requires) {
    this.requires = requires;
  }

  public List<DublinCoreStringProperty> getRights() {
    return rights;
  }

  public void setRights(List<DublinCoreStringProperty> rights) {
    this.rights = rights;
  }

  public List<DublinCoreStringProperty> getRightsHolder() {
    return rightsHolder;
  }

  public void setRightsHolder(List<DublinCoreStringProperty> rightsHolder) {
    this.rightsHolder = rightsHolder;
  }

  public List<DublinCoreStringProperty> getSource() {
    return source;
  }

  public void setSource(List<DublinCoreStringProperty> source) {
    this.source = source;
  }

  public List<DublinCoreStringProperty> getSpatial() {
    return spatial;
  }

  public void setSpatial(List<DublinCoreStringProperty> spatial) {
    this.spatial = spatial;
  }

  public List<DublinCoreStringProperty> getSubject() {
    return subject;
  }

  public void setSubject(List<DublinCoreStringProperty> subject) {
    this.subject = subject;
  }

  public List<DublinCoreStringProperty> getTableOfContents() {
    return tableOfContents;
  }

  public void setTableOfContents(List<DublinCoreStringProperty> tableOfContents) {
    this.tableOfContents = tableOfContents;
  }

  public List<DublinCoreStringProperty> getTemporal() {
    return temporal;
  }

  public void setTemporal(List<DublinCoreStringProperty> temporal) {
    this.temporal = temporal;
  }

  public List<DublinCoreStringProperty> getTitle() {
    return title;
  }

  public void setTitle(List<DublinCoreStringProperty> title) {
    this.title = title;
  }

  public List<DublinCoreTypeProperty> getType() {
    return type;
  }

  public void setType(List<DublinCoreTypeProperty> type) {
    this.type = type;
  }

  public List<DublinCoreDateProperty> getValid() {
    return valid;
  }

  public void setValid(List<DublinCoreDateProperty> valid) {
    this.valid = valid;
  }
}

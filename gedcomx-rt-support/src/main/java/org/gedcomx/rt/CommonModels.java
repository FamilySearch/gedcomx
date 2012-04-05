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
package org.gedcomx.rt;

import javax.xml.bind.annotation.XmlTransient;

/**
 * @author Ryan Heaton
 */
@XmlTransient
@Models ( {
  @Model (
    id = "gx",
    namespace = CommonModels.GEDCOMX_COMMON_NAMESPACE,
    projectId = CommonModels.GEDCOMX_PROJECT_ID,
    label = "Common Model",
    description = "The common model defines the types and elements that are common to all model.",
    version = "v1",
    xmlMediaType = CommonModels.GEDCOMX_COMMON_XML_MEDIA_TYPE,
    jsonMediaType = CommonModels.GEDCOMX_COMMON_JSON_MEDIA_TYPE,
    definesRDFSchema = true
  ),
  @Model (
    id = "rdf",
    namespace = CommonModels.RDF_NAMESPACE,
    projectId = CommonModels.GEDCOMX_PROJECT_ID,
    label = "RDF Model",
    description = "The RDF model defines metadata in RDF format.",
    version = "1999-02-22",
    xmlMediaType = CommonModels.RDF_XML_MEDIA_TYPE,
    jsonMediaType = CommonModels.RDF_JSON_MEDIA_TYPE,
    definesRDFSchema = true
  ),
  @Model (
    id = "dctypes",
    projectId = CommonModels.GEDCOMX_PROJECT_ID,
    namespace = CommonModels.DUBLIN_CORE_TYPE_NAMESPACE,
    label = "Dublin Core Types Model",
    description = "The Dublin Core Types model defines the types of Dublin Core metadata.",
    version = "2010-10-11",
    definesRDFSchema = true
  ),
  @Model (
    id = "foaf",
    projectId = CommonModels.GEDCOMX_PROJECT_ID,
    namespace = CommonModels.FOAF_NAMESPACE,
    label = "FOAF Model",
    description = "The FOAF model defines the types and elements used to represent metadata about users, organizations, and projects.",
    version = "0.1",
    xmlMediaType = CommonModels.RDF_XML_MEDIA_TYPE,
    jsonMediaType = CommonModels.RDF_JSON_MEDIA_TYPE,
    definesRDFSchema = true
  ),
  @Model (
    id = "contact",
    projectId = CommonModels.GEDCOMX_PROJECT_ID,
    namespace = CommonModels.CONTACT_NAMESPACE,
    label = "Contact Model",
    description = "The contact model defines the vocabulary for contact information, e.g. for users or organizations.",
    version = "2000-10",
    definesRDFSchema = true
  )
} )
public class CommonModels {

  private CommonModels() {}

  public static final String GEDCOMX_DOMAIN = "http://gedcomx.org/";
  public static final String GEDCOMX_PROJECT_ID = "gedcomx";

  public static final String GEDCOMX_COMMON_NAMESPACE = "http://gedcomx.org/";
  public static final String GEDCOMX_COMMON_XML_MEDIA_TYPE = "application/x-gedcom+xml";
  public static final String GEDCOMX_COMMON_JSON_MEDIA_TYPE = "application/x-gedcom+json";

  public static final String RDF_NAMESPACE = "http://www.w3.org/1999/02/22-rdf-syntax-ns#";
  public static final String RDFS_NAMESPACE    = "http://www.w3.org/2000/01/rdf-schema#";
  public static final String RDF_XML_MEDIA_TYPE = "application/rdf+xml";
  public static final String RDF_JSON_MEDIA_TYPE = "application/rdf+json";

  public static final String DUBLIN_CORE_NAMESPACE = "http://purl.org/dc/terms/";
  public static final String DUBLIN_CORE_TYPE_NAMESPACE = "http://purl.org/dc/dcmitype/";
  public static final String FOAF_NAMESPACE = "http://xmlns.com/foaf/0.1/";
  public static final String CONTACT_NAMESPACE = "http://www.w3.org/2000/10/swap/pim/contact#";
}
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
package org.gedcomx.rt;

import javax.xml.bind.annotation.XmlTransient;

/**
 * @author Ryan Heaton
 */
@XmlTransient
@Namespaces ( {
  @Namespace (
    id = "gx",
    uri = CommonNamespaces.GEDCOMX_COMMON_NAMESPACE,
    label = "Common Namespace",
    description = "The common namespace defines the types that are common to each model.",
    version = "v1",
    xmlMediaType = CommonNamespaces.GEDCOMX_COMMON_XML_MEDIA_TYPE,
    jsonMediaType = CommonNamespaces.GEDCOMX_COMMON_JSON_MEDIA_TYPE,
    definesRDFSchema = true
  ),
  @Namespace (
    id = "rdf",
    uri = CommonNamespaces.RDF_NAMESPACE,
    label = "RDF Namespace",
    description = "The RDF namespace defines the model used to represent metadata in RDF format.",
    version = "1999-02-22",
    xmlMediaType = CommonNamespaces.RDF_XML_MEDIA_TYPE,
    jsonMediaType = CommonNamespaces.RDF_JSON_MEDIA_TYPE,
    definesRDFSchema = true
  ),
  @Namespace (
    id = "dcterms",
    uri = CommonNamespaces.DUBLIN_CORE_NAMESPACE,
    label = "Dublin Core Terms Namespace",
    description = "The Dublin Core Terms namespace defines the model used to represent metadata using Dublin Core Terms.",
    version = "2010-10-11",
    definesRDFSchema = true
  ),
  @Namespace (
    id = "dctypes",
    uri = CommonNamespaces.DUBLIN_CORE_TYPE_NAMESPACE,
    label = "Dublin Core Types Namespace",
    description = "The Dublin Core Types namespace defines the types of Dublin Core metadata.",
    version = "2010-10-11",
    definesRDFSchema = true
  ),
  @Namespace(
    id = "foaf",
    uri = CommonNamespaces.FOAF_NAMESPACE,
    label = "FOAF Namespace",
    description = "The FOAF namespace defines the model and types used to represent metadata about users, organizations, and projects.",
    version = "0.1",
    xmlMediaType = CommonNamespaces.RDF_XML_MEDIA_TYPE,
    jsonMediaType = CommonNamespaces.RDF_JSON_MEDIA_TYPE,
    definesRDFSchema = true
  ),
  @Namespace(
    id = "contact",
    uri = CommonNamespaces.CONTACT_NAMESPACE,
    label = "Contact Namespace",
    description = "The contact namespace defines the vocabulary for contact information, e.g. for users or organizations.",
    version = "2000-10",
    definesRDFSchema = true
  )
} )
public class CommonNamespaces {

  private CommonNamespaces() {}

  public static final String GEDCOMX_DOMAIN = "http://gedcomx.org";

  public static final String GEDCOMX_COMMON_NAMESPACE = "http://gedcomx.org/";
  public static final String GEDCOMX_COMMON_XML_MEDIA_TYPE = "application/x-gedcom+xml";
  public static final String GEDCOMX_COMMON_JSON_MEDIA_TYPE = "application/x-gedcom+json";

  public static final String RDF_NAMESPACE = "http://www.w3.org/1999/02/22-rdf-syntax-ns#";
  public static final String RDF_XML_MEDIA_TYPE = "application/rdf+xml";
  public static final String RDF_JSON_MEDIA_TYPE = "application/rdf+json";

  public static final String DUBLIN_CORE_NAMESPACE = "http://purl.org/dc/terms/";
  public static final String DUBLIN_CORE_TYPE_NAMESPACE = "http://purl.org/dc/dcmitype/";
  public static final String FOAF_NAMESPACE = "http://xmlns.com/foaf/0.1/";
  public static final String CONTACT_NAMESPACE = "http://www.w3.org/2000/10/swap/pim/contact#";
}
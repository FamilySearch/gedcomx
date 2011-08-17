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
package org.gedcomx.metadata;

import org.gedcomx.common.CommonNamespaces;
import org.gedcomx.rt.Namespace;
import org.gedcomx.rt.Namespaces;
import org.gedcomx.types.TypesNamespaces;

import javax.xml.bind.annotation.XmlTransient;

/**
 * @author Ryan Heaton
 */
@XmlTransient
@Namespaces ( {
  @Namespace (
    id = "rdf",
    uri = MetadataNamespaces.RDF_NAMESPACE,
    label = "RDF Namespace",
    description = "The RDF namespace defines the model used to represent metadata in RDF format.",
    version = "1999-02-22",
    xmlMediaType = MetadataNamespaces.RDF_XML_MEDIA_TYPE,
    jsonMediaType = MetadataNamespaces.RDF_JSON_MEDIA_TYPE
  ),
  @Namespace (
    id = "dcterms",
    uri = MetadataNamespaces.DUBLIN_CORE_NAMESPACE,
    label = "Dublin Core Terms Namespace",
    description = "The Dublin Core Terms namespace defines the model used to represent metadata using Dublin Core Terms.",
    version = "2010-10-11"
  ),
  @Namespace (
    id = "dctypes",
    uri = MetadataNamespaces.DUBLIN_CORE_TYPE_NAMESPACE,
    label = "Dublin Core Types Namespace",
    description = "The dublin core types namespace defines the types of Dublin Core metadata.",
    version = "2010-10-11"
  )
} )
public class MetadataNamespaces {

  private MetadataNamespaces() {}

  public static final String RDF_NAMESPACE = TypesNamespaces.RDF_NAMESPACE;
  public static final String RDF_XML_MEDIA_TYPE = "application/rdf+xml";
  public static final String RDF_JSON_MEDIA_TYPE = "application/rdf+json";
  public static final String DUBLIN_CORE_NAMESPACE = TypesNamespaces.DUBLIN_CORE_NAMESPACE;
  public static final String DUBLIN_CORE_TYPE_NAMESPACE = TypesNamespaces.DUBLIN_CORE_TYPE_NAMESPACE;

}

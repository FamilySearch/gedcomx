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

/**
 * The <b>metadata profile</b> models genealogical "data about data".
 *
 * @label Metadata Profile
 */
@Profile (
  label = "Metadata Profile",
  description = "The metadata profile supports genealogical metadata.",
  namespaces = {
    @Namespace (
      id = "rdf",
      uri = MetadataConstants.RDF_NAMESPACE,
      label = "RDF Namespace",
      description = "The rdf namespace contains the objects for RDF support.",
      version = "1999-02-22",
      xmlMediaType = MetadataConstants.RDF_MEDIA_TYPE,
      jsonMediaType = "application/rdf+json"
    ),
    @Namespace (
      id = "dcterms",
      uri = MetadataConstants.DUBLIN_CORE_NAMESPACE,
      label = "Dublin Core Terms Namespace",
      description = "The dublin core terms namespace contains the objects for support Dublin Core Terms.",
      version = "2010-10-11"
    ),
    @Namespace (
      id = "dctypes",
      uri = MetadataConstants.DUBLIN_CORE_TYPE_NAMESPACE,
      label = "Dublin Core Types Namespace",
      description = "The dublin core types namespace contains the Dublin Core types.",
      version = "2010-10-11"
    )
  }
)
package org.gedcomx.metadata;
//todo: document how we're going to extend metadata in the future

import org.gedcomx.rt.Namespace;
import org.gedcomx.rt.Profile;
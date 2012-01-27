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
package org.gedcomx.opensearch;

import org.gedcomx.rt.Model;
import org.gedcomx.rt.Models;

import javax.xml.bind.annotation.XmlTransient;

/**
 * @author Ryan Heaton
 */
@XmlTransient
@Models ( {
  @Model (
    id = "opensearch",
    namespace = OpenSearchModel.OPENSEARCH_NAMESPACE,
    label = "OpenSearch Model",
    description = "The opensearch model defines elements and types used for searches.",
    version = "1.1",
    xmlMediaType = OpenSearchModel.OPENSEARCH_XML_MEDIA_TYPE,
    jsonMediaType = OpenSearchModel.OPENSEARCH_GEDCOMX_JSON_MEDIA_TYPE
  ),
  @Model (
    id = "relevance",
    namespace = OpenSearchModel.OPENSEARCH_RELEVANCE_NAMESPACE,
    label = "OpenSearch Relevance Model",
    description = "The opensearch relevance model defines elements and types used for indicating the relevance of a search.",
    version = "1.0"
  )
} )
public class OpenSearchModel {

  private OpenSearchModel() {}

  public static final String OPENSEARCH_NAMESPACE = "http://a9.com/-/spec/opensearch/1.1/";
  public static final String OPENSEARCH_XML_MEDIA_TYPE = "application/opensearchdescription+xml";
  public static final String OPENSEARCH_GEDCOMX_JSON_MEDIA_TYPE = "application/x-gedcomx-opensearchdescription+json";

  public static final String OPENSEARCH_RELEVANCE_NAMESPACE = "http://a9.com/-/opensearch/extensions/relevance/1.0/";
}

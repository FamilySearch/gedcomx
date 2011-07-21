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
package org.gedcomx.source;

import org.gedcomx.rt.Namespace;
import org.gedcomx.rt.Namespaces;

import javax.xml.bind.annotation.XmlTransient;

/**
 * @author Ryan Heaton
 */
@XmlTransient
@Namespaces ( {
  @Namespace (
    id = "gxs",
    uri = SourceNamespaces.GEDCOMX_SOURCE_NAMESPACE,
    label = "Source Namespace",
    description = "The source namespace contains the objects necessary for modeling sources.",
    version = "v1",
    xmlMediaType = SourceNamespaces.GEDCOMX_SOURCE_XML_MEDIA_TYPE,
    jsonMediaType = SourceNamespaces.GEDCOMX_SOURCE_JSON_MEDIA_TYPE
  )
} )
public class SourceNamespaces {

  private SourceNamespaces() {}

  public static final String GEDCOMX_SOURCE_NAMESPACE = "http://gedcomx.org/source/v1";
  public static final String GEDCOMX_SOURCE_XML_MEDIA_TYPE = "application/gedcomx-source-v1+xml";
  public static final String GEDCOMX_SOURCE_JSON_MEDIA_TYPE = "application/gedcomx-source-v1+json";
}

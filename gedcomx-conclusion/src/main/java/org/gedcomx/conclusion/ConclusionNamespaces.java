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
package org.gedcomx.conclusion;

import org.gedcomx.rt.Namespace;
import org.gedcomx.rt.Namespaces;

import javax.xml.bind.annotation.XmlTransient;

/**
 * Definition of the GEDCOM X conclusion namespaces.
 *
 * @author Ryan Heaton
 */
@XmlTransient
@Namespaces ( {
  @Namespace (
    id = "gxc",
    uri = ConclusionNamespaces.GEDCOMX_CONCLUSION_NAMESPACE,
    label = "Conclusion Namespace",
    description = "The conclusion namespace contains the objects necessary for modeling genealogical conclusion data.",
    version = "v1",
    xmlMediaType = ConclusionNamespaces.GEDCOMX_CONCLUSION_XML_MEDIA_TYPE,
    jsonMediaType = ConclusionNamespaces.GEDCOMX_CONCLUSION_JSON_MEDIA_TYPE
  )
} )
public class ConclusionNamespaces {

  private ConclusionNamespaces() {}

  public static final String GEDCOMX_CONCLUSION_NAMESPACE = "http://gedcomx.org/conclusion/v1/";
  public static final String GEDCOMX_CONCLUSION_XML_MEDIA_TYPE = "application/x-gedcom-conclusion-v1+xml";
  public static final String GEDCOMX_CONCLUSION_JSON_MEDIA_TYPE = "application/x-gedcom-conclusion-v1+json";

}
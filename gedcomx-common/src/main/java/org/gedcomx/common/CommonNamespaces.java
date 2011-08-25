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
package org.gedcomx.common;

import org.gedcomx.rt.Namespace;
import org.gedcomx.rt.Namespaces;

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
    description = "The common namespace contains the objects that are common to all profiles and namespaces.",
    version = "v1",
    xmlMediaType = CommonNamespaces.GEDCOMX_COMMON_XML_MEDIA_TYPE,
    jsonMediaType = CommonNamespaces.GEDCOMX_COMMON_JSON_MEDIA_TYPE
  )
} )
public class CommonNamespaces {

  private CommonNamespaces() {}

  public static final String GEDCOMX_COMMON_NAMESPACE = "http://gedcomx.org/v1/";
  public static final String GEDCOMX_COMMON_XML_MEDIA_TYPE = "application/x-gedcom-v1+xml";
  public static final String GEDCOMX_COMMON_JSON_MEDIA_TYPE = "application/x-gedcom-v1+json";

}
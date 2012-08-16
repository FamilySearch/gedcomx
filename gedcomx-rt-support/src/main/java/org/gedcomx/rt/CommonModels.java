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
    namespace = CommonModels.GEDCOMX_NAMESPACE,
    projectId = CommonModels.GEDCOMX_PROJECT_ID,
    label = "GEDCOM X Model",
    description = "The core model for all GEDCOM X data types and elements.",
    version = "v1",
    xmlMediaType = CommonModels.GEDCOMX_XML_MEDIA_TYPE,
    jsonMediaType = CommonModels.GEDCOMX_JSON_MEDIA_TYPE
  ),
  @Model (
    id = "types",
    namespace = CommonModels.GEDCOMX_TYPES_NAMESPACE,
    projectId = CommonModels.GEDCOMX_PROJECT_ID,
    label = "GEDCOM X Types",
    description = "The types model contains all of the types and constrained vocabulary for GEDCOM X data.",
    version = "v1"
  )
} )
public class CommonModels {

  private CommonModels() {}

  public static final String GEDCOMX_DOMAIN = "http://gedcomx.org/";
  public static final String GEDCOMX_PROJECT_ID = "gedcomx";

  public static final String GEDCOMX_TYPES_NAMESPACE = "http://gedcomx.org/"; //the constrained vocabulary isn't versioned.
  public static final String GEDCOMX_NAMESPACE = "http://gedcomx.org/v1/";
  public static final String GEDCOMX_XML_MEDIA_TYPE = "application/x-gedcom-v1+xml";
  public static final String GEDCOMX_JSON_MEDIA_TYPE = "application/x-gedcom-v1+json";
}
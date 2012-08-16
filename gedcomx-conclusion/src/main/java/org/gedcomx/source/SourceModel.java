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
package org.gedcomx.source;

import org.gedcomx.rt.CommonModels;
import org.gedcomx.rt.Model;
import org.gedcomx.rt.Models;

import javax.xml.bind.annotation.XmlTransient;


/**
 * @author Ryan Heaton
 */
@XmlTransient
@Models ( {
  @Model (
    id = "gxs",
    projectId = CommonModels.GEDCOMX_PROJECT_ID,
    namespace = SourceModel.GEDCOMX_SOURCE_V1_NAMESPACE,
    label = "Source Metadata Model",
    description = "The Source Metadata model defines the types and elements used to represent metadata about sources.",
    version = "v1",
    xmlMediaType = SourceModel.GEDCOMX_SOURCE_V1_XML_MEDIA_TYPE,
    jsonMediaType = SourceModel.GEDCOMX_SOURCE_V1_JSON_MEDIA_TYPE
  )
} )
public class SourceModel {

  private SourceModel() {}

  public static final String GEDCOMX_SOURCE_V1_NAMESPACE = "http://gedcomx.org/source/v1/";
  public static final String GEDCOMX_SOURCE_V1_XML_MEDIA_TYPE = "application/x-gedcom-source-v1+xml";
  public static final String GEDCOMX_SOURCE_V1_JSON_MEDIA_TYPE = "application/x-gedcom-source-v1+json";
}
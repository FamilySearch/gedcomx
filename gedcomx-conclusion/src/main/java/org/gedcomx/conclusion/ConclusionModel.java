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

import org.gedcomx.rt.CommonModels;
import org.gedcomx.rt.Model;
import org.gedcomx.rt.Models;

import javax.xml.bind.annotation.XmlTransient;

/**
 * Definition of the GEDCOM X conclusion model.
 *
 * @author Ryan Heaton
 */
@XmlTransient
@Models ( {
  @Model (
    id = "gxc",
    projectId = CommonModels.GEDCOMX_PROJECT_ID,
    namespace = ConclusionModel.GEDCOMX_CONCLUSION_V1_NAMESPACE,
    label = "Conclusion Model",
    description = "The conclusion model defines the types and elements of genealogical conclusion data.",
    version = "v1",
    xmlMediaType = ConclusionModel.GEDCOMX_CONCLUSION_V1_XML_MEDIA_TYPE,
    jsonMediaType = ConclusionModel.GEDCOMX_CONCLUSION_V1_JSON_MEDIA_TYPE,
    definesRDFSchema = true
  )
} )
public class ConclusionModel {

  private ConclusionModel() {}

  public static final String GEDCOMX_CONCLUSION_V1_NAMESPACE = "http://gedcomx.org/conclusion/v1/";
  public static final String GEDCOMX_CONCLUSION_V1_XML_MEDIA_TYPE = "application/x-gedcom-conclusion-v1+xml";
  public static final String GEDCOMX_CONCLUSION_V1_JSON_MEDIA_TYPE = "application/x-gedcom-conclusion-v1+json";

}
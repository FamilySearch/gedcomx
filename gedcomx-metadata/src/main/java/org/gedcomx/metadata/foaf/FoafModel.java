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
package org.gedcomx.metadata.foaf;

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
    id = "foaf",
    projectId = CommonModels.GEDCOMX_PROJECT_ID,
    namespace = FoafModel.FOAF_NAMESPACE,
    label = "FOAF Model",
    description = "The FOAF model defines the types and elements used to represent metadata about users, organizations, and projects.",
    version = "0.1",
    xmlMediaType = CommonModels.RDF_XML_MEDIA_TYPE,
    jsonMediaType = CommonModels.RDF_JSON_MEDIA_TYPE,
    definesRDFSchema = true
  ),
  @Model (
    id = "contact",
    projectId = CommonModels.GEDCOMX_PROJECT_ID,
    namespace = FoafModel.CONTACT_NAMESPACE,
    label = "Contact Model",
    description = "The contact model defines the vocabulary for contact information, e.g. for users or organizations.",
    version = "2000-10",
    definesRDFSchema = true
  )
} )
public class FoafModel {

  private FoafModel() {}

  public static final String FOAF_NAMESPACE = "http://xmlns.com/foaf/0.1/";
  public static final String CONTACT_NAMESPACE = "http://www.w3.org/2000/10/swap/pim/contact#";
}
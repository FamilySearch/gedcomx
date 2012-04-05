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
package org.gedcomx.metadata.dc;

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
    id = "dc",
    projectId = CommonModels.GEDCOMX_PROJECT_ID,
    namespace = CommonModels.DUBLIN_CORE_NAMESPACE,
    label = "Dublin Core Terms Model",
    description = "The Dublin Core Terms model defines metadata using Dublin Core Terms.",
    version = "2010-10-11",
    definesRDFSchema = true,
    objectFactory = ObjectFactory.class
  )
} )
public class DublinCoreModel {

  private DublinCoreModel() {}

}
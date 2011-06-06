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
 * <p>The <b>attribution profile</b> models the objects necessary to support attribution metadata for genealogical data. Attribution
 * metadata intends to answer the "who, why, when" questions about genealogical data.</p>
 */
@XmlSchema(
  namespace = AttributionConstants.GEDCOMX_ATTRIBUTION_NAMESPACE,
  elementFormDefault = XmlNsForm.QUALIFIED
)
@XmlAccessorOrder ( XmlAccessOrder.ALPHABETICAL )
@Profile (
  label = "Attribution Profile",
  description = "The attribution profile supports attribution metadata for genealogical data. Attribution metadata intends to answer the \"who, why, when\" questions about genealogical data.",
  namespaces = {
    @Namespace (
      id = "gxa",
      uri = AttributionConstants.GEDCOMX_ATTRIBUTION_NAMESPACE,
      label = "Attribution Namespace",
      description = "The attribution namespace contains the objects necessary for modeling attribution metadata.",
      version = "v1"
    )
  }
)
package org.gedcomx.attribution;
//todo: model attribution, contributor, contribution(?)

import org.gedcomx.rt.Namespace;
import org.gedcomx.rt.Profile;

import javax.xml.bind.annotation.*;

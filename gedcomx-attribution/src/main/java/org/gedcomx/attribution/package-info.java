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
 * <h1>GEDCOM X Attribution</h1>
 *
 * <p>The <b>attribution profile</b> models the objects necessary to support attribution metadata for genealogical data. Attribution
 * metadata intends to answer the "who, why, when" questions about genealogical data.</p>
 */
@XmlSchema(
  namespace = AttributionConstants.GEDCOMX_ATTRIBUTION_NAMESPACE,
  elementFormDefault = XmlNsForm.QUALIFIED,
  xmlns = {
    @XmlNs( prefix = "gxa", namespaceURI = AttributionConstants.GEDCOMX_ATTRIBUTION_NAMESPACE),
    @XmlNs( prefix = "xlink", namespaceURI = "http://www.w3.org/1999/xlink")
  }
)
@XmlAccessorOrder ( XmlAccessOrder.ALPHABETICAL )
package org.gedcomx.attribution;
//todo: model attribution, contributor, contribution(?)

import javax.xml.bind.annotation.*;

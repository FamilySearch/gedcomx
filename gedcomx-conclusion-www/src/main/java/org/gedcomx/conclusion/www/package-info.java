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
 * The <b>conclusion-www</b> profile models the necessary extensions to the conclusion model to support
 * providing conclusion data via the World Wide Web.
 */
@XmlSchema(
  namespace = ConclusionWWWConstants.GEDCOMX_CONCLUSION_WWW_NAMESPACE,
  elementFormDefault = XmlNsForm.QUALIFIED,
  xmlns = {
    @XmlNs ( prefix = AttributionConstants.GEDCOMX_ATTRIBUTION_NAMESPACE_PREFIX, namespaceURI = AttributionConstants.GEDCOMX_ATTRIBUTION_NAMESPACE),
    @XmlNs ( prefix = SourceConstants.GEDCOMX_SOURCE_NAMESPACE_PREFIX, namespaceURI = SourceConstants.GEDCOMX_SOURCE_NAMESPACE),
    @XmlNs ( prefix = IdConstants.GEDCOMX_ID_NAMESPACE_PREFIX, namespaceURI = IdConstants.GEDCOMX_ID_NAMESPACE),
    @XmlNs ( prefix = TypeConstants.GEDCOMX_TYPES_NAMESPACE_PREFIX, namespaceURI = TypeConstants.GEDCOMX_TYPES_NAMESPACE),
    @XmlNs ( prefix = SourceWWWConstants.GEDCOMX_SOURCE_WWW_NAMESPACE_PREFIX, namespaceURI = SourceWWWConstants.GEDCOMX_SOURCE_WWW_NAMESPACE),
    @XmlNs ( prefix = WebConstants.GEDCOMX_WWW_NAMESPACE_PREFIX, namespaceURI = WebConstants.GEDCOMX_WWW_NAMESPACE),
    @XmlNs ( prefix = "", namespaceURI = ConclusionConstants.GEDCOMX_CONCLUSION_NAMESPACE),
    @XmlNs ( prefix = ConclusionWWWConstants.GEDCOMX_CONCLUSION_WWW_NAMESPACE_PREFIX, namespaceURI = ConclusionWWWConstants.GEDCOMX_CONCLUSION_WWW_NAMESPACE),
    @XmlNs ( prefix = "xlink", namespaceURI = "http://www.w3.org/1999/xlink")
  }
)
@XmlAccessorOrder ( XmlAccessOrder.ALPHABETICAL )
package org.gedcomx.conclusion.www;

import org.gedcomx.attribution.AttributionConstants;
import org.gedcomx.conclusion.ConclusionConstants;
import org.gedcomx.id.IdConstants;
import org.gedcomx.source.SourceConstants;
import org.gedcomx.source.www.SourceWWWConstants;
import org.gedcomx.types.TypeConstants;
import org.gedcomx.www.WebConstants;

import javax.xml.bind.annotation.*;

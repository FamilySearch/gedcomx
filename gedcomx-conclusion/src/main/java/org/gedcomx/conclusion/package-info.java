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
 * The <b>conclusion profile</b> models genealogical conclusion data.
 *
 * @label Conclusion Profile
 */
@XmlSchema(
  namespace = ConclusionConstants.GEDCOMX_CONCLUSION_NAMESPACE,
  elementFormDefault = XmlNsForm.QUALIFIED
)
@XmlAccessorOrder ( XmlAccessOrder.ALPHABETICAL )
@Profile (
  label = "Conclusion Profile",
  description = "The conclusion profile supports genealogical conclusion data.",
  namespaces = {
    @Namespace (
      id = "gxc",
      uri = ConclusionConstants.GEDCOMX_CONCLUSION_NAMESPACE,
      label = "Conclusion Namespace",
      description = "The conclusion namespace contains the objects necessary for modeling genealogical conclusion data.",
      version = "v1",
      xmlMediaType = "application/gedcomx-conclusion-v1+xml",
      jsonMediaType = "application/gedcomx-conclusion-v1+json"
    )
  }
)
package org.gedcomx.conclusion;

import org.gedcomx.rt.Namespace;
import org.gedcomx.rt.Profile;

import javax.xml.bind.annotation.XmlAccessOrder;
import javax.xml.bind.annotation.XmlAccessorOrder;
import javax.xml.bind.annotation.XmlNsForm;
import javax.xml.bind.annotation.XmlSchema;

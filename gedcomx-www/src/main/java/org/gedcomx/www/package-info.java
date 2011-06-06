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
 * The <b>www profile</b> models the necessary extensions to provide genealogical data via the World Wide Web.
 *
 * @label WWW Profile
 */
@XmlSchema (
  namespace = WebConstants.GEDCOMX_WWW_NAMESPACE,
  elementFormDefault = XmlNsForm.QUALIFIED
)
@XmlAccessorOrder ( XmlAccessOrder.ALPHABETICAL )
@Profile (
  label = "WWW Profile",
  description = "The www profile supports exposing genealogical data to the World Wide Web.",
  namespaces = {
    @Namespace (
      id = "gxwww",
      uri = WebConstants.GEDCOMX_WWW_NAMESPACE,
      label = "WWW Namespace",
      description = "The www namespace contains the objects necessary exposing genealogical data to the World Wide Web.",
      version = "v1"
    )
  }
)
package org.gedcomx.www;

import org.gedcomx.rt.Namespace;
import org.gedcomx.rt.Profile;

import javax.xml.bind.annotation.XmlAccessOrder;
import javax.xml.bind.annotation.XmlAccessorOrder;
import javax.xml.bind.annotation.XmlNsForm;
import javax.xml.bind.annotation.XmlSchema;
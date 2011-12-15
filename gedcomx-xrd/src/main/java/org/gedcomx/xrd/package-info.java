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
 * The XRD model according to the OASIS XRD standard specification.
 *
 * See http://docs.oasis-open.org/xri/xrd/v1.0/xrd-1.0.html
 *
 * @author Mike Gardiner, Ryan Heaton
 */

@XmlSchema (
  namespace = XRDModel.XRD_V1_NAMESPACE,
  elementFormDefault = XmlNsForm.QUALIFIED
)
package org.gedcomx.xrd;

import javax.xml.bind.annotation.XmlNsForm;
import javax.xml.bind.annotation.XmlSchema;
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

/**
 * The types model defines the standard set of types of genealogical data.
 */
@XmlSchema(
  namespace = CommonModels.GEDCOMX_TYPES_NAMESPACE,
  attributeFormDefault = XmlNsForm.QUALIFIED,
  elementFormDefault = XmlNsForm.QUALIFIED
)
package org.gedcomx.types;

//todo: figure out all the valid types
import org.gedcomx.rt.CommonModels;

import javax.xml.bind.annotation.XmlNsForm;
import javax.xml.bind.annotation.XmlSchema;
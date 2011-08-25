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
 * The Dublin Core metadata model.
 *
 * @see <a href="http://dublincore.org/">Dublin Core Metadata Initiative</a>
 */
@XmlSchema(
  namespace = TypesNamespaces.DUBLIN_CORE_NAMESPACE,
  elementFormDefault = XmlNsForm.QUALIFIED,
  attributeFormDefault = XmlNsForm.QUALIFIED
)
@XmlAccessorOrder( XmlAccessOrder.ALPHABETICAL )
package org.gedcomx.metadata.dc;

import org.gedcomx.types.TypesNamespaces;

import javax.xml.bind.annotation.XmlAccessOrder;
import javax.xml.bind.annotation.XmlAccessorOrder;
import javax.xml.bind.annotation.XmlNsForm;
import javax.xml.bind.annotation.XmlSchema;
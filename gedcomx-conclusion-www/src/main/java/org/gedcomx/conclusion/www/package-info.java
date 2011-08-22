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
 * The conclusion www modules defines the necessary extensions to the conclusion model to support
 * providing conclusion data via the World Wide Web.
 */
@XmlSchema(
  namespace = ConclusionWWWNamespaces.GEDCOMX_CONCLUSION_WWW_NAMESPACE,
  attributeFormDefault = XmlNsForm.QUALIFIED,
  elementFormDefault = XmlNsForm.QUALIFIED
)
@XmlAccessorOrder ( XmlAccessOrder.ALPHABETICAL )
@DefaultNamespace ( ConclusionNamespaces.GEDCOMX_CONCLUSION_NAMESPACE )
package org.gedcomx.conclusion.www;

import org.gedcomx.conclusion.ConclusionNamespaces;
import org.gedcomx.rt.DefaultNamespace;

import javax.xml.bind.annotation.XmlAccessOrder;
import javax.xml.bind.annotation.XmlAccessorOrder;
import javax.xml.bind.annotation.XmlNsForm;
import javax.xml.bind.annotation.XmlSchema;

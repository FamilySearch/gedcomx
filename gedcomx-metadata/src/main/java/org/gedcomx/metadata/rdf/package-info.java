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
 * The RDF-based metadata model.
 *
 * @see <a href="http://www.w3.org/TR/2004/REC-rdf-primer-20040210/">RDF Primer</a>
 */
@XmlSchema (
  namespace = CommonModels.RDF_NAMESPACE,
  elementFormDefault = XmlNsForm.QUALIFIED,
  attributeFormDefault = XmlNsForm.QUALIFIED
)
@XmlAccessorOrder ( XmlAccessOrder.ALPHABETICAL )
package org.gedcomx.metadata.rdf;
//todo: document how metadata refers to data and how metadata refers to other metadata.

import org.gedcomx.rt.CommonModels;

import javax.xml.bind.annotation.XmlAccessOrder;
import javax.xml.bind.annotation.XmlAccessorOrder;
import javax.xml.bind.annotation.XmlNsForm;
import javax.xml.bind.annotation.XmlSchema;
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
package org.gedcomx.attribution;

import org.gedcomx.rt.Namespace;
import org.gedcomx.rt.Namespaces;

import javax.xml.bind.annotation.XmlTransient;

/**
 * Definition of the attribution namespaces of the GEDCOM X standard.
 * 
 * @author Ryan Heaton
 */
@XmlTransient
@Namespaces ( {
  @Namespace (
    id = "gxa",
    uri = AttributionNamespaces.GEDCOMX_ATTRIBUTION_NAMESPACE,
    label = "Attribution Namespace",
    description = "The attribution namespace contains the objects necessary for modeling attribution metadata.",
    version = "v1"
  )
} )
public class AttributionNamespaces {

  private AttributionNamespaces() {}

  public static final String GEDCOMX_ATTRIBUTION_NAMESPACE = "http://gedcomx.org/attribution/v1";

}
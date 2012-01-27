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
package org.gedcomx.atom;

import org.gedcomx.rt.Model;
import org.gedcomx.rt.Models;

import javax.xml.bind.annotation.XmlTransient;

/**
 * @author Ryan Heaton
 */
@XmlTransient
@Models ( {
  @Model (
    id = "atom",
    namespace = AtomModel.ATOM_NAMESPACE,
    label = "Atom Model",
    description = "The Atom model supplied the types and elements defined by the Atom syndication format.",
    version = "2005",
    xmlMediaType = AtomModel.ATOM_XML_MEDIA_TYPE,
    jsonMediaType = AtomModel.ATOM_GEDCOMX_JSON_MEDIA_TYPE
  )
} )
public class AtomModel {

  private AtomModel() {}

  public static final String ATOM_NAMESPACE = "http://www.w3.org/2005/Atom";
  public static final String ATOM_XML_MEDIA_TYPE = "application/atom+xml";
  public static final String ATOM_GEDCOMX_JSON_MEDIA_TYPE = "application/x-gedcomx-atom+json";
}

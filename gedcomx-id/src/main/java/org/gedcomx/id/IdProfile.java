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
package org.gedcomx.id;

import org.gedcomx.rt.Namespace;
import org.gedcomx.rt.Profile;

import javax.xml.bind.annotation.XmlTransient;

/**
 * @author Ryan Heaton
 */
@XmlTransient
@Profile (
  label = "ID Profile",
  description = "The id profile supports the mechanisms for identifying genealogical entities.",
  namespaces = {
    @Namespace (
      id = "gxid",
      uri = IdProfile.GEDCOMX_ID_NAMESPACE,
      label = "ID Namespace",
      description = "The id namespace contains the objects necessary identifying genealogical entities.",
      version = "v1"
    )
  }
)
public class IdProfile {

  private IdProfile() {}

  public static final String GEDCOMX_ID_NAMESPACE = "http://gedcomx.org/id/v1";

}
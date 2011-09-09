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
package org.gedcomx.common;

/**
 * @author Ryan Heaton
 */
public interface Attributable {

  /**
   * Attribution metadata for a genealogical resource. Attribution data is necessary to support
   * a sound <a href="https://wiki.familysearch.org/en/Genealogical_Proof_Standard">genealogical proof statement</a>.
   *
   * @return Attribution metadata for a genealogical resource. Attribution data is necessary to support
   * a sound <a href="https://wiki.familysearch.org/en/Genealogical_Proof_Standard">genealogical proof statement</a>.
   */
  Attribution getAttribution();
}

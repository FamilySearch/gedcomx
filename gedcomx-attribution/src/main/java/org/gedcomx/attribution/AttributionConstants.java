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

import javax.xml.bind.annotation.XmlTransient;

/**
 * Static constants related to the attribution profile of the GEDCOM X standard.
 * 
 * @author Ryan Heaton
 */
@XmlTransient
public class AttributionConstants {

  private AttributionConstants() {}

  public static final String GEDCOMX_ATTRIBUTION_NAMESPACE = "http://gedcomx.org/attribution/v1";
  public static final String GEDCOMX_ATTRIBUTION_NAMESPACE_PREFIX = "gxa";

}
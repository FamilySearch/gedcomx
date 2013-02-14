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
package org.gedcomx.rt;

import javax.xml.bind.annotation.XmlTransient;

/**
 * @author Ryan Heaton
 */
@XmlTransient
public class GedcomxConstants {

  private GedcomxConstants() {}

  public static final String GEDCOMX_DOMAIN = "http://gedcomx.org/";
  public static final String GEDCOMX_PROJECT_ID = "gedcomx";

  public static final String GEDCOMX_TYPES_NAMESPACE = "http://gedcomx.org/"; //the constrained vocabulary isn't versioned.
  public static final String GEDCOMX_NAMESPACE = "http://gedcomx.org/v1/";
  public static final String GEDCOMX_XML_MEDIA_TYPE = "application/x-gedcomx-v1+xml";
  public static final String GEDCOMX_JSON_MEDIA_TYPE = "application/x-gedcomx-v1+json";
}
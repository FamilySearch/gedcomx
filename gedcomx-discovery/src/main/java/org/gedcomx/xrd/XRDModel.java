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
package org.gedcomx.xrd;

import org.gedcomx.rt.Model;
import org.gedcomx.rt.Models;

import javax.xml.bind.annotation.XmlTransient;
import java.lang.String;

/**
 * @author Ryan Heaton
 */
@XmlTransient
@Models ( {
  @Model (
    id = "xrd",
    namespace = XRDModel.XRD_V1_NAMESPACE,
    label = "XRD Model",
    description = "The XRD model is use to describe the model for resource discovery using XRD.",
    version = "v1",
    xmlMediaType = XRDModel.XRD_V1_XML_MEDIA_TYPE,
    jsonMediaType = XRDModel.XRD_V1_JSON_MEDIA_TYPE
  )
} )
public class XRDModel {

  private XRDModel() {}

  public static final java.lang.String XRD_V1_NAMESPACE = "http://docs.oasis-open.org/ns/xri/xrd-1.0";
  public static final java.lang.String XRD_V1_XML_MEDIA_TYPE = "application/xrd+xml";
  public static final String XRD_V1_JSON_MEDIA_TYPE = "application/xrd+json";
}

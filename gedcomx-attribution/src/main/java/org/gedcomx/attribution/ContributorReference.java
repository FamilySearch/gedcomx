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

import javax.xml.XMLConstants;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSchemaType;
import java.net.URI;

/**
 * A reference to a contributor.
 *
 * @author Ryan Heaton
 */
public final class ContributorReference {

  private URI href;

  /**
   * The link to the contributor.
   *
   * @return The link to the contributor.
   */
  @XmlAttribute (namespace="http://www.w3.org/1999/xlink")
  @XmlSchemaType (name = "anyURI", namespace = XMLConstants.W3C_XML_SCHEMA_NS_URI)
  public URI getHref() {
    return href;
  }

  /**
   * The link to the contributor.
   *
   * @param href The link to the contributor.
   */
  public void setHref(URI href) {
    this.href = href;
  }

}

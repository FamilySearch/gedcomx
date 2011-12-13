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

import javax.xml.XMLConstants;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import java.net.URI;


/**
 * The <Link> element serves as a container for metadata about a relation between
 * the resource described by the XRD and a related resource.
 *
 * See http://docs.oasis-open.org/xri/xrd/v1.0/xrd-1.0.html#element.link
 *
 * @author Mike Gardiner, Ryan Heaton
 */
@XmlType ( name = "Link" )
@SuppressWarnings({"rdf-incompatible-ns", "unqualified-attribute"})
public final class Link {

  private URI rel;
  protected URI href;

  @XmlAttribute
  @XmlSchemaType ( name = "anyURI", namespace = XMLConstants.W3C_XML_SCHEMA_NS_URI )
  public URI getRel() {
    return rel;
  }

  public void setRel(URI rel) {
    this.rel = rel;
  }

  @XmlAttribute
  @XmlSchemaType( name = "anyURI", namespace = XMLConstants.W3C_XML_SCHEMA_NS_URI )
  public URI getHref() {
    return href;
  }

  public void setHref(URI href) {
    this.href = href;
  }
}
